package com.quantum.tests;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.utils.moreActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.quantum.utils.DriverUtils.getAppiumDriver;
import static com.quantum.utils.DriverUtils.getDriver;

public class targetMain extends WebDriverTestCase {

    @Test(description="Search", groups={"target3","P1","Search"})
    public void targetSearch() {
        getDriver().get("http://www.target.com");
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchFor("coffee machine");
       // String results = getDriver().findElement("targetSearchResults").getText();
      //  System.out.println(" **"+results);
        moreActions.scrollPage(getDriver());
        getDriver().takeScreenShot();



    }




    private void searchFor(String value)
    {

        String bname = getDriver().getCapabilities().getBrowserName();
        if (bname.equals("MobileOS"))
       {
           moreActions.sleep(2000);
           getDriver().findElement("targetSearch").sendKeys(value);
           moreActions.sleep(500);
           getDriver().findElement(By.xpath("//*[text()='"+value+"']")).click();
       }
       else
       {
           getDriver().findElement("targetSearch").sendKeys(value);
           getDriver().findElement("targetGo").click();

        }

        getDriver().findElement("targetSearchResults");
        moreActions.sleep(5000);
    }



}
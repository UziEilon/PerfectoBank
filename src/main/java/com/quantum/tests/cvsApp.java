package com.quantum.tests;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.cvsUtils;
import com.quantum.utils.moreActions;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class cvsApp extends WebDriverTestCase {


    @Test(description="Search", groups={"cvs","P1","search"})
    public void cvsSearch() {


        //close feedback win
        moreActions.restartApp("com.cvs.cvspharmacy",getDriver());
        getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        int number = getDriver().findElements(By.xpath("//*[@label=\"We'd welcome your feedback!\"]")).size();
        if (number>0)
        {
            getDriver().findElement(By.xpath("//*[@label=\"No, thanks\"]")).click();
        }
        getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);


        cvsUtils.search(getDriver(),"Gillette");

        //verfay got results
        int numberOfitems = getDriver().findElements(By.xpath("//*[@label=\"Add to basket\"]")).size();
        System.out.println(numberOfitems);


    }



}
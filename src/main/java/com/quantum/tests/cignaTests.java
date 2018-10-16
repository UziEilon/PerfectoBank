package com.quantum.tests;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class cignaTests extends WebDriverTestCase {


    @Test(description = "search", groups = {"@Cigna", "@P1","@Search"})
    public void searchCigna() {


        getDriver().get("http://www.cigna.com");
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        getDriver().findElement(By.xpath("//*[@class=\"search-sm-xs\"]")).click();
        getDriver().findElementById("query").sendKeys("insurance");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
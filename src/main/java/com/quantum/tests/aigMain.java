package com.quantum.tests;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.utils.moreActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class aigMain extends WebDriverTestCase {

    @Test(description="Search", groups={"aig","P1","Search"})
    public void targetSearch() {
        getDriver().get("http://www.aig.com");
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().findElementByXPath("//*[text()='Insurance']").click();
        getDriver().get("http://www.aig.com/individual/insurance");
        moreActions.sleep(2000);
        moreActions.scrollPage(getDriver());
        moreActions.scrollPage(getDriver());
        getDriver().get("http://www.aig.com/individual/insurance/life");

        try {
            getDriver().findElement(By.id("btngrp1")).click();
            getDriver().findElementByXPath("//*[contains(text(),'Guaranteed acceptance')]").click();
        }catch (Exception e)
        {
            //nothing
        }

           moreActions.sleep(5000);
        getDriver().get("https://www.aig-lifeinsurance.com/a/?src=tz_aig_ref&afid=413600&TFN=ODAwLTQ2Mi05MTI3&cid=10009");

        getDriver().findElement(By.id("first-name")).sendKeys("Uzi");
        getDriver().findElement(By.id("last-name")).sendKeys("Eilon");
        getDriver().findElement(By.id("zip-code")).sendKeys("01803");
        moreActions.sleep(2000);

    }





}
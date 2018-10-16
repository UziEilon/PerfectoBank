package com.quantum.tests;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.utils.moreActions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class nativeApp extends WebDriverTestCase {

    @Test(description="login", groups={"calc"})
    public void login() {

         getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         getDriver().findElement(By.id("com.perfectomobile.calnew:id/user")).sendKeys("uzi");
        getDriver().findElement(By.id("com.perfectomobile.calnew:id/password")).sendKeys("aaa");
        getDriver().findElement(By.id("com.perfectomobile.calnew:id/loginBT")).click();
        String user  = getDriver().findElement(By.id("com.perfectomobile.calnew:id/username")).getText();
        System.out.println(user);
    }





}
package com.quantum.tests;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.utils.moreActions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class baiscTest extends WebDriverTestCase {


    @Test(description = "test", groups = {"exe"})
    public void searchCigna() {


        getDriver().get("http://www.google.com");
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        moreActions.isRotated(getDriver());



    }
}
package com.quantum.tests;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.utils.moreActions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class mango extends WebDriverTestCase {

    @Test(description="Search", groups={"mango"})
    public void MangoSearch() {
        getDriver().get("http://www.mango.com");
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//*[text()=\"Menu\"]")).click();
        getDriver().findElement(By.xpath("//*[text()=\"Menu\"]")).click();

    }


}
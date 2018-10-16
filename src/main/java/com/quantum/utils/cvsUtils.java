package com.quantum.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class cvsUtils {

    public static void search(RemoteWebDriver d, String element)
        {
            d.findElement(By.xpath("//*[@value=\"Search Products\"]")).sendKeys(element);
            d.findElement(By.xpath("//*[@label=\"Search\"]")).click();



        }
}

package com.quantum.tests;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.utils.moreActions;
import com.sun.jna.platform.win32.OaIdl;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PerfectoBank extends WebDriverTestCase {


    @Test(description="PerfectoBankCheckDeposit", groups={"perfectoBank","P1","search"})
    public void PerfectoBankCheckDeposit() {


        //close feedback win
        moreActions.restartApp("com.perfecto.PerfectoBank",getDriver());
        getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//*[@name=\"userFD\"]")).sendKeys("uzi");
        getDriver().findElement(By.xpath("//UIASecureTextField")).sendKeys("PassW00");

        try{
            getDriver().findElement(By.xpath("//*[@label=\"return\"]")).click();

        }catch (Exception e){
            //nothing
        }

        getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//*[@label=\"loginLBacc\"]")).click();
        getDriver().findElement(By.xpath("//*[@name=\"balanceFD\"]"));


        moreActions.startImageInjection("PRIVATE:check_demo.jpg","com.perfecto.PerfectoBank",getDriver());

        getDriver().findElement(By.xpath("//*[@label=\"Check Deposit\"]")).click();
        getDriver().findElement(By.xpath("//*[@label=\"Open Camera\"]")).click();

        try {
            getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//*[@label=\"OK\"]")).click();

        }catch (Exception e)
        {
            //nothing
        }
        getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        getDriver().findElement(By.xpath("//*[@label=\"Take Picture\"]")).click();
        getDriver().findElement(By.xpath("//*[@label=\"Use Photo\"]")).click();
        moreActions.stopImageInjection(getDriver());

        moreActions.sleep(3000);

        getDriver().findElement(By.xpath("//*[@label=\"Back\"]")).click();
//        getDriver().findElement(By.xpath("///*[@label=\"Logout\"]")).click();



    }

    @Test(dependsOnMethods={"transferMoneyMoreThenBalance"} ,description="transfer", groups={"perfectoBank","P1","search"})
    public void transferMoneyMoreThenBalance() {

        getDriver().findElement(By.xpath("//*[@label=\"Transfer by email\"]")).click();
        int currentBalance = Integer.parseInt(getDriver().findElement(By.xpath("//*[@name=\"currentBalance\"]")).getText());
        getDriver().findElement(By.xpath("//*[@value=\"Email\"]")).sendKeys("uzi@perfecto.com");
        currentBalance=currentBalance+1;
        setBalance(currentBalance);
        getDriver().findElement(By.xpath("//*[@label=\"OK\"]")).click();
        getDriver().findElement(By.xpath("//*[@label=\"You cannot transfer more than your balance\"]"));
        getDriver().findElement(By.xpath("(//*[@label=\"OK\"])[2]")).click();

        currentBalance=currentBalance-2;
       setBalance(currentBalance);

        getDriver().findElement(By.xpath("//*[@label=\"OK\"]")).click();
        getDriver().findElement(By.xpath(" //*[@label=\"Confirm\"]")).click();




    }

 private void setBalance(int amount)
 {
     String crStr = String.valueOf(amount);

     getDriver().findElement(By.xpath("//UIATextField[3]")).clear();
     getDriver().findElement(By.xpath("//UIATextField[3]")).sendKeys(crStr);
     try {
         getDriver().findElement(By.xpath("//*[@label=\"return\"]")).click();

     }
     catch (Exception e)
     {
         //nothing - dont need to close keyboard
     }
 }
}
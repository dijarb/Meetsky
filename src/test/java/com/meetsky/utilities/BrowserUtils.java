package com.meetsky.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        for (String windowHandle : windowHandles) {

            Driver.getDriver().switchTo().window(windowHandle);

            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }

    public static void waitForElementToDisplay(WebElement element){
        Driver.timeout(0,"s");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));

        Driver.timeout(10,"s");
    }
}

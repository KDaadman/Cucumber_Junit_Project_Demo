package com.litigiven.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/*
This class will be storing only the utility methods that cab be used across the project.
 */
public class BrowserUtils {

    /*
    This method will accept in (in seconds) and execute Thread.sleep() method for given duration
    Arg: int second
     */
    public static void sleep(int second){

        second *= 1000;

        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify( String expectedInUrl, String expectedInTitle){

        //Returns and stores all window handles in a Set.
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();
        for (String eachHandle : allWindowsHandles) {
            Driver.getDriver().switchTo().window(eachHandle);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    public static void verifyTitleContains(String expectedInTitle) {

        Assert.assertEquals(expectedInTitle,Driver.getDriver().getTitle());


    }

    /*
    This method accepts WebElement target
    and waits for that WebElement not to be displayed o the page
     */
    public static void waitForInvisibilityOf(WebElement target) {

        //Create the object of "WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accepts String title
    and waits for that contains certain given String value.
     */
    public static void waitForTitleContains(String title) {

        //Create the object of "WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions
        wait.until(ExpectedConditions.titleContains(title));
    }

}

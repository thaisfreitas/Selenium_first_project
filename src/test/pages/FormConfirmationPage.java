package test.pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by thais on 9/17/14.
 */
public class FormConfirmationPage {

    private WebDriver driver;


    public FormConfirmationPage(WebDriver driver) {
        this.driver = driver;
   }

    public boolean isDisplayingFormMessage(String message) {
        String actualMessage = driver.findElement(By.className("ss-custom-resp")).getText();
        return actualMessage.equals(message);
    }

    public boolean isDisplayingIncompleteFormMessage(String message) {
        String actualMessage = driver.findElement(By.className("ss-required-asterisk")).getText();
        return actualMessage.equals(message);
    }

}

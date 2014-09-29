package test;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.model.FormDetails;
import test.pages.FormConfirmationPage;
import test.pages.FormPage;


/**
 * Created by thais on 9/17/14.
 */
public class FormTest {

    private static FirefoxDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void tearDown()throws Exception {
        driver.close();
    }


    @Test
    public void shouldBeAbleToFillCorrectForm(){
        FormDetails formDetails = FormDetails.validInfos();
        new FormPage(driver).open()
                .fillDetails(formDetails)
                .clickSubmit();
        Assert.assertTrue(new FormConfirmationPage(driver).isDisplayingFormMessage("Thank you for playing with Watir-WebDriver"));
    }

    @Test
    public void shouldBeAbleToFillIncorrectForm(){
      FormDetails invalidDetails = FormDetails.incompleteInfo();
      new FormPage(driver).open()
              .fillDetails(invalidDetails)
              .clickSubmit();
      Assert.assertTrue(new FormConfirmationPage(driver).isDisplayingIncompleteFormMessage("* Required"));
    }
}

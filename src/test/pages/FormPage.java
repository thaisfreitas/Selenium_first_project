package test.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import test.model.FormDetails;

public class FormPage {

    private WebDriver driver;
    String baseURL = "https://spreadsheets.google.com/spreadsheet/viewform?formkey=dGtlWGJjbWhuSlAyMHhLdXc2eE0wX2c6MQ";

    public FormPage(WebDriver driver){
        this.driver = driver;
    }

    public FormPage open(){
        driver.get(baseURL);
        return this;
    }

    public FormPage fillDetails(FormDetails formDetails) {
        fill("entry_0", formDetails.getName());
        fill("entry_1", formDetails.getLanguage());
        fill("group_2_1", formDetails.getWhatIsRuby());
        fill("group_3_1", formDetails.getVersionsRuby());
        return this;

    }

    public void fill(String id, String value){
        WebElement field = driver.findElement(By.id(id));
        field.sendKeys(value);
    }

    public FormConfirmationPage clickSubmit() {
        driver.findElement(By.name("submit")).click();
        return new FormConfirmationPage(driver);
    }

}

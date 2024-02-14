package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Example {
    private WebDriver driver;

    public Example(WebDriver driver) {
        this.driver = driver;
    }

    // Page Repository
    private By firstNameField = By.id("billing_first_name");
    private By lastNameField = By.id("billing_last_name");
    private By streetField = By.id("billing_address_1");
    private By postCodeField = By.id("billing_postcode");
    private By cityField = By.id("billing_city");
    private By phoneField = By.id("billing_phone");
    private By emailField = By.id("billing_email");


    // Page Actions
    public void setFirstNameField(String newValue) {
        changeField(driver.findElement(this.firstNameField), newValue);
    }

    public void setLastNameField(String newValue) {
        changeField(driver.findElement(this.lastNameField), newValue);
    }

    public void setStreetField(String newValue) {
        changeField(driver.findElement(this.streetField), newValue);
    }

    public void setPostCodeField(String newValue) {
        changeField(driver.findElement(this.postCodeField), newValue);
    }

    public void setCityField(String newValue) {
        changeField(driver.findElement(this.cityField), newValue);
    }

    public void setPhoneField(String newValue) {
        changeField(driver.findElement(this.phoneField), newValue);
    }

    public void setEmailField(String newValue) {
        changeField(driver.findElement(this.emailField), newValue);
    }

    private void changeField(WebElement element, String newValue) {
        element.clear();
        element.sendKeys(newValue);
    }
}

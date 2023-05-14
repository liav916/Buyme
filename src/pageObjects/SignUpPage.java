package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    By firstNameField = By.cssSelector("input[placeholder='שם פרטי']");
    By emailField = By.cssSelector("input[placeholder='מייל']");
    By passwordField = By.cssSelector("input[placeholder='סיסמה']");
    By passwordVerifyField = By.cssSelector("input[placeholder='אימות סיסמה']");
    By privacyPolicyCheckBox = By.cssSelector("circle[class='fill']");
    By submitButton = By.cssSelector("Button[type='submit']");
    By loginConfrim = By.cssSelector("span[class='ember-view dropdown solid']");
    By registrionButton = By.cssSelector("span.text-link.theme");


    public SignUpPage writeInNameField(String firstName) {

        sendKeys(firstNameField, firstName);
        return this;
    }

    public SignUpPage writeInEmailField(String email) {
        sendKeys(emailField, email);
        return this;
    }

    public SignUpPage writeInPasswordField(String password) {
        sendKeys(passwordField, password);
        return this;
    }

    public SignUpPage writeInPasswordVerifyField(String passwordVerify) {
        sendKeys(passwordVerifyField, passwordVerify);
        return this;
    }

    public SignUpPage clickOnprivacyPolicyCheckBox() {
        click(privacyPolicyCheckBox);
        return this;
    }

    public SignUpPage clickOnSubmit() throws InterruptedException {
        click(submitButton);
        Thread.sleep(10000);
        return this;
    }

    public SignUpPage clickOnRegistrationButton() {

        click(registrionButton);
        return this;
    }


    public void asserSignUp(String expectedResult, String actualResult) {
        WebElement element = driver.findElement(loginConfrim);
        try {
            Assert.assertEquals(expectedResult, actualResult);
        } catch (Exception e) {
        }


    }
}



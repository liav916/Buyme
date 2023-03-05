package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signUpPage extends basePage {

    public signUpPage (WebDriver driver){
        super(driver);
    }

    By signUpButton = By.cssSelector("notSigned[andiallelmwithtext=14]");
    By closeButton = By.id("times");
    By registrionButton = By.cssSelector("register-or-login[class=text-link theme]");
    By facebookButton = By.className("social-btn facebook");
    By GoogleButton = By.className("social-btn google");
    By emailField = By.id("ember1839");
    By passwordField = By.id("ember1846");
    By checkBoxButton = By.className("fill");
    By forgetMyPasswordButton = By.className("bm-body-2 text-link theme db");
    By submitButton = By.cssSelector("button[type=submit]");
    By accessibilityButton = By.id("ybihi");


    public signUpPage clickOnSignUpButton() {
        click(signUpButton);
        return this;
    }

    public signUpPage clickOnCloseButton() {
        click(closeButton);
        return this;
    }

    public signUpPage clickOnregistrionButton() {
        click(registrionButton);
        return this;
    }

    public signUpPage ClickOnFacebookButton() {
        click(facebookButton);
        return this;
    }

    public signUpPage ClickOnGoogleButton() {
        click(GoogleButton);
        return this;
    }

    public signUpPage writeInEmailField(String text) {
        sendKeys(emailField, text);
        return this;
    }

    public signUpPage writeInPasswordField(String text) {
        sendKeys(passwordField, text);
        return this;
    }

    public signUpPage clickOnChecBbox() {
        if (!checkBoxIsSelected(checkBoxButton))
            click(checkBoxButton);
        return this;
    }

    public signUpPage clickOnForgetPassword() {
        click(forgetMyPasswordButton);
        return this;
    }

    public signUpPage clickOnSubmit() {
        click(submitButton);
        return this;
    }

    public signUpPage clickOnaccessibilityButton() {
        click(accessibilityButton);
        return this;
    }


}




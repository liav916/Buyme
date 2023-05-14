package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver){
        super(driver);
    }

    By registrionButton = By.cssSelector("span.text-link.theme");
    By emailField = By.cssSelector("input[data-parsley-type='email']");
    By passwordField = By.cssSelector("input[placeholder='סיסמה']");




    public LoginPage clickOnRegistrationButton() {
        click(registrionButton);
        return this;}

    public LoginPage writeInEmailField (String email) {
        Waitviseblity(emailField);sendKeys(emailField, email);
        return this;
    }

    public LoginPage writeInPasswordField(String password) {
        sendKeys(passwordField, password);
        return this;
    }
}




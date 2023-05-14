package Flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PresentPage;
import pageObjects.SignUpPage;
import tests.BaseTest;



public class Flows {
    By ad = By.cssSelector("svg.inner-element");
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signuppage;
   BaseTest baseTest;
   PresentPage presentPage;

    public Flows(WebDriver driver){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signuppage = new SignUpPage(driver);
       baseTest = new BaseTest();
      presentPage = new PresentPage(driver);
    }

    public void chooseanoption() throws Exception {
        homePage.closepopup(ad);
        homePage.selectPriceDropDownOption();
        homePage.closepopup(ad);
        homePage.selectAreaDropDownOption();
        homePage.closepopup(ad);
        homePage.selectCategoryDropDownOption();
        homePage.clickOnSearch();
    }
    public void logintouser() throws Exception {
        homePage.clickOnSignUpButton();
        loginPage.writeInEmailField(BaseTest.readFromFile("email", BaseTest.getPathXml()));
        loginPage.writeInPasswordField(BaseTest.readFromFile("password", BaseTest.getPathXml()));
        signuppage.clickOnSubmit();}

        public void whoToSendPageFlow () throws InterruptedException {
        presentPage.clickOnSomeOneElseButton();
        presentPage.writeInPresentReciverField("עמית");
        presentPage.selecttypeOfPartyDropdown();
        presentPage.writeaBlessing("be safe");
        presentPage.uploadPhoto();

        }

    }
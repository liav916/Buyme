package tests;

import org.openqa.selenium.WebDriver;
import pageObjects.basePage;
import pageObjects.loginPage;
import pageObjects.signUpPage;


public class BaseTest {
    //1.declaration for all page objects except base
     public static WebDriver driver = null;
     static SignUpTest signUpTest;
     static LoginTest loginTest;
     static basePage basePage;
     static loginPage loginPage;
     static signUpPage signUpPage;

     int a =5;



    //2.@before class - init to browser, driver and report
    //3.read from file

    //4.@after class - close driver and report

}

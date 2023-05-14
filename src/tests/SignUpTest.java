package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUpTest extends BaseTest {


    //@before - open the user - driver.get()




    //@test -- all tests
    @Test
    public void test01_A_RegistrationScreen() throws Exception {
        MyTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()); // gives the test headline based on test name
        MyTests.log(LogStatus.INFO,"test starts: "); // information log
        HomePage.clickOnSignUpButton();
        signUpPage.clickOnRegistrationButton();
        signUpPage.writeInNameField(readFromFile("firstname", getPathXml()));
        signUpPage.writeInEmailField(readFromFile("email", getPathXml()));
        signUpPage.writeInPasswordField(readFromFile("password", getPathXml()));
        signUpPage.writeInPasswordVerifyField(readFromFile("password", getPathXml()));
        signUpPage.clickOnprivacyPolicyCheckBox();
        signUpPage.clickOnSubmit();

        // add results to log
         MyTests.log(LogStatus.PASS,"Signup successful");
        MyTests.log(LogStatus.FAIL,"test failed");

    }
    @Test   
    public void test02_B_HomeScreen() throws Exception {
        flows.chooseanoption();
        HomePage.verifyUrlChange();

    }
    @Test
    public void test03_C_HomeScreen() throws Exception {
        flows.chooseanoption();
        HomePage.verifyUrlChange();
        resultPage.chooseRandomResult();
        resultPage.randomamount();
    }
    @Test
    public void test04_D_HomeScreen() throws Exception {
        flows.chooseanoption();
        resultPage.chooseRandomResult();
        resultPage.randomamount();
        flows.whoToSendPageFlow();


    }
    @After
    public void afterTest() {
        extent.endTest(MyTests);
    }


}

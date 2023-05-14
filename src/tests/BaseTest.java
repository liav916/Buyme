package tests;
import Flow.Flows;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Document;
import pageObjects.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;


public class BaseTest {
    //1.declaration for all page objects except base
    static WebDriver driver;
    static SignUpTest signUpTest;
    static LoginTest loginTest;
    static BasePage basePage;
    static BaseTest basetest;
    static LoginPage loginPage;
    static ResultPage resultPage;
    static SignUpPage signUpPage;
    static HomePage HomePage;
    static Flows flows;
    static ExtentReports extent;
    static ExtentTest MyTests;

    private static String reportFilePath = "C:\\Users\\liav\\Desktop\\Buyme project\\Report.html";
    private static   String pathXml="C:\\Users\\liav\\Desktop\\Buyme project\\fileforvalues.xml";


    //2.@before class - init to browser, driver and report
    //2.@before class - init to browser, driver and report
    @BeforeClass
    public static void setUp() {
        extent = new ExtentReports(reportFilePath);
        MyTests = extent.startTest("BuyMe");
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        resetPage();
        driver.manage().window().maximize();
        driver.get("https://buyme.co.il/");
    }

    public static void resetPage()
    {
        HomePage=new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        resultPage = new ResultPage(driver);
        flows = new Flows(driver);


    }

    public static String getPathXml()
    {
        return pathXml;
    }
    //3.read from file
    public static String readFromFile(String keyData, String filePath) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyData).item(0).getTextContent();
    }

    private  String takeScreenShot(String ImagePath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagePath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagePath + ".png";
    }

    //4.@after class - close driver and report
   @AfterClass
  public static void close() {
       //driver.close();
      //  driver.quit();
      // extent.flush();
    }
}
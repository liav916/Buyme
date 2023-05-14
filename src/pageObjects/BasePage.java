package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class BasePage {

    public static WebDriver driver;
    public WebDriverWait wait;

//Set Driver
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(65));
    }

// click function
    public static void click(By elementLocation) {
        waitForElement(elementLocation);
        driver.findElement(elementLocation).click();
    }
//insert values in field function
    public void sendKeys(By elementLocation, String text) {

        driver.findElement(elementLocation).clear();
        driver.findElement(elementLocation).sendKeys(text);
    }

    public void selectByIndex (By elementLoction, int index) {
        waitForElement(elementLoction);
        WebElement combo = driver.findElement(elementLoction);
        Select selectIndex = new Select(combo);
        selectIndex.selectByIndex(index);

    }

    public void selectByText(By elementLoction, String text) {
        waitForElement(elementLoction);
        WebElement combo = driver.findElement(elementLoction);
        Select selectText = new Select(combo);
        selectText.selectByValue(text);

    }

    public boolean checkBoxIsSelected(By elementLocation) {
        return driver.findElement(elementLocation).isSelected();

    }

    public void readText(By elementLocation) {
        driver.findElement(elementLocation).getText();
    }

    public static void waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public void Waitviseblity(By by) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException o) {
            o.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }



    public int random (int num) {

        int randomNum = 0;
        do {
            randomNum = ThreadLocalRandom.current().nextInt(0, num);
        }while (randomNum==0);
        return randomNum;
    }


}


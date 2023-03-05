package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class basePage {
    public WebDriver driver;

    public basePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void click(By elementLoction) {
        driver.findElement(elementLoction).click();
    }

    public void sendKeys (By elementLoction,String text) {
        driver.findElement(elementLoction).clear();
        driver.findElement(elementLoction).sendKeys(text);
    }

    public boolean checkBoxIsSelected (By elementLoction) {
        return driver.findElement(elementLoction).isSelected();
    }

    public void readText (By elementLoction)
    {
        driver.findElement(elementLoction).getText();
    }







}


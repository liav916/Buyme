package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

     By signUpButton = By.className("notSigned");
     By priceDropdown = By.cssSelector("span[title='סכום']");
     By newPriceDropdown = By.cssSelector("label[class='ember-view bm-field bm-select show-options with-icon empty md no-label']");
     By areaDropDown = By.cssSelector("span[title='אזור']");
     By newAreaDropDown = By.cssSelector("div[aria-label=\"אזור\"]");
     By searchButton = By.cssSelector("a[rel='nofollow']");
     By ad1 = By.cssSelector("svg.inner-element");//"div[data-width=\"21\"]");
     By ad2 = By.cssSelector("polygon[fill='#ebeafa']");
     By cagorydropdown = By.cssSelector("span[aria-label=\"קטגוריה\"]");
     By cagoryopendropdown = By.cssSelector("div[aria-label=\"קטגוריה\"]");



    public HomePage clickOnSignUpButton() {
        click(signUpButton);
        return this;
    }




    public HomePage clickOnSearch() {

        waitForElement(searchButton);
        click(searchButton);
        return this;
    }




    public void selectPriceDropDownOption() throws InterruptedException {

        Waitviseblity(priceDropdown);
        WebElement dropdown = driver.findElement(priceDropdown);
        dropdown.click();
        Waitviseblity(newPriceDropdown);
       WebElement openDropdown = driver.findElement(newPriceDropdown);
        List<WebElement> options = openDropdown.findElements(By.tagName("li"));
        int randomNum = ThreadLocalRandom.current().nextInt(1, options.size());
        WebElement op = options.get(randomNum);
        op.click();
    }

    public void selectAreaDropDownOption() throws InterruptedException {

       // Waitviseblity(areaDropDown);
        WebElement dropdown = driver.findElement(areaDropDown);
        dropdown.click();
        Waitviseblity(newAreaDropDown);
       WebElement openDropdown = driver.findElement(newAreaDropDown);
        List<WebElement> options = openDropdown.findElements(By.tagName("li"));
        int randomNum = ThreadLocalRandom.current().nextInt(1, options.size());
        WebElement op = options.get(randomNum);
        op.click();
    } // select a random value from dropdown
    public void selectCategoryDropDownOption() throws InterruptedException {

        Waitviseblity(cagorydropdown);
        WebElement dropdown = driver.findElement(cagorydropdown);
        dropdown.click();
        Waitviseblity(cagoryopendropdown);
        WebElement openDropdown = driver.findElement(cagoryopendropdown);
        List<WebElement> options = openDropdown.findElements(By.tagName("li"));
        int randomNum = ThreadLocalRandom.current().nextInt(1, options.size());
        WebElement op = options.get(randomNum);
        op.click();}






    public void verifyUrlChange()
    {
        String url = driver.getCurrentUrl();
        Assert.assertNotEquals(url, "https://buyme.co.il/");
    }


    public void closepopup(By by) throws InterruptedException {

        if (driver.findElement(by).isDisplayed())
        {click(by);}
        }


    public void waitForUrlToLoad(String url) throws InterruptedException {
        boolean urlLoaded = false;
        HttpURLConnection connection = null;
        URL u;

        while (!urlLoaded) {
            try {
                u = new URL(url);
                connection = (HttpURLConnection) u.openConnection();
                connection.setRequestMethod("HEAD");
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    urlLoaded = true;
                }
            } catch (Exception e) {
                // URL not loaded yet, wait and try again
                Thread.sleep(1000);
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
    }



}








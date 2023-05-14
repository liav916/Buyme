package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PresentPage extends BasePage {


    public PresentPage(WebDriver driver) {
        super(driver);
    }
    String picsloction = "C:\\Users\\liav\\Desktop\\picscs\\Screenshot_1.png";

    By someOneElseButton = By.cssSelector("div[gtm='למישהו אחר']");
    By presentReciverField = By.cssSelector("input[tuaandiinputdiscrp='שם מקבל המתנה. כדי לשלוח את המתנה אליך. נווט אחורה ושנה את הבחירה בכפתורי הרדיו']");
    By typeOfPartyDropdown = By.cssSelector("div[aria-label='לאיזה אירוע?']");
    By blessingField = By.cssSelector("textarea[aria-label=\"מזל טוב, תודה רבה או פשוט מלא אהבה? כאן כותבים מילים טובות ואיחולים שמחים\"]");
    By pictureUploud = By.cssSelector("input[name='logo']");
    By nextButton = By.cssSelector("button[type='submit']");
    By nowButton = By.cssSelector("div[gtm=\"עכשיו\"]");
    By emailButton = By.cssSelector("svg[gtm=\"method-email\"]");
    By emailfield = By.cssSelector("input[id=\"email\"]");
    By giftSenderField = By.cssSelector("input[placeholder=\"שם שולח המתנה\"]");

    public PresentPage clickOnSomeOneElseButton() {
        click(someOneElseButton);
        return this;}
    public PresentPage clickSubmit() {
        click(nextButton);
        return this;}
    public PresentPage writeInPresentReciverField(String name) {
        sendKeys(presentReciverField, name);
        return this;
    }
    public PresentPage writeaBlessing(String theBlessing) {
        sendKeys(blessingField, theBlessing);
        return this;
    }
    public PresentPage uploadPhoto() {
        sendKeys(pictureUploud, picsloction);
        return this;
    }










    public void selecttypeOfPartyDropdown() throws InterruptedException {

        Waitviseblity(typeOfPartyDropdown);
        WebElement dropdown = driver.findElement(typeOfPartyDropdown);
        dropdown.click();
        Waitviseblity(typeOfPartyDropdown);
        WebElement openDropdown = driver.findElement(typeOfPartyDropdown);
        List<WebElement> options = openDropdown.findElements(By.tagName("li"));
        int randomNum = ThreadLocalRandom.current().nextInt(1, options.size());
        WebElement op = options.get(randomNum);
        op.click();
    }




}

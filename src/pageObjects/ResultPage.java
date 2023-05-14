package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ResultPage extends BasePage {


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    By allSearchResuls = By.cssSelector("ul[role='list']");
    By amountField = By.cssSelector("input[placeholder='הכנס סכום']");
    By chooseButton = By.cssSelector("button[gtm=''בחירה']");
    By FullResults = By.cssSelector("ul.grid.gifts-list");



    public void chooseRandomResult() {
        waitForElement(allSearchResuls);
        WebElement allResults = driver.findElement(allSearchResuls);
        List<WebElement> results = allResults.findElements(By.tagName("div"));
        int randomNum = ThreadLocalRandom.current().nextInt(0, results.size());
        WebElement op = results.get(randomNum);
        Actions actions = new Actions(driver);
        actions.moveToElement(op).click();
        wait.until(ExpectedConditions.elementToBeClickable(op));
        op.click();
    }

    public void randomamount() throws InterruptedException {
        Waitviseblity(FullResults);
        WebElement allresults = driver.findElement(FullResults);
        List<WebElement> op = allresults.findElements(By.tagName("li[class='ember-view']"));
       System.out.println(op.size()+" SIZE");
        if (op.size() == 1)
        {if (op.get(0).getText().contains("הכנס סכום"))
            {By temp = (By) op.get(0).findElement(By.cssSelector("input[placeholder='הכנס סכום']"));
                System.out.println(op.get(0).getText());
                sendKeys(temp,"1200");
                op.get(0).click();}
            else {op.get(0).click();}}
        else {verifysendkeysfield(op);}
    }
    public void verifysendkeysfield(List<WebElement> listLocation) {
        int result = random(listLocation.size());


        if (listLocation.get(result).getText().contains("הכנס סכום"))
        {
            By temp = (By) listLocation.get(result).findElement(By.cssSelector("input[placeholder='הכנס סכום']"));
            By temp1 = By.cssSelector("input[placeholder='הכנס סכום']");
            sendKeys(amountField,"1200");
          //  click(chooseButton);
            listLocation.get(result).click();
        }
        else
        { listLocation.get(result).click();

        }
   /*     String op = listLocation.gettext().getText();
        System.out.println(op);

        WebElement choose = driver.findElement(By.cssSelector("button[id='"+op+"']"));
        if (choose.getText().contains("הכנס סכום")) {
            WebElement key = choose.findElement(By.cssSelector("input[placeholder='הכנס סכום']"));
            key.sendKeys("1200");
        }
        wait.until(ExpectedConditions.elementToBeClickable(choose));
        click(chooseButton);*/
    }



}
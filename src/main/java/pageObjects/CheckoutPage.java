package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
//    private By codButton  = By.cssSelector("input[type='radio'][value='P']");
//    private By prepaidButton = By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div[2]/div/div[9]/div[1]/label[1]/input");
    private By confirmButton =By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div[2]/div/div[9]/div[2]/button");
//    private By confirmationText = By.xpath("//h1[contains(text(),'Thank you, Order is confirmed!')]");
    private By deleteCart  = By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[2]/svg");


    // Actions
   
    public void confirmOrder()  {
        driver.findElement(deleteCart).click();
   
       driver.findElement(confirmButton).click();
    }
    

//    public void confirmOrder() throws InterruptedException {
//        driver.findElement(prepaidButton).click();
//        Thread.sleep(2000);
//   
//        driver.findElement(confirmButton).click();
//    }
//    
//    public String getConfirmationText() {
//        return driver.findElement(confirmationText).getText();
//    }
}

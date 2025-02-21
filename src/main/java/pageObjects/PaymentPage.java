package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;

    // Locators
    By iframe = By.id("dummy-iframe");
    By card = By.xpath("//*[@id=\"checkout-card\"]/div/label/div/div/p");
    By cardNumber = By.cssSelector("input[name=\"cardNumber\"]");
    By expiryMonth = By.id("cardExpirationMonth");
    By expiryYear = By.id("cardExpirationYear");
    By cvv = By.id("cvv");
    By payNowButton = By.xpath("//*[@id=\"checkout-button\"]/button");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Switch to iframe
    public void switchToIframe() {
        //driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(card).click();
        driver.switchTo().frame(driver.findElement(iframe));

    }

//    // Enter card details
//    public void enterCardDetails(String cardNum, String month,String year, String cvvCode) {
//        driver.findElement(cardNumber).sendKeys(cardNum);
//        driver.findElement(expiryMonth).sendKeys(month);
//        driver.findElement(expiryYear).sendKeys(year);
//        driver.findElement(cvv).sendKeys(cvvCode); 
//    }
    
    

    public void enterCardNumber(String cardNum) {
        driver.findElement(cardNumber).sendKeys(cardNum);
        
    }

    public void enterExpiryMonth(String month) {
        driver.findElement(expiryMonth).sendKeys(month);
    }

    public void enterExpiryYear(String year) {
        driver.findElement(expiryYear).sendKeys(year);
    }
    
    public void enterCVV(String cvvCode) {
        driver.findElement(cvv).sendKeys(cvvCode);
    }
    // Click Pay Now
    public void clickPayNow() {
        driver.findElement(payNowButton).click();
    }

    // Switch back to main content
    public void switchBackToMainContent() {
        driver.switchTo().defaultContent();
    }
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    //WebUtils webUtils;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        this.webUtils = new WebUtils(driver); 

    } 

    // Locators
//    private By productDetail = By.xpath("//*[@id=\"root\"]/main/div/div[3]/div[1]/div/div/div[2]/div[1]/div[1]");
    private By addToCartButton = By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div[2]/div[7]/button[1]");
    private By cartIcon = By.xpath("//*[@id=\"root\"]/header/div[2]/div[1]/div[3]/div[4]/a");
    private By searchBar = By.cssSelector("input[placeholder='Search Products, Brands..']");
    private By selectProduct = By.xpath("//li[contains(text(), 'Product Test1')]");
//    private By selectProduct = By.xpath("//*[@id=\"root\"]/header/div[2]/div[2]/div[2]/div/ul/li[1]");

    // Actions
    
    // Searches for a product using the search bar
    public void searchProduct(String productName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).sendKeys(productName);
        Thread.sleep(2000);
    }
    
    // Selects a product from the search results
    public void selectProductFromResults() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(selectProduct)).click();
         Thread.sleep(2000);
    }

//    // Opens the product detail page
//    public void openProductDetail() {
//        wait.until(ExpectedConditions.elementToBeClickable(productDetail)).click();
//    }

    // Adds the product to the cart
    public void addToCart() throws InterruptedException {
//        webUtils.scrollToElement(addToCartButton);  
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        Thread.sleep(2000);

    }

    // Navigates to the cart
    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }



}

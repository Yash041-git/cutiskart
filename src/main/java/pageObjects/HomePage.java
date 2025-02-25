
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    // Locators for elements on the home page
    private By profileIcon = By.xpath("//*[@id=\"root\"]/header/div[2]/div[1]/div[3]/div[2]/a"); 

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
//  jkflf
//    kfnbfmb
//    fnkvdnkv
//    vken

    // Method to click on the profile icon
    public void clickProfileIcon() {
        WebElement icon = driver.findElement(profileIcon);
        icon.click();
    }
}


package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        // Setting up Chrome WebDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaswa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver 
        driver = new ChromeDriver();

        // Configuring implicit wait for elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximizing the window
        driver.manage().window().maximize();

        
    }

    @After
    public void teardown() {
        // Close the driver and quit the browser after the test is complete
        if (driver != null) {
//            driver.quit();
        }
    }
}

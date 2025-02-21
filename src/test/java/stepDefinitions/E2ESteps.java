package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import pageObjects.ProductPage;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
//import org.testng.Assert;

public class E2ESteps {
    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    HomePage homePage;

    @Given("I open the website")
    public void i_launch_the_website_using_the_url() {
        driver.get("https://cutis-web-ui.demotest.in/"); 
    }

    @And("I click on the profile icon to navigate to the signin page")
    public void i_click_on_the_profile_icon_to_navigate_to_the_signin_page() {
        homePage = new HomePage(driver);
        homePage.clickProfileIcon();
    }

    @When("I log in with the following credentials")
    public void i_log_in_with_the_following_credentials(DataTable credentials) throws InterruptedException {
        List<Map<String, String>> data = credentials.asMaps(String.class, String.class);
        String username = data.get(0).get("username");
        String password = data.get(0).get("password");

        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Thread.sleep(2000);

    }
    
    @When("I search for a product")
    public void i_search_for_a_product() throws InterruptedException {
        productPage = new ProductPage(driver);
        productPage.searchProduct("test"); 
        Thread.sleep(2000);
    }

    @When("I select the product from the search result")
    public void i_select_the_product_from_the_search_result() throws InterruptedException {
        productPage.selectProductFromResults();
        Thread.sleep(2000);

    }
    
    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() throws InterruptedException {
        productPage.addToCart(); 
        System.out.println("Product added to the cart.");
    }

    @And("I proceed to checkout")
    public void i_proceed_to_checkout() throws InterruptedException {
        productPage.openCart();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.confirmOrder();
        System.out.println("Radio Button selected");

        
    }
    
    @When("I complete the payment process")
    public void i_complete_the_payment_process() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.switchToIframe();
        paymentPage.enterCardNumber("1234 5678 9012 3456");
        paymentPage.enterExpiryMonth("12");
        paymentPage.enterExpiryYear("30");
        paymentPage.enterCVV("123");

        
        
        
//        paymentPage.enterCardDetails("1234 5678 9012 3456", "12","30","123");
//        paymentPage.clickPayNow();
//        paymentPage.switchBackToMainContent();
    }
    
   


//    @Then("I should see the order confirmation message {string}")
//    public void i_should_see_the_order_confirmation_message(String expectedMessage) {
//        String confirmationText = checkoutPage.getConfirmationText();
//        Assert.assertTrue(confirmationText.contains(expectedMessage), "Order confirmation failed!");
//    }
}

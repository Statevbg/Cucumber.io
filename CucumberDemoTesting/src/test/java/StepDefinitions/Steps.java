package StepDefinitions;

import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Steps extends BaseClass {


    @Given("User launch Chrome browser")
    public void user_launch_chrome_browser() {
        driver = new ChromeDriver();
        lp = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }
    @And("User enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String email, String password) {
        lp.setUsername(email);
        lp.setPassword(password);
    }
    @And("Click on login")
    public void click_on_login() {
        lp.clickLogin();
    }
    @Then("Page Title should be {string}")
    public void page_title_in_loginpage_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assertions.assertTrue(false);
        }else{
            Assertions.assertEquals(title, driver.getTitle());
        }
    }
    @When("User click on logout link")
    public void user_click_on_logout_link() {
        lp.clickLogout();
    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        Assertions.assertEquals(title, driver.getTitle());
    }

    @And("close browser")
    public void close_browser() {
       // driver.quit();
    }

    // Additional steps CustomersFeature
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        addNewCust = new AddNewCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", addNewCust.getPageTitle());
    }
    @When("User click on customers Menu")
    public void user_click_on_customers_menu() {
        addNewCust.clickOnCustomersMenu();
        addNewCust.clickOnCustomersMenuItem();

    }
    @When("click on Add new button")
    public void click_on_add_new_button() {
        addNewCust.clickOnAddNew();
    }
    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addNewCust.getPageTitle());
    }
    @When("user enter customer info")
    public void user_enter_customer_info() {
        String email = randomestring() + "@gmail.com";
        addNewCust.setEmail(email);
        addNewCust.setPassword("random123");
        addNewCust.setFirstName("John");
        addNewCust.setLastName("Smith");
        addNewCust.setGender("Male");
        addNewCust.setDateOfBirth("07/06/1990");
        addNewCust.setCompanyName("Smith and Co.");
       // addNewCust.setCustomerRoles("Vendors");
        addNewCust.setAdminComment("This is for exercise");
    }
    @When("click on Save button")
    public void click_on_save_button() {
        addNewCust.clickSaveButton();
    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string ) {

        Assert.assertTrue(driver.findElement(By.tagName("body"))
                .getText()
                .contains("The new customer has been added successfully."));
    }

}

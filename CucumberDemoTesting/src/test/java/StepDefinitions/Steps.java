package StepDefinitions;

import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Steps {

    public WebDriver driver;
    public LoginPage lp;
    @Given("User launch Chrome browser")
    public void user_launch_chrome_browser() {
        driver = new ChromeDriver();
        lp = new LoginPage(driver);

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

}

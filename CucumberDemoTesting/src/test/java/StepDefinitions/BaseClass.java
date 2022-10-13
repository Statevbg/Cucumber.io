package StepDefinitions;

import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddNewCustomerPage addNewCust;

    public static String randomestring(){
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }
}

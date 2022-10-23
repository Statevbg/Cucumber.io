package PageObjects;

import org.openqa.selenium.By;
import Utilities.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerByEmail {
    WaitHelper waitHelper;
    public WebDriver driver;

    public SearchCustomerByEmail(WebDriver rdriver){
        driver = rdriver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }
    @FindBy(id = "SearchEmail")
    @CacheLookup
    WebElement searchEmail;


    @FindBy(id = "SearchFirstName")
    @CacheLookup
    WebElement searchFName;

    @FindBy(id = "SearchLastName")
    @CacheLookup
    WebElement searchLName;

    @FindBy(id = "search-customers")
    @CacheLookup
    WebElement searchButton;


    @FindBy(how = How.XPATH, using = "//*[@id=\"customers-grid\"]")
    List<WebElement> table;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customers-grid\"]/tbody/tr")
    List<WebElement> rows;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customers-grid\"]/tbody/tr/td")
    List<WebElement> columns;


    public void setEmail(String email){
        waitHelper.WaitForElement(searchEmail, 15);
        searchEmail.clear();
        searchEmail.sendKeys(email);
    }

    public void setFirstName(String email){
        waitHelper.WaitForElement(searchFName, 15);
        searchFName.clear();
        searchFName.sendKeys(email);
    }

    public void setLastName(String email){
        waitHelper.WaitForElement(searchLName, 15);
        searchLName.clear();
        searchLName.sendKeys(email);
    }

    public void clickSearchButton() throws InterruptedException {
        searchButton.click();
        Thread.sleep(3000);
    }
    public int numsOfRows(){
        return (rows.size());
    }
    public int numsOfColumns(){
        return (columns.size());
    }

    public boolean searchCustomerByEmail(String email){
        boolean flag  = false;
        for (int i = 1; i <= numsOfRows(); i++){
            String emailId = driver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
            if (emailId.equals(email)){
                System.out.println(emailId);
                flag = true;
            }
        }
        return flag;
    }



}

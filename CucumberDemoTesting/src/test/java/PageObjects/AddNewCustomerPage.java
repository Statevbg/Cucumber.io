package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
    public WebDriver driver;


    public AddNewCustomerPage(WebDriver rdriver){
        driver = rdriver;
        PageFactory.initElements(driver, this);
    }

    By Customers_Menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    By Customer_MenuItem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
    By buttonAddNew = By.xpath("//a[normalize-space()='Add new']");

    By emailInput = By.id("Email");
    By pwdInput = By.id("Password");
    By firstName =By.id("FirstName");
    By lastName = By.id("LastName");
    By rbMale = By.id("Gender_Male");
    By rbFemale = By.id("Gender_Female");
    By dateOfBirth = By.id("DateOfBirth");
    By companyName = By.id("Company");
    By isTaxExempt = By.id("IsTaxExempt");
    By customerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
    By customerRolesItems = By.cssSelector("select#SelectedCustomerRoleIds");
    By managerOfVendor = By.cssSelector("select#VendorId");
    By adminComment = By.id("AdminComment");
    By saveButton = By.xpath("//button[@name='save']");
    By lstitemAdministrator = By.xpath("//li[contains(text(),'Administrators')]");
    By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
    By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
    By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
    By lstitemForumModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
    By lstitemDealerBIH = By.xpath("//li[contains(text(),'Dealer BIH')]");
    public String getPageTitle(){
        return driver.getTitle();
    }

    public void clickOnCustomersMenu(){

        driver.findElement(Customers_Menu).click();
    }
    public void clickOnCustomersMenuItem(){
        driver.findElement(Customer_MenuItem).click();
    }
    public void clickOnAddNew(){
        driver.findElement(buttonAddNew).click();
    }
    public void setEmail(String email ){
        driver.findElement(emailInput).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(pwdInput).sendKeys(password);
    }
    public void setFirstName(String fname){
        driver.findElement(firstName).sendKeys(fname);
    }
    public void setLastName(String lname){
        driver.findElement(lastName).sendKeys(lname);
    }
    public void setGender(String gender){
        if (gender == "Male"){
            driver.findElement(rbMale).click();
        } else if (gender == "Female") {
            driver.findElement(rbFemale).click();
        }else {
            System.out.println("Wrong Input");
        }
    }
    public void setDateOfBirth(String date){
        driver.findElement(dateOfBirth).sendKeys(date);
    }
    public void setCompanyName(String coName){
        driver.findElement(companyName).sendKeys(coName);
    }
    public void setCustomerRoles(String role){
        driver.findElement(customerRoles).click();
        WebElement roles = driver.findElement(customerRolesItems);
        Select select = new Select(roles);
        select.selectByVisibleText(role);
    }
    public void setCustomerRoles1(String role) {


        driver.findElement(customerRoles).click();
        WebElement listitem = null;


        if(role.equals("Administrators")){
            listitem = driver.findElement(lstitemAdministrator);
        }
        else if (role.equals("Guests")){
            listitem = driver.findElement(lstitemGuests);
        }
        else if (role.equals("Registered")){
            listitem = driver.findElement(lstitemRegistered);
        }
        else if (role.equals("Vendors")){
            listitem = driver.findElement(lstitemVendors);
        }
        else if (role.equals("Forum Moderators")){
            listitem = driver.findElement(lstitemForumModerators);
        }
        else if (role.equals("Dealer BIH")){
            listitem = driver.findElement(lstitemDealerBIH);
        }

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("argument[0].click();", listitem);
    }
    public void setAdminComment(String comment){
        driver.findElement(adminComment).sendKeys(comment);
    }
    public void clickSaveButton(){
        driver.findElement(saveButton).click();
    }

}

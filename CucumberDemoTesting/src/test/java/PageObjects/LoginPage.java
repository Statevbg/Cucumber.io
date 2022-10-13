package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver _driver){
        driver = _driver;
        PageFactory.initElements(_driver, this);
    }
    @FindBy(id = "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement  txtPassword;

    @FindBy(css = "button[type=submit]")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement  btnLogout;

    public void setPassword (String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void setUsername (String email){
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickLogout(){
        btnLogout.click();
    }


}

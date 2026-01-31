package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "signin")
    WebElement signInBtn;

    @FindBy(id = "username")
    WebElement usernameDropdown;

    @FindBy(id = "react-select-2-input")
    WebElement userInput;
    
    @FindBy(id = "react-select-2-option-1")
    WebElement userInputSelect;

    @FindBy(id = "password")
    WebElement passwordDropdown;

    @FindBy(id = "react-select-3-input")
    WebElement passwordInput;
    
    @FindBy(id = "react-select-3-option-1")
    WebElement passOptionSelect;

    @FindBy(id = "login-btn")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    


    public void login(String user, String pass) {
    	WaitUtils.waitForClickable(driver, signInBtn).click();
        WaitUtils.waitForClickable(driver, usernameDropdown).click();
        userInput.sendKeys(user);
        WaitUtils.waitForClickable(driver, userInputSelect).click();
        

        WaitUtils.waitForClickable(driver, passwordDropdown).click();
        passwordInput.sendKeys(pass);
        WaitUtils.waitForClickable(driver, passOptionSelect).click();
        
        WaitUtils.waitForClickable(driver, loginBtn).click();

    }

    //Used for negative test cases
    
    public boolean isLoginButtonEnabled() {
        return loginBtn.isEnabled();
    }
    
    public void loginWithoutData() {
		WaitUtils.waitForClickable(driver, signInBtn).click();
		WaitUtils.waitForClickable(driver, loginBtn).click();
	}
}

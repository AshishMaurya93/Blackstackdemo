package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    @FindBy(xpath = "//div[text()='Checkout']")
    WebElement checkoutBtn;

    @FindBy(id = "firstNameInput")
    WebElement firstName;

    @FindBy(id = "lastNameInput")
    WebElement lastName;
    
    @FindBy(id = "addressLine1Input")
    WebElement address;
    
    @FindBy(id = "provinceInput")
    WebElement state;
    
    @FindBy(id = "postCodeInput")
    WebElement pinCode;

    @FindBy(id = "checkout-shipping-continue")
    WebElement submitBtn;
    
    @FindBy(xpath = "//div[text()='Continue Shopping']")
    WebElement contunueShoppingBtn;


    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void placeOrder(String fName, String lName, String addr, String stateName, String pCode) throws InterruptedException {
        checkoutBtn.click();
        Thread.sleep(3000);
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        address.sendKeys(addr);
        state.sendKeys(stateName);
        pinCode.sendKeys(pCode);
        submitBtn.click();
    }
    
    public void submitOrder() {
    	contunueShoppingBtn.click();
	}
}

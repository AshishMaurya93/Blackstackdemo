package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CartPage {

    WebDriver driver;

    @FindBy(className = "bag")
    WebElement cartIcon;

    @FindBy(className = "shelf-item__del")
    WebElement removeBtn;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCart() {
        WaitUtils.waitForElement(driver, cartIcon);
        cartIcon.click();
    }

    public void removeItem() {
        WaitUtils.waitForElement(driver, removeBtn);
        removeBtn.click();
    }
}

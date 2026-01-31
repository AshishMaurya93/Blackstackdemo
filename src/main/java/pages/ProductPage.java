package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class ProductPage {

    WebDriver driver;

    @FindBy(xpath = "(//div[text()='Add to cart'])[1]")
    WebElement addFirstProduct;

    @FindBy(xpath = "(//div[text()='Add to cart'])[2]")
    WebElement addSecondProduct;

    @FindBy(className = "bag__quantity")
    WebElement cartCount;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addSingleProduct() {
        WaitUtils.waitForElement(driver, addFirstProduct);
        addFirstProduct.click();
    }

    public void addMultipleProducts() {
        WaitUtils.waitForElement(driver, addFirstProduct);
        addFirstProduct.click();

        WaitUtils.waitForElement(driver, addSecondProduct);
        addSecondProduct.click();
    }

    public String getCartCount() {
        WaitUtils.waitForElement(driver, cartCount);
        return cartCount.getText();
    }
}

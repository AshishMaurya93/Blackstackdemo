package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CartTest extends BaseTest {

    @Test
    public void TC_004_addSingleProduct() {
    	test.info("Login to application");
        new LoginPage(driver).login("demouser", "testingisfun99");
        ProductPage product = new ProductPage(driver);
        test.info("Adding single product to cart");
        product.addSingleProduct();
        Assert.assertEquals(product.getCartCount(), "1");
        test.pass("Single product added successfully");
    }

    @Test
    public void TC_005_addMultipleProducts() {
    	test.info("Login to application");
        new LoginPage(driver).login("demouser", "testingisfun99");
        ProductPage product = new ProductPage(driver);
        test.info("Adding multiple products to cart");
        product.addMultipleProducts();
        Assert.assertEquals(product.getCartCount(), "2");
        test.pass("Multiple products added successfully");

    }

    @Test
    public void TC_006_removeProduct() {
    	test.info("Login to application");
        new LoginPage(driver).login("demouser", "testingisfun99");
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        test.info("Adding single product to cart");
        product.addSingleProduct();
        test.info("removing single product from cart");
        cart.removeItem();
        Assert.assertTrue(driver.getPageSource().contains("Add some products in the bag"));
        test.pass("Product removed successfully");
    }
}

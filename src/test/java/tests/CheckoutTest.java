package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends BaseTest {

    @Test
    public void TC_007_successfulCheckout() throws InterruptedException {
    	test.info("Login to application");
        new LoginPage(driver).login("demouser", "testingisfun99");
        test.info("Adding product to cart");
        new ProductPage(driver).addSingleProduct();
        test.info("Proceeding to checkout");
        new CheckoutPage(driver).placeOrder("Ashish", "Maurya", "sector-20, house no. 12, Laxmi Nagar", "New Delhi", "110092");
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("Your Order has been successfully placed."));
        test.pass("Order placed successfully");
    }

    @Test
    public void TC_008_checkoutWithoutProduct() throws InterruptedException {
    	test.info("Login to application");
        new LoginPage(driver).login("demouser", "testingisfun99");
        test.info("openning cart");
        new CartPage(driver).openCart();
        test.info("Trying to checkout without product");
        new CheckoutPage(driver).submitOrder();
        Assert.assertFalse(driver.getPageSource().contains("Order Summary"));
        test.pass("Checkout without product not allowed");
    }
}

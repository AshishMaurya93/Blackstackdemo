package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.WaitUtils;

public class LoginTest extends BaseTest {

    @Test
    public void TC_001_validLogin() {
    	test.info("Starting Valid Login Test");
        LoginPage login = new LoginPage(driver);
        login.login("demouser", "testingisfun99");
        test.info("Logged in with valid credentials");
        Assert.assertTrue(driver.getPageSource().contains("demouser"));
        test.pass("Login successful and products visible");

    }

    @Test
    public void TC_002_invalidLogin() {
    	test.info("Starting Invalid Login Test");
        LoginPage login = new LoginPage(driver);
        login.login("wronginfo", "wronginfo");
        test.info("Trying to login with invalid credentials");
        Assert.assertFalse(driver.getPageSource().contains("Invalid Username"));
        test.pass("Login unsuccessful and products are not visible");
    }


    @Test
    public void TC_003_emptyCredentials() {
    	test.info("Starting No Credentials Login Test");
        LoginPage login = new LoginPage(driver);
        login.loginWithoutData();
        test.info("Trying to login with no credentials");
        Assert.assertFalse(login.isLoginButtonEnabled(),
                "Login button must be disabled when no values selected");
        test.pass("Login unsuccessful and products are not visible");
    }

}

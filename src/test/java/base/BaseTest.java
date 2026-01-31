package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ConfigReader;
import utils.ExtentManager;
import utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;
    protected static ExtentReports extent;
    protected ExtentTest test;
    
    @BeforeSuite
    public void startReport() {
        extent = ExtentManager.getExtent();
    }
    
    public String captureScreenshot(String testName) throws IOException {
        String path = "test-output/screenshots/" + testName + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);
        FileUtils.copyFile(src, dest);
        return path;
    }

    @BeforeMethod
    public void setUp(Method method) {
        prop = ConfigReader.initProperties();
        driver = WebDriverFactory.initDriver(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped");
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = captureScreenshot(result.getName());
            test.fail(result.getThrowable())
                .addScreenCaptureFromPath(screenshotPath);
        }


        driver.quit();
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }

}

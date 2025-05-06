package base;

import java.lang.reflect.Method;
import java.time.Duration;

import constants.AppConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import reports.ExtentManager;
import reports.ExtentReporter;
import utils.*;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void initReports() {
        ExtentManager.initReports();
        LoggerUtils.configureLogger();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, Method method) {
        driver = DriverFactory.initDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(AppConstants.DEFAULT_TIMEOUT));
        PageFactory.initElements(driver, this);
        ExtentReporter.startTest(method.getName());
        LoggerUtils.info("Starting: " + method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotUtils.capture(driver, result.getName());
            ExtentReporter.test.addScreenCaptureFromPath(path);
            LoggerUtils.error("Test Failed: " + result.getName());
        }
        DriverFactory.quitDriver();
        ExtentReporter.flush();
    }

    @AfterSuite
    public void closeReports() {
        ExtentManager.closeReports();
    }
}

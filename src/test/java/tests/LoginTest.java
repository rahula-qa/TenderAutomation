package tests;

public class LoginTest {

    public class LoginTest extends BaseTest {

        @Test(retryAnalyzer = RetryAnalyzer.class)
        public void validLoginTest() {
            driver.get(ConfigReader.getProperty("app.url"));

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(ConfigReader.getProperty("app.username"), ConfigReader.getProperty("app.password"));

            DashboardPage dashboard = new DashboardPage(driver);
            softAssert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard not loaded");
        }
    }
}

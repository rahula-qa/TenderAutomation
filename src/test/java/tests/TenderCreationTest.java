package tests;

public class TenderCreationTest {

    public class TenderCreationTest extends BaseTest {

        @Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "tenderData", dataProviderClass = ExcelUtils.class)
        public void uploadTenderTest(String filePath) {
            driver.get(ConfigReader.getProperty("app.url"));

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(ConfigReader.getProperty("app.username"), ConfigReader.getProperty("app.password"));

            DashboardPage dashboard = new DashboardPage(driver);
            softAssert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard not loaded");

            TenderUploadPage tenderUpload = new TenderUploadPage(driver);
            tenderUpload.uploadTender(filePath);

            AIResultsPage aiResults = new AIResultsPage(driver);
            softAssert.assertNotNull(aiResults.getAIScore(), "AI Score is missing");
            softAssert.assertNotNull(aiResults.getRemarks(), "Remarks are missing");
        }
    }

}

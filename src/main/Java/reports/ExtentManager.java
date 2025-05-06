package reports;

public class ExtentManager {
    private static ExtentReports extent;

    public static void initReports() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
            sparkReporter.loadXMLConfig(new File("resources/extent-config.xml"));

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Framework", "Tender Automation");
            extent.setSystemInfo("QA Lead", "Rahul Kumar");
        }
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static void closeReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}

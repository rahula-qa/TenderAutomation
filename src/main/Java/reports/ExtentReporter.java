package reports;

public class ExtentReporter {
    public static ExtentTest test;

    public static void startTest(String testName) {
        test = ExtentManager.getExtent().createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void flush() {
        ExtentManager.getExtent().flush();
    }
}


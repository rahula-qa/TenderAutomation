package utils;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int attempt = 0;
    private static final int MAX_RETRY = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (attempt < MAX_RETRY) {
            attempt++;
            return true;
        }
        return false;
    }
}

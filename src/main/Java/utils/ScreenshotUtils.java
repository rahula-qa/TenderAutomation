package utils;


    public class ScreenshotUtils {
        public static String capture(WebDriver driver, String screenshotName) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/reports/screenshots/" + screenshotName + ".png";
            try {
                FileUtils.copyFile(src, new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return path;
        }
    }


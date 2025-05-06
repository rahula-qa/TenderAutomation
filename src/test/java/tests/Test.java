package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.setProperty("webdriver.chromedriver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
    }
}

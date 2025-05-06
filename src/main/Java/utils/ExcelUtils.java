package utils;

import org.testng.annotations.DataProvider;

public class ExcelUtils {

@DataProvider(name = "tenderData")
public static Object[][] getTenderData() {
    return new Object[][] {
            { System.getProperty("user.dir") + "/testData/sampleTender1.pdf" },
            { System.getProperty("user.dir") + "/testData/sampleTender2.pdf" }
    };
}
}
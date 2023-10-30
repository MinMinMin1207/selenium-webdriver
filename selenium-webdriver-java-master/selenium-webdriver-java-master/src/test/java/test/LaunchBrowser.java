package test;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LaunchBrowser {
    @Test
    public void testLaunchBrowser() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://google.com");
        //Debug only
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}

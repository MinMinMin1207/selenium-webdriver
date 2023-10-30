package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverFactory {
    public static WebDriver getChromeDriver() {
        /*
        String currentProjectLocation = System.getProperty("user.dir");// current path of project
        String chromeDriverRelativePath = "/src/test/resources/drivers/chromedriver.exe";// path to driver
        String chromeDriverLocation = currentProjectLocation.concat(chromeDriverRelativePath);
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}

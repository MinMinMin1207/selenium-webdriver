package test;

import driver.driverFactory;
import model.pages.LoginPageSimple;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLoginPageSimple {
    @Test
    public void testLoginPage() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPageSimple loginPage = new LoginPageSimple(driver);
        /*loginPage.username().sendKeys("admin");
        loginPage.password().sendKeys("12345678");
        loginPage.loginBtn().click();*/

        loginPage.inputUsername("admin");
        loginPage.inputPassword("12345678");
        loginPage.clickOnLoginBtn();

        driver.quit();
    }
}

package BAI_TAP;

import POM.RegisterPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;

/*1. Go to http://live.techpanda.org/

2. Click on my account link

3. Click Create an Account link and fill New User information excluding the registered Email ID.

4. Click Register

5. Verify Registration is done. Expected account registration done.

6. Go to TV menu

7. Add product in your wish list - use product - LG LCD

8. Click SHARE WISHLIST

9. In next page enter Email and a message and click SHARE WISHLIST

10.Check wishlist is shared. Expected wishlist shared successfully.*/
@Test
public class TestCase05 {
    public static void testTC05() {
        int scc = 1;
        String firstName ="Phuc";
        String lastName = "Loc";
        String email_address = "Loc231@gmail.com";
        String password = "123456";
        String confirmPassword = password;

        StringBuffer verificationError = new StringBuffer();
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            RegisterPage registerPage = new RegisterPage(driver);

            //Step 2. Click on my account link
            registerPage.clickMyAccountLink();
            Thread.sleep(2000);
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);

            //Step 3. Click Create an Account link and fill New User information excluding the registered Email ID.
            registerPage.clickCreateAccountLink();
            Thread.sleep(2000);
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            registerPage.enterFirstName(firstName);
            registerPage.enterLastName(lastName);
            registerPage.enterEmail(email_address);
            registerPage.enterPassword(password);
            registerPage.enterConfirmPassword(confirmPassword);

            Thread.sleep(2000);

            //Step 4. Click Register

            registerPage.clickRegisterButton();
            Thread.sleep(2000);
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);
            // 5. Verify Registration is done. Expected account registration done.
            String vWelcome = ("WELCOME, " + firstName.toUpperCase() + " " + lastName.toUpperCase() + "!");
            String tWelcome = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[1]/div/p")).getText();
            System.out.println("tWelcome = "+tWelcome);

            try {
                assertEquals(tWelcome, vWelcome);
            } catch (Exception e) {
                e.printStackTrace();
            }


            //Step 6. Go to TV menu
            driver.findElement(By.xpath(".//*[@id='nav']/ol/li[2]/a")).click();
            Thread.sleep(2000);

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //Step 7. Add product in your wish list - use product - LG LCD
            driver.findElement(By.xpath("//li/a[@class='link-wishlist']")).click();
            Thread.sleep(2000);

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // Step 8. Click SHARE WISHLIST
            driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
            Thread.sleep(2000);

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }


            //Step 9. In next page enter Email and a message and click SHARE WISHLIST
            registerPage.enterEmail(email_address);

            driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
            Thread.sleep(2000);

            // Step 10. Check wishlist is shared. Expected wishlist shared successfully.
            String vWishList = "Your Wishlist has been shared.";
            String wishList = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
            System.out.println("wishList = "+wishList);
            try {
                assertEquals(vWishList, wishList);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Thread.sleep(3000);


            scc = (scc + 1);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = ("D:\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\resources\\testcase" + scc + ".png");

            FileUtils.copyFile(scrFile, new File(png));

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}

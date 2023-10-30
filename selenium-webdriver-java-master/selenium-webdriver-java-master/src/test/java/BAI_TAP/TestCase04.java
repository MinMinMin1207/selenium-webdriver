package BAI_TAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)

4. Click on �COMPARE� button. A popup window opens

5. Verify the pop-up window and check that the products are reflected in it

Heading "COMPARE PRODUCTS" with selected products in it.

6. Close the Popup Windows

*/

@Test
public class TestCase04 {
    public static void testTC04() {
        int scc = 0;

        StringBuffer verificationError = new StringBuffer();
        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //Step 2. Click on �MOBILE� menu
            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000);

            //Step 3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)
            driver.findElement(By.xpath(".//*//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();
            String Mobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
            System.out.println("Mobile1 = "+Mobile1);
            Thread.sleep(2000);
            driver.findElement(By.xpath(".//*//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();
            String Mobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
            System.out.println("Mobile2 = "+Mobile2);
            Thread.sleep(2000);

            //Step 4. Click on �COMPARE� button. A popup window open
            driver.findElement(By.xpath("//button[@title='Compare']")).click();
            Thread.sleep(2000);

            //switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);

            //Step 5. Verify the pop-up window and check that the products are reflected in it
            //
            //Heading "COMPARE PRODUCTS" with selected products in it.

            String strHead = ("COMPARE PRODUCTS");
            String compHead = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div[1]/h1")).getText();
            System.out.println("compHead = "+compHead);
            String popupMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();  // text captured is "IPHONE" in uppercase
            String popupMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();  // text captured "SONY XPERIA" in uppercase
            System.out.println("popupMobile1 = "+popupMobile1);
            System.out.println("popupMobile2 = "+popupMobile2);
            //Step 6. Close the Popup Windows
            driver.findElement(By.xpath("//button[@title='Close Window']")).click();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}

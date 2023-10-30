package BAI_TAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/*
* Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile

4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed

"The requested quantity for "Sony Xperia" is not available.

5. Verify the error message

6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.

7. Verify cart is empty*/
@Test
public class TestCase03 {

    public static void testTC03(){


        StringBuffer verificationError = new StringBuffer();
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //Step 2. Click on �MOBILE� menu
            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000);

            //Step 3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
            driver.findElement(By.xpath(".//*//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]")).click();
            Thread.sleep(2000);

            //Step 4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
            //
            //"The requested quantity for "Sony Xperia" is not available.
            driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();
            driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");
            driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")).click();
            Thread.sleep(2000);

            //Step 5. Verify the error message
            String reqQty = driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[2]/p")).getText();
            String msgQty = ("* The maximum quantity allowed for purchase is 500.");
            try {
                assertEquals(reqQty, msgQty);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Step 6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
            driver.findElement(By.xpath(".//*[@id='empty_cart_button']")).click();

            Thread.sleep(3000);

            // 7. Verify cart is empty
            String noItemsStg = ("You have no items in your shopping cart.");
            String noItemsMsg = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/div[2]/p[1]")).getText();
            System.out.println("You have no items msg = " + noItemsMsg);

            try {
                assertEquals(noItemsStg, noItemsMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }



        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}

package BAI_TAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/*

Test Steps:

1. Goto http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)

4. Click on Sony Xperia mobile

5. Read the Sony Xperia mobile from detail page.

6. Compare Product value in list and details page should be equal ($100).

*/
@Test
public class TestCase02 {
    public static void testTC02() {
        int scc = 0;

        StringBuffer verificationError = new StringBuffer();
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //Step 2. Click on �MOBILE� menu
            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000);

            //Step 3.In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
            String XPeriaPrice = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
            System.out.println(XPeriaPrice);
            Thread.sleep(2000);

            //Step 4. Click on Sony Xperia mobile
            driver.findElement(By.id("product-collection-image-1")).click();
            Thread.sleep(2000);

            //Step 5. Read the Sony Xperia mobile from detail page.
            String detailPrice = driver.findElement(By.cssSelector("span.price")).getText();
            //Step 6. Compare Product value in list and details page should be equal ($100).
            assertEquals(XPeriaPrice, detailPrice);
            if (XPeriaPrice.equals(detailPrice))
                System.out.printf("XPeriaPrice = detailPrice and price is: %s", detailPrice);
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }


        driver.quit();

    }
}

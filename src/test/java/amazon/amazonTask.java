package amazon;

import com.actitime.automation.common.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;

public class amazonTask {
    WebDriver driver;
    String amazonHomeWindowId;
    BaseClass baseclass;
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
//        CommonFunctions commonFunctions = new CommonFunctions();
        baseclass = new BaseClass();
//        driver = commonFunctions.launchBrowser("chrome");
        driver = baseclass.launchBrowser(browser);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        amazonHomeWindowId = driver.getWindowHandle();
    }

    @Test
    public void verifyAmazonMiniTVPage() throws InterruptedException {
        WebElement miniTV = driver.findElement(By.xpath("//a[text()='Amazon miniTV']"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(miniTV).keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);

        // Switch to the new tab
        Set<String> windows = driver.getWindowHandles();
        windows.remove(amazonHomeWindowId);
        String newTab = windows.iterator().next();
        driver.switchTo().window(newTab);

        System.out.println("Title of the Amazon miniTV page: " + driver.getTitle());
        Thread.sleep(5000);

        // Close the new tab
        driver.close();

        // Switch back to the original tab
        driver.switchTo().window(amazonHomeWindowId);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


//package amazon;
//
//import commonfunction.CommonFunctions;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//
//import java.util.Set;
//public class amazonTask {
//    public static void main(String[] args) throws InterruptedException {
//        CommonFunctions commonFunctions = new CommonFunctions();
//        WebDriver driver = commonFunctions.launchBrowser("chrome");
//        driver.get("https://www.amazon.in/");
//        Thread.sleep(5000);
//
//        WebElement miniTV = driver.findElement(By.xpath("//a[text()='Amazon miniTV']"));
//        Thread.sleep(2000);
//
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.CONTROL).click(miniTV).keyUp(Keys.CONTROL).perform();
//        Thread.sleep(2000);
////        actions.moveToElement(miniTV).build().perform(); // Move to the element
////        actions.keyDown(Keys.ARROW_DOWN).build().perform();
////        actions.keyDown(Keys.ARROW_DOWN).build().perform();
////        actions.keyUp(Keys.ARROW_DOWN).build().perform();
////        actions.keyDown(Keys.ENTER).build().perform();
////        actions.keyUp(Keys.ENTER).build().perform();
////        Thread.sleep(2000);
//
//
//        // Switch to new tab
//        Set<String> windows = driver.getWindowHandles();
//        String amazonHomeWindowId = driver.getWindowHandle();
//        windows.remove(amazonHomeWindowId);
//        String newTab = windows.iterator().next();
//        driver.switchTo().window(newTab);
//
//        System.out.println("Title of the Amazon miniTV page: " + driver.getTitle());
//        Thread.sleep(5000);
//
//        // Close the tab
//        driver.close();
//
//        // Switch back to the original tab
//        driver.switchTo().window(amazonHomeWindowId);
//
//        System.out.println("Title of the amazon home page: " + driver.getTitle());
//        System.out.println("Amazon Window Id: " + amazonHomeWindowId);
//    }
//}
//

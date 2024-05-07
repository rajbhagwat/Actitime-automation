package actitimeTask;

import com.actitime.automation.common.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;

public class BrowserTabOperations {
    WebDriver driver;

//    @BeforeClass
//    public void setUp() {
//        BaseClass = new BaseClass();
//        CommonFunctions commonFunctions = new CommonFunctions();
//
////        driver = commonFunctions.launchBrowser("chrome");
//    }
BaseClass baseClass;

    @Parameters("browser")
    @Test
    public void performTabOperations(String browser) throws InterruptedException {
        baseClass = new BaseClass();
        driver = baseClass.launchBrowser(browser);
        driver.get("https://online.actitime.com/student11/login.do");
        Thread.sleep(5000);

        WebElement actiTimeLink = driver.findElement(By.partialLinkText("actiTIME"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();

        System.out.println("Title of login page: " + driver.getTitle());

        String loginWindowId = driver.getWindowHandle();
        System.out.println("Login Window Id: " + loginWindowId);

        Set<String> allWindowIds = driver.getWindowHandles();
        System.out.println(allWindowIds);

        for (String id : allWindowIds) {
            if (!id.equals(loginWindowId)) {
                System.out.println("Second Tab/Window Id: " + id);

                driver.switchTo().window(id);
                System.out.println("Second Tab Title : " + driver.getTitle());

                driver.close();

                driver.switchTo().window(loginWindowId);

                System.out.println("Current Page Title: " + driver.getTitle());
            }
        }
    }
}


//package actitimeTask;
//
//import commonfunction.CommonFunctions;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//
//import java.util.Set;
//
//public class BrowserTabOperations {
//    public static void main(String[] args) throws InterruptedException {
//        CommonFunctions commonFunctions = new CommonFunctions();
//        WebDriver driver = commonFunctions.launchBrowser("chrome");
//        driver.get("https://online.actitime.com/student11/login.do");
//        Thread.sleep(5000);
//
//        WebElement actiTimeLink = driver.findElement(By.partialLinkText("actiTIME"));
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.ARROW_DOWN).build().perform();
//        actions.keyUp(Keys.ARROW_DOWN).build().perform();
//        actions.keyDown(Keys.ENTER).build().perform();
//        actions.keyUp(Keys.ENTER).build().perform();
//
//        System.out.println("Title of login page: " + driver.getTitle());
//
//        String loginWindowId = driver.getWindowHandle();
//        System.out.println("Login Window Id: "+ loginWindowId);
//
//        Set<String> allWindowIds = driver.getWindowHandles();
//        System.out.println(allWindowIds);
//
//        for (String id : allWindowIds){
//            if (!id.equals(loginWindowId)){
//                System.out.println("Second Tab/Window Id: "+id);
//
//                driver.switchTo().window(id);
//                System.out.println("Second Tab Title : " +driver.getTitle());
//
//                driver.close();
//
//                driver.switchTo().window(loginWindowId);
//
//                System.out.println("Current Page Title: "+ driver.getTitle());
//            }
//        }
//    }
//}

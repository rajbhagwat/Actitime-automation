package actitimeTask;

import com.actitime.automation.common.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SetTaskDateTest {
    WebDriver driver;
    BaseClass baseclass;
    @Parameters("browser")
    @BeforeMethod
    public void setUp( String browser) {
//        CommonFunctions commonFunctions = new CommonFunctions();
        baseclass = new BaseClass();
//        driver = commonFunctions.launchBrowser("chrome");
        driver = baseclass.launchBrowser(browser);
        driver.get("https://online.actitime.com/cybersuccess7/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyTaskDateSetting() throws InterruptedException {
        SetTaskDate.SetTaskDateCalender setTaskDateCalender = new SetTaskDate.SetTaskDateCalender(driver);
        setTaskDateCalender.loginPage("cybersuccess@yopmail.com", "Test@1234");
        Thread.sleep(5000);
        setTaskDateCalender.addTask();
        setTaskDateCalender.verifyTask();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


//package actitimeTask;
//
//import commonfunction.CommonFunctions;
//import org.openqa.selenium.WebDriver;
//
//public class SetTaskDateTest {
//    public static void main(String[] args) throws InterruptedException {
//        CommonFunctions commonFunctions = new CommonFunctions();
//        WebDriver driver = commonFunctions.launchBrowser("chrome");
////        WebDriver driver = CommonFunctions.launchBrowser("chrome"); // Corrected method call
//        driver.get("https://online.actitime.com/cybersuccess7/");
//        driver.manage().window().maximize();
//        Thread.sleep(5000);
//
//        SetTaskDate.SetTaskDateCalender setTaskDateCalender = new SetTaskDate.SetTaskDateCalender(driver);
//        setTaskDateCalender.loginPage("cybersuccess@yopmail.com", "Test@1234");
//        Thread.sleep(5000);
//
//        setTaskDateCalender.addTask(); // Call the addTask method
//        setTaskDateCalender.verifyTask();
//    }
//
//}

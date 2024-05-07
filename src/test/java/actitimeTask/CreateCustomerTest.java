package actitimeTask;

import com.actitime.automation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class CreateCustomerTest {
    WebDriver driver;
    CreateCustomer createCustomer;
    BaseClass baseClass;

    @Parameters("browser")
    @BeforeTest
    public void setup(String browser) throws InterruptedException {
//        CommonFunctions launchBrowser = new CommonFunctions();
//        driver = launchBrowser.launchBrowser("chrome");
        baseClass=new BaseClass();
        driver = baseClass.launchBrowser(browser);
        driver.get("https://online.actitime.com/cybersuccess7/");
        driver.manage().window().maximize();

        createCustomer = new CreateCustomer(driver);
        createCustomer.loginToActitime("cybersuccess@yopmail.com", "Test@1234");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1, groups = "regression")
    public void testCreateDuplicateCustomer() throws Exception {
        createCustomer.createCustomer("Cyber Success", "Training Institute Pune");
        createCustomer.createCustomer("Cyber Success", "Training Institute Pune");
        String errorMsg = createCustomer.getErrorMessage();
        assertTrue(errorMsg.contains("Customer with the specified name already exists"),
                "Duplicate customer creation error message not displayed");
        System.out.println(errorMsg);
        Thread.sleep(3000);

//      Close the customer creation popup
        driver.findElement(By.id("customerLightBoxCloseButton")).click();

        // Handle alert if present
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            // No alert present, continue execution
        }
    }

    @Test(priority = 2, groups = "regression")
    public void testCreateCustomerWithEmptyName() throws Exception {
        createCustomer.createCustomer(" ", "Training Institute Pune");
        String errorMsg = createCustomer.getvalidationMessage();
        assertTrue(errorMsg.contains("Customer name cannot be empty"),
                "Empty customer name error message not displayed");
        System.out.println(errorMsg);

        //Close the customer creation popup
        driver.findElement(By.id("customerLightBoxCloseButton")).click();

        // Handle alert if present
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            // No alert present, continue execution
        }
    }

//    @Test(priority = 3, groups = "regression")
//    public void  testCreateCustomerWithEmptyFields() throws Exception {
//        createCustomer.createCustomer(" " , " ");
//        String errorMsg = createCustomer.getvalidationMessage();
//        assertTrue(errorMsg.contains("Customer name cannot be empty"),
//                "Empty customer name error message not displayed");
//        System.out.println(errorMsg);
//    }
}


//package actitimeTask;
//
//import actitimeTask.commonfunction.CommonFunctions;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//
//public class CreateCustomerTest {
//    public static void main(String[] args) throws Exception {
//        CommonFunctions launchBrowser = new CommonFunctions();
//        WebDriver driver = launchBrowser.launchBrowser("chrome");
//        driver.get("https://online.actitime.com/cybersuccess7/");
//        driver.manage().window().maximize();
//
//        CreateCustomer createCustomer = new CreateCustomer(driver);
//        createCustomer.loginToActitime("cybersuccess@yopmail.com", "Test@1234");
//        Thread.sleep(5000);
//
//        // Create a customer
//        createCustomer.createCustomer("Cyber Success", "Training Institute pune");
//        Thread.sleep(5000);
//
//        // Enter duplicate customer name data
//        createCustomer.createCustomer("Cyber Success", "Training Institute pune");
//        createCustomer.VerifyErrorMsg();
//        Thread.sleep(5000);
//
//
//        // Close the customer creation popup
//        WebElement closeButton = driver.findElement(By.id("customerLightBoxCloseButton"));
//        closeButton.click();
//
//        // Handle alert if present
//        try {
//            driver.switchTo().alert().accept();
//        } catch (Exception e) {
//            // No alert present, continue execution
//        }
//
//        //  customer name empty
//        createCustomer.createCustomer(" ", "Training Institute pune");
//        String errorMsg = createCustomer.getErrorMessage();
//        assert errorMsg.contains("Customer name cannot be empty") : "Empty customer name error message not displayed";
//
////        createCustomer.VerifyErrorMsg();
////        Thread.sleep(5000);
//
//        // Close the customer creation popup
//        driver.findElement(By.id("customerLightBoxCloseButton")).click();
//
//
//        // Handle alert if present
//        try {
//            driver.switchTo().alert().accept();
//        } catch (Exception e) {
//            // No alert present, continue execution
//        }
//
//
//        // Other test scenarios...
//
//        // Close the browser
////        driver.quit();
//    }
//    public static boolean verifyErrorMsg(String errorMsg) throws Exception {
//        if (errorMsg.equals("Customer with the specified name already exists")) {
//            System.out.println("Test Passed: Error message displayed correctly - Customer with the specified name already exists");
//        } else if (errorMsg.equals("Customer name cannot be empty")) {
//            System.out.println("Test Passed: Error message displayed correctly - Customer name cannot be empty");
//        } else {
//            throw new Exception("Test Failed: Error message is not as expected");
//        }
//        return false;
//    }
//
//}







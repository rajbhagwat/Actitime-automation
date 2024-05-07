package actitimeTask;

import com.actitime.automation.common.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ChangeStatusTest {
    WebDriver driver;
    ChangeStatus changeStatus;

    BaseClass baseClass;

    @Parameters("browser")
    @BeforeTest
    public void setup(String browser) throws InterruptedException {
        System.out.println("Browser: " + browser);
        baseClass = new BaseClass();
        driver = baseClass.launchBrowser(browser);
        driver.get("https://online.actitime.com/cybersuccess7/");
        driver.manage().window().maximize();

        changeStatus = new ChangeStatus(driver);
        changeStatus.login("cybersuccess@yopmail.com", "Test@1234");
    }

    @Test(priority = 1, groups = "regression")
    public void testChangeStatus() throws InterruptedException {
        changeStatus.changeStatus();
    }

    @Test(priority = 2, groups = "regression")
    public void testAddUser() {
        changeStatus.addUser("Cyber", "success", "cyber@gmail.com");
    }

    @Test(priority = 3, groups = "regression")
    public void testAssignTask() {
        changeStatus.assignTask();
    }
}


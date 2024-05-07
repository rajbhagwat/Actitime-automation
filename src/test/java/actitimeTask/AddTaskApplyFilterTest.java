package actitimeTask;

import com.actitime.automation.common.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddTaskApplyFilterTest {
    WebDriver driver;
    AddApplyFilter createNewTask;
    //    Actions typeOfWorkDropdown, testingOption ;
    BaseClass baseclass;

    @Parameters("browser")
    @BeforeTest(groups = "regression")
    public void setup(String browser) throws InterruptedException {
        baseclass = new BaseClass();
//        CommonFunctions launchBrowser = new CommonFunctions();
//        driver = launchBrowser.launchBrowser("chrome");
        driver = baseclass.launchBrowser(browser);
        driver.get("https://online.actitime.com/cybersuccess7/");
        driver.manage().window().maximize();
        Thread.sleep(10000);

        createNewTask = new AddApplyFilter(driver);
        createNewTask.loginToActitime("cybersuccess@yopmail.com", "Test@1234");

    }
//    @AfterTest(groups ="regression")
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test(priority = 1, groups = "regression")
    public void testCreateNewTask() throws Exception {
        // Create new task
        createNewTask.createNewTask("Mobile Testing");
        Thread.sleep(5000);

//        // Locate and interact with dropdown
//        WebElement typeOfWorkDropdown = driver.findElement(By.xpath("(//div[@class='typeOfWorkButton editable'])[13]"));
//        typeOfWorkDropdown.click();
//
//        // Select "Testing" from dropdown options
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement testingOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='Testing']")));
//        testingOption.click();
    }
//    @Test(priority = 1, groups = "regression")
//    public void testCreateNewTask() throws Exception {
//        //Actions actions = new Actions(driver);
//
//        createNewTask.createNewTask("Mobile Testing");
//        Thread.sleep(5000);
//        WebElement typeOfWorkDropdown = driver.findElement(By.xpath("(//div[@class='typeOfWorkButton editable'])[13]"));
//        Thread.sleep(3000);
//        typeOfWorkDropdown.click(); // Open the dropdown
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//option[text()='Testing']")).click();
//       actions.moveToElement(typeOfWorkButton).click().perform();


}

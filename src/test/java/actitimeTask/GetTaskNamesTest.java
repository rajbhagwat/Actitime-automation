package actitimeTask;

import com.actitime.automation.common.PropertyHandling;
import com.actitime.automation.pages.LoginPage;
import com.actitime.automation.pages.TaskPage;
import com.actitime.automation.common.BaseClass;
import com.actitime.automation.common.CommonFunctions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.*;

import java.util.List;


public class GetTaskNamesTest extends BaseClass {
    WebDriver driver;
    LoginPage loginPage;
    CommonFunctions commonFunctions;
    TaskPage taskPage;
    PropertyHandling propertyHandling;
//    BaseClass baseClass;

    //    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        propertyHandling = new PropertyHandling("config.properties");
        String browser = propertyHandling.getProperty("browser");
        String url = propertyHandling.getProperty("url");
        driver = launchBrowser("edge");
        loginPage = new LoginPage(driver);
        driver.get(url);

//        baseClass=new BaseClass();
//        driver = baseClass.launchBrowser(browser);
        taskPage = new TaskPage(driver);
//        driver.get("https://online.actitime.com/cybersuccess7/");
        commonFunctions = new CommonFunctions(driver);
    }

    @BeforeMethod
    public void login() {
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        loginPage.login(username,password);
//        loginPage.login("cybersuccess@yopmail.com", "Test@1234");
    }

    @Test
    public void printTaskNames() {
        commonFunctions.click(taskPage.taskModule);
        commonFunctions.click(taskPage.project);
        List<WebElement> taskNames = driver.findElements((By) taskPage.taskList);
        for (WebElement element : taskNames) {
            if (element.isDisplayed()) {
                System.out.println(element.getText());
            } else {
                Actions actions = new Actions(driver);
                actions.scrollToElement(element).build().perform();
                System.out.println(element.getText());
            }
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

//    public static void main(String[] args) throws InterruptedException, AWTException {
//
//        CommonFunctions launchBrowser = new CommonFunctions();
//        WebDriver driver = launchBrowser.launchBrowser("chrome");
//        driver.get("https://online.actitime.com/student11/login.do");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//
//        Actions actions = new Actions(driver);
//        actions.sendKeys(driver.findElement(By.id("username")), "bhagwatraj45@gmail.com").build().perform();
//        actions.click(driver.findElement(By.name("pwd"))).sendKeys("Test@1234").build().perform();
//        actions.moveToElement(driver.findElement(By.id("loginButton"))).click().build().perform();
//        Thread.sleep(5000);
//
//        WebElement TaskTab = driver.findElement(By.xpath("//div[text()='Tasks']"));
//        TaskTab.click();
//
//        actions.click(driver.findElement(By.xpath("(//div[text()='Spaceship building'])[1]"))).build().perform();
//        Thread.sleep(5000);
//        List<WebElement> taskName = driver.findElements(By.xpath("//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']"));
//        System.out.println(taskName.size());
//        for (WebElement element : taskName) {
//            if (element.isDisplayed()) {
//                System.out.println(element.getText());
//            } else {
//                actions.scrollToElement(element).build().perform();
//                System.out.println(element.getText());
//            }
//        }
//
//        Thread.sleep(10000);
//        actions.click(driver.findElement(By.xpath("(//div[@class='atNextMount'])//span[text()='Statuses']"))).build().perform();
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath("(//input[@type='radio'])[2]"))).build().perform();
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath("(//span[contains(@class, 'components-Checkbox-checkbox')])[2]"))).build().perform();
//        Thread.sleep(2000);
//        Robot robot = new Robot();
//        robot.mouseWheel(50);
//        Thread.sleep(3000);
//        WebElement applyButton = driver.findElement(By.xpath("//div[text()='Apply']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyButton);
//        applyButton.click();
//        Thread.sleep(2000);
//
//
//        actions.click(driver.findElement(By.xpath("(//div[@class='img'])[1]"))).build().perform();
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath("//div[@class='moveTo button']"))).build().perform();
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath("(//div[@class='dropdownButton'])[3]"))).build().perform();
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath("//div[@class='searchItemList']//div[1]"))).build().perform();
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath("(//div[@class='dropdownButton'])[4]"))).build().perform();
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath("(//div[text()='Spaceship testing'])[2]"))).build().perform();
//        Thread.sleep(2000);
//        actions.moveToElement(driver.findElement(By.xpath("(//div[text()='Move'])[3]"))).click().build().perform();
//        Thread.sleep(5000);
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast ']//span[1]")));
//
//        // Get the text of the popup message
//        String popupMessage = toastElement.getText().trim();
//
//        // Print the popup message
//        System.out.println("Popup Message: " + popupMessage);
//
//        // Perform assertion or further actions based on the popup message
//        String expectedMessage = "tasks have been moved to project 'Spaceship testing'";
//        if (popupMessage.contains(expectedMessage)) {
//            System.out.println("Test case passed");
//        } else {
//            System.out.println("Test case failed");
//        }
//last commit above code 07/05/2024

//        String actConMsg = driver.findElement(By.xpath("//div[@class='toast ']//span[1]")).getText();
//        String expConMsg = "tasks have been moved to project 'Spaceship testing'";
//        System.out.println(actConMsg);
//
//        if (actConMsg.equals(expConMsg))
//            System.out.println("Test case passed");
//        else
//            System.out.println("Test case failed");


//       // After performing actions, wait for toast alert
//        Thread.sleep(5000); // Adjust as needed to ensure the toast alert is visible
//        WebElement toastMessageElement = driver.findElement(By.xpath("//div[@class='toast ']//span[1]"));
//        String toastMessage = toastMessageElement.getText();
//
//
//        // Verify the success message in the toast alert
//        if (toastMessage.contains("tasks have been moved to project 'Spaceship building'")) {
//            System.out.println("Tasks were moved successfully to 'Spaceship building' category.");
//        } else {
//            System.out.println("Tasks were not moved successfully or verification failed.");
//        }



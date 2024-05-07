package automation;

import com.actitime.automation.common.BaseClass;
import com.actitime.automation.common.CommonFunctions;
import com.orangehrm.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest {
    WebDriver driver;
    CommonFunctions commonFunctions;
     BaseClass baseclass;
    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        baseclass =new BaseClass();
       // commonFunctions = new CommonFunctions();
        driver = baseclass.launchBrowser(browser);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }


    @Test(dataProvider = "getLoginTestData")
    public void verifyLogin(Object username, Object password, Object status) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username.toString(), password.toString());

        if (Boolean.parseBoolean(status.toString())) {
            // Successful login scenario
            commonFunctions.waitForElementToPresent(driver, driver.findElement(By.xpath("//h6[text()='Dashboard']")));
            WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
            String dashboardText = dashboard.getText();
            System.out.println(dashboardText);
            if (dashboardText.equals("Dashboard")) {
                System.out.println("Successfully landed on dashboard module");
            } else {
                throw new Exception("Unable to login to application");
            }
            loginPage.logout();
        } else {
            // Handling invalid login scenarios
            try {
                commonFunctions.waitForElementToPresent(driver, driver.findElement(By.xpath("//*[text()='Invalid credentials']")));
                WebElement errorMsgElement = driver.findElement(By.xpath("//*[text()='Invalid credentials']"));
                String errorMsg = errorMsgElement.getText();
                loginPage.verifyErrorMsg(errorMsg);
            } catch (Exception e) {
                // Handle error message for invalid credentials not found
            }
            try {
                commonFunctions.waitForElementToPresent(driver, driver.findElement(By.xpath("//*[text()='Required']")));
                WebElement vMsgElement = driver.findElement(By.xpath("//*[text()='Required']"));
                String vMsg = vMsgElement.getText();
                loginPage.validationMsg(vMsg);
            } catch (Exception e) {
                // Continue execution
            }
            driver.navigate().refresh();
        }
    }


    @DataProvider
    public Object[][] getLoginTestData() {
        Object[][] obj = new Object[][]{
                {"Admin", "admin123", true},
                {"Admin", "admin", false},
                {"!@#$%", "admin", false},
                {"Admin", "!@$%&", false},
                {"A_d_m_i_n", "admin", false},
                {"Admin", "1234", false},
                {"ADMIN", "ADMIN123", false},
                {"Admin", "", false},
                {"", "admin123", false},
                {"", "", false}
        };
        return obj;
    }
}

//    public static void main(String[] args) throws Exception {
//        //Launch the browser
//        ChromeOptions options = new ChromeOptions(); // capablities
////        options.setBrowserVersion("118");
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//
//        //navigate to url
//        driver.get("https://opensource-demo.orangehrmlive.com/");
//        driver.manage().window().maximize();;
//        Thread.sleep(10000);
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        //perform login operation
//        loginPage.login("Admin", "admin123");
//        Thread.sleep(10000);
//
//        //locate the dashboard module is loaded completely
//        WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
//        String dashboardText = dashboard.getText();
//        System.out.println(dashboardText);
//
//        //verify the dashboardText value
//        if (dashboardText.equals("Dashboard")) {
//            System.out.println("Successfully landed on dashboard module");
//        }else {
//            throw new  Exception("unable login to application");
//        }
//
//        //perform logout operation
//        loginPage.logout();
//        Thread.sleep(5000);
//
//        //enter invalid username and valid password
//        loginPage.login("admin24252156", "admin123");
//        Thread.sleep(10000);
//        String errorMsg = driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
//
//        loginPage.verifyErrorMsg(errorMsg);
//        driver.navigate().refresh();
//        Thread.sleep(5000);
//
//        //enter valid username and invalid password
//        loginPage.login("Admin","322456");
//        Thread.sleep(10000);
//        errorMsg=driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
//        Thread.sleep(5000);
//
//        //check case sensitive or not
//        loginPage.login("ADMIN","ADMIN123");
//        Thread.sleep(10000);
//        errorMsg=driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
//        Thread.sleep(5000);
//
//        //enter special character
//        loginPage.login("Admin@123","a@$%123");
//        Thread.sleep(10000);
//        errorMsg=driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
//        Thread.sleep(5000);
//
//        //check blank values
//        loginPage.login("","");
//        Thread.sleep(10000);
//        String vMsg = driver.findElement(By.xpath("//*[text()='Required']")).getText();
//        loginPage.validationMsg(vMsg);
////        vMsg=driver.findElement(By.xpath("//*[text()='Required']")).getText();
//
//    }
//}

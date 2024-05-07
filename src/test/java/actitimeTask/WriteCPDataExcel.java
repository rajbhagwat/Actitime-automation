package actitimeTask;

import com.actitime.automation.pages.LoginPage;
import com.actitime.automation.common.BaseClass;
import com.actitime.automation.common.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class WriteCPDataExcel extends BaseClass {
    WebDriver driver;
    LoginPage loginPage;
    CommonFunctions commonFunctions;

    @BeforeClass
    public void setup(){
        driver = launchBrowser("edge");
        loginPage = new LoginPage(driver);
        driver.get("https://online.actitime.com/student11/login.do");
        commonFunctions = new CommonFunctions(driver);
    }
    @BeforeMethod
    public void login(){
        loginPage.login("bhagwatraj45@gmail.com" , "Test@1234");

    }

}


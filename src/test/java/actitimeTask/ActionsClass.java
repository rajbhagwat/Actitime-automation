package actitimeTask;

import com.orangehrm.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
    public static void main(String[] args) throws Exception {
        WebDriver driver = launchBrowser("chrome");
        driver.get("https://online.actitime.com/cybersuccess7");
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.id("username")),"cybersuccess@yopmail.com").build().perform();
        actions.sendKeys(driver.findElement(By.name("pwd")),"Test@1234").build().perform();
        actions.moveToElement(driver.findElement(By.id("loginButton"))).click().build().perform();
    }

    public static WebDriver launchBrowser(String browserName) {
        WebDriver driver;
        if(browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            // Add any necessary Chrome options here
            driver = new ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
        return driver;
    }

}

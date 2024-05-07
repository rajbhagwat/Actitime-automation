package automation;

import com.orangehrm.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DropDownWithoutSelectClass {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("118");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        //navigate  to URL
        driver.get("https://opensource-demo.orangehrmlive.com/");
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(10000);
        loginPage.login("Admin","admin123");
        //wait for 10 sec to load on dashboard
        Thread.sleep(5000);

        //click on PIM module
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(5000);
        //click on job title dropdown
        driver.findElement(By.xpath("//div[@class='oxd-form-row']//div[6]//i")).click();
        //select Automation Tester value from dropdown
        driver.findElement(By.xpath("//div[@role='listbox']//div[2]//span")).click();
    }
}

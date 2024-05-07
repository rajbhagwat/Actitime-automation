package automation;

import com.orangehrm.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddEmployee {
    WebDriver driver;
    public void addCustomerTest1() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        LoginPage loginPage = new LoginPage(driver);

        String title = driver.getTitle();
        System.out.println(title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(5000);


    }
}

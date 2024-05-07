package automation;

import com.orangehrm.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class webDriverMethod {
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("118");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

        String title = driver.getTitle();
        System.out.println(title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(10000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin","admin123");
        Thread.sleep(10000);

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(5000);

//        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
//        Thread.sleep(5000);

        WebElement searchEmpName = driver.findElement(By.xpath("//label[text()='Employee Name']/following::input[1]"));
        searchEmpName.sendKeys("Cyber Success");
//        searchEmpName.click();
//        searchEmpName.clear();
        Thread.sleep(5000);

        //enter employee id
        WebElement Empid = driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]"));
        Empid.sendKeys("0540");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //get alert msg
        String actConfirmationMsg = driver.findElement(By.xpath("//*[@id='oxd-toaster_1']")).getText();

        String expConfirmationMsg = "No Records Found";
        if (actConfirmationMsg.equals(expConfirmationMsg))System.out.println("test passed");
        else System.out.println("failed");

        driver.findElement(By.xpath("//*[text()=' Add ']")).click();

//        driver.findElement(By.xpath("//label[text()='Employment Status']/following::i[1]")).click();
//        driver.findElement(By.xpath("//div[text()='Full-Time Permanent']")).click();

//        //locate username textbox
//        WebElement username = driver.findElement(By.name("username"));
//        username.sendKeys("username");
//        Thread.sleep(2000);
//        //call click method
//        username.click();
//        //clear the username text box
//        username.clear();

        driver.get("https://www.amazon.in/");
        WebElement searchtextbox = driver.findElement(By.id("twotabsearchtextbox"));
        String placeholder = searchtextbox.getAttribute("placeholder");
        System.out.println(placeholder);
        WebElement signIn = driver.findElement(By.id("nav-link-accountList"));
        String href = signIn.getAttribute("href");
        System.out.println(href);

        String tagName = signIn.getTagName();
        System.out.println("TagName: " + tagName);

        //isDisplayed()
        //if the search box on amazon website is display then enter Mobile text
        if (searchtextbox.isDisplayed()){
            searchtextbox.sendKeys("Mobile");
            Thread.sleep(1000);
            searchtextbox.clear();
            Thread.sleep(2000);
            driver.quit();
        }



    }
}

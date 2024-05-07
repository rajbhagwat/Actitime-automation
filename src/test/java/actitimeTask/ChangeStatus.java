package actitimeTask;

import com.actitime.automation.common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangeStatus {
    WebDriver driver;
    CommonFunctions commonFunctions;
    public ChangeStatus(WebDriver driver) {
        this.driver = driver;
    }


    public void login(String username, String password) throws InterruptedException {
        commonFunctions = new CommonFunctions(driver);
        commonFunctions.waitForElementToPresent(driver, driver.findElement(By.id("username")));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(5000);
    }
    public void changeStatus() throws InterruptedException {
        WebElement tasksContainer = driver.findElement(By.id("container_tasks"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tasksContainer);
        tasksContainer.click();

        driver.findElement(By.xpath("(//div[@class='img'])[2]")).click();
        driver.findElement(By.xpath("//div[text()='Change Status']")).click();

        //status planning
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mainContainer']//div[@class='name']"))).click();
        //change status apply click
        driver.findElement(By.xpath("(//span[@class='buttonTitle'])[3]")).click();
    }

        public void addUser(String firstName, String lastName, String email){
            commonFunctions.waitForElementToPresent(driver, driver.findElement(By.xpath("//div[@class='components_button withPlusIcon']")));
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='components_button withPlusIcon']"))).click();
            driver.findElement(By.xpath("//div[@class='components_button withPlusIcon']")).click();

            //Add new user
//        driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys(firstName);
//        driver.findElement(By.id("createUserPanel_lastNameEmptyError")).sendKeys(lastName);
//        driver.findElement(By.id("createUserPanel_lastNameEmptyError")).sendKeys(email);
//        //click on dropdown
//        driver.findElement(By.xpath("(//div[@class='downIcon'])[5]")).click();
//        driver.findElement(By.xpath("(//div[@class='itemsContainer'])[1]")).click();
//        //select quality control
//        driver.findElement(By.xpath("(//div[text()='Quality Control'])[7]")).click();
//        //click on save button
//        driver.findElement(By.xpath("(//div[@class='components_button_label'])[4]")).click();

            // for edit user
            driver.findElement(By.id("editUserPanel_firstNameField")).sendKeys(firstName);
            driver.findElement(By.id("editUserPanel_lastNameField")).sendKeys(lastName);
            driver.findElement(By.id("editUserPanel_emailField")).sendKeys(email);

            driver.findElement(By.xpath("(//div[@class='downIcon'])[5]")).click();

            //panel close button
            driver.findElement(By.xpath("(//div[@class='hideButton_panelContainer'])[1]")).click();
            driver.navigate().back();

        }

        public void assignTask(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Spaceship testing'])[1]")));
            element.click();

            driver.findElement(By.xpath("(//div[text()='Spaceship testing'])[1]")).click();

            driver.findElement(By.xpath("(//div[@class='img'])[3]")).click();
            driver.findElement(By.xpath("//div[@class='assignTo button']")).click();


            driver.findElement(By.xpath("//div[@class='mainContainer']//div[@class='arrow']")).click();
            driver.findElement(By.xpath("(//div[@class='content']//span[@class='checkbox'])[6]")).click();

            //close
            driver.findElement(By.xpath("//div[@id='ext-comp-1035']")).click();
            driver.findElement(By.xpath("//span[text()='Assign']")).click();

        }

}

package actitimeTask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class AddApplyFilter {
    WebDriver driver;
    public AddApplyFilter(WebDriver driver) {

        this.driver = driver;
    }

    public void loginToActitime(String username, String password) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(5000);
    }
    public void createNewTask(String testFilter) throws InterruptedException, AWTException {
        Actions actions = new Actions(driver);
        WebElement tasksContainer = driver.findElement(By.id("container_tasks"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tasksContainer);
        tasksContainer.click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//div[@class='addNewButton']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='item createNewTasks']")).click();
        Thread.sleep(2000);

       driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[1]")).sendKeys(testFilter);
//        TaskNameField.sendKeys(testFilter);
        Thread.sleep(2000);

        //type of work
//        driver.findElement(By.xpath("//div[@title='Type of Work']//following::div[2]")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//span[text()='testing ']")).click();
//        Thread.sleep(3000);

        driver.findElement(By.xpath("(//div[@class='components_button_label'])[17]")).click();
        Thread.sleep(5000);
        Thread.sleep(10000);
        actions.click(driver.findElement(By.xpath("(//div[@class='atNextMount'])//span[text()='Statuses']"))).build().perform();
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath("(//input[@type='radio'])[2]"))).build().perform();
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath("(//span[contains(@class, 'components-Checkbox-checkbox')])[2]"))).build().perform();
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.mouseWheel(50);
        Thread.sleep(3000);
        WebElement applyButton = driver.findElement(By.xpath("//div[text()='Apply']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyButton);
        applyButton.click();
        Thread.sleep(2000);
    }

}

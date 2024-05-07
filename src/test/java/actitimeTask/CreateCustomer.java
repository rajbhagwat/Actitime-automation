package actitimeTask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CreateCustomer {

    WebDriver driver;

    public CreateCustomer(WebDriver driver) {

        this.driver = driver;
    }

    public void loginToActitime(String username, String password) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(5000);
    }

    public void createCustomer(String customerName, String description) throws Exception {
        // Navigate to Customers module
//        driver.findElement(By.id("container_tasks")).click();

        WebElement tasksContainer = driver.findElement(By.id("container_tasks"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tasksContainer);
        tasksContainer.click();

        Thread.sleep(3000);

        // Click on New Customer button
        driver.findElement(By.xpath("//div[@class='addNewButton']")).click();
        Thread.sleep(2000);

        // Click on Create New Customer option
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        Thread.sleep(2000);

        // Fill in customer details
        WebElement customerNameField = driver.findElement(By.xpath("//div[@class='customerNameDiv']//input"));
        customerNameField.clear();
        customerNameField.sendKeys(customerName);
        Thread.sleep(1000);

        WebElement descriptionField = driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']"));
        descriptionField.sendKeys(description);
        Thread.sleep(5000);

//        //select existing customer project
//        driver.findElement(By.xpath("(//div[@class='dropdownButton'])[15]")).click();
//        driver.findElement(By.xpath("(//div[text()='Big Bang Company'])[2]")).click();


        // Click on Create Customer button
        driver.findElement(By.xpath("//div[@class='commitButtonPlaceHolder']/div")).click();
        Thread.sleep(5000);

        // Add verification code here
        //div[@class='errorMessageBox']


    }

    public String getErrorMessage() {
        // Wait for the error message to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='customerNameDiv'])//div[2]")));
        return errorMsgElement.getText();
    }

    public String getvalidationMessage() {
        // Wait for the error message to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement validationMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='customerNameDiv'])//div[1]")));
        return validationMsgElement.getText();
    }

//    public void VerifyErrorMsg() throws Exception {
//        // Verify error message
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement errorMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='customerNameDiv']//div[2]")));
//        String errorMsg = errorMsgElement.getText();
//        System.out.println(verifyErrorMsg(errorMsg));
//        verifyErrorMsg(errorMsg);
//        Thread.sleep(5000);
//
//    }


}

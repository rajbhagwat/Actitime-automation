package actitimeTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class SetTaskDate {

    public static class SetTaskDateCalender {
        private WebDriver driver;

        public SetTaskDateCalender(WebDriver driver) {

            this.driver = driver;
        }

        public void loginPage(String username, String password) {
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.name("pwd"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
            loginButton.click();
        }

        public void addTask() throws InterruptedException {
            WebElement containerTasks = driver.findElement(By.xpath("//div[@id='container_tasks']"));
            containerTasks.click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("(//div[text()='Spaceship testing'])[1]")).click();
            Thread.sleep(2000);
            WebElement addTaskButton = driver.findElement(By.xpath("(//div[text()='Add Task'])[1]"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(addTaskButton));
            addTaskButton.click();

            String getName="Raj";
            WebElement sendText = driver.findElement(By.xpath("(//input[@placeholder='Enter Task Name'])[2]"));
            sendText.sendKeys(getName);
            System.out.println(getName);
            Thread.sleep(3000);

//           //type of work
            driver.findElement(By.xpath("//div[@title='Type of Work']//following::div[2]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[text()='testing ']")).click();
            Thread.sleep(3000);
            //set priority
            driver.findElement(By.xpath("//div[@title='Priority']//following::div[2]")).click();
            Thread.sleep(3000);
            //critical
            driver.findElement(By.xpath("//div[@role='list']//following::span[2]")).click();
            Thread.sleep(3000);

            //value
            driver.findElement(By.xpath("(//div[@class='classicBridge-taskPanel-DetailWrapper-element--FwpOD0CA'])[5]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@role='list']//following::span[text()='Important']")).click();
            Thread.sleep(2000);
            //custom
            driver.findElement(By.xpath("//div[@title='Budget, $ (custom field)']//following::input[1]")).sendKeys("500");
            Thread.sleep(5000);
            //budget
            driver.findElement(By.xpath("//div[@title='Code (custom field)']//following::input[1]")).sendKeys("300");
            Thread.sleep(3000);
            //click on add task button
            driver.findElement(By.xpath("(//div[text()='Add Task'])[3]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@class='components-SearchInput-searchInput--dlqxQrkh components-SearchInput-empty--TyuRV3fG']")).sendKeys("Raj");
            Thread.sleep(3000);


        }

        public  void verifyTask() throws InterruptedException {
            WebElement searchText = driver.findElement(By.xpath("//span[@class='highlightToken']"));
            String resultText = searchText.getText();
            System.out.println(resultText);

            String getName="Raj";
            if (resultText.equals(getName)){
                System.out.println("task is verified");
            }else {
                System.out.println("task not match");
            }

            driver.findElement(By.xpath("//div[@class='deadlineEditor atNextMount']/div[1]/div")).click();
            Thread.sleep(5000);

            int dayOfMonth= LocalDateTime.now().getDayOfMonth();
            System.out.println("day of month is" + dayOfMonth);

            String monthName = LocalDateTime.now().getMonth().name();
            int b= monthName.length();
            String actualMonth = monthName.charAt(0) + monthName.substring(1,b).toLowerCase();
            System.out.println(actualMonth);
            Thread.sleep(3000);

            String monthAddress="//td[starts-with(@title, '" + actualMonth + "')]";

//            System.out.println(monthAddress);
            List<WebElement> dates=driver.findElements(By.xpath(monthAddress));
            Thread.sleep(2000);
            for (WebElement getDate:dates){
                String currentMonth = getDate.getText();
                System.out.println(currentMonth);
                if (currentMonth.equals(String.valueOf(dayOfMonth)))
                {
                    getDate.click();
                    Thread.sleep(2000);
                    break;
                }
            }
        }
    }
}

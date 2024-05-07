package com.orangehrm;

import com.actitime.automation.common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    CommonFunctions commonFunctions;

    public LoginPage(WebDriver driver) { this.driver = driver;}

    public void login( String username, String password){
        commonFunctions = new CommonFunctions(driver);
        commonFunctions.waitForElementToPresent(driver.findElement(by));
//        commonFunctions.waitForElementToPresent(driver, By.name("username").findElement(driver));
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
        public void logout() {
            driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']/following-sibling::i")).click();
            driver.findElement(By.xpath("//a[text()='Logout']")).click();


        }

        public void verifyErrorMsg(String msg) throws Exception {
            if(msg.equals("Invalid credentials")){
                System.out.println("Test Passed with invalid credentials");
            }else{
                throw new Exception(("Test Failed: error meassage is not displyed on login page with invalid credentials"));
            }

        }
         public void validationMsg(String msg) throws Exception {
        if(msg.equals("Required")){
            System.out.println("Test Passed with Required credentials");

            }else {
            throw new Exception(("Test Failed: error meassage is not displyed on login page with invalid credentials"));
            }
        }

    public void tostMsg(String msg) throws Exception {
        if(msg.equals("Info")){
            System.out.println("Test Passed with Required credentials");

        }else {
            throw new Exception(("Test Failed: error meassage is not displyed on login page with invalid credentials"));
        }
    }


}



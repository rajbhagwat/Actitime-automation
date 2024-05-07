package com.actitime.automation.pages;

import com.actitime.automation.common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    CommonFunctions commonFunctions;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
//        PageFactory.initElements(driver, LoginPage.class);
    }
    public By username = By.id("username");
//    @FindBy(id="username")
//    WebElement username;

    public By password = By.name("pwd");
//    public By loginButton = By.id("loginButton");
    @FindBy(id = "loginButton")
    WebElement loginButton;
    public  void  login(String username, String password ){
        commonFunctions = new CommonFunctions(driver);
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        commonFunctions.click(loginButton);
    }
}

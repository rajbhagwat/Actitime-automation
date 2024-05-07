package com.actitime.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TaskPage {
    WebDriver driver;
    public TaskPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public By taskModule = By.id("container_tasks");
    public By project = By.xpath("(//div[text()='Spaceship building'])[1]");
   // public By taskList = By.xpath("//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']");
    @FindBy(xpath = "//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']")
    public List<WebElement> taskList;

    @FindBy(xpath = "")
    public WebElement checkBox;
}

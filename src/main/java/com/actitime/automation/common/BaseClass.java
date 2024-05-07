package com.actitime.automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BaseClass {
    WebDriver driver;
    public WebDriver launchBrowser(String browserName) {

        switch (browserName) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.setBrowserVersion("stable");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setBrowserVersion("stable");

                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setBrowserVersion("stable");
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        driver.manage().window().maximize();
        return driver;

    }
}

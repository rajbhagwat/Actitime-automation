package amazon;

import com.actitime.automation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FindBrokenImgAmazon {
    WebDriver driver;
    BaseClass baseclass;
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
//        CommonFunctions commonFunctions = new CommonFunctions();
        baseclass = new BaseClass();
//        driver = commonFunctions.launchBrowser("chrome");
        driver = baseclass.launchBrowser(browser);
        driver.get("https://www.amazon.in/");
    }

    @Test
    public void testFindBrokenImages() {
        List<WebElement> webElementsList = driver.findElements(By.tagName("img"));

        for (WebElement element : webElementsList) {
            String imageURL = element.getAttribute("src");
            if (imageURL != null && !imageURL.isEmpty()) {
                try {
                    URL url = new URL(imageURL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    // Set request method to HEAD to reduce response body
                    connection.setRequestMethod("HEAD");
                    // Get the response code
                    int statusCode = connection.getResponseCode();
                    if (statusCode != 200) {
                        System.out.println("Broken Image Found: " + statusCode + " " + imageURL);
                    }
                    connection.disconnect();
                } catch (IOException e) {
                    System.out.println("Error occurred while checking image: " + imageURL);
                }
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


//package amazon;
//
//import commonfunction.CommonFunctions;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.util.List;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class FindBrokenImg {
//    public static void main(String[] args) {
//        CommonFunctions commonFunctions = new CommonFunctions();
//        WebDriver driver = commonFunctions.launchBrowser("chrome");
//        driver.get("https://www.amazon.in/");
//
//        List<WebElement> webElementsList = driver.findElements(By.tagName("img"));
//
//        for (WebElement element : webElementsList) {
//            String imageURL = element.getAttribute("src");
//            if (imageURL != null && !imageURL.isEmpty()) {
//                try {
//                    URL url = new URL(imageURL);
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    // Set request method to HEAD to reduce response body
//                    connection.setRequestMethod("HEAD");
//                    // Get the response code
//                    int statusCode = connection.getResponseCode();
//                    if (statusCode != 200) {
//                        System.out.println("Broken Image Found: " +statusCode + " " + imageURL);
//                    }
//                    connection.disconnect();
//                } catch (IOException e) {
//                    System.out.println("Error occurred while checking image: " + imageURL);
//                }
//            }
//        }
//
//        // Close the WebDriver session
//        driver.quit();
//    }
//}


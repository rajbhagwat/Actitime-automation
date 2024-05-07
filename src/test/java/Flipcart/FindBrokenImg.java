package Flipcart;

import com.actitime.automation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FindBrokenImg {
    WebDriver driver;
    BaseClass baseclass;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
//        CommonFunctions commonFunctions = new CommonFunctions();
        baseclass = new BaseClass();
//        driver = commonFunctions.launchBrowser("chrome");
        driver = baseclass.launchBrowser(browser);
        driver.get("https://www.flipkart.com/");
    }

    @Test
    public void testFindBrokenImages() {
        List<WebElement> imgElements = driver.findElements(By.tagName("img"));
        System.out.println("Total Images: " + imgElements.size());

        for (WebElement imgElement : imgElements) {
            String imageURL = imgElement.getAttribute("src");
            if (imageURL != null && !imageURL.isEmpty()) {
                try {
                    URL url = new URL(imageURL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("HEAD");
                    int responseCode = connection.getResponseCode();
                    if (responseCode != 200) {
                        System.out.println("Broken Image Found: " + imageURL);
                    }
                    connection.disconnect();
                } catch (IOException e) {
                    System.out.println("Error occurred while checking image: " + imageURL);
                }
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


//package Flipcart;
//
//import commonfunction.CommonFunctions;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.List;
//
//public class FindBrokenImg {
//    public static void main(String[] args) {
//        CommonFunctions commonFunctions = new CommonFunctions();
//        WebDriver driver = commonFunctions.launchBrowser("chrome");
//        driver.get("https://www.flipkart.com/");
//
//        List<WebElement> imgElements = driver.findElements(By.tagName("img"));
//
//        System.out.println("Total Images: " + imgElements.size());
//
//        for (WebElement imgElement : imgElements) {
//            String imageURL = imgElement.getAttribute("src");
//            if (imageURL != null && !imageURL.isEmpty()) {
//                try {
//                    URL url = new URL(imageURL);
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("HEAD");
//                    int responseCode = connection.getResponseCode();
//                    if (responseCode != 200) {
//                        System.out.println("Broken Image Found: " + imageURL);
//                    }
//                    connection.disconnect();
//                } catch (IOException e) {
//                    System.out.println("Error occurred while checking image: " + imageURL);
//                }
//            }
//        }
//
//        driver.quit();
//    }
//}

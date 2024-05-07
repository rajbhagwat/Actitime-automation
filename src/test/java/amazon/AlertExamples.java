package amazon;

import com.actitime.automation.common.BaseClass;
import com.actitime.automation.common.CommonFunctions;
import org.openqa.selenium.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AlertExamples {
     CommonFunctions commonFunctions;
     WebDriver driver;
    BaseClass baseclass;
    @Parameters("browser")
     @Test
    public void alert(String browser){
        baseclass =new BaseClass();
//        commonFunctions = new CommonFunctions();
//        driver = commonFunctions.launchBrowser("edge");
        driver = baseclass.launchBrowser(browser);
        driver.get("https://amazon.in/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

//        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
//         js.executeAsyncScript("window.scrollBy(0, document.body.scrollHeight);");
         js.executeScript("arguments[0].scrollIntoView();", searchBox);

//         js.executeScript("arguments[0].click();", luckButton);

// Corrected setting value to the search box
         js.executeScript("arguments[0].value = 'Samsung Mobiles';", searchBox);

         js.executeScript("alert('Hello Cyber success!');");
  /*       js.executeScript("confirm('Hello Cyber success!');");
         js.executeScript("prompt('Hello Cyber success!');");

         Alert alert = driver.switchTo().alert();
         alert.sendKeys("This is sample text"); */
/*       alert.dismiss();

         String text = alert.getText();
         System.out.println(text);
         alert.accept(); */

    }
}

package InstagramAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class FacebookAutomation {

        // Declaring the Webdriver
        public static WebDriver driver;

        public static void main(String[] args) throws InterruptedException, IOException, AWTException {

            //Get the Instagram page
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.facebook.com/");
            // Get the current window handle (parent window)
            String parentWindowHandle = driver.getWindowHandle();
            int waitTime = 5;
            Duration duration = Duration.ofSeconds(waitTime);
            Thread.sleep(500);

            driver.findElement(By.id("email")).sendKeys("testingtestdatablz@gmail.com");
            driver.findElement(By.id("pass")).sendKeys("testing123");
            driver.findElement(By.name("login")).click();
        }
}

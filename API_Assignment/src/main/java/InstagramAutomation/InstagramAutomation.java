package InstagramAutomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class InstagramAutomation {
    // Declaring the Webdriver
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {

        //Get the Instagram page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com/");
        // Get the current window handle (parent window)
        String parentWindowHandle = driver.getWindowHandle();
        int waitTime = 5;
        Duration duration = Duration.ofSeconds(waitTime);
        Thread.sleep(500);

        // Wait for the login form element to be visible
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")));

        //Login
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).clear();
        //driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div")).click();



        WebElement linkToNewWindow = driver.findElement(By.linkText("Sign up"));
        linkToNewWindow.click();
        // Wait for the signup link to be visible
        Thread.sleep(3000);

        //SignUp
        driver.findElement(By.xpath("//*[@aria-label = \"Mobile Number or Email\"]")).sendKeys("1234567890");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@aria-label = \"Full Name\"]")).sendKeys("Someone");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@aria-label = \"Username\"]")).sendKeys("Seen_123");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@aria-label = \"Password\"]")).sendKeys("1234567890");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@type = \"submit\"]")).click();
        Thread.sleep(500);

        //Take Screen Shot
        TakesScreenshot whileFail = (TakesScreenshot) driver;
        File failShot = whileFail.getScreenshotAs(OutputType.FILE);
        File storeShot = new File("C:\\Users\\HP\\IdeaProjects\\API_Assignment\\ScreenShots\\FailShot_" + System.currentTimeMillis() + ".png");
        FileHandler.copy(failShot, storeShot);
        Thread.sleep(500);

        //learn more
        driver.findElement(By.linkText("Learn More")).click();
        // Get all window handles (tabs)
        java.util.Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new tab
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);

            // Check the URL or title of the tab to identify the target tab
            String currentUrl = driver.getCurrentUrl();
            String currentTitle = driver.getTitle();

            // Example: If the target URL or title is found, break the loop
            if (currentUrl.equals("https://www.facebook.com/help/instagram/261704639352628") || currentTitle.equals("Information for people who don't use Meta Products")) {
                break;
            }
        }

        driver.findElement(By.cssSelector("#mount_0_0_8U > div > div > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div > div.x78zum5.xdt5ytf.x1t2pt76.x1n2onr6.x1ja2u2z.x10cihs4 > div.x2bj2ny.x18n5i07 > div.x9f619.x1n2onr6.x1ja2u2z.x78zum5.x2lah0s.x1qughib.x1qjc9v5.xozqiw3.x1q0g3np.x4cne27.xifccgj > div.x9f619.x1ja2u2z.x78zum5.xdt5ytf.x2lah0s.x193iq5w.xeuugli.xqcrz7y.x2bj2ny.x1ok221b.xexx8yu.x18d9i69.x7wzq59.x13vifvy.x1cvmir6.xfe63ej > nav > div > div.x78zum5.xdt5ytf.x1iyjqo2.x1n2onr6 > div > div:nth-child(1) > div > div > div > div > div > div > span > span > div > div > div.x6s0dn4.x1q0q8m5.x1qhh985.xu3j5b3.xcfux6l.x26u7qi.xm0m39n.x13fuv20.x972fbf.x9f619.x78zum5.x1q0g3np.x1iyjqo2.xs83m0k.x1qughib.xat24cr.x11i5rnm.x1mh8g0r.xdj266r.xeuugli.x18d9i69.x1sxyh0.xurb0ha.xexx8yu.x1n2onr6.x1ja2u2z.x1gg8mnh > div.x6s0dn4.xkh2ocl.x1q0q8m5.x1qhh985.xu3j5b3.xcfux6l.x26u7qi.xm0m39n.x13fuv20.x972fbf.x9f619.x78zum5.x1q0g3np.x1iyjqo2.xs83m0k.x1qughib.xat24cr.x11i5rnm.x1mh8g0r.xdj266r.x2lwn1j.xeuugli.x18d9i69.x4uap5.xkhd6sd.xexx8yu.x1n2onr6.x1ja2u2z > div.xod5an3.x16n37ib.x14vqqas.x1n2onr6.xqcrz7y > div > div > i")).click();

        Thread.sleep(1000);
        //Close the driver
        //driver.close();
    }
}

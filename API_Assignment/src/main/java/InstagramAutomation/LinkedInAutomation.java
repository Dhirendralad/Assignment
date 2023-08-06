package InstagramAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LinkedInAutomation {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //get the linked in page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/");
        Thread.sleep(2000);

        //perform page down page up actions
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(500);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(500);

        //scroll to the end of the page and again to the top
        while (true) {
            actions.sendKeys(Keys.END).perform();
            Thread.sleep(1000);

            //check if end of page is reached
            if(isEndOfPage(driver)) {
                break;
            }
            Thread.sleep(500);
            //Scroll back up
            scrollToTop(driver);
        }
    }

    private static boolean isEndOfPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long windowHeight = (Long) js.executeScript("return window.innerHeight;");
        long totalHeight = (Long) js.executeScript("return document.body.scrollHeight;");
        long scrollPosition = (Long) js.executeScript("return window.scrollY;");

        // Compare the current scroll position with the total height of the page
        return (windowHeight + scrollPosition) >= totalHeight;
    }

    private static void scrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
}

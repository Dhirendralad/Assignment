package InstagramAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrangeHRMAutomation {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Get the Orange HRM page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Get the current window handle (parent window)
        // String parentWindowHandle = driver.getWindowHandle();
        // Add wait time implicitly
        int waitTime = 2;
        Duration duration = Duration.ofSeconds(waitTime);
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        //login to Orange HRM
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type = \"submit\"]")));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();

        //Explore the Admin Module
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/admin/viewAdminModule\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/admin/viewAdminModule\"]")).click();

        //User Management sub module
//        WebElement userManagement =  driver.findElement(By.xpath("//span[text() = \"User Management \"]"));
//        userManagement.click();
//        Thread.sleep(100);
//        WebElement optionToClick = driver.findElement(By.xpath("//ul[@role = \"menu\"]"));
//        List<WebElement> optionUser = optionToClick.findElements(By.xpath("//div[@role=\"menuitem\"]"));
//        for (WebElement option : optionUser) {
//            option.click();
//        }
//        Thread.sleep(100);

        //Job sub module
//        WebElement job =  driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-body.cursor-hover > nav > ul > li.--active.oxd-topbar-body-nav-tab.--parent.pointer-hover > span"));
//        job.click();
//        Thread.sleep(100);
//        WebElement optioninJob = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul"));
//        List<WebElement> options = optioninJob.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]/a"));
//        for (WebElement option : options) {
//            option.click();
//        }
//        Thread.sleep(100);

        driver.findElement(By.xpath("//input[@fdprocessedid=\"4shfwk\"")).sendKeys("Virat Kohli");

        //Explore the PIM tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/pim/viewPimModule\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/pim/viewPimModule\"]")).click();

        //Explore the Leave tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/leave/viewLeaveModule\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/leave/viewLeaveModule\"]")).click();

        //Explore the Time tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/time/viewTimeModule\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/time/viewTimeModule\"]")).click();

        //Explore the Recruitment tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/recruitment/viewRecruitmentModule\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/recruitment/viewRecruitmentModule\"]")).click();

        //Explore the My Info tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/pim/viewMyDetails\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/pim/viewMyDetails\"]")).click();

        //Explore the Performance tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/performance/viewPerformanceModule\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/performance/viewPerformanceModule\"]")).click();

        //Explore the Dashboard tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/dashboard/index\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/dashboard/index\"]")).click();

        //Explore the Directory tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/directory/viewDirectory\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/directory/viewDirectory\"]")).click();

        //Explore the Maintenance tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/maintenance/viewMaintenanceModule\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/maintenance/viewMaintenanceModule\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();

        //Explore the Claim tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/claim/viewClaimModule\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/claim/viewClaimModule\"]")).click();

        //Explore the Buzz tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/web/index.php/buzz/viewBuzz\"]")));
        driver.findElement(By.xpath("//a[@href=\"/web/index.php/buzz/viewBuzz\"]")).click();

    }
}

package InstagramAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BridgeLabzPageAutomation {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //get the page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bridgelabz.com/papregistration");
        Thread.sleep(2000);

        driver.findElement(By.name("ContactNumber")).sendKeys("1234567890");
        Thread.sleep(100);
        driver.findElement(By.name("fullName")).sendKeys("Dhire987456");
        Thread.sleep(100);
        driver.findElement(By.name("email")).sendKeys("someone@this.con");
        Thread.sleep(100);
        WebElement inputElement =  driver.findElement(By.name("gradStream"));
        inputElement.click();
        Thread.sleep(100);
        WebElement optionContainer = driver.findElement(By.id("degreeStreamOptions"));
        List<WebElement> options = optionContainer.findElements(By.xpath("//div[@value = \"Engineering (Non IT)\"]"));
        for (WebElement option : options) {
            option.click();
        }
        Thread.sleep(100);
        WebElement inputElement2 =  driver.findElement(By.name("passoutYear"));
        inputElement2.click();
        Thread.sleep(100);
        WebElement optionContainer2 = driver.findElement(By.id("passoutYears"));
        List<WebElement> options2 = optionContainer2.findElements(By.xpath("//div[@value = \"Before 2020\"]"));
        for (WebElement option : options2) {
            option.click();
        }
        Thread.sleep(100);
        WebElement inputElement3 =  driver.findElement(By.name("location"));
        inputElement3.click();
        Thread.sleep(100);
        WebElement optionContainer3 = driver.findElement(By.id("papTestCenters"));
        List<WebElement> options3 = optionContainer3.findElements(By.xpath("//div[@value = \"Mumbai\"]"));
        for (WebElement option : options3) {
            option.click();
        }
        Thread.sleep(100);
        driver.findElement(By.xpath("//button[text() = \"REGISTER NOW\"]"));

        driver.get("https://bridgelabz.com/papregistration");
        Thread.sleep(2000);

        driver.findElement(By.name("ContactNumber")).sendKeys("8850300770");
        Thread.sleep(100);
        driver.findElement(By.name("fullName")).sendKeys("Dhirendra Deepak Lad");
        Thread.sleep(100);
        driver.findElement(By.name("email")).sendKeys("dhirendralad@gmail.com");
        Thread.sleep(100);
        WebElement inputEle =  driver.findElement(By.name("gradStream"));
        inputEle.click();
        Thread.sleep(100);
        WebElement optionContain = driver.findElement(By.id("degreeStreamOptions"));
        List<WebElement> optionsDeg = optionContain.findElements(By.xpath("//div[@value = \"Engineering (Non IT)\"]"));
        for (WebElement option : optionsDeg) {
            option.click();
        }
        Thread.sleep(100);
        WebElement inputEle2 =  driver.findElement(By.name("passoutYear"));
        inputEle2.click();
        Thread.sleep(100);
        WebElement optionContain2 = driver.findElement(By.id("passoutYears"));
        List<WebElement> optionsPassYear2 = optionContain2.findElements(By.xpath("//div[@value = \"Before 2020\"]"));
        for (WebElement option : optionsPassYear2) {
            option.click();
        }
        Thread.sleep(100);
        WebElement inputElem3 =  driver.findElement(By.name("location"));
        inputElem3.click();
        Thread.sleep(100);
        WebElement optionContain3 = driver.findElement(By.id("papTestCenters"));
        List<WebElement> optionsLocation3 = optionContainer3.findElements(By.xpath("//div[@value = \"Mumbai\"]"));
        for (WebElement option : optionsLocation3) {
            option.click();
        }
        Thread.sleep(100);
        driver.findElement(By.xpath("//button[text() = \"REGISTER NOW\"]"));

        //driver.close();
    }
}

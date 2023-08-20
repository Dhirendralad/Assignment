package InstagramAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class sauceDemoAutomation {
    public static WebDriver driver;

    @Test
    public static void login() throws InterruptedException {
        Thread.sleep(1000);
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public static void CheckTitle() throws InterruptedException {
        String expectedTitle = "Swag Labs";
        String currentTitle = driver.getTitle();

        if (currentTitle.equals(expectedTitle)) {
            System.out.println("Landed on the expected page.");
        } else {
            System.out.println("Not on the expected page.");
        }
    }

    @Test
    public static void AddItemToCart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text() = \"Sauce Labs Bike Light\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("shopping_cart_badge")).click();
    }

    @Test
    public static void RemoveItemFromCart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("continue-shopping")).click();
    }

    @Test
    public static void AddRemoveMultipleItems() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("shopping_cart_badge")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("remove-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("remove-sauce-labs-bolt-t-shirt")).click();
    }

    @Test
    public static void CheckoutItem() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("first-name")).sendKeys("Dhirendra");
        Thread.sleep(1000);
        driver.findElement(By.id("last-name")).sendKeys("Lad");
        Thread.sleep(1000);
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("back-to-products")).click();
    }

    @Test
    public static void ApplyAllAvailableFilters() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//option[text()=\"Name (A to Z)\"]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//option[text()=\"Name (Z to A)\"]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//option[text()=\"Price (low to high)\"]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//option[text()=\"Price (high to low)\"]")).click();
    }

    @Test
    public static void AccessHamburgerMenu() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text() = \"Open Menu\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        login();
        CheckTitle();
        AddItemToCart();
        RemoveItemFromCart();
        AddRemoveMultipleItems();
        CheckoutItem();
        ApplyAllAvailableFilters();
        AccessHamburgerMenu();
        driver.close();
    }

}

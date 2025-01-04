package testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumClass {

    WebDriver driver;


    public void launchBrowserAndApplication() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // It will launch browser
        driver = new ChromeDriver();
        // It will maximize browser window.
        driver.manage().window().maximize();
        // It will launch application
        driver.get("https://www.saucedemo.com/v1/index.html");

        Thread.sleep(3000);

        // Entering username
        // Identify username locator with 'id'
        //WebElement username = driver.findElement(By.id("user-name"));
        //Identify username locator with 'xpath'
        //WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
        username.sendKeys("standard_user");

        // Entering password
        //WebElement pass = driver.findElement(By.id("password"));
        WebElement pass = driver.findElement(By.xpath("//input[@data-test='password']"));
        pass.sendKeys("secret_sauce");


        // Clicking on login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();


        String expectedURL = "https://www.saucedemo.com/v1/inventory.html";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)) {
            System.out.println("Login is successful");
        } else {
            System.out.println("Login is unsuccessful");
        }

        WebElement productsIcon = driver.findElement(By.xpath("//div[@class='product_label']"));
        //WebElement productsIcon = driver.findElement(By.xpath("//div[contains(text(), 'Products')]"));
        //WebElement productsIcon = driver.findElement(By.xpath("//div[contains(@class, 'product_label')]"));
        //*[@id="user-name"]
        //*[@id="password"]

        if (productsIcon.isDisplayed()) {
            System.out.println("Login is successful with PRODUCTS element");
        } else {
            System.out.println("Login is unsuccessful with PRODUCTS element");
        }
        //driver.close();

    }

    public void filterPrice() throws InterruptedException {
        WebElement filterPriceDropDown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        filterPriceDropDown.click();

        Select s1 = new Select(filterPriceDropDown);
        //s1.selectByVisibleText("Name (Z to A)");
        //s1.selectByIndex(3);
        s1.selectByValue("lohi");
        Thread.sleep(5000);
    }
}








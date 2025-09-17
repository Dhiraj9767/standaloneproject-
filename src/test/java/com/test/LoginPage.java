package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    public static void main(String[] args) {

        String productName = "ADIDAS ORIGINAL";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/client");
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userName = driver.findElement(By.id("userEmail"));
        userName.sendKeys("dhirajbhosale2730@gmail.com");
        WebElement password = driver.findElement(By.id("userPassword"));
        password.sendKeys("Dhiraj123");
        WebElement loginBttn = driver.findElement(By.id("login"));
        loginBttn.click();

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wt.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[routerlink*='cart']")));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals("ADIDAS ORIGINAL"));
        Assert.assertTrue(match);
        driver.findElement(By.xpath("//*[@class='totalRow'] /button")).click();

        WebElement selectCountry = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
        selectCountry.sendKeys("ind");

        wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item ')])[2]")).click();
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
        WebElement actionSubmit = driver.findElement(By.cssSelector(".action__submit"));
        Actions actions = new Actions(driver);
        actions.moveToElement(actionSubmit).click().build().perform();

        String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();
    }
}
package com.test;

import com.pom.CartPage;
import com.pom.LandingPage;
import com.pom.ProductCataloge;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest {
    static String productName = "ADIDAS ORIGINAL";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LandingPage lp = new LandingPage(driver);
        lp.goTo();

        ProductCataloge pc =lp.loginApplication("dhirajbhosale2730@gmail.com", "Dhiraj123");

        List<WebElement> products = pc.getProductList();

        pc.addProductToCart(productName);
         pc.goToCartPage();


        CartPage cartPage = new CartPage(driver);
        boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        cartPage.goToCheckout();


    }
}

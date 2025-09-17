package com.test;

import com.pom.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitOrderTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        LandingPage lp = new LandingPage(driver);
        lp.goTo();

        lp.loginApplication("dhirajbhosale2730@gmail.com", "Dhiraj123");

    }
}

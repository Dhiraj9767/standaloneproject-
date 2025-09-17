package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import com.pom.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;

    public WebDriver initilizeDriver() throws IOException {
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "//src//main//java//com//resources//globalData.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();   // ✅ assign to class-level driver
        }
        // (You can add more browsers here: firefox, edge, etc.)

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }

    public LandingPage launchApplication() throws IOException {
        driver = initilizeDriver();
        LandingPage lp = new LandingPage(driver);
        lp.goTo();
        return lp;
    }
}

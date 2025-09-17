package com.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractComponent {


     WebDriver driver;

    public AbstractComponent(WebDriver driver) {

        this.driver = driver;
    }

    public void waitForElementToAppear(By findBy) {

        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
        wt.until(ExpectedConditions.visibilityOfElementLocated(findBy));


    }
}

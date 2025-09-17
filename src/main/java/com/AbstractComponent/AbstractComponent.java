package com.AbstractComponent;

import com.pom.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    protected WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartBttn;

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
        wt.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToDisappear(WebElement ele) {
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(3));
        wt.until(ExpectedConditions.invisibilityOf(ele));
    }

    public CartPage goToCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(cartBttn));
        cartBttn.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
}
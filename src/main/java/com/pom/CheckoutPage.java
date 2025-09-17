package com.pom;

import com.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement countryInput;

    @FindBy(xpath = "//a[contains(@class,'action__submit')]")
    WebElement submitBtn;

    @FindBy(css = ".ta-item")
    WebElement countryOption;

    By results = By.cssSelector(".ta-results");

    public void selectCountry(String countryName) {
        countryInput.sendKeys(countryName);
        waitForElementToAppear(results);
        countryOption.click();
    }

    public ConfirmationPage submitOrder() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
        return new ConfirmationPage(driver);
    }
}
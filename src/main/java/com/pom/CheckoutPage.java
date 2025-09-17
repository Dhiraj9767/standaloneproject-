package com.pom;

import com.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement country;

    @FindBy(css = ".action__submit")
    WebElement submitBttn;
}
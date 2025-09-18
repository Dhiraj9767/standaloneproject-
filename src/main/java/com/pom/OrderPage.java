package com.pom;

import com.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {
    WebDriver driver;
    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> productNames;


    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyOrderDisplay(String productName) {
        boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        if (!match) {
            throw new RuntimeException("Product not found in order history: " + productName);
        }
        return match;
    }
}

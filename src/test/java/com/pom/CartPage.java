package com.pom;

import com.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkoutBttn;

    public boolean verifyProductDisplay(String productName) {
        boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
        return match;
    }

    public CheckoutPage goToCheckout() {
        checkoutBttn.click();
        return new CheckoutPage(driver);
    }
}

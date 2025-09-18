package com.test;

import com.pom.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SubmitOrderTest extends BaseTest {
    static String productName = "ADIDAS ORIGINAL";

    @Test
    public void submitOrder() throws Exception {


        ProductCataloge pc = lp.loginApplication("dhirajbhosale2730@gmail.com", "Dhiraj123");

        List<WebElement> products = pc.getProductList();

        pc.addProductToCart(productName);
        CartPage cartPage = pc.goToCartPage();

        boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("British Indian Ocean Territory");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.verifyConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistoryTest() throws Exception {

        ProductCataloge pc = lp.loginApplication("dhirajbhosale2730@gmail.com", "Dhiraj123");
        OrderPage op = pc.goToOrderPage();
        Assert.assertTrue(op.verifyOrderDisplay(productName));
    }
    }
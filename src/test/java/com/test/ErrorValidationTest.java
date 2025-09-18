package com.test;

import com.pom.CartPage;
import com.pom.CheckoutPage;
import com.pom.ConfirmationPage;
import com.pom.ProductCataloge;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ErrorValidationTest extends BaseTest {
    static String productName = "ADIDAS ORIGINAL";

    @Test
    public void loginErrorMsg() throws Exception {


        lp.loginApplication("dhirajbhosale2730@gmail.com", "hiraj123");

        Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());

    }
    @Test
    public void productErrorValidation() throws Exception {


        ProductCataloge pc = lp.loginApplication("dhirajbhosale2730@gmail.com", "Dhiraj123");

        List<WebElement> products = pc.getProductList();

        pc.addProductToCart(productName);
        CartPage cartPage = pc.goToCartPage();

        boolean match = cartPage.verifyProductDisplay("ADIDAS ORIGINAL");
        Assert.assertTrue(match);


    }

}
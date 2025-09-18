package com.pom;


import com.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userName;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginBttn;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMessage;

    public ProductCataloge loginApplication(String email, String pass) {
        userName.sendKeys(email);
        password.sendKeys(pass);
        loginBttn.click();

        ProductCataloge pc = new ProductCataloge(driver);
        return pc;

    }


    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");

    }

    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        String errorMsg = errorMessage.getText();
        return errorMsg;
    }


}

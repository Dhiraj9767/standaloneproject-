package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".hero-primary")
    WebElement confirmMessage;

    public String verifyConfirmMessage() {
        return confirmMessage.getText();
    }
}

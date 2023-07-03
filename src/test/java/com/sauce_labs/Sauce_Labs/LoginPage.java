package com.sauce_labs.Sauce_Labs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "user-name")
    private WebElement usernameInput;
  
    @FindBy(id = "password")
    private WebElement passwordInput;
  
    @FindBy(id = "login-button")
    private WebElement loginButton;
  
    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}


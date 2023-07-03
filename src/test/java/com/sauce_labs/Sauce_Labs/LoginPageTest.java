package com.sauce_labs.Sauce_Labs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private AllItemsPage allItemsPage;
  
    @BeforeMethod
    public void setup() {
        // Initialize WebDriver and PageFactory
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        allItemsPage = PageFactory.initElements(driver, AllItemsPage.class);
        System.out.println(allItemsPage);
        
        }
  
    @Test
    public void testValidLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(allItemsPage.isInventoryDisplayed());
    }
    
    @Test
    public void testLogout() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        System.out.println("Reached here");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        allItemsPage.clickLogoutLink();
        System.out.println("Reached here below");
        Assert.assertFalse(allItemsPage.isCartDisplayed());
    }
  
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

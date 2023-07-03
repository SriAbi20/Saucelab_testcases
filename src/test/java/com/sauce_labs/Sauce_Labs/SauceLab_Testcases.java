package com.sauce_labs.Sauce_Labs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AllItemsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;

public class SauceLab_Testcases {
	
	private WebDriver driver;
    private LoginPage loginPage;
    private AllItemsPage allItemsPage;

    @BeforeMethod
    public void setup() {
        // Set the system property for the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    	
        // Initialize the ChromeDriver instance
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Instantiate the Page Objects
        loginPage = new LoginPage(driver);
        allItemsPage = new AllItemsPage(driver);
    }
    @Test(enabled = false)
    public void validLoginTest() {
        driver.get("https://www.saucedemo.com/");

        // Perform the login process
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

     // Wait for the All Items page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("inventory.html"));

        // Update the page object reference after login
        allItemsPage = new AllItemsPage(driver);
        
        // Click on the menu
        allItemsPage.clickMenu();

     // Additional test steps on the All Items page
        /*
        WebElement aboutLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("About")));
        aboutLink.click();*/
        
     // Additional test steps on the All Items page
        By aboutLinkLocator = By.linkText("About");
        WebElement aboutLink = wait.until(ExpectedConditions.elementToBeClickable(aboutLinkLocator));
        clickElementWithJavaScript(driver, aboutLink);
        
        //Go back to previous page
        driver.navigate().back();
        
        
        // Write further assertions or perform other actions as needed
     // Additional test steps on the All Items page
        //clickElementWithJavaScript(driver, allItemsPage.getAboutLink());
        // Write further assertions or perform other actions as needed
        // Write further assertions or perform other actions as needed
        
        
        //close the current(About) page
        //driver.close();
    }
    
    @Test(enabled = false)
    public void logoutTest() {
    	 driver.get("https://www.saucedemo.com/");

         // Perform the login process
         loginPage.enterUsername("standard_user");
         loginPage.enterPassword("secret_sauce");
         loginPage.clickLoginButton();
         
      // Wait for the All Items page to load
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         wait.until(ExpectedConditions.urlContains("inventory.html"));
         
         // Update the page object reference after login
         //allItemsPage = new AllItemsPage(driver);
         
          // Click on the menu
         allItemsPage.clickMenu();

         // Assume that the user is already on the All Items page
         // Click on the Logout link
      // Additional test steps on the All Items page
        
        By logoutLinkLocator = By.linkText("Logout");
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(logoutLinkLocator));
        clickElementWithJavaScript(driver, logoutLink);
        
      //close the current page
        driver.close();
        
        //allItemsPage.clickLogoutLink();

        // Assert that the user is logged out
        // (You can use assertions from TestNG or any other assertion library)
        // Sample assertion: Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));

        // Additional test steps after logging out
    }
    @Test(enabled = false)
    public void invalidCredentialsTest() {
        driver.get("https://www.saucedemo.com/");

        // Enter invalid username and password
        loginPage.enterUsername("invalid_username");
        loginPage.enterPassword("invalid_password");
        loginPage.clickLoginButton();

        // Verify that the error message is displayed
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        
        //close the current(Login) page
        driver.close();
    }
    
    @Test(enabled = false)
    public void testNavigation() {
    	// Open the login page
        driver.get("https://www.saucedemo.com/");

        // Perform login actions
        // ...
        // Perform the login process
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        
     // Wait for the All Items page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        

        // Assert that login is successful and user is redirected to the inventory page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        
         // Store the current window handle
        //String currentWindow = driver.getWindowHandle();
        // Click on the menu to reveal the about link
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // Click on the about link to navigate to the Sauce Labs website
        
       //Facing error -->unable to locate element
        /*driver.findElement(By.linkText("About")).click();*/
        By aboutLinkLocator = By.linkText("About");
        WebElement aboutLink = wait.until(ExpectedConditions.elementToBeClickable(aboutLinkLocator));
        clickElementWithJavaScript(driver, aboutLink);
        

        // Assert that the About page is loaded successfully  
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
        

        // Go back to the previous page
        driver.navigate().back();
          
        // Close the current page (About page)
        //driver.close();
           	    
    }
    @Test(enabled=true)
    public void testAddItemsToCart() {
    	// Login to the website by calling validLoginTest()
          validLoginTest();
       
       // Navigate to the All Items page
       //allItemsPage.navigateToAllItems();

       // Add items to the cart
       allItemsPage.addItemToCart("Sauce Labs Backpack");
       allItemsPage.addItemToCart("Sauce Labs Bike Light");
       allItemsPage.addItemToCart("Sauce Labs Bolt T-Shirt");
    	
    }
 // Helper method to click an element using JavaScript
    private void clickElementWithJavaScript(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

}

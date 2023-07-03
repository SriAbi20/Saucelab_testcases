package com.sauce_labs.Sauce_Labs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class AllItemsPage {
    @FindBy(id = "inventory_container")
    private WebElement inventoryContainer;
  
    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsLink;
  
    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;
  
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;
  
    @FindBy(id = "shopping_cart_container")
    private WebElement cartContainer;
  
    public boolean isInventoryDisplayed() {
        return inventoryContainer.isDisplayed();
    }
  
    public void clickAllItemsLink() {
        allItemsLink.click();
    }
  
    public void clickAboutLink() {
        aboutLink.click();
    }
  
    public void clickLogoutLink() {
    	System.out.println("All item page");
        logoutLink.click();
    }
  
    public boolean isCartDisplayed() {
        return cartContainer.isDisplayed();
    }
}

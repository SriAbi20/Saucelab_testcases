package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllItemsPage {
    private WebDriver driver;

   /* @FindBy(xpath = "//div[@id='inventory_sidebar_link']")
    private WebElement allItemsLink;

    @FindBy(xpath = "//div[@id='about_sidebar_link']")
    private WebElement aboutLink;

    @FindBy(xpath = "//div[@id='logout_sidebar_link']")
    private WebElement logoutLink;

    @FindBy(xpath = "//div[@id='reset_sidebar_link']")
    private WebElement resetAppStateLink;
    */
    
    @FindBy(id = "inventory_container")
    private WebElement inventoryContainer;
  
    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsLink;
  
    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;
  
    @FindBy(xpath = "//div[@id='logout_sidebar_link']")
    private WebElement logoutLink;
  
    @FindBy(id = "shopping_cart_container")
    private WebElement cartContainer;
    
    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppStateLink;
    
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menuButton;
    
    

    public AllItemsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickMenu() {
        menuButton.click();
    }

    public void clickAllItemsLink() {
        allItemsLink.click();
    }

    public void clickAboutLink() {
        aboutLink.click();
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public void clickResetAppStateLink() {
        resetAppStateLink.click();
    }
    
}

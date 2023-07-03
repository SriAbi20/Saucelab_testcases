package pages;

import org.openqa.selenium.By;
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
    
    @FindBy(xpath = "//div[contains(@class, 'inventory_item')]//div[contains(@class, 'inventory_item_name') and contains(text(), 'itemNamePlaceholder')]//ancestor::div[contains(@class, 'inventory_item')]//button[contains(@class, 'btn_inventory') and contains(text(), 'Add to cart')]")
    private WebElement addToCartButton;
    

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
    public void addItemToCart(String itemName) {
        WebElement item = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name') and contains(text(), '" + itemName + "')]"));
        WebElement addToCartButton = item.findElement(By.xpath(".//ancestor::div[contains(@class, 'inventory_item')]//button[contains(@class, 'btn_inventory') and contains(text(), 'Add to cart')]"));
        String itemPriceXPath = ".//ancestor::div[contains(@class, 'inventory_item')]//div[contains(@class, 'inventory_item_price')]";
        WebElement itemPriceElement = item.findElement(By.xpath(itemPriceXPath));
        String itemPrice = itemPriceElement.getText();
        System.out.println(itemPrice);
        addToCartButton.click();
    }
}

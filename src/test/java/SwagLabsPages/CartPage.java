package SwagLabsPages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    WebDriver driver;
    By ValidateProductName = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    By ValidateProductPrice = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    By REMOVE_BTN_IN_CART = By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]/android.widget.TextView");

    By CART_PAGE_ICON = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");

    By CHECKOUT_BTN = new AppiumBy.ByAccessibilityId("test-CHECKOUT");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /* This method check that the product share the same name as it was in the product page*/
    public CartPage validateProductName(String ProductName){
         Assert.assertTrue(driver.findElement(ValidateProductName).getAttribute("text").equals(ProductName));
         return this;
    }
    /* This method check that the product share the same price as it was in the product page*/
    public CartPage validateProductPrice(String productPrice){
         Assert.assertTrue(driver.findElement(ValidateProductPrice).getAttribute("text").equals(productPrice));
         return this;
    }
    public CartPage removeItemFromCart(){
        driver.findElement(REMOVE_BTN_IN_CART).click();
        return this;
    }
    /*
    This method checks if the cart icon on the top right has any numbers on it
     */
    public boolean ValidateCartIsEmpty(){
        return driver.findElement(CART_PAGE_ICON).getAttribute("text").equals("");
    }
    public CartPage clickOnCheckOut(){
        driver.findElement(CHECKOUT_BTN).click();
        return this;
    }
}

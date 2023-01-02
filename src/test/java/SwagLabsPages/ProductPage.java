package SwagLabsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    By PRODUCTS_WORD = By.xpath("//android.widget.TextView[@text = \"PRODUCTS\"]");
    By CART_PAGE = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");

    By Sauce_Lab_BackPack = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView");
    By Sauce_Lab_BackPack_Name = By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    /*
    This method checks whether we are at the product page or not after login
     */
    public boolean AssertProductPage() {
        return driver.findElement(PRODUCTS_WORD).getAttribute("text").equals("PRODUCTS");
    }
    /*
    this method adds product "Sauce Lab BackPack" to the cart
     */
    public ProductPage AddProductToCart() {
        driver.findElement(Sauce_Lab_BackPack).click();
        return this;
    }

    public CartPage GoToCartPage() {
        driver.findElement(CART_PAGE).click();
        return new CartPage(driver);
    }
    public boolean AssertFirstProductName(String firstProductName) {
        return driver.findElement(Sauce_Lab_BackPack_Name).getAttribute("text").equals(firstProductName);
    }
}

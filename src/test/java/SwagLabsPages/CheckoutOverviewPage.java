package SwagLabsPages;

import Actions.MobileActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutOverviewPage {
    WebDriver driver;

    By CHECK_OUT_PRICE = By.xpath("//android.widget.TextView [@text = \"Total: $32.39\"]");
    By FINISH_BTN = By.xpath("//android.widget.TextView [@text = \"FINISH\"]");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    /*
    This method checks the total price after taxes in the last stage of purchase
     */
    public CheckoutOverviewPage CheckTotalPrice(String totalPrice){
        Assert.assertTrue(driver.findElement(CHECK_OUT_PRICE).getAttribute("text").equals(totalPrice));
        return this;
    }
    public CheckoutOverviewPage finishCheckout(){
        new MobileActions(driver);
        MobileActions.scrollDownToSpecificText("FINISH");
        driver.findElement(FINISH_BTN).click();
        return this;
    }
}

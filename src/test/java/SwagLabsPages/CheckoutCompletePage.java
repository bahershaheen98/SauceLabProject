package SwagLabsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    WebDriver driver;

    By CHECKOUT_COMPLETE_TEXT = By.xpath("//android.widget.TextView [@text = \"THANK YOU FOR YOU ORDER\"]");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }
    /*
     This method checks that the order has been completed successfully
     */
    public boolean validateCheckoutComplete(){
        return driver.findElement(CHECKOUT_COMPLETE_TEXT).getAttribute("text").equals("THANK YOU FOR YOU ORDER");
    }
}

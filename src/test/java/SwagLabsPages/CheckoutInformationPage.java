package SwagLabsPages;

import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
    WebDriver driver;

    By FIRST_NAME = new AppiumBy.ByAccessibilityId("test-First Name");
    By LAST_NAME = new AppiumBy.ByAccessibilityId("test-Last Name");
    By ZIP_CODE = new AppiumBy.ByAccessibilityId("test-Zip/Postal Code");
    By CONTINUE_BTN = new AppiumBy.ByAccessibilityId("test-CONTINUE");

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }
    /*
    This method fills out the information so we can proceed with the checkout after providing the necessary info
     */
    public CheckoutInformationPage fillInfoAndCheckout(String firstName,String lastName,String zipCode){
        new MobileActions(driver);
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        MobileActions.scrollDownToSpecificText("CONTINUE");
        driver.findElement(CONTINUE_BTN).click();
        return this;
    }
}

package SwagLabsPages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    By USER_NAME = new AppiumBy.ByAccessibilityId("test-Username");
    By PASSWORD = new AppiumBy.ByAccessibilityId("test-Password");
    By LOGIN_BTN = new AppiumBy.ByAccessibilityId("test-LOGIN");

    By ERROR_MSG = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    /*
    This method provides correct info to the login and logs in successfully
     */
    public HomePage successfulLogin(String userName, String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BTN).click();
        return this;
    }
    /*
    This method provides incorrect info to the login and login fails
     */
    public HomePage UnsuccessfulLogin(String wrongUserName, String wrongPassword){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(USER_NAME).sendKeys(wrongUserName);
        driver.findElement(PASSWORD).sendKeys(wrongPassword);
        driver.findElement(LOGIN_BTN).click();
        return this;
    }
    public boolean validateWrongLogin(){
        return driver.findElement(ERROR_MSG).getAttribute("text").equals("Username and password do not match any user in this service.");
    }
}

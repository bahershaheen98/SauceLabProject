package SwagLapTests;

import SwagLabsPages.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestPage {
    WebDriver driver;
    @BeforeMethod
    public void setupDevice() throws MalformedURLException {
        String AppName = "C:\\Users\\ShaheenB\\IdeaProjects\\AppiumAutomationProject\\src\\test\\resources\\TestDataFile\\Android.SauceLabs.Mobile.Sample.app.2.2.0.apk";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Android SDK built for x86");
        caps.setCapability("appium:appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appium:app", AppName);
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:automationName", "UiAutomator2");
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
    }

    @Test
    public void successfulLogin(){
        new HomePage(driver).successfulLogin("standard_user","secret_sauce");
        Boolean Products_Page = new ProductPage(driver).AssertProductPage();
        Assert.assertTrue(Products_Page);
    }
    @Test
    public void unsuccessfulLogin(){
        new HomePage(driver).UnsuccessfulLogin("standard_user","secert_sauces")
                .validateWrongLogin();

    }
    @Test
    public void addProductToCart(){
        new HomePage(driver).successfulLogin("standard_user","secret_sauce");
        new ProductPage(driver).AddProductToCart().AssertFirstProductName("Sauce Labs Backpack");
        new ProductPage(driver).GoToCartPage().validateProductName("Sauce Labs Backpack");
        new CartPage(driver).validateProductPrice("$29.99");
    }
    @Test
    public void removeProductsFromCart(){
        new HomePage(driver).successfulLogin("standard_user","secret_sauce");
        new ProductPage(driver).AddProductToCart().GoToCartPage();
        new CartPage(driver).removeItemFromCart().ValidateCartIsEmpty();
    }

    @Test
    public void purchaseAnItem(){
        new HomePage(driver).successfulLogin("standard_user","secret_sauce");
        new ProductPage(driver).AddProductToCart().GoToCartPage();
        new CartPage(driver).clickOnCheckOut();
        new CheckoutInformationPage(driver).fillInfoAndCheckout("Baher","Shaheen","12345");
        new CheckoutOverviewPage(driver).CheckTotalPrice("Total: $32.39");
        new CheckoutOverviewPage(driver).finishCheckout();
        new CheckoutCompletePage(driver).validateCheckoutComplete();

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

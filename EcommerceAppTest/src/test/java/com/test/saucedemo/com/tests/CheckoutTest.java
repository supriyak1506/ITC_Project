package com.test.saucedemo.com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends BaseTest {

    @Test
    public void testEndToEndCheckout() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");


        InventoryPage inventoryPage = new InventoryPage(driver);

        InventoryPage.addItemToCart("Sauce Labs Backpack");

        inventoryPage.goToCart();

        driver.findElement(org.openqa.selenium.By.id("checkout")).click();

        CheckoutInfoPage infoPage = new CheckoutInfoPage(driver);
        infoPage.enterDetails("Supriya", "Kalaskar", "12345");


        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        overviewPage.clickFinish();


        String successHeader = driver.findElement(org.openqa.selenium.By.className("complete-header")).getText();
        Assert.assertEquals(successHeader, "Thank you for your order!", "Checkout failed!");
    }
}
package com.test.saucedemo.com.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.PropertyFileReader;

public class CartTest extends BaseTest {

    @Test
    public void testAddTwoItemsToCart() {

        LoginPage loginPage = new LoginPage(driver);
        logger.info("Logging in to Saucedemo");
        loginPage.login(PropertyFileReader.getProperty("username"), PropertyFileReader.getProperty("password"));


        InventoryPage inventoryPage= new InventoryPage(driver);

        logger.info("Adding Sauce Labs Backpack to cart");
        InventoryPage.addItemToCart("Sauce Labs Backpack");

       logger.info("Adding Sauce Labs Bike Light to cart");
        InventoryPage.addItemToCart("Sauce Labs Bike Light");

        String count = inventoryPage.getCartBadgeCount();
        logger.info("Current cart count: " + count);

        Assert.assertEquals(count, "2", "Cart count does not match!");

        inventoryPage.goToCart();
        logger.info("Navigated to cart page.");
    }
}
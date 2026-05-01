
package com.test.saucedemo.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertyFileReader;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);


        String user = PropertyFileReader.getProperty("username");
        String pass = PropertyFileReader.getProperty("password");

        loginPage.login(user, pass);

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User was not redirected to the inventory page!");
    }
}
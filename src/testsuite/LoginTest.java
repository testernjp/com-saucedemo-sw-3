package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * 3. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 4. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on page
 */
public class LoginTest extends Utility {
    String baseURL = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.name("password"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.name("login-button"));
        //Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.name("password"), "secret_sauce");
        // Click on ‘LOGIN’ button
        clickOnElement(By.name("login-button"));
        // Verify that six products are displayed on page
        List<WebElement> numberOfProducts = driver.findElements(By.className("inventory_item"));
        System.out.println("Total slides are : " + numberOfProducts.size());
        for (WebElement link : numberOfProducts) {
            System.out.println("The links : " + link.getText());
            System.out.println("The value of attributes : " + link.getAttribute("class"));
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

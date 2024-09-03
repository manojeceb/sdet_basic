package com.virtusa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Autify {

    //Build using mvn install and run using TestNG xml files as per below instructions to get the desired results
    // Run the TestNG_Problem3.xml for "Problem 3" test results
    // Run the TestNG_Problem4.xml for "Problem 4" test results
    //Problem 5 and 6 are also covered here

    WebDriver driver = new ChromeDriver();
    By Exp_Autify_NoCode = By.xpath("//a[text()='Explore Autify NoCode']");
    By Explore_Zenes = By.xpath("//a[text()='Explore Zenes']");

    @BeforeClass
    public void preRequisite() {
        WebDriverManager.chromedriver().setup();

    }

    //--------------------------Problem 3------------------------------//
    /*Verify following links are available on the page
    Why Autify
    Pricing
    Webinars
    Resources
     */
    @Test(priority = 0, dataProvider = "linkDataProvider", dataProviderClass = Autify.class)
    public void verifyAutifyLinks(String linktext) {
        driver.get("https://autify.com/");
        driver.manage().window().maximize();

        driver.findElements(Exp_Autify_NoCode).get(1).click();

        if (linktext.equalsIgnoreCase("Why Autify") || linktext.equalsIgnoreCase("Pricing")) {
            Assert.assertTrue(driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(1).isDisplayed(), "Link '" + linktext + "' is not displayed.");
            System.out.println("Link - '" + linktext + "' exists in the page.");
        } else if (linktext.equalsIgnoreCase("Webinars")) {
            Assert.assertTrue(driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(0).isDisplayed(), "Link '" + linktext + "' presents in the webpage but it is not visible.");
        } else {
            driver.navigate().back();
            driver.findElements(Explore_Zenes).get(1).click();
            Assert.assertTrue(driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(0).isDisplayed(), "Link '" + linktext + "' is not displayed.");
            System.out.println("Link - '" + linktext + "' exists in the page.");
        }
    }

    /*Verify following buttons are enabled on the page
    Start Free Trial
    Sign In
     */
    @Test(priority = 1, dataProvider = "buttonEnabledProvider", dataProviderClass = Autify.class)
    public void verifyAutifyButtonEnabled(String button) {
        driver.get("https://autify.com/");
        driver.manage().window().maximize();

        driver.findElements(Exp_Autify_NoCode).get(1).click();

        if (button.equalsIgnoreCase("Start Free Trial")) {
            Assert.assertTrue(driver.findElements(By.xpath("//a[text()='" + button + "']")).get(0).isEnabled(), "Button '" + button + "' is not enabled.");
            System.out.println("Button - '" + button + "' enabled in the page.");
        } else {
            driver.findElements(By.xpath("//a[text()='Log in']")).get(1).click();
            Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(),\"" + button + "\")]")).get(0).isEnabled(), "Button '" + button + "' is not enabled.");
            System.out.println("Button - '" + button + "' enabled in the page.");
        }

    }

    //--------------------------Problem 4------------------------------//

    /*Verify the title by clicking the following links on the page
    Why Autify
    Pricing
    Webinars
    Resources
     */
    @Test(priority = 3, dataProvider = "linkDataProvider", dataProviderClass = Autify.class)
    public void verifyAutifyLinksTitle(String linktext) {
        driver.get("https://autify.com/");
        driver.manage().window().maximize();

        driver.findElements(Exp_Autify_NoCode).get(1).click();

        if (linktext.equalsIgnoreCase("Why Autify")) {
            Assert.assertTrue(driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(1).isDisplayed(), "Link '" + linktext + "' is not displayed.");
            driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(1).click();
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, linktext, "Page title does not match expected value.");
            System.out.println("Title for the Link - '" + linktext + "' is verified as '" + actualTitle + "'.");
        } else if (linktext.equalsIgnoreCase("Pricing")) {
            Assert.assertTrue(driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(1).isDisplayed(), "Link '" + linktext + "' is not displayed.");
            driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(1).click();
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, linktext, "Page title does not match expected value.");
            System.out.println("Title for the Link - '" + linktext + "' is verified as '" + actualTitle + "'.");
        } else if (linktext.equalsIgnoreCase("Webinars")) {
            Assert.assertTrue(driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(0).isDisplayed(), "Link '" + linktext + "' presents in the webpage but it is not visible to click it.");
            driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(0).click();
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, linktext, "Page title does not match expected value.");
            System.out.println("Title for the Link - '" + linktext + "' is verified as '" + actualTitle + "'.");
        } else {
            driver.navigate().back();
            driver.findElements(Explore_Zenes).get(1).click();
            Assert.assertTrue(driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(0).isDisplayed(), "Link '" + linktext + "' is not displayed.");
            driver.findElements(By.xpath("//a[text()='" + linktext + "']")).get(0).click();
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, linktext, "Page title does not match expected value.");
            System.out.println("Title for the Link - '" + linktext + "' is verified as '" + actualTitle + "'.");
        }
    }


    @AfterTest
    public void quit() {
        driver.quit();
    }

    @DataProvider(name = "linkDataProvider")
    public Object[][] linkDataProvider() {
        return new Object[][]{
                {"Why Autify"},
                {"Pricing"},
                {"Webinars"},
                {"Resources"}
        };
    }

    @DataProvider(name = "buttonEnabledProvider")
    public Object[][] buttonEnabledProvider() {
        return new Object[][]{
                {"Start Free Trial"},
                {"Sign in"}
        };
    }
}

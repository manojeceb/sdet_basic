package com.virtusa.cucumber.steps;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.virtusa.cucumber.base.BaseCase.driver;

public class Herokuapp_step {

    //Thread.sleep is used to decrease the execution speed, else it will run quickly and cannot be able to see what actions are performing

    public void openApp() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void iVerifyThePageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title Mismatch...Expected - \"" + expectedTitle + "\" but found - \"" + actualTitle + "\"");
    }

    public void iNavigateToHomePage() {
        driver.navigate().back();
    }

    public void iClickTheLink(String link) throws InterruptedException {
        Thread.sleep(1000);
        WebElement cLink = driver.findElement(By.xpath("//a[text()='" + link + "']"));
        cLink.click();
    }

    public void iVerifyTheText(String expectedText) throws InterruptedException {
        Thread.sleep(2000);
        WebElement abTestVariation1Text = driver.findElement(By.xpath("//h3"));
        String actualText = abTestVariation1Text.getText();
        Assert.assertEquals(actualText, expectedText, "Text Mismatch...Expected - \"" + expectedText + "\" but found - \"" + actualText + "\"");
    }

    public void iSelectTheOptionAndMakeSureItIsSelected(String option) throws InterruptedException {
        Thread.sleep(3000);
        WebElement dropDown = driver.findElement(By.id("dropdown"));
//        dropDown.click();
        Select dropdown = new Select(dropDown);
        dropdown.selectByVisibleText(option);
        Thread.sleep(2000);

        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
        Assert.assertEquals(selectedText, option, "The selected option is not as expected...");
    }

    public void iValidateTheHyperlinksAvailable(DataTable table) throws InterruptedException {
        Thread.sleep(3000);
        List<List<String>> data = table.asLists(String.class);
        SoftAssert sa = new SoftAssert();
        for (List<String> datum : data) {
            String verifyLink = datum.get(0);
            int size = driver.findElements(By.xpath("//a[text()='" + verifyLink + "']")).size();
            sa.assertEquals(size, 1, "HyperLink - \"" + verifyLink + "\" not found....");
        }
    }
}

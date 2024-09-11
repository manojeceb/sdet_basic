package com.virtusa.cucumber.gherkin.scenario;

import com.virtusa.cucumber.steps.Herokuapp_step;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Herokuapp_scenario extends Herokuapp_step {

    @Given("I open the herokuapp url")
    public void i_open_the_herokuapp_url() {
        openApp();
    }
    @Given("I verify the page title {string}")
    public void i_verify_the_page_title(String title) {
        iVerifyThePageTitle(title);
    }
    @When("I click the {string} link")
    public void i_click_the_link(String link) throws InterruptedException {
        iClickTheLink(link);
    }
    @Then("I verify the text {string}")
    public void i_verify_the_text(String text) throws InterruptedException {
        iVerifyTheText(text);
    }
    @Then("I navigate to home page")
    public void i_navigate_to_home_page() {
        iNavigateToHomePage();
    }
    @Then("I select the option {string} and make sure it is selected")
    public void i_select_the_option_and_make_sure_it_is_selected(String option) throws InterruptedException {
        iSelectTheOptionAndMakeSureItIsSelected(option);
    }
    @Then("I validate the hyperlinks available")
    public void i_validate_the_hyperlinks_available(DataTable dataTable) throws InterruptedException {
        iValidateTheHyperlinksAvailable(dataTable);
    }
}
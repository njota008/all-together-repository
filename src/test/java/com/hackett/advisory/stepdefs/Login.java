package com.hackett.advisory.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseTest {

    @Given("I navigate to the Home Page")
    public void iNavigateToTheHomePage() throws Exception {
        landingPage.navigateToLandingPage();
    }

    @When("I enter {string} and {string} as credentials")
    public void iEnterAndAsCredentials(String user, String password) throws Exception {
        landingPage.loginProcess(user, password);
    }

    @Then("I should login successfully with the proper {string}")
    public void iShouldLoginSuccessfullyWithTheProper(String user) throws Exception {
        clientsPage.validateLoggedUser(user);
    }

    @Then("I should see an alert")
    public void iShouldSeeAnAlert() throws Exception {
        landingPage.validateAlertMessage();
    }

    @And("I should stay in the Home Page")
    public void iShouldStayInTheHomePage() throws Exception {
        landingPage.validatePage();
    }
}


package com.hackett.advisory.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Assessment extends BaseTest {
    @Given("I successfully login in DTP")
    public void iSuccessfullyLoginInDTP() throws Exception {
        landingPage.navigateToLandingPage();
        landingPage.loginProcess("thehackettgrouptest@gmail.com", "welcome1");
        clientsPage.validateLoggedUser("thehackettgrouptest@gmail.com");
    }

    @When("I navigate to the Finance Benefits End-to-End page")
    public void iNavigateToTheFinanceBenefitsEndToEndPage() throws Exception {
        clientsPage.selectClientOption("The Hackett Group - Demo");
        programsPage.navigateToResourcesPage();
        resourcesPage.navigateToFinanceETEBenefitsPage();
    }

    @And("Create and fill a new survey")
    public void createAndFillANewSurvey() throws Exception {
        financeE2EBenefitCasePage.createNewSurvey();
        surveyPage.fillSurvey();
    }
}

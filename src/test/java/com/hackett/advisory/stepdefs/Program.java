package com.hackett.advisory.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Program extends BaseTest {
    @Given("I successfully login with {string} and {string}")
    public void iSuccessfullyLoginWithAnd(String user, String password) throws Exception {
        landingPage.navigateToLandingPage();
        landingPage.loginProcess(user, password);
        clientsPage.validateLoggedUser(user);
    }

    @When("I navigate to the DTP Program page")
    public void iNavigateToTheDTPProgramPage() throws Exception {
        clientsPage.selectClientOption("The Hackett Group - Testing");
        homePage.selectAdminOption();
        adminClientPage.navigateToProgramsTab();
        adminProgramsPage.clickOnAddNewProgramBtn();

    }

    @And("I fill all the fields in the Program Info section")
    public void iFillAllTheFieldsIntheProgramInfoSection() throws Exception {
        programCreatePage.fillProgramInfoSection();
    }

    @And("I select the taxonomies and tags")
    public void iSelectTheTaxonomiesAndTags() throws Exception {
        programTaxonomyTagsPage.createGroupOfTaxonomies();
    }

    @And("I select the accelerators")
    public void iSelectTheAccelerators() throws Exception {
        programAcceleratorsPage.selectAccelerators();
    }

    @And("I select the events and performance studies")
    public void iSelectTheEventsAndPerformanceStudies() throws Exception {
        programEventsPerfStudiesPage.selectEvents();
    }

    @And("I supply information about support and inquiries")
    public void iSupplyInformationAboutSupportAndInquiries() throws Exception {
        programSupportInqPage.fillSupportAndInquiriesUrlsFields();
    }

    @And("I select advisors")
    public void iSelectAdvisors() throws Exception {
        programAdvisorsPage.selectPeople();
    }

    @And("I review and publish the program")
    public void iReviewAndPublishTheProgram() throws Exception {
        programReviewPage.reviewProgram();
        errorsPage.validateTextAndPublishProgram();
    }

    @Then("the program is created successfully")
    public void theProgramIsCreatedSuccessfully() throws Exception {
        adminProgramsPage.validateThatNewProgramWasCreated();
    }

    @And("I delete the program")
    public void iDeleteTheProgram() throws Exception {
        adminProgramsPage.navigateToNewProgram();
        programInfoPage.deleteProgram();
        adminProgramsPage.validateThatNewProgramWasDeleted();
    }
}

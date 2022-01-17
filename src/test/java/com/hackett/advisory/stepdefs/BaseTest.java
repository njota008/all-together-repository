package com.hackett.advisory.stepdefs;

import com.hackett.advisory.pages.*;
import com.hackett.core.stepdefs.Hooks;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.hackett.core.stepdefs.Hooks.driver;


public class BaseTest {

//    protected ChromeDriver driver = Hooks.getDriver();
    protected LandingPage landingPage = new LandingPage(driver);
    protected ClientsPage clientsPage = new ClientsPage(driver);
    protected ProgramsPage programsPage = new ProgramsPage(driver);
    protected ResourcesPage resourcesPage = new ResourcesPage(driver);
    protected FinanceE2EBenefitCasePage financeE2EBenefitCasePage = new FinanceE2EBenefitCasePage(driver);
    protected SurveyPage surveyPage = new SurveyPage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected AdminClientPage adminClientPage = new AdminClientPage(driver);
    protected AdminProgramsPage adminProgramsPage = new AdminProgramsPage(driver);
    protected ProgramCreatePage programCreatePage = new ProgramCreatePage(driver);
    protected ProgramTaxonomyTagsPage programTaxonomyTagsPage = new ProgramTaxonomyTagsPage(driver);
    protected ProgramAcceleratorsPage programAcceleratorsPage = new ProgramAcceleratorsPage(driver);
    protected ProgramEventsPerfStudiesPage programEventsPerfStudiesPage = new ProgramEventsPerfStudiesPage(driver);
    protected ProgramSupportInqPage programSupportInqPage = new ProgramSupportInqPage(driver);
    protected ProgramAdvisorsPage programAdvisorsPage = new ProgramAdvisorsPage(driver);
    protected ProgramReviewPage programReviewPage = new ProgramReviewPage(driver);
    protected ErrorsPage errorsPage = new ErrorsPage(driver);
    protected ProgramInfoPage programInfoPage = new ProgramInfoPage(driver);

}

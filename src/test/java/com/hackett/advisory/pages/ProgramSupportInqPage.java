package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramSupportInqPage extends BasePage {

    public ProgramSupportInqPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "/support-inquiries-urls";
    static final By taxonomyTagsLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"taxonomy-tags\")]");
    static final By acceleratorsLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"accelerators\")]");
    static final By eventsPerfStudiesLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"events\")]");
    static final By supportInquiriesLabel = By.xpath("//a[@class=\"btn btn-primary\" and contains(@href,\"support-inquiries-urls\")]");
    static final By peopleLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"advisors\")]");
    static final By reviewLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"review\")]");
    static final By supportFreshdeskUrlInput = By.cssSelector("input[name=\"support-freshdesk-url\"]");
    static final By inquiriesFreshdeskUrlInput = By.cssSelector("input[name=\"inquiries-freshdesk-url\"]");
    static final By saveAndContinueBtn = By.cssSelector("a[data-save=\"continue\"]");

    public void fillSupportAndInquiriesUrlsFields() throws Exception {
        waitForElementVisibility(taxonomyTagsLabel);
        waitForElementVisibility(acceleratorsLabel);
        waitForElementVisibility(eventsPerfStudiesLabel);
        waitForElementVisibility(supportInquiriesLabel);
        waitForElementVisibility(peopleLabel);
        waitForElementVisibility(reviewLabel);
        assertThat(getCurrentUrl()).contains(URL);
//        sendKeys(supportFreshdeskUrlInput, readFromFile("DTP_HELP_URL"));
        sendKeys(supportFreshdeskUrlInput, System.getProperty("DTP_HELP_URL"));
//        sendKeys(inquiriesFreshdeskUrlInput, readFromFile("DTP_HELP_URL"));
        sendKeys(inquiriesFreshdeskUrlInput, System.getProperty("DTP_HELP_URL"));
        click(saveAndContinueBtn);
    }
}

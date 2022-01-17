package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramReviewPage extends BasePage {

    public ProgramReviewPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "/review";
    static final By taxonomyTagsLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"taxonomy-tags\")]");
    static final By acceleratorsLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"accelerators\")]");
    static final By eventsPerfStudiesLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"events\")]");
    static final By supportInquiriesLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"support-inquiries-urls\")]");
    static final By peopleLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"advisors\")]");
    static final By reviewLabel = By.xpath("//a[@class=\"btn btn-primary\" and contains(@href,\"review\")]");
    static final By bestPracticesNumber = By.cssSelector("div[data-indicator=best-practices] > h2");
    static final By performanceMetricsNumber = By.cssSelector("div[data-indicator=performance-metrics] > h2");
    static final By acceleratorsNumber = By.cssSelector("div[data-indicator=accelerators] > h2");
    static final By bottomSectionBpTotalRecords = By.xpath("//h5[contains(text(),\"Best Practices\")]");
    static final By bottomSectionPmTotalRecords = By.xpath("//h5[contains(text(),\"Performance Metrics\")]");
    static final By bottomSectionAccTotalRecords = By.xpath("//h5[contains(text(),\"Accelerators\")]");
    static final By saveAndContinueBtn = By.cssSelector("a[data-save=\"continue\"]");

    public void reviewProgram() throws Exception {
        waitForElementVisibility(taxonomyTagsLabel);
        waitForElementVisibility(acceleratorsLabel);
        waitForElementVisibility(eventsPerfStudiesLabel);
        waitForElementVisibility(supportInquiriesLabel);
        waitForElementVisibility(peopleLabel);
        waitForElementVisibility(reviewLabel);
        assertThat(getCurrentUrl()).contains(URL);
        int bpNumber = Integer.parseInt(getText(bestPracticesNumber));
        int pmNumber = Integer.parseInt(getText(performanceMetricsNumber));
        int accNumber = Integer.parseInt(getText(acceleratorsNumber));
        String bottomBpNumberText = getText(bottomSectionBpTotalRecords);
        bottomBpNumberText = bottomBpNumberText.replaceAll("[^0-9]", "");
        int bottomBPNumber = Integer.parseInt(bottomBpNumberText);
        click(performanceMetricsNumber);
        String bottomPmNumberText = getText(bottomSectionPmTotalRecords);
        bottomPmNumberText = bottomPmNumberText.replaceAll("[^0-9]", "");
        int BOTTOM_PM_NUMBER = Integer.parseInt(bottomPmNumberText);
        click(acceleratorsNumber);
        String bottomAccNumberText = getText(bottomSectionAccTotalRecords);
        bottomAccNumberText = bottomAccNumberText.replaceAll("[^0-9]", "");
        int bottomAccNumber = Integer.parseInt(bottomAccNumberText);
        assertThat(bpNumber).isEqualTo(bottomBPNumber);
        assertThat(pmNumber).isEqualTo(BOTTOM_PM_NUMBER);
        assertThat(accNumber).isEqualTo(bottomAccNumber);
        click(saveAndContinueBtn);
    }
}

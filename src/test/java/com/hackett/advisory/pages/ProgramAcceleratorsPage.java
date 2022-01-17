package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramAcceleratorsPage extends BasePage {

    public ProgramAcceleratorsPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/admin/program/accelerators";
    static final By taxonomyTagsLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"taxonomy-tags\")]");
    static final By acceleratorsLabel = By.xpath("//a[@class=\"btn btn-primary\" and contains(@href,\"accelerators\")]");
    static final By supportInquiriesLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"support-inquiries-urls\")]");
    static final By eventsPerfStudiesLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"events\")]");
    static final By peopleLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"advisors\")]");
    static final By reviewLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"review\")]");
    static final By saveAndContinueBtn = By.cssSelector("a[data-save=\"continue\"]");

    static By getAcceleratorsInput(String type, int i) {
        return By.xpath("(//input[@data-accelerator=\"" + type + "\"])[" + i + "]");
    }

    public void selectAccelerators() throws Exception {
        waitForElementVisibility(taxonomyTagsLabel);
        waitForElementVisibility(acceleratorsLabel);
        waitForElementVisibility(supportInquiriesLabel);
        waitForElementVisibility(eventsPerfStudiesLabel);
        waitForElementVisibility(peopleLabel);
        waitForElementVisibility(reviewLabel);
        assertThat(getCurrentUrl()).contains(URL);
        click(getAcceleratorsInput("surveyIds", 4));
        click(getAcceleratorsInput("surveyIds", 8));
        click(getAcceleratorsInput("surveyIds", 10));
        click(getAcceleratorsInput("softwareVersionIds", 2));
        click(saveAndContinueBtn);
    }
}

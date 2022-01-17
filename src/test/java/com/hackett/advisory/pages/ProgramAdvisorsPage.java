package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramAdvisorsPage extends BasePage {

    public ProgramAdvisorsPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "/advisors";
    static final By taxonomyTagsLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"taxonomy-tags\")]");
    static final By acceleratorsLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"accelerators\")]");
    static final By eventsPerfStudiesLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"events\")]");
    static final By supportInquiriesLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"support-inquiries-urls\")]");
    static final By peopleLabel = By.xpath("//a[@class=\"btn btn-primary\" and contains(@href,\"advisors\")]");
    static final By reviewLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"review\")]");
    static final By saveAndContinueBtn = By.cssSelector("a[data-save=\"continue\"]");

    public final By getPeopleCheckbox(int i) {
        return By.xpath("(//div[@class=\"checkbox pull-left\"]//input[@type=\"checkbox\"])[" + i + "]");
    }

    public final By getPeoplesRoleInput(int i) {
        return By.xpath("(//div[@class=\"form-group\"]//input[@class=\"form-control input-lg role-input\"])[" + i + "]");
    }

    public void selectPeople() throws Exception {
        waitForElementVisibility(taxonomyTagsLabel);
        waitForElementVisibility(acceleratorsLabel);
        waitForElementVisibility(eventsPerfStudiesLabel);
        waitForElementVisibility(supportInquiriesLabel);
        waitForElementVisibility(peopleLabel);
        waitForElementVisibility(reviewLabel);
        assertThat(getCurrentUrl()).contains(URL);
        click(getPeopleCheckbox(1));
        sendKeys(getPeoplesRoleInput(1), "Advisor");
        click(getPeopleCheckbox(2));
        sendKeys(getPeoplesRoleInput(2), "Advisor");
        click(getPeopleCheckbox(5));
        sendKeys(getPeoplesRoleInput(5), "Advisor");
        click(getPeopleCheckbox(9));
        sendKeys(getPeoplesRoleInput(9), "Advisor");
        click(saveAndContinueBtn);
    }
}

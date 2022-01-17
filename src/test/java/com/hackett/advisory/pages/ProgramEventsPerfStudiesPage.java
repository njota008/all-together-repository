package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramEventsPerfStudiesPage extends BasePage {

    public ProgramEventsPerfStudiesPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/events";
    static final By taxonomyTagsLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"taxonomy-tags\")]");
    static final By acceleratorsLabel = By.xpath("//a[@class=\"btn btn-success\" and contains(@href,\"accelerators\")]");
    static final By eventsPerfStudiesLabel = By.xpath("//a[@class=\"btn btn-primary\" and contains(@href,\"events\")]");
    static final By supportInquiriesLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"support-inquiries-urls\")]");
    static final By peopleLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"advisors\")]");
    static final By reviewLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"review\")]");
//    static final By calendarCheckbox = By.cssSelector("input[filter-key=\"DEFAULT\"]");
    static final By surveyCheckbox = By.cssSelector("input[filter-key=\"PERFORMANCE_STUDY\"]");
//    static final By activeCheckbox = By.cssSelector("input[filter-key=\"ACTIVE\"]");
    static final By inactiveCheckbox = By.cssSelector("input[filter-key=\"INACTIVE\"]");
    static final By searchInput = By.cssSelector("#search-input");

    static By getEventCheckbox(int i) {
        return By.xpath("(//tr[@filter-1=\"DEFAULT\" and not (@style=\"display: none;\")]//td[@data-search]/input[@type=\"checkbox\"])[" + i + "]");
    }

    static final By saveAndContinueBtn = By.cssSelector("a[data-save=\"continue\"]");

    public void selectEvents() throws Exception {
        waitForElementVisibility(taxonomyTagsLabel);
        waitForElementVisibility(acceleratorsLabel);
        waitForElementVisibility(eventsPerfStudiesLabel);
        waitForElementVisibility(supportInquiriesLabel);
        waitForElementVisibility(peopleLabel);
        waitForElementVisibility(reviewLabel);
        assertThat(getCurrentUrl()).contains(URL);
        click(surveyCheckbox);
        click(inactiveCheckbox);
        sendKeys(searchInput, "2020");
        click(getEventCheckbox(1));
        click(getEventCheckbox(2));
        click(getEventCheckbox(3));
        click(saveAndContinueBtn);
    }
}

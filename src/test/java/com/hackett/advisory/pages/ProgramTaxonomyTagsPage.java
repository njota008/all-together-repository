package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramTaxonomyTagsPage extends BasePage {

    public ProgramTaxonomyTagsPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/admin/program/taxonomy-tags";
    static final By taxonomyTagsLabel = By.xpath("//a[@class=\"btn btn-primary\" and contains(@href,\"taxonomy-tags\")]");
    static final By acceleratorsLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"accelerators\")]");
    static final By supportInquiriesLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"support-inquiries-urls\")]");
    static final By eventsPerfStudiesLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"events\")]");
    static final By peopleLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"advisors\")]");
    static final By reviewLabel = By.xpath("//a[@class=\"btn btn-gray\" and contains(@href,\"review\")]");
    static final By addGroupBtn = By.cssSelector("button[data-add-group-button]");
    static final By saveAndContinueBtn = By.cssSelector("a[data-save=\"continue\"]");

    static By getIpToDrag(int i) {
        return By.xpath("//ul[@id=\"items-sortable\"]/li[" + i + "]");
    }

    static By getNewGroupTitleInput(int i) {
        return By.xpath("(//*[@id=\"group-sortable\"]//input[@placeholder=\"Name your group\"])[" + i + "]");
    }

    static By getNewTopicTitleInput(int i) {
        return By.xpath("(//ul[@class=\"sortable connected-sortable ui-sortable\"]//input)[" + i + "]");
    }

    static By getNewTopicTitle(int i) {
        return By.xpath("(//ul[@class=\"sortable connected-sortable ui-sortable\"])[" + i + "]");
    }

    static By getAddTopicBtn(int i) {
        return By.xpath("(//button[@data-add-topic-button])[" + i + "]");
    }

    static By getDoneBtn(int i) {
        return By.xpath("(//*[@id=\"group-sortable\"]//button[@data-done-button])[" + i + "]");
    }

    public void createGroupOfTaxonomies() throws Exception {
        waitForElementVisibility(taxonomyTagsLabel);
        waitForElementVisibility(acceleratorsLabel);
        waitForElementVisibility(eventsPerfStudiesLabel);
        waitForElementVisibility(supportInquiriesLabel);
        waitForElementVisibility(peopleLabel);
        waitForElementVisibility(reviewLabel);
        assertThat(getCurrentUrl()).contains(URL);
        click(addGroupBtn);
        sendKeys(getNewGroupTitleInput(1), "Automation Test Group");
        click(getAddTopicBtn(1));
        sendKeys(getNewTopicTitleInput(1), "Automation Test Topic");
        click(getDoneBtn(2));
        dragAndDropElement(getIpToDrag(1), getNewTopicTitle(1));
        dragAndDropElement(getIpToDrag(5), getNewTopicTitle(1));
        dragAndDropElement(getIpToDrag(7), getNewTopicTitle(1));
        dragAndDropElement(getIpToDrag(9), getNewTopicTitle(1));
        click(addGroupBtn);
        sendKeys(getNewGroupTitleInput(2), "Automation Test Group 2");
        click(getAddTopicBtn(2));
        sendKeys(getNewTopicTitleInput(2), "Automation Test Topic 2");
        click(getDoneBtn(4));
        dragAndDropElement(getIpToDrag(2), getNewTopicTitle(2));
        dragAndDropElement(getIpToDrag(4), getNewTopicTitle(2));
        dragAndDropElement(getIpToDrag(6), getNewTopicTitle(2));
        dragAndDropElement(getIpToDrag(8), getNewTopicTitle(2));
        click(saveAndContinueBtn);
    }
}

package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class FinanceE2EBenefitCasePage extends BasePage {

    public FinanceE2EBenefitCasePage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/dashboard/7e1520b3-ee48-4f58-a3ae-5e68a4f239ed";
    private final By loadingCircle = By.cssSelector("div.loading-circle");
    private final By newSurvey = By.xpath("//a[@take-survey-button]/span[1]");

    public void createNewSurvey() throws Exception {
        assertThat(getCurrentUrl()).contains(URL);
        waitForElementToDisappear(loadingCircle);
        click(newSurvey);
    }
}

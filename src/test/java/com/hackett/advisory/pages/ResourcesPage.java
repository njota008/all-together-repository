package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ResourcesPage extends BasePage {

    public ResourcesPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/programs?programIdentifier=47b740ec-5241-4abe-966a-2ee2c250cf81";
    private final By financeETEBenefitsResults = By.xpath("//a[@href=\"/dashboard/7e1520b3-ee48-4f58-a3ae-5e68a4f239ed\"]");

    public void navigateToFinanceETEBenefitsPage() throws Exception {
        assertThat(getCurrentUrl()).contains(URL);
        click(financeETEBenefitsResults);
    }
}

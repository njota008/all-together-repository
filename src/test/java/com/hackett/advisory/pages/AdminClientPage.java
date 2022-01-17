package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AdminClientPage extends BasePage {

    public AdminClientPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/admin/clients";
    static final By programManagementTabOption = By.cssSelector("a[href=\"/admin/programs\"]");

    public void navigateToProgramsTab() throws Exception {
        waitForElementVisibility(programManagementTabOption);
        assertThat(getCurrentUrl()).contains(URL);
        click(programManagementTabOption);
    }
}

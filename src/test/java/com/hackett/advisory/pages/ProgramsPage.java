package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramsPage extends BasePage {

    public ProgramsPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/programs/epm-program";
    static final By resourcesTab = By.cssSelector("#top-nav-accelerators");

    public void navigateToResourcesPage() throws Exception {
        assertThat(getCurrentUrl()).contains(URL);
        click(resourcesTab);
    }
}

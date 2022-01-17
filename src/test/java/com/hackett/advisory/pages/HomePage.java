package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/programs/epm-program";
    static final By clientMenu = By.cssSelector("a.dropdown-link");
    static final By clientMenuAdminOption = By.cssSelector("a[href=\"/admin\"]");

    public void selectAdminOption() throws Exception {
        waitForElementVisibility(clientMenu);
        assertThat(getCurrentUrl()).contains(URL);
        click(clientMenu);
        click(clientMenuAdminOption);
    }
}

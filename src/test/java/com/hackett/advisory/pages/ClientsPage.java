package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientsPage extends BasePage {

    public ClientsPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/clients/select?program=epm-program&from=0&letter=all";
    static final By loggedUser = By.cssSelector("a.dropdown-link");

    static By getClientOption(String client) {
        return By.xpath("//a[@url-name=\"epm-program\" and contains(text(),\"" + client + "\")]");
    }

    static final By clientSelected = By.cssSelector("li.inline-display.client-name");

    public void validateLoggedUser(String email) throws Exception {
        waitForElementVisibility(loggedUser);
        assertThat(getCurrentUrl()).contains(URL);
        assertThat(getText(loggedUser)).isEqualTo(email);
    }

    public void selectClientOption(String client) throws Exception {
        click(getClientOption(client));
        assertThat(getText(clientSelected)).isEqualTo(client);
    }
}

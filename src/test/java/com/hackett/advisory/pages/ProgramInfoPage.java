package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramInfoPage extends BasePage {


    public ProgramInfoPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/admin/program";
    static final By deleteProgramBtn = By.cssSelector("a.delete-program");

    public void deleteProgram() throws Exception {
        waitForElementVisibility(deleteProgramBtn);
        assertThat(getCurrentUrl()).contains(URL);
        click(deleteProgramBtn);
        handleAlert("Accept");
    }
}

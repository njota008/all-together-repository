package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ErrorsPage extends BasePage {

    public ErrorsPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/errors";
    static final By mainText = By.cssSelector("h4");
    static final By publishProgramBtn = By.cssSelector("a.btn.btn-file.btn-success.btn-lg");

    public void validateTextAndPublishProgram() throws Exception {
        waitForElementVisibility(publishProgramBtn);
        assertThat(getCurrentUrl()).contains(URL);
        assertThat(getText(mainText)).isEqualTo("All fields are complete. Click on \"Publish Program\" when ready");
        click(publishProgramBtn);
    }

}

package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramCreatePage extends BasePage {

    public ProgramCreatePage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/admin/program/create";
    static final By newProgramTitle = By.cssSelector("h1.inline-element");
    static final By programNameInput = By.cssSelector("input[name=\"program-name\"]");
    static final By programDescriptionIframe = By.xpath("//iframe[contains(@title,\"program-description\")]");
    static final By programDescriptionTextArea = By.cssSelector("body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders");
    static final By productNameInput = By.cssSelector("input[name=\"product-name\"]");
    static final By programUrlInput = By.cssSelector("input[name=\"program-url\"]");
    static final By supportEmailAddressInput = By.cssSelector("input[name=\"support-email-address\"]");
    static final By fresdeshPortalUrlInput = By.cssSelector("input[name=\"freshdesk-portal-url\"]");
    static final By emailSignatureTextArea = By.cssSelector("textarea[name=\"email-signature\"]");
    static final By worldClassCheckbox = By.cssSelector("#metric-type-world-class");
    static final By topPerformerCheckbox = By.cssSelector("#metric-type-top-performer");
    static final By saveAndContinueBtn = By.cssSelector("a[data-save=\"continue\"]");

    public void fillProgramInfoSection() throws Exception {
        waitForElementVisibility(newProgramTitle);
        assertThat(getCurrentUrl()).contains(URL);
//        sendKeys(programNameInput, readFromFile("PROGRAM_NAME"));
        sendKeys(programNameInput, System.getProperty("PROGRAM_NAME"));
        threadSleep(5000);
        switchToFrame(programDescriptionIframe);
        sendKeys(programDescriptionTextArea, "The Digital Transformation Platform (DTP) accelerates clients on their journey to world-class performance by quantifying improvement opportunities and focusing implementation efforts on best practices driving the greatest business benefit.");
        switchToDefaultFrame();
        sendKeys(productNameInput, "Digital Transformation Automation Test");
        sendKeys(programUrlInput, "dt-automation-test-" + getRandomNumber(9999999));
        sendKeys(supportEmailAddressInput, "dtpsupport@poweredbyhackett.com");
//        sendKeys(fresdeshPortalUrlInput, readFromFile("DTP_HELP_URL"));
        sendKeys(fresdeshPortalUrlInput, System.getProperty("DTP_HELP_URL"));
        sendKeys(emailSignatureTextArea, "The Hackett Group");
        click(worldClassCheckbox);
        click(topPerformerCheckbox);
        click(saveAndContinueBtn);
//        if (waitForAlertToAppear()) {
//            String alertText = handleAlert("Text");
//            System.out.println(alertText);
//            handleAlert("Accept");
//        }
    }
}

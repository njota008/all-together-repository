package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    private final String URL = "-dtp.poweredbyhackett.com/accounts/sign-in";
    private final By usernameInput = By.cssSelector("input[type=email]");
    private final By passwordInput = By.cssSelector("input[type=password]");
    private final By signInBtn = By.cssSelector("a.button.account-form__button");
    private final By verifiedAccountMsg = By.cssSelector("p.flash-message.positive");

    public void navigateToLandingPage() throws Exception {
        driver.get(System.getenv("BASE_URL"));
        assertThat(getCurrentUrl()).contains(URL);
    }

    public void loginProcess(String user, String password) throws Exception {
        sendKeys(usernameInput, user);
        sendKeys(passwordInput, password);
        click(signInBtn);
    }

    public void validateAlertMessage() throws Exception {
        waitForAlertToAppear();
        assertThat(handleAlert("Text")).contains("Sorry, we were unable to authenticate the email address and password you provided.");
        handleAlert("Dismiss");
    }

    public void validatePage() {
        assertThat(driver.getCurrentUrl()).contains(URL);
    }

//    public void validateAccountVerifiedMessage() throws Exception {
//        Utils.waitFor(driver, ExpectedConditions.visibilityOfElementLocated(verifiedAccountMsg));
//        assertThat(getCurrentUrl()).isEqualTo(URL);
//        String VERIFIED_ACCOUNT_MSG_TEXT = driver.findElement(verifiedAccountMsg).getText();
//        assertThat(VERIFIED_ACCOUNT_MSG_TEXT).isEqualTo("Thank you, your account has been verified. Please sign in.");
//    }
}

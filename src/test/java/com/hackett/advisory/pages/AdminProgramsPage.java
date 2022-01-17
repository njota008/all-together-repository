package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AdminProgramsPage extends BasePage {


    public AdminProgramsPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "/admin/programs";
    static final By addNewProgramBtn = By.cssSelector("a.btn.btn.btn-success.pull-right");
    static final By successMessage = By.cssSelector("div.alert.alert-success");

    static By getNewProgram(String property) throws Exception {
//        return By.xpath("//a[contains(text(),\"" + readFromFile(property) + "\")]");
        return By.xpath("//a[contains(text(),\"" + System.getProperty(property) + "\")]");
    }

    public void clickOnAddNewProgramBtn() throws Exception {
        waitForElementVisibility(addNewProgramBtn);
        assertThat(getCurrentUrl()).contains(URL);
        click(addNewProgramBtn);
    }

    public void validateThatNewProgramWasCreated() throws Exception {
        threadSleep(5000);
        waitForElementVisibility(addNewProgramBtn);
        assertThat(getCurrentUrl()).contains(URL);
        String successMessageText = getText(successMessage);
//        assertThat(successMessageText).isEqualTo("Program " + readFromFile("PROGRAM_NAME") + " has been published");
        assertThat(successMessageText).isEqualTo("Program " + System.getProperty("PROGRAM_NAME") + " has been published");
    }

    public void navigateToNewProgram() throws Exception {
        click(getNewProgram("PROGRAM_NAME"));
    }

    public void validateThatNewProgramWasDeleted() throws Exception {
        threadSleep(5000);
        waitForElementVisibility(addNewProgramBtn);
        assertThat(getCurrentUrl()).contains(URL);
        String successMessageText = getText(successMessage);
//        assertThat(successMessageText).isEqualTo("Program '" + readFromFile("PROGRAM_NAME") + "' was deleted.");
        assertThat(successMessageText).isEqualTo("Program '" + System.getProperty("PROGRAM_NAME") + "' was deleted.");
    }
}

package com.hackett.advisory.pages;

import com.hackett.core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;

public class SurveyPage extends BasePage {

    public SurveyPage(WebDriver driver) {
        super(driver);
    }

    static final String URL = "https://thehackettgroup.co1.qualtrics.com/jfe/form/SV_3xzdTvjEKzuP5XL?return=https%3A%2F%2Fmirror-dtp.poweredbyhackett.com%2Fscorecard%2Fcompleted%2F%3FsurveyUrlId%";
    private final By firstNameInput = By.xpath("(//td[@class=\"ControlContainer\"])[1]/input");
    private final By lastNameInput = By.xpath("(//td[@class=\"ControlContainer\"])[2]/input");
    private final By emailInput = By.xpath("(//td[@class=\"ControlContainer\"])[3]/input");
    private final By titleInput = By.xpath("(//td[@class=\"ControlContainer\"])[4]/input");
    private final By nextBtn = By.cssSelector("#NextButton");
    private final By totalRevenueUSD = By.xpath("(//input)[1]");
    private final By laborCostUSD = By.xpath("//div[@class=\"QuestionBody BorderColor\"]//li[1]//input");
    private final By outsourcingCostUSD = By.xpath("//div[@class=\"QuestionBody BorderColor\"]//li[2]//input");
    private final By technologyCostUSD = By.xpath("//div[@class=\"QuestionBody BorderColor\"]//li[3]//input");
    private final By otherCostUSD = By.xpath("//div[@class=\"QuestionBody BorderColor\"]//li[4]//input");
    private final By FTEs = By.xpath("(//div[@class=\"QuestionBody\"])[2]//input");
    private final By financeTechSpend = By.xpath("(//div[@class=\"QuestionBody\"])[3]//input");

    private By FTEselect(int i) {
        return By.xpath("(//div[@class=\"QuestionBody  \"]//tbody//select)[" + i + "]");
    }

    private By areaToEvaluate(int i) {
        return By.xpath("(//span[@class=\"LabelWrapper\"])[" + i + "]");
    }

    private final By customerToCash = By.xpath("((//div[@class=\"QuestionBody\"])[1]//input)[1]");
    private final By customerToCashOutsourcing = By.xpath("((//div[@class=\"QuestionBody\"])[1]//input)[2]");

    private By barSlide(int i) {
        return By.xpath("(//div[@class=\"BarContainer\"])[" + i + "]/div/div/div[2]");
    }

    private By ProcessCostPerc(int i) {
        return By.xpath("((//div[@class=\"QuestionBody  q-matrix desktop\"])[1]//tbody/tr[" + i + "]/td/input)[1]");
    }

    private By ProcessFTEPerc(int i) {
        return By.xpath("((//div[@class=\"QuestionBody  q-matrix desktop\"])[1]//tbody/tr[" + i + "]/td/input)[2]");
    }

    private By CustomerBillingVolumeInput(int i) {
        return By.xpath("((//div[@class=\"QuestionBody\"])[3]//input)[" + i + "]");
    }

    private final By averageTimeBill = By.xpath("((//div[@class=\"QuestionBody\"])[4]//input)[1]");
    private final By averageInvoiceDisputeResolution = By.xpath("((//div[@class=\"QuestionBody\"])[5]//input)[1]");
    private final By DSO = By.xpath("((//div[@class=\"QuestionBody\"])[6]//input)[1]");
    private final By BPDSO = By.xpath("((//div[@class=\"QuestionBody\"])[7]//input)[1]");
    private final By WACC = By.xpath("((//div[@class=\"QuestionBody\"])[8]//input)[1]");
    private final By badDebtValue = By.xpath("((//div[@class=\"QuestionBody\"])[9]//input)[1]");

    private By getRadioBtn(int i) {
        return By.xpath("((//div[@class=\"QuestionBody  q-matrix desktop\"])[2]//label)[" + i + "]");
    }

    private final By accountToReportLabor = By.xpath("((//div[@class=\"QuestionBody\"])[1]//input)[1]");
    private final By accountToReportOutsoursing = By.xpath("((//div[@class=\"QuestionBody\"])[1]//input)[2]");
    private final By avgMonthlyCycle = By.xpath("(//div[@class=\"QuestionBody\"])[3]//input");
    private final By quarterlyResults = By.xpath("(//div[@class=\"QuestionBody\"])[4]//input");
    private final By afterPeriod = By.xpath("(//div[@class=\"QuestionBody\"])[5]//input");
    private final By activeAccounts = By.xpath("(//div[@class=\"QuestionBody\"])[6]//input");
    private final By reportingEntities = By.xpath("(//div[@class=\"QuestionBody\"])[7]//input");
    private final By externalReportVolume = By.xpath("(//div[@class=\"QuestionBody\"])[8]//input");
    private final By minimumMaterialityLvl = By.xpath("(//div[@class=\"QuestionBody\"])[9]//input");
    private final By planToResultsLabor = By.xpath("((//div[@class=\"QuestionBody\"])[1]//input)[1]");
    private final By planToResultsOutsoursing = By.xpath("((//div[@class=\"QuestionBody\"])[1]//input)[2]");
    private final By financialPlanCycleTime = By.xpath("(//div[@class=\"QuestionBody\"])[3]//input");
    private final By monthlyFinancialForecast = By.xpath("(//div[@class=\"QuestionBody\"])[4]//input");
    private final By lineItemsBudget = By.xpath("(//div[@class=\"QuestionBody\"])[5]//input");
    private final By lineItemsHq = By.xpath("(//div[@class=\"QuestionBody\"])[6]//input");
    private final By iterationsAnnual = By.xpath("(//div[@class=\"QuestionBody\"])[7]//input");
    private final By totalVolumeReports = By.xpath("(//div[@class=\"QuestionBody\"])[8]//input");
    private final By avgTimeRequired = By.xpath("(//div[@class=\"QuestionBody\"])[9]//input");


    public void fillSurvey() throws Exception {
        Thread.sleep(3000);
//        System.out.println(getWindowIds());
        switchToSecondTab();
        assertThat(getCurrentUrl()).contains(URL);
        sendKeys(firstNameInput, "Allison");
        sendKeys(lastNameInput, "Caron");
        sendKeys(emailInput, "acaron@thehackettgroup.com");
        sendKeys(titleInput, "01-0943");
        click(nextBtn);
        Thread.sleep(3000);
        sendKeys(totalRevenueUSD, "5000000000");
        sendKeys(laborCostUSD, "21304633");
        sendKeys(outsourcingCostUSD, "6652223");
        sendKeys(technologyCostUSD, "5047871");
        sendKeys(otherCostUSD, "4130463");
        sendKeys(FTEs, "215");
        sendKeys(financeTechSpend, "401774.52");
        Select FTEselect1 = new Select(driver.findElement(FTEselect(1)));
        FTEselect1.selectByIndex(1);
        Select FTEselect2 = new Select(findElement(FTEselect(2)));
        FTEselect2.selectByIndex(2);
        Select FTEselect3 = new Select(findElement(FTEselect(3)));
        FTEselect3.selectByIndex(3);
        Select FTEselect4 = new Select(findElement(FTEselect(4)));
        FTEselect4.selectByIndex(4);
        Select FTEselect5 = new Select(findElement(FTEselect(5)));
        FTEselect5.selectByIndex(1);
        Select FTEselect6 = new Select(findElement(FTEselect(6)));
        FTEselect6.selectByIndex(2);
        Select FTEselect7 = new Select(findElement(FTEselect(7)));
        FTEselect7.selectByIndex(2);
        Select FTEselect8 = new Select(findElement(FTEselect(8)));
        FTEselect8.selectByIndex(4);
        Select FTEselect9 = new Select(findElement(FTEselect(9)));
        FTEselect9.selectByIndex(2);
        Select FTEselect10 = new Select(findElement(FTEselect(10)));
        FTEselect10.selectByIndex(3);
        Select FTEselect11 = new Select(findElement(FTEselect(11)));
        FTEselect11.selectByIndex(4);
        click(nextBtn);
        Thread.sleep(3000);
        click(areaToEvaluate(1));
        click(areaToEvaluate(2));
        click(areaToEvaluate(3));
        click(nextBtn);
        Thread.sleep(3000);
        sendKeys(customerToCash, "4507290");
        sendKeys(customerToCashOutsourcing, "227209");
        sendKeys(FTEs, "81");
        moveSlide(barSlide(1), 570, 0);
        sendKeys(ProcessCostPerc(1), "20");
        sendKeys(ProcessFTEPerc(1), "20");
        sendKeys(ProcessCostPerc(2), "10");
        sendKeys(ProcessFTEPerc(2), "10");
        sendKeys(ProcessCostPerc(3), "30");
        sendKeys(ProcessFTEPerc(3), "30");
        sendKeys(ProcessCostPerc(4), "10");
        sendKeys(ProcessFTEPerc(4), "10");
        sendKeys(ProcessCostPerc(5), "15");
        sendKeys(ProcessFTEPerc(5), "15");
        sendKeys(ProcessCostPerc(6), "15");
        sendKeys(ProcessFTEPerc(6), "15");
        sendKeys(CustomerBillingVolumeInput(1), "600000");
        sendKeys(CustomerBillingVolumeInput(2), "300000");
        sendKeys(CustomerBillingVolumeInput(3), "700000");
        moveSlide(barSlide(2), 240, 0);
        moveSlide(barSlide(3), 280, 0);
        moveSlide(barSlide(4), 30, 0);
        moveSlide(barSlide(5), 30, 0);
        sendKeys(averageTimeBill, "3.22");
        moveSlide(barSlide(6), 380, 0);
        moveSlide(barSlide(7), 40, 0);
        sendKeys(averageInvoiceDisputeResolution, "17.4");
        moveSlide(barSlide(8), 90, 0);
        moveSlide(barSlide(9), 110, 0);
        moveSlide(barSlide(10), 860, 0);
        moveSlide(barSlide(11), 950, 0);
        sendKeys(DSO, "38.1");
        sendKeys(BPDSO, "27.5");
        sendKeys(WACC, "8.2");
        moveSlide(barSlide(12), 90, 0);
        moveSlide(barSlide(13), 60, 0);
        moveSlide(barSlide(14), 20, 0);
        sendKeys(badDebtValue, "2000000");
        click(getRadioBtn(2));
        click(getRadioBtn(15));
        click(getRadioBtn(26));
        click(nextBtn);
        Thread.sleep(3000);
        click(nextBtn);
        Thread.sleep(3000);
        sendKeys(accountToReportLabor, "5809837");
        sendKeys(accountToReportOutsoursing, "500128.75");
        sendKeys(FTEs, "60");
        moveSlide(barSlide(1), 620, 0);
        sendKeys(ProcessCostPerc(1), "5");
        sendKeys(ProcessFTEPerc(1), "5");
        sendKeys(ProcessCostPerc(2), "20");
        sendKeys(ProcessFTEPerc(2), "20");
        sendKeys(ProcessCostPerc(3), "15");
        sendKeys(ProcessFTEPerc(3), "15");
        sendKeys(ProcessCostPerc(4), "40");
        sendKeys(ProcessFTEPerc(4), "40");
        sendKeys(ProcessCostPerc(5), "5");
        sendKeys(ProcessFTEPerc(5), "5");
        sendKeys(ProcessCostPerc(6), "15");
        sendKeys(ProcessFTEPerc(6), "15");
        sendKeys(avgMonthlyCycle, "11");
        sendKeys(quarterlyResults, "55");
        sendKeys(afterPeriod, "2");
        moveSlide(barSlide(2), 860, 0);
        sendKeys(activeAccounts, "1447.75");
        sendKeys(reportingEntities, "445");
        moveSlide(barSlide(3), 20, 0);
        sendKeys(externalReportVolume, "102");
        moveSlide(barSlide(4), 210, 0);
        moveSlide(barSlide(5), 320, 0);
        moveSlide(barSlide(6), 430, 0);
        moveSlide(barSlide(7), 290, 0);
        sendKeys(minimumMaterialityLvl, "500");
        moveSlide(barSlide(8), 400, 0);
        click(getRadioBtn(2));
        click(getRadioBtn(15));
        click(getRadioBtn(26));
        click(nextBtn);
        Thread.sleep(3000);
        click(nextBtn);
        Thread.sleep(3000);
        sendKeys(planToResultsLabor, "11620687.5");
        sendKeys(planToResultsOutsoursing, "208234.8");
        sendKeys(FTEs, "60");
        moveSlide(barSlide(1), 430, 0);
        sendKeys(ProcessCostPerc(1), "15");
        sendKeys(ProcessFTEPerc(1), "15");
        sendKeys(ProcessCostPerc(2), "20");
        sendKeys(ProcessFTEPerc(2), "20");
        sendKeys(ProcessCostPerc(3), "20");
        sendKeys(ProcessFTEPerc(3), "20");
        sendKeys(ProcessCostPerc(4), "30");
        sendKeys(ProcessFTEPerc(4), "30");
        sendKeys(ProcessCostPerc(5), "15");
        sendKeys(ProcessFTEPerc(5), "15");
        moveSlide(barSlide(2), 560, 0);
        moveSlide(barSlide(3), 580, 0);
        moveSlide(barSlide(4), 650, 0);
        sendKeys(financialPlanCycleTime, "105");
        moveSlide(barSlide(5), 1000, 0);
        moveSlide(barSlide(6), 250, 0);
        moveSlide(barSlide(7), 750, 0);
        sendKeys(monthlyFinancialForecast, "15");
        sendKeys(lineItemsBudget, "180");
        sendKeys(lineItemsHq, "235");
        sendKeys(iterationsAnnual, "3");
        sendKeys(totalVolumeReports, "4566");
        moveSlide(barSlide(8), 420, 0);
        moveSlide(barSlide(9), 740, 0);
        moveSlide(barSlide(10), 500, 0);
        sendKeys(avgTimeRequired, "2.5");
        moveSlide(barSlide(11), 500, 0);
        moveSlide(barSlide(12), 250, 0);
        moveSlide(barSlide(13), 520, 0);
        moveSlide(barSlide(14), 940, 0);
        click(getRadioBtn(6));
        click(getRadioBtn(13));
        click(getRadioBtn(26));
        click(nextBtn);
        Thread.sleep(3000);
        click(nextBtn);
        Thread.sleep(3000);
        click(nextBtn);
        Thread.sleep(6000);
    }
}

package com.hackett.core.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.util.*;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static <T> T waitFor(WebDriver driver, ExpectedCondition<T> expectedCondition) {
        return new WebDriverWait(driver, 2_0L).until(expectedCondition);
    }

    public WebElement findElement(By element) throws Exception {
        try {
            return driver.findElement(element);
        } catch (Exception e) {
            //log.error(e.getmsg)
            throw new Exception("element " + element + " not found.");
        }
    }

    public static void threadSleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String property) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("../hackett-automation-testing/src/main/java/com/hackett/resources/config.properties"));
        return properties.getProperty(property).replace("[", "").replace("]", "");
    }

    public void navigateTo(String URL) throws Exception {
        String url = System.getenv("BASE_URL");
//        switch (URL) {
//            case "Base":
//                url = readFromFile("BASE_URL");
//                break;
//            case "DTP Mirror":
//                url = readFromFile("DTP_MIRROR_URL");
//                break;
//            case "Assessment Test":
//                url = readFromFile("ASSESSMENT_TEST_URL");
//        }
        if (driver == null) {
            System.out.println("DRIVER NULL");
        } else {
            try {
                driver.get(url);
            } catch (Exception e) {
                throw new Exception("Was not possible to navigate to the URL: " + url);
            }
        }
    }

    public String getCurrentUrl() throws Exception {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            throw new Exception("Was not possible to get the current URL");
        }
    }

    public void click(By element) throws Exception {
        try {
            waitFor(driver, ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            throw new Exception("Element " + element + " couldn't be clicked.");
        }
    }

    public void sendKeys(By element, String keys) throws Exception {
        try {
            waitFor(driver, ExpectedConditions.elementToBeClickable(element)).clear();
            waitFor(driver, ExpectedConditions.elementToBeClickable(element)).sendKeys(keys);
        } catch (Exception e) {
            throw new Exception("Couldn't send any key to the element " + element);
        }
    }

    public void waitForElementVisibility(By element) throws Exception {
        try {
            waitFor(driver, ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            throw new Exception(element + " is not visible");
        }
    }

    public String getText(By element) throws Exception {
        try {
            return driver.findElement(element).getText();
        } catch (Exception e) {
            throw new Exception("Couldn't get text from element " + element);
        }
    }

    public void waitForElementToDisappear(By element) throws Exception {
        try {
            waitFor(driver, ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (Exception e) {
            throw new Exception(element + " stills visible");
        }
    }

    public boolean waitForAlertToAppear() throws Exception {
        try {
            waitFor(driver, ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            throw new Exception("Alert is not present");
        }
    }

    public Set<String> getWindowIds() {
        return driver.getWindowHandles();
    }

    public void switchToSecondTab() {
        ArrayList<String> tabs = new ArrayList<String>(getWindowIds());
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
//        Iterator<String> iterator = getWindowIds().iterator();
//        String mainWindow = iterator.next();
//        String childWindow = iterator.next();
//        driver.getWindowHandles().
//                driver.close();
//        driver.switchTo().window(iterator.next());
//        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(newTab.get(1));
    }

    public void moveSlide(By element, int xoffset, int yoffset) throws Exception {
        try {
            WebElement slide = findElement(element);
            Actions move = new Actions(driver);
            Action action = move.dragAndDropBy(slide, xoffset, yoffset).build();
            action.perform();
        } catch (Exception e) {
            throw new Exception("");
        }
    }

    public void switchToFrame(By element) throws Exception {
        try {
            driver.switchTo().frame(driver.findElement(element));
        } catch (Exception e) {
            throw new Exception("");
        }
    }

    public void switchToDefaultFrame() throws Exception {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            throw new Exception("");
        }
    }

    public static int getRandomNumber(int number) {
        Random random = new Random();
        return random.nextInt(number) + 1;
    }

    public void dragAndDropElement(By ElementFrom, By ElementTo) throws Exception {
        waitForElementVisibility(ElementFrom);
        waitForElementVisibility(ElementTo);
        Actions builder = new Actions(driver);
        WebElement webElementFrom = driver.findElement(ElementFrom);
        WebElement webElementTo = driver.findElement(ElementTo);
        Action dragAndDrop = builder.clickAndHold(webElementFrom)
                .moveToElement(webElementTo)
                .release(webElementTo)
                .build();
        dragAndDrop.perform();
    }

    public String handleAlert(String action) {
        Alert alert = driver.switchTo().alert();
        String a = "";
        switch (action) {
            case "Accept":
                alert.accept();
                break;
            case "Dismiss":
                alert.dismiss();
                break;
            case "Text":
                a = alert.getText();
        }
        return a;
    }
}

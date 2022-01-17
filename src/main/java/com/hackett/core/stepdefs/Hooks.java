package com.hackett.core.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static ChromeDriver driver;
    public static String CHROMEDRIVERPATH = "C:/Users/NMarinSalas/IdeaProjects/all-together-repository/src/main/java/com/hackett/core/resources/chromedriver/chromedriver.exe";

    @Before(value = "@UI")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVERPATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--allow-insecure-localhost", "--headless", "--window-size=1920,1080");
        if (driver == null) {
            driver = new ChromeDriver(options);
        }
        System.out.println(driver);
        driver.manage().window().maximize();
    }

    @After(value = "@UI")
    public void tearDown() {
        driver.close();
        driver = null;
    }


    public static WebDriver getDriver() {
        return driver;
    }
}

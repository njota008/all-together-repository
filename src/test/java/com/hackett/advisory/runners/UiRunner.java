package com.hackett.advisory.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(tags = "@UI")

public class UiRunner extends BaseRunner {
}

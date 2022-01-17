package com.hackett.advisory.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        tags = "not (@ignore or @ignored)",
        glue = {"com.hackett.core.stepdefs","com.hackett.advisory.stepdefs"},
        features = {"src/test/java/resources/features"},
        plugin = {"pretty",
        "timeline:target/threads_timeline"}
)
public abstract class BaseRunner {
}

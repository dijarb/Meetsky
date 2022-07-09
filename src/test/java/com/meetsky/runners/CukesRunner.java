package com.meetsky.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber-report.json"},
        features = {"src/test/resources/features"},
        glue = {"com/meetsky/step_definitions"},
        dryRun = false,
        tags = "@logout"
)
public class CukesRunner {
}

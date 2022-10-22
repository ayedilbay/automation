package com.test.automationexercise.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "",
        glue = "com/test/automationexercise/stepdefinition",
        dryRun = false,
        tags = "",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}

)

public class ReRunner {
}

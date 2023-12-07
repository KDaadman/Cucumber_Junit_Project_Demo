package com.litigiven.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-reports.html",
        features = "src/test/resources/features",
        glue = "com/litigiven/step_definitions",
        dryRun = false,
        tags = "@wip",
        publish = true  // generating my report with the public link


)
public class CukesRunner {}
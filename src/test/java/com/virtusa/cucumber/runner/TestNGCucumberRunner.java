package com.virtusa.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/scenario1.feature",
        glue = "com.virtusa",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}

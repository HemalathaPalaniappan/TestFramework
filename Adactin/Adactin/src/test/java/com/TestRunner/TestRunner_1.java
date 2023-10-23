package com.TestRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.utilities.GenerateCucumberReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\feature", glue = "com.step", plugin = { "pretty", "json:src/test/java/com/Report/cucumber.json"},publish=true,monochrome = true, tags = "@AdactInLogin and not @Ignore")

public class TestRunner_1 {
	
	@AfterClass
	public static void tearDown() {
		GenerateCucumberReport.generateCucumberReport();
	}
	
}

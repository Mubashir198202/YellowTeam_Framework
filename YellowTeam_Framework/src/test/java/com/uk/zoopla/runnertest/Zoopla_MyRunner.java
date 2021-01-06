package com.uk.zoopla.runnertest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		
		plugin ={"pretty","html:target/cucumber-reports/cucumber.json", "json:target/cucumber.json"},
		monochrome = true,
		dryRun=false,
		features = "Cucumber_Feature", //Location to feature file
		glue = "com.uk.zoopla.stepdeptest" // Location to Stepdefination
		
		
)

public class Zoopla_MyRunner extends AbstractTestNGCucumberTests {

}

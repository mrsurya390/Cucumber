package com.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".\\src\\test\\resources",
		glue = "com.fb",
		tags = "@fb or @ajio",
		plugin = {"html:target/index.html","json:target/report.json"},
		dryRun = false,
		monochrome = true
		)
public class TestRunner {
}
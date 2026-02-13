package com.qa.myrunner;

import java.io.*;
import org.junit.runner.RunWith;
import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"E:/Programming/LearnAutomation/SeleniumCucumberBDDV2/src/main/java/com/qa/features/SelectFlight.feature" }, 
glue = {"/SeleniumCucumberBDDV2/src/main/java/com/qa/stepDefinitions" }, 
monochrome = true, 
dryRun = false)

public class SuiteRunner {

}
package com.qa.myrunner;
//import java.io.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = {"E:/Programming/workspace/SeleniumCucumberBDDV2/src/main/java/com/qa/features/SelectFlight.feature"}, 
	glue = {"/SeleniumCucumberBDDV2/src/main/java/com/qa/stepDefinitions"}, 
	//tags = "@Regression",
	//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	plugin = {"html:target/test-report"},
	monochrome = true, 
	dryRun = false)
	

	public class SuiteRunner 
	{

//		public static void writeExtentReport() 
//		{
//			 Reporter.loadXMLConfig(new File("E:\\Programming\\workspace\\SeleniumCucumberBDD\\extent-config.xml"));
//			 Reporter.setSystemInfo("Brahmam", System.getProperty("user"));
//		     Reporter.setSystemInfo("Time Zone", System.getProperty("timezone"));
//		     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
//		     Reporter.setSystemInfo("Selenium", "3.7.0");
//		     Reporter.setSystemInfo("Maven", "3.5.2");
//		     Reporter.setSystemInfo("Java Version", "1.8.0_151");
//		}


     }
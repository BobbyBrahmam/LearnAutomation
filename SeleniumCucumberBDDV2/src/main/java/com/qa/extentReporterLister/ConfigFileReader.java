package com.qa.extentReporterLister;

import com.qa.utilities.TestBase;

public class ConfigFileReader extends TestBase{
	public String getReportConfigPath()
	{
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}

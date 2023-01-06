package com.qa.utilities;

//import java.io.File;
import java.io.IOException;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.io.FileHandler 

public class TestUtil extends TestBase
{

	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICT_WAIT = 30;

	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(src, new File(""));
	}

}

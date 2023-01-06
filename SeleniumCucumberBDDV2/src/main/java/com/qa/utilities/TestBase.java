package com.qa.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
//import com.cucumber.listener.Reporter;
import io.cucumber.java.Scenario;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
"E:\\Programming\\workspace\\SeleniumCucumberBDDV2\\src\\main\\java\\com\\qa\\configuration\\Config.properties");
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver initialization() { 
		
		
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Programming\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");

		}

		else if (browserName.equals("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", "C:\\Drivers\\ie.exe");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

		return driver;
	}

	// Extent Reports
//	public static void failed(Scenario scenario) {
//		String date = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
//		try {
//			String destinationPath = System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
//					+ scenario.getName() + date + ".jpg";
//			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(srcFile, new File(destinationPath));
//			Reporter.addScreenCaptureFromPath(destinationPath);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
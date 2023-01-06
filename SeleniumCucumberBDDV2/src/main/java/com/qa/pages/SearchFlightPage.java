package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.qa.utilities.TestBase;


public class SearchFlightPage extends TestBase{
	@FindBy(how = How.CSS, using = "#bookFlightTab form  input[name='or-src']")
	public WebElement source;

	@FindBy(how = How.CSS, using = "#bookFlightTab form  input[name='or-dest']")
	public WebElement destination;

	@FindBy(how = How.CSS, using = ".ui-datepicker-inline .btn.btn-primary.dateClose")
	public WebElement closeDate;

	@FindBy(how = How.CSS, using = "#bookFlightTab form  input[name='or-depart']")
	public WebElement departureInput;

	@FindBy(how = How.CSS, using = "#bookFlightTab button[type='submit']")
	public WebElement searchFlight;

	public SearchFlightPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterSourceAndDestination(String from, String to){
		source.clear();
		source.click();
		source.sendKeys(from);		
		driver.findElement(By.xpath("//input[@name='or-src']/parent::div/div/div[@class='wrap']//div[1]//div[contains(text(),'"+ from + "')][1]")).click();		
		destination.clear();
		destination.click();
		destination.sendKeys(to);
		driver.findElement(By.xpath("//input[@name='or-dest']/parent::div/div/div[@class='wrap']//div[1]//div[contains(text(),'"+ to + "')][1]")).click();
	}

	public void selectDepartureDate(String departure) {
		String month = departure.split("-")[0];
		String date = departure.split("-")[1];
		departureInput.click();	
		WebElement number = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//span[contains(text(),'" + month + "')]/ancestor::div[3]//a[text()='" + date + "']/parent::td"));		
		JavascriptExecutor executor = (JavascriptExecutor) driver;	
		executor.executeScript("arguments[0].click();", number);
	}

	public void searchIternaries() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", searchFlight);
	}
}

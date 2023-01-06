package com.qa.stepDefinitions;

import com.qa.pages.SelectFlightPage;
import org.junit.Assert;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import com.qa.utilities.TestBase;

public class SelectFlightSteps extends TestBase {
	SelectFlightPage select;

	@Then("^I am on the Flight Search Page$")
	public void I_am_on_the_Flight_Search_Page() { 
		select = new SelectFlightPage();
		Assert.assertTrue("User couldn't navigate to SelectFlightPage or the page isn't loading",select.isUserOnSelectFlightPage());
	}

	@When("^I am able to select the best Itinerary$")
	public void I_am_able_to_select_the_best_Itinerary() {
		select.selectTheBestIternary();
	}
	
	@After
	public void closeBrowser()	{
	  driver.quit();
	}
}

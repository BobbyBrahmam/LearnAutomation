package com.qa.stepDefinitions;
import com.qa.utilities.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.qa.pages.SearchFlightPage;

public class SearchFlightStep extends TestBase{
	SearchFlightPage search;

	@Given("^I navigate to the Home Page$")
	public void I_navigate_to_the_Home_Page() {
		System.out.println("In step file");
		TestBase.initialization();
		search = new SearchFlightPage();
	} 

	@When("^I enter the Source \"(.*)\" and Destination \"(.*)\"$")
	public void I_enter_the_Source_and_Destination(String from, String to) {
		search.enterSourceAndDestination(from, to);
	}

	@When("^I select the Departure Date \"(.*)\"$")
	public void I_select_the_Departure_Date(String date) {
		search.selectDepartureDate(date);
	}

	@When("^I search for the available Itineraries$")
	public void I_search_for_the_Iternaries() {
		search.searchIternaries();
	}
}
 
package com.qa.pages;
import com.qa.utilities.TestBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage extends TestBase {
	public SelectFlightPage() {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(css = "[class='time']") })
	public List<WebElement> duration;

	@FindAll({
			@FindBy(xpath = "//div[@class=' row price-details-wrapper']//label[starts-with(@class,'col price-details')][1]//div[@class='price ']/span") })
	public List<WebElement> price;

	public Boolean isUserOnSelectFlightPage() {
		return driver.getTitle().trim().equals(prop.getProperty("SelectFlightPageTitle"));
	}

	public WebElement getElement(int i) {
		return driver.findElement(
				By.xpath("//div[@class='row trips-row d-flex']//label[starts-with(@class,'col price-details')][" + i
						+ "]//div[@class='price ']/span/parent::div/preceding-sibling::div"));
	}

	public void selectTheBestIternary() {
		ArrayList<Integer> durations = new ArrayList<Integer>();
		ArrayList<Integer> prices = new ArrayList<Integer>();
		ArrayList<Integer> departure = new ArrayList<Integer>();

		// Getting the lists of Durations, Prices and Timings and storing them into their Respective ArrayLists
		for (int i = 0; i < duration.size(); i++) {
			int departure_hour = Integer.parseInt(duration.get(i).getText().trim().split("-")[0].trim().split(":")[0]);
			int destination_hour = Integer.parseInt(duration.get(i).getText().trim().split("-")[1].trim().split(":")[0]);
			int departure_minutes = Integer.parseInt(duration.get(i).getText().trim().split("-")[0].trim().split(":")[1]);
			int destination_minutes = Integer.parseInt(duration.get(i).getText().trim().split("-")[1].trim().split(":")[1]);
			int duration_in_minutes = Math.abs(((departure_hour * 60) + departure_minutes) - ((destination_hour * 60) + destination_minutes));
			String fare = price.get(i).getText();
			int amount = Integer.parseInt(fare.substring(1, fare.length()).replaceAll("[-+.^:,?]", ""));
			durations.add(duration_in_minutes);
			prices.add(amount);
			departure.add(departure_hour);
		}

		int row = 0, index = 0;

		Map<Integer, Integer> prices_of_fastest = new HashMap<Integer, Integer>();

		// Counting the number of flights having the same least duration (fastest duration)
		for (int i = 0; i < durations.size(); i++) {
			if (Collections.min(durations) == durations.get(i)) {
				row = i;
				prices_of_fastest.put(i, prices.get(i));
			}
		}
		
		// If there is only one flight with the least duration, then select that flight or go to else condition
		if (row == 1) 
		{
			index = row;
			getElement(index).click();
		}

		// If there are multiple flights with the same least duration, then filter out the cheapest
		else 
		{
			int min_price = Collections.min(prices_of_fastest.values());
			Map<Integer, Integer> timings_of_cheapest = new HashMap<Integer, Integer>();

			// Counting the number of flights having the same cheapest fare
			for (Integer key : prices_of_fastest.keySet()) {				
				if (min_price == prices_of_fastest.get(key)) {
					index = key;
					row++;
					timings_of_cheapest.put(key, departure.get(key));
				}
			}

			// If there is only one flight with the cheapest fare, then select that flight
			if (row == 1) 
				getElement(index).click();

			// If there are multiple flights with the same cheapest fare, then filter out the last flight
			else 
			{
				int most_later = Collections.max(timings_of_cheapest.values());
				row = 0;
				index = 0;
				Map<Integer, Integer> later_among_cheapest = new HashMap<Integer, Integer>();

				// Counting the number of flights having the same departure time
				for (Integer key : timings_of_cheapest.keySet()){
					if (most_later == timings_of_cheapest.get(key)) {
						index = key;
						row++;
						later_among_cheapest.put(key, timings_of_cheapest.get(key));
					}
				}

				// If there is only one flight with the same departure time, select that flight
				if (row == 1) 
					getElement(index).click();

				// If there are multiple flights with the same departure time, select the first shown in the list
				else {
					index = Collections.min(timings_of_cheapest.keySet());
					getElement(index).click();
				}
			}

		}

	}

}

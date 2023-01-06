Feature: Select Flight Page.

Background:
Given I navigate to the Home Page

Scenario: Verify that the user is able to search flights and pick the best itinerary one
When I enter the Source "Hyderabad" and Destination "Bengaluru"
And I select the Departure Date "August-31-2023"
And I search for the available Itineraries
Then I am on the Flight Search Page
And I am able to select the best Itinerary
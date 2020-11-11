@etsy
Feature: Etsy Search feature
  Agile story: User should be able to enter search term and see relevant results
                in the page and in the title.

  Background: Landing on home page
    Given User is on the etsy home page

  @etsyWip1
  Scenario: Title Verification
    Then  User should see title as expected
  #Expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  @etsyWip2
  Scenario: Etsy Search Functionality Title Verification
    When  User types Wooden Spoon in the search box
    And User clicks search box
    Then User should see Wooden Spoon is in the title
    #Expected : User sees Wooden Spoon is in the title

  #TC#53: Etsy Search Functionality Title Verification (with parameterization)
  #User is on https://www.etsy.com
  #User types Wooden Spoon in the search box
  #User clicks search button
  #User sees Wooden Spoon is in the title
  #Note: Follow POM
  @etsyWip3
  Scenario: Etsy Search Functionality Title Verification
    When User types "Box of chocolate" in the search box
    And User clicks to search box
    Then User should see "Box of chocolate" is in the title
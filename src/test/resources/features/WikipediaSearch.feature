@wiki
Feature: Wikipedia Search and Title Verification

  Background: User is on the wikipedia home page
    Given User is on the Wikipedia home page


  @wiki1
  Scenario: Search functionality title verification
    When User types "Steve Jobs" in the wiki search
    And User clicks wiki search button
    Then User should see "Steve Jobs" is in the wiki title

  @wiki2
  Scenario: Search Functionality Header Verification
    When User types "Steve Jobs" in the wiki search
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

  @wiki3
  Scenario: Search Functionality Image Header Verification
    When User types "Steve Jobs" in the wiki search
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header

  @wiki4
  Scenario Outline: Search Functionality Verification
    When User types "<searchValue>" in the wiki search
    And User clicks wiki search button
    Then User should see "<expectedTitle>" is in the wiki title
    Then User sees "<expectedImageHeader>" is in the image header
    Then User sees "<expectedMainHeader>" is in the main header

    Examples: Search values in Wikipedia
    |searchValue| expectedTitle| expectedImageHeader| expectedMainHeader|
    |Steve Jobs |Steve Jobs    |Steve Jobs          |Steve Jobs         |
    |Dua Lipa   |Dua Lipa      |Dua Lipa            |Dua Lipa           |
    |Bruce Lee  |Bruce Lee     |Bruce Lee           |Bruce Lee          |
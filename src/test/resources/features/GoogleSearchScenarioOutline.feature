Feature: Search
  Agile Story: As u user, I should be able to search when i am on Google Search page

  @scenarioOutline
  Scenario Outline: Google Title verification after search
    Given User is on the google search page
    When User searches "<searchValue>"
    Then User should see "<expectedTitle>" is in the title

    Examples: Search values in Google
      | searchValue | expectedTitle |
      | apple       | apple         |
      | kiwi        | kiwi          |
      | orange      | orange        |

    # command + option + L for making pipes straight
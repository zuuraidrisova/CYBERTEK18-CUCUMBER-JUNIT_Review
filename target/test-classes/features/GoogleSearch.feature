@search
Feature: Google Search
  Agile Story: As a user, I should be able to search when I am on Google search page.

  Background: User should be on google search page
    Given User is on the google search page

  Scenario: Google default title verification
    Then User should see title is Google

  @wip # work in progress
  Scenario: Google title verification after search
      When User searches apple
      Then User should see apple in title

  # shortcut for mac:  option + enter allows u to generate step definitions

  Scenario: Google title verification after search
    When User searches "peach"
    Then User should see "peach" in title

  Scenario: Google search page About link title
    When User should see About link
    And User clicks About link
    Then User should see title Google - About Google, Our Culture & Company News


    @googleTable
  Scenario: Google Search Page footer links verification
    Then User should see six links in the footer
      | Advertising      |
      | Business         |
      | How Search Works |
      | Privacy          |
      | Terms            |
      | Settings         |


Feature: SmartBear order Process

    #1. User is logged into SmartBear Tester account and on Order page
  #2. User fills out the form as followed:
  #3. User selects FamilyAlbum from product dropdown
  #4. User enters 4 to quantity
  #5. User enters John Wick to costumer name
  #6. User enters Kenzie Ave to street
  #7. User enters Chicago to city
  #8. User enters IL to state
  #9. User enters 60056
  #10. User selects Visa as card type
  #11. User enters 1111222233334444 to card number
  #12. User enters 12/22 to expiration date
  #13. User clicks process button
  #14. User verifies John Wick is in the list
  #Note: Follow POM, and solution should be done using Cucumber parameterization

  @smartBearParameterization
  Scenario: SmartBear order process verification
    Given User is on SmartBear webpage
    When User logs into SmartBear Tester account
    And User clicks and lands on Order page
    And User selects "FamilyAlbum" from product dropdown
    And User enters "4" to quantity
    And User clicks calculate
    And User enters "John Wick" to costumer name
    And User enters "Kenzie Ave" to street
    And User enters "Chicago" to city
    And User enters "IL" to state
    And User enters "60056" to zipcode
    And User selects visa as card type
    And User enters "1111222233334444" to card number
    And User enters "12/22" to expiration date
    And User clicks process button
    Then User verifies "John Wick" is in the list


    @smartBearScenarioOutline
    Scenario Outline: SmartBear order process verification
      Given User is on SmartBear webpage
      When User logs into SmartBear Tester account
      And User clicks and lands on Order page
      And User selects "<product>" from product dropdown
      And User enters "<quantity>" to quantity
      And User clicks calculate
      And User enters "<costumerName>" to costumer name
      And User enters "<street>" to street
      And User enters "<city>" to city
      And User enters "<state>" to state
      And User enters "<zipCode>" to zipcode
      And User selects visa as card type
      And User enters "<cardNumber>" to card number
      And User enters "<expireDate>" to expiration date
      And User clicks process button
      Then User verifies "<expectedName>" is in the list

      Examples:
        | product     | quantity | costumerName   | street      | city        | state | zipCode | cardNumber   | expireDate | expectedName   |
        | MyMoney     | 1        | Ken Adams      | Kinzie St   | Chicago     | IL    | 60004   | 313313133315 | 12/22      | Ken Adams      |
        | FamilyAlbum | 4        | Joey Tribbiani | State St    | Chicago     | IL    | 60656   | 123433533356 | 11/22      | Joey Tribbiani |
        | ScreenSaver | 5        | Rachel Green   | Michigan St | Chicago     | IL    | 60056   | 335333333337 | 10/22      | Rachel Green   |
        | MyMoney     | 5        | Chandler Bing  | Erie St     | Chicago     | IL    | 60666   | 433353333338 | 10/22      | Chandler Bing  |
        | FamilyAlbum | 9        | Drake Remoray  | Dale St     | Arl Hgths   | IL    | 60452   | 532333335334 | 10/22      | Drake Remoray  |
        | ScreenSaver | 10       | Monica Geller  | Euclid Ave  | Arl Hgths   | IL    | 60312   | 733533333333 | 10/22      | Monica Geller  |
        | MyMoney     | 3        | Ross Geller    | River Rd    | Des Plaines | IL    | 60666   | 833443533732 | 10/22      | Ross Geller    |
        | MyMoney     | 1        | Ken Adams      | Kinzie St   | Chicago     | IL    | 60312   | 933533333531 | 12/22      | Ken Adams      |
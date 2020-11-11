@loginWithBackground
  Feature: Login feature
   Agile Story: As a user, I should be able to login with correct credentials to
               different accounts.And dashboard should be displayed.

#this is how you comment in feature file

    #Before annotation runs here
  Background: User is on the login page
    Given User is on the login page

  Scenario: Librarian login scenario
    When User logs in as librarian
    Then User should see dashboard
     #After annotation runs here

    Scenario: Student login scenario
    When  User logs in as student
    Then User should see dashboard
       #After annotation runs here

    @db
  Scenario: Admin login scenario
    When  User logs in as admin
    Then  User should see dashboard
       #After annotation runs here

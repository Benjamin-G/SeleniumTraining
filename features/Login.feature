#Each feature file contains one feature
  #Gherkin language - business language
Feature: Test the login functionality on sdet university

  #A feature may have given different specific scenarios
  #Scenerios use Give-When-Then structure
  Scenario: the user should be able to login with correct username and password
    Given user is on the login page
    When user enters correct username and correct password
    Then user gets confirmation

  Scenario Outline: the user should be able to login
    Given user is on the login page
    When user enters email <username>
    And user enters password <password>
    Then user gets confirmation

    Examples:
      | username | password |
      | tim@testemail.com | trpass |
      | rw@testemail.com | rwpass |
      | jv@testemail.com | jvpass |

Feature: LoginFeature
  This feature deals with the login functionality of the application

  @rk
  Scenario: Load zkoss page and get select a date
    Given I navigate to the zkoss page
    Then I wait for page to load
    And I click date time button
    Then I click date picker


  Scenario: Login with correct username and password to fail
    Given I navigate to the login page
    And I enter the following for Login
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform page wrongly
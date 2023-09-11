Feature: User Login

  @smoke
  Scenario:
    Then I verify homepage Title is "Automation Exercise"
    And I click on Sign in button
    Then I verify "Login to your account" is visible
    And I enter correct "sky@sky.com" and "skysky"
    * I click on login button
    Then I verify Logged as username is visible
    #And I click delete account button
    #Then I Verify that "ACCOUNT DELETED!" is visible
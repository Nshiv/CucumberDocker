Feature: User logout

  @smoke
  Scenario: I am able to logout after successfull login
    Then I validate homepage Title is "Automation Exercise" is displays
    And I click on Sign in button on homepage
    Then I validate "Login to your account" is visible
    And I enter valid "sky@sky.com" and "skysky"
    * I click login button
    Then I validate Logged as username is visible
    And I click on logout button
    And I verift that i am navigated to login screen again
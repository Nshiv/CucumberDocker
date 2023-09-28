Feature: User invalid login

  @smoke@wip
  Scenario:Verify Invalid login with correct error message on screen
    Then I verify redirected homepage Title is "Automation Exercise" is present
    And I click on Sign-in button
    Then I verify "Login to your account" is visible on navigated screen
    And I enter in-correct "sky@sky.cm" and "skysky"
    * I click on log-in button
    Then I verify corresponding error message on screen

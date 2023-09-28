Feature: User subscription and its Management

  @smoke
  Scenario: Verify user can enable subscriptions
    Then I verify that homepage Title is "Automation Exercise" displays on screen
    And I scroll down to footer
    Then I verify text "SUBSCRIPTION" on footer
    And  I enter "test@gmail.time" address as input
    And  I click on arrow button
    Then I verify success message "You have been successfully subscribed!" is visible

  @smoke
  Scenario: Verify subscription on cart page
    Then I verify that homepage Title is "Automation Exercise" displays on screen
    And I click Cart button
    And I scroll down to footer
    Then I verify text "SUBSCRIPTION" on footer
    And  I enter "test@gmail.time" address as input
    And  I click on arrow button
    Then I verify success message "You have been successfully subscribed!" is visible

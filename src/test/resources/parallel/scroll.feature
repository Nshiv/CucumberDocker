Feature: Scroll up each screen as-per the content

  @smoke
  Scenario: Verify scroll up flow on Homepage with Arrow button
    Then I verify that homepage Title is "Automation Exercise" displays on screen
    When I scroll down to footer
    Then I verify text "SUBSCRIPTION" on footer
    And I click on scroll up button
    Then I verify "Full-Fledged practice website for Automation Engineers" texts are displays on homepage screen

  @smoke
  Scenario: Verify scroll up flow without arrow button
    Then I verify that homepage Title is "Automation Exercise" displays on screen
    When I scroll down to footer
    Then I verify text "SUBSCRIPTION" on footer
    And I scroll up manually to top of the screen






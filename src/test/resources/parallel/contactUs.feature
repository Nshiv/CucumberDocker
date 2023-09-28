Feature: Contact us form homepage

  @smoke
  Scenario: User connects with us with contact us form
    Then I verify that homepage Title is "Automation Exercise" displays on screen
    And I click on Contact us button
    Then I verift "GET IN TOUCH" is visible
    And I enter following details on screen
      | name | email         | subject         | message     |
      | test | test@test.com | need assistanse | test message |
    * I uploads a file
    * I click on submit button
    * I click on ok button
    * I Verify success message "Success! Your details have been submitted successfully." is visible
    * I click on home button
    Then I verify navigation on homepage


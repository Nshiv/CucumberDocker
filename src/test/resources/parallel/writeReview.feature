Feature: Add review for product
  @smoke
  Scenario: Adding review on product
    When I verify homepage Title is "Automation Exercise"
    And I click on view product button on homepage screen
    Then I verify "Write Your Review" is visible on product details screen
    And I enter following details in review section
      | name        | email           | review                                   |
      | John Carter | john@carter.com | this is fantastic product no body should buy it.|
    And I click on Submit button on screen




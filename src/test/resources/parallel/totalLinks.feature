Feature: Links on website
  @smoke
  Scenario: Validate total links on page
    Then  I verify homepage Title is "Automation Exercise"
    And I log all the links present on Homepage screen

  @smoke
  Scenario: Print all the links present on HomePage screen
    Then I verify homepage Title is "Automation Exercise"
    And I print all the links in Logger file

  @new
  Scenario: Get all broken links
    Then  I verify homepage Title is "Automation Exercise"
    And I log all broken links on webpage














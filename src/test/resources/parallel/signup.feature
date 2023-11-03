Feature: User Signup

  @wip
  Scenario: User Signup
    Given I navigated to homepage
    Then I verify that homepage Title is "Automation Exercise"
    When I click on the SignUp button
    Then I verify that "New User Signup!" is visible
    When I enter valid name and email address
      | name | email                     |
      | John | joh458454354mm4@gmail.com |
    And I click the Signup button
    Then I verify texts "ENTER ACCOUNT INFORMATION" is visible on signup form
    When i click title radioButton as Mr.
    When I fill the following details
      | Password | Date_of_Birth |
      | Test@123 | 11/May/1995   |
    And I select the checkbox Sign up for our newsletter
    And I select the checkbox Receive special offers from our partners
    And I fill the following additional details:
      | FirstName | LastName     | Company | Address1    | Address2        | Country | State    | City     | Zipcode | MobileNumber |
      | TestUser  | LastNameUser | XYZ     | planetEarth | MilkyWay galaxy | Canada  | Virginia | New York | 359848  | 4455665456   |
    And I click the Create Account button
    Then I verify texts "ACCOUNT CREATED!" is visible
    When I click the Continue button
    When I click the Delete Account button
    Then I verify that "ACCOUNT DELETED!" is displays
    And I click the Continue button on screen

    @new
    Scenario: Register User with existing email
      Then I verify that homepage Title is "Automation Exercise" displays on screen
      And I click on the SignUp button on screen
      Then I verify that "New User Signup!" is visible on screen
      And I Enter already registered "sky" and "sky@sky.com" for signup
      And I click the Signup button to validate
      Then I Verify error "Email Address already exist!" is visible





Feature: Search products

  @new
  Scenario:Search with a keyword and verify products on listing
    Then I verify that homepage Title is "Automation Exercise" displays on screen
    And  I Click on Products button
    Then I Verify navigation with "ALL PRODUCTS" texts present on product Listing screen
    And  I Enter "Sleeveless" in search input
    And I click on search button
    And I Verify "Sleeveless" is present in product Titles


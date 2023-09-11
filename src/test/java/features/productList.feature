Feature: Product list screen visibility

  @smoke
  Scenario: Verify product list screen is visible
    Then Verify home page is visible with "Automation Exercise" as Title
    And  I Click on Products button
    Then I Verify navigation with "ALL PRODUCTS" texts present on product Listing screen
    And I Click on View Product of first product on product listing
    Then I verify User is landed to product detail page
    Then I Verify  product name, category, price, availability, condition, brand are visible




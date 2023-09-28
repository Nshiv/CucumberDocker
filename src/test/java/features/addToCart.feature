Feature: Add products to cart

  @smoke
  Scenario: Verify add to cart flow for multiple products
    Then I verify that homepage Title is "Automation Exercise" displays on screen
    And  I Click on Products button
    And  I Hover over first product
    And I click on Add to cart button
    And I Click Continue Shopping button
    Then I Verify product is added to Cart
    Then I Verify product price
    And  I verify quantity
    And  I verify  total price

  @smoke
  Scenario: Increase product quantity on cart screen
    Then I verify that homepage Title is "Automation Exercise" displays on screen
    When I click on view product button on homepage screen
    Then I verify User is landed to product detail page
    When I increase product quantity to "4"
    And I click on add to cart button
    And I click on view cart button
    Then I verify increased quantity that is "4" is displays on cart screen




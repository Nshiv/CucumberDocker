Feature: Place Order
  
    @wip
    Scenario: Place order after login
      Then I verify homepage Title is "Automation Exercise"
      When I click on Sign in button
      And I enter correct "sky@sky.com" and "skysky"
      * I click on login button
      Then I verify Logged as username is visible
      When I add product to cart and Navigated to cart page
      When I click on proceed to checkout
      When I enter description texts in comment texts area
      And I click on Place order
      When I enter payment details
        | Name on card | Card number      | CVC | Expiration month | Expiration Year |
        | John Doe     | 1234567890123456 | 123 | 12               | 2023            |
      And Click pay and confirm order button
      Then I verify success message on screen as "Congratulations! Your order has been confirmed!"





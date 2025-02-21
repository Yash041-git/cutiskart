Feature: End-to-End Purchase Flow for Multiple Users
  As multiple users
  I want to log in, search for a product, add it to the cart, and complete the checkout process
  So that I can ensure the functionality works across different user accounts

  Scenario Outline: Successful purchase of a product by a user
    Given I open the website
    And I click on the profile icon to navigate to the signin page
    When I log in with the following credentials
      | username     | password  |
      | <username>   | <password> |
    And I search for a product
    And I select the product from the search result
    And I add the product to the cart
    And I proceed to checkout
    When I complete the payment process
    Then I should see the order confirmation message 

    Examples:
      | username      | password    | confirmationMessage                     |
      | ippthm.eczgmj@example.com | Ma2@3@@b | Thank you, Order is confirmed! |
      #| user2@test.com | password2  | Thank you, Order is confirmed! |
      #| user3@test.com | password3  | Thank you, Order is confirmed! |

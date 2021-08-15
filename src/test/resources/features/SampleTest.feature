Feature: Customer adds the lowest price item to the cart from wishlist
  As a customer, I want to add multiple items to wishlist
  I want to add the lowest price item to the cart from wishlist
  I want to see whether the added item is in cart

  @debug
  Scenario: Customer adds item to the cart from wishlist
    Given Customer navigated to Demo Shop homepage
    And Customer navigated to 'shop' section on the homepage
    And Customer added 4 different items to the wishlist
    When Customer views wishlist table
    Then Customer should be able to find the selected items in the wishlist
    When Customer searches for the lowest price item in the wishlist
    And Customer adds the lowest price item to the cart from wishlist
    And Customer navigates to cart
    Then Customer should be able to verify the item in cart



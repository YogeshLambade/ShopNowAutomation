Feature: Proceed to checkout and Complete Order

  Background: 
    Given User Launch Chrome Browser
    When User Open url "https://shopnowonline.in/account/login"
    And User enter Email as "sqkmcrb7ni@lettershield.com" and password as "Shopnow@123"
    And Click on Sign In button
    Then Home page  Should contain link "Shop Now"
    And Click on Search btn
    And enter text as "Laptop" and clicked
    Then Seach Product name appear as "Anti Radiation Chip for Mobile Cell Phone | Rediance Chip Black & Gold"
    And Again click on item
    And Again click on Add to cart button
    Then popup appered as "Item added to your cart"

  Scenario: Proceed to checkout
    And click on shop now btn
    And click on Cart button
    Then Checkout page appear with text "Anti Radiation Chip for Mobile Cell Phone | Rediance Chip Black & Gold"
    And click on checkout button
    Then complete order page appear with title "Checkout - Shop Now"
    And Close The browser

  Scenario: Complete the order
    And click on checkout button of view my cart
    And Enter user detail
    And Close The browser

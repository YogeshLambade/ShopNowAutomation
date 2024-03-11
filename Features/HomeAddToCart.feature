Feature: Home Page Verification and Add to Cart Feature

  Background: 
    Given User Launch Chrome Browser
    When User Open url "https://shopnowonline.in/"

  Scenario: Verify Home Page Title
    And Get the home page title as "Shop Now"
    And Close The browser

    
  Scenario: Succesfull Search and Add To Cart of item
     And Click on Search btn
     And enter text as "Laptop" and clicked
     Then Seach Product name appear as "Anti Radiation Chip for Mobile Cell Phone | Rediance Chip Black & Gold"
     And Again click on item
     And Again click on Add to cart button
     Then popup appered as "Item added to your cart"
     And Click on view my cart btn
     Then Checkout page appear with text "Anti Radiation Chip for Mobile Cell Phone | Rediance Chip Black & Gold"
     And Close The browser
     
Feature: Login

  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome Browser
    When User Open url "https://shopnowonline.in/account/login"
    And User enter Email as "sqkmcrb7ni@lettershield.com" and password as "Shopnow@123"
    And Click on Sign In button
    Then Home page  Should contain link "Shop Now"
    And Close The browser

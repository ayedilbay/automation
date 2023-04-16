Feature: Test Home Page Functionality
  Background: User navigates to the website and validates url
    When User validates the 'https://automationexercise.com/' of the webpage

    Scenario: Test Contact Us Functionality
      When User clicks Contact Us Button and verifies 'GET IN TOUCH' is visible
      And User enters 'Ayana', 'yedilbay@gmail.com', 'subject' and ' Hello!!! '
      And user uploads file '/Users/yerikyertay/Desktop' and clicks Submit button and OK button
      Then verifies 'Success! Your details have been submitted successfully.' is visible


  Scenario: Verify Test Cases Page
    When User clicks test cases button and verifies the 'https://automationexercise.com/test_cases'



  Scenario: Verify All Products and product detail page
    When User clicks on Product Button and verifies ALL PRODUCTS page 'Automation Exercise - All Products'
    Then User checks that The products list is visible
    When User Click on View Product of first 0 product
    Then User verifies Verify that detail detail is visible: product name, 'Category:', price, 'Availability:', 'Condition:', 'Brand:'


    Scenario: Search Product
      When User clicks on Product Button and verifies ALL PRODUCTS page 'Automation Exercise - All Products'
      And User enters product 'Top' in a search box
      Then User verifies 'SEARCHED PRODUCTS' is visible
      Then User checks that related 'Top' or 'Shirt' products list is visible


      Scenario: Verify Subscription in home page
        When User scrolls down and  Verifies text 'SUBSCRIPTION'
        And User Enters 'ayana@gmail.com' address in input and click arrow button
        Then Verify success message 'You have been successfully subscribed!' is visible


        Scenario: Verify Subscription in Cart page
          When User clicks cart button
          And User scrolls down and  Verifies text 'SUBSCRIPTION'
          And User Enters 'ayana@gmail.com' address in input and click arrow button
          Then Verify success message 'You have been successfully subscribed!' is visible




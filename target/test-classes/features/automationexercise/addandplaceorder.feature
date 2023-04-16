Feature: Adding to cart and Placing order Functionality

  Background: User navigates to the website and validates url
    When User validates the 'https://automationexercise.com/' of the webpage

    Scenario:  Add Products in Cart
      When User clicks on Product Button and verifies ALL PRODUCTS page 'Automation Exercise - All Products'
      And User Hovers over first 0 product and click Add to cart 1
      And User Clicks Continue Shopping button
      And User Hovers over first 1 product and click Add to cart 3
      And Click View Cart button
      Then User Verifies both 2 products are added to Cart
      Then User Verifies their prices 'Rs.', quantity '1' and total price


      Scenario: Verify Product quantity in Cart
        When User clicks on Product Button and verifies ALL PRODUCTS page 'Automation Exercise - All Products'
        And User Click on View Product of first 0 product
        And User Verifies product detail is opened by 'title'
        And User increases quantity to 4 and Clicks Add to cart button
        Then User clicks on View Cart button and verifies that product is displayed in cart page with exact quantity





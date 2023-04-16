#it is user story
Feature: Sign up Functionality

Background: User navigates to the website and validates url
  When User validates the 'https://automationexercise.com/' of the webpage
  And User clicks signuplogin button
  #test description
  Scenario: Creating and deleting user
    #Given User navigates to the automationExercise webpage
#    And User validates the 'https://automationexercise.com/' of the webpage
#    When User clicks signuplogin button
    Then User verifies New User Signup! is visible
    And User Enter 'ayana','asfff@gmail.com' address and clicks signUp button
    Then User validates 'ENTER ACCOUNT INFORMATION' is visible
    When User fills details: 'Title', 'Ayana', Email, password, Date of birth
    And User selects checkbox Sign up for our newsletter and Selects checkbox Receive special offers from our partners
    And User Fills details: 'Ayana', 'Yedilbay', 'Techtorial', '2200 E Devon st', '2nd floor', 'United States', 'IL', 'Des Planes', '00000', '123456789' and Clicks Create Account button
    Then User Verifies that 'ACCOUNT CREATED!' is visible
    Then User Clicks Continue button and Verifies that 'Logged in as' is visible
    Then User Clicks Delete Account button and Verifies that 'Delete Account' is visible

    Scenario: Login User with correct email and password
#      When User validates the 'https://automationexercise.com/' of the webpage
#      And User clicks signuplogin button
      Then User Verifies 'Login to your account' is visible
      When User enters valid email address and password and clicks login button
      Then User verifies that 'Logged in as' button is visible
      When User Clicks Delete Account button and Verifies that 'Delete Account' is visible

      Scenario: Login User with incorrect email and password
#        When User validates the 'https://automationexercise.com/' of the webpage
#        And User clicks signuplogin button
        Then User Verifies 'Login to your account' is visible
        When User enters invalid 'ayana@gmail.com' address and 'Password123aaa' and clicks login button
        Then User Verifies error 'Your email or password is incorrect!' is visible

        Scenario: Logout User
#          When User validates the 'https://automationexercise.com/' of the webpage
#          And User clicks signuplogin button
          Then User Verifies 'Login to your account' is visible
          When User enters valid email address and password and clicks login button
          Then User clicks logout button and verifies that user is navigated to 'https://automationexercise.com/login'


          Scenario: Register User with existing email
            When User verifies New User Signup! is visible
            And User Enters existing 'ayana' and email address and clicks signUp button
            Then User Verifies error 'Email Address already exist!' message is visible














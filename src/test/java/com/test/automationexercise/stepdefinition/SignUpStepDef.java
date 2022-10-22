package com.test.automationexercise.stepdefinition;


import com.test.automationexercise.pages.HomePage;
import com.test.automationexercise.pages.LoginPage;
import com.test.automationexercise.pages.SignUpPage;
import com.test.automationexercise.utils.ConfigReader;
import com.test.automationexercise.utils.DriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class SignUpStepDef {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    SignUpPage signUpPage = new SignUpPage(driver);
//    @Given("User navigates to the automationExercise webpage")
//    public void user_navigates_to_the_automation_exercise_webpage() {
//      driver.get(ConfigReader.readProperty("url"));
//    }

    @Given("User validates the {string} of the webpage")
    public void user_validates_the_url_of_the_webpage(String url) {
        Assert.assertEquals(url,driver.getCurrentUrl().trim());
    }

    @When("User clicks signuplogin button")
    public void user_clicks_signuplogin_button() {
        homePage.clickSignUpButton();
    }

    @Then("User verifies New User Signup! is visible")
    public void user_verifies_new_user_signup_is_visible() {
        Assert.assertTrue(loginPage.validateNewUserSignUpMssg());
    }

    @Then("User Enter {string},{string} address and clicks signUp button")
    public void user_enter_name_and_email_address_signup(String name, String email) {
        loginPage.sendingInfo(name,email);
    }

    @Then("User validates {string} is visible")
    public void user_validates_enter_account_information_is_visible(String header) {
        Assert.assertEquals(header,signUpPage.validateEnterAccountMssg());
    }

    @When("User fills details: {string}, {string}, Email, password, Date of birth")
    public void user_fills_details_title_email_date_of_birth(String title,String name) {
        signUpPage.accountInfo(title,name, ConfigReader.readProperty("username"));
    }

    @When("User selects checkbox Sign up for our newsletter and Selects checkbox Receive special offers from our partners")
    public void user_selects_checkbox_sign_up_for_our_newsletter_and_selects_checkbox_receive_special_offers_from_our_partners() {
        signUpPage.clickCheckBox(driver);
    }

    @When("User Fills details: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and Clicks Create Account button")
    public void user_fills_details_country_and_clicks_create_account_button(String name, String lastname, String company, String address1,
                                                                            String address2, String country, String state, String city,
                                                                            String zipcode,String mobileNumber) {
        signUpPage.fillAddressInfo(driver,name,lastname,company,address1,address2,country,state,city,zipcode,mobileNumber);
    }


    @Then("User Verifies that {string} is visible")
    public void user_verifies_that_is_visible(String accountCreatedMssg) {
        Assert.assertEquals(accountCreatedMssg, signUpPage.getMssg());
    }

    @Then("User Clicks Continue button and Verifies that {string} is visible")
    public void user_clicks_continue_button_and_verifies_that_is_visible(String loggedAsMssg) {
        signUpPage.validateLoggedAsUser(loggedAsMssg);
    }

    @Then("User Clicks Delete Account button and Verifies that {string} is visible")
    public void user_clicks_delete_account_button_and_verifies_that_is_visible_and_click_continue_button(String deleteAccountMssg) {
        signUpPage.deleteAccount(deleteAccountMssg);

    }

    @Then("User Verifies {string} is visible")
    public void user_verifies_is_visible(String loginToYourAccMssg) {
        Assert.assertEquals(loginToYourAccMssg,loginPage.validateLoginToYourAccMss());
    }
    @When("User enters valid email address and password and clicks login button")
    public void user_enters_valid_address_and() {
        loginPage.logInAsExistingUser(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));

    }

    @Then("User verifies that {string} button is visible")
    public void user_verifies_that_button_is_visible(String loggedInAsMssg) {
        Assert.assertTrue(signUpPage.getLoginAsUserMss().contains(loggedInAsMssg));
    }

    @When("User enters invalid {string} address and {string} and clicks login button")
    public void user_enters_invalid_address_and_and_clicks_login_button(String invalidEmail, String invalidPassword) {
        loginPage.logInAsExistingUser(invalidEmail,invalidPassword);
    }
    @Then("User Verifies error {string} is visible")
    public void user_verifies_error_is_visible(String errorMssg) {
        Assert.assertEquals(errorMssg,loginPage.getErrorMssg());
    }

    @Then("User clicks logout button and verifies that user is navigated to {string}")
    public void user_clicks_logout_button_and_verifies_that_user_is_navigated_to(String loginPageUrl) {
        homePage.clickSignOutButton();
        Assert.assertEquals(loginPageUrl,driver.getCurrentUrl());
    }

    @When("User Enters existing {string} and email address and clicks signUp button")
    public void user_enters_existing_username_and_password_address_and_clicks_sign_up_button(String name) {
        loginPage.sendingInfo(name, ConfigReader.readProperty("username"));
    }



    @Then("User Verifies error {string} message is visible")
    public void user_verifies_error_message_is_visible(String errorMessage) {
       Assert.assertEquals(errorMessage,signUpPage.getEmailExistMssg());
    }









}

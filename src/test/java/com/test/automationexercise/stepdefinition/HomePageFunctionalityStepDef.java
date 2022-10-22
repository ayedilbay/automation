package com.test.automationexercise.stepdefinition;

import com.test.automationexercise.pages.ContactUsPage;
import com.test.automationexercise.pages.HomePage;
import com.test.automationexercise.pages.ProductPage;
import com.test.automationexercise.utils.BrowserUtils;
import com.test.automationexercise.utils.DriverHelper;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePageFunctionalityStepDef {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductPage productPage = new ProductPage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);


    @When("User clicks Contact Us Button and verifies {string} is visible")
    public void user_clicks_contact_us_button_and_verifies_is_visible(String expectedMssg) {
        homePage.clickContactUsButton();
        Assert.assertEquals(expectedMssg, contactUsPage.getGetInTouchMssg());

    }
    @When("User enters {string}, {string}, {string} and {string}")
    public void user_enters_and(String name, String email, String subject, String message) {
        contactUsPage.fillForm(name,email,subject,message);

    }
    @When("user uploads file {string} and clicks Submit button and OK button")
    public void user_uploads_file_and_clicks_submit_button_and_ok_button(String path) {
        contactUsPage.uploadFile(path);
        contactUsPage.clickSubmitOkButton(driver);
    }
    @Then("verifies {string} is visible")
    public void verifies_is_visible(String expectedMssg) {
        Assert.assertEquals(expectedMssg, contactUsPage.getSuccessMssg());
    }

    @When("User clicks test cases button and verifies the {string}")
    public void user_clicks_test_cases_button_and_verifies_the(String url) {
        homePage.clickTestCasesButton();
        Assert.assertEquals(url, driver.getCurrentUrl());

    }

    @When("User clicks on Product Button and verifies ALL PRODUCTS page {string}")
    public void user_clicks_on_product_button_and_verifies_that_user_is_navigated_to_all_products_page_successfully(String expectedTitle) {
        homePage.clickProductButton();
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());


    }
    @Then("User checks that The products list is visible")
    public void user_checks_that_the_products_list_is_visible() {
       productPage.validateProductListIsVisible(driver);
    }

    @When("User Click on View Product of first {int} product")
    public void user_click_on_view_product_of_first_product(Integer num) {
        productPage.clickProduct(num);
    }
    @Then("User verifies Verify that detail detail is visible: product name, {string}, price, {string}, {string}, {string}")
    public void user_verifies_verify_that_detail_detail_is_visible_product_name_price(String category, String availability, String condition, String brand) {
        productPage.validateProductInfo(category,availability,condition,brand);
    }

    @When("User enters product {string} in a search box")
    public void user_enters_product_in_a_search_box(String item) {
        productPage.searchForProduct(item);

    }
    @Then("User verifies {string} is visible")
    public void user_verifies_is_visible(String expectedMssg) {
        Assert.assertEquals(expectedMssg,productPage.getSearchedProductMssg());
    }

    @Then("User checks that related {string} or {string} products list is visible")
    public void user_checks_that_related_or_products_list_is_visible(String name1, String name2) {
        productPage.validateSearchedProductList(driver,name1,name2);
    }

    @When("User scrolls down and  Verifies text {string}")
    public void user_scrolls_down_and_verifies_text(String expectedText) {
        Assert.assertEquals(expectedText,homePage.getSubscription(driver));
    }
    @When("User Enters {string} address in input and click arrow button")
    public void user_enters_address_in_input_and_click_arrow_button(String email) {
       homePage.sendEmailToSubscribe(email);
    }
    @Then("Verify success message {string} is visible")
    public void verify_success_message_is_visible(String expectedMssg) {
        Assert.assertEquals(expectedMssg,homePage.getSuccessSubscribeMssg());
    }

    @When("User clicks cart button")
    public void user_clicks_cart_button() {
        homePage.clickCartButton();
    }




}

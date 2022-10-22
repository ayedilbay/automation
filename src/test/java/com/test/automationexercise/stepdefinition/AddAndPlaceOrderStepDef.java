package com.test.automationexercise.stepdefinition;

import com.test.automationexercise.pages.CartPage;
import com.test.automationexercise.pages.ContactUsPage;
import com.test.automationexercise.pages.HomePage;
import com.test.automationexercise.pages.ProductPage;
import com.test.automationexercise.utils.DriverHelper;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddAndPlaceOrderStepDef {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductPage productPage = new ProductPage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);
    CartPage cartPage = new CartPage(driver);

    @When("User Hovers over first {int} product and click Add to cart {int}")
    public void user_hovers_over_first_product_and_click_add_to_cart(Integer num,int add) {
        productPage.hoverOverAddToCartProduct(driver,num,add);

    }
    @When("User Clicks Continue Shopping button")
    public void user_clicks_continue_shopping_button() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productPage.clickContinueShoppingButton();
    }
    @When("Click View Cart button")
    public void click_view_cart_button() {
        productPage.clickViewCartButton();
    }
    @Then("User Verifies both {int} products are added to Cart")
    public void user_verifies_both_products_are_added_to_cart(Integer expectedNum) {
        Assert.assertEquals(expectedNum, cartPage.getSizeOfCart());
    }
    @Then("User Verifies their prices {string}, quantity {string} and total price")
    public void user_verifies_their_prices_quantity_and_total_price(String currency, String quantity) {
        cartPage.validateIngo(currency,quantity);

    }
    @When("User Verifies product detail is opened by {string}")
    public void user_verifies_product_detail_is_opened_by(String string) {

    }
    @When("User increases quantity to {int} and Clicks Add to cart button")
    public void user_increases_quantity_to_and_clicks_add_to_cart_button(Integer int1) {

    }
    @Then("User clicks on View Cart button and verifies that product is displayed in cart page with exact quantity")
    public void user_clicks_on_view_cart_button_and_verifies_that_product_is_displayed_in_cart_page_with_exact_quantity() {

    }

}

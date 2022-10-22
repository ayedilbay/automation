package com.test.automationexercise.pages;

import com.test.automationexercise.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//tbody//tr")
    List<WebElement> listOfCartProduct;

    @FindBy(xpath = "//tbody//tr//td[@class='cart_price']")
    List<WebElement> pricesOfProduct;

    @FindBy(xpath = "//tbody//tr//td[@class='cart_quantity']")
    List<WebElement> quantityOfProduct;

    @FindBy(xpath = "//tbody//tr//td[@class='cart_total']")
    List<WebElement> totalOfProduct;


    public Integer getSizeOfCart(){
        return listOfCartProduct.size();
    }

    public void validateIngo(String currency,String quantity){
        for(WebElement price  : pricesOfProduct){
            Assert.assertTrue(BrowserUtils.getText(price).contains(currency));
           for(WebElement total : totalOfProduct){
               Assert.assertEquals(BrowserUtils.getText(price),BrowserUtils.getText(total));
           }
        }
        for(WebElement quan : quantityOfProduct){
            Assert.assertEquals(quantity,BrowserUtils.getText(quan));
        }
    }


}

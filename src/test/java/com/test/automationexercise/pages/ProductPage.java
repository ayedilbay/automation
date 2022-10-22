package com.test.automationexercise.pages;

import com.beust.ah.A;
import com.test.automationexercise.utils.BrowserUtils;
import io.cucumber.core.stepexpression.ExpressionArgument;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    List<WebElement> listOfProduct;

    @FindBy(xpath = "//ul[contains(@class,'nav-justified')]")
    List<WebElement> viewProductList;

    @FindBy(xpath = "//div[@class='product-information']//h2")
    WebElement productName;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(text(),'Category')]")
    WebElement categoryOfProduct;

    @FindBy(xpath = "//div[@class='product-information']//span//span")
    WebElement priceOfProduct;

    @FindBy(xpath = "//div[@class='product-information']//b[.='Availability:']")
    WebElement availabilityOfProduct;

    @FindBy(xpath = "//div[@class='product-information']//b[.='Condition:']")
    WebElement conditionOfProduct;

    @FindBy(xpath = "//div[@class='product-information']//b[.='Brand:']")
    WebElement brandOfProduct;


    @FindBy(id = "search_product")
    WebElement searchBoxOfProduct;


    @FindBy(id = "submit_search")
    WebElement searchButton;


    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement searchedProductsMssg;


    @FindBy(xpath = "//a[.='Add to cart']")
    List<WebElement> addToCartButton;

    @FindBy(xpath = "//button[.='Continue Shopping']")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//u[.='View Cart']")
    WebElement viewCartButton;







    public void validateProductListIsVisible(WebDriver driver){
        for(WebElement product:listOfProduct){
            BrowserUtils.scrollWithJS(driver,product);
            Assert.assertTrue(product.isDisplayed());
        }
    }

    public void clickProduct(int numberOfProduct){
        viewProductList.get(numberOfProduct).click();
    }

    public void hoverOverAddToCartProduct(WebDriver driver,int num, int add){
        Actions actions = new Actions(driver);
        BrowserUtils.scrollWithJS(driver,listOfProduct.get(num));
        actions.moveToElement(listOfProduct.get(num)).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        addToCartButton.get(add).click();

    }

    public void validateProductInfo(String category,String availability,String condition,String brand){
        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(BrowserUtils.getText(categoryOfProduct).contains(category));
        Assert.assertTrue(priceOfProduct.isDisplayed());
        Assert.assertEquals(BrowserUtils.getText(availabilityOfProduct),availability);
        Assert.assertEquals(BrowserUtils.getText(conditionOfProduct), condition);
        Assert.assertEquals(BrowserUtils.getText(brandOfProduct),brand);

    }

    public void searchForProduct(String item){
        this.searchBoxOfProduct.sendKeys(item);
        this.searchButton.click();

    }

    public String getSearchedProductMssg(){
        return BrowserUtils.getText(searchedProductsMssg);
    }

    public void validateSearchedProductList(WebDriver driver,String name1, String name2){
        for(WebElement product:listOfProduct){
            BrowserUtils.scrollWithJS(driver,product);
            Assert.assertTrue(BrowserUtils.getText(product).contains(name1) || BrowserUtils.getText(product).contains(name2));
        }
    }

    public void clickContinueShoppingButton(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        continueShoppingButton.click();
    }

    public void clickViewCartButton(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        viewCartButton.click();
    }




}

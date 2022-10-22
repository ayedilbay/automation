package com.test.automationexercise.pages;

import com.test.automationexercise.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement signUpButton;

    @FindBy(xpath = "//a[.=' Logout']")
    WebElement signOutButton;

    @FindBy(xpath = "//a[.=' Test Cases']")
    WebElement testCasesButton;

    @FindBy(xpath = "//a[contains(text(),' Products')]")
    WebElement productButton;


    @FindBy(xpath = "//a[.=' Contact us']")
    WebElement contactUfButton;


    @FindBy(xpath = "//h2[.='Subscription']")
    WebElement subscriptionButton;


    @FindBy(id = "susbscribe_email")
    WebElement subscribeEmailBox;


    @FindBy(id = "subscribe")
    WebElement arrowSubscribe;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement successSubscribeMssg;

    @FindBy(xpath = "//a[.=' Cart']")
    WebElement cartButton;








    public void clickSignUpButton(){
        signUpButton.click();
    }

    public void clickSignOutButton(){
        signOutButton.click();
    }

    public void clickTestCasesButton(){
        testCasesButton.click();
    }

    public void clickProductButton(){
        productButton.click();
    }

    public void clickContactUsButton(){
        contactUfButton.click();
    }

    public String getSubscription(WebDriver driver){
        BrowserUtils.scrollWithJS(driver,this.subscriptionButton);
        return BrowserUtils.getText(subscriptionButton);
    }

    public void sendEmailToSubscribe(String email){
        this.subscribeEmailBox.sendKeys(email);
        this.arrowSubscribe.click();
    }

    public String getSuccessSubscribeMssg(){
        return BrowserUtils.getText(successSubscribeMssg);
    }

    public void clickCartButton(){
        cartButton.click();
    }






}

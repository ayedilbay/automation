package com.test.automationexercise.pages;

import com.test.automationexercise.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='signup-form']//h2")
    WebElement newUserSignUpMssg;

    @FindBy(xpath = "//h2[.='Login to your account']")
    WebElement loginToYourAccMssg;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameBox;

    @FindBy(xpath = "//input[@name='email' and @data-qa='signup-email']")
    WebElement emailBox;

    @FindBy(xpath = "//button[.='Signup']")
    WebElement signUpButton;

    @FindBy(xpath = "//div[@class='login-form']//input[@name='email']")
    WebElement emailBoxLogin;

    @FindBy(xpath = "//div[@class='login-form']//input[@name='password']")
    WebElement passwordBoxLogin;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//p[contains(text(), 'is incorrect!')]")
    WebElement errorMssg;


    public boolean validateNewUserSignUpMssg(){
        return newUserSignUpMssg.isDisplayed();
    }

    public String validateLoginToYourAccMss(){
        return BrowserUtils.getText(this.loginToYourAccMssg);
    }

    public void sendingInfo(String name, String email){
        this.nameBox.sendKeys(name);
        this.emailBox.sendKeys(email);
        signUpButton.click();
    }

    public void logInAsExistingUser(String email, String password){
        this.emailBoxLogin.sendKeys(email);
        this.passwordBoxLogin.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMssg(){
        return BrowserUtils.getText(errorMssg);
    }



}

package com.test.automationexercise.pages;

import com.test.automationexercise.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//b[.='Enter Account Information']")
    WebElement enterAccountInfoMssg;


    @FindBy(id = "id_gender2")
    WebElement mrsTitle;

    @FindBy(id = "id_gender1")
    WebElement mrTitle;

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameBox;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordBox;

    @FindBy(id = "days")
    WebElement day;

    @FindBy(id = "months")
    WebElement month;

    @FindBy(id = "years")
    WebElement year;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckBox;

    @FindBy(id = "optin")
    WebElement specialOfferCheckBox;

    @FindBy(id = "first_name")
    WebElement firstNameBox;

    @FindBy(id = "last_name")
    WebElement lastNameBox;

    @FindBy(id = "company")
    WebElement companyBox;

    @FindBy(id = "address1")
    WebElement address1Box;

    @FindBy(id = "address2")
    WebElement address2Box;

    @FindBy(id = "country")
    WebElement countryBox;

    @FindBy(xpath = "//input[@id='state']")
    WebElement stateBox;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityBox;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipCodeBox;

    @FindBy(id = "mobile_number")
    WebElement mobilePhoneNumberBox;

    @FindBy(xpath = "//button[.='Create Account']")
    WebElement createAccountButton;

    @FindBy(tagName = "b")
    WebElement accountCreatedMssg;

    @FindBy(xpath = "//div[.='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(),'Logged')]")
    WebElement loggedAsMssg;

    @FindBy(xpath ="//a[.=' Delete Account']")
    WebElement deleteUserButton;


    @FindBy(tagName = "h1")
    WebElement deleteAccountMssg;


    @FindBy(xpath = "//p[.='Email Address already exist!']")
    WebElement emailExistMssg;



    public String validateEnterAccountMssg(){

        return BrowserUtils.getText(enterAccountInfoMssg);
    }

    public void accountInfo(String title,String name, String password){
        title = title.toLowerCase();
        switch (title){
            case "mr":
                this.mrTitle.click();
                break;
            case "mrs":
                this.mrsTitle.click();
                break;
            default:
                System.out.println("Title is not valid. Please, provide valid title");;

        }
        this.nameBox.clear();
        this.nameBox.sendKeys(name);
        this.passwordBox.sendKeys(password);
        BrowserUtils.selectBy(this.day,"7","text");
        BrowserUtils.selectBy(this.month,"May","text");
        BrowserUtils.selectBy(this.year,"2010","text");

    }

    public void clickCheckBox(WebDriver driver){
        BrowserUtils.clickWithJS(driver,newsletterCheckBox);
        BrowserUtils.clickWithJS(driver,specialOfferCheckBox);
    }

    public void fillAddressInfo(WebDriver driver,String firstname, String lastname, String company, String address1, String address2,
                                String country,String state, String city, String zipCode, String mobileNumber){
        this.firstNameBox.sendKeys(firstname);
        this.lastNameBox.sendKeys(lastname);
        this.companyBox.sendKeys(company);
        this.address1Box.sendKeys(address1);
        this.address2Box.sendKeys(address2);
        BrowserUtils.scrollWithJS(driver,countryBox);
        BrowserUtils.selectBy(this.countryBox,country,"text");
        this.stateBox.sendKeys(state);
        this.cityBox.sendKeys(city);
        this.zipCodeBox.sendKeys(zipCode);
        this.mobilePhoneNumberBox.sendKeys(mobileNumber);
        createAccountButton.click();

    }

    public String getMssg(){
        return BrowserUtils.getText(accountCreatedMssg);
    }


    public void validateLoggedAsUser(String loggedAsUserMssg){
        this.continueButton.click();
        Assert.assertTrue(BrowserUtils.getText(this.loggedAsMssg).contains(loggedAsUserMssg));
    }

    public void deleteAccount(String deleteAccountMssg){
        deleteUserButton.click();
       Assert.assertEquals( deleteAccountMssg,BrowserUtils.getText(this.deleteAccountMssg));
    }

    public String getLoginAsUserMss(){
        return BrowserUtils.getText(loggedAsMssg);
    }

    public String getEmailExistMssg(){
        return BrowserUtils.getText(emailExistMssg);
    }

}

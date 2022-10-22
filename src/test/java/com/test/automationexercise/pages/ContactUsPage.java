package com.test.automationexercise.pages;

import com.test.automationexercise.utils.BrowserUtils;
import com.test.automationexercise.utils.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//h2[.='Get In Touch']")
    WebElement getInTouchMssg;

    @FindBy(xpath = "//input[@name='name']")
    WebElement name;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='subject']")
    WebElement subject;

    @FindBy(xpath = "//textarea[@id='message']")
    WebElement messageBox;

    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement chooseFileBttn;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitBttn;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMssg;



    public String getGetInTouchMssg(){
        return BrowserUtils.getText(getInTouchMssg);
    }

    public void fillForm(String name,String email, String subject, String message){
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.subject.sendKeys(subject);
        this.messageBox.sendKeys(message);

    }

    public void uploadFile(String path){
        chooseFileBttn.sendKeys(path);

    }

    public String getSuccessMssg(){
        return BrowserUtils.getText(successMssg);
    }

    public void clickSubmitOkButton(WebDriver driver){
        BrowserUtils.clickWithJS(driver,submitBttn);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}

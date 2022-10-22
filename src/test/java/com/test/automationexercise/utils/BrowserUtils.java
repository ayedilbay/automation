package com.test.automationexercise.utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {

    public static void selectBy(WebElement location, String value, String methodName){

        Select select = new Select(location);

        switch(methodName){
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available, Use text, value or index");

        }

    }

    public static String getText(WebElement element){
        return element.getText().trim();
    }

    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();

    }

    public static void clickWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void scrollWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void scrollWithPoint(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = element.getLocation();
        int xCord = point.getX();
        int yCord = point.getY();
        js.executeScript("window.scrollTo("+xCord+","+yCord+")");

    }

    public static void switchByID(WebDriver driver, String mainID){

        Set<String> allPagesId = driver.getWindowHandles();

        for(String id : allPagesId){
            if(!id.equals(mainID)){
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByTitle(WebDriver driver, String titleOfPage){
        Set<String> allPagesId = driver.getWindowHandles();
        for(String id : allPagesId){
            driver.switchTo().window(id);
            if(driver.getTitle().contains(titleOfPage)) {
                break;
            }
            }
    }


    public static void getScreenShot(WebDriver driver, String packageName, Scenario scenario){
        if(scenario.isFailed()) {

            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String location = System.getProperty("user.dir") + "/src/java/screenshot" + packageName;

            try {
                FileUtils.copyFile(file, new File(location + getTimeStamp("yyyy-MM-dd-HH-mm-SS") + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void getScreenShotCucumber(WebDriver driver,Scenario scenario){
        Date currentDate = new Date();
        String screenShotFileName = currentDate.toString().replace(" ", "-").replace(":","-");
        if(scenario.isFailed()){
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshot/"+screenShotFileName+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static String getTimeStamp(String pattern){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static void waitForClickability(WebDriver driver,WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibility(WebDriver driver,WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}




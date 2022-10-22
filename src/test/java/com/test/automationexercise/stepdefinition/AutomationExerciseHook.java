package com.test.automationexercise.stepdefinition;

import com.test.automationexercise.utils.BrowserUtils;
import com.test.automationexercise.utils.ConfigReader;
import com.test.automationexercise.utils.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class AutomationExerciseHook {

    WebDriver driver = DriverHelper.getDriver();

    @Before
    public void navigation(){
        driver.get(ConfigReader.readProperty("url"));

    }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShot(driver,"AutomationExercise",scenario);
        driver.quit();
    }
}

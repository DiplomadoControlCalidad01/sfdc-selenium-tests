package org.fundacionjala.diplomadoqa.guiautomation.test;

import org.fundacionjala.diplomadoqa.guiautomation.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class RootState {
    private WebDriver driver;
    
    @Test
    public void salesforceLogin() throws InterruptedException {
        driver.get("https://login.salesforce.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("uvillaseca@diplomadoqa2018.com", "YbaN8pAm");
        Thread.sleep(10000);
    }

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();			
    }		
}	
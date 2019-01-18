package org.fundacionjala.diplomadoqa.guiautomation.test;

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
    public void salesforceLogin() {
        driver.get("https://login.salesforce.com");
        String title = driver.getTitle();
        assertThat(title).contains("Login");

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("uvillaseca@diplomadoqa2018.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("Login")).click();
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
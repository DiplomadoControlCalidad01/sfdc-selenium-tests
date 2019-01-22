package org.fundacionjala.diplomadoqa.guiautomation.test;

import org.fundacionjala.diplomadoqa.guiautomation.page.LoginPage;
import org.fundacionjala.diplomadoqa.guiautomation.page.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class RootState {
    private WebDriver driver;
    
    @Test
    @Parameters({"appUrl", "username", "password"})
    public void salesforceLogin(String appUrl, String username, String password) throws InterruptedException {
        driver.get(appUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(username, password);
        TopMenu topMenu = new TopMenu(driver);
        topMenu.clickSetup();
        topMenu.clickDeveloperConsole();
    }

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();			
    }		
}	
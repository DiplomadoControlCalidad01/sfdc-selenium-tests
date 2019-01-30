package org.fundacionjala.diplomadoqa.guiautomation.test;

import org.fundacionjala.diplomadoqa.guiautomation.GuiceModule;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.inject.Named;

@Guice(modules = GuiceModule.class)
public class RootState {

    @Inject
    private WebDriver driver;

    @Inject
    @Named("app.url")
    private String appUrl;

    @Test
    public void loadWebPage() {
        driver.get(appUrl);
    }

    @AfterSuite
    public void afterTest() {
        driver.quit();			
    }		
}	
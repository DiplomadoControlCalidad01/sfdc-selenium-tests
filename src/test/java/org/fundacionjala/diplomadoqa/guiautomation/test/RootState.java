package org.fundacionjala.diplomadoqa.guiautomation.test;

import org.fundacionjala.diplomadoqa.guiautomation.page.DeveloperConsoleMenuBar;
import org.fundacionjala.diplomadoqa.guiautomation.page.LoginPage;
import org.fundacionjala.diplomadoqa.guiautomation.page.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

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
        DeveloperConsoleMenuBar devConsoleMenuBar = new DeveloperConsoleMenuBar(driver);
        Thread.sleep(10000);
        devConsoleMenuBar.expandFileMenu();
        Thread.sleep(5000);
        devConsoleMenuBar.expandFileNew();
        Thread.sleep(10000);
    }

    @BeforeTest
    @Parameters("browserType")
    public void beforeTest(String browserType) {
        switch (browserType.toUpperCase()) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "c:\\opt\\google\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);

                break;
            case "FIREFOX":
            default:
                System.setProperty("webdriver.gecko.driver", "c:\\opt\\mozilla\\geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                firefoxOptions.addPreference("dom.push.enabled", false);
                driver = new FirefoxDriver(firefoxOptions);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();			
    }		
}	
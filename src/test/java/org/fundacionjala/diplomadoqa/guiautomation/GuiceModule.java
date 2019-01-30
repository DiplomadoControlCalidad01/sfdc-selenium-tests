package org.fundacionjala.diplomadoqa.guiautomation;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import org.fundacionjala.diplomadoqa.guiautomation.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import javax.inject.Singleton;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * User: Ubaldo Villaseca
 * Date: 1/30/2019
 */
public class GuiceModule extends AbstractModule {

    private static Logger logger = Logger.getLogger(GuiceModule.class);

    private Properties props = new Properties();

    @Override
    protected void configure() {
        String propertiesFile = "/global.properties";
        try {
            props.load(getClass().getResourceAsStream(propertiesFile));
            Names.bindProperties(binder(), props);
        } catch (FileNotFoundException e) {
            logger.error(String.format("The configuration file %s could not be found", propertiesFile), e);
        } catch (IOException e) {
            logger.error("I/O Exception during loading configuration", e);
        }

        bind(LoginPage.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    WebDriver providesWebDriver() {
        String browserType = props.getProperty("run.browserType");
        WebDriver driver;
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
        driver.manage().window().maximize();

        return driver;
    }

    @Provides
    @Singleton
    WebDriverWait providesWebDriverWait(WebDriver driver) {
        int timeout = Integer.parseInt(props.getProperty("run.timeout"));

        return new WebDriverWait(driver, timeout);
    }
}

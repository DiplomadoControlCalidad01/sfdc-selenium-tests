package org.fundacionjala.diplomadoqa.guiautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

/**
 * User: ubaldo villaseca
 * Date: 1/23/2019
 */
public abstract class Component {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public Component(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15000);
    }

    protected void switchTo(String windowTitle) {
        if (!run(() -> findWindow(windowTitle))) {
            String msg = String.format("Could not find window with title '%s'", windowTitle);

            throw new RuntimeException(msg);
        }
    }

    private boolean findWindow(String windowTitle) {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle: windowHandles) {
            if (!currentWindowHandle.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                if (driver.getTitle().equals(windowTitle)) {
                    return true;
                } else {
                    driver.switchTo().window(currentWindowHandle);
                }
            }
        }

        return false;
    }
}

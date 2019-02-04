package org.fundacionjala.diplomadoqa.guiautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.inject.Inject;
import java.util.Set;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

/**
 * User: Ubaldo Villaseca
 * Date: 1/23/2019
 */
public abstract class Component {

    @Inject
    protected WebDriver driver;

    @Inject
    protected WebDriverWait wait;

    protected void switchTo(String windowTitle) {
        if (!run(() -> findWindow(windowTitle))) {
            String msg = String.format("Could not find window with title '%s'", windowTitle);

            throw new RuntimeException(msg);
        }
    }

    protected void switchTo() {

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

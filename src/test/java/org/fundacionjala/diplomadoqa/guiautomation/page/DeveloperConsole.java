package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.log4testng.Logger;

import javax.inject.Inject;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

/**
 * User: Ubaldo Villaseca
 * Date: 1/23/2019
 */
public class DeveloperConsole extends Component {

    private static Logger logger = Logger.getLogger(DeveloperConsole.class);

    @Inject
    private NewApexClass newApexClass;

    @Inject
    private NewApexTrigger newApexTrigger;

    @Inject
    private NewVisualforcePage newVisualforcePage;

    @Override
    public void switchTo() {
        switchTo("Developer Console");
    }

    public NewApexClass createNewApexClass() {
        run(() -> {
            fileMenu().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("Interruption exception", e);
            }
            Actions actions = new Actions(driver);
            actions.moveToElement(fileNew());
            actions.build().perform();
            newApexClass().click();
        });

        return newApexClass;
    }

    public NewApexTrigger createNewApexTrigger() {
        run(() -> {
            fileMenu().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("Interruption exception", e);
            }
            Actions actions = new Actions(driver);
            actions.moveToElement(fileNew());
            actions.build().perform();
            newApexTrigger().click();
        });

        return newApexTrigger;
    }

    public NewVisualforcePage createNewVisualforcePage() {
        run(() -> {
            fileMenu().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("Interruption exception", e);
            }
            Actions actions = new Actions(driver);
            actions.moveToElement(fileNew());
            actions.build().perform();
            newVisualforcePage().click();
        });

        return newVisualforcePage;
    }

    public boolean findTab(String tabName) {
        return driver.findElement(By.xpath(String.format("//div[@id='editors']/div[contains(@id, 'tabbar')]//button[contains(., '%s')]", tabName))).isDisplayed();
    }

    private WebElement fileMenu() {
        return driver.findElement(By.xpath("//button[contains(@id, 'editorMenuEntry')]"));
    }

    private WebElement fileNew() {
        return driver.findElement(By.xpath("//a[contains(@id, 'newMenuEntry')]"));
    }

    private WebElement newApexClass() {
        return driver.findElement(By.xpath("//a[contains(@id, 'newApexClassButton')]"));
    }

    private WebElement newApexTrigger() {
        return driver.findElement(By.xpath("//a[contains(@id, 'apexTriggerMenuEntry')]"));
    }

    private WebElement newVisualforcePage() { return driver.findElement(By.xpath("//a[contains(@id, 'newVFpageButton')]")); }
}

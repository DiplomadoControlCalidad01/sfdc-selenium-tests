package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.inject.Inject;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

/**
 * User: ubaldo villaseca
 * Date: 1/23/2019
 */
public class DeveloperConsole extends Component {

    @Inject
    private NewApexClass newApexClass;

    @Override
    public void switchTo() {
        switchTo("Developer Console");
    }

    public NewApexClass createNewApexClass() {
        run(() -> {
            Actions actions = new Actions(driver);
            actions.click(fileMenu());
            actions.moveToElement(fileNew());
            actions.click(newApexClass());
            actions.build().perform();
        });

        return newApexClass;
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
}

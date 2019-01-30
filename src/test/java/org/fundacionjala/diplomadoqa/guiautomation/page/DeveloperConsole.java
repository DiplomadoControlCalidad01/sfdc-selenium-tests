package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.openqa.selenium.By;
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

    public void openFileNew() {
        run(() -> {
            expandFileMenu();
            expandFileNew();
        });
    }

    public NewApexClass createNewApexClass() {
        run(() -> {
            driver.findElement(By.xpath("//a[contains(@id, 'newApexClassButton')]")).click();
        });

        return newApexClass;
    }

    protected void expandFileMenu() {
        driver.findElement(By.xpath("//button[contains(@id, 'editorMenuEntry')]")).click();
    }

    protected void expandFileNew() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[contains(@id, 'newMenuEntry')]")));
        actions.build().perform();
    }
}

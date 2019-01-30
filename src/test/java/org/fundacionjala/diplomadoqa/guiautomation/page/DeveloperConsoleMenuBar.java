package org.fundacionjala.diplomadoqa.guiautomation.page;

import com.google.inject.Inject;
import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

/**
 * User: ubaldo villaseca
 * Date: 1/23/2019
 */
public class DeveloperConsoleMenuBar extends Component {

    public DeveloperConsoleMenuBar() {
        switchTo("Developer Console");
    }

    public void openFileNew() {
        run(() -> {
            expandFileMenu();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#editorMenu-innerCt")));
            expandFileNew();
        });
    }

    public void createNewApexClass() {
        driver.findElement(By.cssSelector("#newApexClassButton-itemEl")).click();
    }

    protected void expandFileMenu() {
        driver.findElement(By.xpath("//button[contains(., 'File')]")).click();
    }

    protected void expandFileNew() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[contains(., 'New')]")));
        actions.build().perform();
    }
}

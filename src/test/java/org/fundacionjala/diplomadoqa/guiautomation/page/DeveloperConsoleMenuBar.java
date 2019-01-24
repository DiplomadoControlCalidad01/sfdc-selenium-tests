package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.fundacionjala.diplomadoqa.guiautomation.ReTry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

/**
 * User: ubaldo villaseca
 * Date: 1/23/2019
 */
public class DeveloperConsoleMenuBar extends Component {
    public DeveloperConsoleMenuBar(WebDriver driver) {
        super(driver);
        switchTo("Developer Console");
    }

    public void openFileNew() {
        run(() -> {
            expandFileMenu();
            expandFileNew();
        });
    }

    protected void expandFileMenu() {
        driver.findElement(By.xpath("//button[contains(., 'File')]")).click();
    }

    protected void expandFileNew() {
        WebElement element = driver.findElement(By.xpath("//a[contains(., 'New')]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.build().perform();
    }
}

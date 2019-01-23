package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * User: ubaldo villaseca
 * Date: 1/23/2019
 */
public class DeveloperConsoleMenuBar extends Component {
    public DeveloperConsoleMenuBar(WebDriver driver) {
        super(driver);
        switchTo("Developer Console");
    }

    public void expandFileMenu() {
        driver.findElement(By.cssSelector("#editorMenuEntry-btnWrap")).click();
    }

    public void expandFileNew() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector("#newMenuEntry-itemEl"));
        actions.moveToElement(element);
        actions.build().perform();
    }
}

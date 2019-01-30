package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

public class TopMenu extends Component {
    public void openDeveloperConsole() {
        run(() -> {
            clickSetup();
            clickDeveloperConsole();
        });
    }

    protected void clickSetup() {
        driver.findElement(By.cssSelector(".setupGear a")).click();
    }

    protected void clickDeveloperConsole() {
        driver.findElement(By.cssSelector("#developer-console-link")).click();
    }
}

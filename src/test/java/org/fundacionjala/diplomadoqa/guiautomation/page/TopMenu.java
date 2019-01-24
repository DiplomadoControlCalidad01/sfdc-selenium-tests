package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.fundacionjala.diplomadoqa.guiautomation.ReTry;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenu extends Component {
    public TopMenu (WebDriver driver) {
        super(driver);
    }

    public void clickSetup() {
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oneHeader")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oneUserProfileCardTrigger")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".setupGear a")));*/
        WebElement setupLink = driver.findElement(By.cssSelector(".setupGear a"));
        wait.until(ExpectedConditions.elementToBeClickable(setupLink));
        // otherwise the popup is not displayed in Firefox
        setupLink.click();
        setupLink.click();
        setupLink.click();
    }

    public void clickDeveloperConsole() {
        driver.findElement(By.cssSelector("#developer-console-link")).click();
    }

}

package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenu {
    private final WebDriver driver;

    public TopMenu (WebDriver driver) {
        this.driver = driver;
    }

    public void clickSetup() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions..elementToBeClickable(By.cssSelector(".setupGear a")));
        driver.findElement(By.cssSelector(".setupGear a")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickDeveloperConsole() {
        driver.findElement(By.cssSelector("#developer-console-link")).click();
    }

}

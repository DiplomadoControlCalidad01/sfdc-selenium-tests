package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.openqa.selenium.By;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

/**
 * User: Ubaldo Villaseca
 * Date: 2/4/2019
 */
public class NewVisualforcePage extends Component {
    public void setName(String className) {
        run (() -> driver.findElement(By.xpath("//span[contains(text(), 'New Apex Page')]/ancestor::div//input")).sendKeys(className));
    }

    public void clickOk() {
        run (() -> driver.findElement(By.xpath("//span[contains(text(), 'New Apex Page')]/ancestor::div//button[contains(., 'OK')]")).click());
    }
}

package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.openqa.selenium.By;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

/**
 * User: Ubaldo Villaseca
 * Date: 1/30/2019
 */
public class NewApexClass extends Component {
    public void setName(String className) {
        run (() -> driver.findElement(By.xpath("//span[contains(text(), 'New Apex class')]/ancestor::div//input")).sendKeys(className));
    }

    public void clickOk() {
        run (() -> driver.findElement(By.xpath("//span[contains(text(), 'New Apex class')]/ancestor::div//button[contains(., 'OK')]")).click());
    }
}

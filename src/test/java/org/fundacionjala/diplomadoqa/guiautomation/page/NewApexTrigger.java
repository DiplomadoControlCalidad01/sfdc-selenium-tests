package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.fundacionjala.diplomadoqa.guiautomation.ReTry.run;

/**
 * User: Ubaldo Villaseca
 * Date: 2/4/2019
 */
public class NewApexTrigger extends Component {
    public void setName(String className) {
        run (() -> driver.findElement(By.xpath("//span[contains(text(), 'New Apex Trigger')]/ancestor::div//input")).sendKeys(className));
    }

    public List<String> getSObjects() {
        run(() -> driver.findElement(By.xpath("//input[contains(@id, 'newTriggerEntities')]")).click());
        List<WebElement> sObjects = driver.findElements(By.xpath("//li[@role='option']"));

        return sObjects.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickSObject(int index) {
        run(() -> driver.findElement(By.xpath(String.format("(//li[@role='option'])[%d]", index))).click());
    }

    public void clickSubmit() {
        run (() -> driver.findElement(By.xpath("//span[contains(text(), 'New Apex Trigger')]/ancestor::div//button[contains(., 'Submit')]")).click());
    }
}

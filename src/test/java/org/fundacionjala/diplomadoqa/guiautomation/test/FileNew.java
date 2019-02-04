package org.fundacionjala.diplomadoqa.guiautomation.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.fundacionjala.diplomadoqa.guiautomation.DependsOn;
import org.fundacionjala.diplomadoqa.guiautomation.GuiceModule;
import org.fundacionjala.diplomadoqa.guiautomation.page.*;
import org.testng.annotations.Guice;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import javax.inject.Inject;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * User: Ubaldo Villaseca
 * Date: 1/30/2019
 */
@Guice(modules = GuiceModule.class)
public class FileNew {

    @Inject
    private TopMenu topMenu;

    @Inject
    private DeveloperConsole devConsole;

    @Test
    public void openDeveloperConsole() {
        topMenu.openDeveloperConsole();
        devConsole.switchTo();
    }

    @Test(dependsOnMethods = "openDeveloperConsole")
    public void createNewApexClass() {
        NewApexClass newApexClass = devConsole.createNewApexClass();
        String newApexClassName = RandomStringUtils.randomAlphabetic(10);
        newApexClass.setName(newApexClassName);
        newApexClass.clickOk();
        assertThat(devConsole.findTab(newApexClassName)).isTrue();
    }

    @Test(dependsOnMethods = "openDeveloperConsole")
    public void createNewApexTrigger() {
        NewApexTrigger newApexTrigger = devConsole.createNewApexTrigger();
        String newApexTriggerName = RandomStringUtils.randomAlphabetic(10);
        newApexTrigger.setName(newApexTriggerName);
        List<String> sObjects = newApexTrigger.getSObjects();
        newApexTrigger.clickSObject(RandomUtils.nextInt(0, sObjects.size()));
        newApexTrigger.clickSubmit();
        assertThat(devConsole.findTab(newApexTriggerName)).isTrue();
    }

    @Test(dependsOnMethods = "openDeveloperConsole")
    public void createNewVisualForce() {
        NewVisualforcePage newVisualforcePage = devConsole.createNewVisualforcePage();
        String newVisualforcePageName = RandomStringUtils.randomAlphabetic(10);
        newVisualforcePage.setName(newVisualforcePageName);
        newVisualforcePage.clickOk();
        assertThat(devConsole.findTab(newVisualforcePageName)).isTrue();
    }
}

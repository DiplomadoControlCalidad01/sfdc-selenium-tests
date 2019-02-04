package org.fundacionjala.diplomadoqa.guiautomation.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.fundacionjala.diplomadoqa.guiautomation.DependsOn;
import org.fundacionjala.diplomadoqa.guiautomation.GuiceModule;
import org.fundacionjala.diplomadoqa.guiautomation.page.DeveloperConsole;
import org.fundacionjala.diplomadoqa.guiautomation.page.NewApexClass;
import org.fundacionjala.diplomadoqa.guiautomation.page.TopMenu;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * User: Ubaldo Villaseca
 * Date: 2/4/2019
 */
@Guice(modules = GuiceModule.class)
public class OpenDeveloperConsole {
    @Inject
    private TopMenu topMenu;

    @Inject
    private DeveloperConsole devConsole;

    @Test
    @DependsOn(Login.class)
    public void salesforceLogin() {
        topMenu.openDeveloperConsole();
        devConsole.switchTo();
        NewApexClass newApexClass = devConsole.createNewApexClass();
        String newApexClassName = RandomStringUtils.randomAlphabetic(10);
        newApexClass.setName(newApexClassName);
        newApexClass.clickOk();
        assertThat(devConsole.findTab(newApexClassName)).isTrue();
    }
}

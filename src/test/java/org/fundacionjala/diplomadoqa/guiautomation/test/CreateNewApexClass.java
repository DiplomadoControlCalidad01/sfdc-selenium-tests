package org.fundacionjala.diplomadoqa.guiautomation.test;

import org.fundacionjala.diplomadoqa.guiautomation.DependsOn;
import org.fundacionjala.diplomadoqa.guiautomation.page.DeveloperConsoleMenuBar;
import org.fundacionjala.diplomadoqa.guiautomation.page.LoginPage;
import org.fundacionjala.diplomadoqa.guiautomation.page.TopMenu;
import org.testng.annotations.Test;

/**
 * User: Ubaldo Villaseca
 * Date: 1/30/2019
 */

public class CreateNewApexClass {
    @Test
    @DependsOn(RootState.class)
    public void salesforceLogin(String appUrl, String username, String password) throws InterruptedException {
        /*LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(username, password);
        TopMenu topMenu = new TopMenu(driver);
        topMenu.openDeveloperConsole();
        DeveloperConsoleMenuBar devConsoleMenuBar = new DeveloperConsoleMenuBar(driver);
        devConsoleMenuBar.openFileNew();
        devConsoleMenuBar.createNewApexClass();

        Thread.sleep(5000);*/
    }
}

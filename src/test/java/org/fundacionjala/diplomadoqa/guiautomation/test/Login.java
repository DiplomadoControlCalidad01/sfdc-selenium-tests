package org.fundacionjala.diplomadoqa.guiautomation.test;

import org.fundacionjala.diplomadoqa.guiautomation.DependsOn;
import org.fundacionjala.diplomadoqa.guiautomation.GuiceModule;
import org.fundacionjala.diplomadoqa.guiautomation.page.LoginPage;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * User: Ubaldo Villaseca
 * Date: 1/30/2019
 */
@Guice(modules = GuiceModule.class)
public class Login {

    @Inject
    private LoginPage loginPage;

    @Inject
    @Named("profiles.sysadmin.username")
    private String username;

    @Inject
    @Named("profiles.sysadmin.password")
    private String password;

    @Test
    @DependsOn(RootState.class)
    public void doLogin() {
        loginPage.doLogin(username, password);
    }
}

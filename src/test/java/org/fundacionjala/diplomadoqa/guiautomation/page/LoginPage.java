package org.fundacionjala.diplomadoqa.guiautomation.page;

import org.fundacionjala.diplomadoqa.guiautomation.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Component {

    public void setUsername(String username) {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void submitWithClick() {
        driver.findElement(By.id("Login")).click();
    }

    public void doLogin(String username, String password) {
        setUsername(username);
        setPassword(password);
        submitWithClick();
    }
}

package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    //constructor
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

}

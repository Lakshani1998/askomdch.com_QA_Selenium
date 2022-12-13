package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {

    //define UI elements

    //make sure "storeMenuLink" clz only accessible for this calss
    private final By storeMenuLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");

    //constructor with super keyword
    public HomePage(WebDriver driver) {
        super(driver);
    }



    //clickStoreMenuLink method
    public StorePage clickStoreMenuLink()
    {
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }
}

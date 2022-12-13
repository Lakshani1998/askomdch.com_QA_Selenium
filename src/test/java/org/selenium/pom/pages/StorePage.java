package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By addToCartBtn = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    //Method create for add text to search fld
    public StorePage enterTxtInSearchFld(String txt)
    {
        driver.findElement(searchFld).sendKeys(txt);
        return this;
    }

    //Method to click on the search button
    public StorePage clickSearchBtn()
    {
        driver.findElement(searchBtn).click();
        return this;
    }

    //Method to check the title "Search results: “Blue”"
    public String getTitle()
    {
        return driver.findElement(title).getText();
    }

    //Method to click add to cart button
    public void clickAddToCartBtn()
    {
        driver.findElement(addToCartBtn).click();
    }
}

package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.StorePage;

public class CheckoutPage extends BasePage {

    private final By firstNameFld = By.cssSelector("#billing_first_name");
    private final By lastNameFld = By.cssSelector("#billing_last_name");
    private final By addressLineOneFld = By.cssSelector("#billing_address_1");
    private final By cityFld = By.cssSelector("#billing_city");
//    private final By stateFld = By.cssSelector("span[class='select2 select2-container select2-container--default select2-container--focus'] span[aria-label='State']");
    private final By postCodeFld = By.cssSelector("#billing_postcode");
    private final By emailFld = By.cssSelector("#billing_email");
    private final By placeOrder = By.cssSelector("#place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");

    public CheckoutPage(WebDriver driver)
    {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstName)
    {
        driver.findElement(firstNameFld).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName)
    {
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddressLineOne(String addressLineOne)
    {
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }

    public CheckoutPage enterCity(String city)
    {
        driver.findElement(cityFld).sendKeys(city);
        return this;
    }

//    public CheckoutPage enterState(String state)
//    {
//        driver.findElement(stateFld).sendKeys(state);
//        return this;
//    }

    public CheckoutPage enterPostCode(String postCode)
    {
        driver.findElement(postCodeFld).sendKeys(postCode);
        return this;
    }

    public CheckoutPage enterEmail(String email)
    {
        driver.findElement(emailFld).sendKeys(email);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress)
    {
        return  enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterAddressLineOne(billingAddress.getAddressLineOne()).
                enterCity(billingAddress.getCity()).
                enterPostCode(billingAddress.getPostCode()).
                enterEmail(billingAddress.getEmail());

    }

    public CheckoutPage placeOrder()
    {
        driver.findElement(placeOrder).click();
        return this;
    }

    public String getNotice()
    {
        return driver.findElement(successNotice).getText();
    }

    
}

package org.selenium;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class MyFirstTestCase  extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
//        BillingAddress billingAddress = new BillingAddress().
//            setFirstName("Lakshani").
//            setLastName("Erandika").
//            setAddressLineOne("San Fransisco").
//            setCity("San Fransisco").
//                setPostCode("94123").
//            setEmail("admin@gmail.com");

        BillingAddress billingAddress = new BillingAddress("Lakshani","Erandika","San Fransisco","San Fransisco","94123", "admin@gmail.com");

        //clickMenuLink and getting url
        StorePage storePage = new HomePage(driver).
                load().
                clickStoreMenuLink().
                search("Blue");

        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);

        //import cart page
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");

        //checkout page methods calling
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
//        checkoutPage.enterBillingAddress("Lakshani","Erandika")
        checkoutPage.setBillingAddress(billingAddress).
                placeOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");




    }


//    @Test
//    public void guestCheckoutUsingDirectBankTransferWithLogin() throws InterruptedException {
//
//        driver.get("https://askomdch.com/");
//
//
//        driver.findElement(By.cssSelector(("li[id='menu-item-1227'] a[class='menu-link']"))).click();
//        driver.findElement(By.cssSelector("#woocommerce-product-search-field-0")).sendKeys("Blue");
//        driver.findElement(By.cssSelector("button[value='Search']")).click();
//        //assert is use to get whether relevant page loaded or not
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),"Search results: “Blue”"
//        );
//        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),"Blue Shoes"
//        );
//        driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
//
//        //login part
//        driver.findElement(By.cssSelector(".showlogin")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("#username")).sendKeys("admin@gmail.com");
//        driver.findElement(By.cssSelector("#password")).sendKeys("123");
//        driver.findElement(By.cssSelector("button[value='Login']")).click();
//
//        //fill the form and place order
//        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("Lakshani");
//        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("Erandika");
//        driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("ABC Street");
//        driver.findElement(By.cssSelector("#billing_city")).sendKeys("Sydni");
//        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("90210");
//        driver.findElement(By.cssSelector("#billing_email")).sendKeys("admin@gmail.com");
//        driver.findElement(By.cssSelector("#place_order")).click();
//        Thread.sleep(5000);
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received")).getText(),"Thank you. Your order has been received."
//        );

//    }


}

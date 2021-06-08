package com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.objects.rewritten.CartPageNew;
import utils.AutomationWait;

import java.text.DecimalFormat;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

//15 tests

public class CartAddProductTest extends BaseTestAbstractClass {
    String stringUrlMainPage = "http://automationpractice.com/index.php";
    CartPageNew cartPageNew = new CartPageNew(driver);

    AutomationWait automationWait = new AutomationWait();
    int quantity = 2;

    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrlMainPage);
        //CartPageNew cartPageNew = new CartPageNew(driver);

        Thread.sleep(5000);
        //Wrapper.getFindFluentWait();
    }

//    @AfterMethod
//    void cleanCart() throws InterruptedException, AWTException {
//        Thread.sleep(5000);
//        generalSeleniumMethods.clickAnyWhere();
//        Thread.sleep(5000);
//
//        while (cartPageNew.cartEmptyDisplayed() != true) {
//            cartPageNew.hoverCartDropDown();
//            cartPageNew.clickCrossIconCart();
//        }
//    }

    @Test //passed
    public void findFadedShortSleeveTshirts() {
        assertTrue(cartPageNew.fadedShortSleeveTshirtsDisplayed(), "product is not found");
    }

    @Test //passed
    public void findBlouse() {
        assertTrue(cartPageNew.blouseDisplayed(), "product is not found");
    }

    @Test //passed
    public void findPrintedDress() {
        assertTrue(cartPageNew.printedDressDisplayed(), "product is not found");
    }

    @Test //passed
    public void findPrintedDressTwo() {
        assertTrue(cartPageNew.printedDressTwoDisplayed(), "product is not found");
    }

    @Test //passed
    public void findPrintedSummerDress() {
        assertTrue(cartPageNew.printedSummerDressDisplayed(), "product is not found");
    }

    @Test //passed
    public void findPrintedSummerDressTwo() {
        assertTrue(cartPageNew.printedSummerDressTwoDisplayed(), "product is not found");
    }

    @Test //passed
    public void findPrintedChiffonDress() {
        assertTrue(cartPageNew.printedChiffonDressDisplayed(), "product is not found");
    }

    @Test //passed
    public void addToCartProductFromPlp() throws InterruptedException {
        cartPageNew.hoverFadedShortSleeve();
        Thread.sleep(5000);
        cartPageNew.clickAddToCartFirstProduct();
        assertEquals(cartPageNew.alertTextAddedToCartModal(), cartPageNew.ADD_TO_CART_MODAL);
    }

    @Test // failed
    public void addToCartFromPdp() throws InterruptedException {
        cartPageNew.clickProductOne();
        Thread.sleep(1000);
        cartPageNew.clickAddToCartFromPdp();
        Assert.assertEquals(cartPageNew.alertTextAddedToCartModal(), cartPageNew.ADD_TO_CART_MODAL);
    }

    @Test //
    public void addToCartFromPdpSix() throws InterruptedException {
        cartPageNew.clickProductOne();
        Thread.sleep(1000);
        cartPageNew.clickPlusFive();
        cartPageNew.clickAddToCartFromPdp();
        Thread.sleep(15000);
        Assert.assertEquals(cartPageNew.alertTextThereAreInTheCart(), cartPageNew.THERE_ARE_IN_THE_CART);
        System.out.println(cartPageNew.alertTextThereAreInTheCart());
    }

    @Test //passed
    public void priceTwoProducts() throws InterruptedException {
        cartPageNew.clickProductOne();
        Thread.sleep(1000);
        cartPageNew.clickPlus();
        cartPageNew.clickAddToCartFromPdp();
        Assert.assertEquals(cartPageNew.textToDigitsPrice() * quantity, cartPageNew.textToDigitsTotalAddedProductModal());
    }

    @Test //The bug: "Continue Shopping" button does not work
    public void priceTwoDifferentProducts() throws InterruptedException {
        cartPageNew.clickProductOne();
        cartPageNew.clickPlus();
        float firstPrice = cartPageNew.textToDigitsPrice() * quantity;
        cartPageNew.clickAddToCartFromPdp();
        cartPageNew.clickContinueShopping();
        Thread.sleep(7000);
        cartPageNew.clickProductTwo();
        Thread.sleep(1000);
        cartPageNew.clickPlus();
        Thread.sleep(5000);
        float secondPrice = cartPageNew.textToDigitsPrice() * quantity;
        cartPageNew.clickAddToCartFromPdp();
        Thread.sleep(5000);

        Assert.assertEquals((firstPrice + secondPrice), cartPageNew.textToDigitsTotalAddedProductModal());
    }

    @Test //passed
    public void priceTwoDifferentProductsTwo() throws InterruptedException {
        cartPageNew.clickProductOne();
        Thread.sleep(1000);
        cartPageNew.clickPlus();
        Thread.sleep(2000);
        float firstPrice = cartPageNew.textToDigitsPrice() * quantity;
        cartPageNew.clickAddToCartFromPdp();
        Thread.sleep(2000);
        cartPageNew.clickCrossIcon();

        cartPageNew.clickLogo();
        Thread.sleep(2000);

        cartPageNew.clickProductTwo();
        Thread.sleep(1000);
        cartPageNew.clickPlus();
        Thread.sleep(2000);
        float secondPrice = cartPageNew.textToDigitsPrice() * quantity;
        cartPageNew.clickAddToCartFromPdp();
        Thread.sleep(2000);
        //System.out.println(cartPage.textToDigitsTotalAddedProducts());

        Assert.assertEquals((Float.parseFloat(new DecimalFormat("0.00").
                format(firstPrice + secondPrice))), Float.parseFloat(new DecimalFormat("0.00").
                format(cartPageNew.textToDigitsTotalProductsAddedAddedToCartModal()))); //actual, expected
    }

    @Test // failed
    public void makeCartEmpty() throws InterruptedException {
        cartPageNew.clickProductOne();
        Thread.sleep(1000);

        cartPageNew.clickAddToCartFromPdp();
        Thread.sleep(5000);
        cartPageNew.clickCrossIcon();

        cartPageNew.hoverCartDropDown();
        Thread.sleep(5000);
        cartPageNew.clickCrossIconCart();
        Thread.sleep(5000);
        assertTrue(cartPageNew.cartEmptyDisplayed());
    }

    @Test // failed
    public void makeCartEmptySeveralProducts() throws InterruptedException {
        cartPageNew.hoverFadedShortSleeve();
        Thread.sleep(1000);
        cartPageNew.clickAddToCartFirstProduct();
        Thread.sleep(5000);

        cartPageNew.clickCrossIcon();
        Thread.sleep(5000);

        cartPageNew.hoverPrintedDress();
        Thread.sleep(5000);
        cartPageNew.clickAddToCartThirdProduct();
        Thread.sleep(5000);

        cartPageNew.clickCrossIcon();
        Thread.sleep(7000);

        cartPageNew.hoverCartDropDown();
        Thread.sleep(5000);
        cartPageNew.clickCrossIconCart();
        Thread.sleep(5000);
        cartPageNew.clickCrossIconCart();
        Thread.sleep(5000);

        assertTrue(cartPageNew.cartEmptyDisplayed());
    }
}

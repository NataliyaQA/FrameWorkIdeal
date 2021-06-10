package com.automationpractice;

import businessLogic.BusinessLogic;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.objects.rewritten.CartPageNew;
import utils.AutomationWait;

import java.text.DecimalFormat;

import static org.testng.Assert.assertTrue;

//15 tests

public class CartAddProductTest extends BaseTestAbstractClass {
    String stringUrlMainPage = "http://automationpractice.com/index.php";
    CartPageNew cartPageNew = new CartPageNew(driver);
    BusinessLogic businessLogic = new BusinessLogic(driver);
    AutomationWait automationWait = new AutomationWait();
    int quantity = 2;

    @BeforeMethod
    void setUpMethod(){
        driver.get(stringUrlMainPage);
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
    public void addToCartProductFromPlp() {
        Assert.assertEquals(businessLogic.addToCartProductFromPlp(), cartPageNew.ADD_TO_CART_MODAL);
    }

    @Test //passed
    public void addToCartFromPdp() throws InterruptedException {
        Assert.assertEquals(businessLogic.addToCartFromPdp(), cartPageNew.ADD_TO_CART_MODAL);
    }

    @Test //failed
    public void addToCartFromPdpSix() {
        Assert.assertEquals(businessLogic.addToCartFromPdpSix(), cartPageNew.THERE_ARE_IN_THE_CART);
    }

    @Test //failed
    public void priceTwoProducts() {
        Assert.assertEquals(businessLogic.priceTwoProducts() * quantity,
                cartPageNew.textToDigitsTotalAddedProductModal());
    }

    @Test //The bug: "Continue Shopping" button does not work
    public void priceTwoDifferentProducts() {
        Assert.assertEquals(businessLogic.priceTwoDifferentProducts(),
                cartPageNew.textToDigitsTotalAddedProductModal());
    }

    @Test //failed
    public void priceTwoDifferentProductsTwo() {
        Assert.assertEquals(businessLogic.priceTwoDifferentProductsTwo(),
                (double)Float.parseFloat(new DecimalFormat("0.00").
                format(cartPageNew.textToDigitsTotalProductsAddedAddedToCartModal()))); //actual, expected
    }

    @Test // failed
    public void makeCartEmpty() {
        assertTrue(businessLogic.makeCartEmpty());
    }

    @Test // failed
    public void makeCartEmptySeveralProducts() {
        assertTrue(businessLogic.makeCartEmptySeveralProducts());
    }
}

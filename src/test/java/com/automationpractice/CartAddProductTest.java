package com.automationpractice;

import businessLogic.BusinessLogic;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.objects.rewritten.CartPageNew;
import utils.AutomationWait;
import utils.listeners.TestListener;

import java.text.DecimalFormat;

import static org.testng.Assert.assertTrue;


@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Cart")
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

    @Test (priority = 0, description = "Find 1st product") //passed
    @Severity(SeverityLevel.MINOR)
    @Description("Find 1st product")
    @Story("Add product to the cart")
    public void findFadedShortSleeveTshirts() {
        assertTrue(cartPageNew.fadedShortSleeveTshirtsDisplayed(), "product is not found");
    }

    @Test (priority = 0, description = "Find 3st product") //passed
    @Severity(SeverityLevel.NORMAL)
    @Description("Find 3st product")
    @Story("Add product to the cart")
    public void findBlouse() {
        assertTrue(cartPageNew.blouseDisplayed(), "product is not found");
    }

    @Test (priority = 0, description = "Find Printed Dress product") //passed
    @Severity(SeverityLevel.MINOR)
    @Description("Find Printed Dress product")
    @Story("Add product to the cart")
    public void findPrintedDress() {
        assertTrue(cartPageNew.printedDressDisplayed(), "product is not found");
    }

    @Test (priority = 0, description = "Find 2d Printed Dress product") //passed
    @Severity(SeverityLevel.NORMAL)
    @Description("Find 2d Printed Dress product")
    @Story("Add product to the cart")
    public void findPrintedDressTwo() {
        assertTrue(cartPageNew.printedDressTwoDisplayed(), "product is not found");
    }

    @Test (priority = 0, description = "Find Summer Dress product") //passed
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Find Summer Dress product")
    @Story("Add product to the cart")
    public void findPrintedSummerDress() {
        assertTrue(cartPageNew.printedSummerDressDisplayed(), "product is not found");
    }

    @Test (priority = 0, description = "Find 2d Summer Dress product") //passed
    @Severity(SeverityLevel.NORMAL)
    @Description("Find 2d Summer Dress product")
    @Story("Add product to the cart")
    public void findPrintedSummerDressTwo() {
        assertTrue(cartPageNew.printedSummerDressTwoDisplayed(), "product is not found");
    }

    @Test (priority = 0, description = "Find Chiffon Dress product") //passed
    @Severity(SeverityLevel.NORMAL)
    @Description("Find Chiffon Dress product")
    @Story("Add product to the cart")
    public void findPrintedChiffonDress() {
        assertTrue(cartPageNew.printedChiffonDressDisplayed(), "product is not found");
    }

    @Test (priority = 0, description = "add to cart product from Plp") //passed
    @Severity(SeverityLevel.NORMAL)
    @Description("add to cart product from Plp")
    @Story("Add product to the cart")
    public void addToCartProductFromPlp() {
        Assert.assertEquals(businessLogic.addToCartProductFromPlp(), cartPageNew.ADD_TO_CART_MODAL);
    }

    @Test (priority = 0, description = "add to cart product from Pdp") //passed
    @Severity(SeverityLevel.NORMAL)
    @Description("add to cart product from Pdp")
    @Story("Add product to the cart")
    public void addToCartFromPdp() throws InterruptedException {
        Assert.assertEquals(businessLogic.addToCartFromPdp(), cartPageNew.ADD_TO_CART_MODAL);
    }

    @Test (priority = 0, description = "add to cart several items of product from Pdp") //failed
    @Severity(SeverityLevel.NORMAL)
    @Description("add to cart 6 items of product from Pdp")
    @Story("Add product to the cart")
    public void addToCartFromPdpSix() {
        Assert.assertEquals(businessLogic.addToCartFromPdpSix(), cartPageNew.THERE_ARE_IN_THE_CART);
    }

    @Test (priority = 0, description = "price of 2 products") //failed
    @Severity(SeverityLevel.CRITICAL)
    @Description("2 same products added to the cart")
    @Story("Add product to the cart")
    public void priceTwoProducts() {
        Assert.assertEquals(businessLogic.priceTwoProducts() * quantity,
                cartPageNew.textToDigitsTotalAddedProductModal());
    }

    @Test (priority = 0, description = "total price of 2 different products") //The bug: "Continue Shopping" button does not work
    @Severity(SeverityLevel.CRITICAL)
    @Description("2 different products added to the cart")
    @Story("Add product to the cart")
    public void priceTwoDifferentProducts() {
        Assert.assertEquals(businessLogic.priceTwoDifferentProducts(),
                cartPageNew.textToDigitsTotalAddedProductModal());
    }

    @Test (priority = 0, description = "total price of 2 different products another place") //failed
    @Severity(SeverityLevel.BLOCKER)
    @Description("total price of 2 different products on the pop-up")
    @Story("Add product to the cart")
    public void priceTwoDifferentProductsTwo() {
        Assert.assertEquals(businessLogic.priceTwoDifferentProductsTwo(),
                (double)Float.parseFloat(new DecimalFormat("0.00").
                format(cartPageNew.textToDigitsTotalProductsAddedAddedToCartModal()))); //actual, expected
    }

    @Test (priority = 0, description = "empty cart") //failed
    @Severity(SeverityLevel.NORMAL)
    @Description("delete one product from the cart")
    @Story("Add product to the cart")
    public void makeCartEmpty() {
        assertTrue(businessLogic.makeCartEmpty());
    }

    @Test (priority = 0, description = "") //failed
    @Severity(SeverityLevel.NORMAL)
    @Description("delete all products from the cart")
    @Story("Add product to the cart")
    public void makeCartEmptySeveralProducts() {
        assertTrue(businessLogic.makeCartEmptySeveralProducts());
    }
}

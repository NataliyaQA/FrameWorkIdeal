package com.automationpractice;

import businessLogic.BusinessLogic;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.objects.rewritten.MyAccountPageNew;
import pageObjects.objects.rewritten.MyOrdersPageNew;
import pageObjects.objects.rewritten.SignInPageNew;
import wrapperMethods.GeneralSeleniumMethods;

// 15 tests
public class MyOrdersPageWithoutOrdersTestNew extends BaseTestAbstractClass {
    //String pageMyOrdersUrl = "http://automationpractice.com/index.php?controller=history";
    MyOrdersPageNew myOrdersPage = new MyOrdersPageNew(driver);
    MyAccountPageNew myAccountPage = new MyAccountPageNew(driver);
    GeneralSeleniumMethods generalSeleniumMethods = new GeneralSeleniumMethods(driver);
    SignInPageNew signInPageNew = new SignInPageNew(driver);
    BusinessLogic businessLogic = new BusinessLogic(driver);

    @BeforeMethod
    void setUpMethod(){
        businessLogic.loginUser();
        myAccountPage.orderHistoryClick();
    }

//    @AfterMethod
//    void signOut() {
//        myAccountPage.signOutButtonClick();
//    }

    @Test //passed
    public void orderHistoryNavigationOne() {
        Assert.assertEquals(myOrdersPage.orderHistoryNavigationOne(), myOrdersPage.ORDER_HISTORY_NAVIGATION_PAGE_ONE);
    }

    @Test
    public void orderHistoryNavigationTwo() throws InterruptedException {
        Assert.assertEquals(myOrdersPage.orderHistoryNavigationTwo(), myOrdersPage.ORDER_HISTORY_NAVIGATION_PAGE_TWO);
    }

    @Test
    public void orderHistoryTitle() {
        Assert.assertEquals(myOrdersPage.orderHistoryTitle(), myOrdersPage.ORDER_HISTORY);
    }

    @Test
    public void orderHistoryText() {
        Assert.assertEquals(myOrdersPage.orderHistoryText(), myOrdersPage.ORDER_HISTORY_TEXT);
    }

    @Test
    public void orderHistoryNoOrdersText() {
        Assert.assertEquals(myOrdersPage.orderHistoryNoOrders(), myOrdersPage.ORDER_HISTORY_NO_ORDERS);
    }

    @Test // re-write xPath in method
    public void orderHistoryBackToAccountButtonName() {
        Assert.assertEquals(myOrdersPage.orderHistoryBackToAccountButton(), myOrdersPage.ORDER_HISTORY_BACK_TO_ACCOUNT);
    }

    @Test
    public void orderHistoryHomeButtonName() {
        Assert.assertEquals(myOrdersPage.orderHistoryHomeButton(), myOrdersPage.ORDER_HISTORY_HOME_BUTTON);
    }

    @Test
    public void iconHomeIsDisplayed() {
        Assert.assertTrue(myOrdersPage.iconHomeIsDisplayed());
    }

    @Test
    public void navigationOneIsDisplayed() {
        Assert.assertTrue(myOrdersPage.navigationOneIsDisplayed());
    }

    @Test
    public void navigationTwoIsDisplayed() {
        Assert.assertTrue(myOrdersPage.navigationTwoIsDisplayed());
    }

    @Test
    public void homeNavigationBreadcrumb() {
        myOrdersPage.clickHomeIcon();
        Assert.assertEquals(generalSeleniumMethods.getUrl(), myOrdersPage.HOME_PAGE_URL);
    }

    @Test
    public void homeNavigationButton() {
        myOrdersPage.clickHomeButton();
        Assert.assertEquals(generalSeleniumMethods.getUrl(), myOrdersPage.HOME_PAGE_URL);
    }

    @Test
    public void myAccountNavigationBreadcrumb() {
       myOrdersPage.clickNavigationOne();
       Assert.assertEquals(generalSeleniumMethods.getUrl(), myOrdersPage.ACCOUNT_URL);
    }

    @Test
    public void myAccountNavigationButton() {
       myOrdersPage.clickBackToAccount();
       Assert.assertEquals(generalSeleniumMethods.getUrl(), myOrdersPage.ACCOUNT_URL);
    }


}

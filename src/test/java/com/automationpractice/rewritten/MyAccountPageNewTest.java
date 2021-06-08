package com.automationpractice.rewritten;

import businessLogic.BusinessLogic;
import com.automationpractice.BaseTestAbstractClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.objects.rewritten.MyAccountPageNew;
import wrapperMethods.GeneralSeleniumMethods;


// 22 tests
public class MyAccountPageNewTest extends BaseTestAbstractClass {
    //String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    MyAccountPageNew myAccountPage = new MyAccountPageNew(driver);
    GeneralSeleniumMethods generalSeleniumMethods = new GeneralSeleniumMethods(driver);
    BusinessLogic businessLogic = new BusinessLogic(driver);

    @BeforeMethod
    void setUpMethod(){
        businessLogic.loginUser();
    }

//    @AfterMethod
//    void signOut() {
//        businessLogic.signOutUser();
//    }

    @Test //passed
    public void myAccountTitleDisplayed() {
        Assert.assertTrue(myAccountPage.myAccountTitleDisplayed());
    }

    @Test// passed
    public void welcomeTextDisplayed() {
        Assert.assertTrue(myAccountPage.welcomeTextDisplayed());
    }

    @Test //passed
    public void orderHistoryDisplayed() {
        Assert.assertTrue(myAccountPage.orderHistoryDisplayed());
    }

    @Test //passed
    public void creditSlipsDisplayed() {
        Assert.assertTrue(myAccountPage.creditSlipsDisplayed());
    }

    @Test //passed
    public void myAddressDisplayed() {
        Assert.assertTrue(myAccountPage.myAddressDisplayed());
    }

    @Test //passed
    public void personalInfoDisplayed() {
        Assert.assertTrue(myAccountPage.personalInfoDisplayed());
    }

    @Test //passed
    public void wishListDisplayed() {
        Assert.assertTrue(myAccountPage.wishListDisplayed());
    }

    @Test //passed
    public void homeButtonDisplayed() {
        Assert.assertTrue(myAccountPage.homeButtonDisplayed());
    }

    @Test //passed
    public void myAccountTitle() {
        Assert.assertEquals(myAccountPage.myAccountTitleName(), myAccountPage.MY_ACCOUNT_TITLE);
    }

    @Test //passed
    public void welcomeText() {
        Assert.assertEquals(myAccountPage.welcomeTextName(), myAccountPage.WELCOME_TEXT);
    }

    @Test //passed
    public void homeButtonName() {
        Assert.assertEquals(myAccountPage.homeButtonName(), myAccountPage.HOME_BUTTON);
    }

    @Test //passed
    public void orderHistoryName() {
        Assert.assertEquals(myAccountPage.orderHistoryName().toLowerCase(), myAccountPage.ORDER_HISTORY);
    }

    @Test //passed
    public void creditSlipsName() {
        Assert.assertEquals(myAccountPage.creditSlipsName(), myAccountPage.CREDIT_SLIPS);
    }

    @Test //passed
    public void myAddressName() {
        Assert.assertEquals(myAccountPage.myAddressName(), myAccountPage.MY_ADDRESS);
    }

    @Test //passed
    public void personalInfoName() {
        Assert.assertEquals(myAccountPage.personalInfoName(), myAccountPage.PERSONAL_INFO);
    }

    @Test //passed
    public void wishListName() {
        Assert.assertEquals(myAccountPage.wishListName(), myAccountPage.WISH_LIST);
    }

    @Test //passed
    public void homePageUrl() {
        myAccountPage.homeButtonClick();
        //Assert.assertEquals(generalSeleniumMethods.getUrl(), myAccountPage.HOME_PAGE_URL);
    }

    @Test //passed
    public void orderHistoryUrl() {
        myAccountPage.orderHistoryClick();
        Assert.assertEquals(generalSeleniumMethods.getUrl(), myAccountPage.ORDER_HISTORY_URL);
    }

    @Test //passed
    public void creditSlipsUrl() {
        myAccountPage.creditSlipsClick();
        Assert.assertEquals(generalSeleniumMethods.getUrl(), myAccountPage.CREDIT_SLIPS_URL);
    }

    @Test //passed
    public void myAddressUrl() {
        myAccountPage.myAddressClick();
        Assert.assertEquals(generalSeleniumMethods.getUrl(), myAccountPage.MY_ADDRESS_URL);
    }

    @Test //passed
    public void personalInfoUrl() {
        myAccountPage.personalInfoClick();
        Assert.assertEquals(generalSeleniumMethods.getUrl(), myAccountPage.PERSONAL_INFO_URL);
    }

    @Test //passed
    public void wishListUrl() {
        myAccountPage.wishListClick();
        Assert.assertEquals(generalSeleniumMethods.getUrl(), myAccountPage.WISH_LIST_URL);
    }
}

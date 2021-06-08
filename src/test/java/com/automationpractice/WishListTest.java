package com.automationpractice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.objects.rewritten.SortByNew;
import pageObjects.objects.rewritten.WishListPageNew;
import pageObjects.objects.rewritten.MyAccountPageNew;

public class WishListTest extends BaseTestAbstractClass{
    String stringUrlWomenPage = "http://automationpractice.com/index.php?id_category=3&controller=category";
    SortByNew sortByNew = new SortByNew(driver);
    MyAccountPageNew myAccountPage = new MyAccountPageNew(driver);
    WishListPageNew wishListPageNew = new WishListPageNew(driver);

    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrlWomenPage);

        myAccountPage.signInButtonHeaderClick();
        myAccountPage.emailSendKey();
        myAccountPage.passwordSendKey();
        myAccountPage.signInButtonClick();
    }

    @AfterMethod
    void signOut() {
        myAccountPage.signOutButtonClick();
    }

    @Test //does not work correctly, returns all Strings with null
    //WishListObject{name='null', quantity=0, viewed=0, created='null', directLink='null', delete='null'}
    public void wishListPage() throws InterruptedException {
        myAccountPage.wishListClick();
        wishListPageNew.nameSendKeyOne();
        Thread.sleep(5000);
        wishListPageNew.saveButtonClick();

        wishListPageNew.getListOfAllElementsTableWishList();
    }
}


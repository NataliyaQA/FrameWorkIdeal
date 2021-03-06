package com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.objects.rewritten.SortByNew;
import pageObjects.objects.ProductObject;
import pageObjects.objects.rewritten.MyAccountPageNew;
import wrapperMethods.GeneralSeleniumMethods;

import java.util.Comparator;
import java.util.List;

public class SortByTest extends BaseTestAbstractClass {
    String stringUrlWomenPage = "http://automationpractice.com/index.php?id_category=3&controller=category";
    SortByNew sortByNew = new SortByNew(driver);
    MyAccountPageNew myAccountPage = new MyAccountPageNew(driver);
    GeneralSeleniumMethods generalSeleniumMethods = new GeneralSeleniumMethods(driver);

    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrlWomenPage);
    }

    @Test //passed
    public void viewGridIconIsEnabled() {
        Assert.assertTrue(sortByNew.viewGridIconIsEnabled());
    }

    @Test //failed
    public void viewListIconIsEnabled() {
        Assert.assertFalse(sortByNew.viewListIconIsEnabled());
    }

    @Test
    public void addToWishListOneWithoutLogin() {
        sortByNew.hoverFirstProduct();
        sortByNew.addToWishListOneClick();

        Assert.assertTrue(sortByNew.alertAddToWishListIsEnabled());
        Assert.assertEquals(sortByNew.alertTextWishList(), sortByNew.ALERT_ADD_TO_WISHLIST);
    }

    @Test //Question "no such element"? why isDisplayed does not work
    public void closeToWishListOneWithoutLogin() throws InterruptedException {
        sortByNew.hoverFirstProduct();
        sortByNew.addToWishListOneClick();

        sortByNew.closeAlertAddToWishListClick();
        Thread.sleep(5000);
        //Assert.assertFalse(sortBy.alertAddToWishListIsDisplayed());
        Assert.assertEquals(generalSeleniumMethods.getUrl(), stringUrlWomenPage);
    }

    @Test
    public void addToWishListOneWithLogin() throws InterruptedException {
        myAccountPage.signInButtonHeaderClick();
        myAccountPage.emailSendKey();
        myAccountPage.passwordSendKey();
        myAccountPage.signInButtonClick();
        Thread.sleep(5000);
        sortByNew.womenButtonClick();

        sortByNew.hoverFirstProduct();
        sortByNew.addToWishListOneClick();

        Assert.assertTrue(sortByNew.alertAddedToWishListIsEnabled());
        Assert.assertEquals(sortByNew.alertTextWishListAdded(), sortByNew.ALERT_ADDED_TO_WISHLIST);
    }

    @Test //Question "no such element"? why isDisplayed does not work
    public void closeToWishListOneWithLogin() throws InterruptedException {
        myAccountPage.signInButtonHeaderClick();
        myAccountPage.emailSendKey();
        myAccountPage.passwordSendKey();
        myAccountPage.signInButtonClick();
        Thread.sleep(5000);
        sortByNew.womenButtonClick();

        sortByNew.hoverFirstProduct();
        sortByNew.addToWishListOneClick();

        sortByNew.closeAlertAddToWishListClick();
        Thread.sleep(5000);
        //Assert.assertFalse(sortBy.alertAddToWishListIsDisplayed());
        Assert.assertEquals(generalSeleniumMethods.getUrl(), stringUrlWomenPage);
    }

    @Test // does not work correctly, failed (real bug), but shows error as:
//    java.lang.AssertionError: Lists differ at element [0]: Faded Short Sleeve T-shirts != Faded Short Sleeve T-shirts
//    Expected :Faded Short Sleeve T-shirts
//    Actual   :Faded Short Sleeve T-shirts
    public void sortProductsNames() throws InterruptedException {
        List<ProductObject> expected = sortByNew.getListOfAllElementsWomenPageInitial();
        sortByNew.selectValueDropDownNameAZ();

        Thread.sleep(5000);
        //Wrapper.getFindFluentWait();

        //expected.sort();
        //expected.stream().sorted(Comparator.comparing(ProductObject::getNameOfProduct)).forEach(System.out::println);

        List<ProductObject> actual = sortByNew.getListOfAllElementsWomenPageSecond();

        int getFirstProduct = 0;
        Assert.assertEquals(actual.get(getFirstProduct)
                .getNameOfProduct(), expected.stream()
                .sorted(Comparator.comparing(ProductObject::getNameOfProduct)));
    }

//   @Test // test is executed only if one of the @Override of "Product" class is commented.
//    // There are one for "nameOfProduct" and one for "price"
//    public void sortProductsPrices() throws InterruptedException {
//        List<ProductObject> products = new ArrayList<>();
//        //for (int i=0; i<=texts.length(); i++) //{text.get(i)}
//        for (ProductObject takeTextOfEach : sortBy.getListOfAllElementsWomenPagePrice()) {
//            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
//            String getPriceString = separateItems.get(1);
//
//            float price = Float.parseFloat(getPriceString
//                    .replace("$", "")
//                    .replace("30.51 -5%", "")
//                    .replace("20.50 -20%", ""));
//
//            products.add(new ProductObject(price));
//        }
//        products.stream().sorted(Comparator.comparing(ProductObject::getPrice))
//                .forEach(System.out::println);
//
//        sortBy.selectValueDropDownPriceLowest();
//        Thread.sleep(5000);
//
//        List<ProductObject> products2 = new ArrayList<>();
//        for (ProductObject takeTextOfEach : sortBy.getListOfAllElementsWomenPagePrice()) {
//            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
//            String getPriceString = separateItems.get(1);
//
//            float price = Float.parseFloat(getPriceString
//                    .replace("$", "")
//                    .replace("30.51 -5%", "")
//                    .replace("20.50 -20%", ""));
//
//            products2.add(new ProductObject(price));
//        }
//        System.out.println("**********");
//        products2.stream().forEach(System.out::println);
//        Assert.assertEquals(products, products2);
//    }
}


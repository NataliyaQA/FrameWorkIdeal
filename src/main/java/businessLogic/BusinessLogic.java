package businessLogic;

import org.openqa.selenium.WebDriver;
import pageObjects.objects.rewritten.CartPageNew;
import pageObjects.objects.rewritten.HomePageNew;
import pageObjects.objects.rewritten.MyAccountPageNew;

import java.text.DecimalFormat;

//extends GeneralSeleniumMethods
public class BusinessLogic {
    public WebDriver driver;
    HomePageNew homePageNew;
    MyAccountPageNew myAccountPage;
    CartPageNew cartPageNew;
    String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public BusinessLogic(WebDriver driver) {
        homePageNew = new HomePageNew(driver);
        myAccountPage = new MyAccountPageNew(driver);
        cartPageNew = new CartPageNew(driver);
        this.driver = driver;
    }

    public void loginUser() {
        driver.get(stringUrl);

        homePageNew.emailSendKey();
        homePageNew.passwordSendKey();
        homePageNew.signInButtonClick();
    }

    public void signOutUser() {
        loginUser();
        myAccountPage.signOutButtonClick();
    }

    public String addToCartProductFromPlp() {
        cartPageNew.hoverFadedShortSleeve();
        cartPageNew.clickAddToCartFirstProduct();
        return cartPageNew.alertTextAddedToCartModal();
    }

    public String addToCartFromPdp() {
        cartPageNew.clickProductOne();
        cartPageNew.clickAddToCartFromPdp();
        return cartPageNew.alertTextAddedToCartModal();
    }

    public String addToCartFromPdpSix() {
        cartPageNew.clickProductOne();
        cartPageNew.clickPlusFive();
        cartPageNew.clickAddToCartFromPdp();
        return cartPageNew.alertTextThereAreInTheCart();
    }

    public float priceTwoProducts() {
        cartPageNew.clickProductOne();
        cartPageNew.clickPlus();
        cartPageNew.clickAddToCartFromPdp();
        return cartPageNew.textToDigitsPrice();
    }

    public float priceTwoDifferentProducts() {
        cartPageNew.clickProductOne();
        float firstPrice = cartPageNew.textToDigitsPrice();
        cartPageNew.clickAddToCartFromPdp();
        cartPageNew.clickContinueShopping();
        cartPageNew.clickProductTwo();
        float secondPrice = cartPageNew.textToDigitsPrice();
        cartPageNew.clickAddToCartFromPdp();
        return ((firstPrice * 2) + (secondPrice * 2));
    }

    public float priceTwoDifferentProductsTwo() {
        cartPageNew.clickProductOne();
        cartPageNew.clickPlus();
        float firstPrice = cartPageNew.textToDigitsPrice();
        cartPageNew.clickAddToCartFromPdp();
        cartPageNew.clickCrossIcon();
        cartPageNew.clickLogo();
        cartPageNew.clickProductTwo();
        cartPageNew.clickPlus();
        float secondPrice = cartPageNew.textToDigitsPrice();
        cartPageNew.clickAddToCartFromPdp();
        return (Float.parseFloat(new DecimalFormat("0.00").
                format((firstPrice * 2) + (secondPrice * 2))));
    }

    public boolean makeCartEmpty() {
        cartPageNew.clickProductOne();
        cartPageNew.clickAddToCartFromPdp();
        cartPageNew.clickCrossIcon();
        cartPageNew.hoverCartDropDown();
        cartPageNew.clickCrossIconCart();
        return cartPageNew.cartEmptyDisplayed();
    }

    public boolean makeCartEmptySeveralProducts() {
        cartPageNew.hoverFadedShortSleeve();
        cartPageNew.clickAddToCartFirstProduct();
        cartPageNew.clickCrossIcon();
        cartPageNew.hoverPrintedDress();
        cartPageNew.clickAddToCartThirdProduct();
        cartPageNew.clickCrossIcon();
        cartPageNew.hoverCartDropDown();
        cartPageNew.clickCrossIconCart();
        cartPageNew.clickCrossIconCart();
        return cartPageNew.cartEmptyDisplayed();
    }
}

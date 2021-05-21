package pageObjects;

import org.openqa.selenium.WebDriver;
import utils.MainMethods;

public class MyAccountPage {
    public WebDriver driver;
    MainMethods mainMethods;

    public static final String MY_ACCOUNT_TITLE = "MY ACCOUNT";
    public static final String WELCOME_TEXT = "Welcome to your account. Here you can manage all of your personal " +
            "information and orders.";
    public static final String HOME_BUTTON = "Home";
    public static final String ORDER_HISTORY = "order history and details";
    public static final String CREDIT_SLIPS = "MY CREDIT SLIPS";
    public static final String MY_ADDRESS = "MY ADDRESSES";
    public static final String PERSONAL_INFO = "MY PERSONAL INFORMATION";
    public static final String WISH_LIST = "MY WISHLISTS";


    public static final String HOME_PAGE_URL = "http://automationpractice.com/index.php";
    public static final String ORDER_HISTORY_URL = "http://automationpractice.com/index.php?controller=history";
    public static final String CREDIT_SLIPS_URL = "http://automationpractice.com/index.php?controller=order-slip";
    public static final String MY_ADDRESS_URL = "http://automationpractice.com/index.php?controller=addresses";
    public static final String PERSONAL_INFO_URL = "http://automationpractice.com/index.php?controller=identity";
    public static final String WISH_LIST_URL = "http://automationpractice.com/index.php?fc=module&module=blockwish" +
            "list&controller=mywishlist";

    public static final String NAME = "TestName";
    public static final String SURNAME = "TestName";
    public static final String EMAIL = "qwe+3@gmail.com";
    public static final String PASSWORD = "123456";

    //Constructor
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * moved to MainMethods
     * @param
     * @return
     */
    //General
    //public String getName(String xPath) {
//        return driver.findElement(By.xpath(xPath)).getText();
//    }

    public String myAccountTitleName() {
        return mainMethods.getText("//h1[@class='page-heading']");
    }

    public String welcomeTextName() {
        return mainMethods.getText("//p[contains(text(),'Welcome')]");
    }

    public String orderHistoryName() {
        return mainMethods.getText("//span[text()='Order history and details']");
    }

    public String creditSlipsName() {
        return mainMethods.getText("//span[text()='My credit slips']");
    }

    public String myAddressName() {
        return mainMethods.getText("//span[text()='My addresses']");
    }

    public String personalInfoName() {
        return mainMethods.getText("//span[text()='My personal information']");
    }

    public String wishListName() {
        return mainMethods.getText("//span[text()='My wishlists']");
    }

    public String homeButtonName() {
        return mainMethods.getText("//a[@title='Home']");
    }

    /**
     * moved to MainMethods
     * @return
     */
    //General is displayed
//    public boolean isDisplayed(String xPath) {
//        return driver.findElement(By.xpath(xPath)).isDisplayed() ? true : false;
//    }

    public boolean myAccountTitleDisplayed() {
        return mainMethods.isDisplayed("//h1[text()='My account']");
    }

    public boolean welcomeTextDisplayed() {
        return mainMethods.isDisplayed("//p[contains(text(),'Welcome')]");
    }

    public boolean orderHistoryDisplayed() {
        return mainMethods.isDisplayed("//i[@class='icon-list-ol']");
    }

    public boolean creditSlipsDisplayed() {
        return mainMethods.isDisplayed("//i[@class='icon-ban-circle']");
    }

    public boolean myAddressDisplayed() {
        return mainMethods.isDisplayed("//i[@class='icon-building']");
    }

    public boolean personalInfoDisplayed() {
        return mainMethods.isDisplayed("//i[@class='icon-user']");
    }

    public boolean wishListDisplayed() {
        return mainMethods.isDisplayed("//i[@class='icon-heart']");
    }

    public boolean homeButtonDisplayed() {
        return mainMethods.isDisplayed("//a[@title='Home']");
    }

    /**
     * moved to MainMethods
     * @return
     */
    //General get URL
//    public String getUrl() {
//        return driver.getCurrentUrl();
//    }

    /**
     * moved to MainMethods
     * @param
     */
    //General click
//    public void clickElement(String xPath) {
//        driver.findElement(By.xpath(xPath)).click();
//    }

    public void orderHistoryClick() {
        mainMethods.clickElement("//i[@class='icon-list-ol']");
    }

    public void creditSlipsClick() {
        mainMethods.clickElement("//i[@class='icon-ban-circle']");
    }

    public void myAddressClick() {
        mainMethods.clickElement("//span[text()='My addresses']");
    }

    public void personalInfoClick() {
        mainMethods.clickElement("//i[@class='icon-user']");
    }

    public void wishListClick() {
        mainMethods.clickElement("//i[@class='icon-heart']");
    }

    public void homeButtonClick() {
        mainMethods.clickElement("//a[@title='Home']");
    }

    public void signInButtonClick() {
        mainMethods.clickElement("//button[@id='SubmitLogin']");
    }

    public void signInButtonHeaderClick() {
        mainMethods.clickElement("//a[@class='login']");
    }
    public void signOutButtonClick() {
        mainMethods.clickElement("//a[@class='logout']");
    }

    /**
     * moved to MainMethods
     * @param
     * @param
     */
    //General sendKey
//    public void sendKey(String xPath, String value) {
//        driver.findElement(By.xpath(xPath)).sendKeys(value);
//    }

    public void emailSendKey() {
        mainMethods.sendKey("//input[@id='email']", EMAIL);
    }

    public void passwordSendKey() {
        mainMethods.sendKey("//input[@id='passwd']", PASSWORD);
    }
}

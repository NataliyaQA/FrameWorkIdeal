package pageObjects;

import org.openqa.selenium.WebDriver;
import utils.MainMethods;

public class MyOrdersPage{
    public WebDriver driver;
    MainMethods mainMethods;

    public static final String ORDER_HISTORY = "ORDER HISTORY";
    public static final String ORDER_HISTORY_TEXT = "Here are the orders you've placed since your account was created.";
    public static final String ORDER_HISTORY_NO_ORDERS = "You have not placed any orders.";
    public static final String ORDER_HISTORY_BACK_TO_ACCOUNT = "Back to your account.";
    public static final String ORDER_HISTORY_HOME_BUTTON = "Home";
    public static final String ORDER_HISTORY_NAVIGATION_PAGE_ONE = "My account";
    public static final String ORDER_HISTORY_NAVIGATION_PAGE_TWO = "Order history";
    public static final String ACCOUNT_URL = "http://automationpractice.com/index.php?controller=my-account";
    public static final String HOME_PAGE_URL = "http://automationpractice.com/index.php";

    //Constructor
    public MyOrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * moved to MainMethods
     * @return
     */
    //General
//    public String getName(String xPath) {
//        return driver.findElement(By.xpath(xPath)).getText();
//    }

    public String orderHistoryNavigationOne() {
        return mainMethods.getText("//div[@class='breadcrumb clearfix']/a[2]");
    }

    public String orderHistoryNavigationTwo() {
        return mainMethods.getText("//span[text()='Order history']");
    }
    public String orderHistoryTitle() {
        return mainMethods.getText("//h1[contains(@class,'page')]");
    }

    public String orderHistoryText() {
        return mainMethods.getText("//p[contains(@class,'info-title')]");
    }
    public String orderHistoryNoOrders() {
        return mainMethods.getText("//p[contains(@class,'alert alert-warning')]");
    }

    public String orderHistoryBackToAccountButton() {
        return mainMethods.getText("//*[@id='center_column']/ul/li[1]/a/span"); //re-write
    }

    public String orderHistoryHomeButton() {
        return mainMethods.getText("//*[text()=' Home']");
    }

    /**
     * moved to MainMethods
     * @param
     * @return
     */
    //General isDisplayed
//    public boolean isDisplayed(String xPath) {
//        return driver.findElement(By.xpath(xPath)).isDisplayed();
//    }

    public boolean iconHomeIsDisplayed() {
       return mainMethods.isDisplayed("//i[@class='icon-home']");
    }

    public boolean navigationOneIsDisplayed() {
        return mainMethods.isDisplayed("//div[@class='breadcrumb clearfix']/a[2]");
    }

    public boolean navigationTwoIsDisplayed() {
        return mainMethods.isDisplayed("//span[@class='navigation_page']");
    }

    /**
     * moved to MainMethods
     * @param
     */
    //General click
//    public void clickAction(String xPath) {
//        driver.findElement(By.xpath(xPath)).click();
//    }

    public void clickHomeIcon() {
        mainMethods.clickElement("//i[@class='icon-home']");
    }

    public void clickNavigationOne() {
        mainMethods.clickElement("//div[@class='breadcrumb clearfix']/a[2]");
    }

    public void clickBackToAccount() {
        mainMethods.clickElement("//a[contains(@href,'my-account')]/span/i"); //re-write
    }

    public void clickHomeButton() {
        mainMethods.clickElement("//*[@id='center_column']/ul/li[2]/a/span"); //re-write
    }
}

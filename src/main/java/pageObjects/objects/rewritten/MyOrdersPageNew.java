package pageObjects.objects.rewritten;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wrapperMethods.GeneralSeleniumMethods;

public class MyOrdersPageNew {
    public WebDriver driver;
    GeneralSeleniumMethods generalSeleniumMethods = new GeneralSeleniumMethods(driver);

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
    public MyOrdersPageNew(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //orderHistoryNavigationOne
    @FindBy(xpath = "//div[@class='breadcrumb clearfix']/a[2]")
    private WebElement orderHistoryNavigationOne;

    public String orderHistoryNavigationOne() {
        return generalSeleniumMethods.getText(orderHistoryNavigationOne);
    }

    //orderHistoryNavigationTwo
    @FindBy(xpath = "//span[text()='Order history']")
    private WebElement orderHistoryNavigationTwo;

    public String orderHistoryNavigationTwo() {
        return generalSeleniumMethods.getText(orderHistoryNavigationTwo);
    }

    //orderHistoryTitle
    @FindBy(xpath = "//h1[contains(@class,'page')]")
    private WebElement orderHistoryTitle;

    public String orderHistoryTitle() {
        return generalSeleniumMethods.getText(orderHistoryTitle);
    }

    //orderHistoryText
    @FindBy(xpath = "//p[contains(@class,'info-title')]")
    private WebElement orderHistoryText;

    public String orderHistoryText() {
        return generalSeleniumMethods.getText(orderHistoryText);
    }

    //orderHistoryNoOrders
    @FindBy(xpath = "//p[contains(@class,'alert alert-warning')]")
    private WebElement orderHistoryNoOrders;

    public String orderHistoryNoOrders() {
        return generalSeleniumMethods.getText(orderHistoryNoOrders);
    }

    //orderHistoryBackToAccountButton
    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/a/span")
    private WebElement orderHistoryBackToAccountButton;

    public String orderHistoryBackToAccountButton() {
        return generalSeleniumMethods.getText(orderHistoryBackToAccountButton);
    }

    //homeButton
    @FindBy(xpath = "//*[text()=' Home']")
    private WebElement homeButton;

    public String orderHistoryHomeButton() {
        return generalSeleniumMethods.getText(homeButton);
    }

    //iconHome
    @FindBy(xpath = "//i[@class='icon-home']")
    private WebElement iconHome;

    public boolean iconHomeIsDisplayed() {
       return generalSeleniumMethods.isDisplayed(iconHome);
    }

    //navigationOne
    @FindBy(xpath = "//div[@class='breadcrumb clearfix']/a[2]")
    private WebElement navigationOne;

    public boolean navigationOneIsDisplayed() {
        return generalSeleniumMethods.isDisplayed(navigationOne);
    }

    //navigationTwo
    @FindBy(xpath = "//span[@class='navigation_page']")
    private WebElement navigationTwo;

    public boolean navigationTwoIsDisplayed() {
        return generalSeleniumMethods.isDisplayed(navigationTwo);
    }

    public void clickHomeIcon() {
        generalSeleniumMethods.clickElement(iconHome);
    }

    public void clickNavigationOne() {
        generalSeleniumMethods.clickElement(navigationOne);
    }

    //backToAccount
    @FindBy(xpath = "//a[contains(@href,'my-account')]/span/i")
    private WebElement backToAccount;

    public void clickBackToAccount() {
        generalSeleniumMethods.clickElement(backToAccount);
    }

    public void clickHomeButton() {
        generalSeleniumMethods.clickElement(homeButton);
    }
}

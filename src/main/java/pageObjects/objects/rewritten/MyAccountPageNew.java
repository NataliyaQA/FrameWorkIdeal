package pageObjects.objects.rewritten;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import wrapperMethods.GeneralSeleniumMethods;

import static pageObjects.objects.rewritten.HomePageNew.EMAIL;
import static pageObjects.objects.rewritten.HomePageNew.PASSWORD;

public class MyAccountPageNew {
    public WebDriver driver;
    GeneralSeleniumMethods generalSeleniumMethods;
    HomePageNew homePageNew;

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

    //Constructor
    public MyAccountPageNew(WebDriver driver) {
        this.driver = driver;
         generalSeleniumMethods = new GeneralSeleniumMethods(driver);
         homePageNew = new HomePageNew(driver);
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this); //Question: why we need it? Should it be here or in MainMethods.java?
        // Is it the same to "NameClass nameClass = new NameClass();" ?

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,100); //Question:
        // how methods will know about this lazy loading concept? Should I write it anywhere more?
        PageFactory.initElements(factory, this);
    }

    // myAccount
    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement myAccount;

    public String myAccountTitleName() {
        return generalSeleniumMethods.getText(myAccount);
    }

    // welcomeText
    @FindBy(xpath = "//p[contains(text(),'Welcome')]")
    private WebElement welcomeText;

    public String welcomeTextName() {
        return generalSeleniumMethods.getText(welcomeText);
    }

    // orderHistoryPanelText
    @FindBy(xpath = "//span[text()='Order history and details']")
    private WebElement orderHistoryPanelText;

    public String orderHistoryName() {
        return generalSeleniumMethods.getText(orderHistoryPanelText);
    }

    // creditSlipsPanelText
    @FindBy(xpath = "//span[text()='My credit slips']")
    private WebElement creditSlipsPanelText;

    public String creditSlipsName() {
        return generalSeleniumMethods.getText(creditSlipsPanelText);
    }

    // myAddressPanelText
    @FindBy(xpath = "//span[text()='My addresses']")
    private WebElement myAddressPanelText;

    public String myAddressName() {
        return generalSeleniumMethods.getText(myAddressPanelText);
    }

    // personalInfoPanelText
    @FindBy(xpath = "//span[text()='My personal information']")
    private WebElement personalInfoPanelText;

    public String personalInfoName() {
        return generalSeleniumMethods.getText(personalInfoPanelText);
    }

    // wishListPanelText
    @FindBy(xpath = "//span[text()='My wishlists']")
    private WebElement wishListPanelText;

    public String wishListName() {
        return generalSeleniumMethods.getText(wishListPanelText);
    }

    // homeButton
    @FindBy(xpath = "//a[@title='Home']")
    private WebElement homeButton;

    public String homeButtonName() {
        return generalSeleniumMethods.getText(homeButton);
    }

    // myAccountTitleDisplayed
    public boolean myAccountTitleDisplayed() {
        return generalSeleniumMethods.isDisplayed(myAccount);
    }

    // welcomeTextDisplayed
    public boolean welcomeTextDisplayed() {
        return generalSeleniumMethods.isDisplayed(welcomeText);
    }

    // orderHistoryIcon
    @FindBy(xpath = "//i[@class='icon-list-ol']")
    private WebElement orderHistoryIcon;

    public boolean orderHistoryDisplayed() {
        return generalSeleniumMethods.isDisplayed(orderHistoryIcon);
    }

    // creditSlipsIcon
    @FindBy(xpath = "//i[@class='icon-ban-circle']")
    private WebElement creditSlipsIcon;

    public boolean creditSlipsDisplayed() {
        return generalSeleniumMethods.isDisplayed(creditSlipsIcon);
    }

    // myAddressIcon
    @FindBy(xpath = "//i[@class='icon-building']")
    private WebElement myAddressIcon;

    public boolean myAddressDisplayed() {
        return generalSeleniumMethods.isDisplayed(myAddressIcon);
    }

    // personalInfoIcon
    @FindBy(xpath = "//i[@class='icon-user']")
    private WebElement personalInfoIcon;

    public boolean personalInfoDisplayed() {
        return generalSeleniumMethods.isDisplayed(personalInfoIcon);
    }

    // wishListIcon
    @FindBy(xpath = "//i[@class='icon-heart']")
    private WebElement wishListIcon;

    public boolean wishListDisplayed() {
        return generalSeleniumMethods.isDisplayed(wishListIcon);
    }

    public boolean homeButtonDisplayed() {
        return generalSeleniumMethods.isDisplayed(homeButton);
    }

    public void orderHistoryClick() {
        generalSeleniumMethods.clickElement(orderHistoryIcon);
    }

    public void creditSlipsClick() {
        generalSeleniumMethods.clickElement(creditSlipsIcon);
    }

    public void myAddressClick() {
        generalSeleniumMethods.clickElement(myAddressIcon);
    }

    public void personalInfoClick() {
        generalSeleniumMethods.clickElement(personalInfoIcon);
    }

    public void wishListClick() {
        generalSeleniumMethods.clickElement(wishListIcon);
    }

    public void homeButtonClick() {
        generalSeleniumMethods.clickElement(homeButton);
    }

    // signOutButtonHeader
    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOutButtonHeader;

    public void signOutButtonClick() {
        generalSeleniumMethods.clickElement(signOutButtonHeader);
    }

    // signInButton
    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInButton;

    public void signInButtonClick() {
        generalSeleniumMethods.clickElement(signInButton);
    }

    // signInButtonHeader
    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButtonHeader;

    public void signInButtonHeaderClick() {
        generalSeleniumMethods.clickElement(signInButtonHeader);
    }

    // emailField
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    public void emailSendKey() {
        generalSeleniumMethods.sendKey(emailField, EMAIL);
    }

    // passwordField
    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    public void passwordSendKey() {
        generalSeleniumMethods.sendKey(passwordField, PASSWORD);
    }

}

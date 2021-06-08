package pageObjects.objects.rewritten;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wrapperMethods.GeneralSeleniumMethods;

public class SearchHomePageElementsNew {
    public WebDriver driver;
    GeneralSeleniumMethods generalSeleniumMethods = new GeneralSeleniumMethods(driver);

    public final String WOMEN_NAME = "WOMEN";
    public final String WOMEN_MENU_TOPS_SUBMENU_NAME = "TOPS";
    public final String WOMEN_MENU_TSHIRS_OPTION_NAME = "T-shirts";
    public final String WOMEN_MENU_BLOUSES_OPTION_NAME = "Blouses";
    public final String WOMEN_MENU_DRESSES_SUBMENU_NAME = "DRESSES";
    public final String CASUAL_DRESSES_OPTION_NAME = "Casual Dresses";
    public final String EVENING_DRESSES_OPTION_NAME = "Evening Dresses";
    public final String SUMMER_DRESSES_OPTION_NAME = "Summer Dresses";
    public final String DRESSES_NAME = "DRESSES";
    public final String TSHIRTS_NAME = "T-SHIRTS";
    public final String HOME_PAGE_TITLE = "My Store";
    public final String WOMEN_PAGE_TITLE = "Women - My Store";

    String stringUrl = "http://automationpractice.com/index.php?id_cms=4&controller=cms";

    public SearchHomePageElementsNew(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //searchQueryTop
    @FindBy(xpath = "//input[contains(@class,'search')]")
    private WebElement searchQueryTop;

    //searchButton
    @FindBy(xpath = "//input[contains(@class,'search')]" +
            "/ancestor::div[@class='container']//button")
    private WebElement searchButton;

    //cartButton
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement cartButton;

    //contactUsButton
    @FindBy(xpath = "//a[@title='Contact Us']")
    private WebElement contactUsButton;

    //signInButton
    @FindBy(xpath = "//a[contains(@title,'Log in')]")
    private WebElement signInButton;

    //logoButton
    @FindBy(xpath = "//img[contains(@class,'logo')]")
    private WebElement logoButton;

    //popularButton
    @FindBy(xpath = "//a[contains(@class,'homefeatured')]")
    private WebElement popularButton;

    //bestSellersButton
    @FindBy(xpath = "//a[contains(@class,'blockbestsellers')]")
    private WebElement bestSellersButton;

    //womenMenu
    @FindBy(xpath = "//a[@title='Women']/parent::li")
    private WebElement womenMenu;

    //womenMenuTopsSubMenu
    @FindBy(xpath = "//a[@title='Women']/following::a[@title='Tops']")
    private WebElement womenMenuTopsSubMenu;

    //womenMenuSubMenuTopsTshirtsOption
    @FindBy(xpath = "//ul[contains(@class,'submenu')]/li//a[@title='T-shirts']")
    private WebElement womenMenuSubMenuTopsTshirtsOption;

    //womenMenuSubMenuTopsBlousesOption
    @FindBy(xpath = "//ul[contains(@class,'submenu')]/li//a[@title='Blouses']")
    private WebElement womenMenuSubMenuTopsBlousesOption;

    //womenMenuDressesSubMenu
    @FindBy(xpath = "//ul[contains(@class,'submenu')]/li/a[@title='Dresses']")
    private WebElement womenMenuDressesSubMenu;

    //womenMenuSubMenuDressesCasualDressesOption
    @FindBy(xpath = "//a[@title='Women']/following-sibling::ul[contains(@class,'submenu')]" +
            "//a[@title='Casual Dresses']")
    private WebElement womenMenuSubMenuDressesCasualDressesOption;

    //womenMenuSubMenuDressesEveningDressesOption
    @FindBy(xpath = "//a[@title='Women']/following-sibling::ul[contains(@class,'submenu')]" +
            "//a[@title='Evening Dresses']")
    private WebElement womenMenuSubMenuDressesEveningDressesOption;

    //womenMenuSubMenuDressesSummerDressesOption
    @FindBy(xpath = "//a[@title='Women']/following-sibling::ul[contains(@class,'submenu')]" +
            "//a[@title='Summer Dresses']")
    private WebElement womenMenuSubMenuDressesSummerDressesOption;

    //dressesMenu
    @FindBy(xpath = "//ul[contains(@class,'sf-menu')]/li/a[@title='Dresses']")
    private WebElement dressesMenu;

    //dressesMenuCasualDressesOption
    @FindBy(xpath = "//ul[contains(@class,'submenu')]/li/a[@title='Casual Dresses']")
    private WebElement dressesMenuCasualDressesOption;

    //dressesMenuEveningDressesOption
    @FindBy(xpath = "//ul[contains(@class,'submenu')]/li/a[@title='Evening Dresses']")
    private WebElement dressesMenuEveningDressesOption;

    //dressesMenuSummerDressesOption
    @FindBy(xpath = "//ul[contains(@class,'submenu')]/li/a[@title='Summer Dresses']")
    private WebElement dressesMenuSummerDressesOption;

    //tShirtsMenu
    @FindBy(xpath = "//ul[contains(@class,'sf-menu')]/li/a[@title='T-shirts']")
    private WebElement tShirtsMenu;

    public void clickOnSearchButton() {
        generalSeleniumMethods.clickAction(searchButton);
    }

    public SearchHomePageElementsNew inputText(String searchQuery) {
        searchQueryTop.sendKeys(searchQuery);
        return this;
    }

    public void hoverWomen() {
        generalSeleniumMethods.hoverOverElement(womenMenu);
    }

    public void hoverTopsSubMenu() {
        generalSeleniumMethods.hoverOverElement(womenMenuTopsSubMenu);
    }

    public void hoverTshirtsSubMenu() {
        generalSeleniumMethods.hoverOverElement(womenMenuSubMenuTopsTshirtsOption);
    }

    public void hoverBlousesSubMenu() {
        generalSeleniumMethods.hoverOverElement(womenMenuSubMenuTopsBlousesOption);
    }

    public void hoverDressesSubMenu() {
        generalSeleniumMethods.hoverOverElement(womenMenuDressesSubMenu);
    }

    public void hoverWomenCasualDressesOption() {
        generalSeleniumMethods.hoverOverElement(womenMenuSubMenuDressesCasualDressesOption);
    }

    public void hoverWomenEveningDressesOption() {
        generalSeleniumMethods.hoverOverElement(womenMenuSubMenuDressesEveningDressesOption);
    }

    public void hoverWomenSummerDressesOption() {
        generalSeleniumMethods.hoverOverElement(womenMenuSubMenuDressesSummerDressesOption);
    }

    public void hoverDresses() {
        generalSeleniumMethods.hoverOverElement(dressesMenu);
    }

    public void hoverDressesCasualDressesOption() {
        generalSeleniumMethods.hoverOverElement(dressesMenuCasualDressesOption);
    }

    public void hoverDressesEveningDressesOption() {
        generalSeleniumMethods.hoverOverElement(dressesMenuEveningDressesOption);
    }

    public void hoverDressesSummerDressesOption() {
        generalSeleniumMethods.hoverOverElement(dressesMenuSummerDressesOption);
    }

    public void hoverTshirts() {
        generalSeleniumMethods.hoverOverElement(tShirtsMenu);
    }

    /**
     * method click on the logo
     * @return instance of page (this)
     */
    public void clickOnStaticLogo() {
        generalSeleniumMethods.clickAction(logoButton);
    }

    public void clickOnWomenMenuButton() {
        generalSeleniumMethods.clickAction(womenMenu);
    }

    public void clickOnWomenMenuTshirsOption() {
        generalSeleniumMethods.clickAction(womenMenuSubMenuTopsTshirtsOption);
    }

    public void clickOnWomenMenuBlousesOption() {
        generalSeleniumMethods.clickAction(womenMenuSubMenuTopsBlousesOption);
    }

    public void clickOnCasualDressesOption() {
        generalSeleniumMethods.clickAction(womenMenuSubMenuDressesCasualDressesOption);
    }

    public void clickOnEveningDressesOption() {
        generalSeleniumMethods.clickAction(womenMenuSubMenuDressesEveningDressesOption);
    }

    public void clickOnSummerDressesOption() {
        generalSeleniumMethods.clickAction(womenMenuSubMenuDressesSummerDressesOption);
    }

    public void clickOnDressesButton() {
        generalSeleniumMethods.clickAction(dressesMenu);
    }

    public void clickOnDressesCasualDressesOption() {
        generalSeleniumMethods.clickAction(dressesMenuCasualDressesOption);
    }

    public void clickOnDressesEveningDressesOption() {
        generalSeleniumMethods.clickAction(dressesMenuEveningDressesOption);
    }

    public void clickOnDressesSummerDressesOption() {
        generalSeleniumMethods.clickAction(dressesMenuSummerDressesOption);
    }

    public void clickOnTshirtsButton() {
        generalSeleniumMethods.clickAction(tShirtsMenu);
    }

    public String getActualTitle() {
        return generalSeleniumMethods.getTitle();
    }

    public String getActualWomenMenuName() {
        return generalSeleniumMethods.getText(womenMenu);
    }

    public String getActualWomenMenuTopsSubMenuName() {
        return generalSeleniumMethods.getText(womenMenuTopsSubMenu);
    }

    public String getActualWomenMenuTshirsOptionName() {
        return generalSeleniumMethods.getText(womenMenuSubMenuTopsTshirtsOption);
    }

    public String getActualWomenMenuBlousesOptionName() {
        return generalSeleniumMethods.getText(womenMenuSubMenuTopsBlousesOption);
    }

    public String getActualWomenMenuDressesSubMenuName() {
        return generalSeleniumMethods.getText(womenMenuDressesSubMenu);
    }

    public String getActualCasualDressesOptionName() {
        return generalSeleniumMethods.getText(womenMenuSubMenuDressesCasualDressesOption);
    }

    public String getActualEveningDressesOptionName() {
        return generalSeleniumMethods.getText(womenMenuSubMenuDressesEveningDressesOption);
    }

    public String getActualSummerDressesOptionName() {
        return generalSeleniumMethods.getText(womenMenuSubMenuDressesSummerDressesOption);
    }

    public String getActualDressesMenuName() {
        return generalSeleniumMethods.getText(dressesMenu);
    }

    public String getActualTshirtsMenuName() {
        return generalSeleniumMethods.getText(tShirtsMenu);
    }
}

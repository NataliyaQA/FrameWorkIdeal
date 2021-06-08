package pageObjects.objects.rewritten;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.objects.ProductObject;
import wrapperMethods.GeneralSeleniumMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortByNew {
    public WebDriver driver;
    GeneralSeleniumMethods generalSeleniumMethods = new GeneralSeleniumMethods(driver);

    //Constants
    public static final String ALERT_ADD_TO_WISHLIST= "You must be logged in to manage your wishlist.";
    public static final String ALERT_ADDED_TO_WISHLIST= "Added to your wishlist.";

    //Constructor
    public SortByNew(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    // General create list of elements
    public List<ProductObject> getListOfAllElementsInitial(WebElement webElement) {
        List<ProductObject> products = new ArrayList<>();
        List<WebElement> elementName = (List<WebElement>) webElement;
        List<String> texts = elementName
                .stream()
                .map(WebElement::getText)
                .collect(toList());

        for (String takeTextOfEach : texts) {
            String getTitleString = Arrays.asList(takeTextOfEach.split("\n")).get(0);
            String getPrice = Arrays.asList(takeTextOfEach.split("\n")).get(1);

            products.add(new ProductObject(getTitleString, convertToFloatPrice(getPrice)));
        }
        System.out.println("**********");
        return products;
    }

    public float convertToFloatPrice(String price) {
        // get price example $30.25 20.50 -20%
        int getActualPrice = 0;
        return Float.parseFloat(price.split(" ")[getActualPrice]
                .replace("$", ""));
    }

    //listOfAllElementsWomenPageInitial
    @FindBy(xpath = "//*[@id='center_column']/ul/li")
    private WebElement listOfAllElementsWomenPageInitial;

    //public List<ProductObject> create
    public List<ProductObject> getListOfAllElementsWomenPageInitial() {
        return getListOfAllElementsInitial(listOfAllElementsWomenPageInitial);
    }

    public List<ProductObject> getListOfAllElementsWomenPageSecond() {
        return getListOfAllElementsInitial(listOfAllElementsWomenPageInitial);
    }

    //dropDownPriceLowest
    @FindBy(xpath = "//*[@id='selectProductSort']")
    private WebElement dropDownPriceLowest;

    public void selectValueDropDownPriceLowest() {
        generalSeleniumMethods.selectValueFromDropDown(dropDownPriceLowest, "Price: Lowest first");
    }

    //drownDownPriceHighest
    @FindBy(xpath = "//*[@id='selectProductSort']")
    private WebElement drownDownPriceHighest;

    public void selectValueDropDownPriceHighest() {
        generalSeleniumMethods.selectValueFromDropDown(drownDownPriceHighest, "Price: Highest first");
    }

    //drownDownAZ
    @FindBy(xpath = "//*[@id='selectProductSort']")
    private WebElement drownDownAZ;

    public void selectValueDropDownNameAZ() {
        generalSeleniumMethods.selectValueFromDropDown(drownDownAZ, "Product Name: A to Z");
    }

    //drownDownZA
    @FindBy(xpath = "//*[@id='selectProductSort']")
    private WebElement drownDownZA;

    public void selectValueDropDownNameZA() {
        generalSeleniumMethods.selectValueFromDropDown(drownDownZA, "Product Name: Z to A");
    }

    //drownDownInStock
    @FindBy(xpath = "//*[@id='selectProductSort']")
    private WebElement drownDownInStock;

    public void selectValueDropDownInStock() {
        generalSeleniumMethods.selectValueFromDropDown(drownDownInStock, "In stock");
    }

    //drownDownReferenceOne
    @FindBy(xpath = "//*[@id='selectProductSort']")
    private WebElement drownDownReferenceOne;

    public void selectValueDropDownReferenceOne() {
        generalSeleniumMethods.selectValueFromDropDown(drownDownReferenceOne, "Reference: Lowest first");
    }

    //drownDownReferenceTwo
    @FindBy(xpath = "//*[@id='selectProductSort']")
    private WebElement drownDownReferenceTwo;

    public void selectValueDropDownReferenceTwo() {
        generalSeleniumMethods.selectValueFromDropDown(drownDownReferenceTwo, "Reference: Highest first");
    }

    //gridIcon
    @FindBy(xpath = "//i[@class='icon-th-large']")
    private WebElement gridIcon;

    public boolean viewGridIconIsEnabled() {
       return generalSeleniumMethods.isEnabled(gridIcon);
    }

    //listIcon
    @FindBy(xpath = "//i[@class='icon-th-list']")
    private WebElement listIcon;

    public boolean viewListIconIsEnabled() {
       return generalSeleniumMethods.isEnabled(listIcon);
    }

    //alertAddToWishList
    @FindBy(xpath = "//p[contains(text(),'You must')]")
    private WebElement alertAddToWishList;

    public boolean alertAddToWishListIsEnabled() {
       return generalSeleniumMethods.isEnabled(alertAddToWishList);
    }

    //alertAddedToWishList
    @FindBy(xpath = "//p[contains(text(),'Added to your wishlist.')]")
    private WebElement alertAddedToWishList;

    public boolean alertAddedToWishListIsEnabled() {
       return generalSeleniumMethods.isEnabled(alertAddedToWishList);
    }

    public boolean alertAddToWishListIsDisplayed() {
       return generalSeleniumMethods.isDisplayed(alertAddToWishList);
    }

    //firstProduct
    @FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    private WebElement firstProduct;

    public void hoverFirstProduct() {
        generalSeleniumMethods.hoverElementTwo(firstProduct);
    }

    //thirdProduct
    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a")
    private WebElement thirdProduct;

    public void hoverThirdProduct() {
        generalSeleniumMethods.hoverElementTwo(thirdProduct);
    }

    //addToWishListOne
    @FindBy(xpath = "//a[@class='addToWishlist wishlistProd_1']")
    private WebElement addToWishListOne;

    public void addToWishListOneClick() {
        generalSeleniumMethods.clickElement(addToWishListOne);
    }

    //addToWishListThree
    @FindBy(xpath = "//a[@class='addToWishlist wishlistProd_3']")
    private WebElement addToWishListThree;

    public void addToWishListThreeClick() {
        generalSeleniumMethods.clickElement(addToWishListThree);
    }

    //addToCompareOne
    @FindBy(xpath = "//a[@class='add_to_compare' and @data-id-product='1']")
    private WebElement addToCompareOne;

    public void addToCompareOneClick() {
        generalSeleniumMethods.clickElement(addToCompareOne);
    }

    //addToCompareThree
    @FindBy(xpath = "//a[@class='add_to_compare' and @data-id-product='3']")
    private WebElement addToCompareThree;

    public void addToCompareThreeClick() {
        generalSeleniumMethods.clickElement(addToCompareThree);
    }

    //closeAlertAddToWishList
    @FindBy(xpath = "//a[@title='Close']")
    private WebElement closeAlertAddToWishList;

    public void closeAlertAddToWishListClick() {
        generalSeleniumMethods.clickElement(closeAlertAddToWishList);
    }

    //womenButton
    @FindBy(xpath = "//a[@title='Women']/parent::li")
    private WebElement womenButton;

    public void womenButtonClick() {
        generalSeleniumMethods.clickElement(womenButton);
    }

    //alertTextWishList
    @FindBy(xpath = "//p[contains(text(),'You must')]")
    private WebElement alertTextWishList;

    public String alertTextWishList() {
        return generalSeleniumMethods.getText(alertTextWishList);
    }

    //alertTextWishListAdded
    @FindBy(xpath = "//p[contains(text(),'Added to your wishlist.')]")
    private WebElement alertTextWishListAdded;

    public String alertTextWishListAdded() {
        return generalSeleniumMethods.getText(alertTextWishListAdded);
    }
}

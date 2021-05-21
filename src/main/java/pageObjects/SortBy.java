package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.objects.ProductObject;
import utils.MainMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortBy {
    public WebDriver driver;
    MainMethods mainMethods;

    //Constants
    public static final String ALERT_ADD_TO_WISHLIST= "You must be logged in to manage your wishlist.";
    public static final String ALERT_ADDED_TO_WISHLIST= "Added to your wishlist.";

    //Constructor
    public SortBy(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    // General create list of elements
    public List<ProductObject> getListOfAllElementsInitial(String xPath) {
        List<ProductObject> products = new ArrayList<>();
        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
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


    //public List<ProductObject> create
    public List<ProductObject> getListOfAllElementsWomenPageInitial() {
        return getListOfAllElementsInitial("//*[@id='center_column']/ul/li");
    }

//    //General create a new list of elements after sorting
//    public List<ProductObject> getListOfAllElementsSecond(String xPath) {
//        List<ProductObject> products2 = new ArrayList<>();
//        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
//        List<String> texts = elementName
//                .stream()
//                .map(WebElement::getText)
//                .collect(toList());
//
//        for (String takeTextOfEach : texts) {
//            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
//            String getTitleString = separateItems.get(0);
//
//            products2.add(new ProductObject(getTitleString));
//        }
//        System.out.println("**********");
//        products2.stream().forEach(System.out::println);
//        return products2;
//    }
//
    public List<ProductObject> getListOfAllElementsWomenPageSecond() {
        return getListOfAllElementsInitial("//*[@id='center_column']/ul/li");
    }

//    // General create list of elements Price
//    public List<String> getListOfAllElementsPrice(String xPath) {
//        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
//        List<String> texts = elementName
//                .stream()
//                .map(WebElement::getText)
//                .collect(toList());
//        return texts;
//    }
//
//    public List<String> getListOfAllElementsWomenPagePrice() {
//        return getListOfAllElementsInitial("//*[@id='center_column']/ul/li");
//    }

    /**
     * moved to MainMethods
     * @param
     * @param
     */
    //General select sort option
//    public void selectValueFromDropDown(String xPath, String value) {
//        Select dropDown = new Select(driver.findElement(By.xpath(xPath)));
//        dropDown.selectByVisibleText(value);
//    }

    public void selectValueDropDownPriceLowest() {
        mainMethods.selectValueFromDropDown("//*[@id='selectProductSort']", "Price: Lowest first");
    }

    public void selectValueDropDownPriceHighest() {
        mainMethods.selectValueFromDropDown("//*[@id='selectProductSort']", "Price: Highest first");
    }

    public void selectValueDropDownNameAZ() {
        mainMethods.selectValueFromDropDown("//*[@id='selectProductSort']", "Product Name: A to Z");
    }

    public void selectValueDropDownNameZA() {
        mainMethods.selectValueFromDropDown("//*[@id='selectProductSort']", "Product Name: Z to A");
    }

    public void selectValueDropDownInStock() {
        mainMethods.selectValueFromDropDown("//*[@id='selectProductSort']", "In stock");
    }

    public void selectValueDropDownReferenceOne() {
        mainMethods.selectValueFromDropDown("//*[@id='selectProductSort']", "Reference: Lowest first");
    }

    public void selectValueDropDownReferenceTwo() {
        mainMethods.selectValueFromDropDown("//*[@id='selectProductSort']", "Reference: Highest first");
    }

    public boolean viewGridIconIsEnabled() {
       return mainMethods.isEnabled("//i[@class='icon-th-large']");
    }

    public boolean viewListIconIsEnabled() {
       return mainMethods.isEnabled("//i[@class='icon-th-list']");
    }

    public boolean alertAddToWishListIsEnabled() {
       return mainMethods.isEnabled("//p[contains(text(),'You must')]");
    }

    public boolean alertAddedToWishListIsEnabled() {
       return mainMethods.isEnabled("//p[contains(text(),'Added to your wishlist.')]");
    }

    public boolean alertAddToWishListIsDisplayed() {
       return mainMethods.isDisplayed("//p[contains(text(),'You must')]");
    }

    public void hoverFirstProduct() {
        mainMethods.hoverElementTwo("//a[contains(text(),'Faded Short Sleeve T-shirts')]");
    }

    public void hoverThirdProduct() {
        mainMethods.hoverElementTwo("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a");
    }

    public void addToWishListOneClick() {
        mainMethods.clickElement("//a[@class='addToWishlist wishlistProd_1']");
    }

    public void addToWishListThreeClick() {
        mainMethods.clickElement("//a[@class='addToWishlist wishlistProd_3']");
    }

    public void addToCompareOneClick() {
        mainMethods.clickElement("//a[@class='add_to_compare' and @data-id-product='1']");
    }
    public void addToCompareThreeClick() {
        mainMethods.clickElement("//a[@class='add_to_compare' and @data-id-product='3']");
    }

    public void closeAlertAddToWishListClick() {
        mainMethods.clickElement("//a[@title='Close']");
    }

    public void womenButtonClick() {
        mainMethods.clickElement("//a[@title='Women']/parent::li");
    }

    public String alertTextWishList() {
        return mainMethods.getText("//p[contains(text(),'You must')]");
    }

    public String alertTextWishListAdded() {
        return mainMethods.getText("//p[contains(text(),'Added to your wishlist.')]");
    }
}

package pageObjects.objects.rewritten;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.objects.WishListObject;
import wrapperMethods.GeneralSeleniumMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WishListPageNew {
    public WebDriver driver;
    MyAccountPageNew myAccountPage = new MyAccountPageNew(driver);
    GeneralSeleniumMethods generalSeleniumMethods = new GeneralSeleniumMethods(driver);

    //Constants
    public static final String NAME_OF_WISHLIST_ONE = "Name Of WishList One";
    public static final String NAME_OF_WISHLIST_TWO = "Name Of WishList Two";

    //Constructor
    public WishListPageNew(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //wishListOne
    @FindBy(xpath = "//input[@id='name']")
    private WebElement wishListOne;

    public void nameSendKeyOne() {
        generalSeleniumMethods.sendKey(wishListOne, NAME_OF_WISHLIST_ONE);
    }

    public void nameSendKeyTwo() {
        generalSeleniumMethods.sendKey(wishListOne, NAME_OF_WISHLIST_TWO);
    }

    public void nameSubmitForm() {
        generalSeleniumMethods.submitForm(wishListOne);
    }

    public List<WishListObject> wishListTable(List<WebElement> webElement) {
        List<WishListObject> tableValues = new ArrayList<>();
        List<WebElement> tableColumnAndValue = webElement;
        List<String> texts = tableColumnAndValue
                .stream()
                .map(WebElement::getText)
                .collect(toList());
        for (String takeTextOfEach : texts) {
            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
            String getName = separateItems.get(0);

            tableValues.add(new WishListObject(getName));
        }
        System.out.println("**********");
        tableValues.stream().forEach(System.out::println);
        return tableValues;
    }

    //tableWishList
    @FindBy(xpath = "//*[@id='block-history']")
    private WebElement tableWishList;

    public List<WishListObject> getListOfAllElementsTableWishList() {
        return wishListTable((List<WebElement>) tableWishList);
    }

    //saveButton
    @FindBy(xpath = "//button[@id='submitWishlist']")
    private WebElement saveButton;

    public void saveButtonClick() {
        generalSeleniumMethods.clickElement(saveButton);
    }

}

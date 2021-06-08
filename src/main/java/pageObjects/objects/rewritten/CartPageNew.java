package pageObjects.objects.rewritten;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ThreadSleep;
import wrapperMethods.GeneralSeleniumMethods;

public class CartPageNew extends BasePageObject {
    GeneralSeleniumMethods generalSeleniumMethods;

    //Constants
    public final String BUTTON_ADD_TO_CART = "Add to cart";
    public final String THERE_ARE_IN_THE_CART = "There are 6 items in your cart.";
    public final String ADD_TO_CART_MODAL = "Product successfully added to your shopping cart\n" +
            "Faded Short Sleeve T-shirts\n" +
            "Orange, S\n" +
            "Quantity 1\n" +
            "Total $16.51\n" +
            "There is 1 item in your cart.\n" +
            "Total products $16.51\n" +
            "Total shipping  $2.00\n" +
            "Total $18.51\n" +
            "Continue shopping\n" +
            "Proceed to checkout";

    private WebDriver driver;

    //Constructor
    public CartPageNew(WebDriver driver) {
        generalSeleniumMethods = new GeneralSeleniumMethods(driver);
        this.driver = driver;
    }

    //Methods
    public void waiterWrapperLocatedBy(WebElement webElement) {
        ThreadSleep.waitForElementLocatedBy(driver, (By) webElement);
    }

    public void waiterWrapperForElement(WebElement webElement) {
        ThreadSleep.waitForElement(driver, webElement);
    }

    // fadedShortSleeveTshirts
    @FindBy(xpath = "//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Faded')]")
    private WebElement fadedShortSleeveTshirts;

    public boolean fadedShortSleeveTshirtsDisplayed() {
        return generalSeleniumMethods.isDisplayed(fadedShortSleeveTshirts);
    }

    // blouse
    @FindBy(xpath = "//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Blouse')]")
    private WebElement blouse;

    public boolean blouseDisplayed() {
        return generalSeleniumMethods.isDisplayed(blouse);
    }

    // printedDress
    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a")
    private WebElement printedDress;

    public boolean printedDressDisplayed() {
        return generalSeleniumMethods.isDisplayed(printedDress);
    }

    // printedDressTwo
    @FindBy(xpath = "//ul[@id='homefeatured']/li[4]/div/div[2]/h5/a")
    private WebElement printedDressTwo;

    public boolean printedDressTwoDisplayed() {
        return generalSeleniumMethods.isDisplayed(printedDressTwo);
    }

    // printedSummerDress
    @FindBy(xpath = "//ul[@id='homefeatured']/li[5]/div/div[2]/h5/a")
    private WebElement printedSummerDress;

    public boolean printedSummerDressDisplayed() {
        return generalSeleniumMethods.isDisplayed(printedSummerDress);
    }

    // printedSummerDressTwo
    @FindBy(xpath = "//ul[@id='homefeatured']/li[6]/div/div[2]/h5/a")
    private WebElement printedSummerDressTwo;

    public boolean printedSummerDressTwoDisplayed() {
        return generalSeleniumMethods.isDisplayed(printedSummerDressTwo);
    }

    // printedChiffonDress
    @FindBy(xpath = "//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Chiffon')]")
    private WebElement printedChiffonDress;

    public boolean printedChiffonDressDisplayed() {
        return generalSeleniumMethods.isDisplayed(printedChiffonDress);
    }

    // addToCart
    @FindBy(xpath = "//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span")
    private WebElement addToCart;

    public boolean addToCartDisplayed() {
        return generalSeleniumMethods.isDisplayed(addToCart);
    }

    // cartEmpty
    @FindBy(xpath = "//span[text()='(empty)']")
    private WebElement cartEmpty;

    public boolean cartEmptyDisplayed() {
        //waiterWrapperForElement(xPath);
        return generalSeleniumMethods.isDisplayed(cartEmpty);
    }

    // crossIconCart
    @FindBy(xpath = "//a[@class='ajax_cart_block_remove_link']")
    private WebElement crossIconCart;

    public boolean crossIconDisplayed() {
        return generalSeleniumMethods.isDisplayed(crossIconCart);
    }

    // fadedShortSleeve
    @FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    private WebElement fadedShortSleeve;

    public void hoverFadedShortSleeve() {
        generalSeleniumMethods.hoverElementTwo(fadedShortSleeve);
    }

    public void hoverPrintedDress() {
        generalSeleniumMethods.hoverElementTwo(printedDress);
    }

    // cartDropDown
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement cartDropDown;

    public void hoverCartDropDown() {
        generalSeleniumMethods.hoverElementTwo(cartDropDown);
    }

    // iconPlus
    @FindBy(xpath = "//i[@class='icon-plus']")
    private WebElement iconPlus;

    public void doubleClickElementFound() {
        generalSeleniumMethods.doubleClickElement(iconPlus);
    }

    public void clickPlusFive() {
        waiterWrapperForElement(iconPlus);
        generalSeleniumMethods.clickPlusSeveralTimes(iconPlus);
    }

    // addToCartFirstProduct
    @FindBy(xpath = "//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span")
    private WebElement addToCartFirstProduct;

    public void clickAddToCartFirstProduct() {
        generalSeleniumMethods.clickElement(addToCartFirstProduct);
    }

    // addToCartThirdProduct
    @FindBy(xpath = "//*[@id='homefeatured']/li[3]/div/div[2]/div[2]/a[1]/span")
    private WebElement addToCartThirdProduct;

    public void clickAddToCartThirdProduct() {
        generalSeleniumMethods.clickElement(addToCartThirdProduct);
    }

    // addToCartFromPdp
    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addToCartFromPdp;

    public void clickAddToCartFromPdp() {
        waiterWrapperForElement(addToCartFromPdp);
        generalSeleniumMethods.clickElement(addToCartFromPdp);
    }

    // productOne
    @FindBy(xpath = "//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Faded')]")
    private WebElement productOne;

    public void clickProductOne() {
        generalSeleniumMethods.clickElement(productOne);
    }

    // productTwo
    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a")
    private WebElement productTwo;

    public void clickProductTwo() {
        generalSeleniumMethods.clickElement(productTwo);
    }

    // continueShopping
    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a")
    private WebElement continueShopping;

    public void clickContinueShopping() {
        waiterWrapperForElement(continueShopping);
        generalSeleniumMethods.clickElement(continueShopping);
    }

    // proceedToCheckout
    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    private WebElement proceedToCheckout;

    public void clickProceedToCheckout() {
        generalSeleniumMethods.clickElement(proceedToCheckout);
    }

    // logo
    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement logo;

    public void clickLogo() {
        generalSeleniumMethods.clickElement(logo);
    }

    // crossIconAddedToCartModal
    @FindBy(xpath = "//span[@class='cross']")
    private WebElement crossIconAddedToCartModal;

    public void clickCrossIcon() {
        generalSeleniumMethods.clickElement(crossIconAddedToCartModal);
    }

    // continueShoppingFromCheckout
    @FindBy(xpath = "//a[@class='button-exclusive btn btn-default']")
    private WebElement continueShoppingFromCheckout;

    public void clickContinueShoppingFromCheckout() {
        generalSeleniumMethods.clickElement(continueShoppingFromCheckout);
    }

    public void clickPlus() {
        waiterWrapperForElement(iconPlus);
        generalSeleniumMethods.clickElement(iconPlus);
    }

    public void clickCrossIconCart() {
        waiterWrapperForElement(crossIconCart);
        generalSeleniumMethods.clickElement(crossIconCart);
    }

    // alertTextAddedToCartModal
    @FindBy(xpath = "//*[@id='layer_cart']/div[1]")
    private WebElement alertTextAddedToCartModal;

    public String alertTextAddedToCartModal() {
        waiterWrapperForElement(alertTextAddedToCartModal);
        return generalSeleniumMethods.getText(alertTextAddedToCartModal);
    }

    // alertTextThereAreInTheCartAddedToCartModal
    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/h2/span[1]")
    private WebElement alertTextThereAreInTheCartAddedToCartModal;

    public String alertTextThereAreInTheCart() {
        waiterWrapperLocatedBy(alertTextThereAreInTheCartAddedToCartModal);
        return generalSeleniumMethods.getText(alertTextThereAreInTheCartAddedToCartModal);
    }

    // priceValuePdp
    @FindBy(xpath = "//*[@id='our_price_display']")
    private WebElement priceValuePdp;

    public float textToDigitsPrice() {
        waiterWrapperForElement(priceValuePdp);
        return generalSeleniumMethods.textToDigits(priceValuePdp);
    }

    // totalAddedProductModal
    @FindBy(xpath = "//span[@id='layer_cart_product_price']")
    private WebElement totalAddedProductModal;

    public float textToDigitsTotalAddedProductModal() {
        waiterWrapperForElement(totalAddedProductModal);
        return generalSeleniumMethods.textToDigits(totalAddedProductModal);
    }

    // totalProductsAddedAddedToCartModal
    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[1]/span")
    private WebElement totalProductsAddedAddedToCartModal;

    public float textToDigitsTotalProductsAddedAddedToCartModal() {
        return generalSeleniumMethods.textToDigits(totalProductsAddedAddedToCartModal);
    }
}

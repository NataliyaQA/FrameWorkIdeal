package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MainMethods;
import utils.ThreadSleep;

import java.awt.*;

public class CartPage {
    public WebDriver driver;
    MainMethods mainMethods;

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

    //Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    //Methods

    public void waiterWrapperLocatedBy(String xPath) {
        ThreadSleep.waitForElementLocatedBy(driver, By.xpath(xPath));
    }

    public void waiterWrapperForElement(String xPath) {
        WebElement button = driver.findElement(By.xpath(xPath));
        ThreadSleep.waitForElement(driver, button);
    }

    //General isDisplayed
    /**
     * moved to MainMethods
     * @param
     * @return
     */
//    public boolean isDisplayed(String xPath) {
//        return driver.findElement(By.xpath(xPath)).isDisplayed() ? true : false;
//    }

    public boolean fadedShortSleeveTshirtsDisplayed() {
        return mainMethods
                .isDisplayed("//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Faded')]");
    }

    public boolean blouseDisplayed() {
        return mainMethods
                .isDisplayed("//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Blouse')]");
    }

    public boolean printedDressDisplayed() {
        return mainMethods
                .isDisplayed("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a");
    }

    public boolean printedDressTwoDisplayed() {
        return mainMethods
                .isDisplayed("//ul[@id='homefeatured']/li[4]/div/div[2]/h5/a");
    }

    public boolean printedSummerDressDisplayed() {
        return mainMethods
                .isDisplayed("//ul[@id='homefeatured']/li[5]/div/div[2]/h5/a");
    }

    public boolean printedSummerDressTwoDisplayed() {
        return mainMethods
                .isDisplayed("//ul[@id='homefeatured']/li[6]/div/div[2]/h5/a");
    }

    public boolean printedChiffonDressDisplayed() {
        return mainMethods
                .isDisplayed("//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Chiffon')]");
    }

    public boolean addToCartDisplayed() {
        return mainMethods
                .isDisplayed("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span");
    }

    public boolean cartEmptyDisplayed() {
        //waiterWrapperForElement(xPath);
        return mainMethods.isDisplayed("//span[text()='(empty)']");
    }

    public boolean crossIconDisplayed() {
        return mainMethods
                .isDisplayed("//a[@class='ajax_cart_block_remove_link']");
    }

    /**
     * moved to MainMethods
     * @param
     * @return
     */
    //General hover
//    public void hoverElement(String xPath) {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath(xPath))).perform();
//    }

    public void hoverFadedShortSleeve() {
        mainMethods.hoverElementTwo("//a[contains(text(),'Faded Short Sleeve T-shirts')]");
    }

    public void hoverPrintedDress() {
        mainMethods.hoverElementTwo("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a");
    }

    public void hoverCartDropDown() {
        mainMethods.hoverElementTwo("//a[@title='View my shopping cart']");
    }

    /**
     * moved to MainMethods
     * @param
     */
    //General double click
//    public void doubleClickElement(String xPath) {
//        Actions actions = new Actions(driver);
//        actions.doubleClick(driver.findElement(By.xpath(xPath))).perform();
//    }

    public void doubleClickElementFound() {
        mainMethods.doubleClickElement("//i[@class='icon-plus']");
    }

    /**
     * moved to MainMethods
     * @param
     */
    //General click several times
//    public void clickPlusSeveralTimes(String xPath) {
//        Actions actions = new Actions(driver);
//        int count = 5;
//        while(count>0) {
//            actions.click(driver.findElement(By.xpath(xPath))).perform();
//            count -=1;
//        }
//    }

    public void clickPlusFive() {
        String xPath = "//i[@class='icon-plus']";
        waiterWrapperForElement(xPath);
        mainMethods.clickPlusSeveralTimes(xPath);
    }

    /**
     * moved to MainMethods
     * @param
     **/
    //General click
//    public void clickElement(String xPath) {
//        driver.findElement(By.xpath(xPath)).click();
//    }

    public void clickAddToCartFirstProduct() {
        mainMethods.clickElement("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span");
    }
    public void clickAddToCartThirdProduct() {
        mainMethods.clickElement("//*[@id='homefeatured']/li[3]/div/div[2]/div[2]/a[1]/span");
    }

    public void clickAddToCartFromPdp() {
        String xPath = "//span[text()='Add to cart']";
        waiterWrapperForElement(xPath);
        mainMethods.clickElement(xPath);
    }

    public void clickProductOne() {
        mainMethods.clickElement("//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Faded')]");
    }

    public void clickProductTwo() {
        mainMethods.clickElement("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a");
    }

    public void clickContinueShopping() {
        String xPath = "//span[@class='continue btn btn-default button exclusive-medium']";
        waiterWrapperForElement(xPath);
        mainMethods.clickElement(xPath);
    }

    public void clickProceedToCheckout() {
        mainMethods.clickElement("//a[@class='btn btn-default button button-medium']");
    }

    public void clickLogo() {
        mainMethods.clickElement("//img[@class='logo img-responsive']");
    }

    public void clickCrossIcon() {
        mainMethods.clickElement("//span[@class='cross']");
    }

    public void clickContinueShoppingFromCheckout() {
        mainMethods.clickElement("//a[@class='button-exclusive btn btn-default']");
    }

    public void clickPlus() {
        String xPath = "//i[@class='icon-plus']";
        waiterWrapperForElement(xPath);
        mainMethods.clickElement(xPath);
    }

    public void clickCrossIconCart() {
        String xPath = "//a[@class='ajax_cart_block_remove_link']";
        waiterWrapperForElement(xPath);
        mainMethods.clickElement(xPath);
    }

    /**
     * moved to MainMethods
     * @throws AWTException
     */
//    public void clickAnyWhere() throws AWTException {
//        Actions actions = new Actions(driver);
//        Robot robot = new Robot();
//        robot.mouseMove(50,50);
//        actions.click().build().perform();
//    }

    /**
     * moved to MainMethods
     * @return
     */
    //General alert
//    public String getText(String xPath) {
//        return driver.findElement(By.xpath(xPath)).getText();
//    }

    public String alertTextAddToCart() {
        String xPath = "//*[@id='layer_cart']/div[1]";
        waiterWrapperForElement(xPath);
        return mainMethods.getText(xPath);
    }
//
//    public String alertTextThereAreInTheCart() {
//        //String xPath = "//span[@class='ajax_cart_product_txt ']";
//        waiterWrapperForElement("//span[@class='ajax_cart_product_txt ']");
//        return mainMethods.getText("//span[@class='ajax_cart_product_txt ']");
//    }
    public String alertTextThereAreInTheCart() {
        String xPath = "//*[@id='layer_cart']/div[1]/div[2]/h2/span[1]";
        waiterWrapperLocatedBy(xPath);
        return mainMethods.getText(xPath);
    }

//    public String alertTextThereAreInTheCart() {
//        String xPath = "//span[@class='ajax_cart_product_txt ']";
//        AutomationWait.waitVisibleClickable(driver.findElement(By.xpath(xPath)));
//        return mainMethods.getText(xPath);
//    }

    /**
     * moved to MainMethods
     * @param
     * @return
     */
    //General
//    public float textToDigits(String xPath) {
//        //DecimalFormat df = new DecimalFormat("#.00");
//        return Float.parseFloat(driver.findElement(By.xpath(xPath)).getText()
//                .replace("$", ""));
//    }

    public float textToDigitsPrice() {
        String xPath = "//*[@id='our_price_display']";
        waiterWrapperForElement(xPath);
        return mainMethods.textToDigits(xPath);
    }

    public float textToDigitsTotalAddedProduct() {
        String xPath = "//span[@id='layer_cart_product_price']";
        waiterWrapperForElement(xPath);
        return mainMethods.textToDigits(xPath);
    }

    public float textToDigitsTotalAddedProducts() {
        return mainMethods.textToDigits("//*[@id='layer_cart']/div[1]/div[2]/div[1]/span");
    }
}

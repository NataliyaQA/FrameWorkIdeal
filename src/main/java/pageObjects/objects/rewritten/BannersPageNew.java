package pageObjects.objects.rewritten;

import logs.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wrapperMethods.GeneralSeleniumMethods;

public class BannersPageNew {
    public WebDriver driver;
    GeneralSeleniumMethods generalSeleniumMethods; //Question: is it correct or better make methods in MainMethods static?

    public final String EXPECTED_BUTTON_NAME = "SHOP NOW !";
    public final String EXPECTED_URL = "https://www.prestashop.com/en?utm_source=v16_homeslider";

    /**
     * method for search all elements by xPath, getText, getCurrentUrl and for definitions of variables
     * @param driver search for elements
     */
    public BannersPageNew(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //firstBanner
    @FindBy(xpath = "//img[contains(@src,'sample-1.jpg')]")
    private WebElement firstBanner;

    //secondBanner
    @FindBy(xpath = "//img[contains(@src,'sample-2.jpg')]")
    private WebElement secondBanner;

    //thirdBanner
    @FindBy(xpath = "//img[contains(@src,'sample-3.jpg')]")
    private WebElement thirdBanner;

    //staticBannerOne
    @FindBy(xpath = "//img[contains(@src,'img1')]")
    private WebElement staticBannerOne;

    //staticBannerTwo
    @FindBy(xpath = "//img[contains(@src,'img2')]")
    private WebElement staticBannerTwo;

    //staticBannerThree
    @FindBy(xpath = "//img[contains(@src,'img3')]")
    private WebElement staticBannerThree;

    //staticBannerFour
    @FindBy(xpath = "//img[contains(@src,'img4')]")
    private WebElement staticBannerFour;

    //staticBannerFive
    @FindBy(xpath = "//img[contains(@src,'img5')]")
    private WebElement staticBannerFive;

    //staticBannerSix
    @FindBy(xpath = "//img[contains(@src,'img6')]")
    private WebElement staticBannerSix;

    //staticBannerSeven
    @FindBy(xpath = "//img[contains(@src,'img7')]")
    private WebElement staticBannerSeven;

    //staticBannerTop
    @FindBy(xpath = "//img[contains(@src,'img-responsive')]")
    private WebElement staticBannerTop;

    //firstBannerButton
    @FindBy(xpath = "//img[contains(@src,'sample-1.jpg')]" +
            "/ancestor::li[@class='homeslider-container']/div//button")
    private WebElement firstBannerButton;

    /**
     * method for 1st banner button hover
     * @return instance of page
     */
    public BannersPageNew hoverFirstBannerButton() {
        Log.log("1st banner is hovered");
        generalSeleniumMethods.hoverOverElement(firstBannerButton);
        return this;
    }

    /**
     * method for getting actual name of button on the 1st banner
     * @return instance of page (this)
     */
    public String getButtonNameOne() {
        return generalSeleniumMethods.getText(firstBannerButton);
    }

    /**
     * method for click on 1st banner button action
     * @return instance of page (this)
     */
    public void clickOnFirstBannerButton() {
        generalSeleniumMethods.clickAction(firstBannerButton);
    }

    //secondBannerButton
    @FindBy(xpath = "//img[contains(@src,'sample-2.jpg')]" +
            "/ancestor::li[@class='homeslider-container']/div//button")
    private WebElement secondBannerButton;

    /**
     * method for 2d banner button hover
     * @return instance of page (this)
     */
    public BannersPageNew hoverSecondBannerButton() {
        generalSeleniumMethods.hoverOverElement(secondBannerButton);
        return this;
    }

    /**
     * method for getting actual name of button on the 2d banner
     * @return instance of page (this)
     */
    public String getButtonNameTwo() {
        return generalSeleniumMethods.getText(secondBannerButton);
    }

    //thirdBannerButton
    @FindBy(xpath = "//img[contains(@src,'sample-3.jpg')]" +
            "/ancestor::li[@class='homeslider-container']/div//button")
    private WebElement thirdBannerButton;

    /**
     * method for getting actual name of button on the 3d banner
     * @return instance of page (this)
     */
    public String getButtonNameThree() {
        return generalSeleniumMethods.getText(thirdBannerButton);
    }

    /**
     * method for 3d banner button hover
     * @return instance of page (this)
     */
    public BannersPageNew hoverThirdBannerButton() {
        generalSeleniumMethods.hoverOverElement(thirdBannerButton);
        return this;
    }

    /**
     * method for click on 2d banner button action
     * @return instance of page (this)
     */
    public void clickOnSecondBannerButton() {
        generalSeleniumMethods.clickAction(secondBannerButton);
    }

    /**
     * method for click on 3d banner button action
     * @return instance of page (this)
     */
    public void clickOnThirdBannerButton() {
        generalSeleniumMethods.clickAction(thirdBannerButton);
    }

    //rightArrowButton
    @FindBy(xpath = "//a[@class='bx-next']")
    private WebElement rightArrowButton;

    /**
     * method for click on right button action
     * @return instance of page (this)
     */
    public void clickOnRightArrowButton() {
        generalSeleniumMethods.clickAction(rightArrowButton);
    }

    //leftArrowButton
    @FindBy(xpath = "//a[@class='bx-prev']")
    private WebElement leftArrowButton;

    /**
     * method for click on left button action
     * @return instance of page (this)
     */
    public void clickOnLeftArrowButton() {
        generalSeleniumMethods.clickAction(leftArrowButton);
    }

    /**
     * method click on the static banner 1
     * @return instance of page (this)
     */
    public void clickOnStaticBannerOne() {
        generalSeleniumMethods.clickAction(staticBannerOne);
    }

    /**
     * method click on the static banner 2
     * @return instance of page (this)
     */
    public void clickOnStaticBannerTwo() {
        generalSeleniumMethods.clickAction(staticBannerTwo);
    }

    /**
     * method click on the static banner 3
     * @return instance of page (this)
     */
    public void clickOnStaticBannerThree() {
        generalSeleniumMethods.clickAction(staticBannerThree);
    }

    /**
     * method click on the static banner 4
     * @return instance of page (this)
     */
    public void clickOnStaticBannerFour() {
        generalSeleniumMethods.clickAction(staticBannerFour);
    }

    /**
     * method click on the static banner 5
     * @return instance of page (this)
     */
    public void clickOnStaticBannerFive() {
        generalSeleniumMethods.clickAction(staticBannerFive);
    }

    /**
     * method click on the static banner 6
     * @return instance of page (this)
     */
    public void clickOnStaticBannerSix() {
        generalSeleniumMethods.clickAction(staticBannerSix);
    }

    /**
     * method click on the static banner 7
     * @return instance of page (this)
     */
    public void clickOnStaticBannerSeven() {
        generalSeleniumMethods.clickAction(staticBannerSeven);
    }

    /**
     * method for getting current URL of page
     * @return instance of page (this)
     */
    public String getCurrentUrl() {
        return generalSeleniumMethods.getUrl();
    }
}



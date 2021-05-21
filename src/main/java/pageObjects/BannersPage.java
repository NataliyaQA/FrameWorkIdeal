package pageObjects;

import logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MainMethods;

public class BannersPage {
    public WebDriver driver;
    MainMethods mainMethods; //Question: is it correct or better make methods in MainMethods static?

    WebElement firstBanner;
    WebElement secondBanner;
    WebElement thirdBanner;
    WebElement firstBannerButton;
    WebElement secondBannerButton;
    WebElement thirdBannerButton;
    WebElement rightArrowButton;
    WebElement leftArrowButton;
    WebElement staticBannerOne;
    WebElement staticBannerTwo;
    WebElement staticBannerThree;
    WebElement staticBannerFour;
    WebElement staticBannerFive;
    WebElement staticBannerSix;
    WebElement staticBannerSeven;
    WebElement staticBannerTop;

    String buttonNameOne;
    String buttonNameTwo;
    String buttonNameThree;
    String expectedButtonName = "SHOP NOW !";

    String expectedUrl = "https://www.prestashop.com/en?utm_source=v16_homeslider";
    String currentUrl;

    /**
     * method for search all elements by xPath, getText, getCurrentUrl and for definitions of variables
     * @param driver search for elements
     */
    public BannersPage(WebDriver driver) {
        this.driver = driver;

        firstBanner = driver.findElement(By.xpath("//img[contains(@src,'sample-1.jpg')]"));
        firstBannerButton = driver.findElement(By.xpath("//img[contains(@src,'sample-1.jpg')]" +
                "/ancestor::li[@class='homeslider-container']/div//button")); //1t banner button

        secondBanner = driver.findElement(By.xpath("//img[contains(@src,'sample-2.jpg')]")); //2d Carrousel Banner
        secondBannerButton = driver.findElement(By.xpath("//img[contains(@src,'sample-2.jpg')]" +
                "/ancestor::li[@class='homeslider-container']/div//button")); //2d banner button

        thirdBanner = driver.findElement(By.xpath("//img[contains(@src,'sample-3.jpg')]")); //3d Carrousel Banner
        thirdBannerButton = driver.findElement(By.xpath("//img[contains(@src,'sample-3.jpg')]" +
                "/ancestor::li[@class='homeslider-container']/div//button")); //3d banner button

        rightArrowButton = driver.findElement(By.xpath("//a[@class='bx-next']")); //right arrow button
        leftArrowButton = driver.findElement(By.xpath("//a[@class='bx-prev']")); //left arrow button

        buttonNameOne = firstBannerButton.getText(); //get name of 1st button
        buttonNameTwo = secondBannerButton.getText(); //get name of 2d button
        buttonNameThree = thirdBannerButton.getText(); //get name of 3d button

        staticBannerOne = staticBanner("img1");
        staticBannerTwo = staticBanner("img2");
        staticBannerThree = staticBanner("img3");
        staticBannerFour = staticBanner("img4");
        staticBannerFive = staticBanner("img5");
        staticBannerSix = staticBanner("img6");
        staticBannerSeven = staticBanner("img7");
        staticBannerTop = staticBanner("img-responsive");

        currentUrl = driver.getCurrentUrl(); //get URL after redirection
    }

    /**
     * method for static banner search
     * @param titleOne
     * @return static banner
     */
    public WebElement staticBanner(String titleOne) {
        return driver.findElement(By.xpath("//img[contains(@src,'" + titleOne + "')]"));
    }

    /**
     * method for element hover moved to MainMethods
     * @param hoverElement hoverOverElement general
     * @return instance of page (this)
     */
//    public BannersPage hoverOverElement(WebElement hoverElement) {
//        Log.log("Banner is hovered");
//        Actions actions = new Actions(driver);
//
//        actions.moveToElement(hoverElement);
//        actions.perform();
//        return this;
//    }

    /**
     * method for 1st banner button hover
     * @return instance of page
     */
    public BannersPage hoverFirstBannerButton() {
        Log.log("1st banner is hovered");
        mainMethods.hoverOverElement(firstBannerButton);
        return this;
    }

    /**
     * method for 2d banner button hover
     * @return instance of page (this)
     */
    public BannersPage hoverSecondBannerButton() {
        mainMethods.hoverOverElement(secondBannerButton);
        return this;
    }

    /**
     * method for 3d banner button hover
     * @return instance of page (this)
     */
    public BannersPage hoverThirdBannerButton() {
        mainMethods.hoverOverElement(thirdBannerButton);
        return this;
    }

    /**
     * moved to MainMethods
     * method for all click actions
     * @param clickElement click on elements general
     * @return instance of page (this)
     */
//    public BannersPage clickAction(WebElement clickElement) {
//        clickElement.click();
//        return this;
//    }

    /**
     * method for click on 1st banner button action
     * @return instance of page (this)
     */
    public void clickOnFirstBannerButton() {
        mainMethods.clickAction(firstBannerButton);
    }

    /**
     * method for click on 2d banner button action
     * @return instance of page (this)
     */
    public void clickOnSecondBannerButton() {
        mainMethods.clickAction(secondBannerButton);
    }

    /**
     * method for click on 3d banner button action
     * @return instance of page (this)
     */
    public void clickOnThirdBannerButton() {
        mainMethods.clickAction(thirdBannerButton);
    }

    /**
     * method for click on right button action
     * @return instance of page (this)
     */

    public void clickOnRightArrowButton() {
        mainMethods.clickAction(rightArrowButton);
    }

    /**
     * method for click on left button action
     * @return instance of page (this)
     */
    public void clickOnLeftArrowButton() {
        mainMethods.clickAction(leftArrowButton);
    }
    /**
     * method click on the static banner 1
     * @return instance of page (this)
     */
    public void clickOnStaticBannerOne() {
        mainMethods.clickAction(staticBannerOne);
    }

    /**
     * method click on the static banner 2
     * @return instance of page (this)
     */
    public void clickOnStaticBannerTwo() {
        mainMethods.clickAction(staticBannerTwo);
    }

    /**
     * method click on the static banner 3
     * @return instance of page (this)
     */
    public void clickOnStaticBannerThree() {
        mainMethods.clickAction(staticBannerThree);
    }

    /**
     * method click on the static banner 4
     * @return instance of page (this)
     */
    public void clickOnStaticBannerFour() {
        mainMethods.clickAction(staticBannerFour);
    }

    /**
     * method click on the static banner 5
     * @return instance of page (this)
     */
    public void clickOnStaticBannerFive() {
        mainMethods.clickAction(staticBannerFive);
    }

    /**
     * method click on the static banner 6
     * @return instance of page (this)
     */
    public void clickOnStaticBannerSix() {
        mainMethods.clickAction(staticBannerSix);
    }

    /**
     * method click on the static banner 7
     * @return instance of page (this)
     */
    public void clickOnStaticBannerSeven() {
        mainMethods.clickAction(staticBannerSeven);
    }

    /**
     * method for getting actual name of button on the 1st banner
     * @return instance of page (this)
     */
    public String getButtonNameOne() {
        return buttonNameOne;
    }

    /**
     * method for getting actual name of button on the 2d banner
     * @return instance of page (this)
     */
    public String getButtonNameTwo() {
        return buttonNameTwo;
    }

    /**
     * method for getting actual name of button on the 3d banner
     * @return instance of page (this)
     */
    public String getButtonNameThree() {
        return buttonNameThree;
    }

    /**
     * method for getting expected name of button on the banners
     * @return instance of page (this)
     */
    public String getExpectedButtonName() {
        return expectedButtonName;
    }

    /**
     * method for getting current URL of page
     * @return instance of page (this)
     */
    public String getCurrentUrl() {
        return currentUrl;
    }

    /**
     * method for getting expected URL of page
     * @return instance of page (this)
     */
    public String getExpectedUrl() {
        return expectedUrl;
    }


}



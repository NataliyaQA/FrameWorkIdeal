package com.automationpractice.carrouselTest;

import com.automationpractice.BaseTestAbstractClass;
import logsOld.LogOld;
import logsOld.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.objects.rewritten.BannersPageNew;
import pageObjects.objects.rewritten.RedirectionUrlsNew;

import static org.testng.Assert.assertEquals;

//4 tests created

public class CarrouselBannerTest extends BaseTestAbstractClass {
    RedirectionUrlsNew redirectionUrlsNew = new RedirectionUrlsNew(driver);
    BannersPageNew bannersPageNew = new BannersPageNew(driver);

    @Test //(enabled=false)
    //re-wrote  + question (why we return to the initial page and make there verification, why don't do it on redirection page?)
    public void firstCarrouselBanner() {
        bannersPageNew.hoverFirstBannerButton(); //hover button on 1st banner
        //LogOld.logOld("The mouse found the button on the first carrousel", LogType.ERROR);

        Assert.assertTrue(bannersPageNew.EXPECTED_BUTTON_NAME.toLowerCase().contains(bannersPageNew.getButtonNameOne().toLowerCase()),
                "Name of button is correct");
        //LogOld.logOld("Name of the button is correct", LogType.INFO);

        bannersPageNew.clickOnFirstBannerButton();

        Assert.assertEquals(redirectionUrlsNew.getUrlExternalPage(), redirectionUrlsNew.EXTERNAL_PAGE_URL, "URL is correct");
        //LLogOld.logOld("First link from carrousel is correct", LogType.WARNING);
    }

    @Test //(enabled=false) //re-wrote
    public void goToSecondCarrouselBanner() {
        bannersPageNew.clickOnRightArrowButton();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bannersPageNew.hoverSecondBannerButton(); //hover button on 2st banner
        LogOld.logOld("The mouse found the button on the 2d carrousel", LogType.INFO);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(bannersPageNew.getButtonNameTwo(), bannersPageNew.EXPECTED_BUTTON_NAME, "Name of button is correct");
        LogOld.logOld("Name of the button is correct", LogType.INFO);
    }

    @Test (enabled=false) //re-wrote + question about verification of redirected banner
    public void UseArrowsGoRightGoLeftBanner() throws InterruptedException {
        bannersPageNew.clickOnRightArrowButton();
        LogOld.logOld("The mouse found the right arrow button on the first carrousel", LogType.INFO);

        Thread.sleep(1000);

        bannersPageNew.clickOnLeftArrowButton();
        LogOld.logOld("The mouse found the left arrow button on the second carrousel", LogType.INFO);

        Thread.sleep(1000);

        LogOld.logOld("We returned to 1st banner", LogType.INFO);
    }

    @Test //re-wrote
    public void goToThirdCarrouselBanner() {
        bannersPageNew.clickOnRightArrowButton();
        LogOld.logOld("The mouse found the right arrow button on the 2d carrousel", LogType.INFO);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bannersPageNew.clickOnRightArrowButton();
        LogOld.logOld("The mouse found the right arrow button on the 3d carrousel", LogType.INFO);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(bannersPageNew.getButtonNameThree(), bannersPageNew.EXPECTED_BUTTON_NAME, "Name of button is correct");
        LogOld.logOld("Name of the button is correct", LogType.INFO);

        bannersPageNew.clickOnThirdBannerButton();

        assertEquals(redirectionUrlsNew.getUrlExternalPage(), redirectionUrlsNew.EXTERNAL_PAGE_URL,"URL is correct");
        LogOld.logOld("First link from carrousel is correct", LogType.INFO);
    }
}

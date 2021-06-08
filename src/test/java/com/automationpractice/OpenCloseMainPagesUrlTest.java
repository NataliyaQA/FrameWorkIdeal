package com.automationpractice;

import businessLogic.BusinessLogic;
import logs.Log;
import logs.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.objects.rewritten.BannersPageNew;
import pageObjects.objects.rewritten.RedirectionUrlsNew;
import pageObjects.objects.rewritten.SearchHomePageElementsNew;
import wrapperMethods.GeneralSeleniumMethods;

//13 tests created

public class OpenCloseMainPagesUrlTest extends BaseTestAbstractClass {
    GeneralSeleniumMethods generalSeleniumMethods = new GeneralSeleniumMethods(driver);
    SearchHomePageElementsNew searchHomePageElementsNew = new SearchHomePageElementsNew(driver);
    RedirectionUrlsNew redirectionUrlsNew = new RedirectionUrlsNew(driver);
    BannersPageNew bannersPageNew = new BannersPageNew(driver);
    BusinessLogic businessLogic = new BusinessLogic(driver);

    /**
     * Check title of Home page
     */
    @Test(priority = 5) // re-written
    public void homePage() {
        Assert.assertEquals(searchHomePageElementsNew.getActualTitle(), searchHomePageElementsNew.HOME_PAGE_TITLE);
        Log.log("Test result: 'My Store' title is found and correct", LogType.INFO);
        Log.log("Priority 5", LogType.INFO);
    }

    /**
     * Check title of Women page
     */
    @Test(priority = 4, description = "this test about Women page") //#2 // re-written without logs
    public void womanPage() {
        redirectionUrlsNew.womenPagePutUrl(); //put URL into browser URL bar
        Assert.assertEquals(searchHomePageElementsNew.getActualTitle(), searchHomePageElementsNew.WOMEN_PAGE_TITLE); // compare an actual result and expected
        System.out.println("Test result: 'Women - My Store' title is found and correct");
    }

    /**
     * Check URL of Women page after redirection via Women menu
     */
    @Test(priority = 3) // re-written without logs
    public void womanPageClick() {
        searchHomePageElementsNew.clickOnWomenMenuButton();
        Assert.assertEquals(redirectionUrlsNew.getWomenPageUrl(), redirectionUrlsNew.WOMEN_PAGE_URL, "URL is correct");
        System.out.println("Priority 3");
    }

    /**
     * Check URL of Dresses page after redirection via Dresses menu
     */
    @Test(priority = 2) // re-written without logs
    public void dressesPageClick() {
        searchHomePageElementsNew.clickOnDressesButton();
        Assert.assertEquals(redirectionUrlsNew.getUrlDressesPage(), redirectionUrlsNew.DRESSES_PAGE_URL,
                "URL is correct");
        System.out.println("Priority 2");
    }

    /**
     * Check URL of Dresses page after redirection via Blouses option
     */
    @Test(priority = 2) // re-written without logs
    public void blousesOptionClick() {
        searchHomePageElementsNew.hoverWomen();
        searchHomePageElementsNew.clickOnWomenMenuBlousesOption();

        Assert.assertEquals(redirectionUrlsNew.getUrlBlouses(), redirectionUrlsNew.BLOUSES_PAGE_URL,
                "URL is correct");
        System.out.println("Priority 2");
    }

    /**
     * Check URL of Dresses page after redirection via Casual dresses option
     */
    @Test(priority = 2) // re-written without logs
    public void casualDressesOptionClick() {
        searchHomePageElementsNew.hoverWomen();
        searchHomePageElementsNew.clickOnCasualDressesOption();

        Assert.assertEquals(redirectionUrlsNew.getUrlCasualDresses(), redirectionUrlsNew.CASUAL_DRESSES_PAGE_URL,
                "URL is correct");
        System.out.println("Priority 2");
    }

    /**
     * Check URL of Dresses page after redirection via Evening dresses option
     */
    @Test(priority = 2) // re-written without logs
    public void eveningDressesOptionClick() {
        searchHomePageElementsNew.hoverWomen();
        searchHomePageElementsNew.clickOnEveningDressesOption();

        Assert.assertEquals(redirectionUrlsNew.getUrlEveningDresses(), redirectionUrlsNew.EVENING_DRESSES_PAGE_URL,
                "URL is correct");
        System.out.println("Priority 2");
    }

    /**
     * Check URL of Dresses page after redirection via Evening dresses option
     */
    @Test(priority = 2) // re-written without logs
    public void summerDressesOptionClick() {
        searchHomePageElementsNew.hoverWomen();
        searchHomePageElementsNew.clickOnSummerDressesOption();

        Assert.assertEquals(redirectionUrlsNew.getUrlSummerDresses(), redirectionUrlsNew.SUMMER_DRESSES_PAGE_URL,
                "URL is correct");
        System.out.println("Priority 2");
    }

    /**
     * Check URL of T-Shirts page after redirection via T-Shirts menu
     */
    @Test(priority = 1) // re-written without logs
    public void tShirtsPageClick() {
        searchHomePageElementsNew.clickOnTshirtsButton();
        Assert.assertEquals(redirectionUrlsNew.getTshirtsPageUrl(), redirectionUrlsNew.TSHIRTS_PAGE_URL, "URL is correct");
        System.out.println("Priority 1");
    }

    /**
     * Check URL of External page after redirection via Static banner 6
     */
        @Test // re-written without logs
        public void threeDaysSaleBannerClick() {
            bannersPageNew.clickOnStaticBannerSix();
            Assert.assertEquals(redirectionUrlsNew.getUrlExternalPage(),
                    redirectionUrlsNew.EXTERNAL_PAGE_URL, "URL is correct");
            System.out.println("Three DaysSale Banner redirection");
        }

    /**
     * Check URL of External page after redirection via Static banner 7
     */
        @Test // failed
        public void summerCollectionBannerClick() {
            bannersPageNew.clickOnStaticBannerSeven();
            Assert.assertEquals(redirectionUrlsNew.getUrlExternalPage(),
                    redirectionUrlsNew.EXTERNAL_PAGE_URL, "URL is correct");
            System.out.println("Summer Collection Banner redirection");
        }

    /**
     * Check URL of External page after redirection via Static banner 1
     */
        @Test
        public void topTrendsBannerClick() {
            bannersPageNew.clickOnStaticBannerOne();
            Assert.assertEquals(redirectionUrlsNew.getUrlExternalPage(),
                    redirectionUrlsNew.EXTERNAL_PAGE_URL, "URL is correct");
            System.out.println("Top Trends Banner redirection");
        }

    /**
     * Check URL of External page after redirection via Static banner 4
     */
        @Test //
        public void sunGlassesAndEyeWearBannerClick() {
            bannersPageNew.clickOnStaticBannerFour();
            Assert.assertEquals(redirectionUrlsNew.getUrlExternalPage(),
                    redirectionUrlsNew.EXTERNAL_PAGE_URL, "URL is correct");
            System.out.println("Sun Glasses & Eyewear Banner redirection");
        }

    /**
     * Check URL of External page after redirection via Static banner 2
     */
        @Test
        public void menCoatAndJacketsBannerClick() {
            bannersPageNew.clickOnStaticBannerTwo();
            Assert.assertEquals(redirectionUrlsNew.getUrlExternalPage(),
                    redirectionUrlsNew.EXTERNAL_PAGE_URL, "URL is correct");
            System.out.println("Men's Coat & Jackets Banner redirection");
        }

    /**
     * Check URL of External page after redirection via Static banner 5
     */
        @Test
        public void savvyTrendsHandBagsBannerClick() {
            bannersPageNew.clickOnStaticBannerFive();
            Assert.assertEquals(redirectionUrlsNew.getUrlExternalPage(),
                    redirectionUrlsNew.EXTERNAL_PAGE_URL, "URL is correct");
            System.out.println("Savvy Trends Handbags Banner redirection");
        }

    /**
     * Check URL of External page after redirection via Static banner 3
     */
        @Test
        public void womenCoatAndJacketsBannerClick() {
            bannersPageNew.clickOnStaticBannerThree();
            Assert.assertEquals(redirectionUrlsNew.getUrlExternalPage(),
                    redirectionUrlsNew.EXTERNAL_PAGE_URL, "URL is correct");
            System.out.println("Women's Coat & Jackets Banner redirection");
        }

    /**
     * Check URL of Logo page after redirection via Logo
     */
        @Test //, enabled = false
        public void logoClick() {
            searchHomePageElementsNew.clickOnStaticLogo();
            Assert.assertEquals(redirectionUrlsNew.getUrlLogoPage(),
                    redirectionUrlsNew.LOGO_PAGE_URL, "URL is correct");
            System.out.println("'Home' page redirection");
        }
}


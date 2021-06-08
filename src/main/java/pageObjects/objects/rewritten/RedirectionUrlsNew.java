package pageObjects.objects.rewritten;

import org.openqa.selenium.WebDriver;
import wrapperMethods.GeneralSeleniumMethods;

public class RedirectionUrlsNew extends BasePageObject {
    GeneralSeleniumMethods generalSeleniumMethods;

    public final String WOMEN_PAGE_URL = "http://automationpractice.com/index.php?id_category=3&controller=category";
    public final String TSHIRTS_PAGE_URL = "http://automationpractice.com/index.php?id_category=5&controller=category";
    public final String BLOUSES_PAGE_URL = "http://automationpractice.com/index.php?id_category=7&controller=category";
    public final String CASUAL_DRESSES_PAGE_URL = "http://automationpractice.com/index.php?id_category=9&controller=category";
    public final String EVENING_DRESSES_PAGE_URL = "http://automationpractice.com/index.php?id_category=10&controller=category";
    public final String SUMMER_DRESSES_PAGE_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";
    public final String DRESSES_PAGE_URL = "http://automationpractice.com/index.php?id_category=8&controller=category";
    public final String EXTERNAL_PAGE_URL = "https://www.prestashop.com/en";
    public final String LOGO_PAGE_URL = "http://automationpractice.com/index.php";

    private WebDriver driver;

    //Constructor
    public RedirectionUrlsNew(WebDriver driver) {
        generalSeleniumMethods = new GeneralSeleniumMethods(driver);
        this.driver = driver;
    }

    public String getUrlDressesPage() {
        return generalSeleniumMethods.getUrl();
    }

    public String getUrlBlouses() {
        return generalSeleniumMethods.getUrl();
    }

    public String getUrlCasualDresses() {
        return generalSeleniumMethods.getUrl();
    }

    public String getUrlEveningDresses() {
        return generalSeleniumMethods.getUrl();
    }

    public String getUrlSummerDresses() {
        return generalSeleniumMethods.getUrl();
    }

    public String getTshirtsPageUrl() {
        return generalSeleniumMethods.getUrl();
    }

    public String getWomenPageUrl() {
        return generalSeleniumMethods.getUrl();
    }

    public void womenPagePutUrl() {
        generalSeleniumMethods.get(WOMEN_PAGE_URL); //put URL into browser URL bar
    }

    public String getUrlExternalPage() {
        return generalSeleniumMethods.getUrl();
    }

    public String getUrlLogoPage() {
        return generalSeleniumMethods.getUrl();
    }

}

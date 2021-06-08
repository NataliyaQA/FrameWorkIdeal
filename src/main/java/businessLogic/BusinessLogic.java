package businessLogic;

import org.openqa.selenium.WebDriver;
import pageObjects.objects.rewritten.HomePageNew;
import pageObjects.objects.rewritten.MyAccountPageNew;

//extends GeneralSeleniumMethods
public class BusinessLogic  {
    public WebDriver driver;
    HomePageNew homePageNew;
    MyAccountPageNew myAccountPage;
    String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public BusinessLogic(WebDriver driver) {
        homePageNew = new HomePageNew(driver);
        this.driver = driver;
    }

    public void loginUser() {
        driver.get(stringUrl);

        homePageNew.emailSendKey();
        homePageNew.passwordSendKey();
        homePageNew.signInButtonClick();
    }

    public void signOutUser() {
        loginUser();
        myAccountPage = new MyAccountPageNew(driver);
        myAccountPage.signOutButtonClick();
    }

}

package businessLogic;

import org.openqa.selenium.WebDriver;
import pageObjects.objects.rewritten.HomePageNew;
import pageObjects.objects.rewritten.MyAccountPageNew;

//extends GeneralSeleniumMethods
public class BusinessLogic  {
    public WebDriver driver;
    HomePageNew homePageNew;
    String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public BusinessLogic(WebDriver driver) {
        this.driver = driver;
        homePageNew = new HomePageNew(driver);
        //super(driver);
    }

    public void loginUser() {
        driver.get(stringUrl);
        homePageNew = new HomePageNew(driver);

        homePageNew.emailSendKey();
        homePageNew.passwordSendKey();
        homePageNew.signInButtonClick();
    }

    public void signOutUser() {
        loginUser();

        MyAccountPageNew myAccountPage = new MyAccountPageNew(driver);
        myAccountPage.signOutButtonClick();
    }

}

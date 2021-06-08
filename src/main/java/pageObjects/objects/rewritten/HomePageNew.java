package pageObjects.objects.rewritten;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapperMethods.GeneralSeleniumMethods;

public class HomePageNew extends BasePageObject{
    GeneralSeleniumMethods generalSeleniumMethods;

    public static final String NAME = "TestName";
    public static final String SURNAME = "TestName";
    public static final String EMAIL = "qwe+3@gmail.com";
    public static final String PASSWORD = "123456";

    //Constructor
    public HomePageNew(WebDriver driver) {
        generalSeleniumMethods = new GeneralSeleniumMethods(driver);
        //PageFactory.initElements(driver, this);
    }

    // signInButton
    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInButton;

    public void signInButtonClick() {
        generalSeleniumMethods.clickElement(signInButton);
    }

    // signInButtonHeader
    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButtonHeader;

    public void signInButtonHeaderClick() {
        generalSeleniumMethods.clickElement(signInButtonHeader);
    }

    // emailField
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    public void emailSendKey() {
        generalSeleniumMethods.sendKey(emailField, EMAIL);
    }

    // passwordField
    @FindBy(xpath = "//*[@id='passwd']")
    private WebElement passwordField;

    public void passwordSendKey() {
        generalSeleniumMethods.sendKey(passwordField, PASSWORD);
    }

}

package com.automationpractice;

import businessLogic.BusinessLogic;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.objects.rewritten.SignInPageNew;
import wrapperMethods.GeneralSeleniumMethods;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//100 tests
public class CreateAnAccountTest extends BaseTestAbstractClass {
    String stringUrlMainPage = "http://automationpractice.com/index.php";
    String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    SignInPageNew signInPageNew = new SignInPageNew(driver);
    GeneralSeleniumMethods generalSeleniumMethods = new GeneralSeleniumMethods(driver);
    BusinessLogic businessLogic = new BusinessLogic(driver);

    @BeforeMethod
    void setUpMethod() {
        driver.get(stringUrl);
        signInPageNew = new SignInPageNew(driver);
    }

//    @AfterMethod
//    void signOut() {
//        signInPage.signOutButtonClick();
//    }

    @Test (priority = 0, description = "Check URL after click on the 'Sign In' button of 'Main' page") //passed
    @Severity(SeverityLevel.NORMAL)
    @Description("Click on the 'Sign In' button of 'Main' page")
    @Story("Create an account")
    public void checkClickSignInMainPage() {
        driver.get(stringUrlMainPage);
        signInPageNew.clickSignInHeaderButton();
        Assert.assertEquals(signInPageNew.actualUrlFind(), signInPageNew.EXPECTED_URL);
        System.out.println("Expected Url is correct");
    }

    @Test (priority = 0, description = "Check URL after click on the 'Sign In' button of 'Account' page") //passed
    @Severity(SeverityLevel.NORMAL)
    @Description("Click on the 'Sign In' button of 'Account' page")
    @Story("Create an account")
    public void checkClickSignInAccountPage() throws InterruptedException {
        Thread.sleep(5000);
        signInPageNew.clickSignInHeaderButton();
        Assert.assertEquals(signInPageNew.actualUrlFind(), signInPageNew.EXPECTED_URL);
        System.out.println("Expected Url is correct");
    }

    @Test (priority = 0, description = "Check name of the 'Sign In' button of 'Main' page") //passed
    @Severity(SeverityLevel.NORMAL)
    @Description("Name of the 'Sign In' button of 'Main' page")
    @Story("Create an account")
    public void signInButtonNameMainPage() {
        driver.get(stringUrlMainPage);
        Assert.assertEquals(signInPageNew.signInHeaderButtonNameFind(), signInPageNew.EXPECTED_SIGN_IN_HEADER_BUTTON_NAME);
    }

    @Test (priority = 0, description = "Check name of the 'Sign In' button of 'Account' page") //passed
    @Severity(SeverityLevel.MINOR)
    @Description("Name of the 'Sign In' button of 'Account' page")
    @Story("Create an account")
    public void signInButtonNameAccountPage() {
        Assert.assertEquals(signInPageNew.signInHeaderButtonNameFind(), signInPageNew.EXPECTED_SIGN_IN_HEADER_BUTTON_NAME);
    }

    @Test (priority = 0, description = "'Sign In' page title") //passed
    @Severity(SeverityLevel.NORMAL)
    @Description("'Sign In' page title")
    @Story("Create an account")
    public void signInPageTitle() throws InterruptedException {
        //SignInPageNew signInPageNew = new SignInPageNew();
        signInPageNew.clickSignInHeaderButton(); //works with and without
        Assert.assertEquals(signInPageNew.actualTitleFind(), signInPageNew.EXPECTED_TITLE);
        System.out.println("You are on Login - My Store");
    }

    @Test (priority = 0, description = "'Authentication' section name") //passed
    @Severity(SeverityLevel.MINOR)
    @Description("'Authentication' section name")
    @Story("Create an account")
    public void authenticationSectionName() {
        Assert.assertEquals(signInPageNew.authenticationSectionTitleFind(),
                signInPageNew.EXPECTED_AUTHENTICATION_SECTION_TITLE.toUpperCase());
    }

    @Test (priority = 0, description = "'Create An Account Section' section name")
    @Severity(SeverityLevel.NORMAL)
    @Description("'Create An Account Section' section name")
    @Story("Create an account")
    public void createAnAccountSectionName() {
        Assert.assertEquals(signInPageNew.createAnAccountTitleFind(), signInPageNew.EXPECTED_CREATE_AN_ACCOUNT_TITLE_NAME);
    }

    @Test (priority = 0, description = "'Create An Account Section' section text")
    @Severity(SeverityLevel.MINOR)
    @Description("'Create An Account Section' section text")
    @Story("Create an account")
    public void createAnAccountSectionText() {
        Assert.assertEquals(signInPageNew.createAnAccountTextFind(), signInPageNew.EXPECTED_CREATE_AN_ACCOUNT_TEXT);
    }

    @Test (priority = 0, description = "'Email' field of 'Create An Account' name")
    @Severity(SeverityLevel.MINOR)
    @Description("")
    @Story("'Email' field of 'Create An Account' name")
    public void emailFieldCreateAnAccountName() {
        Assert.assertEquals(signInPageNew.emailAddressFieldCreateAnAccountTitle(),
                signInPageNew.EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME);
        System.out.print("The title of email Address Field is " + '"'
                + signInPageNew.EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME + '"');
    }

    @Test (priority = 0, description = "Click on the 'Create An Account'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Click on the 'Create An Account'")
    @Story("Create an account")
    public void emailInputWithOneNew() {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Assert.assertEquals(signInPageNew.authenticationFind(), "Authentication");
    }

    @Test (priority = 0, description = "'Email' field should not be empty")
    @Severity(SeverityLevel.CRITICAL)
    @Description("'Email' field should not be empty")
    @Story("Create an account")
    public void emailInputNotEmpty() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertFalse(signInPageNew.emptyFieldEmail());
    }

    @Test (priority = 0, description = "'Email' field filled in with the same value")
    @Severity(SeverityLevel.CRITICAL)
    @Description("'Email' field filled in with the same value")
    @Story("Create an account")
    public void emailInputSameEmail() throws InterruptedException {
        Thread.sleep(5000);
        String email = "qwe@gmail.com";

        signInPageNew.inputEmailCreateAnAccount(email).createAnAccountButtonClick();
        Thread.sleep(5000);

        // 2d part
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.errorMessageIsExist(), signInPageNew.EXPECTED_ERROR_EXISTING_EMAIL);
        System.out.println("An account using this email address has already been registered. " +
                "Please enter a valid password or request a new one.");
    }

    @Test (priority = 0, description = "'Email' field filled in with the invalid value") // Url put and creation of instance of "SignInPage" class moved to current class
    @Severity(SeverityLevel.MINOR)
    @Description("'Email' field filled in with the invalid value")
    @Story("Create an account")
    public void invalidEmailMessage() throws InterruptedException {
        signInPageNew.inputEmailInvalidCreateAnAccount().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidEmail(), signInPageNew.INVALID_EMAIL);
        System.out.println("The text of message is " + '"' + signInPageNew.INVALID_EMAIL + '"');
    }

    @Test (priority = 0, description = "'Email' field message")
    @Severity(SeverityLevel.MINOR)
    @Description("'Email' field message")
    @Story("Create an account")
    public void invalidEmailMessageWhenEmailEmpty() throws InterruptedException {
        signInPageNew.createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidEmail(), signInPageNew.INVALID_EMAIL);
        System.out.println("The text of message is " + '"' + signInPageNew.INVALID_EMAIL + '"');
    }

    @Test (priority = 0, description = "Fill in 'Email' field and check")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Fill in 'Email' field")
    @Story("Create an account")
    // I want to add put from ContextMap. Main idea is: input a new generated email and then check it in the list of all emails
    public void emailInputWithPut() {
        signInPageNew.emailAddressFieldCreateAnAccountFind();
        signInPageNew.inputEmail();
        //put....
        signInPageNew.createAnAccountButtonClick();
    }

    @Test (priority = 0, description = "'Create An Account' button name")
    @Severity(SeverityLevel.MINOR)
    @Description("'Create An Account' button name")
    @Story("Create an account")
    public void createAnAccountButtonName() {
        Assert.assertEquals(signInPageNew.createAnAccountButtonFind(), signInPageNew.EXPECTED_CREATE_AN_ACCOUNT_BUTTON_NAME);
    }

    @Test (priority = 0, description = "'Already Registered' section name")
    @Severity(SeverityLevel.MINOR)
    @Description("'Already Registered' section name")
    @Story("Create an account")
    public void alreadyRegisteredSectionName() {
        Assert.assertEquals(signInPageNew.alreadyRegisteredTitleFind(), signInPageNew.EXPECTED_ALREADY_REGISTERED_TITLE);
    }

    @Test (priority = 0, description = "emailFieldAlreadyRegisteredName")
    @Severity(SeverityLevel.NORMAL)
    @Description("emailFieldAlreadyRegisteredName")
    @Story("Create an account")
    public void emailFieldAlreadyRegisteredName() {
        Assert.assertEquals(signInPageNew.emailAddressFieldAlreadyRegisteredTitle(),
                signInPageNew.EXPECTED_EMAIL_ADDRESS_FIELD_ALREADY_REGISTERED_NAME);
    }

    @Test (priority = 0, description = "passwordFieldAlreadyRegisteredName")
    @Severity(SeverityLevel.MINOR)
    @Description("passwordFieldAlreadyRegisteredName")
    @Story("Create an account")
    public void passwordFieldAlreadyRegisteredName() {
        Assert.assertEquals(signInPageNew.passwordFieldAlreadyRegisteredName(),
                signInPageNew.EXPECTED_PASSWORD_FIELD_ALREADY_REGISTERED_NAME);
    }

    @Test (priority = 0, description = "signInButtonAlreadyRegisteredName")
    @Severity(SeverityLevel.NORMAL)
    @Description("signInButtonAlreadyRegisteredName")
    @Story("Create an account")
    public void signInButtonAlreadyRegisteredName() {
        Assert.assertEquals(signInPageNew.signInAlreadyRegisteredButtonFind(),
                signInPageNew.EXPECTED_SIGN_IN_ALREADY_REGISTERED_BUTTON_NAME);
    }

    @Test (priority = 0, description = "signInButtonClick")
    @Severity(SeverityLevel.MINOR)
    @Description("signInButtonClick")
    @Story("Create an account")
    public void signInButtonClick() throws InterruptedException {
        signInPageNew.clickSignInHeaderButton();
        Thread.sleep(5000);
    }

    @Test (priority = 0, description = "forgotYourPasswordButtonName")
    @Severity(SeverityLevel.NORMAL)
    @Description("forgotYourPasswordButtonName")
    @Story("Create an account")
    public void forgotYourPasswordButtonName() {
        Assert.assertEquals(signInPageNew.forgotYourPasswordFind(), signInPageNew.EXPECTED_FORGOT_YOUR_PASSWORD_NAME);
    }

    @Test (priority = 0, description = "invalidEmailMessageAlreadyRegistered")
    @Severity(SeverityLevel.MINOR)
    @Description("invalidEmailMessageAlreadyRegistered")
    @Story("Create an account")
    public void invalidEmailMessageAlreadyRegistered() throws InterruptedException {
        signInPageNew.inputEmailInvalidAlreadyRegistered().signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.invalidMessageAlreadyRegisteredFirstText(),
                signInPageNew.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST);
        System.out.println("The text of message is " + '"'
                + signInPageNew.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');

        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidMessageAlreadyRegisteredSecondText(),
                signInPageNew.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS);
        System.out.println("The text of message is " + '"'
                + signInPageNew.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS + '"');
    }

    @Test (priority = 0, description = "invalidEmptyEmailMessageAlreadyRegistered")
    @Severity(SeverityLevel.NORMAL)
    @Description("invalidEmptyEmailMessageAlreadyRegistered")
    @Story("Create an account")
    public void invalidEmptyEmailMessageAlreadyRegistered() throws InterruptedException {
        signInPageNew.signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidMessageAlreadyRegisteredFirstText(),
                signInPageNew.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST);
        System.out.println("The text of message is " + '"'
                + signInPageNew.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');

        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.invalidMessageAlreadyRegisteredSecondText(),
                signInPageNew.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY);
        System.out.println("The text of message is " + '"'
                + signInPageNew.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY + '"');
    }

    @Test (priority = 0, description = "invalidPasswordMessageAlreadyRegistered")
    @Severity(SeverityLevel.CRITICAL)
    @Description("invalidPasswordMessageAlreadyRegistered")
    @Story("Create an account")
    public void invalidPasswordMessageAlreadyRegistered() throws InterruptedException {
        String email = "qwe@gmail.com";
        signInPageNew.inputEmailAlreadyRegistered(email);
        Thread.sleep(5000);

        signInPageNew.inputPasswordInvalidAlreadyRegistered().signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidMessageAlreadyRegisteredFirstText(),
                signInPageNew.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST);
        System.out.println("The text of message is " + '"'
                + signInPageNew.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidMessageAlreadyRegisteredSecondText(),
                signInPageNew.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS);
        System.out.println("The text of message is " + '"'
                + signInPageNew.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS + '"');
    }

    @Test (priority = 0, description = "missedPasswordMessageAlreadyRegistered")
    @Severity(SeverityLevel.MINOR)
    @Description("missedPasswordMessageAlreadyRegistered")
    @Story("Create an account")
    public void missedPasswordMessageAlreadyRegistered() throws InterruptedException {
        String email = "qwe@gmail.com";
        signInPageNew.inputEmailAlreadyRegistered(email);
        Thread.sleep(5000);

        //signInPage.inputPasswordInvalidAlreadyRegistered();
        signInPageNew.signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidMessageAlreadyRegisteredFirstText(),
                signInPageNew.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST);
        System.out.println("The text of message is " + '"'
                + signInPageNew.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidMessageAlreadyRegisteredSecondText(),
                signInPageNew.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY);
        System.out.println("The text of message is " + '"'
                + signInPageNew.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY + '"');
    }

    @Test (priority = 0, description = "mismatchedPasswordMessageAlreadyRegistered")
    @Severity(SeverityLevel.CRITICAL)
    @Description("mismatchedPasswordMessageAlreadyRegistered")
    @Story("Create an account")
    public void mismatchedPasswordMessageAlreadyRegistered() throws InterruptedException {
        String email = "qwe@gmail.com";
        signInPageNew.inputEmailAlreadyRegistered(email);
        Thread.sleep(5000);

        signInPageNew.inputPasswordAlreadyRegistered(email).signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidMessageAlreadyRegisteredFirstText(),
                signInPageNew.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST);
        System.out.println("The text of message is " + '"'
                + signInPageNew.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidMessageAlreadyRegisteredSecondText(),
                signInPageNew.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_MISMATCHED);
        System.out.println("The text of message is " + '"'
                + signInPageNew.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_MISMATCHED + '"');
    }

    @Test (priority = 0, description = "createAnAccountPersonalInfoTitle")
    @Severity(SeverityLevel.MINOR)
    @Description("createAnAccountPersonalInfoTitle")
    @Story("Create an account")
    public void createAnAccountPersonalInfoTitle() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.createAnAccountPersonalInfoTitle(),
                signInPageNew.CREATE_AN_ACCOUNT_PERSONAL_INFO_TITLE);
    }

    @Test (priority = 0, description = "yourPersonalInfoSectionTitle")
    @Severity(SeverityLevel.MINOR)
    @Description("yourPersonalInfoSectionTitle")
    @Story("Create an account")
    public void yourPersonalInfoSectionTitle() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.yourPersonalInfoSectionTitle(), signInPageNew.YOUR_PERSONAL_INFO_SECTION_TITLE);
    }

    @Test (priority = 0, description = "yourPersonalInfoTitle")
    @Severity(SeverityLevel.MINOR)
    @Description("yourPersonalInfoTitle")
    @Story("Create an account")
    public void yourPersonalInfoTitle() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.yourPersonalInfoTitle(), signInPageNew.YOUR_PERSONAL_INFO_TITLE);
    }

    @Test (priority = 0, description = "mrRadioButtonDisplayed")
    @Severity(SeverityLevel.MINOR)
    @Description("mrRadioButtonDisplayed")
    @Story("Create an account")
    public void mrRadioButtonDisplayed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.mrRadioButtonDisplayed());
    }

    @Test (priority = 0, description = "mrRadioButtonEnabled")
    @Severity(SeverityLevel.MINOR)
    @Description("mrRadioButtonEnabled")
    @Story("Create an account")
    public void mrRadioButtonEnabled() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        signInPageNew.mrRadioButtonEnabled();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.mrRadioButtonEnabled());
    }

    @Test (priority = 0, description = "")
    @Severity(SeverityLevel.MINOR)
    @Description("")
    @Story("Create an account")
    public void mrsRadioButtonDisplayed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.mrsRadioButtonDisplayed());
    }

    @Test (priority = 0, description = "mrsRadioButtonEnabled")
    @Severity(SeverityLevel.MINOR)
    @Description("mrsRadioButtonEnabled")
    @Story("Create an account")
    public void mrsRadioButtonEnabled() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.mrsRadioButtonEnabled());
    }

    @Test (priority = 0, description = "selectedStatusMrRadioButton")
    @Severity(SeverityLevel.MINOR)
    @Description("selectedStatusMrRadioButton")
    @Story("Create an account")
    public void selectedStatusMrRadioButton() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPageNew.clickMrRadioButton();
        Assert.assertTrue(signInPageNew.selectedStatusMr());
    }

    @Test (priority = 0, description = "selectedStatusMrsRadioButton")
    @Severity(SeverityLevel.MINOR)
    @Description("selectedStatusMrsRadioButton")
    @Story("Create an account")
    public void selectedStatusMrsRadioButton() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPageNew.clickMrsRadioButton();

        Assert.assertTrue(signInPageNew.selectedStatusMrs());
    }

    @Test (priority = 0, description = "selectDropDown") //passed *** corrupted, java.util. had to be added
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDown")
    @Story("Create an account")
    public void selectDropDown() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        //selecting the dropdown element by locating its id
        Select select = new Select(driver.findElement(By.xpath("//*[@id='days']")));

        //Get list of web elements of the dropdown
        List<WebElement> lst = select.getOptions();

        //Looping through the options and printing dropdown options
        System.out.println("The dropdown options are:");
        for (WebElement options : lst)
            System.out.println(options.getText());

        //Selecting the option as '4'-- selectByIndex
        System.out.println("Select the Option by Index 4");
        select.selectByIndex(4);
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Selecting the option as '-'-- selectByVisibleText
        System.out.println("Select the Option by Text -");
        select.selectByVisibleText("-");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Selecting an option by its value
        System.out.println("Select the Option by value 6");
        select.selectByValue("6");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());
    }

    @Test (priority = 0, description = "selectDropDownDaysAll")
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDownDaysAll")
    @Story("Create an account")
    public void selectDropDownDaysAll() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPageNew.dropDownDaysAllOptions();
        int[] expected = signInPageNew.DROPDOWN_DAYS;
        int index = generateRandomIntInRange(0, expected.length - 1);
        Assert.assertEquals(actual, expected);
        Assert.assertEquals(actual[index], expected[index]);
        System.out.println("*********" + index + " " + actual[index] + " " + expected[index]);
    }

    @Test (priority = 0, description = "selectDropDownDaysOption")
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDownDaysOption")
    @Story("Create an account")
    public void selectDropDownDaysOption() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPageNew.dropDownDaysAllOptions();
        int[] expected = signInPageNew.DROPDOWN_DAYS;

        Assert.assertEquals(actual.length, expected.length, "Compare list length");
        // update with stream
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(actual[i], expected[i]);
        }
    }

    @Test (priority = 0, description = "selectDropDownDaysOptionOneByOne")
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDownDaysOptionOneByOne")
    @Story("Create an account")
    public void selectDropDownDaysOptionOneByOne() throws InterruptedException {
        int amountOfDays = 31;
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPageNew.dropDownDaysAllOptions();

        for (int i = 0; i < amountOfDays; i++) {
            int tmp = i;
            Assert.assertEquals(actual[i], tmp + 1);
        }
    }

    @Test (priority = 0, description = "selectDropDownDaysOptionByValue") // Question: how to check all options value one by one?
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDownDaysOptionByValue")
    @Story("Create an account")
    public void selectDropDownDaysOptionByValue() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPageNew.selectDropDownDaysOptionByValue();
    }

    @Test (priority = 0, description = "selectDropDownMonthsAllOptionsByIndex") //  *** was corrupted when actual and expected were written separately as variables with List<String>
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDownMonthsAllOptionsByIndex")
    @Story("Create an account")
    public void selectDropDownMonthsAllOptionsByIndex() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int index = generateRandomIntInRange(0, signInPageNew.DROPDOWN_MONTHS.size() - 1);
        Assert.assertEquals(signInPageNew.dropDownMonthsAllOptions().get(index), signInPageNew.DROPDOWN_MONTHS.get(index));
        System.out.println("*********" + index + " " + signInPageNew.dropDownMonthsAllOptions().get(index)
                + " " + signInPageNew.DROPDOWN_MONTHS.get(index));
    }

    @Test (priority = 0, description = "selectDropDownMonthsAllOption") //  *** corrupted when actual and expected were written separately as variables with List<String>
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDownMonthsAllOption")
    @Story("Create an account")
    public void selectDropDownMonthsAllOption() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.dropDownMonthsAllOptions(), signInPageNew.DROPDOWN_MONTHS);
        System.out.println("*********" + signInPageNew.dropDownMonthsAllOptions()
                + " \n " + signInPageNew.DROPDOWN_MONTHS);
    }

    @Test (priority = 0, description = "selectDropDownYearsAll")
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDownYearsAll")
    @Story("Create an account")
    public void selectDropDownYearsAll() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPageNew.dropDownYearsAllOptions();
        int[] expected = signInPageNew.DROPDOWN_YEARS;
        int index = generateRandomIntInRange(0, expected.length - 1);
        Assert.assertEquals(actual, expected);
        Assert.assertEquals(actual[index], expected[index]);
        System.out.println("*********" + index + " " + actual[index] + " " + expected[index]);
    }

    @Test (priority = 0, description = "selectDropDownYearsOption")
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDownYearsOption")
    @Story("Create an account")
    public void selectDropDownYearsOption() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPageNew.dropDownYearsAllOptions();
        int[] expected = signInPageNew.DROPDOWN_YEARS;

        Assert.assertEquals(actual.length, expected.length, "Compare list length");
        // update with stream
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(actual[i], expected[i]);
        }
    }

    @Test (priority = 0, description = "checkEmailFieldIfNotEmpty")
    @Severity(SeverityLevel.MINOR)
    @Description("checkEmailFieldIfNotEmpty")
    @Story("Create an account")
    public void checkEmailFieldIfNotEmpty() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.emptyFieldEmail(), false);
        System.out.println(signInPageNew.emptyFieldEmail());
    }

    @Test (priority = 0, description = "checkEmailFieldValue")
    @Severity(SeverityLevel.MINOR)
    @Description("checkEmailFieldValue")
    @Story("Create an account")
    public void checkEmailFieldValue() throws InterruptedException {
        signInPageNew.inputEmail();
        Thread.sleep(5000);
        String newEmail = signInPageNew.valueOfEmailFieldHomePage();

        signInPageNew.createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.valueOfEmailField(), newEmail);
        System.out.println(signInPageNew.valueOfEmailField());
    }

    @Test (priority = 0, description = "deleteEmailValue")
    @Severity(SeverityLevel.MINOR)
    @Description("deleteEmailValue")
    @Story("Create an account")
    public void deleteEmailValue() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPageNew.deleteValueEmail();
        Assert.assertEquals(signInPageNew.emptyFieldEmail(), true);
    }

    @Test (priority = 0, description = "countryDropDownFirstOption")
    @Severity(SeverityLevel.MINOR)
    @Description("countryDropDownFirstOption")
    @Story("Create an account")
    public void countryDropDownFirstOption() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.countryDropDownFirstOption(), "-");
    }

    @Test (priority = 0, description = "errorAlertIs")
    @Severity(SeverityLevel.MINOR)
    @Description("errorAlertIs")
    @Story("Create an account")
    public void errorAlertIs() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.deleteValueEmail();
        signInPageNew.countryDropDownFirstOption();
        signInPageNew.clickRegisterButton();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.errorAlertDisplayed());
    }

    @Test (priority = 0, description = "errorAlertText")
    @Severity(SeverityLevel.MINOR)
    @Description("errorAlertText")
    @Story("Create an account")
    public void errorAlertText() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.deleteValueEmail();
        signInPageNew.countryDropDownFirstOption();
        Thread.sleep(5000);
        signInPageNew.clickRegisterButton();

        String actual = signInPageNew.errorAlertText();;
        System.out.println("result:" + "\n" + actual);

        Assert.assertEquals(actual, signInPageNew.ALERT_ERROR);
    }

    @Test (priority = 0, description = "signUpCheckBoxEnabled")
    @Severity(SeverityLevel.MINOR)
    @Description("signUpCheckBoxEnabled")
    @Story("Create an account")
    public void signUpCheckBoxEnabled() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.signUpCheckBox());
    }

    @Test (priority = 0, description = "signUpCheckBoxClickAndSelected")
    @Severity(SeverityLevel.MINOR)
    @Description("signUpCheckBoxClickAndSelected")
    @Story("Create an account")
    public void signUpCheckBoxClickAndSelected() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.clickSignUpCheckBox();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.selectedSignUpCheckBox(), "not correct");
    }

    @Test (priority = 0, description = "signUpCheckBoxName")
    @Severity(SeverityLevel.MINOR)
    @Description("signUpCheckBoxName")
    @Story("Create an account")
    public void signUpCheckBoxName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.signUpCheckBoxName(), signInPageNew.SIGNUP_CHECKBOX, "signUpCheckBoxName is not correct");
    }

    @Test (priority = 0, description = "offersCheckBoxEnabled")
    @Severity(SeverityLevel.MINOR)
    @Description("offersCheckBoxEnabled")
    @Story("Create an account")
    public void offersCheckBoxEnabled() {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Assert.assertTrue(signInPageNew.offersCheckBox());
    }

    @Test (priority = 0, description = "offersCheckBoxName")
    @Severity(SeverityLevel.MINOR)
    @Description("offersCheckBoxName")
    @Story("Create an account")
    public void offersCheckBoxName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.offersCheckBoxName(),
                signInPageNew.OFFERS_CHECKBOX, "offersCheckBoxName is not correct");
    }

    @Test (priority = 0, description = "offersCheckBoxClickAndSelected")
    @Severity(SeverityLevel.MINOR)
    @Description("offersCheckBoxClickAndSelected")
    @Story("Create an account")
    public void offersCheckBoxClickAndSelected() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.clickOffersCheckBox();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.selectedOffersCheckBox());
    }

    @Test (priority = 0, description = "firsNameOneFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("firsNameOneFieldName")
    @Story("Create an account")
    public void firsNameOneFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.firstNameFieldOneName(), signInPageNew.FIRSTNAME_FIELD);
    }

    @Test (priority = 0, description = "lastNameTwoFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("lastNameTwoFieldName")
    @Story("Create an account")
    public void lastNameTwoFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.lastNameFieldTOneName(), signInPageNew.LASTNAME_FIELD);
    }

    @Test (priority = 0, description = "firsNameTwoFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("firsNameTwoFieldName")
    @Story("Create an account")
    public void firsNameTwoFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.firstNameFieldTwoName(), signInPageNew.FIRSTNAME_FIELD);
    }

    @Test (priority = 0, description = "lastNameOneFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("lastNameOneFieldName")
    @Story("Create an account")
    public void lastNameOneFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.lastNameFieldTwoName(), signInPageNew.LASTNAME_FIELD);
    }

    @Test (priority = 0, description = "emailFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("emailFieldName")
    @Story("Create an account")
    public void emailFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.emailFieldName(), signInPageNew.EMAIL_FIELD);
    }

    @Test (priority = 0, description = "passwordFieldName") // time to time is failed with different results of field name
    @Severity(SeverityLevel.MINOR)
    @Description("passwordFieldName")
    @Story("Create an account")
    public void passwordFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.passwordFieldName(), signInPageNew.PASSWORD_FIELD);
    }

    @Test (priority = 0, description = "passwordFieldHelpText")
    @Severity(SeverityLevel.MINOR)
    @Description("passwordFieldHelpText")
    @Story("Create an account")
    public void passwordFieldHelpText() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.passwordFieldHelpText(), signInPageNew.PASSWORD_FIELD_HELP_TEXT);
    }

    @Test (priority = 0, description = "dateOfBirthFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("dateOfBirthFieldName")
    @Story("Create an account")
    public void dateOfBirthFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.dateOfBirthFieldName(), signInPageNew.DATE_OF_BIRTH_FIELD);
    }

    @Test (priority = 0, description = "yourAddressSectionName")
    @Severity(SeverityLevel.MINOR)
    @Description("yourAddressSectionName")
    @Story("Create an account")
    public void yourAddressSectionName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.yourAddressSectionName(), signInPageNew.YOUR_ADDRESS_SECTION.toUpperCase());
    }

    @Test (priority = 0, description = "companyFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("companyFieldName")
    @Story("Create an account")
    public void companyFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.companyFieldName(), signInPageNew.COMPANY_FIELD);
    }

    @Test (priority = 0, description = "addressFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("addressFieldName")
    @Story("Create an account")
    public void addressFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.addressFieldName(), signInPageNew.ADDRESS_FIELD);
    }

    @Test (priority = 0, description = "addressFieldHelpText")
    @Severity(SeverityLevel.MINOR)
    @Description("addressFieldHelpText")
    @Story("Create an account")
    public void addressFieldHelpText() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.addressFieldHelpText(), signInPageNew.ADDRESS_HELP_TEXT);
    }

    @Test (priority = 0, description = "cityFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("cityFieldName")
    @Story("Create an account")
    public void cityFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.cityFieldName(), signInPageNew.CITY_FIELD);
    }

    @Test (priority = 0, description = "countryFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("countryFieldName")
    @Story("Create an account")
    public void countryFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.countryFieldName(), signInPageNew.COUNTRY_FIELD);
    }

    @Test (priority = 0, description = "selectDropDownStatesAllOptionsByIndex")
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDownStatesAllOptionsByIndex")
    @Story("Create an account")
    public void selectDropDownStatesAllOptionsByIndex() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int index = generateRandomIntInRange(0, signInPageNew.STATES.size() - 1);
        Assert.assertEquals(signInPageNew.dropDownStatesAllOptions().get(index), signInPageNew.STATES.get(index));
        System.out.println("*********" + index + " " + signInPageNew.dropDownStatesAllOptions().get(index)
                + " " + signInPageNew.STATES.get(index));
    }

    @Test (priority = 0, description = "selectDropDownStatesAllOption")
    @Severity(SeverityLevel.MINOR)
    @Description("selectDropDownStatesAllOption")
    @Story("Create an account")
    public void selectDropDownStatesAllOption() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.dropDownStatesAllOptions(), signInPageNew.STATES);
        System.out.println("*********" + signInPageNew.dropDownStatesAllOptions()
                + " \n " + signInPageNew.STATES);
    }

    @Test (priority = 0, description = "additionalInfoFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("additionalInfoFieldName")
    @Story("Create an account")
    public void additionalInfoFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.additionalInfoFieldName(), signInPageNew.ADDITIONAL_INFORMATION_FIELD);
    }

    @Test (priority = 0, description = "additionalInfoHelpText")
    @Severity(SeverityLevel.MINOR)
    @Description("additionalInfoHelpText")
    @Story("Create an account")
    public void additionalInfoHelpText() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.additionalInfoHelpText(), signInPageNew.ADDITIONAL_INFORMATION_HELP_TEXT);
    }

    @Test (priority = 0, description = "homePhoneFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("homePhoneFieldName")
    @Story("Create an account")
    public void homePhoneFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.homePhoneFieldName(), signInPageNew.HOME_PHONE_FIELD);
    }

    @Test (priority = 0, description = "mobilePhoneFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("mobilePhoneFieldName")
    @Story("Create an account")
    public void mobilePhoneFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.mobilePhoneFieldName(), signInPageNew.MOBILE_PHONE_FIELD);
    }

    @Test (priority = 0, description = "assignAliasFieldName")
    @Severity(SeverityLevel.MINOR)
    @Description("assignAliasFieldName")
    @Story("Create an account")
    public void assignAliasFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.assignAliasFieldName(), signInPageNew.ASSIGN_ADDRESS_ALIAS_FIELD);
    }

    @Test (priority = 0, description = "valueOfAddressAliasField")
    @Severity(SeverityLevel.MINOR)
    @Description("valueOfAddressAliasField")
    @Story("Create an account")
    public void valueOfAddressAliasField() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.assignAliasFieldValue(), signInPageNew.ASSIGN_ADDRESS_ALIAS_VALUE);
    }

    @Test (priority = 0, description = "registerButtonName")
    @Severity(SeverityLevel.MINOR)
    @Description("registerButtonName")
    @Story("Create an account")
    public void registerButtonName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.registerButtonName(), signInPageNew.REGISTER_BUTTON);
    }

    @Test (priority = 0, description = "requiredText")
    @Severity(SeverityLevel.MINOR)
    @Description("requiredText")
    @Story("Create an account")
    public void requiredText() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.requiredText(), signInPageNew.REQUIRED_TEXT);
    }

    /**
     * Check if the system verifies the invalid input in the FirstName field
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test (priority = 0, description = "firstNameFieldWithDigits") //probably bad design. Question about loop. I'd like to empty all fields one by one and then work only
    // with one field. Should I write if for each field separately
    @Severity(SeverityLevel.MINOR)
    @Description("firstNameFieldWithDigits")
    @Story("Create an account")
    public void firstNameFieldWithDigits() throws InterruptedException, AWTException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
//        if (signInPage.emptyFieldFirstName() == false) {
//            signInPage.deleteValueFirstName();
//        } else if (signInPage.emptyFieldLastName() != true) {
//            signInPage.deleteValueLastName();
//        } else if (signInPage.emptyFieldPassword() == false) {
//            signInPage.deleteValuePassword();
//        } else {
        Assert.assertTrue(signInPageNew.deleteValueFirstName(), "Verify that FirstName is empty");
        signInPageNew.inputValueFirstNameDigits();
        generalSeleniumMethods.clickAnyWhere();
        Assert.assertTrue(signInPageNew.redSignDisplayed());
    }


    /**
     * Check if the system verifies the correctness of input in the FirstName field
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test (priority = 0, description = "firstNameFieldWithLetters")
    @Severity(SeverityLevel.MINOR)
    @Description("firstNameFieldWithLetters")
    @Story("Create an account")
    public void firstNameFieldWithLetters() throws InterruptedException, AWTException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.deleteValueFirstName(), "Verify that FirstName is empty");
        signInPageNew.inputValueFirstNameLetters();
        generalSeleniumMethods.clickAnyWhere();
        Assert.assertTrue(signInPageNew.greenSignDisplayed());
    }

    /**
     * Check if the system verifies the invalid input in the LastName field
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test (priority = 0, description = "lastNameFieldWithDigits")
    @Severity(SeverityLevel.MINOR)
    @Description("lastNameFieldWithDigits")
    @Story("Create an account")
    public void lastNameFieldWithDigits() throws InterruptedException, AWTException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.deleteValueLastName(), "Verify that LastName is empty");
        signInPageNew.inputValueLastNameDigits();
        generalSeleniumMethods.clickAnyWhere();
        Assert.assertTrue(signInPageNew.redSignDisplayed());
    }

    /**
     * Check if the system verifies the correctness of input in the LastName field
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test (priority = 0, description = "lastNameFieldWithLetters")
    @Severity(SeverityLevel.MINOR)
    @Description("lastNameFieldWithLetters")
    @Story("Create an account")
    public void lastNameFieldWithLetters() throws InterruptedException, AWTException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.deleteValueLastName(), "Verify that LastName is empty");
        signInPageNew.inputValueLastNameLetters();
        generalSeleniumMethods.clickAnyWhere();
        Assert.assertTrue(signInPageNew.greenSignDisplayed());
    }

    /**
     * Check if the system verifies the invalid input in the Email field
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test (priority = 0, description = "emailFieldWithAlphaNumeric")
    @Severity(SeverityLevel.MINOR)
    @Description("emailFieldWithAlphaNumeric")
    @Story("Create an account")
    public void emailFieldWithAlphaNumeric() throws InterruptedException, AWTException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        if (signInPageNew.emptyFieldEmail() == false) {
            signInPageNew.deleteValueEmail();
        }
        signInPageNew.inputValueAlphaNumericEmail();
        generalSeleniumMethods.clickAnyWhere();
        Assert.assertTrue(signInPageNew.redSignDisplayed());
    }

    @Test (priority = 0, description = "emailFieldWithLetters")
    @Severity(SeverityLevel.MINOR)
    @Description("emailFieldWithLetters")
    @Story("Create an account")
    public void emailFieldWithLetters() throws InterruptedException, AWTException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        if (signInPageNew.emptyFieldEmail() == false) {
            signInPageNew.deleteValueEmail();
        }
        signInPageNew.inputValueAlphaNumericEmail();
        generalSeleniumMethods.clickAnyWhere();
        Assert.assertTrue(signInPageNew.redSignDisplayed());
    }

    @Test (priority = 0, description = "emailFieldWithCorrectEmail")
    @Severity(SeverityLevel.MINOR)
    @Description("emailFieldWithCorrectEmail")
    @Story("Create an account")
    public void emailFieldWithCorrectEmail() throws InterruptedException, AWTException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        if (signInPageNew.emptyFieldEmail() == false) {
            signInPageNew.deleteValueEmail();
        }
        signInPageNew.inputEmailAuthorization();
        generalSeleniumMethods.clickAnyWhere();
        Assert.assertTrue(signInPageNew.greenSignDisplayed());
    }

    @Test (priority = 0, description = "firstNameFieldsAreEqual")
    @Severity(SeverityLevel.MINOR)
    @Description("firstNameFieldsAreEqual")
    @Story("Create an account")
    public void firstNameFieldsAreEqual() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueFirstNameLetters();
        Assert.assertEquals(signInPageNew.valueOfFirstNameOneField(),
                signInPageNew.valueOfFirstNameTwoField());
        System.out.println("first field" + "\n" + (signInPageNew.valueOfFirstNameOneField()
                + "\n" + "second field" + "\n" + (signInPageNew.valueOfFirstNameOneField())));
    }

    @Test (priority = 0, description = "lastNameFieldsAreEqual")
    @Severity(SeverityLevel.MINOR)
    @Description("lastNameFieldsAreEqual")
    @Story("Create an account")
    public void lastNameFieldsAreEqual() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueLastNameLetters();
        Assert.assertEquals(signInPageNew.valueOfLastNameOneField(),
                signInPageNew.valueOfLastNameTwoField());
        System.out.println("first field" + "\n" + (signInPageNew.valueOfLastNameOneField()
                + "\n" + "second field" + "\n" + (signInPageNew.valueOfLastNameOneField())));
    }

    @Test (priority = 0, description = "companyFieldAllowed")
    @Severity(SeverityLevel.MINOR)
    @Description("companyFieldAllowed")
    @Story("Create an account")
    public void companyFieldAllowed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueFirstNameLetters();
        signInPageNew.inputValueLastNameLetters();
        signInPageNew.inputValuePassword("123456");
        signInPageNew.inputValueAllowedAddress();
        signInPageNew.inputValueAllowedCity();
        signInPageNew.statesDropDownOptionByValue();
        signInPageNew.inputValueAllowedZip();
        signInPageNew.inputValueAllowedPhone();
        signInPageNew.inputValueAllowedMobile();

        signInPageNew.inputValueAllowedCompany();
        signInPageNew.clickRegisterButton();
        Assert.assertEquals(signInPageNew.actualUrlFind(), signInPageNew.MY_ACCOUNT_URL);

        System.out.println("result" + "\n" + (signInPageNew.actualUrlFind()));
    }

    @Test (priority = 0, description = "customerAccountDisplayed")
    @Severity(SeverityLevel.MINOR)
    @Description("customerAccountDisplayed")
    @Story("Create an account")
    public void customerAccountDisplayed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueFirstNameLetters();
        signInPageNew.inputValueLastNameLetters();
        signInPageNew.inputValueAllowedCompany();
        signInPageNew.inputValuePassword("123456");
        signInPageNew.inputValueAllowedAddress();
        signInPageNew.inputValueAllowedCity();
        Thread.sleep(5000);
        signInPageNew.statesDropDownOptionByValue();
        signInPageNew.inputValueAllowedZip();
        signInPageNew.inputValueAllowedPhone();
        signInPageNew.inputValueAllowedMobile();

        String actual = signInPageNew.valueOfFirstNameOneField() + ' ' + signInPageNew.valueOfLastNameOneField();

        signInPageNew.clickRegisterButton();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.customerAccountDisplayed());
        Assert.assertEquals(actual,
                signInPageNew.customerAccountText());

    }

    @Test (priority = 0, description = "companyFieldNotAllowed")
    @Severity(SeverityLevel.MINOR)
    @Description("companyFieldNotAllowed")
    @Story("Create an account")
    public void companyFieldNotAllowed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueFirstNameLetters();
        signInPageNew.inputValueLastNameLetters();
        signInPageNew.inputValuePassword("123456");
        signInPageNew.inputValueNotAllowedCompany();
        signInPageNew.inputValueAllowedAddress();
        signInPageNew.inputValueAllowedCity();
        signInPageNew.statesDropDownOptionByValue();
        signInPageNew.inputValueAllowedZip();
        signInPageNew.inputValueAllowedPhone();
        signInPageNew.inputValueAllowedMobile();

        signInPageNew.clickRegisterButton();
        Assert.assertTrue(signInPageNew.errorInputDisplayed());
        Assert.assertEquals(signInPageNew.errorInputIsInvalid(),
                "company is invalid.");
        System.out.println("Company field" + "\n" + (signInPageNew.errorInputIsInvalid()));
    }

    @Test (priority = 0, description = "firstNameFieldNotAllowedError")
    @Severity(SeverityLevel.MINOR)
    @Description("firstNameFieldNotAllowedError")
    @Story("Create an account")
    public void firstNameFieldNotAllowedError() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPageNew.clickRegisterButton();
        List<String> fullSetOfErrors = signInPageNew.getListOfOptions();
        //fullSetOfErrors.forEach(System.out::println);

        List<String> filteredList = new ArrayList<>();
        for (String errors : filteredList) {
            if (errors.contains("firstname")) ;
            System.out.println(filteredList);
        }
    }

    @Test (priority = 0, description = "addressFieldNotAllowed")
    @Severity(SeverityLevel.MINOR)
    @Description("addressFieldNotAllowed")
    @Story("Create an account")
    public void addressFieldNotAllowed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueFirstNameLetters();
        signInPageNew.inputValueLastNameLetters();
        signInPageNew.inputValuePassword("123456");
        signInPageNew.inputValueAllowedCompany();
        signInPageNew.inputValueAllowedCity();
        signInPageNew.statesDropDownOptionByValue();
        signInPageNew.inputValueAllowedZip();
        signInPageNew.inputValueAllowedPhone();
        signInPageNew.inputValueAllowedMobile();

        signInPageNew.inputValueNotAllowedAddress();
        signInPageNew.clickRegisterButton();
        Assert.assertTrue(signInPageNew.errorInputDisplayed());
        Assert.assertEquals(signInPageNew.errorInputIsInvalid(),
                "address1 is invalid.");
        System.out.println("Address field" + "\n" + (signInPageNew.errorInputIsInvalid()));
    }

    @Test (priority = 0, description = "cityFieldNotAllowed")
    @Severity(SeverityLevel.MINOR)
    @Description("cityFieldNotAllowed")
    @Story("Create an account")
    public void cityFieldNotAllowed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueFirstNameLetters();
        signInPageNew.inputValueLastNameLetters();
        signInPageNew.inputValuePassword("123456");
        signInPageNew.inputValueAllowedCompany();
        signInPageNew.inputValueAllowedAddress();
        signInPageNew.statesDropDownOptionByValue();
        signInPageNew.inputValueAllowedZip();
        signInPageNew.inputValueAllowedPhone();
        signInPageNew.inputValueAllowedMobile();

        signInPageNew.inputValueNotAllowedCity();
        signInPageNew.clickRegisterButton();
        Assert.assertTrue(signInPageNew.errorInputDisplayed());
        Assert.assertEquals(signInPageNew.errorInputIsInvalid(),
                "city is invalid.");
        System.out.println("City field" + "\n" + (signInPageNew.errorInputIsInvalid()));
    }

    @Test (priority = 0, description = "statesFieldNotAllowed")
    @Severity(SeverityLevel.MINOR)
    @Description("statesFieldNotAllowed")
    @Story("Create an account")
    public void statesFieldNotAllowed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueFirstNameLetters();
        signInPageNew.inputValueLastNameLetters();
        signInPageNew.inputValuePassword("123456");
        signInPageNew.inputValueAllowedCompany();
        signInPageNew.inputValueAllowedAddress();
        signInPageNew.inputValueAllowedCity();
        signInPageNew.inputValueAllowedZip();
        signInPageNew.inputValueAllowedPhone();
        signInPageNew.inputValueAllowedMobile();

        signInPageNew.statesDropDownOptionFirst();
        signInPageNew.clickRegisterButton();
        Assert.assertTrue(signInPageNew.errorInputRequiresDisplayed());
        Assert.assertEquals(signInPageNew.errorInputRequires(),
                "This country requires you to choose a State.");
        System.out.println("City field" + "\n" + (signInPageNew.errorInputRequires()));
    }

    @Test (priority = 0, description = "phoneFieldNotAllowed")
    @Severity(SeverityLevel.MINOR)
    @Description("phoneFieldNotAllowed")
    @Story("Create an account")
    public void phoneFieldNotAllowed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueFirstNameLetters();
        signInPageNew.inputValueLastNameLetters();
        signInPageNew.inputValuePassword("123456");
        signInPageNew.inputValueAllowedCompany();
        signInPageNew.inputValueAllowedAddress();
        signInPageNew.statesDropDownOptionByValue();
        signInPageNew.inputValueAllowedZip();
        signInPageNew.inputValueAllowedCity();
        signInPageNew.inputValueAllowedMobile();

        signInPageNew.inputValueNotAllowedPhone();
        signInPageNew.clickRegisterButton();
        Assert.assertTrue(signInPageNew.errorInputDisplayed());
        Assert.assertEquals(signInPageNew.errorInputIsInvalid(),
                "phone is invalid.");
        System.out.println("Phone field" + "\n" + (signInPageNew.errorInputIsInvalid()));
    }

    @Test (priority = 0, description = "phoneFieldsEmpty")
    @Severity(SeverityLevel.MINOR)
    @Description("phoneFieldsEmpty")
    @Story("Create an account")
    public void phoneFieldsEmpty() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueFirstNameLetters();
        signInPageNew.inputValueLastNameLetters();
        signInPageNew.inputValuePassword("123456");
        signInPageNew.inputValueAllowedCompany();
        signInPageNew.inputValueAllowedAddress();
        signInPageNew.inputValueAllowedCity();
        signInPageNew.statesDropDownOptionByValue();
        signInPageNew.inputValueAllowedZip();

        signInPageNew.clickRegisterButton();
        Assert.assertTrue(signInPageNew.errorInputEmptyField());
        Assert.assertEquals(signInPageNew.errorInputEmptyFieldError(),
                "You must register at least one phone number.");
        System.out.println("Phone field" + "\n" + (signInPageNew.errorInputEmptyFieldError()));
    }

    @Test (priority = 0, description = "phoneFieldsEmptyText")
    @Severity(SeverityLevel.MINOR)
    @Description("phoneFieldsEmptyText")
    @Story("Create an account")
    public void phoneFieldsEmptyText() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.clickRegisterButton();
        Assert.assertTrue(signInPageNew.errorInputEmptyPhoneTextDisplayed());
        Assert.assertEquals(signInPageNew.errorInputEmptyPhoneText(),
                "You must register at least one phone number.");
        System.out.println("Phone field text" + "\n" + (signInPageNew.errorInputEmptyPhoneText()));
    }
}

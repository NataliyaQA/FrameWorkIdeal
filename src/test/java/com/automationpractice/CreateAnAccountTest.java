package com.automationpractice;

import businessLogic.BusinessLogic;
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

    @Test  //passed
    public void checkClickSignInMainPage() {
        driver.get(stringUrlMainPage);
        signInPageNew.clickSignInHeaderButton();
        Assert.assertEquals(signInPageNew.actualUrlFind(), signInPageNew.EXPECTED_URL);
        System.out.println("Expected Url is correct");
    }

    @Test  //passed
    public void checkClickSignInAccountPage() throws InterruptedException {
        Thread.sleep(5000);
        signInPageNew.clickSignInHeaderButton();
        Assert.assertEquals(signInPageNew.actualUrlFind(), signInPageNew.EXPECTED_URL);
        System.out.println("Expected Url is correct");
    }

    @Test //passed
    public void signInButtonNameMainPage() {
        driver.get(stringUrlMainPage);
        Assert.assertEquals(signInPageNew.signInHeaderButtonNameFind(), signInPageNew.EXPECTED_SIGN_IN_HEADER_BUTTON_NAME);
    }

    @Test  //passed
    public void signInButtonNameAccountPage() {
        Assert.assertEquals(signInPageNew.signInHeaderButtonNameFind(), signInPageNew.EXPECTED_SIGN_IN_HEADER_BUTTON_NAME);
    }

    @Test // works 123
    public void signInPageTitle() throws InterruptedException {
        SignInPageNew signInPageNew = new SignInPageNew(driver);
        signInPageNew.clickSignInHeaderButton(); //works with and without
        Assert.assertEquals(signInPageNew.actualTitleFind(), signInPageNew.EXPECTED_TITLE);
        System.out.println("You are on Login - My Store");
    }

    @Test //passed
    public void authenticationSectionName() {
        Assert.assertEquals(signInPageNew.authenticationSectionTitleFind(),
                signInPageNew.EXPECTED_AUTHENTICATION_SECTION_TITLE.toUpperCase());
    }

    @Test //passed
    public void createAnAccountSectionName() {
        Assert.assertEquals(signInPageNew.createAnAccountTitleFind(), signInPageNew.EXPECTED_CREATE_AN_ACCOUNT_TITLE_NAME);
    }

    @Test //passed
    public void createAnAccountSectionText() {
        Assert.assertEquals(signInPageNew.createAnAccountTextFind(), signInPageNew.EXPECTED_CREATE_AN_ACCOUNT_TEXT);
    }

    @Test //passed
    public void emailFieldCreateAnAccountName() {
        Assert.assertEquals(signInPageNew.emailAddressFieldCreateAnAccountTitle(),
                signInPageNew.EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME);
        System.out.print("The title of email Address Field is " + '"'
                + signInPageNew.EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME + '"');
    }

    @Test  //passed
    public void emailInputWithOneNew() {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Assert.assertEquals(signInPageNew.authenticationFind(), "Authentication");
    }

    @Test  // passed
    public void emailInputNotEmpty() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertFalse(signInPageNew.emptyFieldEmail());
    }

    @Test  // works
    public void emailInputSameEmail() throws InterruptedException {
        Thread.sleep(5000);
        String email = "qwe@gmail.com";

        signInPageNew.inputEmailCreateAnAccount(email).createAnAccountButtonClick();
        Thread.sleep(5000);

//        driver.get(stringUrl);
//        SignInPage signInPageTwo = new SignInPage(driver);
//        signInPageTwo.inputEmail(email);
//        Thread.sleep(5000);
//        signInPage.createAnAccountButtonClick();
//        Thread.sleep(5000);

        // 2d part
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.errorMessageIsExist(), signInPageNew.EXPECTED_ERROR_EXISTING_EMAIL);
        System.out.println("An account using this email address has already been registered. " +
                "Please enter a valid password or request a new one.");
    }

    @Test // Url put and creation of instance of "SignInPage" class moved to current class
    public void invalidEmailMessage() throws InterruptedException {
        signInPageNew.inputEmailInvalidCreateAnAccount().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidEmail(), signInPageNew.INVALID_EMAIL);
        System.out.println("The text of message is " + '"' + signInPageNew.INVALID_EMAIL + '"');
    }

    @Test //passed
    public void invalidEmailMessageWhenEmailEmpty() throws InterruptedException {
        signInPageNew.createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.invalidEmail(), signInPageNew.INVALID_EMAIL);
        System.out.println("The text of message is " + '"' + signInPageNew.INVALID_EMAIL + '"');
    }

    @Test  //passed
    // I want to add put from ContextMap. Main idea is: input a new generated email and then check it in the list of all emails
    public void emailInputWithPut() {
        signInPageNew.emailAddressFieldCreateAnAccountFind();
        signInPageNew.inputEmail();
        //put....
        signInPageNew.createAnAccountButtonClick();
    }

    @Test  //passed
    public void createAnAccountButtonName() {
        Assert.assertEquals(signInPageNew.createAnAccountButtonFind(), signInPageNew.EXPECTED_CREATE_AN_ACCOUNT_BUTTON_NAME);
    }

    @Test  //passed
    public void alreadyRegisteredSectionName() {
        Assert.assertEquals(signInPageNew.alreadyRegisteredTitleFind(), signInPageNew.EXPECTED_ALREADY_REGISTERED_TITLE);
    }

    @Test //passed
    public void emailFieldAlreadyRegisteredName() {
        Assert.assertEquals(signInPageNew.emailAddressFieldAlreadyRegisteredTitle(),
                signInPageNew.EXPECTED_EMAIL_ADDRESS_FIELD_ALREADY_REGISTERED_NAME);
    }

    @Test //passed
    public void passwordFieldAlreadyRegisteredName() {
        Assert.assertEquals(signInPageNew.passwordFieldAlreadyRegisteredName(),
                signInPageNew.EXPECTED_PASSWORD_FIELD_ALREADY_REGISTERED_NAME);
    }

    @Test  //passed
    public void signInButtonAlreadyRegisteredName() {
        Assert.assertEquals(signInPageNew.signInAlreadyRegisteredButtonFind(),
                signInPageNew.EXPECTED_SIGN_IN_ALREADY_REGISTERED_BUTTON_NAME);
    }

    @Test  //passed
    public void signInButtonClick() throws InterruptedException {
        signInPageNew.clickSignInHeaderButton();
        Thread.sleep(5000);
    }

    @Test //passed
    public void forgotYourPasswordButtonName() {
        Assert.assertEquals(signInPageNew.forgotYourPasswordFind(), signInPageNew.EXPECTED_FORGOT_YOUR_PASSWORD_NAME);
    }

    @Test  //passed
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

    @Test  //passed
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

    @Test  //passed
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

    @Test  //passed
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

    @Test  //passed
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

    @Test  //passed
    public void createAnAccountPersonalInfoTitle() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.createAnAccountPersonalInfoTitle(),
                signInPageNew.CREATE_AN_ACCOUNT_PERSONAL_INFO_TITLE);
    }

    @Test  //passed
    public void yourPersonalInfoSectionTitle() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.yourPersonalInfoSectionTitle(), signInPageNew.YOUR_PERSONAL_INFO_SECTION_TITLE);
    }

    @Test  //passed
    public void yourPersonalInfoTitle() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.yourPersonalInfoTitle(), signInPageNew.YOUR_PERSONAL_INFO_TITLE);
    }

    @Test  //passed
    public void mrRadioButtonDisplayed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.mrRadioButtonDisplayed());
    }

    @Test //passed
    public void mrRadioButtonEnabled() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        signInPageNew.mrRadioButtonEnabled();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.mrRadioButtonEnabled());
    }

    @Test  //passed
    public void mrsRadioButtonDisplayed() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.mrsRadioButtonDisplayed());
    }

    @Test  //passed
    public void mrsRadioButtonEnabled() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.mrsRadioButtonEnabled());
    }

    @Test  //passed
    public void selectedStatusMrRadioButton() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPageNew.clickMrRadioButton();
        Assert.assertTrue(signInPageNew.selectedStatusMr());
    }

    @Test //passed
    public void selectedStatusMrsRadioButton() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPageNew.clickMrsRadioButton();

        Assert.assertTrue(signInPageNew.selectedStatusMrs());
    }

    @Test  //passed *** corrupted, java.util. had to be added
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

    @Test
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

    @Test //passed
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

    @Test  //passed
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

    @Test  //passed. Question: how to check all options value one by one?
    public void selectDropDownDaysOptionByValue() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPageNew.selectDropDownDaysOptionByValue();
    }

    @Test  // passed *** was corrupted when actual and expected were written separately as variables with List<String>
    public void selectDropDownMonthsAllOptionsByIndex() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int index = generateRandomIntInRange(0, signInPageNew.DROPDOWN_MONTHS.size() - 1);
        Assert.assertEquals(signInPageNew.dropDownMonthsAllOptions().get(index), signInPageNew.DROPDOWN_MONTHS.get(index));
        System.out.println("*********" + index + " " + signInPageNew.dropDownMonthsAllOptions().get(index)
                + " " + signInPageNew.DROPDOWN_MONTHS.get(index));
    }

    @Test  // passed *** corrupted when actual and expected were written separately as variables with List<String>
    public void selectDropDownMonthsAllOption() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.dropDownMonthsAllOptions(), signInPageNew.DROPDOWN_MONTHS);
        System.out.println("*********" + signInPageNew.dropDownMonthsAllOptions()
                + " \n " + signInPageNew.DROPDOWN_MONTHS);
    }

    @Test
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

    @Test  //passed
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

    @Test //passed
    public void checkEmailFieldIfNotEmpty() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.emptyFieldEmail(), false);
        System.out.println(signInPageNew.emptyFieldEmail());
    }

    @Test //passed
    public void checkEmailFieldValue() throws InterruptedException {
        signInPageNew.inputEmail();
        Thread.sleep(5000);
        String newEmail = signInPageNew.valueOfEmailFieldHomePage();

        signInPageNew.createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.valueOfEmailField(), newEmail);
        System.out.println(signInPageNew.valueOfEmailField());
    }

    @Test  //passed
    public void deleteEmailValue() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPageNew.deleteValueEmail();
        Assert.assertEquals(signInPageNew.emptyFieldEmail(), true);
    }

    @Test  //passed
    public void countryDropDownFirstOption() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.countryDropDownFirstOption(), "-");
    }

    @Test  //passed
    public void errorAlertIs() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.deleteValueEmail();
        signInPageNew.countryDropDownFirstOption();
        signInPageNew.clickRegisterButton();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.errorAlertDisplayed());
    }

    @Test  //passed
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

    @Test
    public void signUpCheckBoxEnabled() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.signUpCheckBox());
    }

    @Test  // passed
    public void signUpCheckBoxClickAndSelected() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.clickSignUpCheckBox();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.selectedSignUpCheckBox(), "not correct");
    }

    @Test //(enabled=false)
    public void signUpCheckBoxName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.signUpCheckBoxName(), signInPageNew.SIGNUP_CHECKBOX, "signUpCheckBoxName is not correct");
    }

    @Test
    public void offersCheckBoxEnabled() {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Assert.assertTrue(signInPageNew.offersCheckBox());
    }

    @Test
    public void offersCheckBoxName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.offersCheckBoxName(),
                signInPageNew.OFFERS_CHECKBOX, "offersCheckBoxName is not correct");
    }

    @Test //passed
    public void offersCheckBoxClickAndSelected() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.clickOffersCheckBox();
        Thread.sleep(5000);
        Assert.assertTrue(signInPageNew.selectedOffersCheckBox());
    }

    @Test //passed
    public void firsNameOneFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.firstNameFieldOneName(), signInPageNew.FIRSTNAME_FIELD);
    }

    @Test
    public void lastNameTwoFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.lastNameFieldTOneName(), signInPageNew.LASTNAME_FIELD);
    }

    @Test //passed
    public void firsNameTwoFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.firstNameFieldTwoName(), signInPageNew.FIRSTNAME_FIELD);
    }

    @Test //passed
    public void lastNameOneFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.lastNameFieldTwoName(), signInPageNew.LASTNAME_FIELD);
    }

    @Test
    public void emailFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.emailFieldName(), signInPageNew.EMAIL_FIELD);
    }

    @Test //passed but time to time is failed with different results of field name
    public void passwordFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.passwordFieldName(), signInPageNew.PASSWORD_FIELD);
    }

    @Test
    public void passwordFieldHelpText() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.passwordFieldHelpText(), signInPageNew.PASSWORD_FIELD_HELP_TEXT);
    }

    @Test
    public void dateOfBirthFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.dateOfBirthFieldName(), signInPageNew.DATE_OF_BIRTH_FIELD);
    }

    @Test //passed
    public void yourAddressSectionName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.yourAddressSectionName(), signInPageNew.YOUR_ADDRESS_SECTION.toUpperCase());
    }

    @Test
    public void companyFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.companyFieldName(), signInPageNew.COMPANY_FIELD);
    }

    @Test
    public void addressFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.addressFieldName(), signInPageNew.ADDRESS_FIELD);
    }

    @Test
    public void addressFieldHelpText() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.addressFieldHelpText(), signInPageNew.ADDRESS_HELP_TEXT);
    }

    @Test
    public void cityFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.cityFieldName(), signInPageNew.CITY_FIELD);
    }

    @Test
    public void countryFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.countryFieldName(), signInPageNew.COUNTRY_FIELD);
    }

    @Test  // passed
    public void selectDropDownStatesAllOptionsByIndex() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int index = generateRandomIntInRange(0, signInPageNew.STATES.size() - 1);
        Assert.assertEquals(signInPageNew.dropDownStatesAllOptions().get(index), signInPageNew.STATES.get(index));
        System.out.println("*********" + index + " " + signInPageNew.dropDownStatesAllOptions().get(index)
                + " " + signInPageNew.STATES.get(index));
    }

    @Test  // passed
    public void selectDropDownStatesAllOption() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPageNew.dropDownStatesAllOptions(), signInPageNew.STATES);
        System.out.println("*********" + signInPageNew.dropDownStatesAllOptions()
                + " \n " + signInPageNew.STATES);
    }

    @Test
    public void additionalInfoFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.additionalInfoFieldName(), signInPageNew.ADDITIONAL_INFORMATION_FIELD);
    }

    @Test
    public void additionalInfoHelpText() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.additionalInfoHelpText(), signInPageNew.ADDITIONAL_INFORMATION_HELP_TEXT);
    }

    @Test
    public void homePhoneFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.homePhoneFieldName(), signInPageNew.HOME_PHONE_FIELD);
    }

    @Test
    public void mobilePhoneFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.mobilePhoneFieldName(), signInPageNew.MOBILE_PHONE_FIELD);
    }

    @Test
    public void assignAliasFieldName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.assignAliasFieldName(), signInPageNew.ASSIGN_ADDRESS_ALIAS_FIELD);
    }

    @Test //passed
    public void valueOfAddressAliasField() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.assignAliasFieldValue(), signInPageNew.ASSIGN_ADDRESS_ALIAS_VALUE);
    }

    @Test
    public void registerButtonName() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPageNew.registerButtonName(), signInPageNew.REGISTER_BUTTON);
    }

    @Test //passed
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
    @Test //probably bad design. Question about loop. I'd like to empty all fields one by one and then work only
    // with one field. Should I write if for each field separately
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
    @Test //passed
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
    @Test //passed
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
    @Test //passed
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
    @Test //passed
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

    @Test //passed
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

    @Test //passed
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

    @Test
    public void firstNameFieldsAreEqual() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueFirstNameLetters();
        Assert.assertEquals(signInPageNew.valueOfFirstNameOneField(),
                signInPageNew.valueOfFirstNameTwoField());
        System.out.println("first field" + "\n" + (signInPageNew.valueOfFirstNameOneField()
                + "\n" + "second field" + "\n" + (signInPageNew.valueOfFirstNameOneField())));
    }

    @Test
    public void lastNameFieldsAreEqual() throws InterruptedException {
        signInPageNew.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPageNew.inputValueLastNameLetters();
        Assert.assertEquals(signInPageNew.valueOfLastNameOneField(),
                signInPageNew.valueOfLastNameTwoField());
        System.out.println("first field" + "\n" + (signInPageNew.valueOfLastNameOneField()
                + "\n" + "second field" + "\n" + (signInPageNew.valueOfLastNameOneField())));
    }

    @Test //passed
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

    @Test //passed
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

    @Test //passed
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

    @Test // Question with stream AQA#28
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


//        Assert.assertTrue(signInPage.errorInput());
//        Assert.assertEquals(signInPage.errorInputIsInvalid(),
//                "company is invalid.");
//        System.out.println("Company field" + "\n" + (signInPage.errorInputIsInvalid()));
    }

    @Test //passed
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

    @Test //passed
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

    @Test //passed
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

    @Test //passed
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

    @Test //passed
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

    @Test //passed
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

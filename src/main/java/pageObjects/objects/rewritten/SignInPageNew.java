package pageObjects.objects.rewritten;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import wrapperMethods.GeneralSeleniumMethods;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SignInPageNew extends BasePageObject {
    //public WebDriver driver;
    GeneralSeleniumMethods generalSeleniumMethods;

    public static final String EXPECTED_TITLE = "Login - My Store";
    public static final String EXPECTED_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    public static final String MY_ACCOUNT_URL = "http://automationpractice.com/index.php?controller=my-account";
    public static final String EXPECTED_SIGN_IN_HEADER_BUTTON_NAME = "Sign in";
    public static final String EXPECTED_AUTHENTICATION_SECTION_TITLE = "Authentication";
    public static final String EXPECTED_CREATE_AN_ACCOUNT_TITLE_NAME = "CREATE AN ACCOUNT";
    public static final String EXPECTED_CREATE_AN_ACCOUNT_TEXT = "Please enter your email address to create an account.";
    public static final String EXPECTED_CREATE_AN_ACCOUNT_BUTTON_NAME = "Create an account";
    public static final String EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME = "Email address";
    public static final String EXPECTED_ERROR_EXISTING_EMAIL = "An account using this email address has already been " +
            "registered. Please enter a valid password or request a new one.";
    public static final String INVALID_EMAIL = "Invalid email address.";
    public static final String EXPECTED_ALREADY_REGISTERED_TITLE = "ALREADY REGISTERED?";
    public static final String EXPECTED_EMAIL_ADDRESS_FIELD_ALREADY_REGISTERED_NAME = "Email address";
    public static final String EXPECTED_PASSWORD_FIELD_ALREADY_REGISTERED_NAME = "Password";
    public static final String EXPECTED_SIGN_IN_ALREADY_REGISTERED_BUTTON_NAME = "Sign in";
    public static final String EXPECTED_FORGOT_YOUR_PASSWORD_NAME = "Forgot your password?";
    public static final String INVALID_MESSAGE_ALREADY_REGISTERED_FIRST = "There is 1 error";
    public static final String INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS = "Invalid email address.";
    public static final String INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY = "An email address required.";
    public static final String INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS = "Invalid password.";
    public static final String INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY = "Password is required.";
    public static final String INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_MISMATCHED = "Authentication" +
            " failed.";
    public static final String CREATE_AN_ACCOUNT_PERSONAL_INFO_TITLE = "CREATE AN ACCOUNT";
    public static final String YOUR_PERSONAL_INFO_SECTION_TITLE = "YOUR PERSONAL INFORMATION";
    public static final String YOUR_PERSONAL_INFO_TITLE = "Title";
    public static final String COUNTRY = "Country";


    public static final String FIRSTNAME_FIELD = "First name *";
    public static final String LASTNAME_FIELD = "Last name *";
    public static final String EMAIL_FIELD = "Email *";
    public static final String PASSWORD_FIELD = "Password *";
    public static final String PASSWORD_FIELD_HELP_TEXT = "(Five characters minimum)";
    public static final String DATE_OF_BIRTH_FIELD = "Date of Birth";
    public static final String YOUR_ADDRESS_SECTION = "Your address";
    public static final String COMPANY_FIELD = "Company";
    public static final String ADDRESS_FIELD = "Address *";
    public static final String ADDRESS_HELP_TEXT = "Street address, P.O. Box, Company name, etc.";
    public static final String CITY_FIELD = "City *";
    public static final String COUNTRY_FIELD = "Country *";
    public static final String ADDITIONAL_INFORMATION_FIELD = "Additional information";
    public static final String ADDITIONAL_INFORMATION_HELP_TEXT = "You must register at least one phone number.";
    public static final String HOME_PHONE_FIELD = "Home phone";
    public static final String MOBILE_PHONE_FIELD = "Mobile phone *";
    public static final String ASSIGN_ADDRESS_ALIAS_FIELD = "Assign an address alias for future reference. *";
    public static final String ASSIGN_ADDRESS_ALIAS_VALUE = "My address";

    public static final String REGISTER_BUTTON = "Register";
    public static final String REQUIRED_TEXT = "*Required field";

    String emailInvalid = "/*-+2!@#qwe";
    String passwordIncorrect = "123";
    String passwordCorrect = "zzz123";
    String companyAllowed = "/*-+2!@#qwe";
    String companyNotAllowed = "?<>{}[]|\\";
    String addressAllowed = "()'-*123 qweQWE";
    String addressNotAllowed = "!@#$%^";
    String cityAllowed = "-/''123 qweQWE";
    String cityNotAllowed = "+()";
    String zipAllowed = "12345";
    String zipNotAllowed = "QWE123!@#$%^&*()_+";
    String phoneAllowed = "+()- 1234";
    String phoneNotAllowed = "+()- 1234 allowed";

    /**
     * moved to MainMethods
     */
//    String textFieldAlphabetic = RandomStringUtils.randomAlphabetic(5);
//    String testFieldAlphaNumeric = RandomStringUtils.randomAlphanumeric(5);
//    String testFieldNumeric = RandomStringUtils.randomNumeric(5);
//    //String testField = RandomStringUtils.random(15, 6, 10, true, true);
//    String testField = RandomStringUtils.random(2, 0, 53, false, true);
//    String emailO = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";

    public static final int[] DROPDOWN_DAYS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

    public static final List<String> DROPDOWN_MONTHS = Arrays.asList("-", "January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December");

    public static final List<String> STATES = Arrays.asList("-", "Alabama", "Alaska", "Arizona", "Arkansas",
            "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia",
            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
            "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
            "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
            "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island",
            "South Carolina", "South Dakota", "Tennessee", "Texas", "US Virgin Islands", "Utah", "Vermont",
            "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");

    //"Arkansas", "California", "Colorado", "Connecticut", "Delaware",
    public static final int[] DROPDOWN_YEARS = {2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011,
            2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994,
            1993, 1992, 1991, 1990, 1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977,
            1976, 1975, 1974, 1973, 1972, 1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961, 1960,
            1959, 1958, 1957, 1956, 1955, 1954, 1953, 1952, 1951, 1950, 1949, 1948, 1947, 1946, 1945, 1944, 1943,
            1942, 1941, 1940, 1939, 1938, 1937, 1936, 1935, 1934, 1933, 1932, 1931, 1930, 1929, 1928, 1927, 1926,
            1925, 1924, 1923, 1922, 1921, 1920, 1919, 1918, 1917, 1916, 1915, 1914, 1913, 1912, 1911, 1910, 1909,
            1908, 1907, 1906, 1905, 1904, 1903, 1902, 1901, 1900};

    public static final String ALERT_ERROR = "There are 10 errors"
            + "\n" + "You must register at least one phone number."
            + "\n" + "lastname is required."
            + "\n" + "firstname is required."
            + "\n" + "email is required."
            + "\n" + "passwd is required."
            + "\n" + "id_country is required."
            + "\n" + "address1 is required."
            + "\n" + "city is required."
            + "\n" + "Country cannot be loaded with address->id_country"
            + "\n" + "Country is invalid";

    public static final String SIGNUP_CHECKBOX = "Sign up for our newsletter!";
    public static final String OFFERS_CHECKBOX = "Receive special offers from our partners!";

    public static final List<String> COUNTRY_FIELD_LIST = Arrays.asList("-", "United States");

    private WebDriver driver;
    //Constructor
    public SignInPageNew(WebDriver driver) {
        generalSeleniumMethods = new GeneralSeleniumMethods(driver);
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    //constructor
//    public SignInPageNew(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    //methods
    public String actualTitleFind() { //get title of Sign in page
        return generalSeleniumMethods.getTitle();
    }

    public String actualUrlFind() {  //get URL for further comparison
        return generalSeleniumMethods.getUrl();
    }

    //signInHeaderButton
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signInHeaderButton;

    public String signInHeaderButtonNameFind() {
        return generalSeleniumMethods.getText(signInHeaderButton);
    }

    //authenticationSectionTitle
    @FindBy(xpath = "//h1[text()='Authentication']")
    private WebElement authenticationSectionTitle;

    public String authenticationSectionTitleFind() {
        return generalSeleniumMethods.getText(authenticationSectionTitle);
    }

    //createAnAccountTitle
    @FindBy(xpath = "//h3[text()='Create an account']")
    private WebElement createAnAccountTitle;

    public String createAnAccountTitleFind() {
        return generalSeleniumMethods.getText(createAnAccountTitle);
    }

    //createAnAccountText
    @FindBy(xpath = "//div[@class='form_content clearfix']" +
            "/p[contains(text(),'Please')]")
    private WebElement createAnAccountText;

    public String createAnAccountTextFind() {
        return generalSeleniumMethods.getText(createAnAccountText);
    }

    //createAnAccountButton
    @FindBy(xpath = "//*[@id='SubmitCreate']/span")
    private WebElement createAnAccountButton;

    public String createAnAccountButtonFind() {
        return generalSeleniumMethods.getText(createAnAccountButton);
    }

    //emailAddressFieldCreateAnAccount
    @FindBy(xpath = "//*[@id='email_create']")
    private WebElement emailAddressFieldCreateAnAccount;

    public String emailAddressFieldCreateAnAccountFind() {
        return generalSeleniumMethods.getText(emailAddressFieldCreateAnAccount);
    }

    //emailAddressFieldCreateAnAccountTitle
    @FindBy(xpath = "//*[@id='create-account_form']//child::div[2]/label")
    private WebElement emailAddressFieldCreateAnAccountTitle;

    public String emailAddressFieldCreateAnAccountTitle() {
        return generalSeleniumMethods.getText(emailAddressFieldCreateAnAccountTitle);
    }

    //errorMessageIsExist
    @FindBy(xpath = "//div[@id='create_account_error']/ol/li")
    private WebElement errorMessageIsExist;

    public String errorMessageIsExist() {
        return generalSeleniumMethods.getText(errorMessageIsExist);
    }

    //invalidEmail
    @FindBy(xpath = "//li[text()='Invalid email address.']")
    private WebElement invalidEmail;

    public String invalidEmail() {
        return generalSeleniumMethods.getText(invalidEmail);
    }

    //alreadyRegisteredTitle
    @FindBy(xpath = "//h3[text()='Already registered?']")
    private WebElement alreadyRegisteredTitle;

    public String alreadyRegisteredTitleFind() {
        return generalSeleniumMethods.getText(alreadyRegisteredTitle);
    }

    //emailAddressFieldAlreadyRegistered
    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailField;

    public String emailAddressFieldAlreadyRegisteredFind() {
        return generalSeleniumMethods.getText(emailField);
    }

    //emailAddressFieldAlreadyRegisteredTitle
    @FindBy(xpath = "//*[@id='login_form']//child::div[1]/label")
    private WebElement emailAddressFieldAlreadyRegisteredTitle;

    public String emailAddressFieldAlreadyRegisteredTitle() {
        return generalSeleniumMethods.getText(emailAddressFieldAlreadyRegisteredTitle);
    }

    //passwordFieldAlreadyRegistered
    @FindBy(xpath = "//*[@id='passwd']")
    private WebElement passwordFieldAlreadyRegistered;

    public String passwordFieldAlreadyRegisteredFind() {
        return generalSeleniumMethods.getText(passwordFieldAlreadyRegistered);
    }

    //passwordFieldAlreadyRegisteredTitle
    @FindBy(xpath = "//*[@id='login_form']/div/div[2]/label")
    private WebElement passwordFieldAlreadyRegisteredTitle;

    public String passwordFieldAlreadyRegisteredName() {
        return generalSeleniumMethods.getText(passwordFieldAlreadyRegisteredTitle);
    }

    //signInButtonAlreadyRegistered
    @FindBy(xpath = "//*[@id='SubmitLogin']/span")
    private WebElement signInButtonAlreadyRegistered;

    public String signInAlreadyRegisteredButtonFind() {
        return generalSeleniumMethods.getText(signInButtonAlreadyRegistered);
    }

    public void signInAlreadyRegisteredButtonClick() {
        generalSeleniumMethods.clickElement(signInButtonAlreadyRegistered);
    }

    //forgotYourPassword
    @FindBy(xpath = "//p[contains(@class,'lost')]/a")
    private WebElement forgotYourPassword;

    public String forgotYourPasswordFind() {
        return generalSeleniumMethods.getText(forgotYourPassword);
    }

    //authenticationNavigation
    @FindBy(xpath = "//span[text()='Authentication']")
    private WebElement authenticationNavigation;

    public String authenticationFind() {
        return generalSeleniumMethods.getText(authenticationNavigation);
    }

    public void clickSignInHeaderButton() {
        generalSeleniumMethods.clickElement(signInHeaderButton);
    }

    public void createAnAccountButtonClick() {
        generalSeleniumMethods.clickElement(createAnAccountButton);
    }

    //companyField
    @FindBy(xpath = "//*[@id='company']")
    private WebElement companyField;

    public void inputValueAllowedCompany() {
        generalSeleniumMethods.sendKey(companyField, companyAllowed);
    }

    //addressOneField
    @FindBy(xpath = "//*[@id='address1']")
    private WebElement addressOneField;

    public void inputValueAllowedAddress() {
        generalSeleniumMethods.sendKey(addressOneField, addressAllowed);
    }

    //cityField
    @FindBy(xpath = "//*[@id='city']")
    private WebElement cityField;

    public void inputValueAllowedCity() {
        generalSeleniumMethods.sendKey(cityField, cityAllowed);
    }

    //zipField
    @FindBy(xpath = "//*[@id='postcode']")
    private WebElement zipField;

    public void inputValueAllowedZip() {
        generalSeleniumMethods.sendKey(zipField, zipAllowed);
    }

    //phoneField
    @FindBy(xpath = "//*[@id='phone']")
    private WebElement phoneField;

    public void inputValueAllowedPhone() {
        generalSeleniumMethods.sendKey(phoneField, phoneAllowed);
    }

    //mobileField
    @FindBy(xpath = "//*[@id='phone_mobile']")
    private WebElement mobileField;

    public void inputValueAllowedMobile() {
        generalSeleniumMethods.sendKey(mobileField, phoneAllowed);
    }

    public void inputValueNotAllowedCompany() {
        generalSeleniumMethods.sendKey(companyField, companyNotAllowed);
    }

    public void inputValueNotAllowedAddress() {
        generalSeleniumMethods.sendKey(addressOneField, addressNotAllowed);
    }

    public void inputValueNotAllowedCity() {
        generalSeleniumMethods.sendKey(cityField, cityNotAllowed);
    }

    public void inputValueNotAllowedZip() {
        generalSeleniumMethods.sendKey(zipField, zipNotAllowed);
    }

    public void inputValueNotAllowedPhone() {
        generalSeleniumMethods.sendKey(phoneField, phoneNotAllowed);
    }

    public void inputValueNotAllowedMobile() {
        generalSeleniumMethods.sendKey(mobileField, phoneNotAllowed);
    }

    public void inputValueAlphaNumericEmail() {
        generalSeleniumMethods.inputValueAlphaNumeric(emailField);
    }

    public SignInPageNew inputEmail() {
        generalSeleniumMethods.inputValueRandomEmail(emailAddressFieldCreateAnAccount);
        return this;
    }

    public SignInPageNew inputEmailAuthorization() {
        generalSeleniumMethods.inputValueRandomEmail(emailField);
        return this;
    }

    public SignInPageNew inputEmailCreateAnAccount(String email) {
        generalSeleniumMethods.inputEmail(emailAddressFieldCreateAnAccount, email);
        return this;
    }

    public SignInPageNew inputEmailInvalidCreateAnAccount() {
        generalSeleniumMethods.inputEmailInvalid(emailAddressFieldCreateAnAccount, emailInvalid);
        return this;
    }

    public SignInPageNew inputEmailInvalidAlreadyRegistered() {
        generalSeleniumMethods.inputEmailInvalid(emailField, emailInvalid);
        return this;
    }

    public SignInPageNew inputEmailAlreadyRegistered(String email) {
        generalSeleniumMethods.inputEmail(emailField, email);
        return this;
    }

    public SignInPageNew inputPasswordAlreadyRegistered(String password) {
        generalSeleniumMethods.inputPassword(passwordFieldAlreadyRegistered, password);
        return this;
    }

    public SignInPageNew inputPasswordAlreadyRegistered() {
        generalSeleniumMethods.inputPassword(passwordFieldAlreadyRegistered);
        return this;
    }

    public SignInPageNew inputPasswordInvalidAlreadyRegistered() {
        generalSeleniumMethods.inputPassword(passwordFieldAlreadyRegistered, passwordIncorrect);
        return this;
    }

    //invalidMessageAlreadyRegisteredFirst
    @FindBy(xpath = "//div[@class='alert alert-danger']/p")
    private WebElement invalidMessageAlreadyRegisteredFirst;

    public String invalidMessageAlreadyRegisteredFirstText() {
        return generalSeleniumMethods.getText(invalidMessageAlreadyRegisteredFirst);
    }

    //invalidMessageAlreadyRegisteredSecond
    @FindBy(xpath = "//div[@id='center_column']//child::li")
    private WebElement invalidMessageAlreadyRegisteredSecond;

    public String invalidMessageAlreadyRegisteredSecondText() {
        return generalSeleniumMethods.getText(invalidMessageAlreadyRegisteredSecond);
    }

    //personalInfoTitle
    @FindBy(xpath = "//h1[text()='Create an account']")
    private WebElement personalInfoTitle;

    public String createAnAccountPersonalInfoTitle() {
        return generalSeleniumMethods.getText(personalInfoTitle);
    }

    //yourPersonalInfoSectionTitle
    @FindBy(xpath = "//h3[text()='Your personal information']")
    private WebElement yourPersonalInfoSectionTitle;

    public String yourPersonalInfoSectionTitle() {
        return generalSeleniumMethods.getText(yourPersonalInfoSectionTitle);
    }

    //yourPersonalInfoTitle
    @FindBy(xpath = "//div[@class='clearfix']/label")
    private WebElement yourPersonalInfoTitle;

    public String yourPersonalInfoTitle() {
        return generalSeleniumMethods.getText(yourPersonalInfoTitle);
    }

    //mrRadioButtonName
    @FindBy(xpath = "//label[@for='id_gender1']")
    private WebElement mrRadioButtonName;

    public boolean mrRadioButtonDisplayed() {
        return generalSeleniumMethods.isDisplayed(mrRadioButtonName);
    }

    //mrsRadioButtonName
    @FindBy(xpath = "//label[@for='id_gender2']")
    private WebElement mrsRadioButtonName;

    public boolean mrsRadioButtonDisplayed() {
        return generalSeleniumMethods.isDisplayed(mrsRadioButtonName);
    }

    //redSign
    @FindBy(xpath = "//div[@class='required form-group form-error']")
    private WebElement redSign;

    public boolean redSignDisplayed() {
        return generalSeleniumMethods.isDisplayed(redSign);
    }

    //greenSign
    @FindBy(xpath = "//div[@class='required form-group form-ok']")
    private WebElement greenSign;

    public boolean greenSignDisplayed() {
        return generalSeleniumMethods.isDisplayed(greenSign);
    }

    //errorInput
    @FindBy(xpath = "//li[contains(text(),'is invalid')]")
    private WebElement errorInput;

    public boolean errorInputDisplayed() {
        return generalSeleniumMethods.isDisplayed(errorInput);
    }

    //customerAccount
    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")
    private WebElement customerAccount;

    public boolean customerAccountDisplayed() {
        return generalSeleniumMethods.isDisplayed(customerAccount); // will be re-written
    }

    public String errorInputIsInvalid() {
        return generalSeleniumMethods.getText(errorInput);
    }

    //errorInputRequires
    @FindBy(xpath = "//li[contains(text(),'This country')]")
    private WebElement errorInputRequires;

    public boolean errorInputRequiresDisplayed() {
        return generalSeleniumMethods.isDisplayed(errorInputRequires);
    }

    public String errorInputRequires() {
        return generalSeleniumMethods.getText(errorInputRequires);
    }

    //errorInputEmpty
    @FindBy(xpath = "//li[contains(text(),'phone number')]")
    private WebElement errorInputEmpty;

    public boolean errorInputEmptyField() {
        return generalSeleniumMethods.isDisplayed(errorInputEmpty);
    }

    //errorInputEmptyPhoneText
    @FindBy(xpath = "//p[@class='inline-infos']")
    private WebElement errorInputEmptyPhoneText;

    public boolean errorInputEmptyPhoneTextDisplayed() {
        return generalSeleniumMethods.isDisplayed(errorInputEmptyPhoneText);
    }

    public String errorInputEmptyPhoneText() {
        return generalSeleniumMethods.getText(errorInputEmptyPhoneText);
    }

    public String errorInputEmptyFieldError() {
        return generalSeleniumMethods.getText(errorInputEmpty);
    }

    //customerAccountText
    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    private WebElement customerAccountText;

    public String customerAccountText() {
        return generalSeleniumMethods.getText(customerAccountText); //will be re-written
    }

    //mrRadioButton
    @FindBy(xpath = "//*[@id='id_gender1']")
    private WebElement mrRadioButton;

    public boolean mrRadioButtonEnabled() {
        return generalSeleniumMethods.isEnabled(mrRadioButton);
    }

    //mrsRadioButton
    @FindBy(xpath = "//*[@id='id_gender2']")
    private WebElement mrsRadioButton;

    public boolean mrsRadioButtonEnabled() {
        return generalSeleniumMethods.isEnabled(mrsRadioButton);
    }

    //signUpCheckBox
    @FindBy(xpath = "//div[@id='uniform-newsletter']")
    private WebElement signUpCheckBox;

    public boolean signUpCheckBox() {
        return generalSeleniumMethods.isEnabled(signUpCheckBox);
    }

    //offersCheckBox
    @FindBy(xpath = "//*[@id='optin']")
    private WebElement offersCheckBox;

    public boolean offersCheckBox() {
        return generalSeleniumMethods.isEnabled(offersCheckBox);
    }

    //signUpCheckBoxName
    @FindBy(xpath = "//div[@class='checkbox']")
    private WebElement signUpCheckBoxName;

    public String signUpCheckBoxName() {
        return generalSeleniumMethods.getText(signUpCheckBoxName);
    }

    //offersCheckBoxName
    @FindBy(xpath = "//label[@for='optin']")
    private WebElement offersCheckBoxName;

    public String offersCheckBoxName() {
        return generalSeleniumMethods.getText(offersCheckBoxName);
    }

    public void clickMrRadioButton() {
        generalSeleniumMethods.clickElement(mrRadioButton);
    }

    public void clickMrsRadioButton() {
        generalSeleniumMethods.clickElement(mrsRadioButton);
    }

    public void clickSignUpCheckBox() {
        generalSeleniumMethods.clickElement(signUpCheckBox);
    }

    public void clickOffersCheckBox() {
        generalSeleniumMethods.clickElement(offersCheckBox);
    }

    //signOutButton
    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOutButton;

    public void signOutButtonClick() {
        generalSeleniumMethods.clickElement(signOutButton);
    }

    public boolean selectedStatusMr() {
        return generalSeleniumMethods.selectedStatus(mrRadioButton);
    }

    public boolean selectedStatusMrs() {
        return generalSeleniumMethods.selectedStatus(mrsRadioButton);
    }

    public boolean selectedSignUpCheckBox() {
        return generalSeleniumMethods.selectedStatus(signUpCheckBox);
    }

    public boolean selectedOffersCheckBox() {
        return generalSeleniumMethods.selectedStatus(offersCheckBox);
    }

    //dropDownDays
    @FindBy(xpath = "//*[@id='days']")
    private WebElement dropDownDays;

    public int[] dropDownDaysAllOptions() {
        return generalSeleniumMethods.generalDropDownIntAllOptions(dropDownDays);
    }

    public SignInPageNew selectDropDownDaysOptionByValue() {
        Select select = new Select(dropDownDays);
        select.selectByValue("6");
        select.getFirstSelectedOption().getText();
        return this;
    }

    //dropDownYears
    @FindBy(xpath = "//*[@id='years']")
    private WebElement dropDownYears;

    public int[] dropDownYearsAllOptions() {
        return generalSeleniumMethods.generalDropDownIntAllOptions(dropDownYears);
    }

    //dropDownMonths
    @FindBy(xpath = "//*[@id='months']")
    private WebElement dropDownMonths;

    public List<String> dropDownMonthsAllOptions() {
        return generalSeleniumMethods.generalConverterWebElementToList(dropDownMonths);
    }

    //dropDownStates
    @FindBy(xpath = "//*[@id='id_state']")
    private WebElement dropDownStates;

    public List<String> dropDownStatesAllOptions() {
        return generalSeleniumMethods.generalConverterWebElementToList(dropDownStates);
    }

    //registerButton
    @FindBy(xpath = "//button[@id='submitAccount']")
    private WebElement registerButton;

    public void clickRegisterButton() {
        generalSeleniumMethods.clickElement(registerButton);
    }

    public boolean emptyFieldEmail() {
        return generalSeleniumMethods.iFemptyField(emailField);
    }

    //firstNameField
    @FindBy(xpath = "//*[@id='customer_firstname']")
    private WebElement firstNameField;

    public boolean emptyFieldFirstName() {
        return generalSeleniumMethods.iFemptyField(firstNameField);
    }

    //lastNameField
    @FindBy(xpath = "//*[@id='customer_lastname']")
    private WebElement lastNameField;

    public boolean emptyFieldLastName() {
        return generalSeleniumMethods.iFemptyField(lastNameField);
    }

    public boolean emptyFieldPassword() {
        return generalSeleniumMethods.iFemptyField(passwordFieldAlreadyRegistered);
    }

    public String valueOfEmailFieldHomePage() {
        return generalSeleniumMethods.valueOfField(emailAddressFieldCreateAnAccount, "value");
    }

    public String valueOfEmailField() {
        return generalSeleniumMethods.valueOfField(emailField, "value");
    }

    public String valueOfFirstNameOneField() {
        return generalSeleniumMethods.valueOfField(firstNameField, "value");
    }

    //firstNameTwoField
    @FindBy(xpath = "//*[@id='firstname']")
    private WebElement firstNameTwoField;

    public String valueOfFirstNameTwoField() {
        return generalSeleniumMethods.valueOfField(firstNameTwoField, "value");
    }

    public String valueOfLastNameOneField() {
        return generalSeleniumMethods.valueOfField(lastNameField, "value");
    }

    //lastNameTwoField
    @FindBy(xpath = "//*[@id='lastname']")
    private WebElement lastNameTwoField;

    public String valueOfLastNameTwoField() {
        return generalSeleniumMethods.valueOfField(lastNameTwoField, "value");
    }

    //pop-up setOfErrors 1-10
    @FindBy(xpath = "//*[@id='center_column']/div/ol")
    private WebElement setOfErrors;

    public List<String> getListOfOptions() {
        generalSeleniumMethods.getListOfOptions(setOfErrors);
        return (List<String>) this;
    }

    public boolean deleteValueEmail() {
        return generalSeleniumMethods.deleteValue(emailField);
    }

    public boolean deleteValueFirstName() {
        return generalSeleniumMethods.deleteValue(firstNameField);
    }

    public boolean deleteValueLastName() {
        return generalSeleniumMethods.deleteValue(lastNameField);
    }

    public boolean deleteValuePassword() {
        return generalSeleniumMethods.deleteValue(passwordFieldAlreadyRegistered);
    }

    //countryDropDown
    @FindBy(xpath = "//*[@id='id_country']")
    private WebElement countryDropDown;

    public String countryDropDownFirstOption() {
        Actions action = new Actions(driver);
        action.moveToElement(countryDropDown).build().perform();
        countryDropDown.click();

        Select select = new Select(countryDropDown);
        select.selectByIndex(0);
        return select.getFirstSelectedOption().getText();
    }

    //statesDropDown
    @FindBy(xpath = "//*[@id='id_state']")
    private WebElement statesDropDown;

    public String statesDropDownOptionByValue() {
        Actions action = new Actions(driver);
        action.moveToElement(statesDropDown).build().perform();
        statesDropDown.click();

        Select select = new Select(statesDropDown);
        select.selectByValue("FL");
        return select.getFirstSelectedOption().getText();
    }

    public String statesDropDownOptionFirst() {
        Actions action = new Actions(driver);
        action.moveToElement(statesDropDown).build().perform();
        statesDropDown.click();

        Select select = new Select(statesDropDown);
        select.selectByIndex(0);
        return select.getFirstSelectedOption().getText();
    }

    //errorAlertFull
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement errorAlertFull;

    public String errorAlertText() {
        return generalSeleniumMethods.getText(errorAlertFull);
    }

    public boolean errorAlertDisplayed() {
        return generalSeleniumMethods.isDisplayed(errorAlertFull);
    }

    //firstNameFieldName
    @FindBy(xpath = "//label[@for='customer_firstname']")
    private WebElement firstNameFieldName;

    public String firstNameFieldOneName() {
        return generalSeleniumMethods.getText(firstNameFieldName);
    }

    //firstNameTwoFieldName
    @FindBy(xpath = "//label[@for='firstname']")
    private WebElement firstNameTwoFieldName;

    public String firstNameFieldTwoName() {
        return generalSeleniumMethods.getText(firstNameTwoFieldName);
    }

    //lastNameFieldName
    @FindBy(xpath = "//label[@for='customer_lastname']")
    private WebElement lastNameFieldName;

    public String lastNameFieldTOneName() {
        return generalSeleniumMethods.getText(lastNameFieldName);
    }

    //lastNameTwoFieldName
    @FindBy(xpath = "//label[@for='lastname']")
    private WebElement lastNameTwoFieldName;

    public String lastNameFieldTwoName() {
        return generalSeleniumMethods.getText(lastNameTwoFieldName);
    }

    //emailFieldName
    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailFieldName;

    public String emailFieldName() {
        return generalSeleniumMethods.getText(emailFieldName);
    }

    //passwordFieldName
    @FindBy(xpath = "//label[@for='passwd']")
    private WebElement passwordFieldName;

    public String passwordFieldName() {
        return generalSeleniumMethods.getText(passwordFieldName);
    }

    //passwordFieldHelpText
    @FindBy(xpath = "//span[contains(text(),'(Five')]")
    private WebElement passwordFieldHelpText;

    public String passwordFieldHelpText() {
        return generalSeleniumMethods.getText(passwordFieldHelpText);
    }

    //dateOfBirthFieldName
    @FindBy(xpath = "//label[contains(text(),'Date of Birth')]")
    private WebElement dateOfBirthFieldName;

    public String dateOfBirthFieldName() {
        return generalSeleniumMethods.getText(dateOfBirthFieldName);
    }

    //yourAddressSectionName
    @FindBy(xpath = "//*[text()='Your address']")
    private WebElement yourAddressSectionName;

    public String yourAddressSectionName() {
        return generalSeleniumMethods.getText(yourAddressSectionName);
    }

    //companyFieldName
    @FindBy(xpath = "//label[@for='company']")
    private WebElement companyFieldName;

    public String companyFieldName() {
        return generalSeleniumMethods.getText(companyFieldName);
    }

    //addressFieldName
    @FindBy(xpath = "//label[@for='address1']")
    private WebElement addressFieldName;

    public String addressFieldName() {
        return generalSeleniumMethods.getText(addressFieldName);
    }

    //addressFieldHelpText
    @FindBy(xpath = "//span[contains(text(),'Street')]")
    private WebElement addressFieldHelpText;

    public String addressFieldHelpText() {
        return generalSeleniumMethods.getText(addressFieldHelpText);
    }

    //cityFieldName
    @FindBy(xpath = "//label[@for='city']")
    private WebElement cityFieldName;

    public String cityFieldName() {
        return generalSeleniumMethods.getText(cityFieldName);
    }

    //countryFieldName
    @FindBy(xpath = "//label[@for='id_country']")
    private WebElement countryFieldName;

    public String countryFieldName() {
        return generalSeleniumMethods.getText(countryFieldName);
    }

    //additionalInfoFieldName
    @FindBy(xpath = "//label[@for='other']")
    private WebElement additionalInfoFieldName;

    public String additionalInfoFieldName() {
        return generalSeleniumMethods.getText(additionalInfoFieldName);
    }

    //additionalInfoHelpText
    @FindBy(xpath = "//p[contains(text(),'You must')]")
    private WebElement additionalInfoHelpText;

    public String additionalInfoHelpText() {
        return generalSeleniumMethods.getText(additionalInfoHelpText);
    }

    //homePhoneFieldName
    @FindBy(xpath = "//label[@for='phone']")
    private WebElement homePhoneFieldName;

    public String homePhoneFieldName() {
        return generalSeleniumMethods.getText(homePhoneFieldName);
    }

    //mobilePhoneFieldName
    @FindBy(xpath = "//label[@for='phone_mobile']")
    private WebElement mobilePhoneFieldName;

    public String mobilePhoneFieldName() {
        return generalSeleniumMethods.getText(mobilePhoneFieldName);
    }

    //assignAliasFieldName
    @FindBy(xpath = "//label[@for='alias']")
    private WebElement assignAliasFieldName;

    public String assignAliasFieldName() {
        return generalSeleniumMethods.getText(assignAliasFieldName);
    }

    //assignAliasFieldValue
    @FindBy(xpath = "//*[@id='alias']")
    private WebElement assignAliasFieldValue;

    public String assignAliasFieldValue() {
        return generalSeleniumMethods.valueOfField(assignAliasFieldValue, "value");
    }

    //registerButtonName
    @FindBy(xpath = "//button[@id='submitAccount']")
    private WebElement registerButtonName;

    public String registerButtonName() {
        return generalSeleniumMethods.getText(registerButtonName);
    }

    //requiredText
    @FindBy(xpath = "//span[text()='Required field']")
    private WebElement requiredText;

    public String requiredText() {
        return generalSeleniumMethods.getText(requiredText);
    }

    public void inputValueFirstNameLetters() {
        generalSeleniumMethods.inputValueAlphabetic(firstNameField);
    }

    public void inputValueFirstNameDigits() {
        generalSeleniumMethods.inputValueNumeric(firstNameField);
    }

    public void inputValueLastNameLetters() {
        generalSeleniumMethods.inputValueAlphabetic(lastNameField);
    }

    public void inputValueLastNameDigits() {
        generalSeleniumMethods.inputValueNumeric(lastNameField);
    }

    public void inputValuePassword(String value) {
        generalSeleniumMethods.inputPassword(passwordFieldAlreadyRegistered, value);
    }

    public void clickAnyWhere() throws AWTException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        robot.mouseMove(50, 50);
        actions.click().build().perform();
    }
}

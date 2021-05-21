package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.MainMethods;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignInPage {
    public WebDriver driver;
    MainMethods mainMethods;

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
            "Hawaii", "Idaho",  "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",  "Maine",
            "Maryland", "Massachusetts",  "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
            "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
            "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island",
            "South Carolina", "South Dakota", "Tennessee", "Texas",  "US Virgin Islands", "Utah", "Vermont",
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

    //constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    //methods
    public String actualTitleFind(WebDriver driver) { //get title of Sign in page
        return mainMethods.getTitle();
    }

    public String actualUrlFind() {  //get URL for further comparison
        return mainMethods.getUrl();
    }

    /**
     * moved to MainMethods
     * @return
     */
    //General getName
//    public String getName(String xPath) {
//        return driver.findElement(By.xpath(xPath)).getText();
//    }

    public String signInHeaderButtonNameFind() {
        return mainMethods.getText("//a[@title='Log in to your customer account']");
    }

    public String authenticationSectionTitleFind() {
        return mainMethods.getText("//h1[text()='Authentication']");
    }

    public String createAnAccountTitleFind() {
        return mainMethods.getText("//h3[text()='Create an account']");
    }

    public String createAnAccountTextFind() {
        return mainMethods.getText("//div[@class='form_content clearfix']" +
                "/p[contains(text(),'Please')]");
    }

    public String createAnAccountButtonFind() {
        return mainMethods.getText("//*[@id='SubmitCreate']/span");
    }

    public String emailAddressFieldCreateAnAccountFind() {
        return mainMethods.getText("//*[@id='email_create']");
    }

    public String emailAddressFieldCreateAnAccountTitle() {
        return mainMethods.getText("//*[@id='create-account_form']" +
                "//child::div[2]/label");
    }

    public String errorMessageIsExist() {
        return mainMethods.getText("//div[@id='create_account_error']/ol/li");
    }

    public String invalidEmail() {
        return mainMethods.getText("//li[text()='Invalid email address.']");
    }

    public String alreadyRegisteredTitleFind() {
        return mainMethods.getText("//h3[text()='Already registered?']");
    }

    public String emailAddressFieldAlreadyRegisteredFind() {
        return mainMethods.getText("//*[@id='email']");
    }

    public String emailAddressFieldAlreadyRegisteredTitle() {
        return mainMethods.getText("//*[@id='login_form']//child::div[1]/label");
    }

    public String passwordFieldAlreadyRegisteredFind() {
        return mainMethods.getText("//*[@id='passwd']");
    }

    public String passwordFieldAlreadyRegisteredName() {
        return mainMethods.getText("//*[@id='login_form']/div/div[2]/label");
    }

    public String signInAlreadyRegisteredButtonFind() {
        return mainMethods.getText("//*[@id='SubmitLogin']/span");
    }

    public void signInAlreadyRegisteredButtonClick() {
        mainMethods.clickElement("//*[@id='SubmitLogin']/span");
    }

    public String forgotYourPasswordFind() {
        return mainMethods.getText("//p[contains(@class,'lost')]/a");
    }

    public String authenticationFind() {
        return mainMethods.getText("//span[text()='\tAuthentication']");
    }

    public void clickSignInHeaderButton() {
        mainMethods.clickElement("//a[@title='Log in to your customer account']");
    }

    public void createAnAccountButtonClick() {
        mainMethods.clickElement("//*[@id='SubmitCreate']/span");
    }

    /**
     * moved to MainMethods
     */
    //General
//    public void inputValueAllowed(String xPath, String value) {
//        driver.findElement(By.xpath(xPath)).sendKeys(value);
//    }

    public void inputValueAllowedCompany() {
        mainMethods.sendKey("//*[@id='company']", companyAllowed);
    }

    public void inputValueAllowedAddress() {
        mainMethods.sendKey("//*[@id='address1']", addressAllowed);
    }

    public void inputValueAllowedCity() {
        mainMethods.sendKey("//*[@id='city']", cityAllowed);
    }

    public void inputValueAllowedZip() {
        mainMethods.sendKey("//*[@id='postcode']", zipAllowed);
    }

    public void inputValueAllowedPhone() {
        mainMethods.sendKey("//*[@id='phone']", phoneAllowed);
    }

    public void inputValueAllowedMobile() {
        mainMethods.sendKey("//*[@id='phone_mobile']", phoneAllowed);
    }

    /**
     * moved to MainMethods
     * @param
     * @param
     */
    //General
//    public void inputValueNotAllowed(String xPath, String value) {
//        driver.findElement(By.xpath(xPath)).sendKeys(value);
//    }

    public void inputValueNotAllowedCompany() {
        mainMethods.sendKey("//*[@id='company']", companyNotAllowed);
    }

    public void inputValueNotAllowedAddress() {
        mainMethods.sendKey("//*[@id='address1']", addressNotAllowed);
    }

    public void inputValueNotAllowedCity() {
        mainMethods.sendKey("//*[@id='city']", cityNotAllowed);
    }

    public void inputValueNotAllowedZip() {
        mainMethods.sendKey("//*[@id='postcode']", zipNotAllowed);
    }

    public void inputValueNotAllowedPhone() {
        mainMethods.sendKey("//*[@id='phone']", phoneNotAllowed);
    }

    public void inputValueNotAllowedMobile() {
        mainMethods.sendKey("//*[@id='phone_mobile']", phoneNotAllowed);
    }

    /**
     * moved to MainMethods
     * @param
     */
    //General
//    public void inputValueAlphaNumeric(String xPath) {
//        driver.findElement(By.xpath(xPath)).sendKeys(testFieldAlphaNumeric);
//    }
    public void inputValueAlphaNumericEmail() {
        mainMethods.inputValueAlphaNumeric("//*[@id='email']");
    }

    /**
     * moved to MainMethods
     * @param
     * @return
     */
    //General
//    public SignInPage inputValueRandomEmail(String xPath) {
//        driver.findElement(By.xpath(xPath)).sendKeys(emailO);
//        return this;
//    }

    public SignInPage inputEmail() {
        mainMethods.inputValueRandomEmail("//*[@id='email_create']");
        return this;
    }
    public SignInPage inputEmailAuthorization() {
        mainMethods.inputValueRandomEmail("//*[@id='email']");
        return this;
    }

    public SignInPage inputEmailCreateAnAccount(String email) {
        mainMethods.inputEmail("//*[@id='email_create']", email);
        return this;
    }

    public SignInPage inputEmailInvalidCreateAnAccount() {
        mainMethods.inputEmailInvalid("//*[@id='email_create']", emailInvalid);
        return this;
    }

    public SignInPage inputEmailInvalidAlreadyRegistered() {
        mainMethods.inputEmailInvalid("//*[@id='email']", emailInvalid);
        return this;
    }

    public SignInPage inputEmailAlreadyRegistered(String email) {
        mainMethods.inputEmail("//*[@id='email']", email);
        return this;
    }

    public SignInPage inputPasswordAlreadyRegistered(String password) {
        mainMethods.inputPassword("//*[@id='passwd']", password);
        return this;
    }

    public SignInPage inputPasswordAlreadyRegistered() {
        mainMethods.inputPassword("//*[@id='passwd']");
        return this;
    }

    public SignInPage inputPasswordInvalidAlreadyRegistered() {
        mainMethods.inputPassword("//*[@id='passwd']", passwordIncorrect);
        return this;
    }

    public String invalidMessageAlreadyRegisteredFirstText() {
        return mainMethods.getText("//div[@class='alert alert-danger']/p");
    }

    public String invalidMessageAlreadyRegisteredSecondText() {
        return mainMethods.getText("//div[@id='center_column']//child::li");
    }

    public String createAnAccountPersonalInfoTitle() {
        return mainMethods.getText("//h1[text()='Create an account']");
    }

    public String yourPersonalInfoSectionTitle() {
        return mainMethods.getText("//h3[text()='Your personal information']");
    }

    public String yourPersonalInfoTitle() {
        return mainMethods.getText("//div[@class='clearfix']/label");
    }

    public boolean mrRadioButtonDisplayed() {
        return mainMethods.isDisplayed("//label[@for='id_gender1']");
    }

    public boolean mrsRadioButtonDisplayed() {
        return mainMethods.isDisplayed("//label[@for='id_gender2']");
        //the same
//        mrsRadioButton = driver.findElement(By.xpath("//*[@id='id_gender2']"));
//        Boolean displayed = isDisplayed(mrsRadioButton);
//        return displayed;
    }

    public boolean redSign() {
        return mainMethods.isDisplayed("//div[@class='required form-group form-error']");
    }

    public boolean greenSign() {
        return mainMethods.isDisplayed("//div[@class='required form-group form-ok']");
    }

    public boolean errorInput() {
        return mainMethods.isDisplayed("//li[contains(text(),'is invalid')]");
    }

    public boolean customerAccount() {
        return mainMethods.isDisplayed("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span"); // will be re-written
    }

    public String errorInputIsInvalid() {
        return mainMethods.getText("//li[contains(text(),'is invalid')]");
    }

    public boolean errorInputRequiresDisplayed() {
        return mainMethods.isDisplayed("//li[contains(text(),'This country')]");
    }

    public String errorInputRequires() {
        return mainMethods.getText("//li[contains(text(),'This country')]");
    }

    public boolean errorInputEmptyField() {
        return mainMethods.isDisplayed("//li[contains(text(),'phone number')]");
    }

    public boolean errorInputEmptyPhoneTextDisplayed() {
        return mainMethods.isDisplayed("//p[@class='inline-infos']");
    }

    public String errorInputEmptyPhoneText() {
        return mainMethods.getText("//p[@class='inline-infos']");
    }

    public String errorInputEmptyFieldError() {
        return mainMethods.getText("//li[contains(text(),'phone number')]");
    }

    public String customerAccountText() {
        return mainMethods.getText("//*[@id='header']/div[2]/div/div/nav/div[1]/a"); //will be re-written
    }

    /**
     * moved to MainMethods
     * @param xPath
     * @return
     */
    //General isEnabled
//    public boolean isEnabled(String xPath) {
//        return (driver.findElement(By.xpath(xPath)).isEnabled()) ? true : false;
//    }

//    public Boolean isEnabled(WebElement webElement) {
////        enabledStatus = webElement.isEnabled();
////        return enabledStatus; //the same "return true;"
////        if (webElement.isEnabled()) {
////            return true;
////        }
////        else return false;
//
//        return (webElement.isEnabled()) ? true : false;
//    }

    public Boolean mrRadioButtonEnabled() {
        return mainMethods.isEnabled("//*[@id='id_gender1']");
    }

    public Boolean mrsRadioButtonEnabled() {
        return mainMethods.isEnabled("//*[@id='id_gender2']");
    }

    public Boolean signUpCheckBox() {
        return mainMethods.isEnabled("//div[@id='uniform-newsletter']");
    }

    public Boolean offersCheckBox() {
        return mainMethods.isEnabled("//*[@id='optin']");
    }

    public String signUpCheckBoxName() {
        //String xPath = "//*[@id='account-creation_form']/div[1]/div[7]/label"; //the same
        //String xPath = "//*[@id='account-creation_form']/div[1]/div[7]"; //the same
        //String xPath = "//div[@class='checkbox']"; //the sme to the next
        return mainMethods.getText("//div[@class='checkbox']");
    }

    public String offersCheckBoxName() {
        //String xPath = "//*[@id='account-creation_form']/div[1]/div[7]/label"; //the same
        //String xPath = "//*[@id='account-creation_form']/div[1]/div[7]"; //the same
        //String xPath = "//div[@class='checkbox']"; //the sme to the next
        return mainMethods.getText("//label[@for='optin']");
    }

    /**
     * moved to MainMethods
     */
    //General click
//    public void clickAction(String xPath) {
//        WebElement clickElement = driver.findElement(By.xpath(xPath));
//        clickElement.click();
//    }

    public void clickMrRadioButton() {
        mainMethods.clickElement("//*[@id='id_gender1']");
    }

    public void clickMrsRadioButton() {
        mainMethods.clickElement("//*[@id='id_gender2']");
    }

    public void clickSignUpCheckBox() {
        mainMethods.clickElement("//*[@id='uniform-newsletter']");
    }

    public void clickOffersCheckBox() {
        mainMethods.clickElement("//*[@id='optin']");
    }

    public void signOutButtonClick() {
        mainMethods.clickElement("//a[@class='logout']");
    }

    /**
     * moved to MainMethods
     * @param
     * @return
     */
    //General selectedStatus
//    public boolean selectedStatus(WebElement webElement) {
//        return webElement.isSelected();
//    }

    public boolean selectedStatusMr() {
        return mainMethods.selectedStatus(driver.findElement(By.xpath("//*[@id='id_gender1']")));
    }

    public boolean selectedStatusMrs() {
        return mainMethods.selectedStatus(driver.findElement(By.xpath("//*[@id='id_gender2']")));
    }

    public boolean selectedSignUpCheckBox() {
        return mainMethods.selectedStatus(driver.findElement(By.xpath("//*[@id='newsletter']")));
    }

    public boolean selectedOffersCheckBox() {
        return mainMethods.selectedStatus(driver.findElement(By.xpath("//*[@id='optin']")));
    }

    /**
     * moved to MainMethods
     * @param
     * @return
     */
    //General
//    public int[] generalDropDownIntAllOptions(String xPath) {
//        //Find the dropdown element by xPath
//        Select select = new Select(driver.findElement(By.xpath(xPath)));
//        //Get list of web elements
//        List<WebElement> list = select.getOptions();
//        list.remove(0);
//        List<Integer> bufferListStringToInteger = new ArrayList<>();
//        for (WebElement optionOfDropDown : list) {
//            bufferListStringToInteger.add(Integer.parseInt(optionOfDropDown.getText()
//                    .replaceAll("&nbsp;", "").trim()));
//        }
//        int[] dropDown = bufferListStringToInteger.stream().mapToInt(i -> i).toArray();
//        return dropDown;
//    }

    public int[] dropDownDaysAllOptions() {
        return mainMethods.generalDropDownIntAllOptions("//*[@id='days']");
    }

    public SignInPage selectDropDownDaysOptionByValue() {
        Select select = new Select(driver.findElement(By.xpath("//*[@id='days']")));
        select.selectByValue("6");
        select.getFirstSelectedOption().getText();
        return this;
    }

    public int[] dropDownYearsAllOptions() {
        return mainMethods.generalDropDownIntAllOptions("//*[@id='years']");
    }

    /**
     * moved to MainMethods
     * @param
     * @return
     */
    //General
//    public List<String> generalConverterWebElementToList(String xPath) {
//        List<WebElement> list = new Select(driver.findElement(By.xpath(xPath))).getOptions();
//        List<String> listString = new ArrayList<>();
//        for (WebElement optionsOfDropDown : list) {
//            listString.add(optionsOfDropDown.getText()
//                    .replaceAll("&nbsp;", "").trim());
//        }
//        return listString;
//    }

    public List<String> dropDownMonthsAllOptions() {
        return mainMethods.generalConverterWebElementToList("//*[@id='months']");
    }

    public List<String> dropDownStatesAllOptions() {
        return mainMethods.generalConverterWebElementToList("//*[@id='id_state']");
    }

    public void clickRegisterButton() {
        mainMethods.clickElement("//button[@id='submitAccount']");
    }

    /**
     * moved to MainMethods
     * @param
     * @return
     */
    //General
//    public boolean iFemptyField(String xPath) {
//        return (driver.findElement(By.xpath(xPath)).getAttribute("value").isEmpty()) ? true : false;
//        }

    public boolean emptyFieldEmail() {
        return mainMethods.iFemptyField("//*[@id='email']");
    }

    public boolean emptyFieldFirstName() {
        return mainMethods.iFemptyField("//*[@id='customer_firstname']");
    }

    public boolean emptyFieldLastName() {
        return mainMethods.iFemptyField("//*[@id='customer_lastname']");
    }

    public boolean emptyFieldPassword() {
        return mainMethods.iFemptyField("//*[@id='passwd']");
    }

    /**
     * moved to MainMethods
     * @return
     */
//    public String valueOfField(String xPath, String value) {
//        return driver.findElement(By.xpath(xPath))
//                .getAttribute(value);
//    }

    public String valueOfEmailFieldHomePage() {
        return mainMethods.valueOfField("//*[@id='email_create']", "value");
    }

    public String valueOfEmailField() {
        return mainMethods.valueOfField("//*[@id='email']","value");
    }

    public String valueOfFirstNameOneField() {
        return mainMethods.valueOfField("//*[@id='customer_firstname']","value");
    }

    public String valueOfFirstNameTwoField() {
        return mainMethods.valueOfField("//*[@id='firstname']", "value");
    }

    public String valueOfLastNameOneField() {
        return mainMethods.valueOfField("//*[@id='customer_lastname']","value");
    }

    public String valueOfLastNameTwoField() {
        return mainMethods.valueOfField("//*[@id='lastname']", "value");
    }

    /**needs to move to Base Page object class
     *
     * @param xPath
     * @return
     */
    public List<String> getListOfOptions(String xPath) {
        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
        List<String> strings = new ArrayList<>();
        for(WebElement eachElement : elementName){
            strings.add(eachElement.getText());
        }
        return strings;
    }

    /**
     * moved to MainMethods
     * @param xPath
     * @return
     */
    //General including check if field is cleaned
//    public boolean deleteValue(String xPath) {
//        WebElement field = driver.findElement(By.xpath(xPath));
//        field.clear();
//        return field.getText().isEmpty();
//    }

    public boolean deleteValueEmail() {
        return mainMethods.deleteValue("//*[@id='email']");
    }

    public boolean deleteValueFirstName() {
        return mainMethods.deleteValue("//*[@id='customer_firstname']");
    }

    public boolean deleteValueLastName() {
        return mainMethods.deleteValue("//*[@id='customer_lastname']");
    }

    public boolean  deleteValuePassword() {
        return mainMethods.deleteValue("//*[@id='passwd']");
    }

    public String countryDropDownFirstOption() {
        Actions action = new Actions(driver);
        WebElement country = driver.findElement(By.xpath("//*[@id='id_country']"));
        action.moveToElement(country).build().perform();
        country.click();

        Select select = new Select(country);
        select.selectByIndex(0);
        return select.getFirstSelectedOption().getText();
    }

    public String statesDropDownOptionByValue() {
        Actions action = new Actions(driver);
        WebElement states = driver.findElement(By.xpath("//*[@id='id_state']"));
        action.moveToElement(states).build().perform();
        states.click();

        Select select = new Select(states);
        select.selectByValue("FL");
        return select.getFirstSelectedOption().getText();
    }

    public String statesDropDownOptionFirst() {
        Actions action = new Actions(driver);
        WebElement states = driver.findElement(By.xpath("//*[@id='id_state']"));
        action.moveToElement(states).build().perform();
        states.click();

        Select select = new Select(states);
        select.selectByIndex(0);
        return select.getFirstSelectedOption().getText();
    }

    public WebElement errorAlert() {
        return driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
    }

    // is not verified
    public String alertText(WebElement errorAlert) {
        Alert confirmation = driver.switchTo().alert();
        String alertText = confirmation.getText();
        return alertText;
    }

    public String firstNameFieldOneName() {
        return mainMethods.getText("//label[@for='customer_firstname']");
    }

    public String firstNameFieldTwoName() {
        return mainMethods.getText("//label[@for='firstname']");
    }

    public String lastNameFieldTOneName() {
        return mainMethods.getText("//label[@for='customer_lastname']");
    }

    public String lastNameFieldTwoName() {
        return mainMethods.getText("//label[@for='lastname']");
    }

    public String emailFieldName() {
        return mainMethods.getText("//label[@for='email']");
    }

    public String passwordFieldName() {
        return mainMethods.getText("//label[@for='passwd']");
    }

    public String passwordFieldHelpText() {
        return mainMethods.getText("//span[contains(text(),'(Five')]");
    }

    public String dateOfBirthFieldName() {
        return mainMethods.getText("//label[contains(text(),'Date of Birth')]");
    }

    public String yourAddressSectionName() {
        return mainMethods.getText("//*[text()='Your address']");
    }

    public String companyFieldName() {
        return mainMethods.getText("//label[@for='company']");
    }

    public String addressFieldName() {
        return mainMethods.getText("//label[@for='address1']");
    }

    public String addressFieldHelpText() {
        return mainMethods.getText("//span[contains(text(),'Street')]");
    }

    public String cityFieldName() {
        return mainMethods.getText("//label[@for='city']");
    }

    public String countryFieldName() {
        return mainMethods.getText("//label[@for='id_country']");
    }

    public String additionalInfoFieldName() {
        return mainMethods.getText("//label[@for='other']");
    }

    public String additionalInfoHelpText() {
        return mainMethods.getText("//p[contains(text(),'You must')]");
    }

    public String homePhoneFieldName() {
        return mainMethods.getText("//label[@for='phone']");
    }

    public String mobilePhoneFieldName() {
        return mainMethods.getText("//label[@for='phone_mobile']");
    }

    public String assignAliasFieldName() {
        return mainMethods.getText("//label[@for='alias']");
    }

    public String assignAliasFieldValue() {
        return mainMethods.valueOfField("//*[@id='alias']", "value");
    }

    public String registerButtonName() {
        return mainMethods.getText("//button[@id='submitAccount']");
    }

    public String requiredText() {
        return mainMethods.getText("//span[text()='Required field']");
    }

    /**
     * moved to MainMethods
     * @param xPath
     */
    //General
//    public void inputValueAlphabetic(String xPath) {
//        driver.findElement(By.xpath(xPath)).sendKeys(textFieldAlphabetic);
//    }

//    public void inputValueNumeric(String xPath) {
//        driver.findElement(By.xpath(xPath)).sendKeys(testFieldNumeric);
//    }

    public void inputValueFirstNameLetters() {
        mainMethods.inputValueAlphabetic("//*[@id='customer_firstname']");
    }

    public void inputValueFirstNameDigits() {
        mainMethods.inputValueNumeric("//*[@id='customer_firstname']");
    }

    public void inputValueLastNameLetters() {
        mainMethods.inputValueAlphabetic("//*[@id='customer_lastname']");
    }

    public void inputValueLastNameDigits() {
        mainMethods.inputValueNumeric("//*[@id='customer_lastname']");
    }

    public void inputValuePassword(String value) {
        mainMethods.inputPassword("//*[@id='passwd']", value);
    }

    public void clickAnyWhere() throws AWTException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        robot.mouseMove(50,50);
        actions.click().build().perform();
    }
}

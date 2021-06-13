package wrapperMethods;

import logsOld.LogOld;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.objects.rewritten.BasePageObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GeneralSeleniumMethods extends BasePageObject {
    public WebDriver driver;

    String textFieldAlphabetic = RandomStringUtils.randomAlphabetic(5);
    String testFieldAlphaNumeric = RandomStringUtils.randomAlphanumeric(5);
    String testFieldNumeric = RandomStringUtils.randomNumeric(5);
    String testField = RandomStringUtils.random(2, 0, 53, false, true);
    String emailO = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";

    // Constructor
    public GeneralSeleniumMethods(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * method for element hover
     * @param hoverElement hoverOverElement general
     * @return instance of page (this)
     */
    public GeneralSeleniumMethods hoverOverElement(WebElement hoverElement) {
        LogOld.logOld("Element is hovered");
        Actions actions = new Actions(driver);

        actions.moveToElement(hoverElement).perform();
        return this;
    }

    /**
     * method hoverElementTwo, used in CartPage
     * @param webElement
     */
    public void hoverElementTwo(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    /**
     * general isDisplayed
     * @param webElement
     * @return true or false
     */
    public boolean isDisplayed(WebElement webElement) {
        return (webElement.isDisplayed()) ? true : false;
    }

    /**
     * general isEnabled
     * @param webElement
     * @return true or false
     */
    public boolean isEnabled(WebElement webElement) {
        return (webElement.isEnabled()) ? true : false;
    }

    /**
     * general isSelected
     * @param webElement
     * @return true or false
     */

    public boolean selectedStatus(WebElement webElement) {
        return (webElement.isSelected()) ? true : false;
    }

    /**
     * general check if Empty
     * @param webElement
     * @return true or false
     */
    public boolean iFemptyField(WebElement webElement) {
        return (webElement.getAttribute("value").isEmpty()) ? true : false;
    }

    /**
     * general delete value and check if empty
     * @param webElement
     * @return empty field
     */
    public boolean deleteValue(WebElement webElement) {
        webElement.clear();
        return webElement.getText().isEmpty();
    }

    /**
     * method for all click actions
     * @param webElement click on elements general
     */
    public void clickAction(WebElement webElement) {
        webElement.click();
    }

    /**
     * General click
     * @param webElement
     */
    public void clickElement(WebElement webElement) {
        webElement.click();
    }

    /**
     * General double click
     * @param webElement
     */
    public void doubleClickElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.doubleClick(webElement).perform();
    }

    /**
     * General click several times
     * @param webElement
     */
    public void clickPlusSeveralTimes(WebElement webElement) {
        Actions actions = new Actions(driver);
        int count = 5;
        while(count>0) {
            actions.click(webElement).perform();
            count -=1;
        }
    }

    /**
     * general click AnyWhere
     * @throws AWTException
     */
    public void clickAnyWhere() throws AWTException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        robot.mouseMove(50,50);
        actions.click().build().perform();
    }

    /**
     * general getText
     * @param webElement
     * @return element's text
     */
    public String getText(WebElement webElement) {
        return webElement.getText();
    }

    /**
     * general getAttribute
     * @param webElement
     * @return element's value
     */
    public String valueOfField(WebElement webElement, String value) {
        return webElement.getAttribute(value);
    }

    /**
     * general convert text to digit
     * @param webElement
     * @return
     */
    public float textToDigits(WebElement webElement) {
        //DecimalFormat df = new DecimalFormat("#.00");
        return Float.parseFloat(webElement.getText()
                .replace("$", ""));
    }

    /**
     * general getUrl
     * @return
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * general get (put value)
     */
    public void get(String value) {
      driver.get(value);
    }

    /**
     * general getTitle
     * @return
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * general sendKey, input value
     * @param webElement
     * @param value
     * @return
     */
    public void sendKey(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

//    //General sendKey
//    public void sendKey(String xPath, String value) {
//        driver.findElement(By.xpath(xPath)).sendKeys(value);
//    }
    /**
     * general inputValueAlphaNumeric
     * @param webElement
     */
    public void inputValueAlphabetic(WebElement webElement) {
        webElement.sendKeys(textFieldAlphabetic);
    }

    /**
     * general inputValueAlphaNumeric
     * @param webElement
     */
    public void inputValueAlphaNumeric(WebElement webElement) {
        webElement.sendKeys(RandomStringUtils.randomAlphabetic(5));
    }

    /**
     * general inputValueNumeric
     * @param webElement
     */
    public void inputValueNumeric(WebElement webElement) {
        webElement.sendKeys(testFieldNumeric);
    }

    /**
     * general input random email
     * @param webElement
     * @return
     */
    public GeneralSeleniumMethods inputValueRandomEmail(WebElement webElement) {
        webElement.sendKeys("Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com");
        return this;
    }

    /**
     * general input invalid email
     */
    public GeneralSeleniumMethods inputEmailInvalid(WebElement webElement, String value) {
        webElement.sendKeys(value);
        return this;
    }

    /**
     * general input custom email
     * @param webElement
     * @param email
     * @return
     */
    public GeneralSeleniumMethods inputEmail(WebElement webElement, String email) {
        webElement.sendKeys(email);
        return this;
    }

    /**
     * general input password with overloading
     * @param password
     * @return
     */
    //Overloading
    public GeneralSeleniumMethods inputPassword(WebElement webElement, String password) {
        webElement.sendKeys(password);
        return this;
    }

    public GeneralSeleniumMethods inputPassword(WebElement webElement) {
        webElement.sendKeys();
        return this;
    }

    /**
     *
     * @param webElement
     * @return
     */
    public List<String> getListOfOptions(WebElement webElement) {
        List<WebElement> elementName = (List<WebElement>) webElement;
        List<String> strings = new ArrayList<>();
        for (WebElement eachElement : elementName) {
            strings.add(eachElement.getText());
        }
        return strings;
    }

    /**
     * take all options from dropdown
     */
    public int[] generalDropDownIntAllOptions(WebElement webElement) {
        //Find the dropdown element by xPath
        Select select = new Select(webElement);
        //Get list of web elements
        java.util.List<WebElement> list = select.getOptions();
        list.remove(0);
        List<Integer> bufferListStringToInteger = new ArrayList<>();
        for (WebElement optionOfDropDown : list) {
            bufferListStringToInteger.add(Integer.parseInt(optionOfDropDown.getText()
                    .replaceAll("&nbsp;", "").trim()));
        }
        int[] dropDown = bufferListStringToInteger.stream().mapToInt(i -> i).toArray();
        return dropDown;
    }

    /**
     * general ConverterWebElementToList
     * @param webElement
     * @return
     */
    public List<String> generalConverterWebElementToList(WebElement webElement) {
        List<WebElement> list = new Select(webElement).getOptions();
        List<String> listString = new ArrayList<>();
        for (WebElement optionsOfDropDown : list) {
            listString.add(optionsOfDropDown.getText()
                    .replaceAll("&nbsp;", "").trim());
        }
        return listString;
    }

    /**
     * selectValueFromDropDown
     * @param webElement
     * @param value
     */
    public void selectValueFromDropDown(WebElement webElement, String value) {
        Select dropDown = new Select(webElement);
        dropDown.selectByVisibleText(value);
    }

    /**
     * submit form
     * @param webElement
     */
    public void submitForm(WebElement webElement) {
        webElement.submit();
    }

    // is not verified
    public String alertText(WebElement webElement) {
        Alert confirmation = driver.switchTo().alert();
        String alertText = confirmation.getText();
        return alertText;
    }
}


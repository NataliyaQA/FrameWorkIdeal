package utils;

import logs.Log;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainMethods {
    public static WebDriver driver;

    String textFieldAlphabetic = RandomStringUtils.randomAlphabetic(5);
    String testFieldAlphaNumeric = RandomStringUtils.randomAlphanumeric(5);
    String testFieldNumeric = RandomStringUtils.randomNumeric(5);
    //String testField = RandomStringUtils.random(15, 6, 10, true, true);
    String testField = RandomStringUtils.random(2, 0, 53, false, true);
    String emailO = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";


    public MainMethods(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * method for element hover
     * @param hoverElement hoverOverElement general
     * @return instance of page (this)
     */
    public MainMethods hoverOverElement(WebElement hoverElement) {
        Log.log("Element is hovered");
        Actions actions = new Actions(driver);

        actions.moveToElement(hoverElement);
        actions.perform();
        return this;
    }

    /**
     * method hoverElementTwo, used in CartPage
     * @param xPath
     */
    public void hoverElementTwo(String xPath) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(xPath))).perform();
    }

    /**
     * general isDisplayed
     * @param xPath
     * @return
     */
    public boolean isDisplayed(String xPath) {
        return driver.findElement(By.xpath(xPath)).isDisplayed() ? true : false;
    }

    /**
     * general isEnabled
     * @param xPath
     * @return
     */
    public boolean isEnabled(String xPath) {
        return (driver.findElement(By.xpath(xPath)).isEnabled()) ? true : false;
    }

    /**
     * general isSelected
     * @param
     * @return
     */
    public boolean selectedStatus(WebElement webElement) {
        return webElement.isSelected();
    }

    /**
     * general check if Empty
     * @param
     * @return
     */
    public boolean iFemptyField(String xPath) {
        return (driver.findElement(By.xpath(xPath)).getAttribute("value").isEmpty()) ? true : false;
    }

    /**
     * general delete value and check if empty
     * @param
     * @return
     */
    public boolean deleteValue(String xPath) {
        WebElement field = driver.findElement(By.xpath(xPath));
        field.clear();
        return field.getText().isEmpty();
    }

    /**
     * method for all click actions
     * @param clickElement click on elements general
     */
    public void clickAction(WebElement clickElement) {
        clickElement.click();
    }

    /**
     * General click
     * @param xPath
     */
    public void clickElement(String xPath) {
        driver.findElement(By.xpath(xPath)).click();
    }

    /**
     * General double click
     * @param xPath
     */
    public void doubleClickElement(String xPath) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath(xPath))).perform();
    }

    /**
     * General click several times
     * @param xPath
     */
    public void clickPlusSeveralTimes(String xPath) {
        Actions actions = new Actions(driver);
        int count = 5;
        while(count>0) {
            actions.click(driver.findElement(By.xpath(xPath))).perform();
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
     * @param xPath
     * @return
     */
    public String getText(String xPath) {
        return driver.findElement(By.xpath(xPath)).getText();
    }

    /**
     * general getAttribute
     * @param xPath
     * @return
     */
    public String valueOfField(String xPath, String value) {
        return driver.findElement(By.xpath(xPath))
                .getAttribute(value);
    }

    /**
     * general convert text to digit
     * @param xPath
     * @return
     */
    public float textToDigits(String xPath) {
        //DecimalFormat df = new DecimalFormat("#.00");
        return Float.parseFloat(driver.findElement(By.xpath(xPath)).getText()
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
     * general getTitle
     * @return
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * general sendKey, input value
     * @param xPath
     * @param value
     */
    public void sendKey(String xPath, String value) {
        driver.findElement(By.xpath(xPath)).sendKeys(value);
    }

    /**
     * general inputValueAlphaNumeric
     * @param xPath
     */
    public void inputValueAlphabetic(String xPath) {
        driver.findElement(By.xpath(xPath)).sendKeys(textFieldAlphabetic);
    }

    /**
     * general inputValueAlphaNumeric
     * @param xPath
     */
    public void inputValueAlphaNumeric(String xPath) {
        driver.findElement(By.xpath(xPath))
                .sendKeys(RandomStringUtils.randomAlphabetic(5));
    }

    /**
     * general inputValueNumeric
     * @param xPath
     */
    public void inputValueNumeric(String xPath) {
        driver.findElement(By.xpath(xPath)).sendKeys(testFieldNumeric);
    }

    /**
     * general input random email
     * @param xPath
     * @return
     */
    public MainMethods inputValueRandomEmail(String xPath) {
        driver.findElement(By.xpath(xPath)).sendKeys("Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com");
        return this;
    }

    /**
     * general input invalid email
     */
    public MainMethods inputEmailInvalid(String xPath, String value) {
        driver.findElement(By.xpath(xPath)).sendKeys(value);
        return this;
    }

    /**
     * general input custom email
     * @param xPath
     * @param email
     * @return
     */
    public MainMethods inputEmail(String xPath, String email) {
        driver.findElement(By.xpath(xPath)).sendKeys(email);
        return this;
    }

    /**
     * general input password with overloading
     * @param password
     * @return
     */
    //Overloading
    public MainMethods inputPassword(String xPath, String password) {
        driver.findElement(By.xpath(xPath)).sendKeys(password);
        return this;
    }

    public MainMethods inputPassword(String xPath) {
        driver.findElement(By.xpath(xPath)).sendKeys();
        return this;
    }

    /**
     * take all options from dropdown
     */
    public int[] generalDropDownIntAllOptions(String xPath) {
        //Find the dropdown element by xPath
        Select select = new Select(driver.findElement(By.xpath(xPath)));
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
     * @param xPath
     * @return
     */
    public List<String> generalConverterWebElementToList(String xPath) {
        List<WebElement> list = new Select(driver.findElement(By.xpath(xPath))).getOptions();
        List<String> listString = new ArrayList<>();
        for (WebElement optionsOfDropDown : list) {
            listString.add(optionsOfDropDown.getText()
                    .replaceAll("&nbsp;", "").trim());
        }
        return listString;
    }

    /**
     * selectValueFromDropDown
     * @param xPath
     * @param value
     */
    public void selectValueFromDropDown(String xPath, String value) {
        Select dropDown = new Select(driver.findElement(By.xpath(xPath)));
        dropDown.selectByVisibleText(value);
    }

    /**
     * submit form
     * @param xPath
     */
    public void submitForm(String xPath) {
        driver.findElement(By.xpath(xPath)).submit();
    }

}



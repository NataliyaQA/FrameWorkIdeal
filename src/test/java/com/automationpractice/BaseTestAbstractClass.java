package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import wrapperBrowsers.WrapperBrowsers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTestAbstractClass {
    public WebDriver driver = WrapperBrowsers.getDriver();

    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe"); // moved to Wrapper

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterMethod
    public void after(){
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown() {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }

    public static int generateRandomIntInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}

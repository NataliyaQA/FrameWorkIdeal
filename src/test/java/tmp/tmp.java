package tmp;

import com.automationpractice.BaseTestAbstractClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tmp extends BaseTestAbstractClass {

    String stringUrlWomenPage = "https://google.com";


    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrlWomenPage);

    }
    @Test
    public void googleTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
    }

//    @Test
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Data\\Temp\\FrameWorkTemplate\\src\\main\\resources\\drivers\\chromedriver.exe"); // moved to Wrapper
//        WebDriver driver = new ChromeDriver();
////        System.setProperty("webdriver.gecko.driver", "C:\\Data\\Temp\\FrameWorkTemplate\\src\\main\\resources\\drivers\\geckodriver.exe"); // moved to Wrapper
////        WebDriver driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        //driver.manage().window().maximize();
//        driver.get("http://automationpractice.com/");

        //Deleting all the cookies
        //driver.manage().deleteAllCookies();
    }



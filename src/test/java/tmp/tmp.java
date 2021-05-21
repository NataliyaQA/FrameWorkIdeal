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
}

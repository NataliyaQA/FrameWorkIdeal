package pageObjects.objects.rewritten;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import wrapperBrowsers.WrapperBrowsers;

public class BasePageObject {

    //protected WebDriver driver;

    //Constructor
    public BasePageObject() {
        WebDriver driver = WrapperBrowsers.getDriver();
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this); //Question: why we need it? Should it be here or in MainMethods.java?
        // Is it the same to "NameClass nameClass = new NameClass();" ?

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,100); //Question:
        // how methods will know about this lazy loading concept? Should I write it anywhere more?
        PageFactory.initElements(factory, this);
    }
}

package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {

    WebDriver driver;
    String webURL;

    //Annotation -> JUnit
    @Test
    public void pageTitleTest() {
        System.out.println("Running the test");
        driver.get(webURL);

        String actualTitle = driver.getTitle();
        String expectedTitle = "SDET Training | Account Management";
        Assert.assertEquals(expectedTitle, actualTitle);
        //Assert.fail();
    }

    @Before
    public void setUp() {
        System.out.println("Initializing the driver");
        driver = utilities.DriverFactory.open("chrome");
        webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
    }

    @After
    public void tearDown() {
        System.out.println("Closing the driver");
        driver.close();
    }
}

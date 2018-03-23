package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ATagTest {

    WebDriver driver;

    @Test
    public void loginElementsPresentTest() {
        System.out.println("Running test");
        boolean createAccountPresent = false;

        // Making a List of all A tags
        List<WebElement> aElements = driver.findElements(By.tagName("a"));

        int numOfAElements = aElements.size();
        System.out.println("There are "+numOfAElements+" on the page.");

        for (WebElement aElement : aElements) {
            System.out.println(aElement.getText());
            if(aElement.getText().equals("CREATE ACCOUNT")){
                createAccountPresent = true;
            }
        }

        // Assertion
        Assert.assertTrue(createAccountPresent);
    }

    @BeforeMethod
    public void setUp () {
        System.out.println("Initializing the driver");
        String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

        driver = utilities.DriverFactory.open("chrome");
        driver.get(webUrl);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing the driver");
        driver.close();
    }
}

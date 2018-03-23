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

        List<WebElement> aElements = driver.findElements(By.tagName("a"));

        for (WebElement aElement : aElements) System.out.println(aElement.getText());
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

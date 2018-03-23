package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPresentTestNG {
    WebDriver driver;

    //-- Annotations -- @Test
    @Test
    public void loginElementsPresentTest() {
        System.out.println("Running test");

        boolean loginEmailText = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
        boolean loginPasswordText = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();

        Assert.assertTrue(loginEmailText, "Email textbox present");
        Assert.assertTrue(loginPasswordText);
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

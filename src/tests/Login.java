package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class Login {

    @Test
    public void loginTestPOM(){
        // 1. Initialize the driver
        WebDriver driver = utilities.DriverFactory.open("Firefox");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        // 2. Enter the login info (Login Page)
        LoginPage loginPage = new LoginPage(driver);

        // 3. Get confirmation (Dashboard Page)

        // 4. Close the driver
        driver.quit();
    }
}

package demos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateAccount {

    public static void main(String[] args){
        // 1. Create WebDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\brgey\\SDET\\Software\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // 2. Nav to account page >> click on create account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        // 3. Fill out form

        // 4. Get confirmation

        // 5. Close the browser
    }
}

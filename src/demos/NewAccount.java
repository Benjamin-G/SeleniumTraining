package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

    public static void main(String[] args){
        String name = "Mary Smith";
        String email ="ms@testemail.com";
        String password = "mspass";
        String country = "Denmark";
        String phoneNumber = "1231231234";
        String browserType = "chrome";
        WebDriver driver;

        String gender;
        String weeklyEmail;
        String monthlyEmail;
        String occassionalEmail;


        // 1/2. open browser // Nav to account page >> click on create account
        driver = utilities.DriverFactory.open(browserType);

        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        driver.findElement(By.cssSelector("a.btn")).click();

        // 3. Fill out form
            driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys(name);
            driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);

            driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys(phoneNumber); //rel xpath

            driver.findElement(By.cssSelector("input[id=\"MainContent_txtPassword\"]")).sendKeys(password); //little more common than xpath
            driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(password);

            driver.findElement(By.id("MainContent_Female")).click();

            new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);

            driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();

            driver.findElement(By.id("MainContent_btnSubmit")).click();

        // 4. Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFRIMATION: "+conf);

        // 5. Close the browser
        driver.close();
    }
}

package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

    public static void main(String[] args){
        // 1. Create WebDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\brgey\\SDET\\Software\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // 2. Nav to account page >> click on create account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.linkText("Create Account")).click();

        // 3. Fill out form
        driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Mary Smith");
        driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testemail.com");

        driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("1231231234"); //rel xpath

        driver.findElement(By.cssSelector("input[id=\"MainContent_txtPassword\"]")).sendKeys("mspass"); //little more common than xpath
        driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("mspass");

        driver.findElement(By.id("MainContent_Female")).click();

        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Denmark");

        driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();

        driver.findElement(By.id("MainContent_btnSubmit")).click();

        // 4. Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFRIMATION: "+conf);

        // 5. Close the browser
        driver.close();
    }
}

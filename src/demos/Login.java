package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) {
        
        // 1. define the web driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\brgey\\SDET\\Software\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 2. open the web browser, navigate to the web app
        //  http://sdettraining.com/trguitransactions/AccountManagement.aspx
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        // Find elements
        // 3. enter email address
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");

        // 4. enter password
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");

        // 5. click log in
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

        // 6. get confirmation
        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("CONFIRMATION: "+message);

        String pageTitle = driver.getTitle();
        System.out.println("PAGE TITLE: "+ pageTitle);

        // 7. close the browser
        driver.close();
    }
}

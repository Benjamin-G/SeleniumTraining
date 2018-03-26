package stepImplementations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BDDLoginTest {
    WebDriver driver;

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page(){
        System.out.println("User is on the login page");
        String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

        driver = utilities.DriverFactory.open("Chrome");
        driver.get(webUrl);
    }

    @When("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password(){
        System.out.println("User enters username and password");
        String username = "tim@testemail.com";
        String password = "trpass";

        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
        click_login();
    }

    @When("^user enters email (.*)$")
    public void user_enters_username(String username){
        System.out.println("TESTING: "+ username);
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
    }

    @And("^user enters password (.*)$")
    public void user_enters_password(String password){
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
        click_login();
    }

    public void click_login(){
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
    }

    @Then("^user gets confirmation$")
    public void user_gets_confirmation(){
        System.out.println("User gets confirmation");

        String conf = driver.findElement(By.id("conf_message")).getText();

        Assert.assertTrue(conf.contains("success"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

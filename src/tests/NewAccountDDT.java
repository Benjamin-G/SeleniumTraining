package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.CSV;

import java.util.List;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
    String name, email, phone, gender, password, country;
    boolean weeklyEmail, monthlyEmail, occasionalEmail;
    WebElement nameElement, emailElement, phoneElement, passwordElement,verifyPasswordElement,countryElement, maleRadio, femaleRadio, weeklyCheckbox, monthlyCheckbox, occasionalCheckbox, submitButton;
    WebDriver driver;

    // This is our test method
    @Test
    public void newAccountTest() {
        System.out.println("NEW RECORD: "+name+" "+email+" "+phone+" "+gender+" "+password+" "+country+ " "+ monthlyEmail+ " "+weeklyEmail+ " "+occasionalEmail);

        // Define web elements
        defineWebElements();

        // Fill out form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phone); //rel xpath
        passwordElement.sendKeys(password); //little more common than xpath
        verifyPasswordElement.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

        // Gender Radio Button Algorithm
        if(gender.equalsIgnoreCase("Male")){
            maleRadio.click();
        } else {
            femaleRadio.click();
        }

        // Check Box Algorithm just the weekly atm
        if (weeklyEmail) {
            if(!weeklyCheckbox.isSelected()){ weeklyCheckbox.click(); }
        } else {
            if(weeklyCheckbox.isSelected()) { weeklyCheckbox.click(); }
        }
        if (monthlyEmail) {
            if(!monthlyCheckbox.isSelected()){ monthlyCheckbox.click(); }
        } else {
            if(monthlyCheckbox.isSelected()) { monthlyCheckbox.click(); }
        }
        if (occasionalEmail) {
            if(!occasionalCheckbox.isSelected()){ occasionalCheckbox.click(); }
        } else {
            if(occasionalCheckbox.isSelected()) { occasionalCheckbox.click(); }
        }

        submitButton.click();
    }

    @Before
    public void setUp() {
        driver = utilities.DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.cssSelector("a.btn")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void defineWebElements() {
        //Define web elements
        nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        passwordElement = driver.findElement(By.cssSelector("input[id=\"MainContent_txtPassword\"]"));
        verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
        countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        maleRadio = driver.findElement(By.id("MainContent_Male"));
        femaleRadio = driver.findElement(By.id("MainContent_Female"));
        weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
        monthlyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail"));
        occasionalCheckbox = driver.findElement(By.name("ctl00$MainContent$checkUpdates"));
        submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
    }

    // This annotated metod is designed to pass parameters into the class via Constructor
    @Parameters
    public static List<String[]> getData() {
        return CSV.get("C:\\Users\\brgey\\SDET\\UserAccounts.csv");
    }

    // Constructor that passes parameters to the test method
    public NewAccountDDT(String name, String email, String phone, String gender, String password, String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.country = country;

        if (weeklyEmail.equals("TRUE")){ this.weeklyEmail = true;}
        else { this.weeklyEmail = false; }

        if (monthlyEmail.equals("TRUE")){ this.monthlyEmail = true;}
        else { this.monthlyEmail = false; }

        if (occasionalEmail.equals("TRUE")){ this.occasionalEmail = true;}
        else { this.occasionalEmail = false; }

    }
}

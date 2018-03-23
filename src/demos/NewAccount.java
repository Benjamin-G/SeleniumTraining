package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

    public static void main(String[] args){
        String name = "Mary Smith";
        String email ="ms@testemail.com";
        String password = "mspass";
        String country = "Denmark";
        String phoneNumber = "1231231234";
        String browserType = "firefox";
        String gender = "Female";
        boolean weeklyEmail = true;
        boolean monthlyEmail = false;
        boolean occassionalEmail = false;

        //Define WebDriver
        WebDriver driver;
        driver = utilities.DriverFactory.open(browserType);
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.cssSelector("a.btn")).click();

        //Define web elements
        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[id=\"MainContent_txtPassword\"]"));
        WebElement verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
        WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
        WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
        WebElement submmitButton = driver.findElement(By.id("MainContent_btnSubmit"));


        // Fill out form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phoneNumber); //rel xpath
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
            if(!weeklyCheckbox.isSelected()){
                weeklyCheckbox.click();
            }
        } else {
            if(!weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        }

        // Submit
        submmitButton.click();

        // Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        String expected = "Customer information added successfully";

        if(conf.contains(expected)){
            System.out.println("CONFRIMATION: "+conf);
        } else {
            System.out.println("TEST FAILED");
        }

        // Close the browser
        driver.close();
    }
}

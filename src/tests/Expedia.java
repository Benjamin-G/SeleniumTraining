package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Expedia {
    WebDriver driver;
    String browserType = "Chrome";
    String city = "New York, NY";
    String checkIn = "04/07/2018";
    String checkOut = "04/14/2018";
    String numOfGuest = "2";


    @Test
    public void hotelReservation(){
        // 1. Search
        driver.findElement(By.id("tab-hotel-tab-hp")).click();
        driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
        driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
        driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
        new Select(driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[4]/div[4]/label/select"))).selectByValue(numOfGuest);
        driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();

        // 2. Modify the search results page, give criteria
        driver.findElement(By.id("star4")).click();

        // 3. Analyze the results and make our selection

        // 4. Book Reservation

        // 5. Fill out contact / billing

        // 6. Get confirmation
    }

    @BeforeMethod
    public void setUp() {
        driver = utilities.DriverFactory.open(browserType);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}

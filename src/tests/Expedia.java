package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Expedia {
    WebDriver driver;
    String browserType = "Chrome";
    String city = "New York, NY";
    String checkIn = "04/07/2018";
    String checkOut = "04/14/2018";
    String numOfGuest = "2";
    String starRating = "star4";
    String searchResult = "2";


    @Test
    public void hotelReservation() throws InterruptedException {
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

        // Print the name of the city
        String actualCity = driver.findElement(By.className("section-header-main")).getText();
        System.out.println("CITY: "+ actualCity);

        // 2. Modify the search results page, give criteria
        driver.findElement(By.id(starRating)).click();

        // 3. Analyze the results and make our selection
        // Awaiting
        Thread.sleep(7000);

        WebDriverWait wait = new WebDriverWait(driver, 6);

        WebElement selectedHotel = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"resultsContainer\"]/section/article[3]/div[2]/div/a")));
        selectedHotel.click();

        // Tell web driver to switch windows
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        // Print hotel name and star rating
        String hotelName = driver.findElement(By.id("hotel-name")).getText();
        String hotelRating = driver.findElement(By.cssSelector("span[class=\"rating-scale\"]")).getText();
        System.out.println("HOTEL :"+hotelName);
        System.out.println("RATING :"+hotelRating);

        // 4. Book Reservation
        driver.findElement(By.xpath("//*[@id=\"rooms-and-rates\"]/div/article/table/tbody[1]/tr[1]/td[4]/div/div[1]/button")).click();

//        String price = driver.findElement(By.)
//        System.out.println();
        // 5. Fill out contact / billing

        // 6. Get confirmation
        // Create assertion if necessary
    }

    @BeforeMethod
    public void setUp() {
        driver = utilities.DriverFactory.open(browserType);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

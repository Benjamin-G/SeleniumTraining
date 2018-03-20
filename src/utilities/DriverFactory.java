package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver open(String browserType) {
        if(browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\brgey\\SDET\\Software\\geckodriver.exe");
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\brgey\\SDET\\Software\\MicrosoftWebDriver.exe");
            return new EdgeDriver();
        }
        else {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\brgey\\SDET\\Software\\chromedriver.exe");
            return new ChromeDriver();
        }
    }
}

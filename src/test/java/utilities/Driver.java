package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    static WebDriver driver;
    /*
     * Method that will create a driver object
     * if it was not created before,
     * and will returned it.
     * If driver was created before it will
     * return the previous driver object.
     * */

    public static WebDriver getDriver() {
        String browser = ConfigReader.getProperty("browser");
        //When we close the driver,driver will have some object,
        //but we can not use that object for next test scenario.

        if (driver == null || ((RemoteWebDriver)driver).getSessionId()==null) {
            //create driver object
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }else if(browser.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }else if(browser.equals("ie")){
                driver=new InternetExplorerDriver();
            }
        } else {
            return driver;
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }





}

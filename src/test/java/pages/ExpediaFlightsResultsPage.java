package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.TestBase;

public class ExpediaFlightsResultsPage extends TestBase {


        public ExpediaFlightsResultsPage(){
            WebDriver driver = Driver.getDriver();
            PageFactory.initElements(driver, this);
        }

        @FindBy(id = "stops-1")
        public WebElement oneStopButton;

        @FindBy(id = "support-cs")
        public WebElement supportButton;

        @FindBy(xpath = "//button[@class='btn ico-btn-chatNow']")
        public WebElement chatButton;
    }


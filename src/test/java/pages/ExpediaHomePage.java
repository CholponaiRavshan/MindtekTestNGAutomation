package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExpediaHomePage {

    public  ExpediaHomePage(){


        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);


    }
    @FindBy(xpath = "//a[@href='?pwaLob=wizard-flight-pwa']")
    public WebElement flightButton;


    @FindBy(xpath = "//*[@id='uitk-tabs-button-container']/div/li[2]/a/span")
    public WebElement oneWayButton;

    @FindBy(xpath = "//button[@aria-label='Leaving from']")
    public WebElement leavingFromButton;

    @FindBy(xpath = "//button[@aria-label='Going to']")
    public WebElement goingToButton;

    @FindBy(id= "d1-btn")
    public WebElement departingDate;

    @FindBy(xpath = "//button[@aria-label='Aug 28, 2021']")
    public WebElement getDepartingDate;

    @FindBy(xpath = "//button[@data-stid='apply-date-picker']")
    public WebElement doneButton;



    @FindBy(xpath = "//button[@data-testid='submit-button']")
    public WebElement searchButton;

    @FindBy(xpath = "//button[@data-stid='button-type-picker-trigger']")
    public WebElement englishButton;

    @FindBy(xpath = "//a[@href='?pwaLob=wizard-hotel-pwa-v2']")
    public WebElement stayButton;

}

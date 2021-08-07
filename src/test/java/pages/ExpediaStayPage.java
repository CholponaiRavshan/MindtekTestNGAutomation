package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExpediaStayPage {

    public ExpediaStayPage(){

        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@aria-label='Going to']")
    public WebElement goingToButton;

    @FindBy(xpath = "//button[@aria-label='Check-in August 20, 2021']")
    public WebElement getCheckInButton;


    @FindBy(xpath = "//button[@data-stid='apply-date-picker']")
    public WebElement doneButton;


    @FindBy(xpath = "//button[@data-testid='submit-button']")
    public WebElement getSearchButton;
}

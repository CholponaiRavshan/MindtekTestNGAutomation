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

    @FindBy(xpath = "d1-btn")
    public WebElement getCheckInButton;

    @FindBy(xpath = "//button[@aria-label='Check-in August 5, 2021']")
    public WebElement checkInDate;


    @FindBy(xpath = "//button[@data-stid='apply-date-picker']")
    public WebElement doneButton;

    @FindBy(id = "d2-btn")
    public WebElement getCheckOutButton;

    @FindBy(id = "//button[@aria-label='Aug 25, 2021 selected, current check out date.']")
    public WebElement checkOutDate;

    @FindBy(xpath = "//button[@data-stid='apply-date-picker']")
    public WebElement getDoneButton;

    @FindBy(xpath = "//button[@data-testid='submit-button']")
    public WebElement getSearchButton;
}

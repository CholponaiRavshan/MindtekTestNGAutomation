package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppCreateAccountPage {

    public StoreAppCreateAccountPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "id_gender1")
    public WebElement gender;

    @FindBy(id="customer_firstname")
    public WebElement firstNameBox;

    @FindBy(id="customer_lastname")
    public WebElement lastNameBox;

    @FindBy(id="email")
    public WebElement emailBox;

    @FindBy(id="passwd")
    public WebElement passwordBox;

    @FindBy(id="days")
    public WebElement daysBox;

    @FindBy(id="months")
    public WebElement monthsBox;

    @FindBy(id="years")
    public WebElement yearsBox;

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement state;

    @FindBy(id = "postcode")
    public WebElement zipcode;

    @FindBy(id = "id_country")
    public WebElement country;

    @FindBy(id = "other")
    public WebElement additional;

    @FindBy(id = "phone_mobile")
    public WebElement phoneNumber;

    @FindBy(id = "submitAccount")
    public WebElement registerButton;

}

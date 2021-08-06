package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExpediaLanguageChangePage {

    public ExpediaLanguageChangePage(){

    WebDriver driver= Driver.getDriver();
    PageFactory.initElements(driver,this);

    }
    @FindBy(id = "language-selector")
    public WebElement languageSelectButton;

    @FindBy(xpath = "//div[@class='uitk-scrim fade-button']")
    public WebElement saveButton;


}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazeDemoFlightsPage;
import pages.BlazedemoHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.List;

public class BlazedemoTest2 extends TestBase {


    @Test(groups = {"regression"})
    public void test1(){
        BlazedemoHomePage blazedemoHomePage=new BlazedemoHomePage();
        BlazeDemoFlightsPage blazeDemoFlightsPage=new BlazeDemoFlightsPage();

        driver.get(ConfigReader.getProperty("BlazeDemoURL"));
        blazedemoHomePage.findFlightsButton.click();
        List<WebElement>prices= blazeDemoFlightsPage.prices;

        for (WebElement element : prices){
            String priceStr=element.getText();//
            priceStr=priceStr.substring(1);
            double priceDouble=Double.parseDouble(priceStr);
            Assert.assertTrue(priceDouble<1000);
        }

    }
    @Test(groups = {"regression"})
    public void test2(){
        BlazedemoHomePage blazedemoHomePage=new BlazedemoHomePage();
        BlazeDemoFlightsPage blazeDemoFlightsPage=new BlazeDemoFlightsPage();

        driver.get(ConfigReader.getProperty("BlazeDemoURL"));

        Select select=new Select(blazedemoHomePage.fromCityDropdown);
        select.selectByVisibleText("Boston");
        select=new Select(blazedemoHomePage.toCityDropdown);
        select.selectByVisibleText("London");
        blazedemoHomePage.findFlightsButton.click();
        String actualText=blazeDemoFlightsPage.headerText.getText();
        String expectedText="Flights from Boston to London:";
        Assert.assertEquals(actualText,expectedText);
    }

}

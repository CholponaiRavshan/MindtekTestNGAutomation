package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppCreateAccountPage;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

import java.util.Random;

public class StoreRegisterFunctionalityTests extends TestBase {

    @DataProvider(name = "signUpDataProvider")
    public static Object[][] testData(){
        Object[][] data = new Object[][]{
                {"John","Doe","123456",DataUtils.generateRandomNumber(30)+"","1","2021","1234 W Ardmore","Chicago","13","12345","21","12345678"},//Set 1
                {"Kim","Yi","abcdefg","1","12","1980","5678 MyRoad st.","New York","32","54321","21","987654321"},//Set2
                {"Patel","Harsh","abc1234","1","12","1980","5678 MyRoad st.","New York","32","54321","21","987654321"}//Set3

        };
        return data;
    }

    @Test(dataProvider = "signUpDataProvider",groups = {"regression","smoke"})
    public void test1(String firstName, String lastName, String password, String day,String month,String year,String address,
                      String city, String state,String zipcode,String country,String phoneNumber) {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();
        StoreAppCreateAccountPage storeAppCreateAccountPage = new StoreAppCreateAccountPage();

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.loginButton.click();
        storeAppCreateAccountPage.emailBox.sendKeys(DataUtils.generateEmail());
        storeAppLoginPage.submitButton.click();
        storeAppCreateAccountPage.gender.click();
        storeAppCreateAccountPage.firstNameBox.sendKeys(firstName);
        storeAppCreateAccountPage.lastNameBox.sendKeys(lastName);
        storeAppCreateAccountPage.passwordBox.sendKeys(password);
        //This will dropdown instead of Select method
        BrowserUtils.selectByValue(storeAppCreateAccountPage.daysBox, day);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.monthsBox, month);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.yearsBox, year);
        storeAppCreateAccountPage.address.sendKeys(address);
        storeAppCreateAccountPage.city.sendKeys(city);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.state, state);
        storeAppCreateAccountPage.zipcode.sendKeys(zipcode);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.country, country);
        storeAppCreateAccountPage.phoneNumber.sendKeys(phoneNumber);
        storeAppCreateAccountPage.registerButton.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account - My Store";
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title " + actualTitle + " didn't match with expected title " + expectedTitle);


    }
}
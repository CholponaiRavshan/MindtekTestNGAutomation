package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppCreateAccountPage;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import utilities.*;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class StoreRegisterFunctionalityTests extends TestBase {

    String email;
    String password;

    @DataProvider(name = "signUpDataProvider")
    public static Object[][] testData(){
        Object[][] data = new Object[][]{
                {"John","Doe","67890",DataUtils.generateRandomNumber(30)+"","1","2021","1234 W Ardmore","Chicago","13","12345","21","12345678"},//Set 1
                {"Kim","Yi","abcef","1","12","1980","5678 MyRoad st.","New York","32","54321","21","987654321"},//Set2
                {"Patel","Harsh","bnm123","1","12","1980","5678 MyRoad st.","New York","32","54321","21","987654321"}//Set3

        };
        return data;
    }

    @Test(dataProvider = "signUpDataProvider",groups = {"regression","smoke"})
    public void test1(String firstName, String lastName, String password, String day,String month,String year,String address,
                      String city, String state,String zipcode,String country,String phoneNumber) throws IOException {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();
        StoreAppCreateAccountPage storeAppCreateAccountPage = new StoreAppCreateAccountPage();

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.loginButton.click();
        email=DataUtils.generateEmail();
        storeAppLoginPage.emailBox.sendKeys(email);
        storeAppLoginPage.submitButton.click();
        storeAppCreateAccountPage.gender.click();
        storeAppCreateAccountPage.firstNameBox.sendKeys(firstName);
        storeAppCreateAccountPage.lastNameBox.sendKeys(lastName);
        this.password=password;
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
        BrowserUtils.takeScreenshot("SignUpValidation");
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account - My Store";
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title " + actualTitle +
                " didn't match with expected title " + expectedTitle);




    }

    //Login functionality
    @Test(dependsOnMethods = {"test1"}, groups = {"regression","smoke"})
    public void test2() throws IOException {
        StoreAppHomePage storeAppHomePage=new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage=new StoreAppLoginPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.loginButton.click();
        storeAppLoginPage.loginEmailBox.sendKeys(email);
        storeAppLoginPage.loginpasswordBox.sendKeys(password);
        storeAppLoginPage.loginbutton.click();
        BrowserUtils.takeScreenshot("LogInValidation");
        String actualTitle=driver.getTitle();
        String expectedTitle="My account - My Store";
        Assert.assertEquals(actualTitle,expectedTitle,"Title for log in in did not match");

    }


    /**
     * This method will take a screenshot of browser.
     * Ex;
     *     .takeScreenshot("LoginTest");
     */
    public  static void takeScreenshot(String name) throws IOException {
        WebDriver driver= Driver.getDriver();
        File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                  //instead of copypath we use user.dir
        String path=System.getProperty("user.dir")+"/src/test/resources/screenshots/"+name+System.currentTimeMillis()+".png";
        File file= new File(path);
        FileUtils.copyFile(screenshot,file);
    }
    /**
     * This method will til elemnt is clickable
     * Ex:
     *      .waitElementToBeClickable(element);-> returns element;
     *
     */
    public static WebElement waitElementToBeVisible(WebElement element){
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        WebElement element1 =wait.until(ExpectedConditions.visibilityOf(element));//Explicitly wait
        return element1;
    }
    /**
     * This method will scroll the page.
     * Ex:
     *       .scroll(250);
     */
    public static void scroll(int pixels){
        WebDriver driver=Driver.getDriver();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,"+pixels+")");
    }
}
package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExpediaHomePage;
import pages.ExpediaFlightsResultsPage;
import pages.ExpediaLanguageChangePage;
import pages.ExpediaStayPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.TestBase;

public class ExpediaTestCase extends TestBase {

    @Test
    public void test1() {

        driver.get(ConfigReader.getProperty("ExpediaAppURL"));
        ExpediaHomePage expediaHomePage = new ExpediaHomePage();
        expediaHomePage.flightButton.click();
        expediaHomePage.oneWayButton.click();
        expediaHomePage.leavingFromButton.sendKeys("Chicago (ORD - O'Hare Intl.)" + Keys.ENTER);
        expediaHomePage.goingToButton.sendKeys("Paris (PAR - All Airports)" + Keys.ENTER);
        expediaHomePage.departingDate.click();
        expediaHomePage.getDepartingDate.click();
        expediaHomePage.doneButton.click();
        expediaHomePage.searchButton.click();
        String expectedTitle = "ORD to PAR flights";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }
        @Test
        public void test2(){

            driver.get(ConfigReader.getProperty("ExpediaAppURL"));
            ExpediaHomePage expediaHomePage = new ExpediaHomePage();
            ExpediaFlightsResultsPage expediaFlightsResultsPage=new ExpediaFlightsResultsPage();
            expediaHomePage.flightButton.click();
            expediaHomePage.oneWayButton.click();
            expediaHomePage.leavingFromButton.sendKeys("Chicago (ORD - O'Hare Intl.)" + Keys.ENTER);
            expediaHomePage.goingToButton.sendKeys("Paris (PAR - All Airports)" + Keys.ENTER);
            expediaHomePage.departingDate.click();
            expediaHomePage.getDepartingDate.click();
            expediaHomePage.doneButton.click();
            expediaHomePage.searchButton.click();
            expediaFlightsResultsPage.oneStopButton.click();
            String expectedTitle = "ORD to PAR flights";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);

        }
        @Test
        public void test3() throws InterruptedException {

            driver.get(ConfigReader.getProperty("ExpediaAppURL"));
            ExpediaFlightsResultsPage expediaFlightsResultsPage=new ExpediaFlightsResultsPage();
            ExpediaHomePage expediaHomePage = new ExpediaHomePage();
            expediaHomePage.flightButton.click();
            expediaHomePage.oneWayButton.click();
            expediaHomePage.leavingFromButton.sendKeys("Chicago (ORD - O'Hare Intl.)" + Keys.ENTER);
            expediaHomePage.goingToButton.sendKeys("Paris (PAR - All Airports)" + Keys.ENTER);
            expediaHomePage.departingDate.click();
            expediaHomePage.getDepartingDate.click();
            expediaHomePage.doneButton.click();
            expediaHomePage.searchButton.click();
            expediaFlightsResultsPage.oneStopButton.click();
            expediaFlightsResultsPage.supportButton.click();
            expediaFlightsResultsPage.chatButton.click();
            String expectedTitle = "Customer Service Portal";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);


        }
        @Test
        public void test4(){

            driver.get(ConfigReader.getProperty("ExpediaAppURL"));
            ExpediaHomePage expediaHomePage = new ExpediaHomePage();
            ExpediaLanguageChangePage expediaLanguageChangePage=new ExpediaLanguageChangePage();
            expediaHomePage.englishButton.click();
            expediaLanguageChangePage.languageSelectButton.click();
            BrowserUtils.selectByValue(expediaLanguageChangePage.languageSelectButton,"Espanol");
            expediaLanguageChangePage.saveButton.click();

        }
        @Test
        public void test5(){

             driver.get(ConfigReader.getProperty("ExpediaAppURL"));
             ExpediaHomePage expediaHomePage=new ExpediaHomePage();
             ExpediaStayPage expediaStayPage=new ExpediaStayPage();
             expediaHomePage.stayButton.click();
             expediaStayPage.goingToButton.sendKeys("Honolulu"+Keys.ENTER);
             expediaStayPage.getCheckInButton.click();
             expediaStayPage.doneButton.click();
             expediaStayPage.getSearchButton.click();
             String expectedTitle = "Honolulu Hotel Search Results";
             String actualTitle = driver.getTitle();
             Assert.assertEquals(actualTitle, expectedTitle);




        }


}

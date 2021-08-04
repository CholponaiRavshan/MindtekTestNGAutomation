package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class BlazeDemoTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= Driver.getDriver();
    }

    @Test
    public void test1(){
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));
        driver.findElement(By.name("fromPort")).sendKeys(ConfigReader.getProperty("from"));
        driver.findElement(By.name("toPort")).sendKeys(ConfigReader.getProperty("to"));
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]/input")).click();
        String expectedPrice="$765.32";
        String actualPrice=driver.findElement(By.xpath("/html/body/div[2]/p[3]")).getText();
        Assert.assertEquals(actualPrice,expectedPrice);

    }
    @Test
    public void test2(){
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));
        driver.findElement(By.name("fromPort")).sendKeys(ConfigReader.getProperty("from"));
        driver.findElement(By.name("toPort")).sendKeys(ConfigReader.getProperty("to"));
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@value='Choose This Flight']")).click();
        driver.findElement(By.id("inputName")).sendKeys(ConfigReader.getProperty("name"));
        driver.findElement(By.id("address")).sendKeys(ConfigReader.getProperty("Adress"));
        driver.findElement(By.id("city")).sendKeys(ConfigReader.getProperty("City"));
        driver.findElement(By.id("state")).sendKeys(ConfigReader.getProperty("State"));
        driver.findElement(By.id("state")).sendKeys(ConfigReader.getProperty("ZipCode"));
        driver.findElement(By.id("cardType")).sendKeys(ConfigReader.getProperty("CardType"));
        driver.findElement(By.id("creditCardNumber")).sendKeys(ConfigReader.getProperty("CreditCardNumber"));
        driver.findElement(By.id("creditCardMonth")).sendKeys(ConfigReader.getProperty("Month"));
        driver.findElement(By.id("creditCardYear")).sendKeys(ConfigReader.getProperty("Year"));
        driver.findElement(By.id("nameOnCard")).sendKeys(ConfigReader.getProperty("NameonCard"));
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
       // String expectedMessage="Thank you for your purchase today!";
        //String actualMessage=driver.findElement(By.xpath("//div/h1")).getText();
       // System.out.println(actualMessage);
       // Assert.assertEquals(actualMessage,expectedMessage);
       // String expextedLast4Number="7890";
       // String actualLast4Number=


    }
    @Test
    public void test3() {
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));
        driver.findElement(By.name("fromPort")).sendKeys("from");
        driver.findElement(By.name("toPort")).sendKeys("to");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@value='Choose This Flight']")).click();
        driver.findElement(By.id("inputName")).sendKeys("name1");
        driver.findElement(By.id("address")).sendKeys("Adress1");
        driver.findElement(By.id("city")).sendKeys("City1");
        driver.findElement(By.id("state")).sendKeys("State1");
        driver.findElement(By.id("state")).sendKeys("ZipCode1");
        driver.findElement(By.id("cardType")).sendKeys("CardType1");
        driver.findElement(By.id("creditCardNumber")).sendKeys("CreditCardNumber1");
        driver.findElement(By.id("creditCardMonth")).sendKeys("Month1");
        driver.findElement(By.id("creditCardYear")).sendKeys("Year1");
        driver.findElement(By.id("nameOnCard")).sendKeys("NameonCard1");



    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

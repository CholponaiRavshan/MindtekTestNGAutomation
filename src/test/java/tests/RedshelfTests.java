package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class RedshelfTests extends TestBase {
    /*
     * @BeforeMethod->inherited from TestBase class
     * @AfterMethod
     * @Test
     * */






    @Test(groups = {"regression"})
    public void test1() {
        driver.get(ConfigReader.getProperty("RedShelfURl"));
        String expectedTitle = "RedShelf";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test(groups = {"regression,smoke"})
    public void test2() {
        driver.get(ConfigReader.getProperty("RedShelfURl"));
        driver.findElement(By.id("search-catalog-navbar")).sendKeys("Java data structure" + Keys.ENTER);
        driver.findElement(By.xpath("//a[@class='title text-book-title'][1]")).click();
        String bookName = driver.findElement(By.xpath("//h1/span")).getText();
        String title = driver.getTitle();
        //We should validate that title starts with book name.
        //validate- sravnit' expected with actual
        Assert.assertTrue(title.startsWith(bookName));
    }
    @Test(groups = {"regression,smoke"})
    public void test3(){
        driver.get(ConfigReader.getProperty("RedShelfURl"));
        driver.findElement(By.id("search-catalog-navbar")).sendKeys("Java data structure" + Keys.ENTER);
        driver.findElement(By.xpath("//a[@class='title text-book-title'][1]")).click();
        String bookName = driver.findElement(By.xpath("//h1/span")).getText();
       String eISBN=driver.findElement(By.xpath("//span[@class='significant-isbn']")).getText();
        System.out.println(eISBN);
        driver.findElement(By.id("search-catalog-navbar")).sendKeys(eISBN+Keys.ENTER);
        driver.findElement(By.xpath("//a[@class='title text-book-title'][1]")).click();
        String bookNameISBN = driver.findElement(By.xpath("//h1/span")).getText();
        //Validation part; validate
        Assert.assertEquals(bookNameISBN,bookName);
    }


}
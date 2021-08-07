package tests;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.StoreAppHomePage;
import pages.StoreAppShoppingCartPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

import javax.swing.*;

public class StoreAddCartTests extends TestBase {

    @Test(groups = {"regression","smoke"})
    public void addCartFunctionalityTest(){
        StoreAppHomePage storeAppHomePage=new StoreAppHomePage();
        StoreAppShoppingCartPage storeAppShoppingCartPage= new StoreAppShoppingCartPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        String itemPrice=storeAppHomePage.prices.get(1).getText();


        BrowserUtils.scroll(1000);
        BrowserUtils.hoverOver(storeAppHomePage.item1);

        storeAppHomePage.addToCartItem1.click();
        //Here we are validating
        String addCartSuccessMessage=BrowserUtils.waitElementToBeVisible(storeAppHomePage.addCartSuccessMessage).getText();
        String expectedSuccessMessage="Product successfully added to your shopping cart";

        //SoftAssert-> even our validation is not work, it will keep continue all code running.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(addCartSuccessMessage,expectedSuccessMessage);

        String quantity=storeAppHomePage.quantity.getText();
        String total=storeAppHomePage.totalPrice.getText();

        //itemPrice,quantity,total
        // itemPrice->$16.51
        //quantity->1
        //total->33.2

        //here we r taking out $sign

        double itemPriceDouble= DataUtils.remove$AndConvertToDouble(itemPrice);
        double quantityDouble=Double.parseDouble(quantity);//"1"->1.0
        double totalDouble=DataUtils.remove$AndConvertToDouble(total);
        double expectedPrice=itemPriceDouble*quantityDouble;
        double actualPrice=totalDouble;

        Assert.assertEquals(actualPrice,expectedPrice);

        storeAppHomePage.proceedToCheckOut.click();

        String totalProduct=storeAppShoppingCartPage.totalProduct.getText();
        double totalProductDouble=DataUtils.remove$AndConvertToDouble(totalProduct);

        Assert.assertEquals(actualPrice,totalProductDouble);

        String shippingAmount=storeAppShoppingCartPage.totalShipping.getText();
        double shippingAmountDouble=DataUtils.remove$AndConvertToDouble(shippingAmount);

        String taxAmount=storeAppShoppingCartPage.tax.getText();
        double taxAmountDouble=DataUtils.remove$AndConvertToDouble(taxAmount);

       String actualTotal=storeAppShoppingCartPage.totalPrice.getText();
        double actualTotalDouble=DataUtils.remove$AndConvertToDouble(actualTotal);

        double expectedTotal=totalProductDouble+shippingAmountDouble+taxAmountDouble;

        softAssert.assertEquals(actualTotalDouble,expectedTotal);

        softAssert.assertAll();




    }

}

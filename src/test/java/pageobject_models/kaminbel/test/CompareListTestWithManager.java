package pageobject_models.kaminbel.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject_models.kaminbel.page.KaminbelComparePage;
import pageobject_models.kaminbel.page.KaminbelMainPage;
import pageobject_models.kaminbel.page.KaminbelSearchResults;
import pageobject_models.kaminbel.page.KaminbelCatalogPage;

public class CompareListTestWithManager {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserActionSetup () {WebDriverManager.chromedriver().setup();}

    @BeforeTest (alwaysRun = true)
    public void setupTest() {driver = new ChromeDriver();}

    @Test (description = "Adding two items to comparison list")
    public void KaminbelProductCompareListIsNotEmpty () {
        KaminbelMainPage mainPage = new KaminbelMainPage(driver);

        KaminbelSearchResults searchResultsPage = mainPage
                .openPage()
                .openSearchbar()
                .inputQuery("Jotul");

        KaminbelCatalogPage catalogPage = searchResultsPage
                .searchQueryResultLink();

        KaminbelComparePage compareListPage = catalogPage
                .addToCompareList()
                .transitionToCompareList();

        int itemsCount = compareListPage.getCompareListCounter();
        System.out.println("Number of items in list: " + itemsCount);

        Assert.assertTrue(itemsCount > 1, "Adding two items to the compare list failed!");
    }

    @AfterMethod (alwaysRun = true)
    public void browserTeardown () {
        driver.quit();
        driver = null;
    }
}

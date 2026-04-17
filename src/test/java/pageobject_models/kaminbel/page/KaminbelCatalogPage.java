package pageobject_models.kaminbel.page;

import org.openqa.selenium.*;

import static waits.customConditions.waitForElementLocatedBy;

public class KaminbelCatalogPage {

    private WebDriver driver;
    private JavascriptExecutor js;

    private By firstCompareButton = By.xpath("//a[@data-id='15215']");
    private By secondCompareButton = By.xpath("//a[@data-id='15212']");
    private By compareListButton = By.xpath("//a[@href='/product/compare.php']");

    public KaminbelCatalogPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public KaminbelCatalogPage addToCompareList() {
        WebElement firstCompareOption = waitForElementLocatedBy(driver, firstCompareButton);
        WebElement secondCompareOption = waitForElementLocatedBy(driver, secondCompareButton);
        js.executeScript("arguments[0].click();", firstCompareOption);
        js.executeScript("arguments[0].click();", secondCompareOption);
        return this;
    }

    public KaminbelComparePage transitionToCompareList() {
        WebElement compareListIcon = waitForElementLocatedBy(driver, compareListButton);
        js.executeScript("arguments[0].click();", compareListIcon);
        return new KaminbelComparePage(driver);
    }
}

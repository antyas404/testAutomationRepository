package pageobject_models.kaminbel.page;

import org.openqa.selenium.*;

import static waits.customConditions.waitForElementToBeClickable;

public class KaminbelSearchResults {

    private WebDriver driver;
    private JavascriptExecutor js;

    private By productLink = By.xpath("//div[@class='search-page']//a[contains(@href, 'kaminnye-topki/jotul/?sphrase_id')]");


    public KaminbelSearchResults(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public KaminbelCatalogPage searchQueryResultLink() {
        WebElement searchResult = waitForElementToBeClickable(driver, productLink);
        js.executeScript("arguments[0].click();", searchResult);
        return new KaminbelCatalogPage(driver);
    }
}

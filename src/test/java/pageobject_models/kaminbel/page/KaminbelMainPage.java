package pageobject_models.kaminbel.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.customConditions;

import java.time.Duration;

import static waits.customConditions.waitForElementLocatedBy;

public class KaminbelMainPage {

    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    private By searchIcon = By.xpath("//div[@id='headerfixed']//div[contains(@class,'header-search') and @title='Поиск']");
    private By searchQuery = By.xpath("//input[@placeholder='Поиск по сайту']");

    public KaminbelMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.js = (JavascriptExecutor) driver;
    }

    public KaminbelMainPage openPage() {
        driver.get("https://kaminbel.by");
        driver.manage().window().maximize();
        wait.until(customConditions.jQueryAJAXsCompleted());
        return this;
    }

    public KaminbelMainPage openSearchbar() {
        WebElement searchbarIcon = waitForElementLocatedBy(driver, searchIcon);
        js.executeScript("arguments[0].click();", searchbarIcon);
        return this;
    }

    public KaminbelSearchResults inputQuery(String query) {
        WebElement input = waitForElementLocatedBy(driver, searchQuery);
        input.sendKeys(query);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        return new KaminbelSearchResults(driver);
    }
}

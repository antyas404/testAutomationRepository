package pageobject_models.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.RabotaScript_customConditions;

import java.time.Duration;

import static waits.RabotaScript_customConditions.waitForElementLocatedBy;

public class RabotaMainPage {

    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait waitAJAX;

    private By searchVac = By.id("a11y-search-input");
    private By searchButton = By.xpath("//span[text()='Найти']");


    public RabotaMainPage(WebDriver driver) {
        this.driver = driver;
        this.waitAJAX = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.js = (JavascriptExecutor) driver;
    }

    public RabotaMainPage openPage() {
        driver.get("https://rabota.by");
        driver.manage().window().maximize();
        waitAJAX.until(RabotaScript_customConditions.jQueryAJAXsCompleted());
        return this;
    }

    public RabotaMainPage searchForVacancy(String query) {
        WebElement input = waitForElementLocatedBy(driver, searchVac);
        input.sendKeys(query);
        return this;
    }

    public RabotaSearchResults searchSubmit() {
        WebElement submitSearchQuery = driver.findElement(searchButton);
        js.executeScript("arguments[0].click();", submitSearchQuery);
        return new RabotaSearchResults(driver);
    }
}

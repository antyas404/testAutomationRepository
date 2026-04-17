package pageobject_models.rabotaby.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.customConditions;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static waits.customConditions.waitForElementLocatedBy;

public class RabotaSearchResults {

    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait waitAJAX;

    private By popup = By.xpath("//div[@role='dialog']");
    private By cookieButton = By.className("buttons--dm34U4FDi7sgksi_");
    private By vacCountBefore = By.xpath("//span[@data-qa='vacancies-total-found']");
    private By vacCountAfter = By.xpath("//div[@data-qa='vacancies-search-header']");
    private By radioButton = By.xpath("//div[@data-qa='cell-text-content' and .//div[contains(., '1') and contains(., '3')]]");

    public RabotaSearchResults(WebDriver driver) {
        this.driver = driver;
        this.waitAJAX = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.js = (JavascriptExecutor) driver;
    }

    public RabotaSearchResults popupClose() {
        try {
            WebElement popupAppear = waitForElementLocatedBy(driver, popup);
            driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        } catch (TimeoutException ignored) {}
        return this;
    }

    public RabotaSearchResults cookieAgree() {
        List<WebElement> cookie = Collections
                .singletonList(waitForElementLocatedBy(driver, cookieButton));
        cookie.getLast().click();
        return this;
    }

    public static int getCount(WebElement element) {
        String text = element.getText();
        String digits = text.replaceAll("[^0-9]", "");
        return Integer.parseInt(digits);
    }

    public int vacCountBefore() {
        WebElement countBefore = waitForElementLocatedBy(driver, vacCountBefore);
        return getCount(countBefore);
    }

    public int vacCountAfter() {
        WebElement countAfter = waitForElementLocatedBy(driver, vacCountAfter);
        return getCount(countAfter);
    }

    public RabotaSearchResults filterApplying() {
        WebElement filterButton = driver.findElement(radioButton);
        js.executeScript("arguments[0].scrollIntoView();", filterButton);
        js.executeScript("arguments[0].click();", filterButton);
        waitAJAX.until(customConditions.jQueryAJAXsCompleted());
        js.executeScript("window.scrollTo(0, 0);");
        return this;
    }
}

package waits;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class customConditions {

    public static ExpectedCondition<Boolean> jQueryAJAXsCompleted () {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor)
                        driver).executeScript("return (window.jQuery != null) && (jQuery.active == 0); ");
            }
        };
    }

    public static @NonNull WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .presenceOfElementLocated(by));
    }

    public static @NonNull WebElement waitForElementToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .elementToBeClickable(by));
    }
}

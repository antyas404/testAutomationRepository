package pageobject_models.kaminbel.page;

import org.openqa.selenium.*;

import java.util.List;

public class KaminbelComparePage {

    private WebDriver driver;

    private By reserveButton = By.xpath("//span[contains(@data-name, 'order_product')]");

    public KaminbelComparePage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCompareListCounter() {
        List<WebElement> items = driver.findElements(reserveButton);
        return items.size();
    }
}

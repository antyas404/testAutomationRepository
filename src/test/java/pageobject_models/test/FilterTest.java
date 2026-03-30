package pageobject_models.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_models.page.RabotaMainPage;
import pageobject_models.page.RabotaSearchResults;

public class FilterTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserActionSetup () {
        driver = new ChromeDriver();
    }

    @Test (description = "Vacancy search filter by work experience of candidate")
    public void RabotaExpFilterIsCorrect () {
        RabotaMainPage mainPage = new RabotaMainPage(driver);
        RabotaSearchResults resultsPage = mainPage
                .openPage()
                .searchForVacancy("QA Engineer")
                .searchSubmit()
                .popupClose();

        int before = resultsPage.vacCountBefore();
        System.out.println("Vacancies count BEFORE filter: " + before);

        resultsPage.cookieAgree()
                .filterApplying();

        int after = resultsPage.vacCountAfter();
        System.out.println("Vacancies count AFTER filter: " + after);

        Assert.assertNotEquals(after, before, "The number of vacancies has not changed!");
    }

    @AfterMethod (alwaysRun = true)
    public void browserTeardown () {
        driver.quit();
        driver = null;
    }
}

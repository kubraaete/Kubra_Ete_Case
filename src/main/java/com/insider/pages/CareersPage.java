package com.insider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    private By locationsSection = By.id("location-slider");
    private By teamsSection = By.cssSelector(".career-load-more");
    private By lifeSection = By.cssSelector(".elementor-element-populated.e-swiper-container");
    private By seeAllTeams = By.cssSelector("a.btn.btn-outline-secondary.loadmore");

    private By seeAllJobsLink = By.linkText("See all QA jobs");

    By qaMenuLink = By.xpath("//a[h3[text()='Quality Assurance']]");

    By header = By.xpath("//h1[contains(text(),'Quality Assurance')]");

    private By headerText = By.xpath("//h1[normalize-space(text())='Ready to disrupt?']");

    public void verifyViewRole() {
        List<WebElement> jobs = driver.findElements(By.cssSelector(".position-list-item-wrapper"));

        for (WebElement job : jobs) {
            String title = job.findElement(By.cssSelector(".position-title")).getText();
            String department = job.findElement(By.cssSelector(".position-department")).getText();
            String location = job.findElement(By.cssSelector(".position-location")).getText();

            Assert.assertTrue(title.contains("Quality Assurance"));
            Assert.assertTrue(department.contains("Quality Assurance"));
            Assert.assertTrue(location.contains("Istanbul, Turkiye"));
        }

        jobs.get(0).findElement(By.linkText("View Role")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("jobs.lever.co"));

        Assert.assertTrue(driver.getCurrentUrl().contains("jobs.lever.co"));

    }

    public void seeAllJobsLink() {
        WebElement careersLink = driver.findElement(seeAllJobsLink);
        careersLink.click();
    }

    public void filterLocation() {

        WebElement locationDropdown = driver.findElement(By.id("select2-filter-by-location-container"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationDropdown);
        locationDropdown.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//ul[@id='select2-filter-by-location-results']/li")
        ));

        for (WebElement option : options) {
            if(option.getText().equals("Istanbul, Turkiye")) {
                option.click();
                break;
            }
        }

    }
    public void filterDepartment() {

        WebElement departmentDropdown = driver.findElement(By.id("select2-filter-by-department-container"));
        departmentDropdown.click();

        List<WebElement> departmentOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//ul[@id='select2-filter-by-department-results']/li")));

        for (WebElement option : departmentOptions) {
            if (option.getText().equals("Quality Assurance")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
                option.click();
                break;
            }
        }
    }

    public boolean isCareersPageDisplayed() {
        return isElementDisplayed(headerText);  // BasePage’deki generic method
    }

    public boolean isLocationsBlockDisplayed() {
        return isElementDisplayed(locationsSection);
    }

    public boolean isTeamsBlockDisplayed() {
        return isElementDisplayed(teamsSection);
    }

    public boolean isLifeAtInsiderDisplayed() {
        return isElementDisplayed(lifeSection);
    }
    public boolean isQAFileDisplayed() {
        return isElementDisplayed(header);
    }

    public void goToQAPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement qaLink = wait.until(ExpectedConditions.elementToBeClickable(qaMenuLink));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", qaLink);
        Thread.sleep(500);
        qaLink.click();

    }
    public void seeAllTeams() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(seeAllTeams));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void isQADisplayed() {
        Assert.assertTrue(isQAFileDisplayed(), "QA is not visible");
    }

    public void verifyBlocks() {
        Assert.assertTrue(isLocationsBlockDisplayed(), "Locations block is not visible!");
        Assert.assertTrue(isTeamsBlockDisplayed(),"Teams block is not visible!" );
        Assert.assertTrue(isLifeAtInsiderDisplayed(),"Life at Insider block is not visible!");
    }

}

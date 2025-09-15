package com.insider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By companyMenu = By.xpath("//a[normalize-space(text())='Company']");
    private By careersLink = By.linkText("Careers");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void goToCareers() {
        hover(companyMenu);
        click(careersLink);
    }

    public boolean isCompanyMenuDisplayed() {
        return isElementDisplayed(companyMenu);
    }

    public boolean isHomePageDisplayed() {
        return driver.getTitle().contains("Insider");
    }

}

package pages;

import base.BaseTest;
import com.insider.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


    @Test
    public void verifyHomePageIsOpened() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not opened!");
    }

    @Test
    public void isCompanyMenuDisplayed() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isCompanyMenuDisplayed(), "CompanyMenu page is not opened!");
    }

    @Test
    public void goToCareers() {
        HomePage homePage = new HomePage(driver);
        homePage.goToCareers();
    }
}

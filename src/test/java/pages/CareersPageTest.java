package pages;

import base.BaseTest;
import com.insider.pages.CareersPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CareersPageTest extends BaseTest {

    private CareersPage careersPage;

    @BeforeClass
    public void initPage() {
        careersPage = new CareersPage(driver);
        driver.get("https://useinsider.com/careers/");
    }

    @Test
    public void verifyIsCareersPageDisplayed() {
        Assert.assertTrue(careersPage.isCareersPageDisplayed(), "careers page is not displayed!");
    }
    @Test
    public void verifyBlocks() {
        careersPage.verifyBlocks();
    }
    @Test
    public void verifygoToQAPage() throws InterruptedException {
        careersPage.seeAllTeams();
        careersPage.goToQAPage();
        careersPage.isQADisplayed();
        careersPage.seeAllJobsLink();
    }
    @Test
    public void filterLocationAndDepartment() throws InterruptedException {
        careersPage.filterLocation();
        Thread.sleep(5000);
        careersPage.filterDepartment();
        Thread.sleep(10000);
        careersPage.verifyViewRole();
        Thread.sleep(5000);
    }
    @Test
    public void verifyViewRole() {
        careersPage.verifyViewRole();
    }

@AfterClass
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}

package utils;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = "screenshots/" + result.getName() + "_" + System.currentTimeMillis() + ".png";
        try {
            FileUtils.copyFile(srcFile, new File(fileName));
            System.out.println("❌ Screenshot saved: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void onTestStart(ITestResult r) {}
    @Override public void onTestSuccess(ITestResult r) {}
    @Override public void onTestSkipped(ITestResult r) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult r) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}

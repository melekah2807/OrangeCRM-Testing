package utility;

import TestMethods.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class ExtentReportUtility implements ITestListener {
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Test-Report-" + timestamp + ".html";
        extentSparkReporter = new ExtentSparkReporter(System.getProperty ("user.dir")+"\\Reports/"+ reportName);
        extentSparkReporter.config().setDocumentTitle("Automation report");
        extentSparkReporter.config().setReportName("New Feature Testing");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        String os = context.getCurrentXmlTest().getParameter("os");
        extentReports.setSystemInfo("Operating System", os);
        String browser = context.getCurrentXmlTest().getParameter("browser");
        extentReports.setSystemInfo("Browser", browser);
    }
public void onTestSuccess(ITestResult result)
{
    extentTest = extentReports.createTest(result.getClass().getName());
    extentTest.assignCategory(result.getMethod().getGroups());
    extentTest.log(Status.PASS, result.getName()+" got Passed");
}

public void onTestFailure (ITestResult result)
{
    extentTest = extentReports.createTest(result.getClass().getName());
    extentTest.assignCategory(result.getMethod().getGroups());
    extentTest.log(Status.FAIL, result.getName()+"got Failed");
    /**String screenshot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BASE64);
    extentTest.addScreenCaptureFromBase64String(screenshot);**/
}
public void onFinish (ITestContext context)
{
    extentReports.flush();
}
}
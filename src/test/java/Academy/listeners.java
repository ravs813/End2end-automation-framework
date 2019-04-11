package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import resources.ExtentManager;
import resources.base;


public class listeners implements ITestListener  {
base b=new base();
private static Logger log =LogManager.getLogger(base.class.getName());
private static ExtentReports extent = ExtentManager.createInstance();
private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

public synchronized void onStart(ITestContext context) {
	log.info("Extent Reports Version 3 Test Suite started!");
}

public synchronized void onFinish(ITestContext context) {
	log.info(("Extent Reports Version 3  Test Suite is ending!"));
    extent.flush();
}

public synchronized void onTestStart(ITestResult result) {
	log.info((result.getMethod().getMethodName() + " started!"));
    ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
    test.set(extentTest);
}

public synchronized void onTestSuccess(ITestResult result) {
	log.info((result.getMethod().getMethodName() + " passed!"));
    test.get().pass("Test passed");
}

public synchronized void onTestFailure(ITestResult result) {
	try {
		b.getScreenshot(result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	log.info((result.getMethod().getMethodName() + " failed!"));
    test.get().fail(result.getThrowable());
}

public synchronized void onTestSkipped(ITestResult result) {
	log.info((result.getMethod().getMethodName() + " skipped!"));
    test.get().skip(result.getThrowable());
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	log.info(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
}
}
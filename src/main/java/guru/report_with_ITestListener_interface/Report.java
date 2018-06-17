package guru.report_with_ITestListener_interface;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Report implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("test is sterted ->" + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("test passed ->" + iTestResult.getName());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("test not passed ->" + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("test skipped ->"+iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Start ->"+iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish ->"+iTestContext.getName());
    }
}

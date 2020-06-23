package resources;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestNGListener implements ITestListener {

    BaseResourseClass base = new BaseResourseClass();

    public void onTestFailure(ITestResult result) {
        //screenshot
        try {
            base.getScreenshot(result.getName());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        //hey i am done
    }


}

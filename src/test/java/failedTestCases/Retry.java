package failedTestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	int initCount=0;
	int maxRetryCount=1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		 if(initCount<maxRetryCount) {
	        	initCount++;
	        	return true;
	        }
			return false;
		}

}

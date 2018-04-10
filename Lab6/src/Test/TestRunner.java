package Test;

import org.junit.runner.JUnitCore;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			org.junit.runner.Result result=JUnitCore.runClasses(TestSuitee.class);
			
			for(org.junit.runner.notification.Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
			System.out.println(result.wasSuccessful());
	}

}

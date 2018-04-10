package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestBasicCalculator.class,
	TestFieldCalculator.class
})
public class TestSuitee{
/*
	public static Test suite() {
		TestSuite suite = new TestSuite(TestSuitee.class.getName());
		//$JUnit-BEGIN$

		//$JUnit-END$
		return suite;
	}*/

}

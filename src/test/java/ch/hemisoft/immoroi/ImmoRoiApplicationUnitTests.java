package ch.hemisoft.immoroi;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.googlecode.junittoolbox.ParallelSuite;
import com.googlecode.junittoolbox.SuiteClasses;

@RunWith(ParallelSuite.class)
@SuiteClasses({"**/*Test.class"})
public class ImmoRoiApplicationUnitTests {

	@Test
	public void contextLoads() {
	}

}

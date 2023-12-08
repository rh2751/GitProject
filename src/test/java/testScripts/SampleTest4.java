package testScripts;

import org.testng.annotations.Test;

public class SampleTest4 {
	@Test(groups = "feature1")
	  public void test1() {
		  System.out.println("Test41 in Sample4");
	  }
	  
	  @Test(groups = "feature2")
	  public void test2() {
		  System.out.println("Test42 in Sample4");
	  }
	  
	  @Test(groups = "feature4")
	  public void test3() {
		  System.out.println("Test43 in Sample4");
	  }
	  
	  @Test(groups = "feature4")
	  public void test4() {
		  System.out.println("Test44  in Sample4");
	  }
}

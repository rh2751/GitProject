package testScripts;

import org.testng.annotations.Test;

public class SampleTest3 {
  @Test(groups = "feature1")
  public void test1() {
	  System.out.println("Test31 in Sample3");
  }
  
  @Test
  public void test2() {
	  System.out.println("Test32 in Sample3");
  }
  
  @Test(groups = "feature3")
  public void test3() {
	  System.out.println("Test33 in Sample3");
  }
  
  @Test(groups = "feature2")
  public void test4() {
	  System.out.println("Test34  in Sample3");
  }
}

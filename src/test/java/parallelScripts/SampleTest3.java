package parallelScripts;

import org.testng.annotations.Test;

public class SampleTest3 {
	@Test
	  public void test1() {
		long id = Thread.currentThread().getId();
		System.out.println("Test31 in Sample3..." + id);
	  }
	  
	  @Test
	  public void test2() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test32 in Sample3...." + id);
	  }
	  
	  @Test
	  public void test3() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test33 in Sample3...." + id);
	  }
	  
	  @Test
	  public void test4() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test34  in Sample3...." + id);
	  }
}

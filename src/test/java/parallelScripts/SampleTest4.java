package parallelScripts;

import org.testng.annotations.Test;

public class SampleTest4 {
	@Test
	  public void test1() {
		long id = Thread.currentThread().getId();
		System.out.println("Test41 in Sample4..." + id);
	  }
	  
	  @Test
	  public void test2() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test42 in Sample4...." + id);
	  }
	  
	  @Test
	  public void test3() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test43 in Sample4...." + id);
	  }
	  
	  @Test
	  public void test4() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test44  in Sample4...." + id);
	  }
}

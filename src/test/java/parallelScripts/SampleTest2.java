package parallelScripts;

import org.testng.annotations.Test;

public class SampleTest2 {
	@Test
	  public void test1() {
		long id = Thread.currentThread().getId();
		System.out.println("Test21 in Sample2..." + id);
	  }
	  
	  @Test
	  public void test2() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test22 in Sample2...." + id);
	  }
	  
	  @Test
	  public void test3() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test23 in Sample2...." + id);
	  }
	  
	  @Test
	  public void test4() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test24  in Sample2...." + id);
	  }
}

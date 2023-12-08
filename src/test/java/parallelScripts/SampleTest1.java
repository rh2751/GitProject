package parallelScripts;

import org.testng.annotations.Test;

public class SampleTest1 {
	@Test
	  public void test1() {
		long id = Thread.currentThread().getId();
		System.out.println("Test11 in Sample1..." + id);
	  }
	  
	  @Test
	  public void test2() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test12 in Sample1...." + id);
	  }
	  
	  @Test
	  public void test3() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test13 in Sample1...." + id);
	  }
	  
	  @Test
	  public void test4() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test14  in Sample1...." + id);
	  }
}

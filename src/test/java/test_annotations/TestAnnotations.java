package test_annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * see also src/main/java for more 
 * 
 * */

public class TestAnnotations {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest exec");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest exec");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod exec");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod exec");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass exec");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass exec");
	}

	@Test
	public void test1() {
		System.out.println("test1 exec");
	}
	
	@Test
	public void test2() {
		System.out.println("test2 exec");
	}
}

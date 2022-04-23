package testAnnotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
 * needs to install TestNg plugin in IDE
 * 
 * */

public class TestNGAssertDemo {
	
	//soft assertions
	SoftAssert soft = new SoftAssert();
	WebDriver driver;
	
	@Test
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "/home/hjoel87gmx/Downloads/chromedriver");
		driver = new ChromeDriver();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods="launch")
	public void openGoogle() {
		driver.get("https://www.google.com/");
		soft.assertEquals("Googlee", driver.getTitle()); //title is wrong
		//but with the help of soft assertion, the other test methods depending on this method will still execute
	}
	
	@Test(dependsOnMethods="openGoogle")
	public void search() {
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		element.sendKeys("quake");
		element.sendKeys(Keys.ENTER);
	}
}

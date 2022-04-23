package testAnnotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/*
 * tests will be run in parallel, for chrome and firefox
 * 
 * todo: add firefox driver
 * 
 * 
 * */

public class TestNGGroupsDemo {
	
	WebDriver driver;
	
	@Test(groups="Chrome")
	public void launchChrome() {
		System.setProperty("webdriver.chrome.driver", "/home/hjoel87gmx/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(groups="Chrome", dependsOnMethods="launchChrome") //only exec when launchChrome was successful 
	public void tryGoogle() {
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		element.sendKeys("simplilearn");
		element.sendKeys(Keys.ENTER);
	}
	
	/*@Test(groups="Firefox")
	public void launchFirefox() {
		System.setProperty("webdriver.gecko.driver", "");
		driver = new FirefoxDriver();
		driver.get("www.google.com");
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(groups="Firefox", dependsOnMethods="launchFirefox")
	public void tryGoogle2() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("quake");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
	}*/
}

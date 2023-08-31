package sliketm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.Test;

public class Demo {
	public static void main(String args[]) {
		
		String expectedTitle = "Google";
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		driver.close();
	}
}

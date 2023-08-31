package sliketm;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadAssertion 
{
	@Test
	public void testmethod() throws InterruptedException 
	{
		//Launch the browser 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		SoftAssert sa = new SoftAssert();
		
		//Open Url 
		 driver.get("https://www.google.com/");
		 Thread.sleep(2000);
		 
		System.out.println("Verify title......");
		String expectedTitle = "Login google";
		String actualTitle = driver.getTitle();
		sa.assertEquals(expectedTitle, actualTitle,"Title is mismatched");
		
		
		//System.out.println(driver.getTitle());
		
		driver.close();
		
		//report all failure msg
		
		//sa.assertAll();
		
		
	}
	

}

package sliketm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Revcms 
{
     @Test()
     
     public void softassert() throws InterruptedException 
     {
    	 WebDriverManager.chromedriver().setup();
    	 WebDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	
    	 
    	 SoftAssert sa = new SoftAssert();
    	 //Login CMS page
    	 driver.get("https://cms.slike.in/login");
    	 driver.findElement(By.id("email")).sendKeys("aakash.nath@timesinternet.in");
   	     driver.findElement(By.id("password")).sendKeys("AK@Sh123456789");
   	     driver.findElement(By.xpath("//button[text()='Sign In']")).click();
   	     
   	  // Validate CMS Title (Assertion)
 	    System.out.println("<==== Verify CMS.slike title Successfully ====>");
 		String expectedTitle = "cms.slike.in";
 		String actualTitle = driver.getTitle();
 		System.out.println("test: " +actualTitle);
 		sa.assertEquals(expectedTitle, actualTitle);
 		
 		
 		Thread.sleep(3000);
 		driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();
 		
 		Thread.sleep(3000);
 		driver.findElement(By.xpath("(//a[@class='collapsible-header waves-effect pl10'])[2]")).click();
 		
 		
 		Thread.sleep(5000);
 		driver.findElement(By.xpath("(//i[@class='material-icons'])[10]")).click();
 		
 		Thread.sleep(3000);
 		//driver.findElement(By.xpath("name=\"act_channel")).click();
 		
 		
 		//Select Live-TV Channel.
 		WebElement element = driver.findElement(By.name("act_channel"));
 		
 		Select dropdown = new Select(element);
 		 Thread.sleep(3000);
 		dropdown.selectByVisibleText("Mirror Now Mumbai");
 		
 		//Select Recording Status
 		WebElement element2 = driver.findElement(By.name("status"));
 		Select dropdown2 = new Select(element2);
		Thread.sleep(3000);
		dropdown2.selectByValue("3");
		
		//Search Button for LiveTv Recording.
		driver.findElement(By.id("search-submit")).click();
		Thread.sleep(5000);
		
		
		
		//LiveTv Recording Action Button---> for Preview.
		//driver.findElement(By.xpath("(//a[@class='btn edit mbtn waves-effect mr10'])[1]")).click();
		
		//driver.findElement(By.xpath("(//div[@class='__fScn'])[1]")).click();
		//driver.findElement(By.xpath("(//div[@class='__ply'])[1]")).click();
		
		//driver.findElement("")
		
		
		
		driver.close();
		
 		
    	 
    	 
	 } 
    
     
    	 
     
}

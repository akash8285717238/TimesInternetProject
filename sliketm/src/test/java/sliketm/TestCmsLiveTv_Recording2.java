package sliketm;

import static org.testng.Assert.assertEquals;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCmsLiveTv_Recording2 
{
	@Test()
	
	public void LiveTV_Recording() throws InterruptedException
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
   	     
   	     Thread.sleep(3000);
   	    //Validate CMS Title..
   	    String expectedTitle1 ="Slike:Home";
   	    String actualTitle = driver.getTitle();
  	   //assertEquals(actualTitle, expectedTitle1,"Title is mismatched");
  	    Assert.assertEquals(actualTitle, expectedTitle1);
  	    System.out.println("Test: " +actualTitle);
  	    
  	    // Flow between CMS to LiveTv Recording
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();
		
	   //Menu Button Click
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='collapsible-header waves-effect pl10'])[2]")).click();
		
		//LiveTV Button Click
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//i[@class='material-icons'])[10]")).click();
		
		//LiveTV Recording Button Click
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='select-wrapper'])[1]")).click();
	    //driver.findElement(By.xpath("name=\"act_channel")).click();
		
		
		//Select LiveTV channel
		List<WebElement> ChannelType = driver.findElements(By.xpath("//select[@name='act_channel']/option"));
		//List<WebElement> ChannelType = driver.findElements(By.xpath("(//div[@class='select-wrapper'])[1]"));
		Thread.sleep(5000);
		
		//System.out.println(ChannelType);
		
		
	    //Use For each Loop --> for "Select Live TV Channel"
       System.out.println("Total Number of Channel :"+ChannelType.size());
       
      for(WebElement ctype:ChannelType)
		{
    	     //System.out.println(ctype);
			if(ctype.getText().equals("Navbharat Mumbai"))
			{
				ctype.click();
				break;
			}
		}
		
		Thread.sleep(2000);
	    driver.findElement(By.xpath("(//div[@class='select-wrapper'])[2]")).click();
		WebElement element = driver.findElement(By.name("status"));
		
		//Select Recording Status.
		Select dropdown = new Select(element);
		Thread.sleep(3000);
		dropdown.selectByValue("3");
		
		//Search Button Click
		driver.findElement(By.id("search-submit")).click();
		Thread.sleep(3000);
		
		//LiveTv Recording Action Button---> Click Preview Button.
		driver.findElement(By.xpath("(//a[@class='btn edit mbtn waves-effect mr10'])[1]")).click();
		
		
		//Channel Start successfully... 
		String expectedTitle2 = "Preview Video Play";
 		String actualTitle2 = driver.getTitle();
 		sa.assertEquals(expectedTitle2, actualTitle2);
 		System.out.println("Slike : "+ actualTitle2 );
 		
 		//driver.quit();
 	 }	 
  }
 
   	     
   	     
   	     

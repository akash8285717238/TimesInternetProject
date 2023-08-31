package sliketm;



import java.util.ArrayList;

//import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainCmsLiveTv_Recording 
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
   	     
   	     // Validate CMS Title (Assertion)
	 	    System.out.println("<====  CMS.slike Title Verify Successfully ====>");
	 		String expectedTitle = "Login CMS";
	 		String actualTitle = driver.getTitle();
	 		sa.assertEquals(expectedTitle, actualTitle);
   	     
   	     
   	  /*// Validate CMS Title (Assertion)
 	    System.out.println("<====  CMS.slike Title Verify Successfully ====>");
 		String expectedTitle = "Slike:Login";
 		String actualTitle = driver.getTitle();
 		System.out.println("test: " +actualTitle);
 		//assert.assertEquals(expectedTitle, actualTitle);
   	     
 		driver.findElement(By.xpath("//a[@class='h5 brand-logo center']")).click();
 		String expectedTitle = "Slike:Home";
   	    assertEquals(expectedTitle, driver.getTitle());  //Compares both the titles
   	    
   	   String actualTitle1 = driver.getTitle();
   	   String expectedTitle1 ="Slike:Home";
   	   Assert.assertEquals(actualTitle1, expectedTitle1, "Title is mismatched");
   	     
   	     //Validate CMS Title..
    	    String expectedTitle1 ="Slike:Home";
    	    String actualTitle1 = driver.getTitle();
   	        //assertEquals(actualTitle, expectedTitle1,"Title is mismatched");
   	        Assert.assertEquals(actualTitle1, expectedTitle1);
   	        System.out.println("Test: " +actualTitle1);*/
   	    
   	    
   	    
   	    
   	    
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
 		
 		WebElement q;
 		for(int i=0;i<ChannelType.size();i++)
 		{
 			q = ChannelType.get(i);
 			System.out.println(q.getText());
 		}
 		
 		
 		
 		
 		//call all channel in Console.
 		List<String> c1 = new ArrayList<String>();
 		
 		c1.add("All");
 		c1.add("Mirror Now Mumbai");
 		c1.add("ANI_Live_Service");
 		c1.add("ETNow Swadesh DR");
 		c1.add("Rajyasabha");
 		c1.add("ET NOW Mumbai");
 		c1.add("Navbharat DR");
 		c1.add("ET Now DR");
 		c1.add("ANI_Live_Select");
 		c1.add("Loksabha");
 		c1.add("Times Now DR");
 		c1.add("Testing Live stream vendor");
 		c1.add("ETNOW_Swadesh");
 		c1.add("Times Now Mumbai");
 		c1.add("MirrorNow DR");
 		c1.add("Navbharat Mumbai");
 	
 
 		
 		
 		//Use For each Loop --> for "Select Live TV Channel"
        System.out.println("Total Number of Channel :"+ChannelType.size());
 		
 		
       
       for(WebElement ctype:ChannelType)
 		{
    	   
    	   System.out.println(c1);
    	   
 			if(ctype.getText().equals(c1))
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
		Thread.sleep(5000);
		
		/*//LiveTv Recording Action Button---> Click Preview Button.
		driver.findElement(By.xpath("(//a[@class='btn edit mbtn waves-effect mr10'])[1]")).click();
		
		//Channel Start successfully... 
				
				/*String expectedTitle2 = "Preview Video Play";
		 		String actualTitle2 = driver.getTitle();
		 		sa.assertEquals(expectedTitle2, actualTitle2);
		 		System.out.println("Slike : "+ actualTitle2 );*/
		
		
		
		
		    /*String expectedTitle2 ="Slike:Home";
	   	    String actualTitle2 = driver.getTitle();
	  	   //assertEquals(actualTitle, expectedTitle1,"Title is mismatched");
	  	    Assert.assertEquals(actualTitle2, expectedTitle1);
	  	    System.out.println("Test: " +actualTitle2);*/
	  	    
		
		  // LiveTv Recording Action Button---> Click Preview Button.
      /*  List<WebElement> previewButtons = driver.findElements(By.xpath("(//a[@class='btn edit mbtn waves-effect mr10'])"));
        if (!previewButtons.isEmpty()) {
            previewButtons.get(0).click();

            // Channel Start successfully...
            String expectedTitle2 = "Preview Video Play";
            String actualTitle2 = driver.getTitle();
            sa.assertEquals(expectedTitle2, actualTitle2);
            System.out.println("Slike : " + actualTitle2);

            // Perform actions for the currently selected channel
            // ...

            // Go back to the LiveTV Recording page to select the next channel
            driver.navigate().back();
        } else {
            System.out.println("No preview button found for channel: " + channel);
        }
    }

    sa.assertAll(); // Make sure to call assertAll to log all the soft assertions.
    driver.quit();*/
	  
		
		
		}	 
	
}

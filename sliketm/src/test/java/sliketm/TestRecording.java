package sliketm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRecording {

	public static void main(String[] args) throws InterruptedException 
	{
	            //public void softassert() throws InterruptedException 
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
		 		
		 		// Flow between Cms to LiveTv Recording
		 		Thread.sleep(3000);
		 		driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();
		 		
		 		Thread.sleep(3000);
		 		driver.findElement(By.xpath("(//a[@class='collapsible-header waves-effect pl10'])[2]")).click();
		 		
		 		
		 		Thread.sleep(5000);
		 		driver.findElement(By.xpath("(//i[@class='material-icons'])[10]")).click();
		 		
		 		Thread.sleep(3000);
		 		//driver.findElement(By.xpath("name=\"act_channel")).click();
		 		
		 	    driver.findElement(By.xpath("(//div[@class='select-wrapper'])[1]")).click();
		 		List<WebElement> ChannelType = driver.findElements(By.xpath("//select[@name='act_channel']/option"));
		 		
		 		//List<WebElement> ChannelType = driver.findElements(By.xpath("(//div[@class='select-wrapper'])[1]"));
		 		
		 		Thread.sleep(5000);
		 		
		        System.out.println("Number of option :"+ChannelType.size());
		 		
		 		
		 		for(WebElement ctype:ChannelType)
		 		{
		 			if(ctype.getText().equals("Navbharat DR"))
		 			{
		 				ctype.click();
		 				break;
		 			}
		 		}
		 		
		 		Thread.sleep(2000);
		 	    driver.findElement(By.xpath("(//div[@class='select-wrapper'])[2]")).click();
		 		WebElement element = driver.findElement(By.name("status"));
		 		Select dropdown = new Select(element);
				Thread.sleep(3000);
				dropdown.selectByValue("3");
				
				driver.findElement(By.id("search-submit")).click();
				Thread.sleep(5000);
				
				//LiveTv Recording Action Button---> for Preview.
				driver.findElement(By.xpath("(//a[@class='btn edit mbtn waves-effect mr10'])[1]")).click();
				
				Set<String>WindowIDs = driver.getWindowHandles();
				
				
				
				//First method -- iterator()
				
				Iterator<String> it =WindowIDs.iterator();
				String ParentWindowID = it.next();
				String ChildWindowID = it.next();
				
				System.out.println("Parent Window ID:" +ParentWindowID );
				System.out.println("Child Window ID:" +ChildWindowID );
				
				 // Validate CMS Title (Assertion)
		 	    System.out.println("==== Verify << PREVIEW VIDEO >> Play Successfully ====");
		 		String expectedTitle1 = "Preview Video Play";
		 		String actualTitle1 = driver.getTitle();
		 		sa.assertEquals(expectedTitle, actualTitle);
				
				
				//Second Method --using List/ArrayList
				
			   /* List <String> WindowIDsList = new ArrayList(WindowIDs);  //Converting set--> List
			 
			    String ParentWindowID1 = WindowIDsList.get(0);
				String ChildWindowID1 = WindowIDsList.get(1);
				
				System.out.println("Parent Window ID:" +ParentWindowID1 );
				System.out.println("Child Window ID:" +ChildWindowID1 );
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//div[@class='__duration'])[1]")).click();*/
		 		
		 		
		 		/*driver.findElement(By.xpath("//div[text()='00:00 / 05:08']")).click();
		 		
		 		driver.findElement(By.xpath("//div[text()='00:10 / 05:08']")).click();
		 		
		 		System.out.println("==== Verify initial Time = 00:00 / 05:08 ====");
		 		System.out.println("==== Verify final Time = 00:10 / 05:08 ====");*/
		 		
		 		
		 		String expectedTitle2 = "Preview Video Play";
		 		String actualTitle2 = driver.getTitle();
		 		sa.assertEquals(expectedTitle, actualTitle);
			 
			}	 
		

	    }

	}

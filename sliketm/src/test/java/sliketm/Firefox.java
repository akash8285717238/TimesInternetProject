package sliketm;
import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	//import org.openqa.selenium.chrome.ChromeDriver;
	//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;
	//import io.github.bonigarcia.wdm.WebDriverManager;

	public class Firefox  
	{
	    @Test()
	    public void LiveTV_Recording() throws InterruptedException {
	    	System.setProperty("webdriver.gecko.driver","C:\\EclipseLatest\\sliketm\\drivers\\geckodriver.exe");
	    	FirefoxOptions options = new FirefoxOptions();
			options.setBinary("C:\\Users\\aakash.nath\\Downloads\\geckodriver-0.33.0\\gecko.exe");
			options.addArguments("--disable-notifications");
			WebDriver driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			SoftAssert sa = new SoftAssert();

	        // Login CMS page
	        driver.get("https://cms.slike.in/login");
	        driver.findElement(By.id("email")).sendKeys("aakash.nath@timesinternet.in");
	        driver.findElement(By.id("password")).sendKeys("AK@Sh123456789");
	        driver.findElement(By.xpath("//button[text()='Sign In']")).click();

	        // Validate CMS Title (Assertion)
	        String expectedTitle = "Slike:Home";
	        String actualTitle = driver.getTitle();
	        sa.assertEquals(expectedTitle, actualTitle);
	        System.out.println("Test: " +actualTitle);

	        // Flow between CMS to LiveTv Recording
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();

	        // Menu Button Click
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("(//a[@class='collapsible-header waves-effect pl10'])[2]")).click();

	        // LiveTV Button Click
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("(//i[@class='material-icons'])[10]")).click();

	        // LiveTV Recording Button Click
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("(//div[@class='select-wrapper'])[1]")).click();

	        // Select LiveTV channels using ArrayList
	        List<String> c1 = new ArrayList<>();
	        //c1.add("All");
	        c1.add("Mirror Now Mumbai");
	        //c1.add("ANI_Live_Service");
	        c1.add("ETNow Swadesh DR");
	        c1.add("Rajyasabha");
	        c1.add("ET NOW Mumbai");
	        c1.add("Navbharat DR");
	        c1.add("ET Now DR");
	        //c1.add("ANI_Live_Select");
	        //c1.add("Loksabha");
	        c1.add("Times Now DR");
	        //c1.add("Testing Live stream vendor");
	        c1.add("ETNOW_Swadesh");
	        c1.add("Times Now Mumbai");
	        c1.add("MirrorNow DR");
	        c1.add("Navbharat Mumbai");

	        System.out.println("Total Number of Channel: " + c1.size());
	        // Loop through the channels using enhanced for loop
	        for (String channel : c1) 
	        {
	            WebElement channelOption = driver.findElement(By.xpath("//select[@name='act_channel']/option[text()='" + channel + "']"));
	            channelOption.click();
	            Thread.sleep(4000);

	            // Select Recording Status.
	            WebElement statusElement = driver.findElement(By.name("status"));
	            Select dropdown = new Select(statusElement);
	            dropdown.selectByValue("3");

	            // Search Button Click
	            driver.findElement(By.id("search-submit")).click();
	            Thread.sleep(4000);
	            
	            //Preview button click.
	            driver.findElement(By.xpath("(//a[@class='btn edit mbtn waves-effect mr10'])[1]")).click();
	            Thread.sleep(5000);
	            
	            //handle window
	            String parentWindowHandle = driver.getWindowHandle();
	            Set<String> allWindowHandles = driver.getWindowHandles();
	            for (String windowHandle : allWindowHandles) {
	                if (!windowHandle.equals(parentWindowHandle)) {
	                    driver.switchTo().window(windowHandle);

	                    // Perform actions in the child window
	                    // For example, you might record the video, stop recording, check recording status
	                    Thread.sleep(8000);
	                    // Perform actions in the child window here...
	                    
	                    
	                    WebElement element = driver.findElement(By.xpath("//div[@id='playerContainer']")); //locater
	                    
	                    //WebElement element = driver.findElement(By.xpath("(//div[@class='__ply'])[2]"));
	                    

	                    // Assertion - Check if the element is visible
	                    Assert.assertTrue(element.isDisplayed());
	                    
	                     System.out.println("Channel is Visible --> " +channel);
	                    
	                    // Close the child window
	                    driver.close();
	                    // Switch back to the parent window
	                    driver.switchTo().window(parentWindowHandle);
	                    Thread.sleep(5000);
	                    //break;
	                    }
	            }
	       }
	        sa.assertAll(); 
	    }
	            
	}       





package sliketm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LiveTv {
	@Test()
	public void LiveTV_Recording() {
		SoftAssert sa = new SoftAssert();
		int delay = 4000;
		WebDriver driver = null;
     
		try {
			
			// Set ChromeOptions to handle notifications
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications"); // This will disable notifications
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts();
			driver.manage().timeouts();

			// Login CMS page
			driver.get("https://cms.slike.in/login");
			driver.findElement(By.id("email")).sendKeys("aakash.nath@timesinternet.in");
			driver.findElement(By.id("password")).sendKeys("AK@Sh123456789");
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();

			// Validate CMS Title (Assertion)
			String expectedTitle = "Slike:Home";
			String actualTitle = driver.getTitle();
			sa.assertEquals(expectedTitle, actualTitle);
			System.out.println("Test: " + actualTitle);

			// Flow between CMS to LiveTv Recording
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();

			// Menu Button Click
			Thread.sleep(delay);
			driver.findElement(By.xpath("(//a[@class='collapsible-header waves-effect pl10'])[2]")).click();

			// LiveTV Button Click
			Thread.sleep(delay);
			driver.findElement(By.xpath("(//i[@class='material-icons'])[10]")).click();

			// LiveTV Recording Button Click
			Thread.sleep(delay);
			driver.findElement(By.xpath("(//div[@class='select-wrapper'])[1]")).click();

			// Select LiveTV channels using ArrayList
			 List<WebElement> c1 = driver.findElements(By.xpath("//select[@name='act_channel']/option]"));
			
			
		
            System.out.println("Total Number of Channel: " + c1.size());
			// Loop through the channels using enhanced for loop
			for ( WebElement channel  : c1) 
			{      System.out.println(channel.getText());
			       Thread.sleep(3000);
			       
			       if(channel.equals("Mirror Now Mumbai")) 
			       {
			    	   Thread.sleep(3000);
			    	   channel.click(); 
			       }
			
				//WebElement channelOption = driver.findElement(By.xpath("//select[@name='act_channel']/option[text()='" + channel + "']"));
				//channelOption.click();
				Thread.sleep(4000);

				// Select Recording Status.
				WebElement statusElement = driver.findElement(By.name("status"));
				Select dropdown = new Select(statusElement);
				dropdown.selectByValue("3");

				// Search Button Click
				driver.findElement(By.id("search-submit")).click();
				Thread.sleep(4000);

				// Preview button click.
				driver.findElement(By.xpath("(//a[@class='btn edit mbtn waves-effect mr10'])[1]")).click();
				Thread.sleep(5000);

				// Handle window
				String parentWindowHandle = driver.getWindowHandle();
				Set<String> allWindowHandles = driver.getWindowHandles();
				for (String windowHandle : allWindowHandles) {
					if (!windowHandle.equals(parentWindowHandle)) {
						driver.switchTo().window(windowHandle);

						// Perform actions in the child window
						// For example, you might record the video, stop recording, check recording
						// status
						Thread.sleep(10000);
						// Perform actions in the child window here...

						WebElement element = driver.findElement(By.xpath("//div[@id='playerContainer']")); // locator

						// Assertion - Check if the element is visible
						sa.assertTrue(element.isDisplayed(), "Channel is not visible --> " + channel);

						System.out.println("Channel is Visible --> " + channel);

						// Close the child window
						driver.close();
						// Switch back to the parent window
						driver.switchTo().window(parentWindowHandle);
						Thread.sleep(5000);
						// break;
					}
				}
			}
			sa.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			sa.fail("Test f/p due to an exception: " + e.getMessage());
		} finally {
			if (driver != null) 
			{
				driver.quit(); // Close the browser after the test completes
				
			}
		}
	}
}


package sliketm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VideoAutomation {

	
		@Test()
		public void videoAutomation() 
		{
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			SoftAssert sa = new SoftAssert();
			driver.get("https://tvid.in/sdk/stg/embed/index.html#apikey=test403web5a8sg6o9ug&videourl=https://vsnl.slike.in/liveTV/139zoo9ogu/2023_07_26_16_16_1690368383/ETNOW_Swadesh_720_2023_07_26_16_16_1690368383.mp4&skipad=true&title=ETNOW_Swadesh_04:16:23%2026-07-2023&showtitle=true");
			driver.findElement(By.xpath("(//div[@class='__duration'])[1]")).click();
			
			
		}
		
		
     
	}



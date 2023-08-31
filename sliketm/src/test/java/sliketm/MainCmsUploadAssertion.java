
package sliketm;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import LiveTvRecording.ReadConfigFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MainCmsUploadAssertion 
{  @Test
	
   public void MainCmsUploadSucessfully() throws InterruptedException, AWTException 
   
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	   SoftAssert sa = new SoftAssert();
	
	   ReadConfigFile config = new ReadConfigFile();
	   driver.get(config.getURL());
	   driver.findElement(By.id("email")).sendKeys(config.getUN());
       driver.findElement(By.id("password")).sendKeys(config.getPWD());
       driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	   
       // Validate CMS Title (Assertion)
	    System.out.println("<==== Verify CMS.slike title Successfully ====>");
		String expectedTitle = "Login CMS";
		String actualTitle = driver.getTitle();
		sa.assertEquals(expectedTitle, actualTitle);
		//driver.close();
		
		//validation....
		 driver.findElement(By.xpath("(//i[@class='videoIco'])[1]")).click(); //
		 Thread.sleep(5000);
		 
		 driver.findElement(By.xpath("//i[text()='add_circle']")).click();
		 
		WebElement VideoUpload = driver.findElement(By.xpath("//div[@id='uploadvideo']"));
		VideoUpload.click();
		
		// Validate Upload Video(Assertion)
		  System.out.println("<== Upload Cms Video Successfully ==>");
		  String expectedTitle1 = "Upload Video";
		  String actualTitle1 = driver.getTitle();
		  sa.assertEquals(expectedTitle1, actualTitle1);
	   
		
		// Create a Robot instance
	    Robot robot = new Robot();
	    robot.delay(3000);
	    
	   //Copy the image file path to the clipboard
	    StringSelection stringSelection = new StringSelection("C:\\Users\\aakash.nath\\Desktop\\AkashAuto27V.mp4");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	    
	    // pressing Ctrl+V to paste the video file path
	    robot.keyPress(KeyEvent.VK_CONTROL);    //press on CTRL key
	    robot.keyPress(KeyEvent.VK_V);          //press on CTRL keys
	    robot.delay(2000);
	    
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.delay(2000);
	    
       //Pressing Enter to confirm the upload
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.delay(2000);
	    
	   // Validate CMS Title (Assertion)
	    System.out.println("==== Verify CMS VIDEO UPLOAD  Successfully ====>");
		String expectedTitle2 = "Video Upload CMS";
		String actualTitle2 = driver.getTitle();
		sa.assertEquals(expectedTitle, actualTitle);
	    
	    driver.close();
	   
	   
	   
 }

}

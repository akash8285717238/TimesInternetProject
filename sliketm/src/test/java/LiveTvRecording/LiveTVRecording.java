package LiveTvRecording;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Test.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import sliketm.ExternalFile;
public class LiveTVRecording
{
	@Test
	public void Test() throws InterruptedException 
    {
	   WebDriverManager.chromedriver().setup();
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("--disable-notifications");
	   WebDriver driver = new ChromeDriver(options);
	   driver.manage().window().maximize();
	   
	   ReadConfigFile config = new ReadConfigFile();
	   driver.get(config.getURL());
	   driver.findElement(By.id("email")).sendKeys(config.getUN());
       driver.findElement(By.id("password")).sendKeys(config.getPWD());
       driver.findElement(By.xpath("//button[text()='Sign In']")).click();
       
       SoftAssert sa = new SoftAssert();
       
      try {
     String expectedTitle = "Slike:Home";                     // Validate CMS Title (Assertion)
     String actualTitle = driver.getTitle();
     sa.assertEquals(expectedTitle, actualTitle);
     System.out.println("Test: " +actualTitle);
     
     Thread.sleep(3000); // Flow between CMS to LiveTv Recording
     driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();

     Thread.sleep(4000); // Menu Button Click
     driver.findElement(By.xpath("(//a[@class='collapsible-header waves-effect pl10'])[2]")).click();

     Thread.sleep(4000);      // LiveTV Button Click
     driver.findElement(By.xpath("(//i[@class='material-icons'])[10]")).click();

     Thread.sleep(4000);   // LiveTV Recording Button Click
     driver.findElement(By.xpath("(//div[@class='select-wrapper'])[1]")).click();

     ExternalFile ef = new ExternalFile();   // Loop through the channels using enhanced for loop
     
     for (String channel : ef.loadChannelNames()) 
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
                 Thread.sleep(10000);
                 // Perform actions in the child window here...
                  WebElement element = driver.findElement(By.xpath("//div[@id='playerContainer']")); //locater
                // Assertion - Check if the element is visible
                 Assert.assertTrue(element.isDisplayed());
                 System.out.println("Channel is Visible --> " +channel);
                 driver.close();       // Close the child window
                 driver.switchTo().window(parentWindowHandle); // Switch back to the parent window
                 Thread.sleep(5000);      //break;
              }
         }
    }
     sa.assertAll(); 
     }catch (Exception e)
     {
     	 System.out.println("An exception occurred: " + e.getMessage());
     }
 }             
}       





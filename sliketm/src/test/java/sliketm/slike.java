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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;


public class slike {

	public static void main(String[] args) throws InterruptedException, AWTException 
 
	{
		ChromeOptions noti = new ChromeOptions(); 
		noti.addArguments("--disable-notifications");
		
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //SoftAssert sa = new SoftAssert();
	  
	 SoftAssert sa = new  SoftAssert();
      
	  //driver.get("https://cms.slike.in/");
	  
	 driver.get("https://cms.slike.in/login");
	  
	  /*Thread.sleep(5000);
	  driver.findElement(By.id("username")).sendKeys("aakash.nath@timesinternet.in");
	  driver.findElement(By.id("password")).sendKeys("ak@sH314227");
	  driver.findElement(By.xpath("//button[text()='Login']")).click();
	  
	  Thread.sleep(30000);
	  
	 driver.findElement(By.xpath("//button[text()='Verify']")).click();*/
	  
	  //Direct Login CMS ------------>
	  driver.findElement(By.id("email")).sendKeys("aakash.nath@timesinternet.in");
	  driver.findElement(By.id("password")).sendKeys("AK@Sh123456789");
	  driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	  
	  //sa.assertEquals(expectedTitle, actualTitle,"Title is mismatched");
	  
	  
	  //validation....
	  
	 driver.findElement(By.xpath("(//i[@class='videoIco'])[1]")).click(); //
	  
	  Thread.sleep(5000);   //wait 
	  
	 // driver.findElement(By.xpath("//li[@class='right active']")).click();
	  
	 // driver.findElement(By.className("right")).click();
	 
	 driver.findElement(By.xpath("//i[text()='add_circle']")).click();
	 
	 WebElement VideoUpload = driver.findElement(By.xpath("//div[@id='uploadvideo']"));
	 VideoUpload.click();
	
	
	//Actions act = new Actions(driver);
	//act.moveToElement(VideoUpload).click().perform();
	
	
	
	// Create a Robot instance
    Robot robot = new Robot();
    robot.delay(2000);

    // Specify the path of the image file
    //String imagePath = "path/to/image.jpg";
    
   // String imagePath = "C:\\Users\\aakash.nath\\Desktop\\AkashAuto03V.mp4";
    
   // Copy the image file path to the clipboard
    StringSelection stringSelection = new StringSelection("C:\\Users\\aakash.nath\\Desktop\\AkashAuto21V.mp4");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    
    // pressing Ctrl+V to paste the video file path
    robot.keyPress(KeyEvent.VK_CONTROL);    //press on CTRL key
    robot.keyPress(KeyEvent.VK_V);          //press on CTRL keys
    robot.delay(2000);
    
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_V);
    robot.delay(2000);
    

    //  pressing Enter to confirm the upload
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
	
	
	//driver.findElement(By.xpath("//a[@id='_upload']")).click();
    

	
	
	//---------------------------------------------------------------------------------
	driver.findElement(By.xpath("(//a[@class='mbtn btn btn-flat mini left brR'])[2]")).click();
	
	//Channel Dropdown.
	WebElement Ele4Channel=driver.findElement(By.xpath("//select[@id='channels']"));
	
	Select sl = new Select(Ele4Channel);
	sl.selectByVisibleText("test");
	
	//Channel products
	
	WebElement Ele4Prod=driver.findElement(By.xpath("//select[@id='products']"));
	
	Select sl1 = new Select(Ele4Prod);
	sl1.selectByVisibleText("TimesXP-English");
	
	//Catagory dropdown 

	WebElement Ele4Catagory=driver.findElement(By.xpath("//select[@id='categories']"));
	
	Select sl2 = new Select(Ele4Catagory);
	sl2.selectByIndex(3);
	
	//languages dropdown 
	
		WebElement Ele4Languages=driver.findElement(By.xpath("//select[@id='languages']"));
		
		Select sl3 = new Select(Ele4Languages);
		sl3.selectByIndex(3);
		
		
		//meta_languages dropdown 
		
		WebElement Ele4Meta_languages=driver.findElement(By.xpath("//select[@id='meta_languages']"));
		
		Select sl4 = new Select(Ele4Meta_languages);
		sl4.selectByIndex(3);
	
	
		//vendors dropdown 
		
				WebElement Ele4Vendors=driver.findElement(By.xpath("//select[@id='vendors']"));
				
				Select sl5 = new Select(Ele4Vendors);
				sl5.selectByIndex(3);
	            driver.findElement(By.xpath("//input[@id='submitPublished']")).click();
	
	
		
	 
	  
	}

}

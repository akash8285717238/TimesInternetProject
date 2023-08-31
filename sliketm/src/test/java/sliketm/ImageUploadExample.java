package sliketm;

    import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import java.awt.*;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;

	public class ImageUploadExample {
	    public static void main(String[] args) throws AWTException {
	        // Set the path to the ChromeDriver executable
	       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Create an instance of ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the webpage
	        driver.get("http://www.example.com");

	        // Find the file upload button and click on it
	        WebElement uploadButton = driver.findElement(By.id("file-upload"));
	        uploadButton.click();

	        // Create a Robot instance
	        Robot robot = new Robot();

	        // Specify the path of the image file
	        //String imagePath = "path/to/image.jpg";
	        
	        String imagePath = "C:\\Users\\aakash.nath\\Desktop\\AkashAuto03V.mp4";
	        
	        

	        // Copy the image file path to the clipboard
	        StringSelection stringSelection = new StringSelection(imagePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	        // Simulate pressing Ctrl+V to paste the image file path
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);

	        // Simulate pressing Enter to confirm the upload
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);

	        // Wait for the upload to complete (you may need to adjust the delay as per your system performance)
	        robot.delay(2000);

	        // Close the browser
	        driver.quit();
	    }
	}


package sliketm;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class OrangeHRMAutomation {
	    public static void main(String[] args) {
	        // Set the path to the ChromeDriver executable
	        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Create a new instance of the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Launch the OrangeHRM website
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        
	       // driver.findElement("By.")
	        
	       // Find the username and password fields and enter your login credentials
	        /*WebElement usernameField = driver.findElement(By.xpath("//label[text()='Username']"));
	        WebElement passwordField = driver.findElement(By.xpath("//label[text()='Password']"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

	        usernameField.sendKeys("Admin");
	        passwordField.sendKeys("admin123");
	        loginButton.click();*/

	        // Wait for the dashboard page to load
	        WebElement dashboardHeading = driver.findElement(By.xpath("//h1[text()='Dashboard']"));

	        // Verify that the dashboard page is displayed
	        if (dashboardHeading.isDisplayed()) {
	            System.out.println("Login successful. Dashboard page is displayed.");
	        } else {
	            System.out.println("Login failed. Dashboard page is not displayed.");
	        }

	        // Perform other actions on the dashboard page
	        // ...

	        // Logout from the application
	        WebElement welcomeMenu = driver.findElement(By.id("welcome"));
	        welcomeMenu.click();

	        WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
	        logoutLink.click();

	        // Wait for the logout page to load
	        WebElement logoutMessage = driver.findElement(By.xpath("//h2[text()='Logout']"));

	        // Verify that the logout page is displayed
	        if (logoutMessage.isDisplayed()) {
	            System.out.println("Logout successful. Logout page is displayed.");
	        } else {
	            System.out.println("Logout failed. Logout page is not displayed.");
	        }

	        // Close the browser
	        driver.quit();
	    }
	}



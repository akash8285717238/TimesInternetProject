package sliketm;
    import java.util.concurrent.TimeUnit;

    import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class OrangeHRMLoginAutomation {
	public static void main(String[] args) throws InterruptedException {
	       
	        // Create a new instance of the ChromeDriver
            WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // Launch the OrangeHRM website
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	        Thread.sleep(5000);
	        
	        // Find the username and password fields and enter your login credentials
	        
	        WebElement usernameField = driver.findElement(By.name("username"));
	        
	        WebElement passwordField = driver.findElement(By.name("password"));
	        
	        WebElement loginButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

	        usernameField.sendKeys("Admin");
	        
	        passwordField.sendKeys("admin123");
	        
	        loginButton.click();
	        
	        /*WebElement usernameField = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]"));
	        WebElement passwordField = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

	        usernameField.sendKeys("Admin");
	        passwordField.sendKeys("your-password");
	        loginButton.click();*/
	        

	        // Wait for the dashboard page to load
	        WebElement dashboardHeading = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']"));

	        // Verify that the login was successful and the dashboard page is displayed
	        if (dashboardHeading.isDisplayed()) {
	            System.out.println("Login successful. Dashboard page is displayed.");
	        } else {
	            System.out.println("Login failed. Dashboard page is not displayed.");
	        }

	        // Close the browser
	        driver.quit();
	    }
	}



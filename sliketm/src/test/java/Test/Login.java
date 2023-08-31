package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login 
{
	
	public void loginChannelNames(WebDriver driver)
	{    
		User user =ReadingJsonFIle.Readingfile();
		driver.get("https://cms.slike.in/login");
        driver.findElement(By.id("email")).sendKeys(user.getEmail());
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}
}

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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NV1 {

    @Test()
    public void LiveTV_Recording() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver","C:\\EclipseLatest\\sliketm\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\aakash.nath\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		SoftAssert sa = new SoftAssert();
        try {
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

            // Navigate to LiveTV Recording
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("(//a[@class='collapsible-header waves-effect pl10'])[2]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("(//i[@class='material-icons'])[10]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("(//div[@class='select-wrapper'])[1]")).click();

            // Select LiveTV channels using ArrayList
            List<String> c1 = new ArrayList<>();
            c1.add("Mirror Now Mumbai");
            // ... (other channel entries)

            System.out.println("Total Number of Channel: " + c1.size());

            // Loop through the channels using enhanced for loop
            for (String channel : c1) {
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
                        Thread.sleep(8000);

                        WebElement element = driver.findElement(By.xpath("//div[@id='playerContainer']")); //locator

                        // Assertion - Check if the element is visible
                        Assert.assertTrue(element.isDisplayed());

                        System.out.println("Channel is Visible --> " + channel);

                        // Close the child window
                        driver.close();
                        // Switch back to the parent window
                        driver.switchTo().window(parentWindowHandle);
                        Thread.sleep(5000);
                    }
                }
            }
            sa.assertAll();
        } finally {
            driver.quit();
        }
    }
}

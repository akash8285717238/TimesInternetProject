package sliketm;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exception2 {
    private WebDriver driver;
    private SoftAssert sa;
    private int delay = 4000;

    @BeforeClass
    public void setup() {
        // Set ChromeOptions to handle notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // This will disable notifications
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        sa = new SoftAssert();
    }

    @Test
    public void LiveTV_Recording() {
        try {
            // Login CMS page
            driver.get("https://cms.slike.in/login");
            driver.findElement(By.id("email")).sendKeys("aakash.nath@timesinternet.in");
            driver.findElement(By.id("password")).sendKeys("AK@Sh123456789");
            driver.findElement(By.xpath("//button[text()='Sign In']")).click();

            // Validate CMS Title (Assertion)
            String expectedTitle = "Slike:Home2";
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

            // Select LiveTV channels dynamically
            WebElement channelDropdown = driver.findElement(By.xpath("//select[@name='act_channel']"));
            Select channelSelect = new Select(channelDropdown);
            List<WebElement> channelOptions = channelSelect.getOptions();

            System.out.println("Total Number of Channel Options: " + channelOptions.size());

            for (int i = 1; i < channelOptions.size(); i++) {
                // Get the option text and select the channel
                String channelName = channelOptions.get(i).getText();
                channelSelect.selectByIndex(i);

                // Perform actions for the selected channel
                performActionsForChannel(channelName);
            }

            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            sa.fail("Test f/p due to an exception: " + e.getMessage());
        }
    }

    private void performActionsForChannel(String channel) throws InterruptedException {
        // ... (previous code for actions related to the selected channel)
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser after the test completes
        }
    }
}

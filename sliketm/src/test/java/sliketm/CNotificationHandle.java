package sliketm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CNotificationHandle {
    @Test()
    public void LiveTV_Recording() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        SoftAssert sa = new SoftAssert();

        // Login CMS page
        driver.get("https://cms.slike.in/login");
        driver.findElement(By.id("email")).sendKeys("aakash.nath@timesinternet.in");
        driver.findElement(By.id("password")).sendKeys("AK@Sh123456789");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();

        // Validate CMS Title (Assertion)
        String expectedTitle = "Login CMS";
        String actualTitle = driver.getTitle();
        sa.assertEquals(expectedTitle, actualTitle);

        // Flow between CMS to LiveTv Recording
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();

        // Menu Button Click
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@class='collapsible-header waves-effect pl10'])[2]")).click();

        // LiveTV Button Click
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//i[@class='material-icons'])[10]")).click();

        // LiveTV Recording Button Click
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='select-wrapper'])[1]")).click();

        // Select LiveTV channels using ArrayList
        List<String> c1 = new ArrayList<>();
        c1.add("Mirror Now Mumbai");
        c1.add("ANI_Live_Service");
        c1.add("ETNow Swadesh DR");
        c1.add("Rajyasabha");
        c1.add("ET NOW Mumbai");
        c1.add("Navbharat DR");
        c1.add("ET Now DR");
        c1.add("ANI_Live_Select");
        c1.add("Loksabha");
        c1.add("Times Now DR");
        c1.add("Testing Live stream vendor");
        c1.add("ETNOW_Swadesh");
        c1.add("Times Now Mumbai");
        c1.add("MirrorNow DR");
        c1.add("Navbharat Mumbai");

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
            Thread.sleep(5000);

            // LiveTv Recording Action Button---> Click Preview Button.
            List<WebElement> previewButtons = driver.findElements(By.xpath("(//a[@class='btn edit mbtn waves-effect mr10'])"));
            if (!previewButtons.isEmpty()) {
                previewButtons.get(0).click();

                // Switch to the child window
                String parentWindowHandle = driver.getWindowHandle();
                Set<String> allWindowHandles = driver.getWindowHandles();
                for (String windowHandle : allWindowHandles) {
                    if (!windowHandle.equals(parentWindowHandle)) {
                        driver.switchTo().window(windowHandle);

                        // Perform actions in the child window
                        // For example, you might record the video, stop recording, check recording status, etc.
                        Thread.sleep(5000);
                        // Perform actions in the child window here...

                        // Close the child window
                        driver.close();

                        // Switch back to the parent window
                        driver.switchTo().window(parentWindowHandle);
                        break;
                    }
                }

                // Go back to the LiveTV Recording page to select the next channel
                driver.navigate().back();
            } else {
                System.out.println("No preview button found for channel: " + channel);
            }
        }

        // Get the notification handle
        String notificationHandle = driver.getWindowHandle();
        System.out.println("Notification Handle: " + notificationHandle);

        sa.assertAll(); // Make sure to call assertAll to log all the soft assertions.
        driver.quit();
    }
}


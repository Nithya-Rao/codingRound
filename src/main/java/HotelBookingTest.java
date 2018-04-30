import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver;
    

/*@FindBy(how = How.ID, using = "flashSaleEl-hotel")
private WebElement hotelLink;
*/
   @FindBy(linkText = "hotels")
   public WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() throws InterruptedException {
        setDriverPath();
        
        driver=new ChromeDriver();

        driver.get("https://www.cleartrip.com/");
        //Thread.sleep(2000);
       			
        driver.findElement(By.linkText("Hotels")).click();
       //hotelLink.click();
        
        wait(2000);
        driver.findElement(By.id("Tags")).click();
        driver.findElement(By.xpath("//*[@id='Tags']")).sendKeys("Indiranagar, Bangalore");

       // localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

        driver.quit();

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}

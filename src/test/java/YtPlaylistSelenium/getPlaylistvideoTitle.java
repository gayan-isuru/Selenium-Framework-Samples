package YtPlaylistSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class getPlaylistvideoTitle {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
       // driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/playlist?list=PLgbf4L0WvebciyGW9bKfMLr-TGUp_u6K5");

    }

    @Test
    public void getPlaylistvideoTitle() {

        List<WebElement> videoTitles = driver.findElements(By.xpath("//a[@id='video-title']"));

        for (WebElement videoTitle : videoTitles) {
        int i=1;
           String titleName=  videoTitle.getText();
            System.out.println(+i+ " titleName: " + titleName);
            i++;
        }


    }
}

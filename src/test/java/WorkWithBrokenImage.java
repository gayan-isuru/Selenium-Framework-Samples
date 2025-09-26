import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WorkWithBrokenImage {


    WebDriver driver;
    @BeforeMethod
    public void BeforeMethods(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void BrokenImageExample1(){
        driver.get("https://demoqa.com/broken");
        //find Element
        List<WebElement> images= driver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']//div/img"));
        //Check naturalWidth = 0 (image is broken)

        int i =1;
        for(WebElement image:images){
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image "+i+" is broken");
            }
            else{
                System.out.println("Image "+i+" is not broken, It is available");
            }
            i++;
        }
    }



}

package Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class implicitWait {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // use implicitwait concept  (like Global variable)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for 10 sec drp notsuchelement exception

        //use timeOuts()
       // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));  // page loads the withing 2 sec. (if not loads within 2 sec "TimeOutException" )
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void ImplicitWaitTest() throws InterruptedException {


        //select click button
        WebElement selectBtn = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']//span[@class='ui-button-text ui-c']"));
        selectBtn.click();

        //Thread.sleep(10000);
        String getTextNewBtn = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span[@class='ui-button-text ui-c']")).getText();
        System.out.println("New Button text is :"+getTextNewBtn);
    }

}

package Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class explicit_wait {


WebDriver driver;
@BeforeMethod
    public void beforeMethod()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void testexplicit_wait()
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //select click button
        WebElement selectBtn = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']//span[@class='ui-button-text ui-c']"));
        selectBtn.click();

        //Thread.sleep(10000);


        By newBtnLocator = By.xpath("//button[@id='j_idt87:j_idt90']/span[@class='ui-button-text ui-c']");

        WebElement NewBtnText = wait.until(ExpectedConditions.presenceOfElementLocated(newBtnLocator));
        String newBtnText =NewBtnText.getText();
        System.out.println("New Button text is :"+newBtnText);
    }


}


package Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class fluentWait {


    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/waits.xhtml");
    }


    @Test
    public void testexplicit_wait() {
        //declaration  fluent wait
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);
        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']//span[@class='ui-button-text ui-c']")).click();

        WebElement fluentWaitElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span[@class='ui-button-text ui-c']"));

            }

        });

        String getTextNewBtn = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span[@class='ui-button-text ui-c']")).getText();
        System.out.println("New Button text is Fluent meth:" + getTextNewBtn);
    }
}

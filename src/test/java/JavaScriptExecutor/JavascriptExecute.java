package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptExecute {


    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

    }
    @Test
    public void JavascriptExecute() throws InterruptedException {
        //get a alert in a web page using JS
        //JavascriptExecutor jsExecute = (JavascriptExecutor) driver;
        //jsExecute.executeScript("alert('Hello this is my first alert');");


        //2. set a Input value in a textBox using JavaScriptExecutor
            //2.1 set the value sing value property
        WebElement dropName = driver.findElement(By.xpath("//input[@id='name']"));
        WebElement dropEmail = driver.findElement(By.xpath("//input[@id='email']"));
        JavascriptExecutor jsExecute = (JavascriptExecutor) driver;
        //jsExecute.executeScript("arguments[0].value='Gayan Isuru'", dropName);

        //2.2 set the value using setAttribute
        jsExecute.executeScript("arguments[0].setAttribute('value', 'Gayan Isuru')", dropName);


        //3. Highlight Elements

        jsExecute.executeScript("arguments[0].style.border='3px solid red'", dropName);
        jsExecute.executeScript("arguments[0].style.background='blue'", dropName);


        Thread.sleep(2000);

        //4. click elements using javaScriptExecutor
        WebElement selectDate = driver.findElement(By.xpath("//input[@id='sunday']"));
        jsExecute.executeScript("arguments[0].click();", selectDate);
    }



}

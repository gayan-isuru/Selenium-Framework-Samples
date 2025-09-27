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
    JavascriptExecutor jsExecute;
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
        jsExecute = (JavascriptExecutor) driver;
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


        //5.task

        WebElement ScrollTillCountry = driver.findElement(By.xpath("//label[normalize-space()='Country:']"));
        jsExecute.executeScript("arguments[0].scrollIntoView()", ScrollTillCountry);

        scrollPage();
    }

    public void scrollPage() throws InterruptedException {
        //1. scroll  some position
        // scroll down 1000px
        jsExecute.executeScript("window.scrollTo(0,'1000')");
        System.out.println("Current pageOff set value is :"+jsExecute.executeScript("return window.pageOffset"));
        //Scroll up old position
        Thread.sleep(2000);
        jsExecute.executeScript("window.scrollTo(0,'-1000')");


        //2 scroll the bottom of the page using pixel number
        Thread.sleep(2000);

        jsExecute.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //3.Scroll the top of the page
        Thread.sleep(2000);

        jsExecute.executeScript("window.scrollTo(0,0");

        //4. Scroll the page till element is visible
        Thread.sleep(1000);
        WebElement ScrollTillCountry = driver.findElement(By.xpath("//label[normalize-space()='Country:']"));
        jsExecute.executeScript("arguments[0].scrollIntoView()", ScrollTillCountry);
    }



}

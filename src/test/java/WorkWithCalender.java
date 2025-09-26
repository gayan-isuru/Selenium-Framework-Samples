import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WorkWithCalender {

    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    //method 1
    public void workWithCalenderExample1() {
//        driver.get("https://jqueryui.com/datepicker/");

//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
//        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
//        datePicker.click();
//
//        datePicker.sendKeys("10/10/2025");

    }

    @Test
    //method 2
    public void workWithCalenderExample2() {
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();

        while(true){

        String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

        if(actualMonth.equals("October") && actualYear.equals("2025")) {
            break;
        }
        else{
            driver.findElement(By.xpath("//a[@title='Next']")).click();
        }

        }
        List<WebElement>  selectDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement element : selectDate) {
            if(element.getText().equals("10")){
                element.click();
                break;
            }
        }

    }
}


package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable1 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

    }
    @Test
    public void WebTable1() throws InterruptedException {
        //task1: How many rows in the table

       int countRow = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Total number of rows in the table: " + countRow);

        //task2: How many Columns in the table

        int countColumns = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Total number of columns in the table: " + countColumns);


        //task3: Retrieve the specific row/column data

        String getData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[4]/td[3]")).getText();
        System.out.println("Retrieve specific data in 4th row 4rd data "+getData);



        //task4: retrieve the all data from table

        // we want to two for loops 1. outerloop(table row) 2. table data

        for(int i=1;i<=countRow;i++) {  //countRow =5
            for (int j=1;j<countColumns;j++) {   //countColumns =4

                String tableData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tableData+" ");
            }
            System.out.println();
        }




        //task5: print ID and Name only Table

        for(int i=1;i<=countRow;i++) {
            String getID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String getName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();

            System.out.println("Product ID: "+getID +" " +" Product Name: "+ getName);
        }

        //5.1 Find the product price ,which name related to Laptop

        for(int i=1;i<=countRow;i++) {
            String getProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
            if(getProductName.equals("Laptop")){
                String geProductPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();

                System.out.println("Relevent product Price: "+geProductPrice);
                break;
            }

        }

        //task6: select all the checkbox
        //count pages
        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for(int i=0;i<=pageCount;i++) {
            pages.get(i).click();
            Thread.sleep(2000);
            for(int j=1;j<countRow;j++) {
                boolean isSelect =driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[4]/input")).isSelected();
                if(!isSelect) {
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[4]/input")).click();
                    //Thread.sleep(2000);
                }


            }
        }




        //7 task select one checkBox
        int testData = 4;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+testData+"]/td[4]/input")).click();





    }
}

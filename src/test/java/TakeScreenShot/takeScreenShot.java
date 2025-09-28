package TakeScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class takeScreenShot {

    WebDriver driver;
    private File File;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.leafground.com/alert.xhtml");
    }
    @Test
    public void takeScreenShot() throws IOException, AWTException {

        //capture screenshot of full webpage

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;    //get TakeScreenshotInterface
        File storeFile = takesScreenshot.getScreenshotAs(OutputType.FILE);              // in takeScreenshot-> getScre..AS(return type);and store in file
        File destinationFile = new File(System.getProperty("user.dir") + "\\ScreenShot" + "\\alertFullScreen1.png");
        FileHandler.copy(storeFile,destinationFile);




        //capture screenshot of section of web page

       WebElement getTargetSection = driver.findElement(By.xpath("//*[@id=\"j_idt88\"]/div/div[1]"));
       File store2 = getTargetSection.getScreenshotAs(OutputType.FILE);
        File destinationFile2 = new File(System.getProperty("user.dir") + "\\ScreenShot" + "\\alertTargetSS.png");
       FileUtils.copyFile(store2,destinationFile);

        //capture screenshot of element of web page


        WebElement getTargetElement = driver.findElement(By.xpath(" //*[@id=\"j_idt88\"]/div/div[2]/div[2]"));
        File store3= getTargetElement.getScreenshotAs(OutputType.FILE);
        File destinationFile3 = new File(System.getProperty("user.dir") + "\\ScreenShot" + "\\alertTargetElement.png");
        FileUtils.copyFile(store3,destinationFile3);


        //capture screenshot of full entire full screen
       WebElement alertBox =  driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt91\"]"));
       alertBox.click();

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage source2 = robot.createScreenCapture(rectangle);
        File destinationFile4 = new File(System.getProperty("user.dir") + "\\ScreenShot" + "\\alertTargetentireimage.png");
        ImageIO.write(source2, "png", destinationFile4);

    }


}

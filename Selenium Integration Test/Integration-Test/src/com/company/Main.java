package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/geckodriver");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, myprofile);
        dc.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(dc);
        driver.get("http://localhost:8080");

        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Part 0 --- Register ----
//        driver.findElement(By.xpath("//a[@id='register_test']")).click();
//        driver.findElement(By.id("name")).sendKeys("test");
//        driver.findElement(By.id("lastname")).sendKeys("testcase");
//        driver.findElement(By.id("username")).sendKeys("local");
//        driver.findElement(By.id("password")).sendKeys("12345");
//        driver.findElement(By.id("email")).sendKeys("local@bristol.ac.uk");
//
////        Select select = (Select)driver.findElement(By.id("course"));
////        select.selectByValue("EE");
//        driver.findElement(By.id("ucard")).sendKeys("12345");
//        WebElement scroll = driver.findElement(By.id("submit"));
//        js.executeScript("arguments[0].scrollIntoView();", scroll);
//        js.executeScript("arguments[0].click();", scroll);
//        driver.findElement(By.xpath("//button[@id='submit']")).click();


        // --------------------------------------------------------------
        //END OF PART 0

        //Part 1 ---- NAVIGATE THROUGH LOGIN --
        driver.findElement(By.xpath("//a[@id='login_test']")).click();
        driver.findElement(By.id("username")).sendKeys("local");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@value='Login']")).click();
        // --------------------------------------------------------------
        //END OF PART 1

        //PART 2 -- MAKE A BOOKING
        driver.findElement(By.xpath("//a[@id='book_test']")).click();
        Select select = new Select(driver.findElement(By.id("start_time")));
        select.selectByValue("9");
        Select sel2 = new Select(driver.findElement(By.id("end_time")));
        sel2.selectByValue("10");
        driver.findElement(By.xpath("//input[@id='booking_d1']")).click();

        //scroll down
        WebElement Element = driver.findElement(By.id("1"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", Element);
        js.executeScript("arguments[0].click();", Element);
//        driver.findElement(By.xpath("//input[@id='1']")).click();
        // --------------------------------------------------------------

        WebElement Element2 = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView();", Element2);
        driver.findElement(By.xpath("//input[@id='submit']")).click();
        driver.findElement(By.xpath("//a[@id='return_to_home_test']")).click();

        // --------------------------------------------------------------
        //END OF PART 2

        //PART 3 -TEST ACCESS
        driver.findElement(By.xpath("//a[@id='userallbooking_test']")).click();
        driver.findElement(By.xpath("//a[@id='return_to_home_test']")).click();

        //---------------------------
        //END OF PART 3

        //PART 4 - TEST EDIT USER
        driver.findElement(By.xpath("//a[@id='edituser_test']")).click();
        driver.findElement(By.id("name")).sendKeys("testfirstname");
        driver.findElement(By.id("lastname")).sendKeys("testlastname");
//        driver.findElement(By.xpath("//a[@id='edituser_test']")).click();
        driver.findElement(By.xpath("//input[@id='submit']")).click();

        // --------------------------------------------------------------
        //END OF PART 4

        // PART 5 -- TEST ADMIN BOOKING
        driver.get("http://localhost:8080/admin");
        driver.findElement(By.xpath("//a[@id='book_test']")).click();


        Select admin1 = new Select(driver.findElement(By.id("start_time")));
        admin1.selectByValue("10");
        Select admin2 = new Select(driver.findElement(By.id("end_time")));
        admin2.selectByValue("12");
        driver.findElement(By.xpath("//input[@id='admin_d2']")).click();
//        driver.findElement(By.xpath("//input[@id='select_All']")).click();

        //seats
        WebElement checkbox = driver.findElement(By.id("sellect_All"));
        checkbox.click();
//        driver.findElement(By.xpath("//input[@id='A4']")).click();

//        WebElement frame = ((FirefoxDriver) driver).findElementByCssSelector("input[id=A3]");
//        frame.click();
//        WebElement checkbox = driver.findElement(By.id("A3"));
//        checkbox.click();


        WebElement admin = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView();", admin);
        js.executeScript("arguments[0].click();", admin);
        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.elementToBeClickable(lastElementToLoad));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("return_to_home_test")));
        driver.findElement(By.xpath("//a[@id='return_to_home_test']")).click();
        // --------------------------------------------------------------
        //END OF PART 5

//        //PART 6 ADMIN SHOW ALL BOOKING
//        driver.get("http://locahost:8080/bookings/admin_all_booking");
//        WebDriverWait wait2 = new WebDriverWait(driver, 20);
////        wait.until(ExpectedConditions.elementToBeClickable(lastElementToLoad));
//        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("return_to_admin_home_test")));
//        driver.findElement(By.xpath("//a[@id='return_to_admin_home_test']")).click();

        // --------------------------------------------------------------
        //END OF PART 6

        driver.quit();








//        //find text box
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell");
//        //click search button
//        driver.findElement(By.xpath("//input[@value='Go']")).click();
    }
}
package org.portfolio.tests.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private WebDriver driver;

    //actions needed BeforeMethod:
    //start driver
    //go to web page
    //log in
    @BeforeMethod
    public void start(){
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("dac15906354f41e4ae7fdf6bb3b098a4");
        driver.findElement(By.name("Submit")).click();
    }

    //actions needed AfterMethod
    //close driver
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

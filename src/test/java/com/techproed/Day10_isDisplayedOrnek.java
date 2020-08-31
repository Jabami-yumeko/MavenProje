package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup(); // chrome driver kullanabilir hale geliyor

    }

    @Before
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.bestbuy.com");
    }

    @After
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void titleTest(){
        String sayfaBasligi = driver.getTitle();
        boolean bestKelimesiIceriyorMu = sayfaBasligi.contains("Best");
        Assert.assertTrue(bestKelimesiIceriyorMu);
    }
    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.className("logo"));
        boolean logoGorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(logoGorunuyorMu);
    }
    @Test
    public void mexicoLinkTest(){
        WebElement mexicoLinki = driver.findElement(By.partialLinkText("Mexico"));
        boolean linkGorunuyorMu = mexicoLinki.isDisplayed();
        Assert.assertTrue(linkGorunuyorMu);
    }
}

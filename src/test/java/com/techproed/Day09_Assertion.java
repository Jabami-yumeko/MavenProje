package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){
        driver.get("http://google.com");
        String googleTitle = driver.getTitle();

        Assert.assertEquals("Arama",googleTitle);
    }

    @Test
    public void test2(){
        driver.get("http://amazon.com");
         // Amazon.com basligi amazon kelimesini iceriyor olsun

        String title = driver.getTitle();
        boolean iceriyorMu = title.contains("Amazon"); // "true" ya da "false"

        // boolean veri tipinde bir deger giriyoruz.
        Assert.assertTrue(iceriyorMu); // true oldugunu dogrula
        // Parantezin icerisi TRUE ise test basarili
    }
    @Test
    public void test3(){
        driver.get("http://facebook.com");
        String title = driver.getTitle();

        // facebook.com title i Youtube kelimesini icermesin.

        boolean iceriyorMu = title.contains("Youtube");
        Assert.assertFalse(iceriyorMu); // false oldugunu dogrula
        // Parantezin icerisi FALSE ise test basarili
    }
    @Test
    public void test4(){
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println("MERHABALAR");
        Assert.assertEquals("Google arama sayfasi",title);
        System.out.println("TEST DOGRULAMA ISLEMI BITTI ...");
    }
    @Test
    public void test5(){
        driver.get("http://facebook.com");
        String title = driver.getTitle();

        // facebook.com title i Youtube kelimesini icermesin.

        boolean iceriyorMu = title.contains("Youtube");
        Assert.assertFalse(iceriyorMu); // false oldugunu dogrula
        // Parantezin icerisi FALSE ise test basarili

        System.out.println("TEST DOGRULAMA ISLEMI BITTTIIII");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }












}

package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Day08_IkinciOrnek {

static WebDriver driver;

    @BeforeClass // class calismaya baslayinca bu calisir
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterClass // class calismayi bitince bu calisir
    public static void tearDown(){
        driver.quit();
    }

    @Before // Her test methodundan once calisir
    public void beforeTest(){
        driver.get("http://google.com");
    }
    @After // Her test methodundan sonra calisir
    public void afterTest(){
        WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayisi.getText());
    }
    @Test
    public void test1(){
            WebElement aramaKutusu = driver.findElement(By.name("q"));
            aramaKutusu.sendKeys("elma");
        aramaKutusu.submit();
        }

    @Test
        public void test2(){
            WebElement aramaKutusu = driver.findElement(By.name("q"));
            aramaKutusu.sendKeys("samsung kulaklık");
        aramaKutusu.submit();
        }
    @Test
    public void test3(){
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("çalışma sandalyesi");
        aramaKutusu.submit();
    }








}

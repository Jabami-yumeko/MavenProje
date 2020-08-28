package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {
    public static void main(String[] args) {
        // Browser lari kullanabilmek icin WebDriverManager kutuphanesini
        // kullaniyoruz.

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("samsung headphones" + Keys.ENTER);

        WebElement searchFoundText = driver.findElement(By.xpath("//span[@dir='auto']"));
        searchFoundText.getText();
        System.out.println(searchFoundText.getText());

        WebElement firstChoise = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(firstChoise.getText());

        List<WebElement> allItems = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
//        allItems.get(4).getText();
//        System.out.println(allItems.get(4).getText());

        for (WebElement w:allItems){
            System.out.println(w.getText());
        }
    }
}

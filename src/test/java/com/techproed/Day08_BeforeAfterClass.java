package com.techproed;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day08_BeforeAfterClass {

    @BeforeClass
    public static  void setUp(){
        System.out.println("Setup is working well");
    }
    @Test
    public void test1(){
        System.out.println("Test 1 is working well");
    }
    @Test
    public void test2(){
        System.out.println("Test 2 is working well");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("tearDown is working well");
    }

}

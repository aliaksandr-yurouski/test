package com.epam;

import org.testng.Assert;
import org.testng.annotations.*;

public class AppTest extends Assert
{
    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][]{
                {2,2,4},
                {2,3,5},
                {3,3,6}
        };
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite.");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before test.");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before class.");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method.");
    }

    @Test(dataProvider = "dataProvider")
    public void testCase(int first, int second, int expected_result){
        System.out.println("testCase.");
        assertEquals(first + second, expected_result);
    }

    @Test
    public void anotherTestCase(){
        System.out.println("anotherTestCase.");
        assertNotEquals(2 + 3, 4);
    }

    @Parameters({"devident", "devider"})
    @Test(expectedExceptions = ArithmeticException.class)
    public void exceptionTest(String devident, String devider){
        int a = Integer.parseInt(devident) / Integer.parseInt(devider);
    }

    @AfterClass
    public void after(){
        System.out.println("after test case.");
    }
}

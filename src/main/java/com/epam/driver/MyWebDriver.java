package com.epam.driver;

import com.epam.properties.PropertyLoader;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aliaksandr_Yurouski on 7/31/2015.
 */
public class MyWebDriver {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static DesiredCapabilities desiredCapabilities;
    private static final int TIMEOUT = Integer.parseInt(PropertyLoader.loadPropetryByName("TIMEOUT"));

    public static WebDriver createWebDriver(){

        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("Firefox");
        desiredCapabilities.setPlatform(Platform.WINDOWS);

        driver.set(new FirefoxDriver(desiredCapabilities));

        driver.get().manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.get().manage().window().maximize();
        return driver.get();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void closeDriver(){
        driver.get().quit();
    }
}

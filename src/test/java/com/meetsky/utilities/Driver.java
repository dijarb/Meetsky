package com.meetsky.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static WebDriver driver;
    private static Dimension defaultWindowSize;

    public static WebDriver getDriver(){
        if(driver == null){
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException("Incorrect browser type, please check configuration.properties file\nSupported browser types: chrome, firefox, edge");
            }
            defaultWindowSize = driver.manage().window().getSize();
            maximizeWindow();
            Driver.timeout(10,"s");
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver != null){
            driver.quit(); // this line will terminate the existing session. value will not even be null
            driver = null;
        }
    }

    public static void maximizeWindow(){
        driver.manage().window().maximize();
        return;
    }

    public static void setDefaultWindowSize(){
        driver.manage().window().setSize(defaultWindowSize);
        return;
    }

    public static void timeout(long duration, String unitOfTime){
        switch (unitOfTime.toLowerCase()){
            case "ms":
                driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MILLISECONDS);
                break;
            case "s":
                driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
                break;
            case "m":
                driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MINUTES);
                break;
            case "h":
                driver.manage().timeouts().implicitlyWait(duration, TimeUnit.HOURS);
                break;
            case "d":
                driver.manage().timeouts().implicitlyWait(duration, TimeUnit.DAYS);
                break;
        }
        return;
    }


}

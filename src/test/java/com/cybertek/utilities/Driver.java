package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private Driver(){

    }

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver( new ChromeOptions().setHeadless(true));
                    break;

                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

                case "chrome-remote":

                    //same as ChromeOptions
                   // DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                   // desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);

                    try {

                        ChromeOptions chromeOptions = new ChromeOptions();//to run tests on chrome browser remotely
                        URL url = new URL("http://54.87.102.95:4444/wd/hub");
                        //url is ip address of EC2 that is running Selenium Grid
                        driver = new RemoteWebDriver(url, chromeOptions);//we use remote web driver which takes 2 args
                                //first arg is url, second is chromeOptions

                    }catch (MalformedURLException e){//all in try catch because Url constructor throws checked exception

                        e.printStackTrace();
                    }
                    break;

                case "firefox-remote":
                    try{

                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        URL url = new URL("http://54.87.102.95:4444/wd/hub");
                        driver = new RemoteWebDriver(url, firefoxOptions);

                    }catch (Exception e){

                        e.printStackTrace();
                    }
                    break;

                default:
                    throw new RuntimeException("Wrong browser name: "+browser);


            }
        }

        return driver;
    }


    public static void closeDriver(){

        if(driver != null){//if driver is not null

            driver.close();//close it

            driver = null;//and set the value to null
        }
    }



}

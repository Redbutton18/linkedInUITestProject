package com.linkedIn;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.linkedIn.helpers.properties.UrlLinkProp.MAIN_URL;


@Listeners({})
public class BaseTest {
    public String baseUrl = MAIN_URL;
    public String remoteURL = "http://10.0.2.15:4444/wd/hub";
    public RemoteWebDriver driver;

//    @BeforeTest
//    public void setUp(){
//        Configuration.browser = "chrome";
//        Configuration.startMaximized = true;
//        Configuration.timeout = 10000;
//        Configuration.reportsFolder = "target/test-result/reports";
//    }
    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browserName){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("enableVNC", true);

        if (browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        } else if (browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        } else if (browserName.equals("opera")){
            WebDriverManager.operadriver().setup();
            cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.OPERA);
        }
        try{
            driver = new RemoteWebDriver(new URL(remoteURL), cap);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
    }
}

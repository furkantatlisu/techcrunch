package Tests;

import Pages.LatestNewsPage;
import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstCase {

    String driverPath = "chromedriver.exe";
    WebDriver driver;
    MainPage mainPage;
    LatestNewsPage latestNewsPage;

    public void getObject(){
        mainPage = new MainPage(driver);
        latestNewsPage = new LatestNewsPage(driver);
    }

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://techcrunch.com/");
        driver.manage().window().maximize();
        System.out.println("driver executed");
    }

    @AfterTest
    public void shutdown(){
        driver.quit();
        System.out.println("driver closed");
    }

    @Test
    public void mainSenario(){
        getObject();
        mainPage.checkMainPageTitle();  //verify main page
        mainPage.confirmLatestNewsAuthorList();
        mainPage.confirmLatestNewsImageList();
        mainPage.compareRandomChosenTitle();
        latestNewsPage.compareUrlAndTitle();
        latestNewsPage.compareBrowserTabAndTitle();
    }



}

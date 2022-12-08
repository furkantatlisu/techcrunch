//package Tests;
//
//import Common.Util;
//import Pages.MainPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import java.util.concurrent.TimeUnit;
//
//public class BaseTest {
//
//    String driverPath = "chromedriver.exe";
//    WebDriver driver;
//    BaseTest baseTest;
//
//    @BeforeTest
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver", driverPath);
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://techcrunch.com/");
//        driver.manage().window().maximize();
//        System.out.println("driver executed");
//    }
//
//    @AfterTest
//    public void shutdown(){
//        driver.quit();
//    }
//}

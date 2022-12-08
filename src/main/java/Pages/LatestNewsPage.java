package Pages;

import Common.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LatestNewsPage {
    WebDriver driver;
    Util util;

    By latestNewsMainTitle = By.xpath("//*[@class='article__title']");


    public LatestNewsPage(WebDriver driver) {
        util = new Util(driver);
        this.driver = driver;
    }

    public boolean compareUrlAndTitle(){
        String substringText = util.find(latestNewsMainTitle).getText().toUpperCase().substring(1,6);
        String url = driver.getCurrentUrl().toUpperCase().substring(35,40);
        if (substringText.equals(url)){
            System.out.println("title and url are matched");
            return true;
        }
        else {
            System.out.println("title and url are not matched");
            return false;
        }
    }

    public boolean compareBrowserTabAndTitle(){
        String tabName = driver.getTitle().toUpperCase().substring(0,10);
        String substringText = util.find(latestNewsMainTitle).getText().toUpperCase().substring(0,10);

        if (substringText.equals(tabName)){
            System.out.println("title and browser name are matched");
            return true;
        }
        else {
            System.out.println("title and browser name are not matched");
            return false;
        }
    }


}

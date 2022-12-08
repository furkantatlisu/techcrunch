package Pages;

import Common.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainPage {
    WebDriver driver;
    Util util;

    By titleText = By.xpath("//*[@class='button button--secondary button--subscribe']");
    By latestNewsTitleList = By.xpath("//*[@class='river river--homepage ']//*[@class='post-block__title__link']");
    By latestNewsAuthorList = By.xpath("//*[@class='river river--homepage ']//*[@class='post-block__title__link']//parent::*//following-sibling::*//*[@class='river-byline__authors']");
    By latestNewsImageList = By.xpath("//*[@class='river river--homepage ']//*[@class='post-block__title__link']//parent::*//parent::*//following-sibling::footer//figure");
    By latestNewsMainTitle = By.xpath("//*[@class='article__title']");


    public MainPage(WebDriver driver) {
        util = new Util(driver);
        this.driver = driver;
    }

    public boolean checkMainPageTitle(){
        if (util.isDisplayed(titleText)){
            return true;
        }
        else {
            return false;
        }
    }

    public void confirmLatestNewsAuthorList(){
        List<WebElement> elementList = util.findAll(latestNewsAuthorList);
        List<String> titleTextList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        titleTextList.stream().count();
    }

    public void confirmLatestNewsImageList(){
        List<WebElement> elementList = util.findAll(latestNewsImageList);
        List<String> titleImageList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        titleImageList.stream().count();
    }

    public boolean compareRandomChosenTitle(){
        Random rand = new Random();
        List<WebElement> elementList = util.findAll(latestNewsTitleList);
        int listSize = elementList.size();
        int randomIndex = rand.nextInt(listSize);
        WebElement randomElement = elementList.stream().collect(Collectors.toList()).get(randomIndex);
        String randomElementText = randomElement.getText();
        util.moveToSeeElement(randomElement);
        elementList.get(randomIndex).click();
        String randomChosenElementTitle = util.find(latestNewsMainTitle).getText();
        if (randomChosenElementTitle.equals(randomElementText)) {
            System.out.println("correct titles");
            return true;
        }
        else {
            System.out.println("wrong titles");
            return false;
        }
    }

}

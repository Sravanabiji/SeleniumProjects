import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.Set;

public class ArticleHubPageTest {
    public static void main(String[] args){
        //set path to chrome
        System.setProperty("webdriver.chrome.driver","E:\\ChromeDrivers\\chromedriver-win32\\chromedriver.exe");
        //launch chrome
        WebDriver driver = new ChromeDriver();
        //navigate to url
        driver.get("https://qaarticlehub.ccbp.tech/");
        // click the article
        WebElement articleEl = driver.findElement(By.xpath("/html/body/div/div[2]"));
        articleEl.click();
        //window handles
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle : windowHandles){
            driver.switchTo().window(handle);
        }

        //print the article title
        WebElement articleTitle = driver.findElement(By.xpath("/html/body/div/div/div/h1"));
        String articleTitleEl = articleTitle.getText();
        //print
        System.out.println(articleTitleEl);

        //print the article content
        WebElement articleContent = driver.findElement(By.xpath("/html/body/div/div/div/p"));
        String articleContentEl =  articleContent.getText();
        //print
        System.out.println(articleContentEl);
        //close
        driver.close();
        //quit
        driver.quit();
    }
}

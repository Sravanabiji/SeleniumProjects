import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WikiSearchTest {
    public static void main(String[] args){
        // set path to chrome
        System.setProperty("webdriver.chrome.driver","E:\\ChromeDrivers\\chromedriver-win32\\chromedriver.exe");
        // new chrome driver
        WebDriver driver = new ChromeDriver();
        // navigate to url
        driver.get("https://qawikisearch.ccbp.tech/");
        // web element
        WebElement inputEl = driver.findElement(By.xpath("//input[@id='searchInput']"));
        inputEl.sendKeys("HTML");
        // search button
        WebElement buttonEl = driver.findElement(By.xpath("//button[@class = 'search-button']"));
        buttonEl.click();
        // create WebDriverWait object with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait element displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='result-item']")));
        // list web element
        List<WebElement> results = driver.findElements(By.xpath("//div[@class ='result-item']"));
        // if conditions
        if (results.size()>3){
            System.out.println("Results Found");
        }
        //close
        driver.quit();
    }
}

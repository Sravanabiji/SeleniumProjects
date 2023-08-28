import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class AppStoreTest {
    public static void main(String[] args){
        //set path to chrome
        System.setProperty("webdriver.chrome.driver","E:\\ChromeDrivers\\chromedriver-win32\\chromedriver.exe");
        //launch chrome
        WebDriver driver = new ChromeDriver();
        //navigate to url
        driver.get("https://qaappstore.ccbp.tech");

        //first test

        //social button
        WebElement socialEl = driver.findElement(By.xpath("/html/body/div/div/div/ul[1]/li[1]/button"));
        socialEl.click();
        //verify apps
        int excepetedCount = 10;
        int actualCount = driver.findElements(By.xpath("/html/body/div/div/div/ul[2]/li")).size();
        //if
        if(excepetedCount == actualCount){
            System.out.println("Social apps count is correct");
            } else{
            System.out.println("Social apps count is incorrect");
        }

        //games tab
        WebElement gameEl = driver.findElement(By.xpath("/html/body/div/div/div/ul[1]/li[2]/button"));
        gameEl.click();
        //verify apps
        int gameCount = 10;
        int gamesCount = driver.findElements(By.xpath("/html/body/div/div/div/ul[2]/li")).size();
        //if statement
        if(gameCount == gamesCount){
            System.out.println("Gaming apps count is correct");
        }
        else {
            System.out.println("Gaming apps count is incorrect");
        }

        //news tab

        //newsbutton
        WebElement newsEl = driver.findElement(By.xpath("/html/body/div/div/div/ul[1]/li[3]/button"));
        newsEl.click();
        //verify
        int newCount = 10;
        int newsCount = driver.findElements(By.xpath("/html/body/div/div/div/ul[2]/li")).size();
        //if statement
        if(newCount == newsCount){
            System.out.println("News apps count is correct");
        }
        else{
            System.out.println("News apps count is incorrect");
        }

        //food tab

        //foob button
        WebElement foodEl = driver.findElement(By.xpath("/html/body/div/div/div/ul[1]/li[4]/button"));
        foodEl.click();
        //verify
        int foodCount = 10;
        int foodsCount = driver.findElements(By.xpath("/html/body/div/div/div/ul[2]/li")).size();
        //if statement
        if(foodCount == foodsCount){
            System.out.println("Food apps count is correct");
        }
        else {
            System.out.println("Food apps count is incorrect");
        }


        //secondtest

        //newsbutton
        WebElement newEl = driver.findElement(By.xpath("/html/body/div/div/div/ul[1]/li[3]/button"));
        newEl.click();
        //searchinput
        WebElement searchInput = driver.findElement(By.cssSelector("input.search-input"));
        searchInput.sendKeys("News");

        //verify
        int NEWSCOUNT = 7;
        int NewsCount = driver.findElements(By.xpath("/html/body/div/div/div/ul[2]/li")).size();
        //if statement
        if(NEWSCOUNT == NewsCount){
            System.out.println("News apps count is correct");
        }
        else{
            System.out.println("News apps count is incorrect");
        }

        // Verify whether all the apps contain "News" in their names
        boolean allAppsContainNews = true;
        for (WebElement app : driver.findElements(By.cssSelector(".app .app-name"))) {
            if (!app.getText().contains("News")) {
                allAppsContainNews = false;
                break;
            }
        }

        if (allAppsContainNews) {
            System.out.println("Search results for \"News\":");
            for (WebElement app : driver.findElements(By.cssSelector(".app .app-name"))) {
                System.out.println("<" + app.getText() + ">");
            }
        } else {
            System.out.println("Search functionality is not as expected");
        }

    }
}

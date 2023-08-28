import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class TipCalculatorTest {
    public static void main(String[] args){
        //set path to chrome
        System.setProperty("webdriver.chrome.driver","E:\\ChromeDrivers\\chromedriver-win32\\chromedriver.exe");
        // launch chrome
        WebDriver driver = new ChromeDriver();
        //navigate to url
        driver.get("https://qatipcalc.ccbp.tech/");
        //bill amount
        WebElement billEl = driver.findElement(By.cssSelector("input[id ^= 'billAmount']"));
        billEl.sendKeys("1000");
        //percentage tip
        WebElement percentageEl = driver.findElement(By.cssSelector("input[id ^= 'percentageTip']"));
        percentageEl.sendKeys("12");
        //button
        WebElement button = driver.findElement(By.cssSelector("button[id *= 'calculateButton']"));
        button.click();
        //tip amount
        WebElement tip = driver.findElement(By.cssSelector("p[id *= 'tipAmount']"));
        tip.getText();
        //total amount
        WebElement total = driver.findElement(By.cssSelector("p[id *= 'totalAmount']"));
        total.getText();

        String acutalTip = tip.getText();
        String excepetedTip = acutalTip;
        String actualTotal = total.getText();
        String excepetedTotal = actualTotal;
        //if statement
        if(acutalTip.equals(excepetedTip) && actualTotal.equals(excepetedTotal)){
            System.out.println("Tip Calculated Correctly");
        } else {
            System.out.println("Tip Calculated Incorrectly");
        }
        //second test case
        //percentage tip
        WebElement percentage = driver.findElement(By.cssSelector("input[id ^= 'percentageTip']"));
        percentage.clear();
        //button
        WebElement buttonEl = driver.findElement(By.cssSelector("button[id *= 'calculateButton']"));
        buttonEl.click();

        String excepetedMsg = "Please Enter a Valid Input.";
        String actualMsg = excepetedMsg;
        //if statement
        if(excepetedMsg.equals(actualMsg)){
            System.out.println("Error message displayed for no input");
        } else{
            System.out.println("Error message missing for no input");
        }
        //third case

        //percentage tip
        WebElement percentage3 = driver.findElement(By.cssSelector("input[id ^= 'percentageTip']"));
        percentage3.sendKeys("10f");
        //button
        WebElement button3 = driver.findElement(By.cssSelector("button[id *= 'calculateButton']"));
        button3.click();
        //error msg
        WebElement errormsg = driver.findElement(By.cssSelector("p[id $= 'errorMessage'"));
        String excepetedMsgEl = "Please Enter a Valid Input";
        String actualMsgEl = excepetedMsgEl;
        //if statement
        if(excepetedMsgEl.equals(actualMsgEl)){
            System.out.println("Error message displayed for invalid input");
        } else {
            System.out.println("Error message missing for invalid input");
        }
        //close
        driver.quit();
    }
}

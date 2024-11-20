package core;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Driver {
    public static WebDriver driver;
    private static WebDriverWait wait;
    private static String nameScenario;
    private static File directory;
    private static int numberPrint;
    public static void setNameScenario(String nameScenario) {
        Driver.nameScenario = nameScenario;
    }
    public Driver(Browser navegador){
        switch (navegador){
            case CHROME:
                startChrome();
                break;
            case EDGE:
                startEdge();
                break;
            case FIREFOX:
                startFireFox();
                break;
            case IE:
                startIE();
                break;

        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    private static void startIE() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
    }

    private static void startFireFox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private static void startEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    private static void startChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        boolean headless = Boolean.parseBoolean(System.getProperty("headless"));

        if (headless) {
            chromeOptions.addArguments("--headless");
        }

        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(chromeOptions);
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void visibilityOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public static void invisibilityOf(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void creatDirectory(){
        String path = "src/test/resources/evidencias";
        directory = new File(path +"/"+ nameScenario);
        directory.mkdir();
        numberPrint = 0;
    }

    public static void printScreen(String pass) throws IOException {
        numberPrint++;
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = directory.getPath() + "/"+numberPrint +" - " + pass + ".png";
        FileUtils.copyFile(file, new File(path));
    }
    public static void aguardaOptions(Select select){
        for(int i = 0; i < 6; i++){
            if (select.getOptions().size() > 1){
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }

    public void HomePage(WebDriver driver) {
        Driver.driver = driver;
        PageFactory.initElements(driver, this);
    }

}

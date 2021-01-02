import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Class1 {
    WebDriver driver;
    //Before Method is one of the annotations in testng
    //which is used to do functions before every method is invoked
    @BeforeMethod
    public void settingUpDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    //Triggering three websites to do simple operations
    //Also using dependsOnMethods to invoke specific methods before other methods
    @Test(dependsOnMethods = {"goToWebsiteAmazon"})
    public void goToWebsiteYoutube(){
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input#search")).sendKeys("testng basics");
        driver.findElement(By.cssSelector("button#search-icon-legacy")).click();
    }
    @Test(dependsOnMethods = {"goToWebsiteYoutube"})
    public void goToWebsiteUdemy(){
        driver.get("https://www.udemy.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("form.udlite-search-form-autocomplete-input-group.udlite-search-form-autocomplete-input-group-reversed > input:nth-child(2)")).sendKeys("selenium");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test
    public void goToWebsiteAmazon() throws InterruptedException {
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a#nav-hamburger-menu")).click();
        driver.findElement(By.cssSelector("ul.hmenu.hmenu-visible > li:nth-child(2)")).click();
    }
    //After Method is one of the annotations in testng
    //which is used to do functions after every method is completed
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NewTours_Test {

    private WebDriver driver;
    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src=\"images/mast_register.gif\"]");
    By usernameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name=\"confirmPassword\"]");
    By registerBtnLocator = By.name("submit");
    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By signInBtnLocator = By.name("submit");
    By homePageLocator = By.xpath("//img [@src=\"images/logo.gif\"]");


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");

    }
    @After
    public void tearDown() throws Exception {
        //driver.quit();

    }
    @Test
    public void registerUser() throws Exception {
        driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000);
        if(driver.findElement(registerPageLocator).isDisplayed()){
            driver.findElement(usernameLocator).sendKeys("Cristian Rendón");
            driver.findElement(passwordLocator).sendKeys("passUno");
            driver.findElement(confirmPasswordLocator).sendKeys("passUno");

            driver.findElement(registerBtnLocator).click();
        }else{
            System.out.println("Error");
        }
        List<WebElement> fonts = driver.findElements(By.tagName("font"));

        assertEquals("Note: Your user name is Cristian Rendón.",fonts.get(5).getText());

    }
    @Test
    public void signIn()throws Exception{
        if(driver.findElement(userLocator).isDisplayed()){
            driver.findElement(userLocator).sendKeys("Cristian Rendón");
            driver.findElement(passLocator).sendKeys("passUno");
            driver.findElement(signInBtnLocator).click();
            Thread.sleep(2000);
            assertTrue(driver.findElement(homePageLocator).isDisplayed());

        }
        else
            System.out.print("Error");

    }
}

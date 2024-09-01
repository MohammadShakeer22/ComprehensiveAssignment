import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class test1 {

    public static WebDriver driver;
    @BeforeMethod
    public static WebDriver beforeTest()
    {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--headless");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60000));
        return driver;
    }

    @Test(groups = {"Regression"})
    public static void test_PS3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--headless");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

        driver=beforeTest();
        driver.get("https://autify.com/");

        WebElement lnk_ExploreAutifyNoCode = driver.findElement(By.xpath("(//a[text()='Explore Autify NoCode'])[2]"));
        lnk_ExploreAutifyNoCode.click();

        WebElement lnk_StartFreeTrial = driver.findElement(By.xpath("//a[text()='Start Free Trial']"));
        lnk_StartFreeTrial.click();

        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Trial Application - Autify"));

        driver.quit();

    }

    @Test(groups = {"Regression"})
    public static void test_PS4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--headless");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

        driver=beforeTest();
        driver.get("https://autify.com/");

        WebElement lnk_ExploreAutifyNoCode = driver.findElement(By.xpath("(//a[text()='Explore Autify NoCode'])[2]"));
        lnk_ExploreAutifyNoCode.click();

        WebElement lnk_StartFreeTrial = driver.findElement(By.xpath("//a[text()='Start Free Trial']"));
        lnk_StartFreeTrial.click();

        WebElement btn_SignUp = driver.findElement(By.xpath("//button[text()='Sign up']"));
        btn_SignUp.click();

        WebElement validation_FirstNameMissing = driver.findElement(By.xpath("//span[contains(text(),'First name can') and contains(text(),'be blank')]"));
        WebElement validation_LastNameMissing = driver.findElement(By.xpath("//span[contains(text(),'Last name can') and contains(text(),'be blank')]"));
        WebElement validation_CompanyNameMissing = driver.findElement(By.xpath("//span[contains(text(),'Company name can') and contains(text(),'be blank')]"));
        WebElement validation_CompanySizeMissing = driver.findElement(By.xpath("//span[contains(text(),'Company size can') and contains(text(),'be blank')]"));
        WebElement validation_EmailMissing = driver.findElement(By.xpath("//span[contains(text(),'Email can') and contains(text(),'be blank')]"));
        WebElement validation_PasswordMissing = driver.findElement(By.xpath("//span[contains(text(),'Password cannot be blank')]"));
        WebElement validation_PhoneNumberMissing = driver.findElement(By.xpath("//span[contains(text(),'Phone Number') and contains(text(),'be blank')]"));

        Assert.assertTrue(validation_FirstNameMissing.isDisplayed() && validation_LastNameMissing.isDisplayed() && validation_CompanyNameMissing.isDisplayed() && validation_CompanySizeMissing.isDisplayed() && validation_EmailMissing.isDisplayed() && validation_PasswordMissing.isDisplayed() && validation_PhoneNumberMissing.isDisplayed());

        driver.quit();

    }

}

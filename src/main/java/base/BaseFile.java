package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.UdemyBusiness;

public class BaseFile {
	public static FileInputStream fisReader = null;
	public static Properties property = null;
	public static WebDriverWait wait = null;
	public static WebDriver driver;
	public static UdemyBusiness udemy = null;
	public static UtilityFile utils=new  UtilityFile();
	
	
	@BeforeSuite
	public void initialization() throws IOException {
		fisReader = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
		property = new Properties();
		property.load(fisReader);

		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--headless");
                 options.addArguments("--no-sandbox");
		 options.addArguments("--disable-dev-shm-usage");
                 driver = new ChromeDriver(options);
		 // WebDriverManager.chromedriver().setup();
		 // driver = new ChromeDriver();
	        driver.get(property.getProperty("URL"));
		driver.manage().window().maximize();
		 Thread.sleep(10000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));


		
		// WebDriverManager.chromedriver().setup();
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--incognito", "--disable-blink-features=AutomationControlled");
		// driver =  new ChromeDriver(options);
		
	}

	@BeforeTest
	public void execution() {
		// Initialize the PageFactory for the saucedemoPage class
		 udemy = PageFactory.initElements(driver, UdemyBusiness.class);
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}

}

package Selenium_API;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class API_check_environment {
	//Khai bao 1 bien driver
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-condition Step 01: init chrome driver");
		System.setProperty("webdriver.chrome.driver", ".\\Libraries\\chromedriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		
		System.out.println("Pre-condition Step 02: Wait for loading success");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		System.out.println("Pre-condition Step 03: Open IT viec website");
		driver.get("https://itviec.com/");
	}
	@Test
	public void TC_01_check_HomePage_url() {
		System.out.println("TC_01 step 01: get current page url");
		String homePageUrl = driver.getCurrentUrl();
		
		System.out.println("TC_01 step 02: expected matching actual url");
		Assert.assertEquals(homePageUrl, "https://itviec.com/");
	}
	
	@Test
	public void TC_02_check_homePage_Title() {
		System.out.println("TC_02 step 01: get home page title");
		String homePageTitle = driver.getTitle();
		
		System.out.println("TC_02 step 02: expected matching autual title");
		Assert.assertEquals(homePageTitle, "ITviec | Top IT Jobs for You");
		
		
	}
	
	@AfterClass
	public void afterClass() {
		String path = System.getenv("PATH");
		System.out.println(path);
				
		System.out.println("Run post-condition: Close Firefox browser");
		driver.close();
	}

}

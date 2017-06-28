package tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.AnnouncementPage;
import PageObject.Login;

public class LoginTest {
	
	WebDriver driver;
	String baseUrl;
	String nodeURL;
	
	@BeforeTest
	public void setUp() throws MalformedURLException{
		baseUrl = System.getProperty("baseURL");
		nodeURL = "http://PvAdmin:ae358a6d-21a9-4b75-9c96-70d162dc5657@ondemand.saucelabs.com:80/wd/hub";
		DesiredCapabilities capability = new DesiredCapabilities();
		
		System.out.println(baseUrl);
		System.out.println(nodeURL);
		System.out.println(System.getProperty("browserName"));
		System.out.println(System.getProperty("browserVersion"));
		System.out.println(System.getProperty("platform"));
		System.out.println(System.getProperty("userName"));
		System.out.println(System.getProperty("password"));
		//capability.setBrowserName(System.getProperty("browserName"));
		capability.setCapability ("browserName", System.getProperty("browserName")); 
		capability.setCapability("Version", System.getProperty("browserVersion"));
		capability.setCapability("Name", "JenkinsDemo");
		capability.setCapability("screenResolution", "1280x1024") ;
		capability.setCapability("Passed", "true");
		capability.setCapability("platform", System.getProperty("platform"));
		driver = new RemoteWebDriver(new URL(nodeURL), capability);
	}
	
	@Test(priority=0)
	public void test_login() throws InterruptedException{
		driver.get(baseUrl);
		Login objLogin = new Login(driver);
		String actualTitle = objLogin.getLoginTitle();
		Assert.assertTrue(actualTitle.contains("PVM > Login"), "Wrong page loaded");
		
		AnnouncementPage obj = objLogin.loginToPVM(System.getProperty("userName"), System.getProperty("password"));
		
		assertEquals(obj.AnnouncementPageTitle,"PVM > Announcement");
		Thread.sleep(3000);
		
		objLogin = obj.clickLogOut();
		Assert.assertTrue(actualTitle.contains("PVM > Login"), "Wrong page loaded");
	}
	
	@AfterTest
	public void TearDown(){
		driver.close();
		driver.quit();
	}
}

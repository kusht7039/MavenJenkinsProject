package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AnnouncementPage {
	WebDriver driver;
	
	public AnnouncementPage(WebDriver driver){
		this.driver = driver;
	}
	public By logOutBtn = By.linkText("logout");
	public String AnnouncementPageTitle = "PVM > Announcement";
	
	public Login clickLogOut(){
		driver.findElement(logOutBtn).click();
		return new Login(driver);
	}
}

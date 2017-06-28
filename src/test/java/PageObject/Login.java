package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	public By UserName = By.id("txtLogin");
	public By Password = By.id("txtPassword");
	public By LoginBtn = By.id("btnSubmit");
	
	public Login(WebDriver driver){
		this.driver = driver;
	}
	
	public void setUserName(String userName){
		driver.findElement(UserName).sendKeys(userName);
	}
	
	public void setPassword(String password){
		driver.findElement(Password).sendKeys(password);
	}
	
	public void clickLogin(){
		driver.findElement(LoginBtn).click();
	}
	
	public String getLoginTitle(){
		return driver.getTitle();
	}
	
	public AnnouncementPage loginToPVM(String userName, String password){
		this.setUserName(userName);
		this.setPassword(password);
		this.clickLogin();
		return new AnnouncementPage(driver);
	}

}

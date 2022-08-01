package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	Logger log; 
	WebDriver driver;
	@Test
	public void login() throws IOException, InterruptedException  {
		
	driver=Intializedriver();
	driver.get(prop.getProperty("URL"));	
	//log=LogManager.getLogger(LoginTest.class.getName());
						
	LandingPage landingpage=new LandingPage(driver);
	landingpage.myaccountdropdown().click();
	landingpage.logindropdown().click();
	
	Thread.sleep(3000);
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.emailaddressfield().sendKeys(prop.getProperty("email"));
	loginpage.passwordfield().sendKeys(prop.getProperty("password"));
	loginpage.logintButton().click();
	 
	AccountPage accounpage=new AccountPage(driver);
	Assert.assertTrue(accounpage.editAccountInformationoption().isDisplayed());
	}
	@AfterMethod
	public void close() {
		driver.close(); 
	}
 
}
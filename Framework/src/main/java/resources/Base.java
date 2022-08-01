package resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
WebDriver driver;
public Properties prop;
	
	public WebDriver Intializedriver() throws IOException {
		 prop = new Properties();
		String propPath=System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis =new FileInputStream(propPath);
		prop.load(fis);
		 String browsername=prop.getProperty("browser");	
		  
		 if(browsername.equalsIgnoreCase("chrome")) {  
			 
			 	WebDriverManager.chromedriver().setup();
			 	driver=new ChromeDriver();
			 
		 } else if(browsername.equalsIgnoreCase("firefox")){
			 
				 WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();
				
		 } else if(browsername.equalsIgnoreCase("IE")){
			 
				 WebDriverManager.iedriver().setup();
				 driver=new InternetExplorerDriver();
			 }
				 
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
			  return driver; 
		 }
	

}

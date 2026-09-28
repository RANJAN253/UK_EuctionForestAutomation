package com.forest.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import com.forest.actionclass.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	@BeforeTest
	public void loadConfig() throws IOException 
	{
		try	{
			prop = new Properties();
			System.out.println("Super constructor invoked");
			String file = System.getProperty("user.dir")+ "\\Configuration\\config.properties";
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			System.out.println("drive: " + driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
			
		}
	}	
	//@BeforeClass
	//@Parameters("Browser")
	//public static void launchApp(String Browser)
	public static void launchApp()
	{
		String browserName = prop.getProperty("browser");  // for properties 
		if(browserName.equalsIgnoreCase("Chrome"))	{
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("Firefox")) {
		     WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("IE")) {
		
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		Action.implicitWait(driver, 10);
					
		driver.get(prop.getProperty("baseURL"));
	}
}
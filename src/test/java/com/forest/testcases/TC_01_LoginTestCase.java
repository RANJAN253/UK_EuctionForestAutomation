package com.forest.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.forest.base.BaseClass;
import com.forest.testpages.TC_02_HomePage;
import com.forest.testpages.IndexPage;
import com.forest.testpages.TC_01_LoginPage;
import com.forest.utilities.*;
public class TC_01_LoginTestCase extends BaseClass {
	IndexPage index;
	TC_01_LoginPage loginpage;
	TC_02_HomePage homepage;
	
	
	  @BeforeTest 
	  public void setUp()  { 
		  launchApp(); 
		 // launchApp("chrome");
	  }
		
	@AfterTest
	public void tearDown()	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void LoginTest() throws InterruptedException	{
	   Log.startTestCase("loginTest");
		
		//Log.startTestCase("loginTest");
		index = new IndexPage();
		loginpage = index.clickOnLoginBtn();
		
		Log.info("user is going to click on SignIn");
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Log.info("Enter Username and Password");
		
		String actUrl = driver.getCurrentUrl();
		String expUrl = "http://dev.ukfdceauction.in/UserDashBoard";
		
		Assert.assertEquals(actUrl, expUrl);
		
		 Log.info("Verifying if user is able to login");
		
		 Log.info("Login is Sucess");
		 Log.endTestCase("loginTest");
		
		loginpage.validateUsername();
	}
}
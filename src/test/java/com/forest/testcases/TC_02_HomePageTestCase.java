package com.forest.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.forest.base.BaseClass;
import com.forest.testpages.TC_02_HomePage;


public class TC_02_HomePageTestCase extends BaseClass
{
	TC_01_LoginTestCase loginpage;
	TC_02_HomePage homepage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}

	
	@Test
	public void HomePageTest() throws InterruptedException
	{
		loginpage = new TC_01_LoginTestCase();
		loginpage.LoginTest();
		
		homepage = new TC_02_HomePage();
		homepage.clickOnCurrectAuctionBtn();
		Thread.sleep(2000);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

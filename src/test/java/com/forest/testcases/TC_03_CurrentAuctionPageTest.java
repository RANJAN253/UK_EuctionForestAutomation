package com.forest.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.forest.base.BaseClass;
import com.forest.testpages.TC_03_CurrentAuctionPage;


public class TC_03_CurrentAuctionPageTest extends BaseClass 
{
	TC_02_HomePageTestCase homepage;
	TC_03_CurrentAuctionPage currentauctionpage;
	
	  @BeforeMethod
	  public void setUp()  { 
		  launchApp(); 
		 // launchApp("chrome");
	  }
		
	@Test(priority=1)
	public void currentAuctionValidateList() throws Throwable	
	{
		homepage = new TC_02_HomePageTestCase();
		homepage.HomePageTest();
				
		currentauctionpage = new TC_03_CurrentAuctionPage();
		currentauctionpage.clickonAcutionId();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown()	{
		driver.quit();
	}

}

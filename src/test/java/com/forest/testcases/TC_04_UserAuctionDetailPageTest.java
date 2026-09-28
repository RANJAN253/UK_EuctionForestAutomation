package com.forest.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.forest.base.BaseClass;
import com.forest.testpages.TC_04_UserAuctionDetailPage;


public class TC_04_UserAuctionDetailPageTest extends BaseClass
{
	TC_03_CurrentAuctionPageTest currentauctiontest;
	TC_04_UserAuctionDetailPage auctiondetailpage;
	
	  @BeforeMethod
	  public void setUp()  { 
		  launchApp(); 
		 // launchApp("chrome");
	  }
	@Test(priority=1)
	public void currentAuctionDetail() throws Throwable	
	{
		currentauctiontest = new TC_03_CurrentAuctionPageTest();
		currentauctiontest.currentAuctionValidateList();
		
		auctiondetailpage = new TC_04_UserAuctionDetailPage();
		auctiondetailpage.selectCheckBox();
		Thread.sleep(1000);
		auctiondetailpage.clickOnForward();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown()	{
		driver.quit();
	}
}
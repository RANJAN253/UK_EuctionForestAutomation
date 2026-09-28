package com.forest.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.forest.base.BaseClass;
import com.forest.testpages.IndexPage;

public class IndexTestCase extends BaseClass {
	IndexPage index;
	
	  @BeforeMethod
	  public void setUp() 
	  { 
		  launchApp(); 
		//  launchApp("chrome"); 
	  }
	 
	@Test(priority = 1, enabled=true)
	public void verifyLogo() {
		index = new IndexPage();
		boolean result = index.validateLogo();
		Assert.assertTrue(result);
		System.out.println("Test Case 1:  Display Logo Successfully !");
	}

	@Test(priority=2,enabled=true)
	public void verifyTitle()
	{
	  String actTitle = index.getEAcutonTitle();
	   //Assert.assertEquals(actTitle, "Uttarakhand Forest Development Corporation, E-Auction");
	   Assert.assertEquals(actTitle, "Uttarakhand Forest Development Corporation, E-Auction");
	   System.out.println("Test Case 2 :Title Verified Successfully !");
	}
	
	  @Test(priority=3, enabled=true)
	  public void clickCurrentAuction() throws InterruptedException 
	  {
		  index = new IndexPage();
		  index.clickOnCurrentAuctionBtn();
		  Thread.sleep(2000);
		  System.out.println("Test Case 3 : Click on Current Auction Menu !");
	  }
	  
	  @Test(priority=4,enabled=true)
	  public void clickUpcomingAuction() throws InterruptedException
	  {
		  index = new IndexPage();
		  index.clickOnUpCommingAuction();
		  Thread.sleep(2000);
		  System.out.println("Test Case 4 : Successfully click on Upcoming Auction Menu");
	  }
		  
	  @Test(priority = 5, enabled=true)
	  public void openParyRegistration() throws InterruptedException {
		index = new IndexPage();
		
		index.clickPartyRegistration();
		Thread.sleep(2000);
		System.out.println("Test Case 5 : Open Registration" );
	}
	  @Test(priority=6)
	  public void clickOnAuctionID() throws Exception
	  {
		  index = new IndexPage();
		  index.clickOnAuctionLinkId();
		  Thread.sleep(1000);
		  System.out.println("Test Case 6 : Click on Auction Id Successfully" );
	  }
	  
	  
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

package com.forest.testcases;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.forest.base.BaseClass;
import com.forest.testpages.TC_05_BidPage;

public class TC_05_ForwardToBidTestCase extends BaseClass
{
	TC_04_UserAuctionDetailPageTest auctiondetailtest;
	TC_05_BidPage bid;
		
	@BeforeClass
	public void setUp()	  { 
		  launchApp();
	}
	
	@Test(priority=1,enabled=true)
	public void verifyBidWithoutValue() throws Throwable	
	{
		auctiondetailtest = new TC_04_UserAuctionDetailPageTest();
		auctiondetailtest.currentAuctionDetail();
		
		bid = new TC_05_BidPage();
		
		// *************************  TC_01 :- Click on Submit buttion without enter any Amount   ****************************************************************
		
		bid.clickBidNow();
		
		bid.clickOnSubmitBtn();
		
		//Bidding amt should be multiple of 100
		Alert alert = driver.switchTo().alert();
		String popup = 	driver.switchTo().alert().getText();
		System.out.println("Msg :- " + popup);
		alert.accept();
		Thread.sleep(2000);
		
		// ************************ TC_02 :- Bidding amt should be multiple of 100  ********************************************************************************
		bid.clickBidNow();
		Thread.sleep(1000);
		
		bid.highestBidAmt();
		
		bid.enterBidAmt(555);
		Thread.sleep(1000);
		
		bid.enterConAmt(555);
		Thread.sleep(1000);
		
		bid.clickOnSubmitBtn();
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		Thread.sleep(1000);
		
		bid.clearTextBox();
		Thread.sleep(1000);
		
	   //************************** TC_3 :  Bidding with Valid Enter  Amount and invalid enter Confirmation amount ********************************************************
		bid.clickBidNow();
		Thread.sleep(500);
		
		bid.enterBidAmt(2000);
		Thread.sleep(500);
		
		bid.enterConAmt(1000);
		Thread.sleep(500);
		
		bid.clickOnSubmitBtn();
		Thread.sleep(500);
		
		//Bidding amount and confirm bid amount do not match
		
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		Thread.sleep(1000);
		
		bid.clearTextBox();
		Thread.sleep(1000);
		//************************** TC_4 :  Bidding with Valid Enter  Amount ********************************************************************************************
		
		bid.clickBidNow();
		Thread.sleep(1000);
		
		bid.enterBidAmt(5000);
		Thread.sleep(1000);
				
		bid.enterConAmt(5000);
		Thread.sleep(1000);
				
		bid.clickOnSubmitBtn();
		Thread.sleep(5000);
	}
		
		
	@AfterClass
	public void tearDown()	{
		driver.quit();
	}
}
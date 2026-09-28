package com.forest.testcases;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.forest.base.BaseClass;
import com.forest.testpages.BidPage;
import com.forest.testpages.CurrentAuctionPage;
import com.forest.testpages.HomePage;
import com.forest.testpages.IndexPage;
import com.forest.testpages.LoginPage;
import com.forest.testpages.UserAuctionDetailPage;

public class TC_06_ForwardToBidTestCase extends BaseClass{
	HomePage homepage = new HomePage();
	CurrentAuctionPage currentauction ;
	UserAuctionDetailPage auctiondetailpage;
	BidPage bidpage;
	IndexPage indexpage;
	LoginPage loginpage;


	@BeforeClass
	public void setUp()	  { 
		launchApp();
	}

	@Test(priority=1,enabled=true)
	public void verifyBidWithValue() throws Throwable	{
		indexpage = new IndexPage();
		indexpage.clickOnLoginBtn();

		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		homepage = new HomePage();
		homepage.clickOnCurrectAuctionBtn();

		currentauction = new CurrentAuctionPage();
		currentauction.clickonAcutionId();

		auctiondetailpage = new UserAuctionDetailPage();
		auctiondetailpage.selectCheckBox();
		Thread.sleep(2000);
		auctiondetailpage.clickOnForward();

		//*********************** TC_1 :  Bidding with Enter valid Amount **************************
		bidpage = new BidPage();
		bidpage.clickBidNow();

		bidpage.enterBidAmt(1000);
		Thread.sleep(5000);

		bidpage.enterConAmt(1000);
		Thread.sleep(3000);

		bidpage.clickOnSubmitBtn();
		Thread.sleep(3000);

		//*********************** TC_2 : Verify that Bidding amt should be multiple of 100  **************************

		bidpage = new BidPage();
		bidpage.clickBidNow();

		bidpage.enterBidAmt(555);
		Thread.sleep(5000);

		bidpage.enterConAmt(555);
		Thread.sleep(3000);

		bidpage.clickOnSubmitBtn();
		Thread.sleep(3000);
		
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(5000);
		alert1.accept();
		Thread.sleep(5000);
		
		bidpage.clearTextBox();
		Thread.sleep(1000);

		//*********************** TC_ :  Bidding with Enter wrong  Amount **************************
		bidpage = new BidPage();
		bidpage.clickBidNow();

		bidpage.enterBidAmt(1000);
		Thread.sleep(5000);

		bidpage.enterConAmt(1500);
		Thread.sleep(3000);

		bidpage.clickOnSubmitBtn();
		Thread.sleep(3000);
		
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(5000);
		alert2.accept();
		Thread.sleep(5000);
		
		bidpage.clearTextBox();
		Thread.sleep(1000);
		//*********************** TC_1 :  Bidding with Enter valid Amount **************************
	
		bidpage.clickOnModifyBid();

		bidpage.enterBidAmt(1500);
		Thread.sleep(5000);

		bidpage.enterConAmt(1500);
		Thread.sleep(5000);

		bidpage.clickOnSubmitBtn();
		Thread.sleep(5000);

	}
}
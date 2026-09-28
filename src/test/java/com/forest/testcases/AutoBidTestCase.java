package com.forest.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.forest.base.BaseClass;
import com.forest.testpages.AutoBidPage;
import com.forest.testpages.TC_05_BidPage;
import com.forest.testpages.TC_02_HomePage;
import com.forest.testpages.IndexPage;
import com.forest.testpages.TC_01_LoginPage;

public class AutoBidTestCase extends BaseClass
{
	IndexPage index;
	TC_01_LoginPage loginpage;
	TC_02_HomePage homepage;
	TC_05_BidPage fwrdToBid;
	AutoBidPage autobid;
	
	@BeforeTest
	public void setUp() {
		launchApp();
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void autoBidMethod() throws InterruptedException	{
		index = new IndexPage();
		loginpage = index.clickOnLoginBtn();
		fwrdToBid = new TC_05_BidPage();
		autobid = new AutoBidPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		String actUrl = driver.getCurrentUrl();
		String expUrl = "http://dev.ukfdceauction.in/UserDashBoard";
		Assert.assertEquals(actUrl, expUrl);
		
		autobid.clickOnAutoAuctionLnk();
		autobid.selectAuctionId();
		autobid.selectLot();
		autobid.selectRange();
		autobid.enterFromAmt(25000);
		autobid.enterToAmt(25000);
		autobid.clickOnSave();
	}
}

		


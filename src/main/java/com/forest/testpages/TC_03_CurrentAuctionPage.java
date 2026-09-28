package com.forest.testpages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.forest.actionclass.Action;
import com.forest.base.BaseClass;

public class TC_03_CurrentAuctionPage extends BaseClass
{
	@FindBy(xpath="//h4[@class='page-title']")
	WebElement currentauctionlist;
	
	@FindBy(xpath="//a[normalize-space()='T/D/3/30195/G']")
	WebElement auctionId;
	
	@FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[12]/a[1]")
	WebElement Bid_Now;
	
	 public TC_03_CurrentAuctionPage()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	public boolean validateCurrentLotList() throws Throwable
	{
		String msg = currentauctionlist.getText();
		System.out.println(msg);
		// action.fluentWait(getDriver(), addToCartMessag, 10);
		 return Action.isDisplayed(driver, currentauctionlist);
	}
	
	public boolean validateAuctionId()
	{
		return Action.isDisplayed(driver, auctionId);
	}
	
	public TC_04_UserAuctionDetailPage clickonAcutionId()
	{
		Action.click(driver, auctionId);
		return new TC_04_UserAuctionDetailPage();
	}
	
  
}

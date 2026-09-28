package com.forest.testpages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.forest.actionclass.Action;
import com.forest.base.BaseClass;

public class CurrentAuctionPage extends BaseClass
{
	 public CurrentAuctionPage()	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	@FindBy(xpath="//h4[@class='page-title']")
	WebElement currentauctionlist;
	
	@FindBy(xpath="//a[normalize-space()='H/T/34/285/E']")
	WebElement auctionId;
	
	//@FindBy(xpath="//a[normalize-space()='T/D/3/30195/G']")
	//WebElement auctionId;
	
	@FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[12]/a[1]")
	WebElement Bid_Now;
	
	
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
	
	public UserAuctionDetailPage clickonAcutionId()
	{
		Action.click(driver, auctionId);
		return new UserAuctionDetailPage();
	}
	
  
}

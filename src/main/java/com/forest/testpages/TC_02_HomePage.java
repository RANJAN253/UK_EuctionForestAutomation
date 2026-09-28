package com.forest.testpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.forest.actionclass.Action;
import com.forest.base.BaseClass;

public class TC_02_HomePage extends BaseClass
{
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navigation-menu']//li//a[@href='/UserDashBoard/UserCurrentAuction']")
	WebElement currentAuction;
	
	@FindBy(xpath="//div[@id='UserName']")
	WebElement lblUserName;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navigation-menu']//li//a[@href='/UserDashBoard/UserCurrentAuction']")
	WebElement CurrentAuction;
	
	
	public TC_02_HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateUsername()
	{
		String lblUser = lblUserName.getText();
		System.out.println("User Name :- " + lblUser);
		return Action.isDisplayed(driver, lblUserName);
	}
	
	public String getCurrentURL()
	{
		String homePageUrl = driver.getCurrentUrl();
		return homePageUrl;
	}
	
	  public TC_03_CurrentAuctionPage clickOnCurrectAuctionBtn() throws InterruptedException    {
	    	//Thread.sleep(2000);
	    	Action.click(driver, CurrentAuction);
	    	
	    	return new TC_03_CurrentAuctionPage();
	    }
	  
	 
}

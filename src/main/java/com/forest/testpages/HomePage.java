package com.forest.testpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.forest.actionclass.Action;
import com.forest.base.BaseClass;

public class HomePage extends BaseClass
{
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navigation-menu']//li//a[@href='/UserDashBoard/UserCurrentAuction']")
	WebElement currentAuction;
	
	@FindBy(xpath="//div[@class='col-sm-2']//center//a[@href='/UserDashBoard/UserCurrentAuction']")
	WebElement currentAuctionBtn;
		
	@FindBy(xpath="//div[@id='UserName']")
	WebElement lblUserName;
	
	public HomePage()
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
	
	  public CurrentAuctionPage clickOnCurrectAuctionBtn() throws InterruptedException    {
	    	
	    	Action.click(driver, currentAuction);
	    	
	    	return new CurrentAuctionPage();
	  }
}

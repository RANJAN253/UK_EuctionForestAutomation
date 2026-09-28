package com.forest.testpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.forest.actionclass.Action;
import com.forest.base.BaseClass;

public class AutoBidPage extends BaseClass
{
	@FindBy(xpath="//ul[@class='nav navbar-nav navigation-menu']//li//a[@href='/UserDashBoard/UserAutoBid']")
	WebElement AutoBidLnk;
	
	@FindBy(xpath="//select[@id='Auctions']")
	WebElement selectAuctionID;
	
	@FindBy(xpath="//select[@id='Lots']")
	WebElement selectLotNo;
	
	@FindBy(xpath="//select[@id='Range']")
	WebElement selectRange;	
	
	@FindBy(xpath="//input[@id='FromAmount']")
	WebElement fromAmt;
	
	@FindBy(xpath="//input[@id='ToAmount']")
	WebElement toAmt;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement saveBtn;
			
	public AutoBidPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAutoAuctionLnk()
	{
		Action.click(driver, AutoBidLnk);
	}
	
	public void selectAuctionId()
	{
		Action.selectByVisibleText(selectAuctionID, "T/D/3/30193/H - Bibiwala");
	}
	
	public void selectLot()
	{
		Action.selectByVisibleText(selectLotNo, "1030/NC/21-22");
	}
	
	public void selectRange()
	{
		Action.selectByVisibleText(selectRange, "500");
	}
	
	public void enterFromAmt(int num)
	{
		Action.type(fromAmt, ""+ num);
	}
	
	public void enterToAmt(int num)
	{
		Action.type(toAmt, ""+ num);
	}
	
	public void clickOnSave()
	{
		Action.click(driver, saveBtn);
	}
	
	
	
	
	
	
	

}

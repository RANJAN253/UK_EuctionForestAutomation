package com.forest.testpages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.forest.actionclass.Action;
import com.forest.base.BaseClass;

public class TC_04_UserAuctionDetailPage extends BaseClass
{	
	//@FindBy(xpath="//a[normalize-space()='T/D/3/30195/G']")
	//WebElement auctionId;
	
	//header[@id='topnav']
	@FindBy(xpath="//h3[@class='panel-title']")
	WebElement lotlistmsg;
	
	@FindBy(xpath="//input[@id='btnPost']")
	WebElement ForwordToBidBtn;
	
	@FindBy(xpath="//table[@id='tblAuctionDetail']")
	WebElement lotRow;
	
	@FindBy(xpath="//input[@id='checkedAll']")
	WebElement selectAllCheckbox;
		
	 public TC_04_UserAuctionDetailPage()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void selectCheckBox()	 {
		 selectAllCheckbox.click();
	 }
	 
	 public boolean validateForwardToBidBtn()	 {
		 return Action.isDisplayed(driver, ForwordToBidBtn);
	 }
	 
	 public TC_05_BidPage clickOnForward()	 {
		 Action.click(driver, ForwordToBidBtn);
		 return new TC_05_BidPage();
		 
		
	 }
}
package com.forest.testpages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.forest.actionclass.Action;
import com.forest.base.BaseClass;

public class IndexPage extends BaseClass
{
	@FindBy(xpath="//img[@src='/Images/UAFDClogo.jpg']")
	 WebElement erpLogo;
	
	@FindBy(xpath="//a[normalize-space()='|  Login |']")
	 WebElement linkLoginBtn;
	
	@FindBy(xpath="//ul[@class='menusl']//a[contains(text(),'वर्तमान नीलामी')]")
    WebElement currentauctionBtn;
    
    @FindBy(xpath="//a[normalize-space()='']")
    WebElement UpCommingAuction;
    
   //a[normalize-space()='T/D/3/30195/G']
    @FindBy(xpath="//a[normalize-space()='T/D/3/30195/G']")
     WebElement autionId;
    
    @FindBy(linkText="Bid Now")
     WebElement Bid_Now;
    
    @FindBy(xpath="//input[@id='EmailId']")
      WebElement txtEmail;
    
    @FindBy(xpath="//input[@id='Password']")
     WebElement txtPassword;
    
    @FindBy(xpath="//input[@name='btnSubmit']")
     WebElement btnSignIn;
    
    @FindBy(xpath="//a[normalize-space()='']")
    WebElement linkpartyRegister;
    
    @FindBy(css="li:nth-child(4) a:nth-child(1)")
    WebElement partyRegistraion;
    
    // Initialization the  page  objects
    public IndexPage() //constructor
    {
      PageFactory.initElements(driver, this);
    }  
    
    public TC_01_LoginPage clickOnLoginBtn ()    {
    	Action.click(driver, linkLoginBtn);
    	return new TC_01_LoginPage();
    }
    
    public boolean  validateLogo()    {
    	return Action.isDisplayed(driver, erpLogo); 
    }
    
    public void clickOnCurrentAuctionBtn() throws InterruptedException    {
    	Action.click(driver, currentauctionBtn);
    }
    
    public TC_04_UserAuctionDetailPage clickOnAuctionLinkId() throws Exception
    {
    	Action.click(driver, autionId);
    //	Action.JSClick(driver,autionId);
    	return new TC_04_UserAuctionDetailPage();
    }
    
       
    public void clickOnUpCommingAuction() {
    	Action.click(driver, UpCommingAuction);
    }
    
   // public void clickOnAuctionId() throws InterruptedException {
    //	Thread.sleep(1000);
   // 	Action.click(driver, autionId);
   // }
    
    public String getEAcutonTitle()    {
    	String myauctiontitle = driver.getTitle();
    	return myauctiontitle;
    }
    
    public void clickPartyRegistration() throws InterruptedException   {
    	Thread.sleep(1000);
    	Action.click(driver, partyRegistraion);
    	String CurrentUrl = driver.getCurrentUrl();
    	System.out.println(CurrentUrl);
    	String ActualUrl = "http://dev.ukfdceauction.in/User/IndividualRegistration";
    	Assert.assertEquals(ActualUrl, CurrentUrl);
    }
}
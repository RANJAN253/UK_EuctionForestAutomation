package com.forest.testpages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.forest.actionclass.Action;
import com.forest.base.BaseClass;

public class BidPage extends BaseClass
{
	@FindBy(xpath="//input[@id='btnSubmit']")
	WebElement btnSubmit;
	
	@FindBy(linkText="Bid Now")
    private WebElement Bid_Now;
	
	@FindBy(id="txtBidAmount")
	private WebElement txtBidAmt;
	 
	@FindBy(id="txtConfirmAmt")
	private WebElement txtConfirmAmt;
	
    @FindBy(linkText="Modify Bid")
    private WebElement Modify_Bid;
    
    @FindBy(xpath="//div[@id='txtHighestBidAmount']")
    WebElement highestbidamt;
    
    @FindBy(tagName="tr")
    WebElement bidlot;
    
    // Initialization the  page  objects
    public BidPage( ) 
    {
       PageFactory.initElements(driver, this);
    }    
    
    public void clickBidNow()     {
    	boolean enable = Bid_Now.isEnabled();
    	System.out.println("Bid Now Button Enabled" + enable);
    	
    	if (Bid_Now.isEnabled())  {
    		
    		Bid_Now.click();
    	}
    	else 
    	{
    		System.out.println("Element not found");
    	}
    }
    
    public void enterBidAmt(int num) throws InterruptedException    {
    	//txtBidAmt.sendKeys("" +num);
    	Action.type(txtBidAmt, ""+num);
    }
    
    public void enterConAmt(int num) throws InterruptedException   {
    	//txtConfirmAmt.sendKeys(""+num);
    	Action.type(txtConfirmAmt, ""+num);
    }
    
    public void clickOnSubmitBtn() throws InterruptedException   {
    	Action.click(driver, btnSubmit);
    }
    
    public void clickOnModifyBid()    {
    	Modify_Bid.click();
    }
    
    public void clearTextBox()    {
    	txtBidAmt.clear();
    	txtConfirmAmt.clear();
    }
    public void highestBidAmt()
    {
    	boolean hbid = highestbidamt.isDisplayed();
    	
    	System.out.println("Highest Bid Amt :-" +  hbid);
    }
    
}
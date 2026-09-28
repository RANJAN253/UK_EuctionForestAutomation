package com.forest.testpages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.forest.actionclass.Action;
import com.forest.base.BaseClass;

public class TC_01_LoginPage extends BaseClass {
		
	@FindBy(xpath="//a[normalize-space()='|  Login |']")
	 WebElement linkLoginBtn;
	
	@FindBy(xpath="//input[@id='EmailId']") 
    WebElement txtEmail;
    
    @FindBy(xpath="//input[@id='Password']")
    WebElement txtPassword;
    
    @FindBy(xpath="//input[@name='btnSubmit']")
    WebElement btnSignIn;
    
    @FindBy(xpath="//div[@id='UserName']")
    WebElement username;
    
    @FindBy(xpath="//a[@class='text-dark']")
    WebElement forgotPassword;
    
    @FindBy(xpath="//input[@id='txtUid']")
    WebElement txtEmailForgot;
    
    public TC_01_LoginPage() {
    	PageFactory.initElements(driver, this);
    }
    
    public TC_02_HomePage login(String uname, String pwd) throws InterruptedException {
        	
    	//Action.click(driver, linkLoginBtn);
    	Action.type(txtEmail, uname);
    	Action.type(txtPassword, pwd);
    	Thread.sleep(10000);
    	Action.click(driver, btnSignIn);
    	
    	Thread.sleep(2000);
    	return new TC_02_HomePage();
    }
	
    public void clickOnForgotPwd(String forgotEmail) {
    	Action.click(driver, forgotPassword);
    	Action.type(txtEmailForgot, forgotEmail);
    }
    
    public boolean validateUsername()
    {
    	String UserName = username.getText();
    	System.out.println("User Name :- " + UserName);
    	return Action.isDisplayed(driver, username);
    }


	
}
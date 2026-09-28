package com.forest.testpages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.forest.actionclass.Action;
import com.forest.base.BaseClass;

public class LoginPage extends BaseClass {
		
	 public LoginPage() {
	    	PageFactory.initElements(driver, this);
	    }
	  
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
    
    @FindBy(xpath="//img[@alt='user-img']")
    WebElement logoutImageBtn;
    
    @FindBy(xpath="//a[@id='btnLogOut']")
    WebElement logoutBtn;
    
   
    public HomePage login(String uname, String pwd) throws InterruptedException {
        	
    	//Action.click(driver, linkLoginBtn);
    	Action.type(txtEmail, uname);
    	Action.type(txtPassword, pwd);
    	Thread.sleep(10000);
    	Action.click(driver, btnSignIn);
    	
    	Thread.sleep(2000);
    	return new HomePage();
    }
	
    public void clickOnForgotPwd(String forgotEmail) {
    	Action.click(driver, forgotPassword);
    	Action.type(txtEmailForgot, forgotEmail);
    }
    
    public boolean validateUsername()    {
    	String UserName = username.getText();
    	System.out.println("User Name :- " + UserName);
    	return Action.isDisplayed(driver, username);
    }
    
    public void clickonLogoutImage()    {
    	logoutImageBtn.click();
    }
    
    public void clickOnLogout()
    {
    	logoutBtn.click();
    }


	
}
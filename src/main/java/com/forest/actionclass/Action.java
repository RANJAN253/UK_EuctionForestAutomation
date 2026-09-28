package com.forest.actionclass;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import com.forest.base.BaseClass;
public class Action extends BaseClass  {
	
	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele)	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public static void click(WebDriver ldriver, WebElement locatorName) 	{
		Actions act = new Actions(ldriver);
		act.moveToElement(locatorName).click().build().perform();
	}
	
	public static boolean findElement(WebDriver ldriver, WebElement ele){
		boolean flag = false;
		try	{
			ele.isDisplayed();
			flag = true;
		} catch(Exception e) {
			System.out.println("Location not found: "+ ele);
			flag = false;
		} finally  {
			if (flag) {
				System.out.println("Successfully found element at ");
			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}
	
	public static boolean isDisplayed(WebDriver ldriver, WebElement ele) {
		boolean flag = false;
		flag = findElement(ldriver, ele);
		if(flag)
		{
			flag = ele.isDisplayed();
			if(flag) 
			{
				System.out.println(" The element is Displayed ");
			} else 
			{
				System.out.println("The Element is not Displayed");
			}
			
		}else
		{
			System.out.println("Not displayed");
		}
		return flag;
	}
	
	public static boolean isSelected(WebDriver ldriver, WebElement ele)
	{
		boolean flag = false;
		flag = findElement(ldriver, ele);
		if(flag)
		{
			flag =  ele.isSelected();
			if(flag)
			{
				System.out.println("The Element is Selected");
			}
			else
			{
				System.out.println("The Element is not Selected");
			}
		}
		else
		{
			System.out.println("Not Selected");
		}
		return flag;		
	}
	
	public static boolean isEnabled(WebDriver ldriver, WebElement ele)
	{
		boolean flag = false;
		flag = findElement(ldriver, ele);
		if(flag)
		{
			flag =  ele.isEnabled();
			if(flag)
			{
				System.out.println("The Element is Enabled");
			}
			else
			{
				System.out.println("The Element is not Enabled");
			}
		}
		else
		{
			System.out.println("Not Enabled");
		}
		return flag;		
	}
	
	public static boolean type(WebElement ele, String text)
	{
		boolean flag = false;
		try
		{
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			//logger.info("Entered text: " +text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Locator Not found");
			flag = false;
		}finally {
			if(flag) {
				System.out.println("Successfully enter value");
			} else {
				System.out.println("unable to enter value");
			}
		}
		return flag;
	}
	
	public static boolean selectBySendKeys(WebElement ele, String value)
	{
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(flag) {
				System.out.println("Select value from the DropDown");
			} else {
				System.out.println("Not Select value from the dropdown");
				//throw  new ElementNotFoundException("","", "")
			}
		}
	}
	
	public static boolean selectByIndex(WebElement element, int index)
	{
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(flag) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option not selected by Index");
				//throw  new ElementNotFoundException("","", "")
			}
		}
	}
	
	public static boolean selectByValue(WebElement element, String value)
	{
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
				//throw  new ElementNotFoundException("","", "")
			}
		}
	}
	
	public static boolean selectByVisibleText(WebElement element, String visibletext)
	{
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}
	
	/*
	 * public static boolean mouseHoverByJavaScript(WebElement locator) { boolean
	 * flag = false; try { WebElement mo = locator; String javaScript ="var evObj" =
	 * document.createEvent('MouseEvent');
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript(javaScript, mo); flag = true; return true; } catch(Exception
	 * e) { return false; } finally { if(flag) {
	 * System.out.println("MouseOver Action is  performed"); } else {
	 * System.out.println("MouserOver Action is not performed"); } } }
	 */
	
	public static boolean JSClick(WebDriver driver, WebElement ele) throws Exception
	{
		boolean flag = false;
		try {
			//WEbElement  element  = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("argument[0].click;", ele);
			flag = true;
		}
		catch (Exception e) {
			throw e;
		} finally {
			if(flag) {
				System.out.println("Click Action is performed");
			} else if(!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}
	
	/*
	 * public static boolean switchToFrameByIndex(int index) { boolean flag = false;
	 * try { new WebDriverWait(drive,15).until(ExceptionConditions.visibility);
	 * driver.switchTo().frame(index); flag = true; return flag; } catch(Exception
	 * e) { return false; } finally { if(flag) {
	 * System.out.println("Frame with index \""+ index+ "\" is selected"); } else {
	 * System.out.println("Frame with index \""+ index+ "\" is not selected"); } } }
	 */
	
	public static boolean switchToFrameById(String idValue)
	{
		boolean flag = false;
		try
		{
			driver.switchTo().frame(idValue);
			flag = true;
			return flag;
		} catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		} finally {
			if(flag) {
				System.out.println("Frame with id \"" + idValue + "\" is Selected");
			}
			else
			{
				System.out.println("Frame with id \"" + idValue + "\" is not Selected");
			}
		}
	}
	
 	public static boolean switchToFrameByName(String nameValue)
	{
		boolean flag = false;
		try
		{
			driver.switchTo().frame(nameValue);
			flag = true;
			return flag;
		} catch (Exception e) 
		{
			//e.printStackTrace();
			return false;
		} finally {
			if(flag) {
				System.out.println("Frame with id \"" + nameValue + "\" is Selected");
			}
			else if(!flag)
			{
				System.out.println("Frame with id \"" + nameValue + "\" is not Selected");
			}
		}
	}
	
	public static boolean switchToDefaultFrame()
	{
		boolean flag = false;
		try
		{
			driver.switchTo().defaultContent();
			flag = true;
			return flag;
		} catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		} finally {
			if(flag) {
				//SuccessReport("SelectFrame", "Frame with name is selected");
			}
			else if(!flag)
			{
				//failureReport("SelectFrame", "Frame with name is not selected");
			}
		}
	}
	
	public static void mouseOverElement(WebElement element)
	{
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				System.out.println("Mouseover action is performed on");
			} else {
				System.out.println("Mouseover action is not performed on");
			}
		}
	}
	
	public static boolean moveToElement(WebDriver driver, WebElement ele)
	{
		boolean  flag = false;
		try {
			//WebElement element = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0],scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			//actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(ele).build().perform();
			flag = true;
			return true;
			}
		catch(Exception e)
		{
			return false;
		} finally {
			if(flag) {
				System.out.println("MouseOver Action is  performed");
			} else {
				System.out.println("MouserOver Action is not performed");
			}
		}
	}
	
	public static void implicitWait(WebDriver driver, int timeout)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void explicitWait(WebDriver driver, WebElement element, int timeOut)
	{
	//	WebDriverWait wait = new WebDriverWait(driver, timeOut);
		//wait.until(ExpectedConditions.visibilityOf(element));			
	}
	
	public static void pageLoadTimeOut(WebDriver driver, int timeout)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
	public static String screenShot(WebDriver driver, String filename)
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot =  (TakesScreenshot)driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + dateName + ".png" ;
		
		try
		{
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e)
		{
			e.getMessage();
		}
		
		//This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"	+ dateName + ".png";
		return newImageString;
		
	}
	
	public static String getCurrentTime()
	{
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
	
}

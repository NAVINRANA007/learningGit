package cssProject.TransactionBanking;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class libaryMethods {

	public static void mouseHoverAction(WebDriver driver,WebElement mainElement, String subElement)
	{

		Actions action = new Actions(driver);

		action.moveToElement(mainElement).perform();
		if(subElement.equals("Accessories"))
		{
			action.moveToElement(driver.findElement(By.linkText(subElement)));

			// System.out.print("Accessories link is found under Product Category");
		}


	}
	public static void waitForElement(WebDriver driver, WebElement element)
	{

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void SendTextMethod(WebDriver driver,String strObject,String inputuser) throws Exception
	{


		WebElement element=driver.findElement(By.xpath(strObject));

		element.clear();

		element.sendKeys(inputuser);
		element.sendKeys(Keys.TAB);

	}
	public void SendTextToWebElement(WebElement element,String inputuser) throws Exception
	{


		try {
			element.clear();

			element.sendKeys(inputuser);

			System.out.println("send key works fine!!");

			element.sendKeys(Keys.TAB);
		} catch (Exception e) 

		{
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println(e.getMessage());
		}

	}

	public void clickActionToWebElement(WebElement element) throws Exception
	{


		try
		{



			element.click();
			Thread.sleep(2000);
			System.out.println("webelent clickable");
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
	public void clickActionWithHighlight( WebDriver driver,WebElement element) throws Exception
	{


		try
		{


			highLightElement(driver, element);
			element.click();
			Thread.sleep(2000);
			System.out.println("webelent clickable");
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public void fileUploaderMethod(String uploadFilePath) throws Exception
	{
		try {
			Robot robot=new Robot();

			StringSelection strObjectPath=new StringSelection(uploadFilePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strObjectPath,null);
			robot.setAutoDelay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.setAutoDelay(2000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);


			Thread.sleep(2000);
			System.out.println("File uploaded sucessfully1 !!!");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}



	public String numberFromStringMethod(String inputValue)
	{

		String numberOnly= inputValue.replaceAll("[^0-9]", "");


		System.out.println(numberOnly);

		return numberOnly;
	}

	public static void  highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		String actualvalue= element.getCssValue("backgroundColor");
		System.out.println("colr vaalue is:"+actualvalue);
		for(int i=0;i<150;i++)
		{
			colordetails("rgb(0,200,0)", driver, element);
			colordetails(actualvalue, driver, element);

		}

	}
	public static void colordetails(String color,WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);

		try
		{
			Thread.sleep(400);
		}
		catch(Exception e )
		{
			System.out.println("blinkingk");
		}

		//	js.executeScript("arguments[0].setAttribute('style','border: solid 1px white');", element); 

	}








	public void locatorclickAction(WebDriver driver,String strObject) throws Exception
	{


		WebElement element=driver.findElement(By.xpath(strObject));
		Thread.sleep(2000);

		element.click();

	}


	public void selectDropDown(WebDriver driver,String strObject,String DropDownValue) throws Exception
	{


		WebElement element=driver.findElement(By.xpath(strObject));
		Thread.sleep(2000);
		// highLighter.highLightElement(driver, element);

		Select selectDropDownMenu=new Select(element);


		try
		{
			int abc=Integer.parseInt(DropDownValue);

			selectDropDownMenu.selectByIndex(abc);
		}
		catch (Exception e) 
		{


			selectDropDownMenu.selectByValue(DropDownValue);
		}

	}
	public void  clickonElementWithActionMethod(WebDriver driver,String Object) throws InterruptedException
	{

		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(Object));
		actions.moveToElement(mainMenu);
		Thread.sleep(2000);
		actions.click().build().perform();
	}


}

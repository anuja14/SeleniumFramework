package framework;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class fbautomation {
   public static String result= "fail";
   public static WebDriver driver=null;
   /**
    * This function uses the getmethod function of java.lang.class will invoke the functions of these class run time based n the passed parameters
    * @param functionname
    * @param param1
    * @param param2
    * @param param3
    * @throws IllegalAccessException
    * @throws IllegalArgumentException
    * @throws InvocationTargetException
    * @throws NoSuchMethodException
    * @throws SecurityException
    */
	public static void callmethod(String functionname , String param1 , String param2 , String param3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	
	{
		Method method= fbautomation.class.getMethod(functionname , String.class, String.class, String.class);
		method.invoke(functionname, param1,param2,param3);
		
	}
	
	/**
	 * This method is used to launch the URL
	 * @param browser
	 * @param path
	 * @param url
	 */
	public static void InvokeApp(String browser, String path , String url)
	{	
	  try
	  {
		switch (browser){
		case "ie":
			System.setProperty("webdriver.ie.driver", path);
			 driver = new InternetExplorerDriver();
			 break;
		case "chrome":	
			System.setProperty("webdriver.chrome.driver", path);
			 driver = new ChromeDriver();
			 break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		TakeScreenshot.screenshots(driver);
		result="True";
	  }	
	  
	  catch(Exception e){
		  System.out.println(e.getStackTrace());
	  }
	}
	
	/**
	 * This function print number and name of radio buttons present and select one
	 * @param radiobuttonname
	 * @param param2
	 * @param param3
	 */
	public static  void selectRadio(String radiobuttonname,String param2, String param3)
	{
	   try
	   {
			List<WebElement> buttons  =driver.findElements(By.xpath(".//div[@class='control-group']//following::input[@name='sex']"));
			System.out.println(buttons.size());
			for(int i=0 ; i<buttons.size();i++)
			{
				System.out.println("button name are :"+buttons.get(i).getAttribute("value"));
				if((buttons.get(i).getAttribute("value")).matches(radiobuttonname))
				{
					buttons.get(i).click();
				}
			}
			result="True";
			TakeScreenshot.screenshots(driver);
		}
	    catch(Exception e)
	   {
	    	System.out.println(e.getStackTrace());
	   }
	} 	
	
	/**
	 * This function is used to click the link(based on partial link text and link text)
	 * @param param1
	 * @param param2
	 * @param param3
	 */
	public static void  ClickonLink(String param1 , String param2, String param3)
	{
		try
		
		{
			driver .findElement(By.partialLinkText("Link Test")).click();
			driver.findElement(By.linkText("Link Test")).click();
			result="True";
			
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
	}
}

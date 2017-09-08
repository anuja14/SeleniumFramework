package framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
    /**
     * This function takes screenshot in the specified date time format
     * @param driver
     * @throws IOException
     */
	public  static void screenshots ( WebDriver driver) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String path = "C:\\Users\\anuja\\Selenium\\screenshot"+ timeStamp+".png" ;
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path));
	}
}

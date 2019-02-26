package cssProject.TransactionBanking;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HarnessFile {

	Properties properties=new Properties();
	WebDriver driver;

	// Browser Launch 


	public void setUp() throws Exception
	{
		properties.load(new FileReader(new File("test.properties")));

		System.setProperty("webdriver.chrome.driver", properties.getProperty("driverPath"));

		driver = new ChromeDriver();

	}

	public void testSendEmail() throws Exception
	{
		//Login to Flipkart


		driver.get(properties.getProperty("URL"));

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



	}


}

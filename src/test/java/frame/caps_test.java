package frame;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class caps_test extends dcc{

	AndroidDriver<AndroidElement> driver; 
	
@BeforeTest
public void setup() throws Exception
{
	driver=capsi(deviceName, platformName, appPackage, appActivity);
Thread.sleep(5000);
}


@Test
public void Test1() throws Exception
{	
System.out.println("Awesome!!");
Thread.sleep(4000);
driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
// Anguilla
Thread.sleep(4000);
driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"))");
Thread.sleep(3000);
// Anguilla
driver.findElement(MobileBy.xpath("//*[@text='Belgium']")).click();
Thread.sleep(3000);
driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("john doe");
Thread.sleep(3000);
driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

}


	
}

package frame;

import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class dcc {
	public static String deviceName;
	public static String platformName;
	public static String appPackage;
	public static String appActivity;
	
	
	public  static void start_Emulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"//src//main//resources//extension.bat");
		Thread.sleep(7000);
	}
	
	
	public static   AndroidDriver<AndroidElement> capsi(String deviceName,String platformName,String appPackage,String appActivity) throws IOException, InterruptedException
	{
		FileReader fr=new FileReader(System.getProperty("user.dir")+"//src//main//java//golbal.properties");
		
		Properties pi=new Properties();
		pi.load(fr);
		deviceName=pi.getProperty("deviceName");
		platformName=pi.getProperty("platformName");
		appPackage=pi.getProperty("appPackage");
		appActivity=pi.getProperty("appActivity");
		
		if(deviceName.equals("icarus"))
		{
			start_Emulator();
		}
		
		DesiredCapabilities dc = new DesiredCapabilities();
	    dc.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
	    dc.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
	    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,appPackage);
	    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appActivity);
	    dc.setCapability(MobileCapabilityType.NO_RESET, false);
	    // automation name for android is android ui automator (in built feature of android used to find the element)        
	    dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
	    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
	    return driver;
		
		
	}
	
	
	
}

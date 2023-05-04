package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Caluctortest {
	
	static AppiumDriver<MobileElement> driver;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			openCalculator();
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			System.out.println("error");
		}
	}
		
		public static void openCalculator() throws MalformedURLException {
			DesiredCapabilities cap = new DesiredCapabilities();
		  cap.setCapability("deviceName","SM-G950W");
		  cap.setCapability("udid","98896a314b34524745");
		  cap.setCapability("platformName","Android");
		  cap.setCapability("platformVersion","9");
		  cap.setCapability("appPackage","com.sec.android.app.popupcalculator");
		  cap.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
	      driver= new AppiumDriver<MobileElement>(url,cap);
		   System.out.println("Application started");
		   MobileElement a=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_07"));
		   MobileElement b=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_03"));
		   MobileElement c=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add"));
		   MobileElement d=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
		   a.click();
		   c.click();
		   b.click();
		  
		   d.click();
		 
		   MobileElement RE=driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Champ de saisie de la calculatrice\"]"));
		   System.out.println(RE.getText());
		}}
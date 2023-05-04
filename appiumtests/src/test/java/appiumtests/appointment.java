package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class appointment {
static AppiumDriver<MobileElement> driver;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			openskin();
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			System.out.println("error");
		}
		
	}
		
		public static void openskin() throws MalformedURLException, InterruptedException {
			DesiredCapabilities cap = new DesiredCapabilities();
		  cap.setCapability("deviceName","sdk_gphone64_x86_64");
		  cap.setCapability("udid","emulator-5554");
		  cap.setCapability("platformName","Android");
		  cap.setCapability("platformVersion","12");
		  cap.setCapability("appPackage","tavie.patient.skin.pre.v3.test");
		  cap.setCapability("appActivity","com.medlink.mehdi.tavie.SplashScreen");
		  cap.setCapability("adbExecTimeout","30000");
		  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
	      driver= new AppiumDriver<MobileElement>(url,cap);
		   System.out.println("Application started");
		   Thread.sleep(5000);
		   //select French country 
		 MobileElement SkinFR=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"));
		 SkinFR.click();
		 
		   
		   driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		  //select country :click on done button 
		 MobileElement Continue1=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continueButton"));
		 Continue1.click();
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS); 
		 //select language :click on done button 
		 MobileElement Continue2=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continueButton"));
		 Continue2.click();
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS); 
		 //select center :click on done button 
		 MobileElement Done=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continueButton"));
		 Done.click();
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 //welcome to tavie:click on create account button 
		 MobileElement CreateAccount=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/action1"));
		 CreateAccount.click();
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 //Click on activation code button
		 MobileElement accountTextField=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/code_activation"));
		 accountTextField.click();
		 /// Enter the activation code 
		 accountTextField.sendKeys("vival360");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		//hide the keybord
		driver.hideKeyboard();
		//Click on check button
	    driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/check_btn")).click();
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);	
	
		
		Thread.sleep(5000);
		//element.click();
		Dimension dimension  = driver.manage().window().getSize();
		int start_x = (int) (dimension.width * 0.5);
		int start_y =(int) (dimension.height);
		int end_x  = (int) (dimension.width * 0.5);
		int end_y=(int) (dimension.height * 0.1);

		System.out.println(dimension.width);
		System.out.println(dimension.height);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		 TouchAction touch = new TouchAction(driver);
		//touch.press(PointOption.point(start_x,start_y));
		 for(int i=0;i<34;i++)
		 {
			 touch.press(PointOption.point(start_x,start_y));  
		 //touch.press(PointOption.point(850,2176));
		touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));	
		touch.moveTo(PointOption.point(end_x,end_y)).release().perform();
		//touch.moveTo(PointOption.point(850,230)).release().perform();
		 }


	
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_agree_1")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continue_btn_terms")).click();
				//WebElement myLocator = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")); 
			
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		  

		for(int r=0;r<32;r++)
		{
		touch.press(PointOption.point(start_x,start_y));  	
		///touch.press(PointOption.point(850,2176));
		touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));	
		//touch.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3)));	
		touch.moveTo(PointOption.point(end_x,end_y)).release().perform();
		//touch.moveTo(PointOption.point(850,230)).release().perform();
		}		 
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_agree_1")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_agree_2")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continue_btn_terms")).click();		    
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);	
		//select female gender
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/female_btn")).click();
		//click to select the age
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/age_range")).click();	      
		//driver.findElements(By.id("tavie.patient.skin.pre.v3.test:id/rv_age_range")).get(1).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continue_btn")).click();




		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/addMedication")).click();
		// add braftovi 
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]")).click();

		//open the frequency pop-up 
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_add_med_frequency")).click();
		//select daily frequency
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_dialog_add_med_daily")).click();
		// add 2 doses
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/iv_item_dose_add")).click();
		//scroll to select the time dose
		touch.press(PointOption.point(start_x,start_y));  	
		touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));	
		touch.moveTo(PointOption.point(end_x,end_y)).release().perform();
		//open the time pop-up
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/rl_item_dose_time")).click();
		//select the current time click done 
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_add_med_add")).click();
		//Click on done button 
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_add_med_add")).click();
		//understand braftovi pop-up
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_undestood")).click();
		//done button of select medication interface
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/done")).click();
		// done button of review medication interface
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/doneButton")).click();
		//wait loading account 
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);	 
	    //the tutorial
		/// welcome to tavie skin
		MobileElement tuto= driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/info_layout"));
		tuto.findElement(By.id("tavie.patient.skin.pre.v3.test:id/skip_button")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);	
      
		//dashboard
		MobileElement tabbar=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tab_dashboard"));
		tabbar.findElement(By.id("tavie.patient.skin.pre.v3.test:id/bb_bottom_bar_icon")).click();
		//Navigate to appointment 

		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")).click(); 
	    //click on continue button 
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/buttonHolder")).click();
		//click on close button
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView")).click();
	        
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}

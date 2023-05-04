package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class skin {
	
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
			 cap.setCapability("deviceName","SM-G950W");
		  cap.setCapability("udid","98896a314b34524745");
		  cap.setCapability("platformName","Android");
		  cap.setCapability("platformVersion","9");
		  cap.setCapability("appPackage","tavie.patient.skin.pre.v3.test");
		  cap.setCapability("appActivity","com.medlink.mehdi.tavie.SplashScreen");
		  cap.setCapability("adbExecTimeout","30000");
		  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
	      driver= new AppiumDriver<MobileElement>(url,cap);
		   System.out.println("Application started");
		   Thread.sleep(1000);
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
		MobileElement CHECK =driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]"));
		CHECK.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);	
		String text2="Les présentes Conditions d’Utilisation constituent l’intégralité de l’accord entre l’utilisateur et MedClinik. Le fait que nous n’exercions pas ou n’appliquions pas un droit ou une disposition des présentes Conditions d’Utilisation ne constitue pas une renonciation à ce droit ou à cette disposition. Si une disposition des présentes Conditions d’Utilisation est jugée illégale, nulle ou inapplicable, cette disposition ou une partie de la disposition est réputée séparable des présentes Conditions d’Utilisation et n’affecte pas la validité et l’applicabilité des autres dispositions.";
	    String id ="tavie.patient.skin.pre.v3.test:id/ll_agree_1";
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);	
	   
	   // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().description(\""+text2+"\")).scrollForward()"));
  //MobileElement scrolling = (MobileElement) driver.findElement(

     // MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" +

        ///    "new UiSelector().description(\"text2\"));")); 

    //System.out.println(scrolling.getLocation());
   //System.out.print(scrolling.getText()) ;
   driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);   
  //scrolling.click();

	    //tavie.patient.skin.pre.v3.test:id/bottom_view
	    //MobileElement el = (MobileElement) driver
	    	    //.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("
	    	      //+ "new UiSelector().scrollable(true)).scrollIntoView("                      
	    	       //+ "new UiSelector().textContains(\"ou MedClinik par courrier à l’attention du responsable du programme TAVIE Skin de MedClinik SAS à l’adresse suivante:\"));"));
	    	//el.click();
	  String Text =" ou MedClinik par courrier à l’attention du responsable du programme TAVIE Skin de MedClinik SAS à l’adresse suivante:";
  String parentScrollViewId= "android.widget.ScrollView";
		  //"android.widget.ScrollView";
 //// tavie.patient.skin.pre.v3.test:id/bottomsheet
		  //"android.widget.ScrollView";
		  //"tavie.patient.skin.pre.v3.test:id/main_content";
		  //"tavie.patient.skin.pre.v3.test:id/container";
		  //"tavie.patient.skin.pre.v3.test:id/Frame_Layout_main";
		  //"tavie.patient.skin.pre.v3.test:id/webViewHolder";
  //tavie.patient.skin.pre.v3.test:id/webViewHolder
  //
//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().class(\""+parentScrollViewId+"\")).scrollForward()"));   
 
 ///driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("
     //// + "new UiSelector().className(\"parentScrollViewId\")).scrollIntoView("                      
      /// + "new UiSelector().text(\"Text\"));"));

  //MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
	    //    "new UiScrollable(new UiSelector())" +
	       //  ".scrollIntoView(new UiSelector().resourceId(\"tavie.patient.skin.pre.v3.test:id/container\"))")); 
		
		///element.click();
//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollabl(new UiSelector().className("android.widget.Spinner").childSelector(new UiSelector().className("android.widget.EditText").index(0))"));
  MobileElement webview=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/webViewHolder"));
//List<MobileElement> listt=webview.findElements(By.className("android.widget.TextView"));
//for(MobileElement e: listt)
	//System.out.println(e.getAttribute("text"));
//MobileElement element = (MobileElement) webview.findElement(MobileBy.AndroidUIAutomator(
//  "new UiScrollable(new UiSelector())" +
//  ".scrollIntoView(new UiSelector().text(\"text2\"))")); 
Thread.sleep(1000);
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


List<MobileElement> listt1=webview.findElements(By.className("android.widget.TextView"));
for(MobileElement e: listt1)
	System.out.println(e.getAttribute("text"));	
	
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
driver.closeApp();



}


}

		              
	
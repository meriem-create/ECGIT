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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class emulator {

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
		cap.setCapability("deviceName", "sdk_gphone64_x86_64");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("appPackage", "tavie.patient.skin.pre.v3.test");
		cap.setCapability("appActivity", "com.medlink.mehdi.tavie.SplashScreen");
		cap.setCapability("adbExecTimeout", "30000");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println("Application started");
		Thread.sleep(4000);

		/// select the country
		String country = "France";
		// "Deutschland","Portugal","Luxembourg","Italy","Spain","België","France",,
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + country + "\")")).click();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		// select country interface :click on done button
		MobileElement Continue1 = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continueButton"));
		Continue1.click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// select language :click on done button
		MobileElement Continue2 = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continueButton"));
		Continue2.click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// select center :click on done button

		MobileElement Done = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continueButton"));

		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOf(Done));
		Done.click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// welcome to tavie:click on create account button
		MobileElement CreateAccount = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/action1"));
		CreateAccount.click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// Click on activation code button
		MobileElement accountTextField = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/code_activation"));
		accountTextField.click();
		/// Enter the activation code
		accountTextField.sendKeys("vival360");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// hide the keybord
		driver.hideKeyboard();
		// Click on check button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/check_btn")).click();

		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);

		Thread.sleep(1000);
		// element.click();
		Dimension dimension = driver.manage().window().getSize();
		int start_x = (int) (dimension.width * 0.5);
		int start_y = (int) (dimension.height);
		int end_x = (int) (dimension.width * 0.5);
		int end_y = (int) (dimension.height * 0.1);

		System.out.println(dimension.width);
		System.out.println(dimension.height);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		TouchAction touch = new TouchAction(driver);
		// touch.press(PointOption.point(start_x,start_y));
		for (int i = 0; i < 35; i++) {
			touch.press(PointOption.point(start_x, start_y));
			// touch.press(PointOption.point(850,2176));
			touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
			touch.moveTo(PointOption.point(end_x, end_y)).release().perform();
			// touch.moveTo(PointOption.point(850,230)).release().perform();
		}

		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_agree_1")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continue_btn_terms")).click();
		// WebElement myLocator =
		// driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		for (int r = 0; r < 32; r++) {
			touch.press(PointOption.point(start_x, start_y));
			/// touch.press(PointOption.point(850,2176));
			touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
			// touch.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3)));
			touch.moveTo(PointOption.point(end_x, end_y)).release().perform();
			// touch.moveTo(PointOption.point(850,230)).release().perform();
		}
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_agree_1")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_agree_2")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continue_btn_terms")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// select female gender
		String gender = "HOMME";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + gender + "\")")).click();
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/female_btn")).click();
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/male_btn")).click();
		// click to select the age
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/age_range")).click();
		// driver.findElements(By.id("tavie.patient.skin.pre.v3.test:id/rv_age_range")).get(1).click();
		// driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")).click();
		String age = "75 ans et plus";
		/// "45 à 64","65 à 74","75 ans et plus","18 à 44"
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + age + "\")")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/continue_btn")).click();

		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/addMedication")).click();
		// add braftovi
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"))
				.click();

		// open the frequency pop-up
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_add_med_frequency")).click();
		// select daily frequency
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_dialog_add_med_daily")).click();
		// add 2 doses
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/iv_item_dose_add")).click();
		// scroll to select the time dose

		touch.press(PointOption.point(start_x, start_y));
		touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		touch.moveTo(PointOption.point(end_x, end_y)).release().perform();
		// open the time pop-up
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/rl_item_dose_time")).click();
		// select the current time click done
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_add_med_add")).click();
		// Click on done button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_add_med_add")).click();
		// understand braftovi pop-up
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_undestood")).click();
		// done button of select medication interface
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/done")).click();
		// done button of review medication interface
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/doneButton")).click();
		// wait loading account
		// driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		WebDriverWait wait1 = new WebDriverWait(driver, 3000);
		MobileElement skip = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/skip_button"));
		wait1.until(ExpectedConditions.visibilityOf(skip));
		skip.click();
		// the tutorial
		/// welcome to tavie skin
		// MobileElement tuto=
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tutorial_body"));
		// MobileElement
		// tuto1=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout[3]"));
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/skip_button")).click();
		// driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// my feed
		/// MobileElement
		// t1=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tutorial_body"));
		/// MobileElement
		// feed=t1.findElement(By.id("tavie.patient.skin.pre.v3.test:id/next_button"));
		/// MobileElement
		// fd=feed.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout[3]"));
		/// MobileElement
		// next=fd.findElement(By.id("tavie.patient.skin.pre.v3.test:id/next_button"));
		/// WebDriverWait wait1 = new WebDriverWait(driver,2000);
		/// wait1.until(ExpectedConditions.visibilityOf(next));
		/// next.click();

		// environment
		// MobileElement
		// title=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tutorial_title_layout"));
		/////// System.out.println(title.getText());
		//// MobileElement
		// environment=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/next_button"));
		// WebDriverWait wait = new WebDriverWait(driver,1000);
		/// wait.until(ExpectedConditions.visibilityOf(environment));
		/// environment.click();

		// coaching
		// MobileElement
		// title=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tutorial_title_layout"));
		/// System.out.println(title.getText());
		//// MobileElement
		// coaching=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/next_button"));
		// WebDriverWait wait = new WebDriverWait(driver,1000);
		//// wait.until(ExpectedConditions.visibilityOf(coaching));
		/// coaching.click();

		// dictionary
		// MobileElement
		// title=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tutorial_title_layout"));
		///////////// System.out.println(title.getText());
		/// MobileElement dictionary
		// =driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/next_button"));
		// WebDriverWait wait = new WebDriverWait(driver,1000);
		/// wait.until(ExpectedConditions.visibilityOf(dictionary ));
		//// dictionary .click();
		// maps
		// MobileElement
		// title=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tutorial_title_layout"));
		//// System.out.println(title.getText());
		/// MobileElement
		// maps=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/next_button"));
		// WebDriverWait wait = new WebDriverWait(driver,1000);
		/// wait.until(ExpectedConditions.visibilityOf(maps ));
		/// maps .click();

//navigate to the dashboard:
		touch.press(PointOption.point(start_x, start_y));
		/// touch.press(PointOption.point(850,2176));
		touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3)));
		touch.moveTo(PointOption.point(end_x, end_y)).release().perform();

		MobileElement dashboard = driver
				.findElement(By.id("tavie.patient.skin.pre.v3.test:id/bb_bottom_bar_item_container"));
		MobileElement dashboard1 = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tab_dashboard"));

		dashboard1.findElement(By.className("android.widget.ImageView")).click();
		// navigate to appointment
		String appointement = "Mon Parcours de Soins";

		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + appointement + "\")")).click();
		/// Click on continue
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/buttonHolder")).click();

		// close the help pop-up
		MobileElement up = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]"));

		up.findElement(By.className("android.widget.ImageView")).click();
		// open add new appointment interface( add non medical appointment)
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/start")).click();
		// app title
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/et_appointment_title")).sendKeys("appointment1");
		// app location
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/et_appointment_location")).sendKeys("France");
		// app date and time
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/rl_appointment_date_time")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_dialog_appointment_time_done")).click();
		/// click on done button
		String donn = "Terminé";

		MobileElement elem = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ donn + "\").instance(0))")));

		// driver.findElementByAndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textContains(\""+donn+"\").instance(0))");
		elem.click();

		// touch.press(PointOption.point(start_x,start_y));
		/// touch.press(PointOption.point(850,2176));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3)));
		// touch.moveTo(PointOption.point(end_x,end_y)).release().perform();
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_appointment_done")).click();
		// add medical appointment

		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/addHolder")).click();

		// app title
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/et_appointment_title")).sendKeys("appointment2");
		// app location
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/et_appointment_location")).sendKeys("France");
		// app date and time
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/rl_appointment_date_time")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_dialog_appointment_time_done")).click();

		/// choose medical appointment
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_add_appointment_category_pso_yes")).click();

		// with whom field
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/et_appointment_with_whom")).sendKeys("Doctor1");
		/// swipe
		String id1 = "tavie.patient.skin.pre.v3.test:id/rl_add_appointment_getting_prepared";
		MobileElement elem1 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id1 + "\").instance(0))")));
		elem1.click();

		// touch.press(PointOption.point(start_x,start_y));
		/// touch.press(PointOption.point(850,2176));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3)));
		// touch.moveTo(PointOption.point(end_x,end_y)).release().perform();
		// click to open checklist list
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/rl_add_appointment_getting_prepared")).click();

		/// choose a checklist
		String checklist = "Consulter un nouvel oncologue";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + checklist + "\")")).click();

		// click on Understood button of dismlair checklist

		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_undestood")).click();

		// reply to question 1:
		String optionq1 = "Plus de dialogue";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + optionq1 + "\")")).click();

		// reply to question 2:
		String optionq2 = "Oui";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + optionq2 + "\")")).click();
		// swipe to show the next questions
		// touch.press(PointOption.point(850,2176));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.moveTo(PointOption.point(850,600)).release().perform();
		// String optionq6="Je n'en ai pas.";
		// MobileElement elem2= (MobileElement) driver.findElement(
		// MobileBy.AndroidUIAutomator(
		// ("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().text(\""+optionq6+"\").instance(0))")));
		// elem2.getText();

		// reply to question 3:
		// String optionq3="Fait";
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+optionq3+"\")")).click();

		// reply to question 4:
		// String optionq4="Oui";
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+optionq4+"\")")).click();

		// reply to question 5:
		// String optionq5="Pas encore";
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+optionq5+"\")")).click();

		// swipe to show until the next end
		// touch.press(PointOption.point(850,2176));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.moveTo(PointOption.point(850,600)).release().perform();
		//
		// MobileElement donebut =
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_checklist_done"));
		String donebut = "Enregistrer";
		MobileElement elem3 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ donebut + "\").instance(0))")));
		// elem3.getText();
		elem3.click();

		// reply to question 6:
		// String optionq6="Je n'en ai pas.";
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+optionq6+"\")")).click();

		// reply to question 7:
		// String optionq7="Oui";
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+optionq7+"\")")).click();

		// enter text question8
		// String freetext="Écrivez vos notes ici";
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+freetext+"\")")).sendKeys("test");
		// click on done button

		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_checklist_done")).click();

		// set the appointment as reccurent
		String id2 = "tavie.patient.skin.pre.v3.test:id/sw_appointment_recurring";
		MobileElement elem4 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id2 + "\").instance(0))")));
		elem4.click();

		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/sw_appointment_recurring")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_appointment_frequency")).click();
		// select daily app

		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_dialog_appointment_frequency_daily")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_dialog_appointment_frequency_done")).click();

// swipe
		// touch.press(PointOption.point(850,2176));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.moveTo(PointOption.point(850,600)).release().perform();
		// click on donr button

		String id3 = "tavie.patient.skin.pre.v3.test:id/btn_appointment_done";
		MobileElement elem5 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id3 + "\").instance(0))")));

		elem5.click();

		// swipe left

		// touch.press(PointOption.point(800,1200));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
		// touch.moveTo(PointOption.point(100,1200)).release().perform();

		// touch.press(PointOption.point(start_x,start_y));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.moveTo(PointOption.point(end_x,end_y)).release().perform();

		// open calendar
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// WebDriverWait wait3 = new WebDriverWait(driver,5000);
		String id6 = "tavie.patient.skin.pre.v3.test:id/ll_open_appointment";
		// String openapp="Ouvrir le rapport de consultation";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches(\"" + id6 + "\")")).click();

		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+id6+"\")")).click();
		// MobileElement
		// openap=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_open_appointment"));
		// wait3.until(ExpectedConditions.visibilityOf(openap));
		// openap.click();
		// the tutorial
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_open_appointment")).click();
		// click on open pv report
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_open_open_report")).click();
		String pvreport = "Ouvrir le rapport de consultation";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + pvreport + "\")")).click();

		// click on understood button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_undestood")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// scroll until the end
		// touch.press(PointOption.point(start_x,start_y));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.moveTo(PointOption.point(end_x,end_y)).release().perform();
		String id7 = "tavie.patient.skin.pre.v3.test:id/rv_medications";
		// String openapp="Ouvrir le rapport de consultation";
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().resourceIdMatches(\""+id7+"\")")).click();
		MobileElement elem6 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id7 + "\").instance(0))")));

		elem6.click();

		// driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// click on arrow icon medication management
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/nextButton2")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// click on arrow icon of health profile
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/nextButton2")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// click on arrow icon of symptoms
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/nextButton2")).click();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
		// click on close button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/close_layout_bar")).click();
		// click on back button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/backButton")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		// scroll down
		String text1 = "Profil de santé";
		MobileElement elem7 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ text1 + "\").instance(0))")));

		elem7.click();

		// touch.press(PointOption.point(start_x,start_y));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.moveTo(PointOption.point(end_x,end_y)).release().perform();
		// open health profile interface
		// String openbutton="Ouvrir";
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+openbutton+"\")")).click();

		// open hcp interface
		String openbutton1 = "Ajouter";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + openbutton1 + "\")")).click();
		// add pathology name
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/nameEditText")).sendKeys("Pathology1");
		// select color
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/iv_add_hcp_green")).click();
		// select diagnostic date
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/dateTextView")).click();
		String month = "Avril";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + month + "\")")).click();
		String year = "2019";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + year + "\")")).click();
		String donebutton = "Terminé";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + donebutton + "\")")).click();
		// click on add medication
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/addMedicationPathologie")).click();
		// click on check button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/radioButton")).click();
		String donebutton1 = "Terminé";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + donebutton1 + "\")")).click();
		// add hcp
		String addhcp = "Ajouter un nouveau PDS";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + addhcp + "\")")).click();
		// add doctor name
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/et_dr_name")).sendKeys("doctor1");
		// add location
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/autocomplete_fragment")).sendKeys("Aer");
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/autocomplete_fragment")).click();
		// driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		// ( (AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

		// add speciality
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/et_specialty")).sendKeys("Melanoma");
		// add telephone number
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/et_phone_number")).sendKeys("1122334455667788");
		// select color
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/iv_add_hcp_blue")).click();

		// click on done button
		String donebutton2 = "Terminé";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + donebutton2 + "\")")).click();
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebDriverWait wait2 = new WebDriverWait(driver, 3000);
		MobileElement check = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/crisis_menu"));
		wait2.until(ExpectedConditions.visibilityOf(check));
		check.click();
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/crisis_menu")).click();
		// click on check button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/radioButton")).click();
		// click on done button
		String donebutton3 = "Terminé";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + donebutton3 + "\")")).click();
		// scroll
		String id8 = "tavie.patient.skin.pre.v3.test:id/done";
		MobileElement elem8 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id8 + "\").instance(0))")));

		elem8.click();

		// touch.press(PointOption.point(start_x,start_y));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.moveTo(PointOption.point(end_x,end_y)).release().perform();
		// click on done button
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/done")).click();
		// click on check button the pop-up "you add"
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/crisis_menu")).click();

		// click on back button of health profile
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/back")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		// click on back button of Mon parcours de soins
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/back")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		// navigate to Medication Managment interface
		String treatment = "Gestion du traitement";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + treatment + "\")")).click();
		/// Click on continue
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/buttonHolder")).click();
		// medication goals
		// String goal1="Mieux dormir";
		// String goal2="Ne pas avoir peur que la maladie évolue";
		// String goal3="Je viens d'avoir mon diagnostic";
		// String goal4="Reprendre mes loisirs";
		// String goal5="Reprendre mon activité professionnelle";
		// String goal6="Se sentir moins déprimé(e)";

		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+goal1+"\")")).click();
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+goal2+"\")")).click();
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+goal3+"\")")).click();
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+goal4+"\")")).click();
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+goal5+"\")")).click();
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().text(\""+goal6+"\")")).click();

		MobileElement el1 = driver.findElement(By.className("androidx.recyclerview.widget.RecyclerView"));
		List el2 = el1.findElements(By.className("android.view.ViewGroup"));
		System.out.println(el2.size());
		((MobileElement) el2.get(0)).click();
		((MobileElement) el2.get(1)).click();
		((MobileElement) el2.get(2)).click();
		((MobileElement) el2.get(3)).click();
		((MobileElement) el2.get(4)).click();
		((MobileElement) el2.get(5)).click();
		// click on done button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/done")).click();

		// close the help pop-up
		MobileElement upp = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]"));

		upp.findElement(By.className("android.widget.ImageView")).click();

		// click on upcoming medication

		String text2 = "Voir plus";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + text2 + "\")")).click();
		// navigate to updates interface
		String text3 = "MISES À JOUR";
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().resourceIdMatches(\""+id10+"\")")).click();
		// ((WebElement) driver.findElementsByAccessibilityId(id10)).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + text3 + "\")")).click();
		// click on back button

		String id11 = "tavie.patient.skin.pre.v3.test:id/backButton";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches(\"" + id11 + "\")")).click();
		// add new medicaton (cotelic)
		// Ajouter
		String text4 = "Ajouter";
		MobileElement elem9 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ text4 + "\").instance(0))")));

		elem9.click();

		// List medication_list=
		// driver.findElements(By.className("androidx.recyclerview.widget.RecyclerView"));

		// System.out.println(medication_list.size()) ;
		// ((MobileElement) medication_list.get(2)).click();

		String text5 = "Cotellic";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + text5 + "\")")).click();

		// open the frequency pop-up
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_add_med_frequency")).click();
		// select daily frequency
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_dialog_add_med_daily")).click();

		// scroll to select the time dose

		// touch.press(PointOption.point(start_x,start_y));
		// touch.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
		// touch.moveTo(PointOption.point(end_x,end_y)).release().perform();
		// open the time pop-up
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/rl_item_dose_time")).click();
		// select the current time click done
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/done")).click();
		String id12 = "tavie.patient.skin.pre.v3.test:id/btn_add_med_add";
		MobileElement elem10 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id12 + "\").instance(0))")));

		elem10.click();
		// Click on done button
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_add_med_add")).click();
		// understand cottelic pop-up
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_undestood")).click();
		// done button of select medication interface
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/done")).click();

		// update medication
		/// open the review medication interface
		String text6 = "Cotellic - 20mg";
		MobileElement elem11 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ text6 + "\").instance(0))")));
		elem11.click();
		// add a dose

		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_frequency_2")).click();

		String id13 = "tavie.patient.skin.pre.v3.test:id/tv_item_dose_time";
		MobileElement elem12 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id13 + "\").instance(0))")));
		elem12.click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/done")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/save_changes")).click();

		// delete the medication

		/// open the review medication interface

		MobileElement elem13 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ text6 + "\").instance(0))")));
		elem13.click();
		// click on delete button
		String id14 = "tavie.patient.skin.pre.v3.test:id/delete_medication";
		MobileElement elem14 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id14 + "\").instance(0))")));
		elem14.click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/confirm_button")).click();

		// add custom medication

		MobileElement elem15 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ text4 + "\").instance(0))")));

		elem15.click();
		// click on add custom medication button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/layout_add_custom_medication")).click();

		// add medication name
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/et_add_med_name")).sendKeys("Medication1");
		// select color
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/iv_add_med_yellow")).click();
		// select medication type
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/iv_add_med_cream")).click();
		// select frequency
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_add_med_frequency")).click();
		// select weekly frequency
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_dialog_add_med_weekly")).click();
		// select monday as day to take medication
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/iv_add_med_frequency_weekly_mon")).click();
		// select dose time
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_item_dose_time")).click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/done")).click();
		// refill reminder
		String id15 = "tavie.patient.skin.pre.v3.test:id/refill_reminder";
		MobileElement elem16 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id15 + "\").instance(0))")));

		elem16.click();
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_dialog_appointment_time_done")).click();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		// click on add medication
		String id16 = "tavie.patient.skin.pre.v3.test:id/btn_add_med_add";
		MobileElement elem17 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id16 + "\").instance(0))")));

		elem17.click();
		// select non on the popup that appears
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn0")).click();

		// click on done button of select medications interface
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/done")).click();

		// scroll until the end of interface

		String id17 = "tavie.patient.skin.pre.v3.test:id/rv_medications";
		MobileElement elem18 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id17 + "\").instance(0))")));

		elem18.click();
// click on back button 
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/back")).click();
/// navigate to symptomps environment 
		String text7 = "Mes Symptômes";
		MobileElement elem19 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ text7 + "\").instance(0))")));

		elem19.click();

/// click on continue button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/buttonHolder")).click();
/// click on understood button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_undestood")).click();
/// close the helpopup
		MobileElement uppp = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]"));

		uppp.findElement(By.className("android.widget.ImageView")).click();

// click on see more open the symptoms library
		String id18 = "tavie.patient.skin.pre.v3.test:id/monpso";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches(\"" + id18 + "\")")).click();
// select right arm 
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/right_arm")).click();
/// 
		MobileElement sym = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/symptoms_parent"));
		MobileElement sym1 = sym.findElement(By.className("android.widget.LinearLayout"));
		MobileElement sym2 = sym1.findElement(By.id("tavie.patient.skin.pre.v3.test:id/symptoms_holder"));
		List sym_list = sym2.findElements(By.className("android.widget.RelativeLayout"));
		System.out.println(sym_list.size());
		/// symptomps1
		((MobileElement) sym_list.get(0)).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// see script
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/script_button")).click();
		String id19 = "tavie.patient.skin.pre.v3.test:id/done";
		MobileElement elem20 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id19 + "\").instance(0))")));

		elem20.click();
		/// symptomps1
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// ((MobileElement) sym_list.get(2)).click();

// click on back 
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/backbtn")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/backbtn")).click();

		// click on the symptoms on last consulted terms

		MobileElement l1 = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/recycler_view"));
		List list1 = l1.findElements(By.className("android.view.ViewGroup"));
		System.out.println(list1.size());
		((MobileElement) list1.get(0)).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// see script
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/script_button")).click();
		// String id19="tavie.patient.skin.pre.v3.test:id/done";
		MobileElement elem21 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id19 + "\").instance(0))")));

		elem21.click();
		// Adverse event
		// click to open the adverse event
		String id20 = "tavie.patient.skin.pre.v3.test:id/ll_direction_report";
		MobileElement elem22 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id20 + "\").instance(0))")));

		elem22.click();

		// wait untill continue button appears
		WebDriverWait wait3 = new WebDriverWait(driver, 1000);
		MobileElement CTN_BTN = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_dialog_add_med_done"));
		wait3.until(ExpectedConditions.visibilityOf(CTN_BTN));
		CTN_BTN.click();
		// click on understand button

		String id21 = "tavie.patient.skin.pre.v3.test:id/ll_undestood";
		MobileElement elem23 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id21 + "\").instance(0))")));
		elem23.click();

		// enter name
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/name_edit_profile")).sendKeys("TEST1");
		// enter last name
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/last_name_profile")).sendKeys("TEST2");
		// enter age
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_age")).sendKeys("55");
		// change gender
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_gender")).click();
		String text8 = "Femme";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + text8 + "\")")).click();
		// enter email
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/textView127")).sendKeys("TEST@Test.com");
		// enter phone number
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/textView128")).sendKeys("1234567");

		MobileElement ConfirmBTN = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/confimContact"));

		if (ConfirmBTN.isEnabled()) {
			ConfirmBTN.click();
		}

		// enter text
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/message")).sendKeys("Mon événement indésirable");
		// select Adverse reaction severity criteria

		String id22 = "tavie.patient.skin.pre.v3.test:id/lifethreatening";
		MobileElement elem24 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id22 + "\").instance(0))")));
		elem24.click();
		// select result
		String id23 = "tavie.patient.skin.pre.v3.test:id/NotResolved";
		MobileElement elem25 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id23 + "\").instance(0))")));
		elem25.click();
		// select medication

		String id24 = "tavie.patient.skin.pre.v3.test:id/whatthree";
		MobileElement elem26 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id24 + "\").instance(0))")));
		elem26.click();
		/// MobileElement
		/// ConfirmBTN2=driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/confim"));

		// if(ConfirmBTN2.isEnabled()) {

		// ConfirmBTN2.click();}
		// click on next button
		String id25 = "tavie.patient.skin.pre.v3.test:id/confim";
		MobileElement elem27 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id25 + "\").instance(0))")));
		elem27.click();
		// when start braftovi
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/date1_section3")).click();
		// select ok on the current date
		driver.findElement(By.id("android:id/button1")).click();
		// click on yes
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn_yes")).click();
		// enter actual dose
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/dose1_section3_1")).sendKeys("55");
		/// select reaction
		String id26 = "tavie.patient.skin.pre.v3.test:id/rl_section3_3";
		MobileElement elem28 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id26 + "\").instance(0))")));
		elem28.click();
		// when start mektovi
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/date2_section3_2")).click();
		// select 1
		String text9 = "1";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + text9 + "\")")).click();

		// select ok on the current date
		driver.findElement(By.id("android:id/button1")).click();

		// click on no

		String id27 = "tavie.patient.skin.pre.v3.test:id/btn_no1";
		MobileElement elem29 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id27 + "\").instance(0))")));
		elem29.click();

		// enter Mektovi dose

		String id28 = "tavie.patient.skin.pre.v3.test:id/dose2_section3_4";
		MobileElement elem30 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id28 + "\").instance(0))")));
		elem30.sendKeys("105");

		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/dose2_section3_4")).sendKeys("105");
		// reaction mektovi
		String id29 = "tavie.patient.skin.pre.v3.test:id/rl_section3_2_2";
		MobileElement elem31 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id29 + "\").instance(0))")));
		elem31.click();
		// next button

		String id30 = "tavie.patient.skin.pre.v3.test:id/confimsection_3";
		MobileElement elem32 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceIdMatches(\""
						+ id30 + "\").instance(0))")));
		elem32.click();
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/confimsection_3")).click();
		// click on yest button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/btn12")).click();
		// enter doctor name
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/name_doctor")).sendKeys("Docor1");
		// enter hospital name
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/location")).sendKeys("Hospital1");
		// enter doctor number
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/numero")).sendKeys("123456789");
		// click on next button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/confimsection_4")).click();
		// clcik on accept button radiio
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/iv_consent")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		// String text10="J'accepte de partager ces informations avec Pierre Fabre";

		String id31 = "tavie.patient.skin.pre.v3.test:id/ll_consent";
		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().resourceIdMatches(\""+id31+"\")")).click();

		// driver.findElement( MobileBy.AndroidUIAutomator("new
		// UiSelector().resourceIdMatches(\""+id31+"\")")).click();

		// MobileElement em1=
		// driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/ll_consent"));
		// MobileElement em2=
		// em1.findElement(By.id("tavie.patient.skin.pre.v3.test:id/iv_consent"));

		// em2.click();
		driver.findElement(By.id(id31)).click();
		driver.findElement(By.id(id31)).click();

		// click on sned button
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tv_send")).click();

		// wait untill the sned pop_up appears
		WebDriverWait wait4 = new WebDriverWait(driver, 1000);
		MobileElement checkbtn = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/crisis_menu"));
		wait4.until(ExpectedConditions.visibilityOf(checkbtn));
		checkbtn.click();
		// click on back button
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/back")).click();
		// Click to open coaching session
		MobileElement ss = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/tab_sessions"));
		MobileElement ss_icon = ss.findElement(By.className("android.widget.ImageView"));
		ss_icon.click();

		// start "adopter un mode de vie actif"
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/startButton")).click();

		// session1
		MobileElement session = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/sessions"));
		List list_session = session.findElements(By.className("android.widget.LinearLayout"));
		System.out.println(list_session.size());
		((MobileElement) list_session.get(0)).click();
		// welcome , je ne sais pas button
		MobileElement session1 = driver
				.findElement(By.id("tavie.patient.skin.pre.v3.test:id/redirect_buttons_regular_holder"));
		List list_session1 = session1.findElements(By.className("android.widget.LinearLayout"));
		System.out.println(list_session1.size());
		((MobileElement) list_session1.get(4)).click();
		// video histoire d'alexandra
		driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/buttonlayout")).click();

		WebDriverWait wait5 = new WebDriverWait(driver, 1000);
		MobileElement CNbtn = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/material_ripple"));
		wait5.until(ExpectedConditions.visibilityOf(CNbtn));
		CNbtn.click();
		// survey
		MobileElement survey = driver.findElement(By.id("tavie.patient.skin.pre.v3.test:id/questionnaire_holder"));
		List list_survey = survey.findElements(By.className("android.widget.LinearLayout"));
		System.out.println(list_survey.size()+"list surevey number");
		for (int i = 0; i < list_survey.size(); i++) {
			System.out.println(list_survey.get(i));
			//List list_options = ((MobileElement) list_survey.get(i)).findElements(By.className("android.widget.LinearLayout"));
			//System.out.println(list_options.size());
			//((MobileElement) list_options.get(0)).click();
		}
		// ((MobileElement) list_survey.get(0)).click();

	}

}
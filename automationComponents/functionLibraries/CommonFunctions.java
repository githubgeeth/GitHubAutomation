package functionLibraries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import testRunner.TestRunner;

public class CommonFunctions extends WebDriver {	
	
	public static String scenarioStatus; 
	
	public void launchURL(String url) {
		driver.manage().window().maximize();
		driver.get(url);		
		TestRunner.logger.log(LogStatus.PASS,  "Launch the URL: " + url);
	}
	
	//Selects the value from drop down based on either Visible text, Value or Index
	public  void dropdownSelect(WebElement obj, String comptype, String dropdownvalue) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(obj));
		Select slist = new Select(obj);
		if (comptype.equals("Visible text")) {
			slist.selectByVisibleText(dropdownvalue);			
		} else if (comptype.equals("value")) {
			slist.selectByValue(dropdownvalue);
		} else if (comptype.equals("index")) {
			slist.selectByIndex(Integer.parseInt(dropdownvalue));
		}
		TestRunner.logger.log(LogStatus.PASS, dropdownvalue + " dropdown value is selected");
	}
	
	public  void objClick(WebElement obj) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(obj));
		TestRunner.logger.log(LogStatus.PASS, obj.getText() + " object is clicked");
		obj.click();
	}
	
	public  void objsetText(WebElement obj, String str) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(obj));
		
		obj.clear();
		obj.sendKeys(str);
		TestRunner.logger.log(LogStatus.PASS, str  +  " is provided in " + obj.toString());
	}
	
	public  void dataVerification(WebElement obj, String str) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(obj));
		String actlocation = obj.getText();
		/*SoftAssert soft = new SoftAssert();
		soft.assertTrue(actlocation.trim().equals(str), "Test")*/
		if (actlocation.trim().contentEquals(str)){
			TestRunner.logger.log(LogStatus.PASS, obj.getText() + " has " + actlocation.trim() + ". Expected value: " + str);
			scenarioStatus = "Success";
		} else {
			TestRunner.logger.log(LogStatus.FAIL, obj.getText() + " has " + actlocation.trim() + ". Expected value: " + str);
			scenarioStatus = "Failure";			
		}
	}
	
	public void partialdataVerification(WebElement obj, String str) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(obj));
		String actlocation = obj.getText();
		/*SoftAssert soft = new SoftAssert();
		soft.assertTrue(actlocation.trim().equals(str), "Test")*/
		if (actlocation.trim().contains(str)){
			TestRunner.logger.log(LogStatus.PASS, obj.getText() + " contains " + actlocation.trim() + ". Expected value: " + str);
			scenarioStatus = "Success";
		} else {
			TestRunner.logger.log(LogStatus.FAIL, obj.getText() + " contains " + actlocation.trim() + ". Expected value: " + str);
			scenarioStatus = "Failure";			
		}
	}
	
	public  void objVerification(WebElement obj) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(obj));		
		if (obj.isEnabled()){
			TestRunner.logger.log(LogStatus.PASS, obj.getText() + " is available");
			scenarioStatus = "Success";
		} else {
			TestRunner.logger.log(LogStatus.FAIL, obj.getText() + " is not available");
			scenarioStatus = "Failure";
		}
	}
	
	public  void scenarioExecutionStatus() {
		if (scenarioStatus.equalsIgnoreCase("Success")) {
		} else {
			System.out.println("Test Status: " + scenarioStatus);
			Assert.fail("Failed");
		}
	}
}
package functionLibraries;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import testRunner.TestRunner;

public class CommonFunctionsLatest extends WebDriver {	
	
	public static String scenarioStatus; 
	
	/***************************************************
	 * Name: 			launchURL
	 * Description: 	Maximize the browser and launches the application  
	 * Author:			schanga003
	 ***************************************************/
	public void launchURL(String url) throws Exception {
		try {
			driver.manage().window().maximize();
			driver.get(url);
			printReportStatement("Launch the URL: " + url, "Pass");
			scenarioStatus = "Success";
			//TestRunner.logger.log(LogStatus.PASS,  "Launch the URL: " + url);
		} catch (Exception e) {
			printReportStatement("Not able launch the URL: " + url + ". Exception: " + e, "Fail");			
			Assert.fail("Failed");
		}		
	}
	
	/*******************************************************************************
	 * Name: 			dropdownSelect
	 * Description: 	Selects the value from drop down based on either Visible text, Value or Index  
	 * Author:			schanga003
	 *******************************************************************************/
	public  void dropdownSelect(WebElement obj, String comptype, String dropdownvalue) throws Exception {
		try {
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
			//TestRunner.logger.log(LogStatus.PASS, dropdownvalue + " dropdown value is selected");
			printReportStatement(dropdownvalue + " dropdown value is selected", "Pass");
			scenarioStatus = "Success";
		} catch (Exception e) {
			printReportStatement("Object either doesn't exist or not found. Exception: " + e, "Fail");
			Assert.fail("Failed");
		}
	}
	
	/*******************************************
	 * Name: 			objClick
	 * Description: 	Clicks on an object  
	 * Author:			schanga003
	 *******************************************/
	public  void objClick(WebElement obj) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(obj));
			//TestRunner.logger.log(LogStatus.PASS, obj.getText() + " object is clicked");
			printReportStatement(obj.getText() + " object is clicked", "Pass");
			obj.click();
			scenarioStatus = "Success";
		} catch (Exception e) {
			printReportStatement("Object either doesn't exist or not found. Exception: " + e, "Fail");
			Assert.fail("Failed");
		}
	}
	
	/*****************************************************
	 * Name: 			objsetText
	 * Description: 	Input data into application objects  
	 * Author:			schanga003
	 *****************************************************/
	public  void objsetText(WebElement obj, String str) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(obj));
			obj.clear();
			obj.sendKeys(str);	
			//TestRunner.logger.log(LogStatus.PASS, str  +  " is provided in " + obj.toString());
			printReportStatement(str  +  " is provided in " + obj.toString(), "Pass");
			scenarioStatus = "Success";
		} catch (Exception e) {
			printReportStatement("Object either doesn't exist or not found. Exception: " + e, "Fail");
			Assert.fail("Failed");
		}
	}
	
	/************************************************
	 * Name: 			dataVerification
	 * Description: 	Verifies if actual and expected text is same  
	 * Author:			schanga003
	 ************************************************/
	public  void dataVerification(WebElement obj, String str) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(obj));
			String actlocation = obj.getText();
			/*SoftAssert soft = new SoftAssert();
			soft.assertTrue(actlocation.trim().equals(str), "Test")*/
			if (actlocation.trim().contentEquals(str)){
				//TestRunner.logger.log(LogStatus.PASS, obj.getText() + " has " + actlocation.trim() + ". Expected value: " + str);
				printReportStatement(obj.getText() + " has " + actlocation.trim() + ". Expected value: " + str, "Pass");
				scenarioStatus = "Success";
			} else {
				//TestRunner.logger.log(LogStatus.FAIL, obj.getText() + " has " + actlocation.trim() + ". Expected value: " + str);
				printReportStatement(obj.getText() + " has " + actlocation.trim() + ". Expected value: " + str, "Fail");
				scenarioStatus = "Failure";			
			}
		} catch (Exception e) {
			printReportStatement("Object either doesn't exist or not found. Exception: " + e, "Fail");			
		}
	}
	
	/************************************************
	 * Name: 			partialdataVerification
	 * Description: 	Verifies if actual text contains expected text  
	 * Author:			schanga003
	 ************************************************/
	public void partialdataVerification(WebElement obj, String str) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(obj));
			String actlocation = obj.getText();
			/*SoftAssert soft = new SoftAssert();
			soft.assertTrue(actlocation.trim().equals(str), "Test")*/
			if (actlocation.trim().contains(str)){
				//TestRunner.logger.log(LogStatus.PASS, obj.getText() + " contains " + actlocation.trim() + ". Expected value: " + str);
				printReportStatement(obj.getText() + " contains " + actlocation.trim() + ". Expected value: " + str, "Pass");
				scenarioStatus = "Success";
			} else {
				//TestRunner.logger.log(LogStatus.FAIL, obj.getText() + " contains " + actlocation.trim() + ". Expected value: " + str);
				printReportStatement(obj.getText() + " contains " + actlocation.trim() + ". Expected value: " + str, "Fail");
				scenarioStatus = "Failure";			
			}
		} catch (Exception e) {
			printReportStatement("Object either doesn't exist or not found. Exception: " + e, "Fail");			
		}
	}
	
	/************************************************
	 * Name: 			objVerification
	 * Description: 	Verifies object availability 
	 * Author:			schanga003
	 ************************************************/
	public  void objVerification(WebElement obj) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(obj));		
			if (obj.isEnabled()){
				//TestRunner.logger.log(LogStatus.PASS, obj.getText() + " is available");
				printReportStatement(obj.getText() + " is available", "Pass");
				scenarioStatus = "Success";
			} else {
				//TestRunner.logger.log(LogStatus.FAIL, obj.getText() + " is not available");
				printReportStatement(obj.getText() + " is not available", "Fail");
				scenarioStatus = "Failure";
			}
		} catch (Exception e) {
			printReportStatement("Object either doesn't exist or not found. Exception: " + e, "Fail");			
		}
	}
	
	/**********************************************************
	 * Name: 			scenarioExecutionStatus
	 * Description: 	Marks the test case as passed or failed based on test steps 
	 * Author:			schanga003
	 **********************************************************/
	public  void scenarioExecutionStatus() {
		if (scenarioStatus.equalsIgnoreCase("Success")) {
		} else {
			//System.out.println("Test Status: " + scenarioStatus);
			Assert.fail("Failed");
		}
	}
	
	/***************************************************************
	 * Name: 			clickElement
	 * Description: 	Clicks on the particular menu item with help of the Name of the field 
	 * Author:			schanga003
	 ***************************************************************/
	public String clickElement(String xpath, String itemtobeclicked) throws Exception {		
		String itemavailability = "False";
		
		if (waitMultipleElementsVisibility(xpath).equalsIgnoreCase("True")) { 
		try {			
			List<WebElement> linkElements = driver.findElements(By.xpath(xpath));
			for(WebElement obj : linkElements){
				
				if (obj.getText().equalsIgnoreCase(itemtobeclicked)) {
					printReportStatement(obj.getText() + " is clicked.", "Pass");
					scenarioStatus = "Success";
					itemavailability = "True";
					obj.click();
					printReportStatement(itemtobeclicked + " is clicked", "Pass");
					break;
				}
			}
			if (itemavailability.equalsIgnoreCase("False")) {
				printReportStatement(itemtobeclicked + " is not avaiable", "Fail");
				Assert.fail("Failed");
			}
		
		}  catch (Exception e) {
			printReportStatement("Object either doesn't exist or not found. Exception: " + e, "Fail");
			Assert.fail("Failed");
		}
		} else {
			printReportStatement("Object either doesn't exist or not found.", "Fail");
			Assert.fail("Failed");
		}
		return itemavailability;
	}
	
	/***************************************************************
	 * Name: 			verifyElement
	 * Description: 	Verifies particular menu item with help of the Name of the field 
	 * Author:			schanga003
	 ***************************************************************/
	public String verifyElement(String xpath, String itemtobeverified) throws Exception {		
		String itemavailability = "False";
		
		if (waitMultipleElementsVisibility(xpath).equalsIgnoreCase("True")) { 
		try {			
			List<WebElement> linkElements = driver.findElements(By.xpath(xpath));
			for(WebElement obj : linkElements){
				
				if (obj.getText().equalsIgnoreCase(itemtobeverified)) {
					printReportStatement(obj.getText() + " is clicked.", "Pass");
					scenarioStatus = "Success";
					itemavailability = "True";
					//obj.click();
					printReportStatement(itemtobeverified + " is clicked", "Pass");
					break;
				}
			}
			if (itemavailability.equalsIgnoreCase("False")) {
				printReportStatement(itemtobeverified + " is not avaiable", "Fail");
				Assert.fail("Failed");
			}
		
		}  catch (Exception e) {
			printReportStatement("Object either doesn't exist or not found. Exception: " + e, "Fail");
			Assert.fail("Failed");
		}
		} else {
			printReportStatement("Object either doesn't exist or not found.", "Fail");
			Assert.fail("Failed");
		}
		return itemavailability;
	}
	
	/***************************************************************
	 * Name: 			extractTagsData
	 * Description: 	Extracts data from a tag underlying parent tag 
	 * Author:			schanga003
	 ***************************************************************/
	public String extractTagsData(String xpath) throws Exception {		
		String tagsdata = "";
		try {			
			List<WebElement> linkElements = driver.findElements(By.xpath(xpath));
			for(WebElement obj : linkElements){				
				tagsdata = tagsdata + obj.getText() + " & " ;
			}
			printReportStatement("Command line to create a repository. Commands: " + "\n" + tagsdata, "Pass");
			scenarioStatus = "Success";
		} catch (Exception e) {
			printReportStatement("Object either doesn't exist or not found. Exception: " + e, "Fail");
			Assert.fail("Failed");
		}
		System.out.println(tagsdata);
		return tagsdata;
	}
	
	/***********************************************************
	 * Name: 			printReportStatement
	 * Description: 	Prints the customized statement in HTML report 
	 * Author:			schanga003
	 ***********************************************************/
	public void printReportStatement(String msg, String status) throws Exception {
		try {
			DateFormat  df = new SimpleDateFormat("MM_dd_yyyy_HH_MM_SS");
		    Date dt = new Date();
			
			String yourfilepath = System.getProperty("user.dir") + "\\Screenshots\\";
			File snapshort_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(snapshort_file, new File(yourfilepath + df.format(dt) + "test.png"));
			String image = TestRunner.logger.addScreenCapture(yourfilepath + df.format(dt) + "test.png");
			if (status.equalsIgnoreCase("Pass")) {
				TestRunner.logger.log(LogStatus.PASS, msg + image);
				scenarioStatus = "Success";
			} else {
				TestRunner.logger.log(LogStatus.FAIL, msg + image);
				scenarioStatus = "Failure";
			}
		} catch(Exception e) {
			System.out.println("Not able to print to the report: " + e);
			Assert.fail("Failed");
		}	
	}
	
	/***********************************************************
	 * Name: 			commandlineExecution
	 * Description: 	Executes command line statements 
	 * Author:			schanga003
	 ***********************************************************/
	public void commandlineExecution(String command) throws Exception {
		try {
			String cmdlinoutput = "";
	        Process p=Runtime.getRuntime().exec("cmd /c " + command); 
	        p.waitFor(); 
	        BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
	        String line; 
	        while((line = reader.readLine()) != null) 
	        { 
	        	cmdlinoutput = cmdlinoutput + line + "\n";	        	
	        }
	        printReportStatement("Command line output:" + "\n" + cmdlinoutput, "Pass");
	    }
	    catch(IOException e1) {} 
	    catch(InterruptedException e2) {} 
	}
	
	/***********************************************************
	 * Name: 			waitMultipleElementsVisibility
	 * Description: 	Waits until multiple elements are visible 
	 * Author:			schanga003
	 ***********************************************************/
	public String waitMultipleElementsVisibility(String xpath) throws Exception {
		String status = "False";
		try {					
			
			int esize = 0, count = 0;
		    do {
		    	List<WebElement> linkElements = driver.findElements(By.xpath(xpath));
		    	esize = linkElements.size();
		    	Thread.sleep(1000);
		    	count = count + 1;
		    	if (count > 30) {
		    		break;
		    	}
		    } while (esize <= 1);
		    if (count <= 30) {
		    	printReportStatement("Object is visible.", "Pass");
		    	status = "True";
		    } else {
		    	printReportStatement("Object is not visible.", "Fail");		    	
		    }
	    }
	    catch(Exception e) {}		
		return status;
	}
	
}
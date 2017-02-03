package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubLogin {
	@FindBy(xpath = "//input[@class='form-control' and contains(@id, 'txtEMAIL')]") 
	public WebElement PwCEmail;
	
	@FindBy(xpath = "//input[@class='btn' and contains(@id, 'Submit')]") 
	public WebElement GitHubLogIn;
	
	//Subba's Private GitHub
	@FindBy(xpath = "//a[contains(@href,'login') and text()='Sign in']") 
	public WebElement Signin;
	
	@FindBy(xpath = "//input[@name='login' and @id='login_field']") 
	public WebElement Username;
	
	@FindBy(xpath = "//input[@name='password' and @id='password']") 
	public WebElement Password;
	
	@FindBy(xpath = "//input[@name='commit' and @value='Sign in']") 
	public WebElement LoginButton;
}
package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PFCreateRepository {
	//Subba' private GitHub
	@FindBy(xpath = "//a[@href='/new' and contains(text(),'New repository') and contains(@class,'btn')]") 
	public WebElement NewRepository;
	
	@FindBy(xpath = "//a[contains(@class,'btn-secondary') and text()='Start a project']") 
	public WebElement StartaProject;
	
	@FindBy(xpath = "//input[@id='repository_name' and @name='repository[name]']") 
	public WebElement Repositoryname;
	
	@FindBy(xpath = "//button[contains(text(),'Create repository') and @type='submit']") 
	public WebElement Createrepository;
	
	String codetab = "//a[contains(@class,'selected reponav-item') and contains(@href, ";
	
	@FindBy(xpath = "//a[contains(@class,'selected reponav-item')]") 
	public WebElement defaultCode;
	
	//Issues
	@FindBy(xpath = "//a[contains(@class,'reponav-item') and contains(@href,'issues')]") 
	public WebElement Issues;
	
	@FindBy(xpath = "//a[contains(@href,'issues/new') and contains(text(),'New issue') and contains(@class,'btn')]") 
	public WebElement Newissue;
	
	@FindBy(xpath = "//input[@id='issue_title' and @name='issue[title]']") 
	public WebElement IssueName;
	
	@FindBy(xpath = "//textarea[@name='issue[body]' and @id ='issue_body']") 
	public WebElement IssueDescription;
	
	@FindBy(xpath = "//button[@type='submit' and contains(text(), 'Submit new issue')]") 
	public WebElement Submitnewissue;
	
	@FindBy(xpath = "//span[@class='js-issue-title']") 
	public WebElement Issuetitle;
	
	//Pull requests
	@FindBy(xpath = "//a[contains(@class,'reponav-item') and contains(@href,'pulls')]") 
	public WebElement Pullrequests;
	
	@FindBy(xpath = "//a[contains(@href,'compare') and contains(text(),'New pull request') and contains(@class,'btn')]") 
	public WebElement Newpullrequests;
	
	//Projects
	@FindBy(xpath = "//a[contains(@class,'reponav-item') and contains(@href,'projects')]") 
	public WebElement Projects;
	
	@FindBy(xpath = "//a[contains(@href,'projects/new') and text() = 'Create a project' and contains(@class,'btn')]")
	public WebElement CreateaProject;
	
	@FindBy(xpath = "//input[@id='project_name' and @name='project[name]']") 
	public WebElement Projectname;
	
	@FindBy(xpath = "//textarea[@name='project[body]' and @id ='project_body']") 
	public WebElement Projectbody;
	
	@FindBy(xpath = "//button[@type='submit' and text() = 'Save project']") 
	public WebElement Saveproject;
	
	@FindBy(xpath = "//div[starts-with(@class, 'project-header')]/h3") 
	public WebElement Verifyproject;
	
	//Wiki
	@FindBy(xpath = "//a[contains(@class,'reponav-item') and contains(@href,'wiki')]") 
	public WebElement Wiki;
	
	@FindBy(xpath = "//a[contains(@href,'wiki/_new') and contains(@class,'btn') and text()='Create the first page']") 
	public WebElement Createfirstpage;
	
	//Pulse
	@FindBy(xpath = "//a[contains(@class,'reponav-item') and contains(@href,'pulse')]") 
	public WebElement Pulse;
	
	@FindBy(xpath = "//div[@class ='boxed-group flush']/h3") 
	public WebElement PulseHeader;
	
	//Graphs
	@FindBy(xpath = "//a[contains(@class,'reponav-item') and contains(@href,'graphs')]") 
	public WebElement Graphs;
	
	@FindBy(xpath = "//div[contains(@class,'blankslate')]/*[name()='svg']") 
	public WebElement Graphsicon;
	
	//Settings
	@FindBy(xpath = "//a[contains(@class,'reponav-item') and contains(@href,'settings')]") 
	public WebElement Settings;
		
	@FindBy(xpath = "//button[text()='Delete this repository' and @type='button']") 
	public WebElement DeleteRepository;
	
	@FindBy(xpath = "//div[@class='facebox-popup']//input[@type='text' and @name='verify']") 
	public WebElement DelRepositoryName;
	
	@FindBy(xpath = "//div[@class='facebox-popup']//button[@type='submit' and contains(text(),'delete this repository')]") 
	public WebElement DelRepositorySubmit;
	
	@FindBy(xpath = "//div[@id='js-flash-container']//div[@class='container']") 
	public WebElement RepoDeletionMsg;	
}
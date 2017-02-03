package automationScripts;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.Given;
import functionLibraries.CommonFunctions;
import functionLibraries.ExcelReader;
import functionLibraries.WebDriver;
import pageFactory.GitHubLogin;
import pageFactory.PFCreateRepository;

public class CreateRepository extends WebDriver{
	
	public String issuename, issuedesc, projname, projdesc, repname;
	ExcelReader er = new ExcelReader();
	
	GitHubLogin ghlobj = PageFactory.initElements(driver, GitHubLogin.class);	
	PFCreateRepository crobj = PageFactory.initElements(driver, PFCreateRepository.class);
	CommonFunctions cfobj = new CommonFunctions();
	
	DateFormat  df = new SimpleDateFormat("MM_dd_yyyy_HH_MM_SS");
    Date dt = new Date();

	@Given("^Launch PwC GitHub URL and login to GitHub$")
	public void launch_PwC_GitHub_URL_and_login_to_GitHub() throws Throwable {
		Properties prop = new Properties();
		FileInputStream inputProperties = new FileInputStream(System.getProperty("user.dir") + "\\Input\\config.properties");
		prop.load(inputProperties);
		cfobj.launchURL(prop.getProperty("URL"));
		//cfobj.objsetText(ghlobj.PwCEmail, prop.getProperty("emailid"));
		//cfobj.objClick(ghlobj.GitHubLogIn);
		
		//Subba's private GitHub
		cfobj.objClick(ghlobj.Signin);
		cfobj.objsetText(ghlobj.Username, prop.getProperty("Username"));
		cfobj.objsetText(ghlobj.Password, prop.getProperty("Password"));
		cfobj.objClick(ghlobj.LoginButton);
	}

	@Given("^Click on Start a project to create a repository and verify Code tab is displayed \"([^\"]*)\"$")
	public void click_on_Start_a_project_to_create_a_repository_and_verify_Code_tab_is_displayed(String arg1) throws Throwable {
		//cfobj.objClick(crobj.StartaProject);
		cfobj.objClick(crobj.NewRepository);
		repname = er.getData("TC001", 4, 1) + "_" + df.format(dt);
		cfobj.objsetText(crobj.Repositoryname, repname);
		cfobj.objClick(crobj.Createrepository);
	    cfobj.objVerification(crobj.defaultCode);
	}

	@Given("^Navigate to Issues and create a new issue \"([^\"]*)\"$")
	public void navigate_to_Issues_and_create_a_new_issue(String arg1) throws Throwable {
	    cfobj.objClick(crobj.Issues);
	    cfobj.objClick(crobj.Newissue);
	    issuename = er.getData("TC001", 0, 1) + "_" + df.format(dt);
	    cfobj.objsetText(crobj.IssueName, issuename);
	    issuedesc = er.getData("TC001", 1, 1) + "_" + df.format(dt);
	    cfobj.objsetText(crobj.IssueDescription, issuedesc);
	    cfobj.objClick(crobj.Submitnewissue);
	    cfobj.dataVerification(crobj.Issuetitle, issuename);
	}

	@Given("^Navigate to Pull requests and verify if New pull request is available$")
	public void navigate_to_Pull_requests_and_verify_if_New_pull_request_is_available() throws Throwable {
		cfobj.objClick(crobj.Pullrequests);
		cfobj.objVerification(crobj.Newpullrequests);
	}

	@Given("^Navigate to Projects and create a new project \"([^\"]*)\"$")
	public void navigate_to_Projects_and_create_a_new_project(String arg1) throws Throwable {
		cfobj.objClick(crobj.Projects);
		cfobj.objClick(crobj.CreateaProject);	    
	    projname = er.getData("TC001", 2, 1) + "_" + df.format(dt);
	    cfobj.objsetText(crobj.Projectname, projname);
	    projdesc = er.getData("TC001", 3, 1) + "_" + df.format(dt);
	    cfobj.objsetText(crobj.Projectbody, projdesc);
	    cfobj.objClick(crobj.Saveproject);
	    cfobj.partialdataVerification(crobj.Verifyproject, projname);
	}

	@Given("^Navigate to Wiki and verify Wiki icon$")
	public void navigate_to_Wiki_and_verify_Wiki_icon() throws Throwable {
		cfobj.objClick(crobj.Wiki);
		cfobj.objVerification(crobj.Createfirstpage);
	}

	@Given("^Navigate to Pulse and verify header$")
	public void navigate_to_Pulse_and_verify_header() throws Throwable {
		cfobj.objClick(crobj.Pulse);
		cfobj.objVerification(crobj.PulseHeader);
	}

	@Given("^Navigate to Graphs and verify graph icon availability$")
	public void navigate_to_Graphs_and_verify_graph_icon_availability() throws Throwable {
		cfobj.objClick(crobj.Graphs);
		cfobj.objVerification(crobj.Graphsicon);
	}

	@Given("^Navigate to settigns and Delete the repository$")
	public void navigate_to_settigns_and_Delete_the_repository() throws Throwable {
		cfobj.objClick(crobj.Settings);
		cfobj.objClick(crobj.DeleteRepository);
		cfobj.objsetText(crobj.DelRepositoryName, repname);
		cfobj.objClick(crobj.DelRepositorySubmit);
		cfobj.dataVerification(crobj.RepoDeletionMsg, er.getData("TC001", 6, 1).replace("@", "\"" + er.getData("TC001", 5, 1) + "/" + repname + "\""));
	}
}
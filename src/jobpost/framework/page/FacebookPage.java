package jobpost.framework.page;

import jobpost.framework.base.PageBage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage extends PageBage{

	@FindBy(name = "session_key")
	public WebElement emailField;
	
	@FindBy(name = "session_password")
	public WebElement passwordField;
	
	@FindBy(name = "signin")
	public WebElement logInButton;
	
	/////////////////////
	@FindBy(xpath = "//*[@id='yui-gen3']/div[3]/input")
	public WebElement shareButton;
	
	/*
	@FindBy(name = "email")
	public WebElement emailField;
	
	@FindBy(name = "pass")
	public WebElement passwordField;
	
	@FindBy(name = "login")
	public WebElement logInButton;
	
	///////////////////////////
	@FindBy(id = "checkpointSubmitButton")
	public WebElement checkpointButton;
	
	///////////////////////////
	@FindBy(id = "u_0_i")
	public WebElement dropDownLink;
	
	@FindBy(className = "_54nc")
	public WebElement pageYouManageLink;
	
	@FindBy(id = "u_0_u")
	public WebElement pageDropDownLink;
	
	@FindBy(xpath = "//*[@id='u_0_t']/div/div/div[1]/div/div/ul/li[2]/a")
	public WebElement eliteCareerLink;
	
	@FindBy(name = "share")
	public WebElement shareButton;
	*/
}

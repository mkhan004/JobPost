package jobpost.framework.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import jobpost.framework.base.PageBage;

public class BdJobsDetailPage extends PageBage{

	@FindBy(className = "category")
	public WebElement jobCategory;
	
	@FindBy(className = "job-title ")
	public WebElement jobTitle;
	
	@FindBy(className = "company-name ")
	public WebElement companyName;
	
	@FindBy(className = "job_des")
	public WebElement jobDescription;
	
	@FindBy(className = "job_nature_text_d")
	public WebElement jobType;
	
	@FindBy(className = "job_loc ")
	public WebElement jobLocation;
	
	@FindBy(className = "salary_range")
	public WebElement salary;
	
	@FindBy(className = "date")
	public WebElement deadline;
	
	@FindBy(xpath = ".//*[@id='job-preview']/div/div[3]/div/div[1]/div/div[2]/h4[1]")
	public WebElement publishDate;

	@FindBy(className = "edu_req")
	public WebElement education;
	
	@FindBy(className = "edu_req")
	public List<WebElement> experience;
	
	@FindBy(className = "job_req")
	public WebElement additionalRequirements;
	
	@FindBy(className = "oth_ben")
	public WebElement otherBenifit;
	
	@FindBy(css = "div[class='guide text-center ']")
	public WebElement emailText;
	
	@FindBy(linkText = "<< Back to search results")
	public WebElement moveToSearchPageLink;
	
}

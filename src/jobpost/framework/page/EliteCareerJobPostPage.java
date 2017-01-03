package jobpost.framework.page;

import jobpost.framework.base.PageBage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EliteCareerJobPostPage extends PageBage{

	@FindBy(name = "CompanyName")
	public WebElement companyNameField;
	
	@FindBy(name = "JobPosition")
	public WebElement jobPositionField;
	
	@FindBy(name = "JobType")
	public WebElement jobTypeDropDownList;
	
	@FindBy(name = "JobLevel")
	public WebElement jobLevelDropDownList;
	
	@FindBy(name = "JobCategory")
	public WebElement jobCategoryDropDownList;
	
	@FindBy(name = "NoOfVacancy")
	public WebElement noOfVacancyDropDownList;
	
	@FindBy(name = "JobDescription")
	public WebElement jobDescriptionField;
	
	@FindBy(name = "JobResponsibility")
	public WebElement jobResponsibilityField;
	
	@FindBy(name = "EducationRequirement")
	public WebElement educationRequirementField;
	
	@FindBy(name = "ExperienceRequirement")
	public WebElement experienceRequirementField;
	
	@FindBy(name = "AdditionalRequirement")
	public WebElement additionalRequirementField;
	
	@FindBy(name = "Salary")
	public WebElement salaryField;
	
	@FindBy(name = "JobLocation")
	public WebElement jobLocationField;
	
	@FindBy(name = "OtherBenefits")
	public WebElement otherBenefitsField;
	
	@FindBy(name = "ApplicationDeadline")
	public WebElement applicationDeadlineField;
	
	@FindBy(name = "Email")
	public WebElement EmailField;
	
	@FindBy(name = "submit")
	public WebElement submitButton;
	
}

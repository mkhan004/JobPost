package jobpost.framework.page;

import jobpost.framework.base.PageBage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EliteCareerNewJobsPage extends PageBage{

	@FindBy(id = "application_status_head_container")
	public WebElement totalJobs;
	
	@FindBy(linkText = "Next")
	public WebElement nextPageLink;
}

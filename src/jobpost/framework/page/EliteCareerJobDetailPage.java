package jobpost.framework.page;

import jobpost.framework.base.PageBage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EliteCareerJobDetailPage extends PageBage{

	@FindBy(id = "job_view_style")
	public WebElement totalJobView;
	
	@FindBy(xpath = "//*[@id='toolbar_hupso_toolbar_0']/a[1]/img")
	public WebElement facebookShareLink;
	
	@FindBy(xpath = "//*[@id='toolbar_hupso_toolbar_0']/a[2]/img")
	public WebElement linkedInShareLink;
}

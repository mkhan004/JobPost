package jobpost.framework.page;

import jobpost.framework.base.PageBage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobsListPage extends PageBage{

	@FindBy(id = "TopTotalRecord")
	public WebElement totalJobCount;
	
	@FindBy(linkText = "Next »")
	public WebElement nextPageLink;
}

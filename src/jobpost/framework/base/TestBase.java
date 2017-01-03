package jobpost.framework.base;

import java.util.concurrent.TimeUnit;

import jobpost.framework.page.BdJobsDetailPage;
import jobpost.framework.page.EliteCareerJobDetailPage;
import jobpost.framework.page.EliteCareerJobPostPage;
import jobpost.framework.page.EliteCareerNewJobsPage;
import jobpost.framework.page.FacebookPage;
import jobpost.framework.page.JobsListPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	//protected String url = "http://joblist.bdjobs.com/jobView.asp?id=582830&fcatId=6&pg=1&ln=1";
	public static WebDriver driver;
	public static WebDriver driver2;
	public static WebDriver driver3;
	protected static BdJobsDetailPage bdJobsDetailPage;
	protected static JobsListPage jobsListPage;
	protected static EliteCareerJobPostPage eliteCareerJobPostPage;
	protected static EliteCareerNewJobsPage eliteCareerNewJobsPage;
	protected static EliteCareerJobDetailPage eliteCareerJobDetailPage;
	protected static FacebookPage facebookPage;
	static String accounting = "http://joblist.bdjobs.com/jobsearch.asp?fcatId=1&icatId=";
	static String garmentTextile = "http://joblist.bdjobs.com/jobsearch.asp?fcatId=6&icatId=";
	static String commercialSupplyChain = "http://joblist.bdjobs.com/jobsearch.asp?fcatId=3&icatId=";
	static String engineeringArchiteck = "http://joblist.bdjobs.com/jobsearch.asp?fcatId=5&icatId=";
	static String hr = "http://joblist.bdjobs.com/jobsearch.asp?fcatId=17&icatId=";
	static String it = "http://joblist.bdjobs.com/jobsearch.asp?fcatId=8&icatId=";
	static String Engineer = "http://jobs.bdjobs.com/jobsearch.asp?fcatId=5&icatId=";


	public static void setUp(){
		driver = new FirefoxDriver();
		String url = Engineer;
		driver.get(url);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		bdJobsDetailPage = PageFactory.initElements(driver, BdJobsDetailPage.class);
		jobsListPage = PageFactory.initElements(driver, JobsListPage.class);
	}
	
	public static void setUp2(){
		driver2 = new FirefoxDriver();
		String url2 = "http://elitecareer.net/freejobpost.php";
		driver2.get(url2);
		driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver2.manage().window().maximize();
		
		eliteCareerJobPostPage = PageFactory.initElements(driver2, EliteCareerJobPostPage.class);
	}
	
	public static void setUp3(){
		driver3 = new FirefoxDriver();
		String url3 = "http://elitecareer.net";
		driver3.get(url3);
		driver3.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver3.manage().window().maximize();
		
		eliteCareerNewJobsPage = PageFactory.initElements(driver3, EliteCareerNewJobsPage.class);
		eliteCareerJobDetailPage = PageFactory.initElements(driver3, EliteCareerJobDetailPage.class);
		facebookPage = PageFactory.initElements(driver3, FacebookPage.class);
	}
	
	public static void tearDown(){
		driver.close();
	}
	
	public static void tearDown2(){
		driver2.close();
	}
	
}

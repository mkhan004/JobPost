package jobpost.framework.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StudyPlan {

	WebDriver driver = null;
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://qa.atom.ktp.io/StudyPlanAdmin/");
		driver.findElement(By.name("UserName")).sendKeys("kec\\shakkhan");
		driver.findElement(By.name("Password")).sendKeys("As365827@");
		driver.findElement(By.cssSelector("input[class = 'btn btn-lg btn-success btn-block']")).click();
		wait(10);
	}
	
	@Test
	public void testTitle(){
		Assert.assertEquals(driver.getTitle(), "ATOM Syllabus Admin");
	}
	
	@Test
	public void testXsdError(){
		
		List<WebElement> busenessList = driver.findElements(By.cssSelector("div[class = 'btn-group']"));
		for(int i=0; i<busenessList.size(); i++){
			System.out.println(busenessList.get(i).getText());
		}
		
		//driver.findElement(By.linkText("KTP")).click();
		//driver.findElement(By.className("btn-group")).click();;
		//wait(5);
		
		//driver.findElement(By.partialLinkText("Wayne Enterprises")).click();
		//wait(15);
		
		//List<WebElement> syllabusList = driver.findElements(By.cssSelector("tr[class = 'listing modified-syllabus']"));
		//syllabusList.get(0).click();
		//wait(15);
		String text = driver.findElement(By.cssSelector("div[class = 'panel-body']")).getText();
		System.out.println("Error Print: "+text);
		String mess = "Error: The element 'assignment' has incomplete content. List of possible elements expected:";
		Assert.assertTrue(text.toLowerCase().contains(mess.toLowerCase()), mess);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	public void wait(int second){
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package jobpost.framework.test;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jobpost.framework.base.TestBase;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class JobShare extends TestBase {

	public static void main(String[] args) throws InterruptedException {
		setUp3();
		String[] list = eliteCareerNewJobsPage.totalJobs.getText().split(" ");
		System.out.println(list[3]);
		int totalJobs = eliteCareerNewJobsPage.convertStringToInteger(list[3]);
		
		int runningSum = 0;
		if(runningSum != 0){
			for(int m=0; m<runningSum; m+=10){
				eliteCareerNewJobsPage.nextPageLink.click();
			}
		}
		
		for (int j = 0; j < totalJobs; j = runningSum) {

			int count = eliteCareerNewJobsPage.getListOfWebElementsEC("div[id = 'job_title_style']").size();
			System.out.println(runningSum + " - " + totalJobs);

			for (int i = 0; i < count; i++) {
				List<WebElement> countList = eliteCareerNewJobsPage.getListOfWebElementsEC2("//*[@id='job_title_style']/a");
				countList.get(i).click();
				String[] viewList = eliteCareerJobDetailPage.totalJobView.getText().split(" ");
				int totalView = eliteCareerJobDetailPage.convertStringToInteger(viewList[2]);
				System.out.println(i + " - " + totalView);
				
				if(totalView > 10){
					//driver3.switchTo().defaultContent();
					eliteCareerJobDetailPage.goToPreviousPage2();
					System.out.println(i + " passed");
				}else{
					
					eliteCareerJobDetailPage.linkedInShareLink.click();
					Set<String> winList = driver3.getWindowHandles();
					Iterator it = winList.iterator();
					String mainWin = (String) it.next();
					String secondWin = (String) it.next();
					driver3.switchTo().window(secondWin);
					
					//String additionalRequirements = "";
					try {
						facebookPage.emailField.sendKeys("shakil_ipe@yahoo.com");
						facebookPage.passwordField.sendKeys("365827");
						facebookPage.logInButton.click();
						//Thread.sleep(10000);
				    } catch (NoSuchElementException e) {
				    	//Thread.sleep(10000);
				    }
					
					Thread.sleep(10000);
					facebookPage.shareButton.click();
					
					/*
					facebookPage.checkpointButton.click();
					facebookPage.dropDownLink.click();
					facebookPage.pageYouManageLink.click();
					facebookPage.pageDropDownLink.click();
					facebookPage.eliteCareerLink.click();
					*/
					driver3.close();
					driver3.switchTo().window(mainWin);
					eliteCareerJobDetailPage.goToPreviousPage2();
				}
			}

			eliteCareerNewJobsPage.nextPageLink.click();
			runningSum += count;
		}

	}

}

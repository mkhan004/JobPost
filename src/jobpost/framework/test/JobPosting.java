package jobpost.framework.test;

import java.text.ParseException;
import java.util.List;

import jobpost.framework.base.TestBase;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class JobPosting extends TestBase {

	public static void main(String[] args) throws ParseException, InterruptedException {
		setUp();
		int totalJobs = jobsListPage.convertStringToInteger(jobsListPage.totalJobCount.getText());

		int runningSum = 0;
		if (runningSum != 0) {
			for (int m = 0; m < runningSum; m += 20) {
				jobsListPage.nextPageLink.click();
			}
		}

		for (int j = 0; j < totalJobs; j = runningSum) {

			int count = jobsListPage.getWebElementsList("div[class='job-title-text']").size();
			System.out.println(j + " - " + totalJobs + " - " + count);
			//
			for (int i = 0; i < count; i++) {
				List<WebElement> countList = jobsListPage.getWebElementsList("div[class='job-title-text']");
				countList.get(i).click();
				String winHandleBefore = driver.getWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}

				String email = null;
				try {
					email = bdJobsDetailPage.extractEmailFromText(bdJobsDetailPage.emailText.getText()).trim();
				} catch (Exception e) {
					// TODO: handle exception
				}

				String publishedDateString = "";
				try {
					publishedDateString = bdJobsDetailPage.publishDate.getText().split(":")[1].trim();
				} catch (Exception e) {
					
				}
				
				String startDate = "";
				try {
					startDate = bdJobsDetailPage.changeDateFormate(publishedDateString);
				} catch (Exception e) {
					
				}
				int diff = 0;
				try {
					diff = bdJobsDetailPage.differenceInDaysWithCurrentDate(startDate);
				} catch (Exception e) {
					
				}
				System.out.println(startDate +": "+ diff + ": " + publishedDateString + ", Email: " + email);

				if (diff <= 7) {
					if (email == null) {
						Thread.sleep(1000);
						driver.switchTo().defaultContent();
						driver.close();
						driver.switchTo().window(winHandleBefore);
						// bdJobsDetailPage.moveToSearchPageLink.click();

					} else {
						// String parentUrl = driver.getCurrentUrl();
						String companyName = "";
						try {
							companyName = bdJobsDetailPage.companyName.getText();
						} catch (Exception e) {
							
						}
						String jobPosition = "";
						try {
							jobPosition = bdJobsDetailPage.jobTitle.getText();
						} catch (Exception e) {
							
						}
						String jobType = "Full Time";
//						String categoryString = bdJobsDetailPage.jobCategory.getText().split(":")[1].trim();
						String jobCategory = "";
						try {
							jobCategory = bdJobsDetailPage.jobCategory.getText().split(":")[1].trim();
						} catch (Exception e) {
							
						}
						String education = "";
						try {
							education = bdJobsDetailPage.education.getText().replaceAll("Educational Requirements", "").trim();
						} catch (Exception e) {
							
						}
						
						String jobDescription = "";
						try {
							jobDescription = bdJobsDetailPage.jobDescription.getText().replaceAll("Job Description / Responsibility", "").trim();
//							System.out.println("experience: " + experience);
						} catch (Exception e) {
							jobDescription = "";
							// e.printStackTrace();
						}
						
						String experience = "";
						try {
							experience = bdJobsDetailPage.experience.get(1).getText().replaceAll("Experience Requirements", "").trim();
//							System.out.println("experience: " + experience);
						} catch (Exception e) {
							experience = "";
							// e.printStackTrace();
						}

						String additionalRequirements = "";
						try {
							additionalRequirements = bdJobsDetailPage.additionalRequirements.getText().replaceAll("Job Requirements", "").trim();
						} catch (Exception e) {
							additionalRequirements = "";
							// e.printStackTrace();
						}

						String salary = "";
						try {
							salary = bdJobsDetailPage.salary.getText().replaceAll("Salary Range", "").trim();
						} catch (Exception e) {
							salary = "";
							// e.printStackTrace();
						}

						String jobLocation = "";
						try {
							jobLocation = bdJobsDetailPage.jobLocation.getText().replaceAll("Job Location", "").trim();
						} catch (Exception e) {
							
						}

						String otherBenifit = "";
						try {
							otherBenifit = bdJobsDetailPage.otherBenifit.getText().replaceAll("Other Benefits", "").trim();
						} catch (Exception e) {
							otherBenifit = "";
							// e.printStackTrace();
						}

						String deadlineDateString = "";
						try {
							deadlineDateString = bdJobsDetailPage.deadline.getText().split(":")[1].trim();
						} catch (Exception e) {
							
						}
						String deadline = bdJobsDetailPage.changeDateFormate(deadlineDateString);
						
						System.out.println("jobLocation: " + jobLocation + "deadline: " + deadline + "email: " + email);

						String jobResponsibility = "";
						
						
						int noOfVacancy = 1;
						
						try {
							List<WebElement> jobDetailList = bdJobsDetailPage.getListOfWebElements("jr_text_d");
							if (bdJobsDetailPage.getElementIndexByName("No. of  Vacancies") != -1) {
								int index = bdJobsDetailPage.getElementIndexByName("No. of  Vacancies");
								noOfVacancy = bdJobsDetailPage.convertStringToInteger(jobDetailList.get(index).getText());
							}

							if (bdJobsDetailPage.getElementIndexByName("Job Description / Responsibility") != -1) {
								int index = bdJobsDetailPage.getElementIndexByName("Job Description / Responsibility");
								jobResponsibility = jobDetailList.get(index).getText();
							}
						} catch (Exception e) {
							
						}
						
						

						

						setUp2();
						eliteCareerJobPostPage.companyNameField.sendKeys(companyName);
						eliteCareerJobPostPage.jobPositionField.sendKeys(jobPosition);
						eliteCareerJobPostPage.selectFromDropdownList(eliteCareerJobPostPage.jobTypeDropDownList,
								jobType);
						eliteCareerJobPostPage.selectFromDropdownList(eliteCareerJobPostPage.jobLevelDropDownList,
								"Senior Level");

						if (jobPosition.contains("marketing") || jobPosition.contains("Marketing")
								|| jobPosition.contains("merchandiser") || jobPosition.contains("Merchandiser")
								|| jobPosition.contains("Merchandising") || jobPosition.contains("merchandising")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Marketing/Merchandising");
						} else if (jobPosition.contains("IE") || jobPosition.contains("ipe")
								|| jobPosition.contains("IPE") || jobPosition.contains("industrial engineering")
								|| jobPosition.contains("Industrial Engineering")
								|| jobPosition.contains("Industrial & Production Engineering")
								|| jobPosition.contains("industrial & production engineering")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList,
									"Industrial & Production Engineering");
						} else if (jobCategory.contains("Garments/Textile")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Garment/Textile");
						} else if (jobCategory.contains("General Management/Admin")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Admin/Management");
						} else if (jobCategory.contains("IT/Telecommunication")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Information Technology");
						} else if (jobCategory.contains("Marketing/Sales")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Marketing/Merchandising");
						} else if (jobCategory.contains("Accounting/Finance")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Account/Finance");
						} else if (jobCategory.contains("Commercial/Supply Chain")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Commercial/Supply Chain");
						} else if (jobCategory.contains("Engineer/Architect")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Engineering");
						} else if (jobCategory.contains("HR/Org. Development")) {
							eliteCareerJobPostPage
									.selectFromDropdownList(eliteCareerJobPostPage.jobCategoryDropDownList, "HR");
						} else if (jobCategory.contains("Design/Creative")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Design/Art");
						} else if (jobCategory.contains("Customer Support/Call Centre")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Call Center/Customer Support");
						} else if (jobCategory.contains("Medical/Pharma")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Doctor/Pharmaceutical/Nurse");
						} else if (jobCategory.contains("Education/Training")) {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Education");
						} else {
							eliteCareerJobPostPage.selectFromDropdownList(
									eliteCareerJobPostPage.jobCategoryDropDownList, "Garment/Textile");
						}

						String vacancy = eliteCareerJobPostPage.convertIntegerToString(noOfVacancy);
						eliteCareerJobPostPage.selectFromDropdownList(eliteCareerJobPostPage.noOfVacancyDropDownList,
								vacancy);
						eliteCareerJobPostPage.jobDescriptionField.sendKeys(jobDescription);
						eliteCareerJobPostPage.jobResponsibilityField.sendKeys(jobResponsibility);
						eliteCareerJobPostPage.educationRequirementField.sendKeys(education);
						eliteCareerJobPostPage.experienceRequirementField.sendKeys(experience);
						eliteCareerJobPostPage.additionalRequirementField.sendKeys(additionalRequirements);
						eliteCareerJobPostPage.salaryField.sendKeys(salary);
						eliteCareerJobPostPage.jobLocationField.sendKeys(jobLocation);
						eliteCareerJobPostPage.otherBenefitsField.sendKeys(otherBenifit);
						eliteCareerJobPostPage.applicationDeadlineField.sendKeys(deadline);
						eliteCareerJobPostPage.EmailField.sendKeys(email);
						eliteCareerJobPostPage.submitButton.click();

						tearDown2();
						driver.switchTo().defaultContent();

						System.out.println(
								email + " == " + i + " == " + jobCategory + " = " + companyName + " == " + jobPosition);
						// System.out.println(jobCategory+" == "+jobPosition);
						// driver.get(parentUrl);
						driver.close();
						driver.switchTo().window(winHandleBefore);
						// Thread.sleep(1000);
						// bdJobsDetailPage.moveToSearchPageLink.click();
					}
				} else {
					driver.close();
					driver.switchTo().window(winHandleBefore);
					// bdJobsDetailPage.moveToSearchPageLink.click();
				}

			}
			//
			jobsListPage.nextPageLink.click();
			runningSum += count;
		}

	}

}

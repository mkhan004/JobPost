package jobpost.framework.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBage extends TestBase{
	
	// Regx for Phone Number: "[(0-9)]{5}+\\-[0-9]{3}+\\-[0-9]{4}+"

	public String extractEmailFromText(String inputText){
		Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(inputText);
		String email = null;
		while (m.find()) {
	        email =  m.group();
	    }
	    return email;
	}
	
	public List<WebElement> getListOfWebElements(String className){
		List <WebElement> allElements = driver.findElements(By.className(className));		
		return allElements;
	}
	
	public List<WebElement> getWebElementsList(String css){
		List<WebElement> allElements = driver.findElements(By.cssSelector(css));		
		return allElements;
	}
	
	public List<WebElement> getListOfWebElementsEC(String selectorName){
		List <WebElement> allElements = driver3.findElements(By.cssSelector(selectorName));		
		return allElements;
	}
	
	public List<WebElement> getListOfWebElementsEC2(String selectorName){
		List <WebElement> allElements = driver3.findElements(By.xpath(selectorName));		
		return allElements;
	}
	
	public int getElementIndexByName(String elementName){
		int elementIndex = -1;
		List <WebElement> allFolders = driver.findElements(By.className("jr_text_s"));
		for(int i=0; i<allFolders.size(); i++){
			if(allFolders.get(i).getText().equalsIgnoreCase(elementName)){
				elementIndex = i;
			}
		}
		return elementIndex;
	}
	
	public Integer convertStringToInteger(String stringData){
		int integerValue = 1;
		try {
			integerValue = Integer.parseInt(stringData.split(" ")[0]);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return integerValue;
	}
	
	public String convertIntegerToString(Integer integerValue){
		String newString = String.valueOf(integerValue);
		return newString;
	}
	
	public void selectFromDropdownList(WebElement element, String value){
		new Select(element).selectByVisibleText(value);
	}
	
	public void goToPreviousPage(){
		driver.navigate().back();
	}
	
	public void goToPreviousPage2(){
		driver3.navigate().back();
	}
	
	public String changeDateFormate(String oldFormateString) throws ParseException{
		java.util.Date oldDate = new SimpleDateFormat("MMM dd, yyyy").parse(oldFormateString);
		String newDate = new SimpleDateFormat("yyyy-MM-dd").format(oldDate);
		return newDate;
	}
	
	public int differenceInDaysWithCurrentDate(String startDate) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateStop = format.format(date);
		long diff = format.parse(dateStop).getTime() - format.parse(startDate).getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		return (int) diffDays;
	}
}

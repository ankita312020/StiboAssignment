package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityFile extends BaseFile{
	// method to click on element using explicit wait
		public void clickOn(WebDriver driver, WebElement element, int timeout) {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
	
		static JavascriptExecutor js;

		public static void scroll(int x, int y) {
			
			 js = (JavascriptExecutor)driver;
			String scrollBy = "window.scrollBy("+x+","+y+")";
			js.executeScript(scrollBy, "");
		}
		
		public static void scrollIntoView(WebElement element) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].scrollIntoView(true);", element);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		public boolean tikMark(String compareTableCategory, String pricingPlan) {
			WebElement checkMark = driver.findElement(By.xpath("//div/p[contains(text(),'" +compareTableCategory+ "')]/../following-sibling::div/p/span[@data-pricingplan='" +pricingPlan+ "']/img[@decoding='async' and @src='https://business.udemy.com/wp-content/themes/udemy-business-child/images/checkmark.svg']"));
			return checkMark.isDisplayed()	;	
		}
		public boolean notTikMark(String compareTableCategory, String pricingPlan){
			WebElement dashIcon= driver.findElement(By.xpath("//div/p[contains(text(),'" +compareTableCategory+ "')]/../following-sibling::div/p/span[@data-pricingplan='" +pricingPlan+ "']/img[@decoding='async' and @src='https://business.udemy.com/wp-content/themes/udemy-business-child/images/dash-icon.svg']"));
			return dashIcon.isDisplayed();		
		}
		
		
		
		
}

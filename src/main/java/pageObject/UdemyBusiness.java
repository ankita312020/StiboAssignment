package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BaseFile;
import base.UtilityFile;

public class UdemyBusiness extends BaseFile{
	UtilityFile utils = new UtilityFile();
	@FindBy(xpath="//div[@role='alertdialog']//div[@id='onetrust-button-group']//button[contains(text(),'OK')]")
	private WebElement alertButton;
	
	@FindBy(xpath="//h2[@id='jv-adv-heading_36160e-a5']")
	private WebElement scrollBar;
	
	
	public void getScrollBar() {
		UtilityFile.scrollIntoView(scrollBar);
	}
	
	public void getAlertButton() {
		utils.clickOn(driver, alertButton, 10);
	}

}

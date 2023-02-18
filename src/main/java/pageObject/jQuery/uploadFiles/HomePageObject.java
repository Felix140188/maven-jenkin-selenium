package pageObject.jQuery.uploadFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileNameLoaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.UPLOAD_FILE_NAME, fileName);
		return isElementDisplayed(driver, HomePageUI.UPLOAD_FILE_NAME, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElements(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileNameUploaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.UPLOADED_FILE_NAME_LINK, fileName);
		return isElementDisplayed(driver, HomePageUI.UPLOADED_FILE_NAME_LINK, fileName);
	}

	public boolean isFileImageUploaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.UPLOADED_FILE_NAME_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUI.UPLOADED_FILE_NAME_IMAGE, fileName);
	}

}

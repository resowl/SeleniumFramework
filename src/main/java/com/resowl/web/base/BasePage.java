package com.resowl.web.base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLTableRowElement;

public class BasePage extends BaseTest {

	/**
	 * Wait Element
	 * 
	 * @param element
	 */
	public void waitElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * Click on element
	 * 
	 * @param element
	 */
	public void clickElement(WebElement element) {
		waitElement(element);
		element.click();
	}

	/**
	 * Insert text in input Actions performed are 1. Clear input 2. insert text
	 * 
	 * @param element
	 * @param text
	 */
	public void enterText(WebElement element, String text) {
		waitElement(element);
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Get value from a WebElement
	 * 
	 * @param element
	 * @return String
	 */
	public String getElementValue(WebElement element) {
		waitElement(element);
		return element.getText();
	}

	/**
	 * Check if element present
	 * 
	 * @param element
	 * @return
	 */
	public boolean elementPresent(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * Perform right click on the element
	 * 
	 * @param element
	 */
	public void rightClickElement(WebElement element) {
		waitElement(element);
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	/**
	 * Accept the alert
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * Verify if alert present on the page
	 * @return
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}
	
	/**
	 * Get Alert Message
	 * @return
	 */
	public String getAlertMessage() {
		if(isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		}else {
			return null;
		}
	}
	
	/**
	 * Select a value from a dropdown by value
	 * @param dropdownElement
	 */
	public void selectDdByValue(WebElement dropdownElement, String value) {
		Select dd = new Select(dropdownElement);
		dd.selectByValue(value);
	}
	
	/**
	 * Get selected value from dropdown
	 * @param dropdownElement
	 * @return
	 */
	public String getSelectedDropdownOption(WebElement dropdownElement) {
		Select dd = new Select(dropdownElement);
		WebElement option = dd.getFirstSelectedOption();
		return option.getText();
	}

}

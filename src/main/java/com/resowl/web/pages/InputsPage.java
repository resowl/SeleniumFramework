package com.resowl.web.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resowl.web.base.BasePage;

public class InputsPage extends BasePage{
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//LOCATORS
	/////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath = "//input[@type='number']")
	private WebElement numberInput;
	
	
	public InputsPage() {
		PageFactory.initElements(driver, this);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//GETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter for number input
	 * @return WebElement
	 */
	public WebElement getNumberInput() {
		return numberInput;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//ACTIONS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Insert value in the number input
	 * @param numberValue
	 */
	public void insertNumber(String numberValue) {
		enterText(getNumberInput(), numberValue);
	}
	
	/**
	 * Get Element value
	 * @return
	 */
	public int getNumberValue() {
		String value = getElementValue(getNumberInput());
		return Integer.parseInt(value);
	}
	

}

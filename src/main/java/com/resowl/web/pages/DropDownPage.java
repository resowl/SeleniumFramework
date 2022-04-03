package com.resowl.web.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resowl.web.base.BasePage;

public class DropDownPage extends BasePage {
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//LOCATORS
	/////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath = "//h3[text()='Dropdown List']")
	private WebElement pageHeader;
	
	@FindBy(id = "dropdown")
	private WebElement dropdown;
	
	public DropDownPage() {
		PageFactory.initElements(driver, this);
	}


	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//GETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Get Page Header
	 * @return
	 */
	public WebElement getPageHeader() {
		return pageHeader;
	}
	
	/**
	 * Get dropdown Element
	 * @return
	 */
	public WebElement getDropdown() {
		return dropdown;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//ACTIONS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Get header text
	 * @return String
	 */
	public String getHeaderText() {
		return getElementValue(getPageHeader());
	}
	
	/**
	 * Select value from dropdown
	 * @param value
	 */
	public void selectDropdownOption(String value) {
		selectDdByValue(getDropdown(), value);
	}
	
	/**
	 * Get selected value from dropdown
	 * @return
	 */
	public String getDropdownValue() {
		return getSelectedDropdownOption(getDropdown());
	}

}

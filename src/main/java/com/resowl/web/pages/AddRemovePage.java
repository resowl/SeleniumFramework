package com.resowl.web.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resowl.web.base.BasePage;

public class AddRemovePage extends BasePage{
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//LOCATORS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//button[text()='Add Element']")
	WebElement addElementButton;
	
	@FindBy(xpath = "//button[text()='Delete']")
	List<WebElement> deleteButtons;

	public AddRemovePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//GETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Get Delete button
	 * @return List<WebElement>
	 */
	public List<WebElement> getDeleteButtons() {
		return deleteButtons;
	}

	/**
	 * Get add element button
	 * @return WebElement
	 */
	public WebElement getAddElementButton() {
		return addElementButton;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//ACTIONS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Click on add element button
	 */
	public void clickAddElementButton() {
		clickElement(getAddElementButton());
	}
	
	/**
	 * Get number of delete buttons on the page
	 * @return int
	 */
	public int getDeleteButtonCount() {
		return getDeleteButtons().size();
		
	}
	
	/**
	 * Click on delete button based on the index
	 * @param index
	 */
	public void clickDeleteButton(int index) {
		clickElement(getDeleteButtons().get(index));
	}
	
	

}
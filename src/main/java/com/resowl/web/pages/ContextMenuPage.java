package com.resowl.web.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resowl.web.base.BasePage;

public class ContextMenuPage extends BasePage{
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//LOCATORS
	/////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath = "hot-spot")
	private WebElement hotspot;
	
	@FindBy(xpath = "//h3[text()='Context Menu']")
	private WebElement pageHeader;
	
	
	public ContextMenuPage() {
		PageFactory.initElements(driver, this);
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//GETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter for the hotspot
	 * @return WebElement
	 */
	public WebElement getHotspot() {
		return hotspot;
	}
	
	/**
	 * Getter for page header
	 * @return WebElement
	 */
	public WebElement getPageHeader() {
		return pageHeader;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//ACTIONS
	/////////////////////////////////////////////////////////////////////////////////////////////
	

	/**
	 * Right click on the hot spot of the 
	 */
	public void rightClickHotspot() {
		rightClickElement(getHotspot());
	}
	
	/**
	 * Get header text
	 * @return
	 */
	public String getHeaderText() {
		return getElementValue(getPageHeader());
	}
	
	/**
	 * Accept Context Menu
	 */
	public void acceptContextMenuAlert() {
		acceptAlert();
	}
	

}

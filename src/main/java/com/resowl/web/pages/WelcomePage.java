package com.resowl.web.pages;

import java.awt.Checkbox;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resowl.web.base.BasePage;

public class WelcomePage extends BasePage {

	/////////////////////////////////////////////////////////////////////////////////////////////
	//LOCATORS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(linkText = "Add/Remove Elements")
	private WebElement addRemoveElementLink;

	@FindBy(linkText = "Checkboxes")
	private WebElement checkboxesLink;
	
	@FindBy(linkText = "Inputs")
	private WebElement inputsLink;
	
	@FindBy(linkText = "Context Menu")
	private WebElement contextMenuLink;
	
	@FindBy(linkText = "Dropdown")
	private WebElement dropdownLink;

	@FindBy(linkText = "File Upload")
	private WebElement fileUploadLink;
	
	@FindBy(linkText = "Form Authentication")
	private WebElement formAuthenticationLink;
	
	
	
	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//GETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Getter for add remove link
	 * 
	 * @return WebElement
	 */
	public WebElement getAddRemoveElementLink() {
		return addRemoveElementLink;
	}

	/**
	 * Gettter for checkbox link
	 * 
	 * @return WebElement
	 */
	public WebElement getCheckboxesLink() {
		return checkboxesLink;
	}
	
	/**
	 * Getter for input link
	 * @return WebElement
	 */
	public WebElement getInputsLink() {
		return inputsLink;
	}
	
	/**
	 * Getter for context menu link
	 * @return WebElement
	 */
	public WebElement getContextMenuLink() {
		return contextMenuLink;
	}
	
	/**
	 * Getter for dropdown link
	 * @return WebElement
	 */
	public WebElement getDropdownLink() {
		return dropdownLink;
	}

	/**
	 * Getter for file upload link
	 * @return WebElement
	 */
	public WebElement getFileUploadLink() {
		return fileUploadLink;
	}

	/**
	 * Getter for form authentication
	 * @return WebElement
	 */
	public WebElement getFormAuthenticationLink() {
		return formAuthenticationLink;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//ACTIONS
	/////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * CLick on add remove element link
	 * 
	 * @return AddRemovePage
	 */
	public AddRemovePage clickAddRemoveElement() {
		clickElement(getAddRemoveElementLink());
		return new AddRemovePage();
	}
	
	/**
	 * Click on checkbox link
	 * @return CheckboxPage
	 */
	public CheckboxPage clickCheckboxesLink() {
		clickElement(getCheckboxesLink());
		return new CheckboxPage();
	}
	
	/**
	 * Click on inputs page
	 * @return InputsPage
	 */
	public InputsPage clickInputsLink() {
		clickElement(getInputsLink());
		return new InputsPage();
	}
	
	/**
	 * Click on context menu link
	 * @return ContextMenuPage
	 */
	public ContextMenuPage clickContextMenuLink() {
		clickElement(getContextMenuLink());
		return new ContextMenuPage();
	}
	
	/**
	 * Click on dropdown link
	 * @return DropDownPage
	 */
	public DropDownPage clickDropdownLink() {
		clickElement(getDropdownLink());
		return new DropDownPage();
	}
	
	/**
	 * Click on the file upload link
	 * @return FileUploadPage
	 */
	public FileUploadPage clickFileUploadLink() {
		clickElement(getFileUploadLink());
		return new FileUploadPage();
	}
	
	/**
	 * Click on form authentication link
	 * @return FormLoginPage
	 */
	public FormLoginPage clickFormAuthnticationLink() {
		clickElement(getFormAuthenticationLink());
		return new FormLoginPage();
	}


	

	

}
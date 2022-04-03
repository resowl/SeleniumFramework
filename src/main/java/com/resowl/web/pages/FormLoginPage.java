package com.resowl.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resowl.web.base.BasePage;

public class FormLoginPage extends BasePage{
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//LOCATORS
	/////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath = "//h2[text()='Login Page']")
	private WebElement pageHeader;
	
	@FindBy(id = "username")
	private WebElement usernameInput;
	
	@FindBy(id = "password")
	private WebElement pwInput;
	
	@FindBy(xpath = "//i[text()=' Login']")
	private WebElement loginButton;
	
	@FindBy(id = "flash")
	private WebElement flashMsg;
	
	public FormLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//GETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Get Page Header
	 * @return WebElement
	 */
	public WebElement getPageHeader() {
		return pageHeader;
	}
	
	/**
	 * Getter for username input
	 * @return WebElement
	 */
	public WebElement getUsernameInput() {
		return usernameInput;
	}


	/**
	 * Getter for password Input
	 * @return
	 */
	public WebElement getPwInput() {
		return pwInput;
	}
	
	/**
	 * Getter for login button
	 * @return WebElement
	 */
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * Getter for the flash message
	 * @return WebElement
	 */
	public WebElement getFlashMsg() {
		return flashMsg;
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
	 * Enter username
	 * @param username
	 */
	public void enterUsername(String username) {
		enterText(getUsernameInput(), username);
	}
	
	/**
	 * Enter password
	 * @param password
	 */
	public void enterPw(String password) {
		enterText(getPwInput(), password);
	}
	
	/**
	 * Click on the login button
	 */
	public void clickLoginButton() {
		clickElement(getLoginButton());
	}
	
	/**
	 * Perform Login Operation
	 * @param username
	 * @param password
	 */
	public void performLogIn(String username, String password) {
		enterUsername(username);
		enterPw(password);
		clickLoginButton();
	}
	
	/**
	 * Get flash message
	 * @return String
	 */
	public String getFlashMessage() {
		return getElementValue(getFlashMsg());
	}
	
	
	
	

}

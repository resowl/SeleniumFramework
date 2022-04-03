package com.resowl.web.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resowl.web.base.BasePage;

public class CheckboxPage extends BasePage{
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//LOCATORS
	/////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath = "//input[@type='checkbox']")
	private List<WebElement> checkBoxes;
	
	
	public CheckboxPage() {
		PageFactory.initElements(driver, this);
	}

	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//GETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter for checkboxes on the page
	 * @return list of WebElement
	 */
	public List<WebElement> getCheckBoxes() {
		return checkBoxes;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//ACTIONS
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Get state of the checkboxes
	 * @return array of boolean containing state of the checkbox
	 * true represents checkbox checked
	 * false represents checkbox unchecked
	 */
	public boolean[] getCheckBoxesState() {
		boolean[] result = new boolean[getCheckBoxes().size()];
		for (int i = 0; i < getCheckBoxes().size() ; i++) {
			if(getCheckBoxes().get(i).isSelected()) {
				result[i] = true;
			}
		}
		System.out.println(Arrays.toString(result));
		return result;
	}
	
	/**
	 * Toggle checkboxes
	 * It will toggle the state of all the checkboxes available on the page
	 */
	public void toggleCheckBoxes() {
		for (WebElement we : getCheckBoxes()) {
			clickElement(we);
		}
	}
	


}

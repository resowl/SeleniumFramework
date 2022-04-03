package com.resowl.web.functional;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.resowl.web.base.BaseTest;
import com.resowl.web.pages.CheckboxPage;
import com.resowl.web.pages.DropDownPage;
import com.resowl.web.pages.WelcomePage;

public class DropdownTest extends BaseTest{
	
	DropDownPage dropDownPo; 
	
	public DropdownTest() throws IOException {
		super();
	}
	
	@Parameters({ "browser"})
	@BeforeClass(alwaysRun = true)
	public void beforeClass(String browser) {
		String className = this.getClass().getSimpleName();
		initialization(browser);
		driver.get(getUrl());
	}
	
	@Test(priority = 1)
	public void testDropdownNavigation() {
		WelcomePage welcomePo = new WelcomePage();
		dropDownPo = welcomePo.clickDropdownLink();
		Assert.assertEquals(dropDownPo.getHeaderText(),"Dropdown List");
	}
	
	@Test(priority = 2)
	public void testDropdownOption() {
		dropDownPo.selectDropdownOption("1");
		System.out.println(dropDownPo.getDropdownValue());
		Assert.assertEquals(dropDownPo.getDropdownValue(), "Option 1");
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}

package com.resowl.web.functional;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.resowl.web.base.BaseTest;
import com.resowl.web.pages.CheckboxPage;
import com.resowl.web.pages.WelcomePage;

public class CheckboxTest extends BaseTest{
	
	CheckboxPage checkboxPo;
	
	public CheckboxTest() throws IOException {
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
	public void testCheckboxesState() {
		WelcomePage welcomePo = new WelcomePage();
		checkboxPo = welcomePo.clickCheckboxesLink();
		boolean checkboxState[] = checkboxPo.getCheckBoxesState();
		boolean[] expectedState = { false, true};
		Assert.assertEquals(checkboxState,expectedState);
	}
	
	@Test(priority = 2)
	public void testToggleCheckboxes() {
		checkboxPo.toggleCheckBoxes();
		boolean checkboxState[] = checkboxPo.getCheckBoxesState();
		boolean[] expectedState = { true, false};
		Assert.assertEquals(checkboxState,expectedState);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}

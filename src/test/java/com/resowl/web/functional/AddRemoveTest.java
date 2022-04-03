package com.resowl.web.functional;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.resowl.web.base.BaseTest;
import com.resowl.web.pages.AddRemovePage;
import com.resowl.web.pages.WelcomePage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class AddRemoveTest extends BaseTest {
	
	AddRemovePage addRemovePo;

	public AddRemoveTest() throws IOException {
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
	public void testAddElements() {
		WelcomePage welcomePo = new WelcomePage();
		addRemovePo = welcomePo.clickAddRemoveElement();
		addRemovePo.clickAddElementButton();
		int deleteButtonCount = addRemovePo.getDeleteButtonCount();
		Assert.assertEquals(deleteButtonCount, 1);
		test.log(LogStatus.PASS, "Navigated to the specified URL");
	}

	@Test(priority = 2)
	public void testDeleteElements() {
		addRemovePo.clickDeleteButton(0);
		int deleteButtonCount = addRemovePo.getDeleteButtonCount();
		Assert.assertEquals(deleteButtonCount, 0);
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	

}

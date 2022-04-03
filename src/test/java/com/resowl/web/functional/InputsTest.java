package com.resowl.web.functional;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.resowl.web.base.BaseTest;
import com.resowl.web.pages.AddRemovePage;
import com.resowl.web.pages.InputsPage;
import com.resowl.web.pages.WelcomePage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class InputsTest extends BaseTest {
	
	InputsPage inputPo;

	public InputsTest() throws IOException {
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
	public void testInputPageNevigation() {
		WelcomePage welcomePo = new WelcomePage();
		inputPo = welcomePo.clickInputsLink();
	}

	@Test(priority = 2)
	public void testInputEntry() {
		inputPo.insertNumber("5");
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	

}

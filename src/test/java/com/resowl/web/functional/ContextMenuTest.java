package com.resowl.web.functional;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.resowl.web.base.BaseTest;
import com.resowl.web.pages.AddRemovePage;
import com.resowl.web.pages.ContextMenuPage;
import com.resowl.web.pages.InputsPage;
import com.resowl.web.pages.WelcomePage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

/**
 * TODO: Right click not working.  
 * @author Vasav
 *
 */
public class ContextMenuTest extends BaseTest {
	
	ContextMenuPage contextMenuPo;

	public ContextMenuTest() throws IOException {
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
	public void testContextMenuNevigation() {
		WelcomePage welcomePo = new WelcomePage();
		contextMenuPo = welcomePo.clickContextMenuLink();
		Assert.assertEquals(contextMenuPo.getHeaderText(), "Context Menu");
	}

	@Test(priority = 2)
	public void testContextMenu() {
		contextMenuPo.rightClickHotspot();
		System.out.println(contextMenuPo.getAlertMessage());
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	

}

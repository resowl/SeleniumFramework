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
import com.resowl.web.pages.FormLoginPage;
import com.resowl.web.pages.WelcomePage;

/*
 * TODO: Use excel to get data
 */
public class FormAuthenticationTest extends BaseTest{
	
	FormLoginPage formLoginPo; 
	
	public FormAuthenticationTest() throws IOException {
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
	public void testLoginPageNavigation() {
		WelcomePage welcomePo = new WelcomePage();
		formLoginPo = welcomePo.clickFormAuthnticationLink();
		Assert.assertEquals(formLoginPo.getHeaderText(),"Login Page");
	}
	
	@Test(priority = 2)
	public void testIncorrectUsername() {
		formLoginPo.performLogIn("tomsmith 123", "SuperSecretPassword!");
		Assert.assertEquals(formLoginPo.getFlashMessage().contains("Your username is invalid!"), true);
	}
	
	@Test(priority = 3)
	public void testIncorrectPassword() {
		formLoginPo.performLogIn("tomsmith", "SuperSecretPassword! 123");
		Assert.assertEquals(formLoginPo.getFlashMessage().contains("Your password is invalid!"), true);
	}
	
	@Test(priority = 4)
	public void testLogin() {
		formLoginPo.performLogIn("tomsmith", "SuperSecretPassword!");
		Assert.assertEquals(formLoginPo.getFlashMessage().contains("You logged into a secure area!"), true);
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}

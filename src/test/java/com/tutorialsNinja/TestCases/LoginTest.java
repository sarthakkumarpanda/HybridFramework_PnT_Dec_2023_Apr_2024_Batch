package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsNinja.Pages.AccountPage;
import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.LoginPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.TestData.ExcelCode;
import com.tutorialsNinja.Utilities.Util;

public class LoginTest extends TestBase{
	
	public LoginTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public AccountPage accountpage;
	
	@BeforeMethod
	public void loginSetup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		loginpage = homepage.combiningTwoActionsToNavigateToLoginPage();
	}
	
	@Test(priority=1, dataProvider = "TNLogin", dataProviderClass = ExcelCode.class)
	public void verifyLoginWithValidCredentials(String email, String password) {
		accountpage = loginpage.navigateToLoginPageByCombining3Actions(email, password);
		Assert.assertTrue(accountpage.validateDisplayStatusOfLogoutLink());
	}
	
	@Test(priority=2)
	public void verifyLoginWithValidEmailInvalidPassword() {
		loginpage.navigateToLoginPageByCombining3Actions(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));	
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailValidPassword() {
		loginpage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));	
	}

	@Test(priority=4)
	public void verifyLoginWithInvalidCredentials() {
		loginpage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));	
	}
	
	@Test(priority=5)
	public void verifyLoginWithNoCredentials() {
		loginpage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

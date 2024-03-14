package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//in the Page class, we will define the WebElements, we will initialize the WebElements and we will create actions for those WebElements
	
	public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions to call these Object in the form of methods

	
	public LoginPage combiningTwoActionsToNavigateToLoginPage() {
		myAccountDropdown.click();	
		loginOption.click();
		return new LoginPage(driver);		
	}
	
	public RegisterPage combiningTwoActionsToNavigateToRegisterPage() {
		myAccountDropdown.click();	
		registerOption.click();
		return new RegisterPage(driver);		
	}
	
	public void enterProductName(String validProductText) {
		searchBox.sendKeys(validProductText);
	}
	
	public ProductPage clickOnSearchButton() {
		searchButton.click();
		return new ProductPage(driver);
	}
	
	public ProductPage navigateToProductPage(String validProductText) {
		searchBox.sendKeys(validProductText);
		searchButton.click();
		return new ProductPage(driver);
	}
}

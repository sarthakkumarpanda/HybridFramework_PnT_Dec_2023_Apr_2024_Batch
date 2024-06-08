package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//h2[text() = '$122.00']") //this is your assignment
	private WebElement priceOfLaptop;
	
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean displayStatusOfLaptopPrice() {
		boolean display = priceOfLaptop.isDisplayed();
		return display;
	}

}

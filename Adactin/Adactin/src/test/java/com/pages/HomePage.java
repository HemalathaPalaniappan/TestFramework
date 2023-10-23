package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.step.Hooks;
import com.utilities.BaseClass;

//import com.utilities.BaseClass;

public class HomePage extends BaseClass{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement username_homePage;

	public WebElement getUserNameHomePage() {
		return username_homePage;
	}
	
	
	
}

package com.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.BaseClass;

public class LoginPage extends BaseClass{
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement userNameField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id = "login")
	private WebElement loginButton;
	
	@FindBy(className = "auth_error")
	private WebElement errorMessage;
	
	@FindBy(id="username_span")
	private WebElement userNameLoginError;
	
	@FindBy(id="password_span")
	private WebElement passwordLoginError;

	public WebElement getUserName() {
		return userNameField;
	}

	public WebElement getPassword() {
		return passwordField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getErrorMessage() {
		return errorMessage;
	}
	
	public WebElement getUserNameErrorMsg() {
		return userNameLoginError;
	}
	
	public WebElement getPasswordErrorMsg() {
		return passwordLoginError;
	}
	
	

}

package com.step;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.Utilities;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends Utilities{
	
	LoginPage loginpage= new LoginPage();
	HomePage homepage = new HomePage();
	
	@Given("User is on Adactin login page")
	public void user_is_on_adactin_login_page() {
		LaunchUrl("https://adactinhotelapp.com/");
	}
	@When("User enter the username and password")
	public void user_enter_the_username_and_password(DataTable usercredentials) throws IOException, InterruptedException {
		List<Map<String, String>> user = usercredentials.asMaps(String.class, String.class);
        for (Map<String, String> form : user) {
		enterText(loginpage.getUserName(), form.get("UserName"));
		enterText(loginpage.getPassword(), form.get("Password"));
        }
	}
	
	@When("User enter {string} and {string} in the field")
	public void i_enter_username_password_in_the_field(String username, String password) {
		enterText(loginpage.getUserName(), username);
		enterText(loginpage.getPassword(), password);
	}
	
	@When("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		click(loginpage.getLoginButton());
		Thread.sleep(3000);
	}

	@Then("I verify username is displayed on the homepage")
	public void verify_username_is_displayed_on_homepage() throws IOException {
		Assert.assertTrue(getValueAttribute(homepage.getUserNameHomePage(), "value").contains(propertyFile("username")));
	}
	
	@Then("I verify Error Message is displayed on homepage")
	public void verify_error_message_is_displayed_on_homepage() {
		elementDisplayed(loginpage.getErrorMessage());
		Assert.assertTrue(getElementText(loginpage.getErrorMessage()).contains("Invalid Login details"));
	}
	
	@Then("I verify Error Message is displayed if user does not enter anything {string} field")
	public void verify_error_message_is_displayed_blank_field(String field) {
		if(field.equalsIgnoreCase("username") || field.equalsIgnoreCase("user_pass")) {
		elementDisplayed(loginpage.getUserNameErrorMsg());
	}else if(field.equalsIgnoreCase("password")) {
		elementDisplayed(loginpage.getPasswordErrorMsg());
	}
	}
}

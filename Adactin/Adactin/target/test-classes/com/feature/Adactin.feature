@AdactInLogin
Feature: Verify Adactin Application functionality

Background:
	Given User is on Adactin login page

Scenario: Verify user can able to login with valid credential on Adactin Application
	When User enter the username and password
		|UserName|Password|
		|hemapalani|hema@123|
	And User clicks on login button
	Then I verify username is displayed on the homepage

Scenario Outline: Verify Error Message is displayed when user logged in with invalid credential on Adactin Application
	When User enter "<UserName>" and "<Password>" in the field
	And User clicks on login button
	Then I verify Error Message is displayed on homepage
	
	Examples:
	|UserName|Password|
	|Test123|he*#$ma |
	|Test@%^345|Test643|
	|234546|64674|
	|*(($! | 349*$)# |
	
Scenario Outline: Verify Error Message is displayed when user did not enter anything on any one of the field or both
	When User enter "<UserName>" and "<Password>" in the field
	And User clicks on login button
	Then I verify Error Message is displayed if user does not enter anything "<ErrorField>" field
		
	Examples:
	|UserName|Password|ErrorField|
	| | hema@123|UserName|
	|hemapalani|  | Password|
	|  |  |User_Pass|
Feature: Add Owner

	Background: To Launch the browser
		Given Launch the browser
		
	Scenario: Add New Owner
		When Open Spring Clinic on the browser
		And Click The Find Owner Button
		When Click The Add Owner Button
		And Fill Owner Info
		And Click The Add Inside Owner Button
		Then Check Find New Owner Info
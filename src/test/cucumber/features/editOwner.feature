Feature: Edit Owner

	Background: To Launch the browser
		Given Launch the browser1
		When Add New Owner1
		
	Scenario: Edit Just Added Owner
		When Click Edit Owner Button
		And Clear Address Info
		When Write New Address Info
		And Click Update Owner Button
		Then Check The Address is Updated
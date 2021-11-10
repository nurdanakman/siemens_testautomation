Feature: Edit Pet

	Background: To Launch the browser
		Given Launch the browser2
		When Add New Owner2
		
	Scenario: Add New Pet
		When Click Add New Pet Button
		And Write New Pet Info
		When Select Pet Type in DropDown
		And Click Add Pet Button
		Then Check The Added Pet Info
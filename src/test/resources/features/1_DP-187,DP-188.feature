@DP-186 @ISQADEMO @iOS
Feature: ISQA DEMO

	@TEST_DP-187 @Positive @iOS
	Scenario: [ISQA][DEMO] User buy product
		Given User click one of list product
		When User add "4" product
		And User click add to cart button
		And User click cart menu
		And User click checkout button
		And User click autofill account
		And User click login button
		And User input fullname "Fransiskus Andika"
		And User input address line 1 "Menara Standard Chartered"
		And User input city "Jakarta Selatan"
		And User input state/region "DKI Jakarta"
		And User input zip code "12345"
		And User input country "Indonesia"
		And User click to payment button
		And User input card fullname "Fransiskus Andika"
		And User input card number "4012888888881881"
		And User input expiration date "03/25"
		And User input security code "321"
		And User click review order
		And User click place order button
		Then User success order product
	@TEST_DP-188 @Negative @iOS
	Scenario: [ISQA][DEMO] User buy product and input blank data
		Given User click one of list product
		When User add "4" product
		And User click add to cart button
		And User click cart menu
		And User click checkout button
		And User click autofill account
		And User click login button
		And User click to payment button
		Then User see alert "Please provide your full name"

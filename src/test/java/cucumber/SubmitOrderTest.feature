Feature: Purchase the order from Ecomerse website


Background:
Given I landed on Ecomerse website with "Ravi" "jagtap"

@tag2
Scenario: Create user in Ecomerse website

Given Create an account by entering details 
When Fill all details of username and  click register
And validate currect username and surname is display
Then click on logout


     
     
Scenario: Create user in Ecomerse website

Given login with username and password 
When Add a product to the cart
And Proceed to the checkout page and continue till payments
Then Validate on the payments page is the product details are correct.



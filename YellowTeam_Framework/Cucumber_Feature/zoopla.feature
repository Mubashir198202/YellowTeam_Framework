Feature: Zoopla users can buy the property and sale the property

Scenario Outline: User able to successfully login and Verify the home page

Given As a User I can Open any Browser
And As a User I can enter "https://www.zoopla.co.uk/"
And As a User I can clik on the  Sign in button
And As a user I can enter Valid "<userName>" and "<passWord>"
And As a user I can clik the Sign in button
And As a user I am able to verify the title "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents"
When As a user I am able to write Newyork, Lincolnshire 
And As a user I am able to click Search button
And As a user I am able to Print all the price values in sorted order (descending order)
And As a user I am able to click on fifth property from list
And As a user I am able to verify the logo, name and telephone number of the agent "Logo,Agent name,phone number"
And As a user I am able to click on MyZoopla
And As a user I am able to clik on signout button
Then As a user I am able to verify the logout title "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents"
And As a user I able to close browser

Examples: 
 |userName                |passWord         |
 |marupon76@gmail.com     |Rupon123456      |
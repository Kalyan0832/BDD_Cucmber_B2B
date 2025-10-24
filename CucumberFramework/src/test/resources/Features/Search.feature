Feature:Login to the application

@smoke
@sanity
Scenario Outline:
User should able to search for products
Given Launch browser and enter url
And login page is displayed
When Enter <UserName> and <password>

|Username						|password|
|pavankalyansattu@gmail.com		|Kalyan@0832|

And Click on enter
And  User should be logged in
And Homepage should be displayed
When Search for products "<productName>"
Then Page should be displayed

Examples:

|	productName 	|
|	Mobiles 		|
|	Laptops			|
|	Mobiles			|

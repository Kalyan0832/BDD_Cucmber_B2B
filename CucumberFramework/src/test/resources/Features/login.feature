Feature:Login to the application

@smoke
@sanity
Scenario: User should able to login with 
Given Launch browser and enter url
And login page is displayed
When Enter <UserName> and <password>

|Username						|password|
|pavankalyansattu@gmail.com		|Kalyan@0832|

And Click on enter
Then User should be logged in
And Homepage should be displayed
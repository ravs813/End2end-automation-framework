Feature: Application Login


Scenario Outline: Positive login validation 
Given Intialize the browser with chrome
And Navigate to "http://QAClickAcademy.com" site
And Click on Login link in home page to land on Secure sign in page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And close the browser


Examples: 
|username        |password |
|test99@gmail.com|123456   |
|test12@gmail.com|12345    |

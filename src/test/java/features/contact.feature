Feature: QT testcase

Scenario Outline: login to the application

Given Initialize the browser with chrome
And Navigate to "https://qtrecognition.testqtwiz.com/" site
When User enters <Username> and <password>
Then click on login

Examples:
|Username									|password		|
|test1										|test2			|
|aishwarya.kurkoti@qualitestgroup.com		|P@ssw0rd		|
# Test Plan

|ID|Description|Expected|Result| 
|---|----------|------------|------------|
|T01_H01| 	No access should be allowed without login|	Invalid login credentials must restrict login|passed| 
|T02_H02| 	Application must serve multiple purposes|	Application should have more than one functionality|passed| 
|T03_H03| 	App must give options for login, register and exit|	Menu should be displayed to user having options of login, register and exit|passed| 
|T03_H03_L01| 	App must register the user|	App must take user data and write to a file|passed| 
|T03_H03_L02| 	App must login the user|	App must take user data and verify against user file and allow login if credentials match|passed|
|T03_H04| 	App must provide basic banking services after login|	After login, user is provided with a menu of basic banking operations|passed| 
|T04_H05_L01| 	User must be able to see account details|Users account details are shown when user wants to see|passed| 
|T04_H05_L02| 	User must be able to perform transactions|	User can deposit or withdraw money in their account|passed| 
|T04_H05_L03| 	User must be able to see available balance|	User’s account balance must be shown|passed| 


Summary:


This application will allow a user the ease and ability to manage their budget through a 9-category allocation system. Through the interface the user will determine the percentage of their income they would like to allocate to each category. After these determinations are made, the user can enter all income and expenditures made and the category totals will update to let the user know how much they have left to spend in each area.



Motivation:

Over the years I have refined my own budgeting tools via excel and I am interested to take that tool to the next level by developing a desktop application connected to a mySQL database that stores a users financial activity securely on their personal computer.


User Interface:

The user interface will be made through JavaFX and will present the user with a simple experience along with exhibiting budget system functionality.

I have 3 months of experience using JavaFX and have built two other applications using JavaFX. For this project I would like to incorporate CSS with my JavaFX build to flesh out the user experience. I have started a basic skeleton of the project to exhibit this skillset: Untitled video - Made with Clipchamp (2).mp4

The user interface will include the following features: 


	
A login screen -> Budget Overview
	
4 different screen navigation options on Budget Overview screen:
	

		
Transaction Overview (see all transactions via a table view)
		
Enter Expenditure (simple screen to enter/update expenditures)
		
Enter Income (simple screen to enter/update income)
		
Set Allocations (screen to set allocation percentages)
	
	



External Services or data:

To exhibit data persistence the data entered will be stored in a mySQL database that is configured to hold the income/expenditure information. The allocation information will be pulled from the database on initialization and stored in an ObservableArray to be presented through the UI upon login,  the database will be queried as it's necessary to present past transaction data to the user while they navigate through the application. Due to financial regulations the app will not connect to or pull data directly from the user's bank account. 


Edited

Team Member: Daniel An
# Project: Budgeteering
## Description

This application will allow a user the ease and ability to manage their budget through a 9-category allocation system. Through the interface the user will determine the percentage of their income they would like to allocate to each category. After these determinations are made, the user can enter all income and expenditures made and the category totals will update to let the user know how much they have left to spend in each area.

### Motivation

Over the years I have refined my own budgeting tools via excel and I am interested to take that tool to the next level by developing a desktop application connected to a mySQL database that stores a users financial activity securely on their personal computer.

### User Experience

- The user interface will include the following features:

- A login screen -> Budget Overview

- 4 different screen navigation options on Budget Overview screen:

  - Transaction Overview (see all transactions via a table view)

  - Enter Expenditure (simple screen to enter/update expenditures)

  - Enter Income (simple screen to enter/update income)

  - Set Allocations (screen to set allocation percentages)

## Technology Used

- JavaFX
- SceneBuilder
- Maven
- JUnit

## Installation

- Ensure Java is installed on device, (App uses on Java 11)
- Install latest version of JavaFX, (App is run on JavaFX SDK 18.0.1)
- Configure your current editor to have javafx run configurations

## First Use Instruction

- Register a username/password
- Set allocations first and foremost (this needs to add to 100% there will be an alert)
- Enter transactions (either an income or expenditure)
  - Do not enter any negative values, income will be positive and expenditure will be negative)
- Happy Budgeting!

## Project Overview

- [Project Worksheet](planning/project-worksheet.md)

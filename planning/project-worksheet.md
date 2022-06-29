# Project Overview

## Project Description

This application is meant to model the envelope system as presented by Dave Ramsey's financial solutions. These envelopes
are represented in the application as buckets. 
Each bucket in the display represents an area of the users finances that they need to plan for and allocate funds to. 
These allocations are made through determining the percentage of the user's income that they plan on allocating. For example
it's suggested that the average american should have a mortgage or rent that is 30% of their income. If this was the case
the user would use an allocation screen to set this value so as they input their income values the buckets show how much they 
have saved for their mortgage.

## UML

- []()

## MVP/Post MVP
#### MVP

Enter Brief Description here
- 1 registered user will be able to log in and log out with saved data
- User will be able to set income allocation percentages for budgeting
- The home screen/Budget Overview will list budget categories and respective amount of funds left to use
- User will be able to create transactions, (either income or expenditure), updating account total
- User will be able to delete transactions and update account total.

#### PostMVP

- Validation for log-in
- Add an allocation total text field that shows allocation
- Transition data towards a SQL database
- Add Update functionality for transactions

## Models and Controllers

| Models(MVP)  | Description |
|--------------|:-----------:|
| User         |             |
| Users        |             |
| BankAccount  |             |
| Bucket       |             |
| Buckets      |             |
| BucketType   |             |
| Transaction  |             |
| Transactions |             |


| Controllers          |                     Description                     |
|----------------------|:---------------------------------------------------:|
| BudgetOverview       |  List of all buckets that the budget incorporates   |
| EnterTransaction     | Separate view to enter in an income or expenditure  |
| LoginScreen          | First page on load for users to log-in and register |
| SetBudgetBuckets     |     Setting allocation percentages for buckets      |
| Transaction Overview |     List of all transactions User has inputted      |

#### Time Table

| Component        | Priority | Estimated Time | Time Invested |
|------------------|:--------:|:--------------:|:-------------:|
| Modeling         |    H     |      24H       |      29H      |
| View Controllers |    H     |                |               |
| UI Development   |    H     |      15H       |      20H      |
| Total(MVP)       |    H     |                |               |
| Total(PostMVP)   |    L     |                |               |

## Technology Used

- JavaFX
- Scene Builder
- JUnit5
- Maven

## Additional Libraries

- [JavaFX Download](https://gluonhq.com/products/javafx/)
- [JavaFX Docs](https://docs.oracle.com/javafx/2/api/overview-summary.html)
- [SceneBuilder](https://gluonhq.com/products/scene-builder/)
- [JUnit](https://junit.org/junit5/docs/current/user-guide/)
- [Maven](https://maven.apache.org/)

## Future Changes

- Transition all data to SQL database
- Enable multiple Users and Authentication for each
- Publish the Application

## Code Snippet

```

```

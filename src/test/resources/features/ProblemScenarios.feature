Feature: Problem Feature

  1. Problem 1 - Regression script contains a happy flow end to end test that includes SI Manager RBACS and Known Error Creation and Closure
  2. Problem 2 - Regression script contains a negative flow end to end test that includes the following:
                  - Problem User RBACS
                  - Problem Task Rejection
                  - Known Error Creation and Closure
  3. Problem 3 - Regression script contains a negative flow end to end test that includes SD Problem Manager RBACS, Problem Task Rejection and Re-opening a Problem record.

  Scenario: Problem 1
    Given I am Logged in ServiceNow as Admin
    When I Logoff and Login as
      | HOT Service Desk Agent    |
      | Test SDServiceDeskAnalyst1 |
    And I Create a new Problem record with details
      | Requester  | ITService    | Component              | Symptom        | ProblemType | TFSReference | SupplierReference| OwningGroup      | Impact | Urgency | Priority | ProblemTitle | ProblemStatement                	                  | Business Impact              | WorkNotes        		                        |
      | Test User1 | Test Service | Test Service Component | Other(TOOLING) | Proactive   | TFSRef001    | SupRef001        | HOT Service Desk | 3      | 3       | 3        | Problem 1    | Problem 1 SI RBACS, Known Error Creation and Closure | Problem Business Impact text | Problem 1 SI RBACS, Known Error Creation and Closure |
    And I Click Save
    And I Change the Problem Status to Assigned
    And populate the Assignment group to "Test AssignmentGroup1"
    And I Click Save
    Given I Logoff and Login as "Test AssignmentGrpUser1"
    And I Navigate to Problem Record 1
    And I Change the Problem Status to In Progress
    And I Click Save
    And I Change the Problem Status to Known Error
    Then Known Error checkbox is ticked
    And I populate the Workaround details
      | Workaround      |
      | Workaround Text |
    And I populate Rootcause Information is populated as "Rootcause Information Text"
      | RootcauseInfo              |
      | Rootcause Information Text |
    And I Click Save
    When I click New in the Problem Tasks Tab
    Then ShortDescription has been automatically populated with the Problem Title from the Problem Record
    Then OwningGroup has been automatically populated with the Problem Assignment Group
    Then Opened field has been automatically populated with the date and time
    And I populate the task with details
      | AssignmentGroup       | TaskDescription       | Type 		            | Priority   | DueDate |
      | Test AssignmentGroup1 | Task Description Text | Prevention & Mitigation | 2 - Medium | Today   |
    And I Click Save
    When I Change DueDate field to +1 days
    And I Click Save
    Then Extention Count field is automatically changed to "1"
    When I Change DueDate field to -3 days
    And I Click Save
    Then Extention Count field stay as "1"
    When I Change the Task Status to In Progress
    And I Click Save
    When I Change the Task Status to Resolved
    And I populate the Resolution details
      | ResolutionDetails       |
      | Resolution Details Text |
    And I Click Save
    Then Resolved field is automatically populated with the resolved date and time
    When I Navigate back to the Problem record
    And I Change the Problem Status to Awaiting Implementation with the details
      | Solution Deployment Details | Resolution Details      |
      | Awaiting deployment detials | Resolution Detials Text |
    And I Click Save
    And I Change the Problem Status to Resolved with the details
      | Resolution Code        |
      | Resolved (Permanently) |
    And I Click Save
    When I Logoff and Login as
      | Problem Manager        |
      | Test SDProblemManager1 |
    And I Search and Open the Problem Record
    And I Change the Status to Closed with the details
      | Closure Code       | Closure Notes      |
      | Closed Implemented | Closure Notes Test |
    And I Click Save
    Then all fields in the Problem record and Problem Task are ready only
    Then the Problem Record state is Closed
    Then the Problem Task state is Closed
  PRB0042277
  PRB0042281
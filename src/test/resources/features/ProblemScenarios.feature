Feature: Problem Feature

  1. Problem 1 - Regression script contains a happy flow end to end test that includes SI Manager RBACS and Known Error Creation and Closure
  2. Problem 2 - Regression script contains a negative flow end to end test that includes the following:
                  - Problem User RBACS
                  - Problem Task Rejection
                  - Known Error Creation and Closure
  3. Problem 3 - Regression script contains a negative flow end to end test that includes SD Problem Manager RBACS, Problem Task Rejection and Re-opening a Problem record.

#  Scenario: Problem 1
#    Given I am Logged in ServiceNow as Admin
#    When I Logoff and Login as
#      | HOT Service Desk Agent     |
#      | Test SDServiceDeskAnalyst1 |
#    And I Create a new Problem record with details
#      | Requester  | ITService    | Component              | Symptom        | ProblemType | TFSReference | SupplierReference| OwningGroup      | Impact | Urgency | Priority | ProblemTitle | ProblemStatement                	                   | BusinessImpact               | WorkNotes        		                             |
#      | Test User1 | Test Service | Test Service Component | ACCESS         | Proactive   | TFSRef001    | SupRef001        | HOT Service Desk | 3      | 3       | 3        | Problem 1    | Problem 1 SI RBACS, Known Error Creation and Closure | Problem Business Impact text | Problem 1 SI RBACS, Known Error Creation and Closure |
#    And I Change the Problem Status to Assigned
#    And I populate the Assignment group and Save
#      | AssignmentGroup       |
#      | Test AssignmentGroup1 |
#    When I Logoff and Login as
#      | AssignmentGroupUser     |
#      | Test AssignmentGrpUser1 |
#    And I Search and Open the Problem
#    And I Change the Problem Status to In Progress
#    And I Change the Problem Status to Known Error
#    And I populate the Workaround details
#      | Workaround      |
#      | Workaround Text |
#    And I populate Rootcause Information
#      | RootcauseInfo              |
#      | Rootcause Information Text |
#    And I click New in the Problem Tasks Tab
#    Then ShortDescription has been automatically populated with the Problem Title from the Problem Record
#    And OwningGroup has been automatically populated with the Problem Assignment Group
#    And Opened field has been automatically populated with the date and time
#    When I populate the task with details
#      | AssignmentGroup       | TaskDescription       | TaskType 		            | Priority   | DueDate |
#      | Test AssignmentGroup1 | Task Description Text | Prevention & Mitigation     | 2 - Medium | Today   |
#    And I Change DueDate field to +1 days
#    Then Extension Count field is automatically changed to "1"
#    When I Change DueDate field to -3 days
#    Then Extension Count field stay as "1"
#    When I Change the Task Status to In Progress
#    And I Resolve the Task with details
#      | ResolutionDetails       |
#      | Resolution Details Text |
#    Then Resolved field is automatically populated with the resolved date and time
#    When I Navigate back to the Problem record
#    And I Change the Problem Status to Awaiting Implementation with the details
#      | SolutionDeploymentDetails   | ResolutionDetails       |
#      | Awaiting deployment details | Resolution Detials Text |
#    And I Change the Problem Status to Resolved with the details
#      | ResolutionCode        |
#      | Resolved (Permanently) |
#    And I Logoff and Login as
#      | Problem Manager        |
#      | Test SDProblemManager1 |
#    And I Search and Open the Problem
#    And I Change the Status to Closed with the details
#      | ClosureCode        | ClosureNotes       |
#      | Closed Implemented | Closure Notes Test |
#    Then all fields in the Problem record and Problem Task are ready only
#    Then the Problem Record state is Closed
#    Then the Problem Task state is Closed
#
#
#
#
#  Scenario: Problem 2
#
#    Given I am Logged in ServiceNow as Admin
#    When I Logoff and Login as
#      | HOT Service Desk Agent |
#      | Test SDServiceDeskAnalyst2 |
#    And I Create a new Problem record with details
#      | Requester  | ITService    | Component              | Symptom | ProblemType | TFSReference | SupplierReference| OwningGroup      | Impact | Urgency | Priority | ProblemTitle | ProblemStatement                	               										                                           | BusinessImpact               | WorkNotes        		                             |
#      | Test User2 | Test Service | Test Service Component | ACCESS  | Proactive   | TFSRef001    | SupRef001        | HOT Service Desk | 3      | 3       | 3        | Problem 2    | Problem 1. Negative flow end to end test including Problem User RBACS, Problem Task Rejection, Known Error Creation and Closure | Problem Business Impact text | Problem 2, RBACS, Known Error Rejection, and Closure |
#    And I Change the Problem Status to Assigned
#    And I populate the Assignment group and Save
#      | AssignmentGroup       |
#      | Test AssignmentGroup2 |
#    When I Logoff and Login as
#      | AssignmentGroupUser     |
#      | Test AssignmentGrpUser2 |
#    And I Search and Open the Problem
#    And I Change the Problem Status to In Progress
#    And I Change the Problem Status to Known Error
#    And I populate the Workaround details
#      | Workaround      |
#      | Workaround Text |
#    And I populate Rootcause Information
#      | RootcauseInfo              |
#      | Rootcause Information Text |
#    And I click New in the Problem Tasks Tab
#    Then ShortDescription has been automatically populated with the Problem Title from the Problem Record
#    And OwningGroup has been automatically populated with the Problem Assignment Group
#    And Opened field has been automatically populated with the date and time
#    When I populate the task with details
#      | AssignmentGroup       | TaskDescription         | TaskType 		          | Priority   | DueDate |
#      | Test AssignmentGroup2 | Task 1 Description Text | Prevention & Mitigation | 2 - Medium | Today   |
#    When I Change the Task Status to Rejected
#    And I populate the WorkNotes with details
#      | WorkNotes      |
#      | WorkNotes Text |
#    Then the Problem Task state is Rejected
#    When I Search and Open the Problem
#    And I click New in the Problem Tasks Tab
#    Then ShortDescription has been automatically populated with the Problem Title from the Problem Record
#    And OwningGroup has been automatically populated with the Problem Assignment Group
#    And Opened field has been automatically populated with the date and time
#    When I populate the Task 2 with details
#      | AssignmentGroup       | TaskDescription         | TaskType 		          | Priority   | DueDate |
#      | Test AssignmentGroup2 | Task 2 Description Text | Prevention & Mitigation | 2 - Medium | Today   |
#    When I Change the Task Status to In Progress
#    And I Resolve the Task 2 with details
#      | ResolutionDetails       |
#      | Resolution Details Text |
#    Then Resolved field is automatically populated with the resolved date and time
#    When I Navigate back to the Problem record
#    And I Change the Problem Status to Awaiting Implementation with the details
#      | SolutionDeploymentDetails   | ResolutionDetails       |
#      | Awaiting deployment details | Resolution Detials Text |
#    And I Change the Problem Status to Resolved with the details
#      | ResolutionCode         |
#      | Resolved (Permanently) |
#    And I Logoff and Login as
#      | Problem Manager        |
#      | Test SDProblemManager2 |
#    And I Search and Open the Problem
#    And I Change the Status to Closed with the details
#      | ClosureCode        | ClosureNotes       |
#      | Closed Implemented | Closure Notes Test |
#    Then all fields in the Problem record and Problem Task 2 are ready only
#    Then the Problem Record state is Closed
#    Then the Problem Task 2 state is Closed
#
#
#
#

  Scenario: Problem 3

    Given I am Logged in ServiceNow as Admin
    And I Logoff and Login as
      | HOT Service Desk Agent     |
      | Test SDServiceDeskAnalyst3 |
    And I Create a new Problem record with details
      | Requester  | ITService    | Component              | Symptom  | ProblemType | TFSReference | SupplierReference | OwningGroup      | Impact | Urgency | Priority | ProblemTitle | ProblemStatement                	                  						                             | BusinessImpact               | WorkNotes        		                   					                                 |
      | Test User3 | Test Service | Test Service Component | ACCESS   | Proactive   | TFSRef001    | SupRef001         | HOT Service Desk | 3      | 3       | 3        | Problem 3    | Probelm 3 - involving SD Problem Manager RBACS, Problem Task Rejection and Re-opening a Problem record. | Problem Business Impact text | Problem 1 SD Problem Manager RBACS, Problem Task Rejection and Re-opening a Problem record |
    And I Change the Problem Status to Assigned
    And I populate the Assignment group and Save
      | AssignmentGroup       |
      | Test AssignmentGroup3 |
    When I Logoff and Login as
      | AssignmentGroupUser     |
      | Test AssignmentGrpUser3 |
    And I Search and Open the Problem
    And I Change the Problem Status to In Progress
    And I click New in the Problem Tasks Tab
    Then ShortDescription has been automatically populated with the Problem Title from the Problem Record
    And OwningGroup has been automatically populated with the Problem Assignment Group
    And Opened field has been automatically populated with the date and time
    And I populate the task with details
      | AssignmentGroup       | TaskDescription         | TaskType	              | Priority   | DueDate |
      | Test AssignmentGroup3 | Task 1 Description Text | Prevention & Mitigation | 2 - Medium | Today   |
    When I Change the Task Status to In Progress
    And I Change the Task Status to Rejected
    And I populate the WorkNotes with details
      | WorkNotes      |
      | WorkNotes Text |
    Then the Problem Task state is Rejected
    When I Search and Open the Problem
    And I click New in the Problem Tasks Tab
    Then ShortDescription has been automatically populated with the Problem Title from the Problem Record
    And OwningGroup has been automatically populated with the Problem Assignment Group
    And Opened field has been automatically populated with the date and time
    When I populate the Task 2 with details
      | AssignmentGroup       | TaskDescription         | TaskType 		          | Priority   | DueDate |
      | Test AssignmentGroup3 | Task 2 Description Text | Prevention & Mitigation | 2 - Medium | Today   |
    When I Change the Task Status to In Progress
    And I Resolve the Task 2 with details
      | ResolutionDetails       |
      | Resolution Details Text |
    Then Resolved field is automatically populated with the resolved date and time
    When I Navigate back to the Problem record
    And I Change the Problem Status to Awaiting Implementation with the details
      | SolutionDeploymentDetails   | RootcauseInfo              | ResolutionDetails       |
      | Awaiting deployment details | Rootcause Information Text | Resolution Detials Text |
    And I Change the Problem Status to Resolved with the details
      | ResolutionCode        |
      | Resolved (Work Around)|
    And I Logoff and Login as
      | Problem Manager        |
      | Test SDProblemManager3 |
    And I Search and Open the Problem
    And I Change the Problem Status to In Progress
    And I Logoff and Login as
      | AssignmentGroupUser     |
      | Test AssignmentGrpUser3 |
    And I Search and Open the Problem
    And I click New in the Problem Tasks Tab
    Then ShortDescription has been automatically populated with the Problem Title from the Problem Record
    And OwningGroup has been automatically populated with the Problem Assignment Group
    And Opened field has been automatically populated with the date and time
    When I populate the Task 3 with details
      | AssignmentGroup       | TaskDescription         | TaskType 		          | Priority   | DueDate |
      | Test AssignmentGroup3 | Task 3 Description Text | Prevention & Mitigation | 2 - Medium | Today   |
    When I Change the Task Status to In Progress
    And I Resolve the Task 2 with details
      | ResolutionDetails       |
      | Resolution Details Text |
    Then Resolved field is automatically populated with the resolved date and time
    When I Navigate back to the Problem record
    And I Change the Problem Status to Awaiting Implementation with the details
      | SolutionDeploymentDetails   | RootcauseInfo              | ResolutionDetails       |
      | Awaiting deployment details | Rootcause Information Text | Resolution Detials Text |
    And I Change the Problem Status to Resolved with the details
      | ResolutionCode        |
      | Resolved (Work Around)|
    And I Logoff and Login as
      | Problem Manager        |
      | Test SDProblemManager3 |
    And I Search and Open the Problem
    And I Change the Status to Closed with the details
      | ClosureCode        | ClosureNotes       |
      | Closed Implemented | Closure Notes Test |
    Then all fields in the Problem record and Problem Task 3 are ready only
    Then the Problem Record state is Closed
    Then the Problem Task 3 state is Closed






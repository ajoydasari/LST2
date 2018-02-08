Feature: Incident Feature

  1. Incident 1 - The purpose of this test is to validate that a PSC user can raise a customer related incident, assigned to appropriate groups, updated, comments added, closed through the 3 strike rule
  2. Incident 2 - The purpose of this test is to ensure that multiple Incidents with similar issues can be added to a 'Parent' Incident as 'Child' Incidents. The test also actions the ability to update the Parent record which automatically updates the Child records attached to it.
  3. Incident 3 - The purpose of this test is to validate that an incident can be created and closed as a First Time Fix (FTF)

  Scenario: Incident 1
    Given I am Logged in ServiceNow as Admin
    When I Logoff and Login as
      | ServiceDeskAgent           |
      | Test SIServiceDeskAnalyst1 |
    And I Create a new Incident with details
      | Requester    | PSCUser | CustomerRelated | ITService    | Component              | Symptom   | TFSReference | SupplierReference| OwningGroup      | AssignmentGroup       | Impact | Urgency | Priority | ShortDescription            | Description                         |
      | Test User1   | yes     | yes             | Test Service | Test Service Component | ACCESS    | TFSRef001    | SupRef001        | HOT Service Desk | Test AssignmentGroup1 | 4      | 4       | 4        | Incident 1 - Access Request | Access Request to the Shared Drives |
    Then Service SLA has been added to the Incident and status changed to 'In Progress'
    And New Incident notification Email has been sent to the requester
    When I Logoff and Login as
      | Resolver1               |
      | Test AssignmentGrpUser1 |
    And I Select Incident from My Assignment Groups Open Incidents link
    And I Reject the Incident with notes
      | WorkNotes                 |
      | Incident Rejection Reason |
    Then Incident Status changed to Rejected
    And Assignment Group is Removed
    And Incident no longer appears in My Assignment Groups Open Incidents
    When I Logoff and Login as
      | HOTServiceDeskAgent        |
      | Test SDServiceDeskAnalyst1 |
    And I Select the Incident from My Owning Groups Open Incidents link
    And I Change the Incident Status to Assigned
    And I Assign Group with WorkNotes and Save
      | AssignmentGroup       | WorkNotes                               |
      | Test AssignmentGroup2 | Incident Assigned to Assignment Group 2 |
    Then Incident Status changed to Assigned
    When I Logoff and Login as
      | Resolver2               |
      | Test AssignmentGrpUser2 |
    And I Select Incident from My Assignment Groups Open Incidents link
    And I Change the Incident Status to In Progress
    Then Incident Status changed to In Progress
    And I Change the Incident Status to Awaiting Info
    Then Incident Status changed to Awaiting Info
    And I Change the Incident Status to In Progress
    Then Incident Status changed to In Progress
    When I Resolve the Incident with Resolution Details
    | ResolutionCode        | ResolutionNotes     |
    | Solved (Work Around)  | Resolution Details  |
    Then Resolution Service Classification displayed correctly for Incident
    And Incident Status changed to Resolved
    Then Incident Resolution Email has been sent to the requester
    When I Logoff and Login as
      | HOTServiceDeskAgent        |
      | Test SDServiceDeskAnalyst1 |
    And I Call Customer with notes for the Incident
      | WorkNotes                                 |
      | Attempt call customer for the first time  |
    And I Call Customer with notes for the Incident
      | WorkNotes                                 |
      | Attempt call customer for the second time |
    And I Call Customer with notes for the Incident
      | WorkNotes                                 |
      | Attempt call customer for the third time  |
    And I Search and Open the Incident
    Then Incident Status changed to Closed
    And Incident Closure Details displayed correctly for Incident
      | ClosureCode                       | ClosureNotes                                                                                            |
      | Closed - Three Contacts Attempted | This call is being closed automatically after three contacts. Please see work notes for further details |
    Then Incident Closure Email has been sent to the requester



  Scenario: Incident 2
    Given I am Logged in ServiceNow as Admin
    When I Logoff and Login as
      | HOT Service Desk Agent    |
      | Test SDServiceDeskAnalyst1 |
    And I Create a new Incident1 with details
      | Requester  | PSCUser | CustomerRelated | ITService    | Component              | Symptom   | TFSReference | SupplierReference| OwningGroup      | AssignmentGroup       | Impact | Urgency | Priority | WorkNotes		             | ShortDescription 		    | Description  	             |
      | Test User1 | yes     | yes             | Test Service | Test Service Component | ACCESS    | TFSRef001    | SupRef001        | HOT Service Desk | Test AssignmentGroup1 | 3      | 3       | 3        | Incident Parent and Child 1  | Incident Parent and Child 1 | Incident Parent and Child 1 |
    And I Create a new Incident2 with details
      | Requester  | PSCUser | CustomerRelated | ITService    | Component              | Symptom   | TFSReference | SupplierReference| OwningGroup      | AssignmentGroup       | Impact | Urgency | Priority | WorkNotes     		         | ShortDescription 		    | Description                |
      | Test User2 | no      | yes             | Test Service | Test Service Component | ACCESS    | TFSRef001    | SupRef001        | HOT Service Desk | Test AssignmentGroup1 | 4      | 4       | 4        | Incident Parent and Child 2  | Incident Parent and Child 2 | Incident Parent and Child 2 |
    And I Create a new Incident3 with details
      | Requester  | PSCUser | CustomerRelated | ITService    | Component              | Symptom   | TFSReference | SupplierReference| OwningGroup      | AssignmentGroup       | Impact | Urgency | Priority | WorkNotes     		         | ShortDescription 		    | Description                |
      | Test User3 | no      | yes             | Test Service | Test Service Component | ACCESS    | TFSRef001    | SupRef001        | HOT Service Desk | Test AssignmentGroup1 | 4      | 4       | 4        | Incident Parent and Child 3  | Incident Parent and Child 3 | Incident Parent and Child 3 |
    And I Search and Open the Incident3
    And I Click Edit on the Child Incidents Tab
    And I Add Incident1 as a Child Incident
    Then Incident1 is Added as a Child Incident
    And I Click Edit on the Child Incidents Tab
    When I Add Incident2 as a Child Incident
    Then Incident2 is Added as a Child Incident
    When I Logoff and Login as
      | FJ Resolver 1           |
      | Test AssignmentGrpUser1 |
    And I Select Incident3 from My Assignment Groups Open Incidents link
    And I Change the Incident Status to In Progress
    Then Incident Status changed to In Progress
    When I Resolve the Incident with Resolution Details
      | ResolutionCode        | ResolutionNotes        |
      | Solved                | Resolution Notes Text  |
    Then Incident3 Status changed to Resolved
    Then Resolution Service Classification displayed correctly for Incident3
    Then Incident3 Resolution Email has been sent to the requester
    When I Search and Open the Incident1
    Then Incident1 Status changed to Resolved
    When I Search and Open the Incident2
    Then Incident2 Status changed to Resolved
    When I Logoff and Login as
      | HOT Service Desk Agent     |
      | Test SDServiceDeskAnalyst1 |
    And I Search and Open the Incident3
    When I Close the Incident3 with details
      | ClosureCode                     | ClosureNotes       |
      | Closed - Parent incident closed | Closure Notes Text |
    Then Incident3 Status changed to Closed
    When I Search and Open the Incident1
    Then Incident1 Status changed to Closed
    When I Search and Open the Incident2
    Then Incident2 Status changed to Closed
    And Child Incident1 contains Closure Details from Incident3
    And Child Incident2 contains Closure Details from Incident3
    Then Incident3 Closure Email has been sent to the requester




#  Scenario: Incident 3
#    Given I am Logged in ServiceNow as Admin
#    When I Logoff and Login as <ServiceDeskAgent>
#    And I Select Favourites Tab
#    And I Create a new Incident 1 with details <Requester>, <CustomerRelated>, <ITService>, <Component>, <Symptom>, <TFSReference>, <SupplierReference>, <OwningGroup>, <AssignmentGroup>, <Impact>, <Urgency>, <ShortDescription>, <Description>
#      | ServiceDeskAgent  | ToolingTeamUser | Requester    | CustomerRelated | ITService           | Component                           | Symptom   | TFSReference | SupplierReference| OwningGroup      | AssignmentGroup   | Impact | Urgency | Priority | WorkNotes      	     	        | ShortDescription 	        | Description                         |
#      | Alex Weir         | Nicholas Gann   | Charles Melly| yes             | Service Now (IT Svc)| ServiceNow Core Platform (Svc Comp) | ACCESS    | TFSRef001    | SupRef001        | HOT Service Desk | HOT Tooling Team  | 4      | 4       | 4        | Incident First Time Fix Worknotes | Incident First Time Fix   | Incident First Time Fix Description |
#    And I Click on the First Time Fix button
#    Then Closure Notes have been prompted as a mandatory field
#
#    When I populate the closure code as *Closure Notes Text*
#    Then Closure Code has been automatically populated as *Closed - First Time Fix*
#    When click on the First Time Fix button
#
#    Then Incident state is "Closed"
#    Then Incident Resolution email is sent to "Charles Melley"
#    Then Incident Closure email is sent to "Charles Melley"

#
#  Scenario: Check Email
#    Given I am Logged in ServiceNow as Admin
#    When I Open Emails
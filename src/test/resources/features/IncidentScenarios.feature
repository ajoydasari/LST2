Feature: Incident Feature

  1. Incident 1 - The purpose of this test is to validate that a PSC user can raise a customer related incident, assigned to appropriate groups, updated, comments added, closed through the 3 strike rule
  2. Incident 2 - The purpose of this test is to ensure that multiple Incidents with similar issues can be added to a 'Parent' Incident as 'Child' Incidents. The test also actions the ability to update the Parent record which automatically updates the Child records attached to it.
  3. Incident 3 - The purpose of this test is to validate that an incident can be created and closed as a First Time Fix (FTF)

  Scenario: Incident 1
    Given I am Logged in ServiceNow as Admin
    When I Logoff and Login as
    | ServiceDeskAgent |
    | Cameron McKenzie |
    And I Select Favourites Tab
    And I Create a new Incident with details
    | Requester    | CustomerRelated | ITService           | Component                           | Symptom   | TFSReference | SupplierReference| OwningGroup      | AssignmentGroup   | Impact | Urgency | Priority | ShortDescription | Description                         |
    | Adrian Moody | yes             | Service Now (IT Svc)| ServiceNow Core Platform (Svc Comp) | ACCESS    | TFSRef001    | SupRef001        | HOT Service Desk | HOT Tooling Team  | 4      | 4       | 4        | Access Request   | Access Request to the Shared Drives |
    Then Service SLA has been added to the Incident and status changed to 'In Progress'
    And Incident notification Email has been sent to the requester
##    When I Logoff and Login as <ToolingTeamUser>
##      | ServiceDeskAgent |
##      | Nicholas Gann  |
##    And I Select All Apps Tab
##    And I Select Incident from My Assignment Groups Open Incidents link
##    And I select the Incident created earlier
##    And I Reject the Incident with notes <WorkNotes>
##    Then Incident status changed to Rejected
#
#

#  Scenario: Incident 2
#    Given I am Logged in ServiceNow as Admin
#    When I Logoff and Login as <ServiceDeskAgent>
#    And I Select Favourites Tab
#    And I Create a new Incident 1 with details <Requester>, <CustomerRelated>, <ITService>, <Component>, <Symptom>, <TFSReference>, <SupplierReference>, <OwningGroup>, <AssignmentGroup>, <Impact>, <Urgency>, <ShortDescription>, <Description>
#      | ServiceDeskAgent | ToolingTeamUser | Requester    | CustomerRelated | ITService           | Component                           | Symptom   | TFSReference | SupplierReference| OwningGroup      | AssignmentGroup   | Impact | Urgency | Priority | WorkNotes         | ShortDescription | Description                         |
#      | Cameron McKenzie | Nicholas Gann   | Adrian Moody | yes             | Service Now (IT Svc)| ServiceNow Core Platform (Svc Comp) | ACCESS    | TFSRef001    | SupRef001        | HOT Service Desk | HOT Tooling Team  | 4      | 4       | 4        | Incident Rejected | Access Request   | Access Request to the Shared Drives |
#    And I Create a new Incident 2 with details <Requester>, <CustomerRelated>, <ITService>, <Component>, <Symptom>, <TFSReference>, <SupplierReference>, <OwningGroup>, <AssignmentGroup>, <Impact>, <Urgency>, <ShortDescription>, <Description>
#      | ServiceDeskAgent | ToolingTeamUser | Requester    | CustomerRelated | ITService           | Component                           | Symptom   | TFSReference | SupplierReference| OwningGroup      | AssignmentGroup   | Impact | Urgency | Priority | WorkNotes         | ShortDescription | Description                         |
#      | Cameron McKenzie | Nicholas Gann   | Adrian Moody | yes             | Service Now (IT Svc)| ServiceNow Core Platform (Svc Comp) | ACCESS    | TFSRef001    | SupRef001        | HOT Service Desk | HOT Tooling Team  | 4      | 4       | 4        | Incident Rejected | Access Request   | Access Request to the Shared Drives |
#    And I Create a new Incident 3 with details <Requester>, <CustomerRelated>, <ITService>, <Component>, <Symptom>, <TFSReference>, <SupplierReference>, <OwningGroup>, <AssignmentGroup>, <Impact>, <Urgency>, <ShortDescription>, <Description>
#      | ServiceDeskAgent | ToolingTeamUser | Requester    | CustomerRelated | ITService           | Component                           | Symptom   | TFSReference | SupplierReference| OwningGroup      | AssignmentGroup   | Impact | Urgency | Priority | WorkNotes         | ShortDescription | Description                         |
#      | Cameron McKenzie | Nicholas Gann   | Adrian Moody | yes             | Service Now (IT Svc)| ServiceNow Core Platform (Svc Comp) | ACCESS    | TFSRef001    | SupRef001        | HOT Service Desk | HOT Tooling Team  | 4      | 4       | 4        | Incident Rejected | Access Request   | Access Request to the Shared Drives |
#    And I navigate to Incident 3

#    And click on Edit on the child incidents tab
#    And Add the Incident 1 as a child incident
#    Then Incident 1 is added as a child incident
#    And Add the Incident 2 as a child incident
#    Then Incident 2 is added as a child incident
#    When I Save the Incident
#    Then Incidents 1 and 2 will display as child incidents of Incident 3
#
#    Given I Logoff and Login as "HOT Tooling Team"
#    And I Select Favourites Tab
#    And I click on My Assignment Groups Open Incidents
#    And navigate to the Incident 3 record
#
#    And Change the Status to "In Progress"
#    Given State is In Progress
#    And I change the state to <Status> with <Worknotes> <ResolutionCode> <ResolutionNotes>
#      | Status    | Worknotes       | ResolutionCode    | ResolutionNotes |
#      | Resolved  | Work notes text | Solved            |                 |
#    When I Save the Incident
#    Then Incident 3 State is "Resolved"
#    Then resolution service classification information is automaticlaly populated as <ResolutionITService> <ResolutionComponent> <ResolutionSymptom> from Incident 3
#      | ResolutionITService    | ResolutionComponent                  | ResolutionSymptom |
#      | Service Now  (IT Svc)  | ServiceNow Core Platform (Svc Comp)  | ACCESS            |
#    Then a Incident Resolution email is sent to "Adrian Moody"
#    Then Incident 1 State is "Resolved"
#    Then Incident 2 State is "Resolved"
#
#    Given I Logoff and Login as "Alex Weir"
#    And I Select Favourites Tab
#    And navigate to the Incident 3 record
#    And Change the status to "Closed"
#
#    Then Incident 1 State is "Closed"
#    And Incident 2 State is "Closed"
#    And Child incident 1 contains <ClosureCode> <ClosureNotes> from Incident 3
#      | ClosureCode                       | ClosureNotes        |
#      | Closed - Parent Incident closed   | Closure Notes Text  |
#    And Child incident 2 contains <ClosureCode> <ClosureNotes> from Incident 3
#      | ClosureCode                       | ClosureNotes        |
#      | Closed - Parent Incident closed   | Closure Notes Text  |
#    And a Incident Closure email is sent to the "Adrian Moody"
#
#
#
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


#  Scenario: Check Email
#    Given I am Logged in ServiceNow as Admin
#    When I Open Emails
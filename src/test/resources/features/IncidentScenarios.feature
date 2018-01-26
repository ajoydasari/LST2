Feature: Incident Feature

  1. Incident 1 - The purpose of this test is to validate that a PSC user can raise a customer related incident, assigned to appropriate groups, updated, comments added, closed through the 3 strike rule

  Scenario Outline: Incident 1
    Given I am Logged in ServiceNow as Admin
    When I Logoff and Login as <ServiceDeskAgent>
    And I Select Favourites Tab
    And I Create a new Incident with details <Requester>, <CustomerRelated>, <ITService>, <Component>, <Symptom>, <TFSReference>, <SupplierReference>, <OwningGroup>, <AssignmentGroup>, <Impact>, <Urgency>, <ShortDescription>, <Description>
#    Then Service SLA has been added to the Incident and status changed to 'In Progress'
#    And Incident notification Email has been sent to the requester
    When I Logoff and Login as <ToolingTeamUser>
    And I Select All Apps Tab
    And I Select Incident from My Assignment Groups Open Incidents link
    And I select the Incident created earlier
    And I Reject the Incident with notes <WorkNotes>
    Then Incident status changed to Rejected

  Examples:
    | ServiceDeskAgent | ToolingTeamUser | Requester    | CustomerRelated | ITService           | Component                           | Symptom   | TFSReference | SupplierReference| OwningGroup      | AssignmentGroup   | Impact | Urgency | WorkNotes         | ShortDescription | Description                         |
    | Cameron McKenzie | Nicholas Gann   | Adrian Moody | yes             | Service Now (IT Svc)| ServiceNow Core Platform (Svc Comp) | ACCESS    | TFSRef001    | SupRef001        | HOT Service Desk | HOT Tooling Team  | 4      | 4       | Incident Rejected | Access Request   | Access Request to the Shared Drives |

Feature: Change Feature

  1. Change 1 - The puspose of this test is to validate that a normal change can be created by the Change Analysts, processed through the states and closed with a successful PIU


  Scenario: Change 1

    Given I am Logged in ServiceNow as Admin
    And I Logoff and Login as
      | HOT Change Analyst  |
      | Test ChangeAnalyst1 |
    And I Click on Create New in the Change module menu
    When I populate the Change/Release Ready Reckoner with the details
      | IT Service   | Standard/EmergencyChange | NewService | MultiEnvironment | MultipleSuppliers | ImpactOtherITSystems | DeployTogether |
      | Test Service | No		                | No         | No               | No		        | No			       | No		        |
    And I Click Calculate Score
    When I Click Go to Change
    Then New Change Request record is displayed
    And I Create a New Change Record with the details
      | Requestor  | Change title  |
      | Test User4 | Change Test 1 |
    When I Click on Complete Risk and Impact button
    Then Change Risk and Impact Record is displayed
    And I Create a New Change Risk and Impact Record with the details
      | HowManyImpacted | WhatImpactOnService | WithinServiceHours | DateStartTimeCanChange | TestingDone | TestingCompleted | EvidenceProvided | InvolveOtherSuppliers | AccessObtained | CanServicesBeRestored | PrerequisitesCompleted |
      | All Users	    | Performance only	  | No				   | Yes					| Yes		  | Yes				 | Yes 				| No					| Yes			 | Yes					 | Yes                    |
    And I Click on Complete Risks and Impact
    Then The Page Automatically Reloads to Change Request Record
    And I populate the Risks and Impact fields
      | PrimaryConfigItem      | Description               | ReasonForChange      | StartDateTime | EndDateTime | ImplementationPlanAttached | ImplementationPlan      | PreImplementationTestEvidenceAttached | BackoutPlanAttached |
      | Test Service Component | Change 1 Description Text | Change 1 Reason Text |               |             | No                         | Implementaion Plan Text | Yes						           | Yes				 |
    And I Click on Submit for Validation
    And I Populate the Justification details
      | JustificationToExpedite	       |
      | Justification to expedite text |
    And I Click on Submit for Validation
    Then The State changes to Validation
    And I Click on the 'Assign to me' button next to the 'Assigned to' field
    Then Assigned to field displays as 'Test Change Analyst1'
    Then Assignment Group displays as 'HOT Change Analysts'
    When I populate the Change Classification
      | ChangeClassification |
      | Minor                |
    And I Click on Request Assessments
    Then the State Changes to Awaiting Approval
    When I Logoff and Login as
      | AssignmentGroupUser     |
      | Test AssignmentGrpUser1 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then AssignmentGroupUser can view the change record
      | AssignmentGroupUser     |
      | Test AssignmentGrpUser1 |
    And I go back to the approval
    And I Click on Approve
    Then the State Changes to Awaiting Approval
    When I Logoff and Login as
      | AssignmentGroupUser     |
      | Test AssignmentGrpUser2 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then AssignmentGroupUser can view the change record
      | AssignmentGroupUser     |
      | Test AssignmentGrpUser2 |
    And I go back to the approval
    And I Click on Approve
    Then the State Changes to Awaiting Approval
    When I Logoff and Login as
      | ChangeManager       |
      | Test ChangeManager1 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then ChangeManager can view the change record
      | ChangeManager       |
      | Test ChangeManager1 |
    And I Navigate to the Change Record
    And Change Request Record is in a State of Implementation
    When I Logoff and Login as
      | TestUser      |
      | Test User4    |
    And I Navigate to the Change Record
    And I Navigate to the PIU Record
    And I Populate the PIU Record with the details:
      | ChangeCompletedWithinChangeWindow | ChangeMetSuccessCriteria | AssetCINeedUpdating |
      | Yes							      | Yes					     | Yes				   |
    And I Click on Complete PIU
    And I Navigate to the Change Record
    Then The State of PIU Record is Awaiting Closure


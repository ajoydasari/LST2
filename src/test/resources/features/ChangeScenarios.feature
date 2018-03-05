Feature: Change Feature

  1. Change 1 - The puspose of this test is to validate that a normal change can be created by the Change Analysts, processed through the states and closed with a successful PIU
  2. Change 2 - The purpose of this test is to validate that a Normal Change can be created by the Change Analysts, processed through the states and Change Authority Approval rejects the proposed dates. Change is moved back to validation, dates are changed and the change record is processed through to completion
  3. Change 3 - Emergency change is created via the ready reckoner functionality. Change request is created and submitted for validation. Assessments are skipped and the change request is approved. PIU is generated post the planned end date is completed as successful. PIR is opened due to it being an emergency change. PIR completed and closed.

  Scenario: Change 1

    Given I am Logged in ServiceNow as Admin
    And I Logoff and Login as
      | HOT Change Analyst  |
      | Test ChangeAnalyst1 |
    And I Click on Create New in the Change module menu
    When I populate the Change/Release Ready Reckoner with the details
      | ITService    | EmergencyChange | NewService | MultiEnvironment | MultipleSuppliers | ImpactOtherITSystems | DeployTogether |
      | Test Service | No              | No         | No               | No                | No                   | No             |
    And I Click Calculate Score
    When I Click Go to Change
    Then New Change Request record is displayed
    And I Create a New Change Record with the details
      | Requestor  | ChangeTitle   |
      | Test User4 | Change Test 1 |
    When I Click on Complete Risk and Impact button
    Then Change Risk and Impact Record is displayed
    And I Create a New Change Risk and Impact Record with the details
      | HowManyImpacted | WhatImpactOnService | WithinServiceHours | DateStartTimeCanChange | TestingDone | TestingCompleted | EvidenceProvided | InvolveOtherSuppliers | AccessObtained | CanServicesBeRestored | PrerequisitesCompleted |
      | All Users	    | Performance Only	  | No				   | Yes					| Yes		  | Yes				 | Yes 				| No					| Yes			 | Yes					 | Yes                    |
    And I Click on Complete Risks and Impact
    Then The Page Automatically Reloads to Change Request Record
    And I populate the Change fields
      | PrimaryConfigItem      | Description               | ReasonForChange      | StartDateTime | EndDateTime | ImplementationPlanAttached | ImplementationPlan       | PreImplTestEvidenceAttached | BackoutPlanAttached |
      | Test Service Component | Change 1 Description Text | Change 1 Reason Text | NOW           | NOW         | No                         | Implementation Plan Text |Yes                          | Yes				    |
    And I Click on Submit for Validation
    And I Populate the Justification details
      | JustificationToExpedite	       | PostImplVerificationSteps                   |
      | Justification to expedite text | Post Implementation Verification Steps text |
    And I Click on Submit for Validation second time
    Then The Change Record State changes to Validation
    And I Click on the 'Assign to me' button next to the 'Assigned to' field
    Then Assigned to field displays as 'Test ChangeAnalyst1'
    Then Assignment Group displays as 'HOT Change Analysts'
    When I populate the Change Classification
      | ChangeClassification |
      | Minor                |
    And I Click on Request Assessments
    Then The Change Record State changes to Awaiting Approval
    When I Logoff and Login as
      | AssignmentGroupUser     |
      | Test AssignmentGrpUser1 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then AssignmentGroupUser can view the change record
    And I go back to the approval
    And I Click on Approve
    And I Search and Open the Change Record
    Then The Change Record State changes to Awaiting Approval
    When I Logoff and Login as
      | AssignmentGroupUser     |
      | Test AssignmentGrpUser2 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then AssignmentGroupUser can view the change record
    And I go back to the approval
    And I Click on Approve
    And I Navigate to the Change Record
    Then The Change Record State changes to Awaiting Approval
    When I Logoff and Login as
      | ChangeManager       |
      | Test ChangeManager1 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then ChangeManager can view the change record
    When I go back to the approval
    And I Click on Approve
    And I Navigate to the Change Record
    Then The Change Record State changes to Awaiting Implementation
    And a PIU Task is created when Change Endtime is elapsed
    When I Logoff and Login as
      | TestUser      |
      | Test User4    |
    And I Navigate to the Change Record
    And I Navigate to the PIU Record
    And I Populate the PIU Record with the details
      | ChangeCompletedWithinChangeWindow | ChangeMetSuccessCriteria | AssetCINeedUpdating |
      | Yes							      | Yes					     | Yes				   |
    And I Click on Complete PIU
    And I Navigate to the Change Record
    Then The Change Record State changes to Awaiting Closure


#
#
#  Scenario: Change 2
#
#    Given I am Logged in ServiceNow as Admin
#    When I Logoff and Login as
#      | ChangeAnalyst       |
#      | Test ChangeAnalyst2 |
#    And I Click on Create New in the Change module menu
#    When I populate the Change/Release Ready Reckoner with the details
#      | ITService    | EmergencyChange | NewService | MultiEnvironment | MultipleSuppliers | ImpactOtherITSystems | DeployTogether |
#      | Test Service | No              | No         | No               | No                | No                   | No             |
#    And I Click Calculate Score
#    When I Click Go to Change
#    Then New Change Request record is displayed
#    And I Create a New Change Record with the details
#      | Requestor  | ChangeTitle   |
#      | Test User4 | Change Test 2 |
#    When I Click on Complete Risk and Impact button
#    Then Change Risk and Impact Record is displayed
#    And I Create a New Change Risk and Impact Record with the details
#      | HowManyImpacted | WhatImpactOnService | WithinServiceHours | DateStartTimeCanChange | TestingDone | TestingCompleted | EvidenceProvided | InvolveOtherSuppliers | AccessObtained | CanServicesBeRestored | PrerequisitesCompleted |
#      | All Users	    | Performance Only	  | No				   | Yes					| Yes		  | Yes				 | Yes 				| No					| Yes			 | Yes					 | Yes                    |
#    And I Click on Complete Risks and Impact
#    Then The Page Automatically Reloads to Change Request Record 2
#    And I populate the Change fields
#      | PrimaryConfigItem      | Description               | ReasonForChange      | StartDateTime | EndDateTime | ImplementationPlanAttached | ImplementationPlan       | PreImplTestEvidenceAttached | BackoutPlanAttached |
#      | Test Service Component | Change 2 Description Text | Change 2 Reason Text | NOW           | NOW         | No                         | Implementation Plan Text |Yes                          | Yes                 |
#    And I Click on Submit for Validation
#    And I Populate the Justification details
#      | JustificationToExpedite	       | PostImplVerificationSteps                   |
#      | Justification to expedite text | Post Implementation Verification Steps text |
#    And I Click on Submit for Validation
#    Then The Change Record State changes to Validation
#    And I Click on the 'Assign to me' button next to the 'Assigned to' field
#    Then Assigned to field displays as 'Test ChangeAnalyst2'
#    Then Assignment Group displays as 'HOT Change Analysts'
#    When I populate the Change Classification
#      | ChangeClassification |
#      | Minor                |
#    And I Click on Request Assessments
#    Then The Change Record State changes to Awaiting Approval
#    When I Logoff and Login as
#      | AssignmentGroupUser     |
#      | Test AssignmentGrpUser1 |
#    And I Click on My Approvals in the External Change Assessment module
#    And I Click on the Approval for the change request
#    And I Click on the information button next to the Approving field
#    Then AssignmentGroupUser can view the change record
#    And I go back to the approval
#    And I Click on Approve
#    And I Search and Open the Change Record
#    Then The Change Record State changes to Awaiting Approval
#    When I Logoff and Login as
#      | AssignmentGroupUser     |
#      | Test AssignmentGrpUser2 |
#    And I Click on My Approvals in the External Change Assessment module
#    And I Click on the Approval for the change request
#    And I Click on the information button next to the Approving field
#    Then AssignmentGroupUser can view the change record
#    And I go back to the approval
#    And I Click on Approve
#    Then The Change Record State changes to Awaiting Approval
#    When I Logoff and Login as
#      | ChangeManager       |
#      | Test ChangeManager2 |
#    And I Click on My Approvals in the External Change Assessment module
#    And I Click on the Approval for the change request
#    And I Click on the information button next to the Approving field
#    Then ChangeManager can view the change record
#    And I Navigate to the Change Record
#    And populate the comments field with "test comments"
#    And I click Proposed Dates Rejected
#    When I Search and Open the Change Record
#    Then The Change Record State changes to Validation
#    When I Logoff and Login as
#      | ChangeAnalyst       |
#      | Test ChangeAnalyst2 |
#    When I Search and Open the Change Record
#    And I edit the start date
#    And I edit the end date
#    And I Click on the 'Assign to me' button next to the 'Assigned to' field
#    Then Assigned to field displays as 'Test ChangeAnalyst2'
#    Then Assignment Group displays as 'HOT Change Analysts'
#    And I click Save
#    And I click on the Change Task
#    And I click Close Task
#    When I Search and Open the Change Record
#    And I Click on Request Assessments
#    Then The Change Record State changes to Awaiting Approval
#    When I Logoff and Login as
#      | AssignmentGroupUser     |
#      | Test AssignmentGrpUser1 |
#    And I Click on My Approvals in the External Change Assessment module
#    And I Click on the Approval for the change request
#    And I Click on the information button next to the Approving field
#    Then AssignmentGroupUser can view the change record
#    And I go back to the approval
#    And I Click on Approve
#    When I Logoff and Login as
#      | AssignmentGroupUser     |
#      | Test AssignmentGrpUser2 |
#    And I Click on My Approvals in the External Change Assessment module
#    And I Click on the Approval for the change request
#    And I Click on the information button next to the Approving field
#    Then AssignmentGroupUser can view the change record
#    And I go back to the approval
#    And I Click on Approve
#    When I Logoff and Login as
#      | ChangeManager       |
#      | Test ChangeManager1 |
#    And I Click on My Approvals in the External Change Assessment module
#    And I Click on the Approval for the change request
#    And I Click on the information button next to the Approving field
#    Then ChangeManager can view the change record
#    And I Navigate to the Change Record
#    And The Change Record State changes to Implementation
#    When I Logoff and Login as
#      | TestUser      |
#      | Test User4    |
#    And I navigate to My Groups PIU Taks module
#    And I navigate to the PIU record of Change Request Record 2
#    And I populate the record with the details:
#      | Was the change copleted within the authorised change window? | Did the change meet the success criteria? | Does Asset/CI data need to be updated as a result of this change? |
#      | Yes							       | Yes					   | Yes							       |
#    And I click Complete PIU
#    And I Navigate to the Change Record
#    And The Change Record State changes to Awaiting Closure




#  Scenario: Change 3
#    Given I am Logged in ServiceNow as Admin
#    When I Logoff and Login as "Test ChangeManager3"
#    And I click on "Create New" in the Change module menu
#    When I populate the Change/Release Ready Reckoner with the details
#    | IT Service   | Is this a Standard/Emergency Change? |
#    | Test Service | Yes				      |
#    And I click "calculate score"
#    When I click "Go to Change"
#    Then a New Change Request record is displayed
#    And I create a new Change record with the details
#      | Requestor  | Change title  | Test Type |
#      | Test User4 | Change Test 3 | Emergency |
#    And I click Save
#    And I populate the record with the information:
#      | Primary Configuration Item | Change classification | Description 	| Reason for Change      | Start date/time | End date/time |
#      | Test Service Component     | Minor 		     | Description text | Reason for change text | Start date/time | End date/time |
#    When I click Sumbit for Validation
#    And I cick on the "Assign to me" button next to the "Assigned to" field
#    Then the "Asigned to" field displays as "Test ChangeManager3"
#    And the "Assignment Group" displays as "HOT Change Analysts"
#    When I click on the Skip Assessments button
#    And I navigate to the approvals tab
#    And I click on the Approver record for Test ChangeManager3
#    And I click Approve
#    Then Change Request record 3 is in a state of Implementaion
#    Given I Logoff and Login as "Test User4"
#    And I navigate to My Groups PIU Taks module
#    And I navigate to the PIU record of Change Request Record 3
#    And I populate the record with the details:
#      | Was the change completed within the authorised change window? | Did the change meet the success criteria? | Does Asset/CI data need to be updated as a result of this change? |
#      | Yes							        | Yes					    | Yes							        |
#    And I click Complete PIU
#    Given I Logoff and Login as "Test ChangeManager3"
#    And I navigate to Change Request Record 3
#    And I populate the record with the information
#      | Is the implementation plan attached? | Implementation plan      | Is the pre-implementation testing evidence attached? | Is the backout plan attached? | Post implementation verification steps      |
#      | No				       | Implementation plan text | Yes							 | Yes				 | Post implementation verification steps text |
#    And I click Save
#    And I navigate to the Change Task titled 'Mandatory Fields'
#    And I click Close Task
#    And I navigate to Change Request Record 3
#    Then the state of Change Request record 3 is PIR
#    And I navigate to the Change Task titled 'PIR'
#    And PIR Reason is displaying as Emergency Change
#    And I populate the closed status as Completed with Issues
#    And I click close Task
#    And I navigate to Change Request Record 3
#    Then Change Request record 3 state is Closed

Feature: Change Feature

  1. Change 1 - The puspose of this test is to validate that a normal change can be created by the Change Analysts, processed through the states and closed with a successful PIU
  2. Change 2 - The purpose of this test is to validate that a Normal Change can be created by the Change Analysts, processed through the states and Change Authority Approval rejects the proposed dates. Change is moved back to validation, dates are changed and the change record is processed through to completion
  3. Change 3 - Emergency change is created via the ready reckoner functionality. Change request is created and submitted for validation. Assessments are skipped and the change request is approved. PIU is generated post the planned end date is completed as successful. PIR is opened due to it being an emergency change. PIR completed and closed.
  4. Change 4 - Requestor submitted off tool copies of completed Standard Change RFC and risks and impact template to the Change Analyst. Change Analyst selects the appropriate Change Model and populates the change. Change Analyst processes the change through to completion

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
      | Requestor  | ChangeTitle   | ChangeType |
      | Test User4 | Change Test 1 | Normal     |
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
    And I Click on Save
    When I Logoff and Login as
      | ChangeManager       |
      | Test ChangeManager1 |
    And I Search and Open the Change Record
    When I Populate Accepted For Expediting
      | AcceptExpedite |
      | Yes            |
    And I Logoff and Login as
      | HOT Change Analyst  |
      | Test ChangeAnalyst1 |
    And I Search and Open the Change Record
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
      | Yes							      | Yes					  | Yes				    |
    And I Click on Complete PIU
    And I Navigate to the Change Record
    Then The Change Record State changes to Awaiting Closure



  Scenario: Change 2

    Given I am Logged in ServiceNow as Admin
    When I Logoff and Login as
      | ChangeAnalyst       |
      | Test ChangeAnalyst2 |
    And I Click on Create New in the Change module menu
    When I populate the Change/Release Ready Reckoner with the details
      | ITService    | EmergencyChange | NewService | MultiEnvironment | MultipleSuppliers | ImpactOtherITSystems | DeployTogether |
      | Test Service | No              | No         | No               | No                | No                   | No             |
    And I Click Calculate Score
    When I Click Go to Change
    Then New Change Request record is displayed
    And I Create a New Change Record with the details
      | Requestor  | ChangeTitle   | ChangeType |
      | Test User4 | Change Test 2 | Normal     |
    When I Click on Complete Risk and Impact button
    Then Change Risk and Impact Record is displayed
    And I Create a New Change Risk and Impact Record with the details
      | HowManyImpacted | WhatImpactOnService | WithinServiceHours | DateStartTimeCanChange | TestingDone | TestingCompleted | EvidenceProvided | InvolveOtherSuppliers | AccessObtained | CanServicesBeRestored | PrerequisitesCompleted |
      | All Users	    | Performance Only	  | No				   | Yes					| Yes		  | Yes				 | Yes 				| No					| Yes			 | Yes					 | Yes                    |
    And I Click on Complete Risks and Impact
    Then The Page Automatically Reloads to Change Request Record 2
    And I populate the Change fields
      | PrimaryConfigItem      | Description               | ReasonForChange      | StartDateTime | EndDateTime | ImplementationPlanAttached | ImplementationPlan       | PreImplTestEvidenceAttached | BackoutPlanAttached |
      | Test Service Component | Change 2 Description Text | Change 2 Reason Text | NOW           | NOW         | No                         | Implementation Plan Text |Yes                          | Yes                 |
    And I Click on Submit for Validation
    And I Populate the Justification details
      | JustificationToExpedite	       | PostImplVerificationSteps                   |
      | Justification to expedite text | Post Implementation Verification Steps text |
    And I Click on Submit for Validation
    Then The Change Record State changes to Validation
    And I Click on the 'Assign to me' button next to the 'Assigned to' field
    Then Assigned to field displays as 'Test ChangeAnalyst2'
    Then Assignment Group displays as 'HOT Change Analysts'
    When I populate the Change Classification
      | ChangeClassification |
      | Minor                |
    And I Click on Save
    When I Logoff and Login as
      | ChangeManager       |
      | Test ChangeManager1 |
    And I Search and Open the Change Record
    When I Populate Accepted For Expediting
      | AcceptExpedite |
      | Yes            |
    And I Logoff and Login as
      | HOT Change Analyst  |
      | Test ChangeAnalyst2 |
    And I Search and Open the Change Record
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
    And I Search and Open the Change Record
    Then The Change Record State changes to Awaiting Approval
    When I Logoff and Login as
      | ChangeManager       |
      | Test ChangeManager2 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then ChangeManager can view the change record
    When I go back to the approval
    And I Click on Proposed Dates Rejected with comments 'test comments'
    When I Search and Open the Change Record
    Then The Change Record State changes to Validation
    When I Logoff and Login as
      | ChangeAnalyst       |
      | Test ChangeAnalyst2 |
    When I Search and Open the Change Record
    And I Edit the Start date
    And I Edit the End date
    And I Click on the 'Assign to me' button next to the 'Assigned to' field
    Then Assignment Group displays as 'HOT Change Analysts'
    Then Assigned to field displays as 'Test ChangeAnalyst2'
    And I Click on Save
    When I Logoff and Login as
      | ChangeManager       |
      | Test ChangeManager2 |
    When I Search and Open the Change Record
    And I Click on the Change Task
    And I Click Close Task
    When I Search and Open the Change Record
    And I Click on Request Assessments again
    Then The Change Record State changes to Awaiting Approval
    When I Logoff and Login as
      | AssignmentGroupUser     |
      | Test AssignmentGrpUser1 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then AssignmentGroupUser can view the change record again
    And I go back to the approval
    And I Click on Approve
    When I Logoff and Login as
      | AssignmentGroupUser     |
      | Test AssignmentGrpUser2 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then AssignmentGroupUser can view the change record again
    And I go back to the approval
    And I Click on Approve
    When I Logoff and Login as
      | ChangeManager       |
      | Test ChangeManager1 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then ChangeManager can view the change record
    And I go back to the approval
    And I Click on Approve
    When I Search and Open the Change Record
    And The Change Record State changes to Awaiting Implementation
    When I Logoff and Login as
      | TestUser      |
      | Test User4    |
    And I Click on My Groups PIU Tasks module
    And I Navigate to the PIU record of Change Request Record
    And I Populate the PIU Record with the details
      | ChangeCompletedWithinChangeWindow | ChangeMetSuccessCriteria | AssetCINeedUpdating |
      | Yes							      | Yes                      | Yes				   |
    And I Click on Complete PIU
    And I Navigate to the Change Record
    And The Change Record State changes to Awaiting Closure



  Scenario: Change 3
    Given I am Logged in ServiceNow as Admin
    When I Logoff and Login as
      | Change Manager      |
      | Test ChangeManager3 |
    And I Click on Create New in the Change module menu
    When I populate the Change/Release Ready Reckoner with the details
      | ITService    | EmergencyChange |
      | Test Service | Yes             |
    And I Click Calculate Score
    When I Click Go to Change
    Then New Change Request record is displayed
    And I Create a New Change Record with the details
      | Requestor  | ChangeTitle   | ChangeType |
      | Test User4 | Change Test 3 | Emergency  |
    And I populate the Change fields for Emergency Change
      | PrimaryConfigItem      | ChangeClassification | Description      | ReasonForChange        | StartDateTime | EndDateTime |
      | Test Service Component | Minor                | Description text | Reason for change text | NOW           | NOW         |
    And I Click on Submit for Validation
    And I Click on the 'Assign to me' button next to the 'Assigned to' field
    Then Assigned to field displays as 'Test ChangeManager3'
    Then Assignment Group displays as 'HOT Change Managers'
    When I Click on Skip Assessments
    And I Navigate to the approvals tab
    And I click on the Approver record for 'Test ChangeManager3'
    And I Click on Approve
    Then The Change Record State changes to Awaiting Implementation
    When I Logoff and Login as
      | TestUser      |
      | Test User4    |
    And I Click on My Groups PIU Tasks module
    And I Navigate to the PIU record of Change Request Record
    And I Populate the PIU Record with the details
      | ChangeCompletedWithinChangeWindow | ChangeMetSuccessCriteria | AssetCINeedUpdating |
      | Yes							      | Yes                      | Yes				   |
    And I Click on Complete PIU
    When I Logoff and Login as
      | Change Manager      |
      | Test ChangeManager3 |
    And I Search and Open the Change Record
    And I populate the Change record with the information
      | ImplementationPlanAttached | ImplementationPlan       | PreImplTestEvidenceAttached | BackoutPlanAttached | PostImplVerificationSteps                   |
      | No                         | Implementation Plan Text |Yes                          | Yes                 | Post implementation verification steps text |
    And I Click on Save
    And I navigate to the Change Task titled 'Mandatory Fields'
    And I click Close Task
    And I Search and Open the Change Record
    Then The Change Record State changes to Awaiting PIR
    And I navigate to the Change Task titled 'PIR'
    And PIR Reason is displaying as Emergency Change
    And I populate the closed status as Completed with Issues
    And I click Close Task
    And I Search and Open the Change Record
    Then The Change Record State changes to Closed



    Scenario: Change 4

    Given I am Logged in ServiceNow as Admin
    When I Logoff and Login as
      | Change Manager      |
      | Test ChangeManager3 |
    And I Click on Create New in the Change module menu
    When I populate the Change/Release Ready Reckoner with the details
      | ITService    | EmergencyChange |
      | Test Service | Yes             |
    And I Click Calculate Score
    When I Click Go to Change
    Then New Change Request record is displayed
    When I Create a New Change Record with the details
      | Requestor  | ChangeTitle   | ChangeType | Template              |
      | Test User4 | Change Test 4 | Standard   | Test Service Template |
#    And I Select a Change Model Template 'Test Service Template' from Lookup
#    And I Click Lookup Using List function in Change Model field
#    And I Click New on Change Model Popup
#    And I Create a New Template record with the details
#      | Name 		  | Table	  	   | ShortDescription     | Groups	              |
#      | ATF Template  | Change Request | Test Change Template | *Test AssignmentGroup3 |
    And I Click on Save
#    And I Click on Submit for Validation
    And I populate the Change fields for Change4 test
      | PrimaryConfigItem      | RiskImpact | ChangeClassification | Description      | ReasonForChange        | StartDateTime | EndDateTime | ImplementationPlanAttached | ImplementationPlan       | PreImplTestEvidenceAttached | BackoutPlanAttached | PostImplVerificationSteps                   |
      | Test Service Component | 2- Medium  | Minor 		       | Description Text | Reason for change text | NOW           | NOW         | No                         | Implementation Plan Text | Yes                         | Yes                 | Post implementation verification steps text |
    And I Click on Submit for Validation
    And I Populate the Justification details for Change4 test
      | JustificationToExpedite	       |
      | Justification to expedite text |
    And I Click on Submit for Validation
    Then The Change Record State changes to Validation
    And I Click on the 'Assign to me' button next to the 'Assigned to' field
    Then Assigned to field displays as 'Test ChangeManager3'
    Then Assignment Group displays as 'HO Change Authority'
    Then I Click on the Change Assessors Tab
    And I add 'Test AssignmentGroup1' to the Internal Assessment groups
    And I add 'Test AssignmentGroup2' to the External Assessment groups
      When I Populate Accepted For Expediting
        | AcceptExpedite |
        | Yes            |
      And I Click on Save
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
    When I Logoff and Login as
        | AssignmentGroupUser     |
        | Test AssignmentGrpUser2 |
    And I Click on My Approvals in the External Change Assessment module
    And I Click on the Approval for the change request
    And I Click on the information button next to the Approving field
    Then AssignmentGroupUser can view the change record
    And I go back to the approval
    And I Click on Approve
    When I Logoff and Login as
      | ChangeManager       |
      | Test ChangeManager3 |
    And I Search and Open the Change Record
    And I Click on the 'Assign to me' button next to the 'Assigned to' field
    And I Click on Save
    And I Navigate to the approvals tab
    And I click on the Approver record for 'Test ChangeManager3'
    And I Click on Approve
    And I Search and Open the Change Record
    Then The Change Record State changes to Awaiting Implementation
    And a PIU Task is created when Change Endtime is elapsed
    When I Logoff and Login as
      | TestUser      |
      | Test User4    |
    And I Click on My Groups PIU Tasks module
    And I Navigate to the PIU record of Change Request Record
    And I Populate the PIU Record with the details
      | ChangeCompletedWithinChangeWindow | CompletionDetails       | ChangeMetSuccessCriteria | AssetCINeedUpdating |
      | No							      | Completion details text | Yes                      | Yes				 |
    And I Click on Complete PIU
    When I Logoff and Login as
      | Change Manager      |
      | Test ChangeManager3 |
    And I Search and Open the Change Record
    And I Navigate to the Tasks Tab
    And I Validate the PIR has been reopened with a PIR reason of Change Unsuccessful
    And I navigate to the Change Task titled 'PIR'
    And I populate the closed status as Completed with Issues
    And I click Close Task
    And I Search and Open the Change Record
    Then The Change Record State changes to Closed



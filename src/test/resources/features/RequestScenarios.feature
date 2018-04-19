Feature: Request Feature

  1. Request 1 - Create a new Request from the ESS Portal for one item and process through the approvals and fulfilment tasks to Acceptance
  2. Request 2 - Create a new Request from the ESS Portal for multiple Items and ensure that items can be rejected and the item can be disputed following fulfilment.
  3. Request 3 - Regression script contains a negative flow end to end test that includes SD Problem Manager RBACS, Problem Task Rejection and Re-opening a Problem record.

#  mvn test -Dcucumber.options="--tags @debug"
#
#  @Request
#  Scenario: Request 1
#    Given I am Logged in ServiceNow as Admin
#    When I Logoff and Login as ESS User
#      | TestIser   |
#      | Test User1 |
#    And I Click on Order Something
#    And I Select the User Access category
#    And I Select the User Access Software subcategory
#    And I Select the ASYS Access item
#    And I Populate ASYS record with the information
#      | WhatDoYouWantToDo | PoiseID    | AssetNumberPrefix    | AssetNumber | AsysAccessRequired | LevelOfAccessRequired | ASYSScanningCapabilityRequired |
#      | Provide		      | Test User1 | HOA                  | 1234123	    | Requirement text   | Requirement text 	 | Yes				               |
#    And I Add to cart
#    And I Edit item
#    And I update the record with the information
#      | AsysAccessRequired | LevelOfAccessRequired |
#      | Requirement text 2 | Requirement text 2	   |
#    And I Delete the item from the cart
#    And I Navigate to the homepage
#    And I Click on Order Something
#    And I Select the Hardware Access category
#    And I Select the Removable Storage subcategory
#    And I Select the Encrypted USB Memory Stick item
#    And I Populate the USB Memory Stick record with the information
#      | WhatDoYouWantToDo | PleaseSelectFromTheFollowing | PoiseID    | PermissionType  | WhatInfoIsMoving | BusinessBenefitOfMove | WhereFromAndTo          | Deskside | BusinessJustification | Quantity |
#      | Provide		      | Delivery			         | Test User1 | Read and Write  | Information text | Benefit text		   | Information moving text | Croydon  | Justification text    | 30       |
#    And I Add to cart
#    And I Edit item
#    Then the quantity has automatically changed to 20
#    And I Edit the quantity to 30
#    Then Quantity cap for this item is 20 message displayed
#    When I Edit the quantity to 1
#    And I Save to Regular Orders
#    And I name the regular order
#      | RegularOrderName |
#      | Test USB Order  |
#    And I Click on Checkout
#    And I Navigate to the homepage
#    And I Navigate to My Open Orders
#    And I Select the requested item
#    Then Order State displayed as 'Awaiting Approval'
#    And 'Escalate Approval' and 'Withdraw' buttons are displayed
#    Then the Approvers name is displayed
#      | Approver       |
#      | Test Approver1 |
#    When I Logout of ESS and Login to ServiceNow as Admin
#    Then New Request Raised email sent to the Requester 'Test User1'
#    Then an email is sent to the Approver
#    When I Logoff and Login as
#      | Approver       |
#      | Test Approver1 |
#    And I Click on My Approvals in the External Change Assessment module
#    And I Click on the Approval for the request item
#    And I Click on Approve
#    Then an email is sent to the 2nd Approver 'HODDaTRemMedApprovals'
#    When I Logoff and Login as ESS User
#      | TestUser   |
#      | Test User1 |
#    And I Navigate to My Open Orders
#    And I Select the requested item
#    Then Order State displayed as 'Awaiting Approval'
#    When I am Logged in ServiceNow as Admin
#    And I Search and Open the Request Item
#    And I Navigate to the approval task of the request item assigned to HODDaTRemMedApprovals
#    And I Click on Approve
#    Then an email is sent to the Fulfiller 'HODDaTRemMedApprovals'
#    When I Logoff and Login as ESS User
#      | TestUser   |
#      | Test User1 |
#    And I Navigate to My Open Orders
#    And I Select the requested item
#    Then Order State displayed as 'In Progress'
#    Then The estimated delivery date is displayed
#    When I Logout of ESS and Login to ServiceNow as Admin
#    And I Logoff and Login as
#      | HOTSSDRequestManagement |
#      | Test SSDReqManager1     |
#    And I Navigate to the Items module on the Service Catalog application menu
#    And I Navigate to the requested item
#    Then the user can view the request item fullfilment task in the tasks tab
#    When I Logoff and Login as
#      | Fulfilller                     |
#      | Test FJDeskSideSouthFulfiller1 |
#    And I Navigate to My Groups Work module
#    And I Select the fulfilment task for the requested item
#    Then the SLA assigned to the fulfilment task is appropriate for the quantity of items selected
##    And I assign the task to myself 'Test FJDeskSideSouthFulfiller1'
#    And I Assign the task to myself
#    And I Populate the work notes with 'Test Worknotes'
#    And I Populate the Customer Visible Notes with 'Test customer visible worknotes'
#    And I Populate the variables field with details '123123','MK23423','S23423'
#    And I Close the task with Notes 'Closure Notes'
#    Then an email is sent to the Requester 'Test User1' stating worknotes have been added
#    When I Logoff and Login as
#      | HOTSSDRequestManagement |
#      | Test SSDReqManager1     |
#    And I Navigate to the Items module on the Service Catalog application menu
#    And I Navigate to the requested item
#    And I Populate the Requested Item work notes with 'Test Worknotes'
#    And I Populate the Requested Item Customer Visible Notes with 'Test customer visible worknotes'
#    Then the user can view the request item fullfilment task in the tasks tab
#    Then an email is sent to the Requester 'Test User1' stating worknotes have been added
#    Then an email is sent to the Requester 'Test User1' Acceptance of the Item
#    When I Logoff and Login as ESS User
#      | TestUser   |
#      | Test User1 |
#    And I Navigate to My Open Orders
#    And I Select the requested item
#     Then Order State displayed as 'Awaiting Acceptance'
#    Then the user can view the customer visible work notes added to the record 'Test customer visible worknotes'
#    When I Click on Accept
#    And I Populate the comment box with 'Acceptance Thanks'
#    And I Navigate to the homepage
#    And I Navigate to My Open Orders
#    Then the requested item is not displayed
#    And I Navigate to My Closed Orders
#    Then the requested item is displayed
#    When I Logout of ESS and Login to ServiceNow as Admin
#    Then an email is sent to the Post implementation Fullfiller 'FujitsuHOLicensingTeam'
#    When I Logoff and Login as
#      | Fulfilller          |
#      | Test FJHOLicensing1 |
#    And I Navigate to My Groups Work module
#    And I Navigate to the Post Implementation Fulfillment Task
#    And I Close the task with Notes 'Test Closure Notes'
#    When I Logoff and Login as ESS User
#      | TestUser   |
#      | Test User1 |
#    And I Navigate to My Closed Orders
#    Then Order State displayed as 'Closed-Completed'
#    When I Logout of ESS and Login to ServiceNow as Admin
#    Then Closure email is sent to the Requester 'Test User1'
#
#
#
#
#
#
#
#
#
#
#  @debug
#  Scenario: Request 2
#    Given I am Logged in ServiceNow as Admin
#    When I Logoff and Login as ESS User
#      | TestUser   |
#      | Test User2 |
#    And I Click on Order Something
#    And I Select the User Access category
#    And I Select the User Access Software subcategory
#    And I Select the ASYS Access item
#    And I Populate ASYS record with the information
#      | WhatDoYouWantToDo | PoiseID    | AssetNumberPrefix    | AssetNumber | AsysAccessRequired | LevelOfAccessRequired | ASYSScanningCapabilityRequired |
#      | Provide		      | Test User2 | HOA                  | 1234123	    | Requirement text   | Requirement text 	 | Yes				              |
#    And I Add to cart
#    And I Continue Shopping
#    And I Search and Select item 'TE 070'
#    And I Populate the DDI record with the information
#      | WhatDoYouWantToDo | PoiseID    | DDINumbers  | BusinessJustification  |
#      | Add			      | Test User2 | 1234123     | Justification text     |
#    And I Add to cart
#    And I Click on Order Something from My Orders drop down list
#    And I Select the User Access category
#    And I Select the I-Manage subcategory
#    And I Select the I-Manage SyncPoint Access item
#    And I Populate the I-Manage SyncPoint Access record with the information
#      | WhatDoYouWantToDo | PoiseID    | AssetNumberPrefix | AssetNumber | BusinessJustification |
#      | Provide		      | Test User2 | HOA 		       | 1234121     | Justification text    |
#    And I Add to cart
#    And I Click on Checkout
#    And I Navigate to My Open Orders
#    And I Select the requested item A
#    Then First Order State displayed as 'Awaiting Approval'
#    And 'Escalate Approval' and 'Withdraw' buttons are displayed
#    Then the Approvers name is displayed
#      | Approver       |
#      | Test Approver1 |
#    Then email is sent to the Approver for Request A
#    And I Select the requested item B
#    Then Second Order State displayed as 'Awaiting Approval'
#    And 'Escalate Approval' and 'Withdraw' buttons are displayed
#    Then the Approvers name is displayed
#      | Approver       |
#      | Test Approver1 |
#    Then email is sent to the Approver for Request B
#    And I Select the requested item C
#    Then Third Order State displayed as 'Awaiting Approval'
#    And 'Escalate Approval' and 'Withdraw' buttons are displayed
#    Then the Approvers name is displayed
#      | Approver       |
#      | Test Approver1 |
#    Then email is sent to the Approver for Request C
#    Then New Request Raised email sent to the Requester 'Test User2'
#    When I Logoff and Login as
#      | Approver       |
#      | Test Approver1 |
#    And I Click on My Approvals in the External Change Assessment module
#    And I Click on the Approval entry for the request item A
#    And I Click on Approve
#    And I Click on the Approval entry for the request item B
#    And I Reject the entry with work notes 'Rejection reason'
#    And I Click on the Approval entry for the request item C
#    And I Request More Information with details 'I would like more information'
#    When I Logoff and Login as
#      | Approver            |
#      | Test SSDReqManager1 |
#    And I Search and Provide more info 'This is more information' for Request Item C
#    When I Logoff and Login as
#      | Approver       |
#      | Test Approver1 |
#    And I Click on My Approvals in the External Change Assessment module
#    And I Click on the Approval entry for the request item C
#    And I Reject the entry with work notes 'Rejection reason'
#    When I Logoff and Login as ESS User
#      | TestUser   |
#      | Test User2 |
#    And I Navigate to My Open Orders
#    And I Search for requested item A
#    Then First Order State displayed as 'In Progress'
#    Then The estimated delivery date displayed for Requested Item A
#    And I Navigate to My Closed Orders
#    And I Search for requested item B
#    Then Second Order State displayed as 'Closed-Rejected(Approver)'
#    And I Search for requested item C
#    Then Third Order State displayed as 'Closed-Rejected(Approver)'
#    When I Logout of ESS and Login to ServiceNow as Admin
#
#
###    And I Logoff and Login as
###      | TestApplicationSupportUser |
###      | Test AOApplicationSupport1 |
###    And I Navigate to My Groups Work module
###    And I Select the fulfilment task for the requested item
###    Then the SLA assigned to the fulfilment task is appropriate for the quantity of items selected
###    And I assign the task to myself
###   And I Populate the work notes with "Test Worknotes"
###    And I Populate the Customer Visible Notes with "Test customer visible worknotes"
###    And I Close the task
###    Then an email is sent to the Requester stating worknotes have been added
###   Then an email is sent to the second fulfiller
#
#
#    And I Logoff and Login as
#      | TestApplicationSupportUser |
#      | Test FJSYSCENFulfiller1    |
#    And I Search and Open Request Item A and Save the Task Number
#    And I Navigate to My Groups Work module
#    And I Select the fulfilment task for the requested item
#    Then SLA assigned to the fulfilment task is appropriate for the quantity of items selected
##    And I assign the task to myself 'Test FJSYSCENFulfiller1'
#    And I Assign the task to myself
#    And I Close the task with Notes 'Closure Notes'
#    When I Logoff and Login as ESS User
#      | TestUser   |
#      | Test User2 |
#    And I Navigate to My Open Orders
#    And I Search for requested item A
#    When I Click on Dispute and provide comments 'Dispute Comments'
#    Then an Incident has been created
#    And New Incident notification Email has been sent to the user
#    When I Logoff and Login as ESS User
#      | TestUser   |
#      | Test User2 |
#    And I Navigate to My Open Incidents
#    And I Search for Request Incident
#    Then First Incident State displayed as 'New'
#    When I Logout of ESS and Login to ServiceNow as Admin
#    When I Logoff and Login as
#      | RequestManager      |
#      | Test SSDReqManager1 |
#    And I Select IncidentNo from My Assignment Groups Open Incidents link
#    And I Progress the Request Incident to 'In Progress' State
#    And I Progress the Request Incident to 'Resolved' State
#      | ResolutionCode        | ResolutionNotes     |
#      | Solved (Work Around)  | Resolution Details  |
#    And Closure notification Email has been sent to the user
#    When I Logoff and Login as ESS User
#      | TestUser   |
#      | Test User2 |
#    And I Navigate to My Closed Orders
#    And I Search for requested item A
#    Then First Order State displayed as 'Closed-Completed'




  Scenario: Request 3

    Given I am Logged in ServiceNow as Admin
#    When I Logoff and Login as ESS User
#      | TestUser   |
#      | Test User3 |
#    And I Click on Order Something
#    And I Search for 'USB' and validate order items only are listed
#    And I Navigate to the homepage
#    And I Click on Order Something
#    And I Search and Select item 'ASYS Access'
#    And I Populate ASYS record with the information
#      | WhatDoYouWantToDo | PoiseID    | AssetNumberPrefix    | AssetNumber | AsysAccessRequired | LevelOfAccessRequired | ASYSScanningCapabilityRequired |
#      | Provide		      | Test User3 | HOA                  | 1234123	    | Requirement text   | Requirement text 	 | Yes				              |
#    And I Add to cart
#    And I Click on Checkout
#    And I Navigate to the homepage
#    And I Navigate to My Open Orders
#    And I Select the requested item
#    Then First Order State displayed as 'Awaiting Approval'
#    And 'Escalate Approval' and 'Withdraw' buttons are displayed
#    Then the Approvers name is displayed
#      | Approver       |
#      | Test Approver1 |
#    Then an email is sent to the Approver
#    Then New Request Raised email sent to the Requester 'Test User3'
#    When I Logoff and Login as
#      | Approver       |
#      | Test Approver1 |
#    And I Click on My Approvals in the External Change Assessment module
#    And I Click on the Approval for the request item
#    And I Click on Approve
    When I Logoff and Login as
      | Approver                   |
      | Test AOApplicationSupport1 |
    And I Open the Request Item and Save Delivery date and Task Number
    And I Navigate to My Groups Work module
    And I Select the fulfilment task for the requested item
    Then SLA assigned to the fulfilment task is appropriate for the quantity of items selected
    And I Assign the task to myself
    And I Progress the task to Awaiting User with Notes 'Awaiting User notes'
    Then the task SLA has been paused
    And I Progress the task to In Progress with Notes 'Revert to In Progress Notes'
    Then the task SLA has been presumed
    Then I Open the Request Item and verify that Delivery date is updated
    And I Progress the task to Awaiting User with Notes 'Awaiting User notes'
    Then the task SLA has been paused
##    And I wait 1 hour
#    And I Progress the task to In Progress with Notes 'Revert to In Progress Notes'
#    Then the task SLA has been presumed
#    Then I Open the Request Item and verify that Delivery date is updated
##    Then an update email is sent to the requester
#    And I Close the task with Notes 'Closure Notes'
##    Then an email is sent to the post implementation fulfiller
#    When I Logoff and Login as
#      | Fulfilller          |
#      | Test FJHOLicensing1 |
#    And I Navigate to My Groups Work module
#    And I Navigate to the Post Implementation Fulfillment Task
#    And I Close the task with Notes 'Test Closure Notes'




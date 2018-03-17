Feature: Request Feature

  1. Request 1 - Create a new Request from the ESS Portal for one item and process through the approvals and fulfilment tasks to Acceptance
  2. Request 2 - Create a new Request from the ESS Portal for multiple Items and ensure that items can be rejected and the item can be disputed following fulfilment.
  3. Request 3 - Regression script contains a negative flow end to end test that includes SD Problem Manager RBACS, Problem Task Rejection and Re-opening a Problem record.

  Scenario: Request 1

    Given I am Logged in ServiceNow as Admin
    When I Logoff and Login as ESS User
      | TestIser   |
      | Test User1 |
    And I Click on Order Something
    And I Select the User Access category
    And I Select the User Access Software subcategory
    And I Select the ASYS Access item
    And I Populate ASYS record with the information
      | WhatDoYouWantToDo | PoiseID    | AssetNumberPrefix    | AssetNumber | AsysAccessRequired | LevelOfAccessRequired | ASYSScanningCapabilityRequired |
      | Provide		      | Test User1 | HOA                  | 1234123	 | Requirement text   | Requirement text 	  | Yes				               |
    And I Add to cart
    And I Edit item
    And I update the record with the information
      | AsysAccessRequired | LevelOfAccessRequired |
      | Requirement text 2 | Requirement text 2	   |
    And I Delete the item from the cart
    And I Navigate to the homepage
    And I Click on Order Something
    And I Select the Hardware Access category
    And I Select the Removable Storage subcategory
    And I Select the Encrypted USB Memory Stick item
    And I Populate the USB Memory Stick record with the information
      | WhatDoYouWantToDo | PleaseSelectFromTheFollowing | PoiseID    | PermissionType  | WhatInfoIsMoving | BusinessBenefitOfMove | WhereFromAndTo          | Deskside | BusinessJustification | Quantity |
      | Provide		      | Delivery			         | Test User1 | Read and Write  | Information text | Benefit text		   | Information moving text | Croydon  | Justification text    | 30       |
    And I Add to cart
    And I Edit item
    Then the quantity has automatically changed to 20
    And I Edit the quantity to 30
    Then Quantity cap for this item is 20 message displayed
    And I Save to Regular Orders
    And I name the regular order
      | RegularOrderName |
      | Test USB Order1  |
    And I Click on Checkout
#    And I Navigate to the homepage
#    And I Navigate to My Open Orders
#    And I Select the reqested item
#    Then the state is Awaiting Approval
#    Then the Escalate and Withraw buttons are displayed
#    Then the Approvers name is displayed
#    Then an emial is sent to the requester
#    Then an email is sent to the Approver
#    When I Logoff and Login as
#      | Approver       |
#      | Test Approver1 |
#    And I Navigate to the 'My Approvals' module on the Self-Service Application Menu
#    And I Navigate to the request item
#    And I Navigate to the approval task of the request item
#    And I Approve
#    Then an email is sent to the 2nd Approver
#    When I Logoff and Login as
#      | TestUser   |
#      | Test User1 |
#    And I Navigate to My Open Orders
#    And I Select the reqested item
#    Then the state is Awaiting Approval
#    When I am Logged in ServiceNow as Admin
#    And I Navigate to the request item
#    And I Navigate to the approval task of the request item assigned to HODDaTRemMedApprovals
#    And I Approve
#    Then an email is sent to the Fulfiller
#    When I Logoff and Login as
#      | TestUser   |
#      | Test User1 |
#    And I Navigate to My Open Orders
#    And I Select the reqested item
#    Then the state is In Progress
#    Then The the estimated delivery date is displayed
#    When I Logoff and Login as
#      | HOTSSDRequestManagement |
#      | Test SSDReqManager1     |
#    And I Navigate to the Items module on the Service Catalog application menu
#    And I Navigate to the requested item
#    Then the user can view the request item fullfilment task in the tasks tab
#    When I Logoff and Login as
#      | Fulfilller                     |
#      | Test FJDeskSideSouthFulfiller1 |
#    And I Navigate to My Groups Work module
#    And I Select the fultilment task for the requested item
#    Then the SLA assigned to the fulfilment task is appropriate for the quantity of items selected
#    And I assign the task to myself
#    And I Populate the work notes with "Test Worknotes"
#    And I Populate the Customer Visible Notes with "Test customer visible worknotes"
#    And I Populate the variables field
#    And I Close the task
#    Then an email is sent to the Requester stating worknotes have been added
#    When I Logoff and Login as
#      | HOTSSDRequestManagement |
#      | Test SSDReqManager1     |
#    And I Navigate to the Items module on the Service Catalog application menu
#    And I Navigate to the requested item
#    Then the user can view the request item fullfilment task in the tasks tab
#    And I Populate the work notes with "Test Worknotes"
#    And I Populate the Customer Visible Notes with "Test customer visible worknotes"
#    And I Save
#    Then an email is sent to the Requester stating worknotes have been added
#    Then an email is sent to the Requester requesting Acceptance of the Item
#    When I Logoff and Login as
#      | TestUser   |
#      | Test User1 |
#    And I Navigate to My Open Orders
#    And I Select the reqested item
#    Then the state is Awaiting Acceptance
#    Then the user can view the customer visibile work notes added to the record
#    And I Accept
#  and I Populate the comment box with "Acceptance Thanks"
#    And I Navigate to the homepage
#    And I Navigate to My Open Orders
#    Then the requested item is not displayed
#    And I Navigate to My Closed Orders
#    Then the requested item is displayed
#    Then an email is sent to the Post implementaiton Fullfiller
#    When I Logoff and Login as
#      | Fulfilller          |
#      | Test FJHOLicensing1 |
#    Given I login as fulfiller "TestFJHOLicensing1
#    And I Navigate to My Groups Work module
#    And I Navigate to the Post Implementation Fulfillment Task
#    And I Close Task
#    And I Populate the work notes with "Test Worknotes"
#    And I Close the task
#    When I Logoff and Login as
#      | TestUser   |
#      | Test User1 |
#    And I Navigate to My Closed Orders
#    Then the state is Closed
#    Then an email is sent to the Requester

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
#  Request 2
#
#  Create a new Request from the ESS Portal for multiple Items and ensure that items can be rejected and the item can be disputed following fulfilment.
#
#
#
#
#    Given I login as "Test User2"
#    And I Click on Order Something
#    And I Select the User Access category
#    And I Select the User Access Software subcategory
#    And I Select the ASYS Access item
#    And I Populate the record with the information
#      | What do you want to do? | Poise ID   | Asset Number Prefix | Asset Number | Asys Access Required | Level of Access required | ASYS Scanning Capability required |
#      | Provide		  | Test User2 | HOA 		     | 1234123	    | Requirement text     | Requirement text 	      | Yes				  |
#
#    And I add to cart
#    And I Continue Shopping
#
#    And I Populate the search box with "TE 070"
#    And I Select the item
#    And I Populate the record with the information
#      | What do you want to do? | Poise ID   | DDI Numbers | Business Justification |
#      | Add			  | Test User1 | 1234123     | Justification text     |
#
#    And I add to cart
#
#    And I Navigate to the My Orders drop down list
#    And I Click on Order Something
#    And I Select the User Access category
#    And I Select the I-Manage subcategory
#    And I Select the I-Manage SyncPoint Access item
#    And I Populate the record with the information
#      | What do you want to do? | Poise ID   | Asset Number Prefix | Asset Number | Business Justification |
#      | Provide		  | Test User1 | HOA 		     | 1234121      | Justification text     |
#
#    And I add to cart
#    And I view Cart
#    And I checkout
#
#    And I Navigate to the homepage
#    And I Navigate to My Open Orders
#
#    And I Select the requested item A
#    Then the state is Awaiting Approval
#    Then the Escalate and Withraw buttons are displayed
#    Then the Approvers name is displayed
#    Then an email is sent to the Approver
#
#    And I Select the requested item B
#    Then the state is Awaiting Approval
#    Then the Escalate and Withraw buttons are displayed
#    Then the Approvers name is displayed
#    Then an email is sent to the Approver
#
#    And I Select the requested item C
#    Then the state is Awaiting Approval
#    Then the Escalate and Withraw buttons are displayed
#    Then the Approvers name is displayed
#    Then an email is sent to the Approver
#
#    Then an email is sent to the requester
#
#
#
#    Given I logoff and login as ****Approver Item A****
#    And I Navigate to the 'My Approvals' module on the Self-Service Application Menu
#    And I Navigate to the request item A
#    And I Navigate to the approval task of the request item
#    And I Approve
#
#
#
#    Given I logoff and login as ****Approver Item B****
#    And I Navigate to the 'My Approvals' module on the Self-Service Application Menu
#    And I Navigate to the request item B
#    And I Navigate to the approval task of the request item
#    And I Populate the work notes with "Rejection reason"
#    And I Reject
#
#
#
#    Given I logoff and login as ****Approver Item C****
#    And I Navigate to the Approval email
#    And I Request More Information
#    And I Populate the email template with "I would like more information"
#    And I send
#
#
#
#    Given I login as "Test User2"
#    And I Navigate to my emails
#    And I Navigate to the email requesting more information
#    And I Populate the email template with "This is the more information"
#    And I send
#
#
#
#    Given I logoff and login as ****Approver Item C****
#    And I Navigate to the 'My Approvals' module on the Self-Service Application Menu
#    And I Navigate to the request item C
#    And I Navigate to the approval task of the request item
#    And I Populate the work notes with "Rejection reason"
#    And I Reject
#
#
#
#    Given I login as "Test User1"
#    And I Navigate to My Open Orders
#    And I Select requested item A
#    Then the state is In Progress
#    Then the estimated delivery date is displayed
#
#    And I Navigate to My Open Orders
#    And I Select requested item B
#    Then the state is Closed
#
#
#    And I Navigate to My Open Orders
#    And I Select requested item C
#    Then the state is Closed
#
#
#
#    Given I login as ***Fulfiller Item A/ AO Applicatin Support/ David Why****
#    And I Navigate to My Groups Work module
#    And I Select the fultilment task for the requested item
#    Then the SLA assigned to the fulfilment task is appropriate for the quantity of items selected
#    And I assign the task to myself
#    And I Populate the work notes with "Test Worknotes"
#    And I Populate the Customer Visible Notes with "Test customer visible worknotes"
#    And I Close the task
#    Then an email is sent to the Requester stating worknotes have been added
#    Then an email is sent to the second fulfiller
#
#
#
#
#    Given I login as ***Fulfiller Item A/ FY SYSCEN/ Geoff Robinson****
#    And I Navigate to My Work module
#    And I Select the fultilment task for the requested item
#    Then the SLA assigned to the fulfilment task is appropriate for the quantity of items selected
#    And I assign the task to myself
#    And I Close the task
#
#
#
#
#    Given I login as "Test User1"
#    And I Navigate to My Open Orders
#    And I Select requested item A
#    And I dispute
#    Then an Incident has been created
#    Then Test User 1 recieves an email notification about the incident
#    And I Navigate to My Open Incidents
#    And I Select the Incident
#    Then the incident is in New state
#
#
#
#
#    Given I logogg and login as *****HOT SSD Request Management member/ Indi Jordan*****
#    Then the disputed incident is displaying in the HOT SSD Request Management Incident list
#    And I Navigate to the incident record
#    Then the fields have been prePopulated with details from the user
#    And I Populate the record with the informaion
#      | ????	| ???? |
#      | ????	| ???? |
#
#    And I progress the incident to In Progress
#    And I save
#    And I progress the incident to Resolved
#    And I Populate the record with the informaion
#      | ????	| ???? |
#      | ????	| ???? |
#    And I save
#    Then the requester has recieved a Closure notification email
#
#
#    Given I login as "Test User1"
#    And I Navigate to My Closed Orders
#    And all requested items are displyed
#
#
#
#  Request 3
#
#  Create a new request, process and validate the SLA is paused when in a state of Awaiting User. Checking Level 1 and Level 2 choices, and Poise ID field
#
#
#    Given I login as "Test User3"
#    And I Click on Order Something
#    And I Populate the search field with "USB"
#    Then the items in the drop down list are order items only
#    And I run the search
#    Then the search results are order items only
#
#
#    And I Navigate back to the homepage
#    And I Select Order Something
#    And I search for "ASYS Access"
#    And I Select the item
#    And I Populate the record with the information
#
#      | What do you want to do? | Poise ID   | Asset Number Prefix | Asset Number | Asys Access Required | Level of Access required | ASYS Scanning Capability required |
#      | Provide		  | Test User3 | HOA 		     | 1234123	    | Requirement text     | Requirement text 	      | Yes				  |
#
#    And I add to cart
#    And I view cart
#    And I checkout
#
#
#    And I Navigate to the homepage
#    And I Navigate to My Open Orders
#
#    And I Select the requested item
#    Then the state is Awaiting Approval
#    Then the Escalate and Withraw buttons are displayed
#    Then the Approvers name is displayed
#    Then an email is sent to the Approver
#    Then an email is sent to the requester
#
#    Given I logoff and login as ****Approver Item A****
#    And I Navigate to the 'My Approvals' module on the Self-Service Application Menu
#    And I Navigate to the request item A
#    And I Navigate to the approval task of the request item
#    And I Approve
#
#
#    Given I login as ***Fulfiller Item A/ AO Applicatin Support/ Peter Young****
#    And I Navigate to My Groups Work module
#    And I Select the fultilment task for the requested item
#    Then the SLA assigned to the fulfilment task is appropriate for the quantity of items selected
#    And I assign the task to myself
#    And I Populate the worknotes with "Awaiting User notes"
#    And I progress the task to Awaiting User
#    Then the task SLA has been paused
#
#
#    And I Populate the worknotes with "Revert to In Progress Notes"
#    And I progress the task to In Progress
#
#
#    Then the task SLA has been presumed
#    Then the delivery date on the request item has been updated
#
#
#
#
#
#
#    And I Populate the worknotes with "Awaiting User notes"
#    And I progress the task to Awaiting User
#    Then the task SLA has been paused
#    And I wait 1 hour
#
#    And I Populate the worknotes with "Revert to In Progress Notes"
#    And I progress the task to In Progress
#
#
#    Then the task SLA has been presumed
#    Then the delivery date on the request item has been updated
#
#    Then an update email is sent to the requester
#
#    And I Close the task
#    Then an email is sent to the post implementation fulfiller
#
#
#
#
#
#
#
#    Given I login as ***Post implementation Fulfiller Item A/ FJ Home Office/ Lisa Harding****
#    And I Navigate to My Groups Work module on the Service Catalog application
#    And I Navigate to the post implementation task
#    And I Populate the worknotes with "close task notes"
#    And I Close the task
#
#
#

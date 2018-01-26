Feature: Change Feature

  1. Change 1 - The puspose of this test is to validate that a normal change can be created by the Change Analysts, processed through the states and closed with a successful PIU

  Scenario Outline: Change 1
    Given I am Logged in ServiceNow as Admin
    When I Logoff and Login as <ChangeAnalyst>
    And I Create a new Change with details in the Ready Reckoner page <ITService>, <StandardChange>, <NewService>, <MultiEnvironment>, <MultipleSuppliers>, <ImpactToOtherSystems>, <GroupOfChanges>
    Then Risk and Impact Score Calculated and Change Record is calculated
    When I click on Submit for Validation button
    Then Mandatory fields are prompted for completion
    When I complete all the mandatory fields and click on Submit for Validation
    Then Change record created and moves into the state of Validation

    Examples:
      | ChangeAnalyst | ITService            | StandardChange | NewService | MultiEnvironment | MultipleSuppliers | ImpactToOtherSystems | GroupOfChanges |
      | Amanda Monks  | Service Now (IT Svc) | No             | No         | No               | No                | No                   | No             |

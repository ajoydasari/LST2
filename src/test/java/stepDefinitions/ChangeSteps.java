package stepDefinitions;

import Utilities.Util;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataObjects.ChangeData;
import dataObjects.PIUData;
import dataObjects.ReadyReckonerData;
import dataObjects.RiskImpactData;
import pageObjects.*;

import java.util.List;

public class ChangeSteps  extends Util {


    private String changeNo;
    private ReadyReckonerData readyReckonerData;
    private ChangeData changeData;
    private ChangeData change1Data;
    private ChangeData change2Data;
    private ChangeData change3Data;
    private RiskImpactData riskImpactData;
    private PIUData piuData;

    public ChangeSteps(){
        readyReckonerData = new ReadyReckonerData();
        change1Data = new ChangeData();
        change2Data = new ChangeData();
        change3Data = new ChangeData();
        riskImpactData = new RiskImpactData();
        piuData = new PIUData();
    }

    public ChangeData GetChangeObject(String ChangeNumber)
    {
        switch (ChangeNumber) {
            case "Change":
                changeData = change1Data;
                break;
            case "Change2":
                changeData = change2Data;
                break;
            case "Change3":
                changeData = change3Data;
                break;
            default:
                changeData = change1Data;
        }
        return  changeData;
    }



    @When("^I Click on Create New in the Change module menu$")
    public void i_Create_a_new_Problem_with_details() {
        new HomePage().SelectAllAppsTab();
        LHSNavigationPage favPage = new LHSNavigationPage();
        favPage.CreateNewChange();
    }


    @When("^I populate the Change/Release Ready Reckoner with the details$")
    public void i_populate_the_Change_Release_Ready_Reckoner_with_the_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        readyReckonerData.initialize(data);
        new ReadyReckonerPage().CompleteReadyReckoner(readyReckonerData);
  }

    @When("^I Click Calculate Score$")
    public void i_Click_Calculate_Score() {
        new ReadyReckonerPage().CalculateScore();
  }

    @When("^I Click Go to Change$")
    public void i_Click_Go_to_Change() {
        new ReadyReckonerPage().GoToChange();
    }

    @Then("^New Change Request record is displayed$")
    public void new_Change_Request_record_is_displayed() {
        new ChangePage().WaitForPageLoad();
        new ChangePage().NewChangeRecordDisplayed();
    }

    @Then("^I Create a New Change Record with the details$")
    public void i_Create_a_New_Change_Record_with_the_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        change1Data.initialize(data);
        changeNo = new ChangePage().NewChange(change1Data);
        SaveData("Change1",changeNo);
    }

    @When("^I Click on Complete Risk and Impact button$")
    public void i_Click_on_Complete_Risk_and_Impact_button() {
        new ChangePage().CompleteRiskImpact();
    }

    @Then("^Change Risk and Impact Record is displayed$")
    public void change_Risk_and_Impact_Record_is_displayed() {
        new RiskImpactPage().WaitForPageLoad();
    }

    @Then("^I Create a New Change Risk and Impact Record with the details$")
    public void i_Create_a_New_Change_Risk_and_Impact_Record_with_the_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        riskImpactData.initialize(data);
        new RiskImpactPage().CompleteNewRecordDetails(riskImpactData);
    }

    @Then("^I Click on Complete Risks and Impact$")
    public void i_Click_on_Complete_Risks_and_Impact() {
        new RiskImpactPage().ClickCompleteRiskImpact();
  }


    @Then("^The Page Automatically Reloads to Change Request Record(.*)$")
    public void the_Page_Automatically_Reloads_to_Change_Request_Record(String changeNo) {
        changeNo = RetrieveData("Change1");
        new ChangePage().WaitForPageLoad();
        new ChangePage().VerifyChangeRecordLoaded(changeNo);
    }

    @Then("^I populate the Change fields$")
    public void i_populate_the_Change_fields(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        change1Data.initialize(data);
        new ChangePage().PopulateChangeDetails(change1Data);
    }

    @Then("^I Click on Submit for Validation$")
    public void i_Click_on_Submit_for_Validation() {
        ChangePage changePage = new ChangePage();
        changePage.ClickSubmitForValidation();
 }


    @Then("^I Click on Submit for Validation second time$")
    public void i_Click_on_Submit_for_Validation_second_time() {
        ChangePage changePage = new ChangePage();
        changePage.ClickSubmitForValidation();
        changePage.WaitForRequestAssessments();
    }


    @Then("^I Populate the Justification details$")
    public void i_Populate_the_Justification_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        change1Data.initialize(data);
        new ChangePage().PopulateExpediteJustification(change1Data);
    }

    @Then("^The Change Record State changes to (.*)$")
    public void the_State_changes_to_Validation(String status) {
        ChangePage changePage = new ChangePage();
        changePage.VerifyChangeRecordStatus(status);
        WaitForPageRefresh();
    }

    @Then("^I Click on the 'Assign to me' button next to the 'Assigned to' field$")
    public void i_Click_on_the_Assign_to_me_button_next_to_the_Assigned_to_field() {
        new ChangePage().AssignToMe();
    }

    @Then("^Assigned to field displays as '(.*)'$")
    public void assigned_to_field_displays_as_Test_Change_Analyst(String username) {
        new ChangePage().VerifyAssignedTo(username);
    }

    @Then("^Assignment Group displays as '(.*)'$")
    public void assignment_Group_displays_as(String group) {
        new ChangePage().VerifyAssignmentGroup(group);
     }

    @When("^I populate the Change Classification$")
    public void i_populate_the_Change_Classification(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        change1Data.initialize(data);
        new ChangePage().PopulateChangeClassification(change1Data);
    }

    @When("^I Click on Request Assessments$")
    public void i_Click_on_Request_Assessments() {
        ChangePage changePage = new ChangePage();
        changePage.ClickRequestAssessments();
        changePage.validateIsAt();
  }


    @When("^I Click on My Approvals in the External Change Assessment module$")
    public void i_Click_on_My_Approvals_in_the_External_Change_Assessment_module() {
        new LHSNavigationPage().Change_MyApprovals();
    }

    @When("^I Click on the Approval for the change request$")
    public void i_Click_on_the_Approval_for_the_change_request() {
        changeNo = RetrieveData("Change1");
        new ApprovalListPage().selectRecord(changeNo);
        new ApprovalPage().WaitForPageLoad(changeNo);
//        WaitForPageRefresh();
    }

    @When("^I Click on the information button next to the Approving field$")
    public void i_Click_on_the_information_button_next_to_the_Approving_field() {
        new ApprovalPage().selectApprovingInfo();
//        WaitForPageRefresh();
    }

    @Then("^AssignmentGroupUser can view the change record$")
    public void assignmentgroupuser_can_view_the_change_record() {
        new ChangePage().validateIsAt();
  }

    @Then("^I go back to the approval$")
    public void i_go_back_to_the_approval() {
        changeNo = RetrieveData("Change1");
        new CommonPageObjects().NavigateBack();
        new ApprovalPage().WaitForPageLoad(changeNo);
  }

    @Then("^I Click on Approve$")
    public void i_Click_on_Approve() {
        new ApprovalPage().clickApprove();
 }

    @Then("^ChangeManager can view the change record$")
    public void changemanager_can_view_the_change_record() {
        new ChangePage().validateIsAt26();
 }

    @Then("^I Navigate to the Change Record$")
    public void i_Navigate_to_the_Change_Record() {
        new CommonPageObjects().Find_Record("Change1");
    }

    @Then("^a PIU Task is created when Change Endtime is elapsed$")
    public void a_PIU_Task_is_created_when_Change_Endtime_is_elapsed() {
        new ChangePage().ValidatePIURecordCreated();
     }


    @When("^I Navigate to the PIU Record$")
    public void i_Navigate_to_the_PIU_Record() {
        new ChangePage().ClickPIURecord();
    }

    @When("^I Populate the PIU Record with the details$")
    public void i_Populate_the_PIU_Record_with_the_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        piuData.initialize(data);
        new PIUPage().populatePIURecord(piuData);
    }

    @When("^I Click on Complete PIU$")
    public void i_Click_on_Complete_PIU() {
        new PIUPage().CompletePIU();
    }

    @When("^I Search and Open the Change Record$")
    public void i_Search_and_Open_the_Incident1(){
        new CommonPageObjects().Find_Record("Change1");
    }


}

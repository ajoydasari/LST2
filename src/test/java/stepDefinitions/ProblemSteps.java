package stepDefinitions;

import Utilities.Util;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataObjects.*;
import org.apache.commons.lang.time.DateUtils;
import pageObjects.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProblemSteps extends Util {
    private String problemNo,problemTaskNo;
    private ProblemData problemData;
    private ProblemData problem1Data;

    public ProblemSteps(){
        problem1Data = new ProblemData();
    }

    public ProblemData GetProblemObject(String ProblemNumber)
    {
        switch (ProblemNumber) {
            case "Problem":
                problemData = problem1Data;
                break;
            default:
                problemData = problem1Data;
        }
        return  problemData;
    }




    @When("^I Create a new Problem record with details$")
    public void i_Create_a_new_Problem_with_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();

        new HomePage().SelectAllAppsTab();

        LHSNavigationPage favPage = new LHSNavigationPage();
        favPage.CreateNewProblem();

        ProblemPage problemPage = new ProblemPage();
        problemData = GetProblemObject("Problem");
        problemData.initialize(data);
        problemNo = problemPage.NewProblem(problemData);

        SaveData("Problem", problemNo);
    }


    @When("^I Change the Problem Status to Assigned$")
    public void i_Change_the_Problem_Status_to_Assigned(){
        ProblemPage problemPage = new ProblemPage();
        problemPage.ChangeProblemStatusWithoutSave("Assigned");
    }


    @When("^I Change the Problem Status to In Progress$")
    public void i_Change_the_Problem_Status_to_In_Progress(){
        ProblemPage problemPage = new ProblemPage();
        problemPage.ChangeProblemStatus("In Progress");
        problemPage.VerifyInProgressReadOnlyFields();
    }


    @When("^I Change the Problem Status to Known Error$")
    public void i_Change_the_Problem_Status_to_Known_Error(){
        ProblemPage problemPage = new ProblemPage();
        problemPage.ValidateKnownErrorField();
        problemPage.ChangeProblemStatus("Known Error");
        problemPage.VerifyKnownErrorTicked();
    }


    @When("^I populate the Assignment group and Save$")
    public void populate_the_Assignment_group_to(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemPage problemPage = new ProblemPage();
        problemData = GetProblemObject("Problem");
        problemData.initialize(data);
        problemPage.ChangeAssignmentGroup(problemData.AssignmentGroup);
        problemPage.VerifyAssignmentReadOnlyFields();
    }

    public void Find_Problem(String ProblemNumber){
        problemNo = RetrieveData(ProblemNumber);
        new HomePage().GlobalSearch(problemNo);
        WaitForPageRefresh();
    }

    @When("^I Search and Open the Problem$")
    public void i_Search_and_Open_the_Incident1(){
        Find_Problem("Problem");
    }


    @Then("^I populate the Workaround details$")
    public void i_populate_the_Workaround_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemPage problemPage = new ProblemPage();
        problemData = GetProblemObject("Problem");
        problemData.initialize(data);
        problemPage.CompleteWorkAround(problemData.Workaround);
    }

    @Then("^I populate Rootcause Information$")
    public void i_populate_Rootcause_Information(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemPage problemPage = new ProblemPage();
        problemData = GetProblemObject("Problem");
        problemData.initialize(data);
        problemPage.CompleteRootCause(problemData.RootcauseInfo);
    }



    @Then("^I populate the WorkNotes with details$")
    public void I_populate_the_WorkNotes_with_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemTaskPage problemTaskPage = new ProblemTaskPage();
        problemData = GetProblemObject("Problem");
        problemData.taskData1.initialize(data);
        problemTaskPage.CompleteWorkNotes(problemData.taskData1);
    }

    @When("^I click New in the Problem Tasks Tab$")
    public void i_click_New_in_the_Problem_Tasks_Tab() {
        new ProblemPage().CreateNewTask();
    }

    @Then("^ShortDescription has been automatically populated with the Problem Title from the Problem Record$")
    public void shortdescription_has_been_automatically_populated_with_the_Problem_Title_from_the_Problem_Record() {
        ProblemTaskPage taskPage = new ProblemTaskPage();
        problemData = GetProblemObject("Problem");
        taskPage.VerifyShortDescriptionCopiedFromProblem(problemData);
    }

    @Then("^OwningGroup has been automatically populated with the Problem Assignment Group$")
    public void owninggroup_has_been_automatically_populated_with_the_Problem_Assignment_Group() {
        ProblemTaskPage taskPage = new ProblemTaskPage();
        problemData = GetProblemObject("Problem");
        taskPage.VerifyOwningGroupCopiedFromProblem(problemData);
    }

    @Then("^Opened field has been automatically populated with the date and time$")
    public void opened_field_has_been_automatically_populated_with_the_date_and_time() {
        ProblemTaskPage taskPage = new ProblemTaskPage();
        problemData = GetProblemObject("Problem");
        taskPage.SelectResolutionTab();
        taskPage.VerifyOpenedAtFieldValue(problemData);
    }

    @Then("^I populate the task with details$")
    public void i_populate_the_task_with_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemTaskPage taskPage = new ProblemTaskPage();
        problemData = GetProblemObject("Problem");
        problemData.taskData1.initialize(data);
        problemTaskNo = taskPage.CompleteTaskDetails(problemData.taskData1);
        SaveData("ProblemTask", problemTaskNo);
    }


    @Then("^I populate the Task 2 with details$")
    public void i_populate_the_task2_with_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemTaskPage taskPage = new ProblemTaskPage();
        problemData = GetProblemObject("Problem");
        problemData.taskData2.initialize(data);
        problemTaskNo = taskPage.CompleteTaskDetails(problemData.taskData2);
        SaveData("ProblemTask2", problemTaskNo);
    }



    @Then("^I populate the Task 3 with details$")
    public void i_populate_the_task3_with_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemTaskPage taskPage = new ProblemTaskPage();
        problemData = GetProblemObject("Problem");
        problemData.taskData3.initialize(data);
        problemTaskNo = taskPage.CompleteTaskDetails(problemData.taskData3);
        SaveData("ProblemTask3", problemTaskNo);
    }



    @When("^I Change DueDate field to \\+1 days$")
    public void i_Change_DueDate_field_to_plus1days() {
        new ProblemTaskPage().SetDueDateToTomorrow();
    }



    @When("^I Change DueDate field to \\-3 days$")
    public void i_Change_DueDate_field_to_minus3days() {
        new ProblemTaskPage().SetDueDateToMinus3Days();
    }


    @Then("^Extension Count field is automatically changed to \"1\"$")
    public void extention_Count_field_is_automatically_changed_to()
    {
     new ProblemTaskPage().VerifyExtensionCount("1");
    }



    @Then("^Extension Count field stay as \"1\"$")
    public void extension_Count_field_stay_as() {
        new ProblemTaskPage().VerifyExtensionCount("1");
    }



    @Then("^I Change the Task Status to (.*)$")
    public void I_Change_the_Task_Status_to(String status) {
        new ProblemTaskPage().ChangeTaskStatus(status);
    }

    @Then("^Resolved field is automatically populated with the resolved date and time$")
    public void resolved_field_is_automatically_populated_with_the_resolved_date_and_time() {
        ProblemTaskPage taskPage = new ProblemTaskPage();
        problemData = GetProblemObject("Problem");
        taskPage.SelectResolutionTab();
        taskPage.VerifyResolvedFieldValue(problemData);
    }


    @When("^I Navigate back to the Problem record$")
    public void i_Navigate_back_to_the_Problem_record() {
        new ProblemTaskPage().NavigateBackToProblem();
    }



    @When("^I Change the Problem Status to Awaiting Implementation with the details$")
    public void I_Change_the_Problem_Status_to_Awaiting_Implementation_with_the_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemPage problemPage = new ProblemPage();
        problemData = GetProblemObject("Problem");
        problemData.initialize(data);
        problemPage.AwaitingImplementation(problemData);
    }



    @When("^I Change the Problem Status to Resolved with the details$")
    public void I_Change_the_Problem_Status_to_Resolved_with_the_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemPage problemPage = new ProblemPage();
        problemData = GetProblemObject("Problem");
        problemData.initialize(data);
        problemPage.ResolveProblem(problemData);
    }

    @When("^I Change the Status to Closed with the details$")
    public void i_Change_the_Status_to_Closed_with_the_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemPage problemPage = new ProblemPage();
        problemData = GetProblemObject("Problem");
        problemData.initialize(data);
        problemPage.CloseProblem(problemData);
        }


    @Then("^all fields in the Problem record and Problem Task are ready only$")
    public void all_fields_in_the_Problem_record_and_Problem_Task_are_ready_only() {
        new ProblemPage().VerifyClosedReadonlyFields();
        ProblemTaskPage problemTaskPage = new ProblemTaskPage();
        problemTaskPage.Find_ProblemTask("ProblemTask");
        problemTaskPage.VerifyClosedReadonlyFields();
    }
//
//    @Then("^all fields in the Problem record and Problem Task 2 are ready only$")
//    public void all_fields_in_the_Problem_record_and_Problem_Task2_are_ready_only() {
//        new ProblemPage().VerifyClosedReadonlyFields();
//        ProblemTaskPage problemTaskPage = new ProblemTaskPage();
//        problemTaskPage.Find_ProblemTask("ProblemTask2");
//        problemTaskPage.VerifyClosedReadonlyFields();
//    }



    @Then("^all fields in the Problem record and Problem Task (\\d+) are ready only$")
    public void all_fields_in_the_Problem_record_and_Problem_Task2_are_ready_only(int taskNo) {
        new ProblemPage().VerifyClosedReadonlyFields();
        ProblemTaskPage problemTaskPage = new ProblemTaskPage();
        problemTaskPage.Find_ProblemTask("ProblemTask"+taskNo);
        problemTaskPage.VerifyClosedReadonlyFields();
    }

    @Then("^the Problem Record state is Closed$")
    public void the_Problem_Record_state_is_Closed() {
        Find_Problem("Problem");
        new ProblemPage().verifyProblemStatus("Closed");
    }

    @Then("^the Problem Task state is (.*)")
    public void the_Problem_Task_state_is_Closed(String status) {
        ProblemTaskPage problemTaskPage = new ProblemTaskPage();
        problemTaskPage.Find_ProblemTask("ProblemTask");
        problemTaskPage.verifyProblemTaskStatus(status);
    }
//
//
//    @Then("^the Problem Task 2 state is (.*)")
//    public void the_Problem_Task2_state_is_Closed(String status) {
//        ProblemTaskPage problemTaskPage = new ProblemTaskPage();
//        problemTaskPage.Find_ProblemTask("ProblemTask2");
//        problemTaskPage.verifyProblemTaskStatus(status);
//    }


    @Then("^the Problem Task (\\d+) state is (.*)")
    public void the_Problem_Task2_state_is_Closed(int taskNo, String status) {
        ProblemTaskPage problemTaskPage = new ProblemTaskPage();
        problemTaskPage.Find_ProblemTask("ProblemTask"+taskNo);
        problemTaskPage.verifyProblemTaskStatus(status);
    }

    @When("^I Resolve the Task with details$")
    public void i_Resolve_the_Task_with_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemTaskPage taskPage = new ProblemTaskPage();
        problemData = GetProblemObject("Problem");
        problemData.taskData1.initialize(data);
        taskPage.ResolveTask(problemData.taskData1);
    }

    @When("^I Resolve the Task 2 with details$")
    public void i_Resolve_the_Task2_with_details(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        ProblemTaskPage taskPage = new ProblemTaskPage();
        problemData = GetProblemObject("Problem");
        problemData.taskData2.initialize(data);
        taskPage.ResolveTask(problemData.taskData2);
    }

}

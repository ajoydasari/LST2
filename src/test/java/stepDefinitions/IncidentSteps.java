package stepDefinitions;

import Utilities.Util;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataObjects.*;
import pageObjects.*;

import java.util.List;

public class IncidentSteps extends Util{


    private String incidentNo;
    private IncidentData incidentData;
    private IncidentData incident1Data;
    private IncidentData incident2Data;
    private IncidentData incident3Data;

    public IncidentSteps(){
        incident1Data = new IncidentData();
        incident2Data = new IncidentData();
        incident3Data = new IncidentData();
    }

    public IncidentData GetIncidentObject(String IncidentNumber)
    {
        switch (IncidentNumber) {
            case "Incident":
                incidentData = incident1Data;
                break;
            case "Incident2":
                incidentData = incident2Data;
                break;
            case "Incident3":
                incidentData = incident3Data;
                break;
            default:
                incidentData = incident1Data;
        }
        return  incidentData;
    }


    private void NewIncident(String IncidentNumber, List<List<String>> data)
    {
        new HomePage().SelectAllAppsTab();

        LHSNavigationPage favPage = new LHSNavigationPage();
        favPage.CreateNewIncident();

        IncidentPage incidentPage = new IncidentPage();
        incidentData = GetIncidentObject(IncidentNumber);
        incidentData.initialize(data);
        incidentNo = incidentPage.NewIncident(incidentData);

        SaveData(IncidentNumber,incidentNo);
    }

    @When("^I Create a new Incident with details$")
    public void i_Create_a_new_Incident_with_details(DataTable dataTable){
        List<List<String>> data = dataTable.raw();
        NewIncident("Incident",data);
    }

    @When("^I Create a new Incident1 with details$")
    public void i_Create_a_new_Incident1_with_details(DataTable dataTable){
        List<List<String>> data = dataTable.raw();
        NewIncident("Incident1",data);
    }

    @When("^I Create a new Incident2 with details$")
    public void i_Create_a_new_Incident2_with_details(DataTable dataTable){
        List<List<String>> data = dataTable.raw();
        NewIncident("Incident2",data);
    }

    @When("^I Create a new Incident3 with details$")
    public void i_Create_a_new_Incident3_with_details(DataTable dataTable){
        List<List<String>> data = dataTable.raw();
        NewIncident("Incident3",data);
    }

//    @When("^I Create a new (.*) with details$")
//    public void i_Create_a_new_Incident_with_details(String IncidentNumber, DataTable dataTable){
//        List<List<String>> data = dataTable.raw();
//
//        new HomePage().SelectAllAppsTab();
//
//        LHSNavigationPage favPage = new LHSNavigationPage();
//        favPage.CreateNewIncident();
//
//        IncidentPage incidentPage = new IncidentPage();
//        incidentData = GetIncidentObject(IncidentNumber);
//        incidentData.initialize(data);
//        incidentNo = incidentPage.NewIncident(incidentData);
//
//        SaveData(IncidentNumber,incidentNo);
//    }


    @When("^I Create a new (.*) with details without Saving$")
    public void i_Create_a_new_Incident_with_details_without_Saving(String IncidentNumber, DataTable dataTable){
        List<List<String>> data = dataTable.raw();

        new HomePage().SelectAllAppsTab();

        LHSNavigationPage favPage = new LHSNavigationPage();
        favPage.CreateNewIncident();

        IncidentPage incidentPage = new IncidentPage();
        incidentData = GetIncidentObject(IncidentNumber);
        incidentData.initialize(data);
        incidentNo = incidentPage.CompleteNewIncidentDetails(incidentData);

        SaveData(IncidentNumber,incidentNo);
    }


    @Then("^Service SLA has been added to the Incident and status changed to 'In Progress'$")
    public void service_SLA_has_been_added_to_the_Incident_and_status_changed_to_In_Progress() {
        new IncidentPage().SLACreatedAsInProgress();
    }

    @Then("^New Incident notification Email has been sent to the requester")
    public void incident_notification_Email_has_been_sent_to_the_requester() {

        WaitForEmailsToBeSent();

        HomePage homePage = new HomePage();
        homePage.Impersonate_User(GblEmailsUser);

        incidentNo = RetrieveData("Incident");
        Find_Email(FormatEmailReceiver(incident1Data.Requester), "New Incident Raised", incidentNo);
    }

    @When("^I Select (.*) from My Assignment Groups Open Incidents link$")
    public void i_Select_Incident_from_My_Assignment_Groups_Open_Incidents_link(String IncidentNumber){
        new HomePage().SelectAllAppsTab();
        new LHSNavigationPage().setFilter("My Assignment Groups Open Incidents");
        new LHSNavigationPage().MyAssignmentGroupOpenIncidents();
//        new IncidentsListPage().WaitForPageLoad();
        incidentNo = RetrieveData(IncidentNumber);
        new IncidentsListPage().selectIncident(incidentNo);
//        new IncidentPage().WaitForIncidentStateEditable();
    }

    @When("^I Select the (.*) from My Owning Groups Open Incidents link$")
    public void I_Select_The_Incident_from_My_Owning_Groups_Open_Incidents_link(String IncidentNumber) {
        new HomePage().SelectAllAppsTab();
        new LHSNavigationPage().setFilter("My Owning Groups Open Incidents");
        new LHSNavigationPage().MyOwningGroupOpenIncidents();
        incidentNo = RetrieveData(IncidentNumber);
        new IncidentsListPage().selectIncident(incidentNo);
    }


    @When("^I select the Incident created earlier$")
    public void I_select_the_Incident_created_earlier() {
        incidentNo = RetrieveData("Incident");
        new IncidentsListPage().selectIncident(incidentNo);
    }

    @When("^I Reject the Incident with notes$")
    public void i_Reject_the_Incident_with_notes_Incident_Rejected(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        incident1Data.initialize(data);

        IncidentPage incidentPage = new IncidentPage();
        incidentPage.RejectIncident(incident1Data.WorkNotes);
    }

    @Then("^(.*) Status changed to (.*)$")
    public void incident_status_changed(String IncidentNumber, String status) {
        new IncidentPage().verifyIncidentStatus(status);
    }

    @Then("^Assignment Group is Removed$")
    public void assignment_Group_is_Removed(){
        new IncidentPage().verifyAssignemntGroupRemoved();
    }

    @Then("^Incident no longer appears in My Assignment Groups Open Incidents$")
    public void incident_no_longer_appears_in_my_assignment_groups(){
        new LHSNavigationPage().setFilter("My Assignment Groups Open Incidents");
        new LHSNavigationPage().MyAssignmentGroupOpenIncidents();
        incidentNo = RetrieveData("Incident");
        new IncidentsListPage().incidenNotExists(incidentNo);
    }

    @When("^I Assign Group with WorkNotes and Save$")
    public void I_Assign_Group_with_WorkNotes(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        incident1Data.initialize(data);
        IncidentPage incidentPage = new IncidentPage();
        incidentPage.Select_AssignmentGroup(incident1Data);
    }


    @When("^I Resolve the (.*) with Resolution Details$")
    public void i_Resolve_the_Incident_with_Resolution_Details(String IncidentNumber, DataTable dataTable){
        List<List<String>> data = dataTable.raw();
        incidentData = GetIncidentObject(IncidentNumber);
        incidentData.initialize(data);
        new IncidentPage().ResolveIncident(incidentData);
    }

    @Then("^Resolution Service Classification displayed correctly for (.*)")
    public void resolution_Service_Classification_displayed_correctly(String IncidentNumber){
        incidentData = GetIncidentObject(IncidentNumber);
        new IncidentPage().verifyServiceClassfication(incidentData);
    }


    private void Find_Email(String requester, String subject, String bodyText)
    {
        LHSNavigationPage navPage = new LHSNavigationPage();
        EmailsPage emails = new EmailsPage();
        navPage.openEmails();
        emails.Email_Exists(requester, subject, bodyText);
    }


    @Then("^(.*) Resolution Email has been sent to the requester$")
    public void incident_Resolution_Email_has_been_sent_to_the_requester(String IncidentNumber){

        WaitForEmailsToBeSent();

        HomePage homePage = new HomePage();
        homePage.Impersonate_User(GblEmailsUser);

        incidentNo = RetrieveData(IncidentNumber);
        incidentData = GetIncidentObject(IncidentNumber);
        Find_Email(FormatEmailReceiver(incidentData.Requester), "Incident Resolved", incidentNo);
    }

    @Then("^(.*) Closure Email has been sent to the requester$")
    public void incident_Closure_Email_has_been_sent_to_the_requester(String IncidentNumber)
    {
        WaitForEmailsToBeSent();
        HomePage homePage = new HomePage();
        homePage.Impersonate_User(GblEmailsUser);

        incidentNo = RetrieveData(IncidentNumber);
        incidentData = GetIncidentObject(IncidentNumber);
        Find_Email(FormatEmailReceiver(incidentData.Requester), "Incident Closure", incidentNo);
    }

    public void Find_Incident(String IncidentNumber){
        incidentNo = RetrieveData(IncidentNumber);
        new HomePage().GlobalSearch(incidentNo);
        WaitForPageRefresh();
    }

    @When("^I Search and Open the Incident$")
    public void i_Search_and_Open_the_Incident(){
        WaitForPageRefresh();
        Find_Incident("Incident");
    }

    @When("^I Search and Open the Incident1$")
    public void i_Search_and_Open_the_Incident1(){
        Find_Incident("Incident1");
    }

    @When("^I Search and Open the Incident2$")
    public void i_Search_and_Open_the_Incident2(){
        Find_Incident("Incident2");
    }

    @When("^I Search and Open the Incident3$")
    public void i_Search_and_Open_the_Incident3(){
        Find_Incident("Incident3");
    }

    @When("^I Call Customer with notes for the (.*)")
    public void i_Call_Customer_with_notes(String IncidentNumber, DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        incidentData = GetIncidentObject(IncidentNumber);
        incidentData.initialize(data);
        incidentNo = RetrieveData("Incident");
        new HomePage().GlobalSearch(incidentNo);
        new IncidentPage().CallCustomer(incidentData.WorkNotes);
    }

    @Then("^Incident Closure Details displayed correctly for (.*)$")
    public void incident_Closure_Details_displayed_correctly(String IncidentNumber, DataTable dataTable){
        List<List<String>> data = dataTable.raw();
        incidentData = GetIncidentObject(IncidentNumber);
        incidentData.initialize(data);
        new IncidentPage().verifyClosureDetails(incidentData);
    }

    // ******  Incident 2 Steps ****** //

    @When("^I Click Edit on the Child Incidents Tab$")
    public void i_Click_Edit_on_the_Child_Incidents_Tab(){
        new IncidentPage().EditChildIncident();
    }

    @When("^I Add (.*) as a Child Incident$")
    public void i_Add_Incident_as_a_Child_Incident(String IncidentNumber){
        incidentNo = RetrieveData(IncidentNumber);
        new EditMembersPage().AddChild(incidentNo);
    }

    @Then("^(.*) is Added as a Child Incident$")
    public void incident_is_Added_as_a_Child_Incident(String IncidentNumber){
        incidentNo = RetrieveData(IncidentNumber);
        new IncidentPage().verifyChildAdded(incidentNo);
    }

    @When("^I Change the Incident Status to (.*)$")
    public void i_Change_the_Incident_Status_to(String status){
        new IncidentPage().ChangeIncidentStatus(status);
    }

    @When("^I Change the Incident1 Status to (.*)$")
    public void i_Change_the_Incident1_Status_to(String IncidentNumber, String status){
        new IncidentPage().ChangeIncidentStatus(status);
    }

    @When("^I Change the Incident2 Status to (.*)$")
    public void i_Change_the_Incident2_Status_to(String IncidentNumber, String status){
        new IncidentPage().ChangeIncidentStatus(status);
    }

    @When("^I Change the Incident3 Status to (.*)$")
    public void i_Change_the_Incident3_Status_to(String IncidentNumber, String status){
        new IncidentPage().ChangeIncidentStatus(status);
    }

    @When("^I Close the (.*) with details$")
    public void I_Close_the_Incident3_with_details(String IncidentNumber, DataTable dataTable){
        List<List<String>> data = dataTable.raw();
        incidentData = GetIncidentObject(IncidentNumber);
        incidentData.initialize(data);

        new IncidentPage().CloseIncident(incidentData);
    }

    @Then("^Child (.*) contains Closure Details from (.*)")
    public void child_Incident_contains_Closure_Details_from_Incident(String ChildIncident, String ParentIncident){

            incidentNo = RetrieveData(ChildIncident);
            incidentData = GetIncidentObject(ParentIncident);
            new HomePage().GlobalSearch(incidentNo);
            new IncidentPage().verifyClosureDetails(incidentData);
    }


    // ******  Incident 2 Steps ****** //

    @When("^I Click on the First Time Fix button$")
    public void i_Click_on_the_First_Time_Fix_button(){
        new IncidentPage().FirstTimeFix();
//        WaitForPageRefresh();
    }


    @Then("^Closure code populated popup displayed$")
    public void closure_code_populated_popup_displayed() {
        AssertAlertText("Closure code has been pre populated for first time fix.");
    }

    @Then("^Closure Code has been automatically populated$")
    public void closure_Code_has_been_automatically_populated(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        incidentData = GetIncidentObject("Incident");
        incidentData.initialize(data);
        new IncidentPage().verifyClosureCode(incidentData.ClosureCode);
    }

    @When("^I Complete the Closure Notes$")
    public void i_Complete_the_Closure_Notes(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        incidentData = GetIncidentObject("Incident");
        incidentData.initialize(data);
        new IncidentPage().CompleteClosureNotes(incidentData);
    }



    @Then("^Closure Notes have been prompted as a mandatory field$")
    public void closure_Notes_have_been_prompted_as_a_mandatory_field(){
        AssertAlertText("Closure notes are mandatory to confirm first time fix.");
    }



    @When("^I Validate user can view Work notes$")
    public void i_Validate_user_can_view_Work_notes()  {
        new IncidentPage().verifyWorkNotesVisible();
    }

    @When("^I Validate user can view Customer Work notes$")
    public void i_Validate_user_can_view_Customer_Work_notes()  {
        new IncidentPage().verifyCustomerNotesVisible();
    }

    @When("^I Populate the Customer Work notes and Save$")
    public void i_Populate_the_Customer_Work_notes_and_Save(DataTable dataTable)  {
        List<List<String>> data = dataTable.raw();
        incidentData = GetIncidentObject("Incident");
        incidentData.initialize(data);
        new IncidentPage().AddCustomerWorkNoteswithSave(incidentData);
    }

    @When("^I Validate user cannot view Work notes$")
    public void i_Validate_user_cannot_view_Work_notes()  {
        new IncidentPage().verifyWorkNotesNotVisible();
    }

    @When("^I Validate user cannot view Customer Work notes$")
    public void i_Validate_user_cannot_view_Customer_Work_notes()  {
        new IncidentPage().verifyCustomerNotesNotVisible();
    }
    
}


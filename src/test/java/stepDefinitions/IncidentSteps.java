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
    IncidentData incidentData;
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


    @When("^I Create a new (.*) with details$")
    public void i_Create_a_new_Incident_with_details(String IncidentNumber, DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();

        new HomePage().SelectAllAppsTab();

        LHSNavigationPage favPage = new LHSNavigationPage();
        favPage.CreateNewIncident();

        IncidentPage incidentPage = new IncidentPage();
        incidentData = GetIncidentObject(IncidentNumber);
        incidentData.initialize(data);
        incidentNo = incidentPage.NewIncident(incidentData);

        SaveData(IncidentNumber,incidentNo);
    }



    @Then("^Service SLA has been added to the Incident and status changed to 'In Progress'$")
    public void service_SLA_has_been_added_to_the_Incident_and_status_changed_to_In_Progress() {
        new IncidentPage().SLACreatedAsInProgress();
    }

    private void WaitForEmailsToBeSent()
    {
        sleep(5);
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
    public void i_Select_Incident_from_My_Assignment_Groups_Open_Incidents_link(String IncidentNumber) throws Throwable {
        new HomePage().SelectAllAppsTab();
        new LHSNavigationPage().MyAssignmentGroupOpenIncidents();
        new IncidentsListPage().WaitForPageLoad();
        incidentNo = RetrieveData(IncidentNumber);
        new IncidentsListPage().selectIncident(incidentNo);
    }

    @When("^I Select the (.*) from My Owning Groups Open Incidents link$")
    public void I_Select_The_Incident_from_My_Owning_Groups_Open_Incidents_link(String IncidentNumber) {
        new HomePage().SelectAllAppsTab();
        new LHSNavigationPage().MyOwningGroupOpenIncidents();
        incidentNo = RetrieveData(IncidentNumber);
        new IncidentsListPage().selectIncident(incidentNo);
    }

    @When("^I Select Incident from My Owning Groups Resolved Incidents link$")
    public void I_Select_Incident_from_My_Owning_Groups_Resolved_Incidents_link() {
        new HomePage().SelectAllAppsTab();
        new LHSNavigationPage().MyOwningGroupOpenIncidents();
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
        //IncidentWorkNotes notes = new IncidentWorkNotes();
        incident1Data.initialize(data);

        IncidentPage incidentPage = new IncidentPage();
        incidentPage.RejectIncident(incident1Data.WorkNotes);
    }

    @Then("^Incident Status changed to (.*)$")
    public void incident_status_changed(String status) {
        new IncidentPage().verifyIncidentStatus(status);
    }

    @Then("^Assignment Group is Removed$")
    public void assignment_Group_is_Removed() throws Throwable {
        new IncidentPage().verifyAssignemntGroupRemoved();
    }

    @Then("^Incident no longer appears in My Assignment Groups Open Incidents$")
    public void incident_no_longer_appears_in_my_assignment_groups() throws Throwable {
        new LHSNavigationPage().MyAssignmentGroupOpenIncidents();
        incidentNo = RetrieveData("Incident");
        new IncidentsListPage().incidenNotExists(incidentNo);
    }

    @When("^I Assign Group with WorkNotes and Save$")
    public void I_Assign_Group_with_WorkNotes(DataTable dataTable)
    {
        List<List<String>> data = dataTable.raw();
        //
        // ResolverGroup group = new ResolverGroup();
        incident1Data.initialize(data);

        IncidentPage incidentPage = new IncidentPage();
        incidentPage.Select_AssignmentGroup(incident1Data);
    }

    @When("^I Change the Incident Status to (.*)$")
    public void i_Change_the_Incident_Status_to(String status) throws Throwable {
        new IncidentPage().ChangeIncidentStatus(status);
    }

    @When("^I Resolve the (.*) with Resolution Details$")
    public void i_Resolve_the_Incident_with_Resolution_Details(String IncidentNumber, DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        //ResolutionDetails resolution = new ResolutionDetails();
//        incident1Data.initialize(data);
//        new IncidentPage().ResolveIncident(incident1Data);
        incidentData = GetIncidentObject(IncidentNumber);
        incidentData.initialize(data);
        new IncidentPage().ResolveIncident(incidentData);
    }

    @Then("^Resolution Service Classification displayed correctly for (.*)")
    public void resolution_Service_Classification_displayed_correctly(String IncidentNumber) throws Throwable {
        //List<List<String>> data = dataTable.raw();
        //ResolutionServiceClassification classification = new ResolutionServiceClassification();
        //incident1Data.initialize(data);
        System.out.println("IncidentNumber='"+IncidentNumber+"'");
        incidentData = GetIncidentObject(IncidentNumber);
        new IncidentPage().verifyServiceClassfication(incidentData);
    }


    public void Find_Email(String requester, String subject, String bodyText)
    {
        LHSNavigationPage navPage = new LHSNavigationPage();
        EmailsPage emails = new EmailsPage();
        navPage.openEmails();
        emails.Email_Exists(requester, subject, bodyText);
    }

//    @Then("^Incident Resolution Email has been sent to the requester$")
//    public void incident_Resolution_Email_has_been_sent_to_the_requester(DataTable dataTable) throws Throwable {
//        List<List<String>> data = dataTable.raw();
//        //IncidentNotification notification = new IncidentNotification();
//        incident1Data.initialize(data);
//
//        WaitForEmailsToBeSent();
//
//        HomePage homePage = new HomePage();
//        homePage.Impersonate_User(GblEmailsUser);
//
//        incidentNo = RetrieveData("Incident");
//        Find_Email(FormatEmailReceiver(incident1Data.Requester), incident1Data.Subject, incidentNo);
//    }

    @Then("^(.*) Resolution Email has been sent to the requester$")
    public void incident_Resolution_Email_has_been_sent_to_the_requester(String IncidentNumber) throws Throwable {

        WaitForEmailsToBeSent();

        HomePage homePage = new HomePage();
        homePage.Impersonate_User(GblEmailsUser);

        incidentNo = RetrieveData(IncidentNumber);
        incidentData = GetIncidentObject(IncidentNumber);
        Find_Email(FormatEmailReceiver(incidentData.Requester), "Incident Resolved", incidentNo);
    }

    @Then("^Incident Closure Email has been sent to the requester$")
    public void incident_Closure_Email_has_been_sent_to_the_requester(DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        //IncidentNotification notification = new IncidentNotification();
        //notification.initialize(data);

        WaitForEmailsToBeSent();

        HomePage homePage = new HomePage();
        homePage.Impersonate_User(GblEmailsUser);

        incidentNo = RetrieveData("Incident");
        Find_Email(FormatEmailReceiver(incident1Data.Requester), "Incident Closure", incidentNo);
    }

    @When("^I Search and Open the (.*)$")
    public void i_Search_and_Open_the_Incident(String IncidentNumber) throws Throwable {
        incidentNo = RetrieveData(IncidentNumber);
        new HomePage().GlobalSearch(incidentNo);
    }

    @When("^I Call Customer with notes for the (.*)")
    public void i_Call_Customer_with_notes(String IncidentNumber, DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        //IncidentWorkNotes notes = new IncidentWorkNotes();
        incidentData = GetIncidentObject(IncidentNumber);
        incidentData.initialize(data);
        incidentNo = RetrieveData("Incident");
        new HomePage().GlobalSearch(incidentNo);
        new IncidentPage().CallCustomer(incidentData.WorkNotes);
    }

    @Then("^Incident Closure Details displayed correctly for (.*)$")
    public void incident_Closure_Details_displayed_correctly(String IncidentNumber, DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        incidentData = GetIncidentObject(IncidentNumber);
        //IncidentClosure closure = new IncidentClosure();
        incidentData.initialize(data);
        new IncidentPage().verifyClosureDetails(incidentData);
    }

    // ******  Incident 2 Steps ****** //

    @When("^I Click Edit on the Child Incidents Tab$")
    public void i_Click_Edit_on_the_Child_Incidents_Tab() throws Throwable {


    }

    @When("^I Add (.*) as a Child Incident$")
    public void i_Add_Incident_as_a_Child_Incident(String IncidentNumber) throws Throwable {


    }

    @Then("^(.*) is Added as a Child Incident$")
    public void incident_is_Added_as_a_Child_Incident(String IncidentNumber) throws Throwable {


    }

    @When("^I Save the Incident$")
    public void i_Save_the_Incident() throws Throwable {

    }

    @Then("^Incident1 and Incident2 displayed as Child Incidents of Incident3$")
    public void incidents_and_displayed_as_Child_Incidents_of_Incident() throws Throwable {


    }

    @Then("^Resolution Service Classification information is automaticlaly populated from (.*)$")
    public void resolution_Service_Classification_information_is_automaticlaly_populated_from_Incident(String IncidentNumber) throws Throwable {

    }

    @When("^I Change the (.*) Status to Closed$")
    public void i_Change_the_Incident_Status_to_Closed(String IncidentNumber) throws Throwable {



    }


    @Then("^Child (.*) contains Closure Details from Incident3$")
    public void child_Incident_contains_Closure_Details_from_Incident(String IncidentNumber, DataTable dataTable) throws Throwable {



    }
}


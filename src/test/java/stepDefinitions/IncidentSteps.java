package stepDefinitions;

import Utilities.Util;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.IncidentsListPage;
import pageObjects.LHSNavigationPage;
import pageObjects.IncidentPage;

public class IncidentSteps extends Util{

    private String incidentNo;

    @When("^I Create a new Incident with details (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void i_Create_a_new_Incident(String Requester, String CustomerRelated, String ITService, String Component, String Symptom, String TFSReference, String SupplierReference, String OwningGroup, String AssignmentGroup, String Impact, String Urgency, String ShortDescription, String Description) {
        LHSNavigationPage favPage = new LHSNavigationPage();
        favPage.CreateNewIncident();

        IncidentPage incidentPage = new IncidentPage();
        incidentNo = incidentPage.NewIncident(Requester, CustomerRelated, ITService, Component, Symptom, TFSReference, SupplierReference, OwningGroup, AssignmentGroup, Impact, Urgency, ShortDescription, Description);
        SaveData("IncidentNo",incidentNo);
    }

    @Then("^Service SLA has been added to the Incident and status changed to 'In Progress'$")
    public void service_SLA_has_been_added_to_the_Incident_and_status_changed_to_In_Progress() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Incident notification Email has been sent to the requester$")
    public void incident_notification_Email_has_been_sent_to_the_requester() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I Select Incident from My Assignment Groups Open Incidents link$")
    public void I_Select_Incident_from_My_Assignment_Groups_Open_Incidents_link() {
        new LHSNavigationPage().MyAssignmentGroupOpenIncidents();

    }

    @When("^I select the Incident created earlier$")
    public void I_select_the_Incident_created_earlier() {
        incidentNo = RetrieveData("IncidentNo");
        new IncidentsListPage().selectIncident(incidentNo);
    }

    @When("^I Reject the Incident with notes (.*)$")
    public void i_Reject_the_Incident_with_notes_Incident_Rejected(String notes)
    {
        IncidentPage incidentPage = new IncidentPage();
        incidentPage.RejectIncident(notes);
    }

    @Then("^Incident status changed to Rejected$")
    public void incident_status_changed_to_Rejected() {
        IncidentPage incidentPage = new IncidentPage();
        incidentPage.verifyIncidentRejected();
    }

}

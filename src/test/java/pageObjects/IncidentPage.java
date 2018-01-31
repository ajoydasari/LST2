package pageObjects;

import Utilities.Util;
import dataObjects.Incident;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IncidentPage extends Util {

    @FindBy(how = How.ID, using = "sys_readonly.incident.number")
    private WebElement incidentNumber;

    @FindBy(how = How.ID, using = "incident.state")
    private WebElement incidentState;

    @FindBy(how = How.ID, using = "incident.u_customer_related")
    private WebElement customerRelated;

    @FindBy(how = How.XPATH, using = ".//div[text()='This user is a Premium Service Centre (PSC) user. Please indicate whether this is a customer related incident.']")
    private WebElement PSCUserMSG;

    @FindBy(how = How.XPATH, using = ".//div[text()='This is a Premium Service Centre (PSC) user and this is a customer related incident.']")
    private WebElement PSC_and_customerRelatedMSG;

    @FindBy(how = How.ID, using = "sys_readonly.incident.opened_at")
    private WebElement openedAt;

    @FindBy(how = How.ID, using = "incident.opened_by_label")
    private WebElement openedBy;

    @FindBy(how = How.ID, using = "sys_display.incident.caller_id")
    private WebElement requester;

    @FindBy(how = How.ID, using = "sys_readonly.incident.number")
    private WebElement requesterReadOnly;

    @FindBy(how = How.ID, using = "sys_display.incident.location")
    private WebElement location;

    @FindBy(how = How.ID, using = "incident.caller_id.location_label")
    private WebElement locationReadOnly;

    @FindBy(how = How.ID, using = "incident.caller_id.u_reasonable_adjustment_needs")
    private WebElement assistiveTechnologyUser;

    @FindBy(how = How.ID, using = "sys_readonly.incident.caller_id.u_reasonable_adjustment_needs")
    private WebElement assistiveTechnologyUserReadOnly;

    @FindBy(how = How.ID, using = "sys_display.incident.u_service")
    private WebElement service;

    @FindBy(how = How.ID, using = "incident.u_service.u_security_context_label")
    private WebElement security_context;

    @FindBy(how = How.ID, using = "sys_display.incident.u_component")
    private WebElement component;

    @FindBy(how = How.ID, using = "lookup.incident.u_component")
    private WebElement componentlookup;

    @FindBy(how = How.ID, using = "sys_display.incident.u_subcat")
    private WebElement symptom;

    @FindBy(how = How.ID, using = "lookup.incident.u_subcat")
    private WebElement symptomlookup;

    @FindBy(how = How.ID, using = "incident.short_description")
    private WebElement short_description;

    @FindBy(how = How.ID, using = "incident.description")
    private WebElement description;

    @FindBy(how = How.ID, using = "lookup.incident.caller_id")
    private WebElement requesterLookup;

    @FindBy(how = How.ID, using = "incident.u_tfs_reference")
    private WebElement tfsReference;

    @FindBy(how = How.ID, using = "incident.u_supplier_reference")
    private WebElement supplierReference;

    @FindBy(how = How.ID, using = "sys_display.incident.u_owning_group")
    private WebElement owningGroup;

    @FindBy(how = How.ID, using = "sys_display.incident.assignment_group")
    private WebElement assignemntGroup;

    @FindBy(how = How.ID, using = "incident.impact")
    private WebElement impact;

    @FindBy(how = How.ID, using = "incident.urgency")
    private WebElement urgency;

    @FindBy(how = How.ID, using = "incident.priority")
    private WebElement priority;

    @FindBy(how = How.ID, using = "sysverb_update_and_stay_save")
    private WebElement Save;

    @FindBy(how = How.XPATH, using = ".//div[text()='New record']")
    private WebElement newRecord;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Notes']")
    private WebElement notesTab;

    @FindBy(how = How.ID, using = "activity-stream-work_notes-textarea")
    private WebElement WorkNotesTextArea;

    @FindBy(how = How.XPATH, using = ".//li[@class='active']/a[text()='Assigned']")
    private WebElement assignedActive;

    @FindBy(how = How.XPATH, using = ".//span[text()='The following mandatory fields are not filled in: Work notes']")
    private WebElement workNotesMandatory;

    @FindBy(how = How.XPATH, using = ".//span[text()='The following mandatory fields are not filled in: Symptom, Requester, Short description, Description, Component, IT Service, Current location']")
    private WebElement mandatoryFieldsMSG;

    @FindBy(how = How.XPATH, using = ".//li[@class='active']/a[text()='Rejected']")
    private WebElement rejectedActive;

    @FindBy(how = How.XPATH, using = ".//*[@id='incident.task_sla.task_table']//tr[@record_class='task_sla']")
    private WebElement IncidentSLA;

    @FindBy(how = How.XPATH, using = ".//*[@id='incident.task_sla.task_table']//tr[@record_class='task_sla']/td[4]")
    private WebElement IncidentSLAStatus;

    @FindBy(how = How.XPATH, using = ".//input[@id='ni.incident.u_major_incident']")
    private WebElement majorIncident;

    @FindBy(how = How.ID, using = ".//select[@id='incident.contact_type']")
    private WebElement source;

    @FindBy(how = How.ID, using = "sys_readonly.incident.contact_type")
    private WebElement sourceReadOnly;

    public IncidentPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String NewIncident(Incident incident)
    {
        UserSearchPage userspage = new UserSearchPage();

        SwitchToIFrame();

        WaitForElement(newRecord);
        AssertElementText(incidentState, "New");

        Readonly(incidentNumber);
        Readonly(openedAt);
        Readonly(openedBy);

        IsNotEmpty(incidentNumber);
        IsNotEmpty(openedAt);
        IsNotEmpty(openedBy);

        click(Save);
        IsDisplayed(mandatoryFieldsMSG);

        CaptureWindowHandles();

        requesterLookup.isDisplayed();
        requesterLookup.click();

        SwitchToNewWindow();
        userspage.SearchForUser(incident.Requester);

        SwitchToOldWindow();
        SwitchToIFrame();

        IsDisplayed(PSCUserMSG);

        selectValue(customerRelated,incident.CustomerRelated);
        IsDisplayed(PSC_and_customerRelatedMSG);
        IsNotEmpty(location);

        CommonPageObjects commonPage = new CommonPageObjects();

        //Capture how many Component options are available before selecting the IT Service
        CaptureWindowHandles();
        componentlookup.click();
        WaitForPageLoad();
        SwitchToNewWindow();

        String componentCount = commonPage.getResultsCount();
        Log("Component Options Count before selecting the IT Service: "+componentCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        //Capture how many Symptom options are available before selecting the IT Service and Component
        CaptureWindowHandles();
        symptomlookup.click();
        WaitForPageLoad();
        SwitchToNewWindow();
        String symptomCount = commonPage.getResultsCount();
        Log("Symptom Options Count before selecting the IT Service and Component: "+symptomCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        sendKeys_Select(service,incident.ITService);
        sleep(3);

        //Capture how many Component options are available after selecting the IT Service
        CaptureWindowHandles();
        componentlookup.click();
        WaitForPageLoad();
        SwitchToNewWindow();
        String newcomponentCount = commonPage.getResultsCount();
        Log("Component Options Count after selecting the IT Service: "+newcomponentCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        Assert.assertTrue(Integer.parseInt(newcomponentCount)<Integer.parseInt(componentCount),"Component Options are now reduced after selecting the IT Service");

        sendKeys_Select(component,incident.Component);
        sleep(3);

        //Capture how many Symptom options are available before selecting the IT Service and Component
        CaptureWindowHandles();
        symptomlookup.click();
        WaitForPageLoad();
        SwitchToNewWindow();
        String newsymptomCount = commonPage.getResultsCount();
        Log("Symptom Options Count after selecting the IT Service and Component: "+newsymptomCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        Assert.assertTrue(Integer.parseInt(newsymptomCount)<Integer.parseInt(symptomCount),"Symptom Options are now reduced after selecting the IT Service and Component");

        sendKeys_Select(symptom,incident.Symptom);

        AssertElementValue(security_context,"Open");
        Readonly(security_context);

        UnChecked(majorIncident);
        selectValue(source,"Phone");

        tfsReference.sendKeys(incident.TFSReference);
        supplierReference.sendKeys(incident.SupplierReference);

        sendKeys_Select(owningGroup,incident.OwningGroup);
        sendKeys_Select(assignemntGroup,incident.AssignmentGroup);

        selectValue(impact,incident.Impact);
        selectValue(urgency,incident.Urgency);
        AssertElementValue(priority, incident.Priority);

        short_description.sendKeys(incident.ShortDescription);
        description.sendKeys(incident.Description);

        click(Save);
        WaitForElement(assignedActive);
        String incidentNo = getValue(incidentNumber);

        AssertElementText(incidentState, "Assigned");

        IsDisplayed(requesterReadOnly);
        Readonly(locationReadOnly);
        IsDisplayed(assistiveTechnologyUserReadOnly);
        Readonly(security_context);
        IsDisplayed(sourceReadOnly);
        Readonly(priority);

        isElementPresent(IncidentSLA);
        AssertElementText(IncidentSLAStatus, "In progress");



        SwitchToDefault();

        return incidentNo;
    }


    public void RejectIncident(String WorkNotes) {

        SwitchToDefault();
        SwitchToIFrame();
        WaitForPageLoad();
        selectValue(incidentState,"Rejected");     //Rejected
        click(Save);

        IsDisplayed(workNotesMandatory);

        notesTab.click();
        WorkNotesTextArea.sendKeys(WorkNotes);
        click(Save);

        WaitForElement(rejectedActive);
        SwitchToDefault();
    }



    public void verifyIncidentRejected()
    {
        SwitchToDefault();
        SwitchToIFrame();
        AssertElementValue(incidentState, "8");
        SwitchToDefault();
    }

    private String getSecurityContextValue()
    {
        return driver.findElement(By.id("sys_display.incident.u_service.u_security_context")).getAttribute("value");
    }

}

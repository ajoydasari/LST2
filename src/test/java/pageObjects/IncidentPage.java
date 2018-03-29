package pageObjects;

import Utilities.Util;
import dataObjects.IncidentData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @FindBy(how = How.XPATH, using = ".//select[@id='incident.state']/option")
    private WebElement incidentStateOption;

    @FindBy(how = How.ID, using = "sys_readonly.incident.state")
    private WebElement readOnly_incidentState;

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

    @FindBy(how = How.ID, using = "first_time_fixinc")
    private WebElement FirstTimeFix;

    @FindBy(how = How.XPATH, using = ".//div[text()='New record']")
    private WebElement newRecord;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Main Details']")
    private WebElement mainDetailsTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Notes']")
    private WebElement notesTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Resolution Information']")
    private WebElement resolutionTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Closure']")
    private WebElement closureTab;

    @FindBy(how = How.ID, using = "activity-stream-work_notes-textarea")
    private WebElement WorkNotesTextArea;

    @FindBy(how = How.ID, using = "activity-stream-comments-textarea")
    private WebElement CustomerNotesTextArea;

    @FindBy(how = How.XPATH, using = ".//li[@class='active']/a[text()='Assigned']")
    private WebElement assignedActive;

    @FindBy(how = How.XPATH, using = ".//span[text()='The following mandatory fields are not filled in: Work notes']")
    private WebElement workNotesMandatory;

    @FindBy(how = How.XPATH, using = ".//span[text()='Work notes are required at the end of a customer call']")
    private WebElement workNotesMandatory_CallCustomer;

    @FindBy(how = How.XPATH, using = ".//span[text()='The following mandatory fields are not filled in: Symptom, Requester, Short description, Description, Component, IT Service, Current location']")
    private WebElement mandatoryFieldsMSG;

    @FindBy(how = How.XPATH, using = ".//li[@class='active']/a[text()='Rejected']")
    private WebElement rejectedActive;

    @FindBy(how = How.XPATH, using = ".//li[@class='active']/a[text()='Resolved']")
    private WebElement resolvedActive;

    @FindBy(how = How.XPATH, using = ".//*[@id='incident.task_sla.task_table']//tr[@record_class='task_sla']")
    private WebElement IncidentSLA;

    @FindBy(how = How.XPATH, using = ".//*[@id='incident.task_sla.task_table']//tr[@record_class='task_sla']/td[4]")
    private WebElement IncidentSLAStatus;

    @FindBy(how = How.XPATH, using = ".//input[@id='ni.incident.u_major_incident']")
    private WebElement majorIncident;

    @FindBy(how = How.XPATH, using = ".//*[@id='incident.contact_type']")
    private WebElement source;

    @FindBy(how = How.ID, using = "sys_readonly.incident.contact_type")
    private WebElement sourceReadOnly;

    @FindBy(how = How.ID, using = "incident.close_code")
    private WebElement resolutionCode;

    @FindBy(how = How.ID, using = "incident.close_notes")
    private WebElement resolutionNotes;

    @FindBy(how = How.ID, using = "sys_display.incident.u_resolution_it_service")
    private WebElement resolutionITService;

    @FindBy(how = How.ID, using = "sys_display.incident.u_resolution_component")
    private WebElement resolutionComponent;

    @FindBy(how = How.ID, using = "sys_display.incident.u_resolution_symptom")
    private WebElement resolutionSymptom;

    @FindBy(how = How.ID, using = "call_customer")
    private WebElement callCustomer;

    @FindBy(how = How.XPATH, using = ".//select[@id='sys_readonly.incident.u_closure_code']/option[@selected]")
    private WebElement closureCode_ReadOnly;

    @FindBy(how = How.XPATH, using = ".//select[@id='incident.u_closure_code']")
    private WebElement closureCode;

    @FindBy(how = How.ID, using = "sys_readonly.incident.u_closure_notes")
    private WebElement closureNotes_ReadOnly;

    @FindBy(how = How.ID, using = "incident.u_closure_notes")
    private WebElement closureNotes;

    @FindBy(how = How.XPATH, using = ".//*[@id='tabs2_list']//span[contains(text(),'Child')]")
    private WebElement childIncidentsTab;

    @FindBy(how = How.ID, using = "sysverb_edit_o2m")
    private WebElement editChildIncidents;


    public IncidentPage()
    {
        PageFactory.initElements(driver,this);
    }

    protected void WaitForPageLoad()
    {
        SwitchToDefaultIFrame();
        WaitForElement(incidentState);
        WaitForPageRefresh();
        SwitchToDefault();
    }

    public void WaitForIncidentStateEditable()
    {
        SwitchToDefaultIFrame();
        WaitForElement(incidentState);
        SwitchToDefault();
    }



    public String CompleteNewIncidentDetails(IncidentData incidentData) {

        String incidentNo;
        SwitchToDefaultIFrame();
        WaitForElementToBeClicable(incidentState);
        sleep(3);
        UserSearchPage userspage = new UserSearchPage();

        WaitForElement(newRecord);
        AssertElementText(incidentState, "New");

        Readonly(incidentNumber);
        Readonly(openedAt);
        Readonly(openedBy);

        IsNotEmpty(incidentNumber);
        IsNotEmpty(openedAt);
        IsNotEmpty(openedBy);
        click(Save);
        AssertDisplayed(mandatoryFieldsMSG);

        requesterLookup.isDisplayed();

        ClickToOpenNewWindow(requesterLookup);
        userspage.SearchForUser(incidentData.Requester);

        SwitchToOldWindow();
        SwitchToIFrame();

        if(incidentData.PSCUser.contains("yes"))
        {
            AssertDisplayed(PSCUserMSG);
            selectValue(customerRelated, incidentData.CustomerRelated);
            AssertDisplayed(PSC_and_customerRelatedMSG);
        }

        IsNotEmpty(location);

        CommonPageObjects commonPage = new CommonPageObjects();
        //Capture how many Component options are available before selecting the IT Service
        ClickToOpenNewWindow(componentlookup);

        String componentCount = commonPage.getResultsCount();
        Log("Component Options Count before selecting the IT Service: "+componentCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        //Capture how many Symptom options are available before selecting the IT Service and Component
        ClickToOpenNewWindow(symptomlookup);
        String symptomCount = commonPage.getResultsCount();
        Log("Symptom Options Count before selecting the IT Service and Component: "+symptomCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        sendKeys_Select(service, incidentData.ITService);

        //Capture how many Component options are available after selecting the IT Service
        ClickToOpenNewWindow(componentlookup);
        String newcomponentCount = commonPage.getResultsCount();
        Log("Component Options Count after selecting the IT Service: "+newcomponentCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        System.out.println(componentCount);
        System.out.println(newcomponentCount);
        Assert.assertTrue(Integer.parseInt(newcomponentCount)<Integer.parseInt(componentCount),"Component Options are now reduced after selecting the IT Service");

        sendKeys_Select(component, incidentData.Component);

        //Capture how many Symptom options are available before selecting the IT Service and Component
        ClickToOpenNewWindow(symptomlookup);
        String newsymptomCount = commonPage.getResultsCount();
        Log("Symptom Options Count after selecting the IT Service and Component: "+newsymptomCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        Assert.assertTrue(Integer.parseInt(newsymptomCount)<Integer.parseInt(symptomCount),"Symptom Options are now reduced after selecting the IT Service and Component");

        sendKeys_Select(symptom, incidentData.Symptom);

        AssertElementValue(security_context,"Open");
        Readonly(security_context);

        UnChecked(majorIncident);
        selectValue(source,"Phone");

        tfsReference.sendKeys(incidentData.TFSReference);
        supplierReference.sendKeys(incidentData.SupplierReference);

        sendKeys_Select(owningGroup, incidentData.OwningGroup);
        sendKeys_Select(assignemntGroup, incidentData.AssignmentGroup);

        selectValue(impact, incidentData.Impact);
        selectValue(urgency, incidentData.Urgency);
        AssertElementValue(priority, incidentData.Priority);

        short_description.sendKeys(incidentData.ShortDescription);
        description.sendKeys(incidentData.Description);

        incidentNo = getValue(incidentNumber);

        SwitchToDefault();

        return incidentNo;
    }



    public String NewIncident(IncidentData incidentData)
    {
        String incidentNo = CompleteNewIncidentDetails(incidentData);

        SwitchToIFrame();

        click(Save);
        WaitForPageRefresh();

        WaitForElement(assignedActive);

        AssertElementText(incidentState, "Assigned");

        AssertDisplayed(requesterReadOnly);
        Readonly(locationReadOnly);
        AssertDisplayed(assistiveTechnologyUserReadOnly);
        Readonly(security_context);
        AssertDisplayed(sourceReadOnly);
        Readonly(priority);

        SwitchToDefault();

        return incidentNo;
    }

    public void FirstTimeFix()
    {
        SwitchToIFrame();
        click_NoAssert(FirstTimeFix);
    }



    public void SLACreatedAsInProgress()
    {
        SwitchToDefaultIFrame();
        isElementPresent(IncidentSLA);
        AssertElementText(IncidentSLAStatus, "In progress");
        SwitchToDefault();
    }


    public void ChangeIncidentStatus(String status) {
        SwitchToDefaultIFrame();
        WaitForElementToBeClicable(incidentState);
        selectValue(incidentState,status);
        click(Save);
        WaitForPageRefresh();
        WaitForElementToBeClicable(incidentState);
        String incidentStatusValue = getIncidentStatusValue(status);
        WaitForElementValue(incidentState, incidentStatusValue);
    }


    public void CloseIncident(IncidentData incidentData) {
        SwitchToDefaultIFrame();
        WaitForElementToBeClicable(incidentState);
        selectValue(incidentState,"Closed");

        selectClosureTab();

        closureCode.sendKeys(incidentData.ClosureCode );
        closureNotes.sendKeys(incidentData.ClosureNotes);

        click(Save);

        SwitchToDefault();
        WaitForPageRefresh();
    }


    public void CompleteClosureNotes(IncidentData incidentData) {
        SwitchToDefaultIFrame();
        selectClosureTab();
        closureNotes.sendKeys(incidentData.ClosureNotes);
        SwitchToDefault();
    }

    public void RejectIncident(String WorkNotes) {

        SwitchToDefaultIFrame();
        WaitForElementToBeClicable(incidentState);
        selectValue(incidentState,"Rejected");     //Rejected
        click(Save);
        WaitForPageRefresh();
        AssertDisplayed(workNotesMandatory);
        AddWorkNotes(WorkNotes);
        click(Save);

        WaitForElement(rejectedActive);
        SwitchToDefault();
    }


    public void AddCustomerWorkNoteswithSave(IncidentData incidentData) {

        SwitchToDefault();
        SwitchToIFrame();

        AddCustomerWorkNotes(incidentData.CustomerWorkNotes);
        click(Save);
        WaitForPageRefresh();

        SwitchToDefault();
    }


    private void AddWorkNotes(String WorkNotes)
    {
        if(!(notesTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(notesTab);
        WorkNotesTextArea.sendKeys(WorkNotes);
    }

    private void AddCustomerWorkNotes(String WorkNotes)
    {
        if(!(notesTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(notesTab);
        CustomerNotesTextArea.sendKeys(WorkNotes);
    }



    public String getIncidentStatusValue(String status)
    {
        Log("Get Incident Status Value: '"+status+"'");
        SwitchToDefaultIFrame();

        switch (status) {
            case "Assigned":
                return "2";
            case "Rejected":
                return "8";
            case "Awaiting Approval":
                return "10";
            case "In Progress":
                return "22";
            case "Awaiting Info":
                return "23";
            case "Resolved":
                return "6";
            case "Closed":
                return "7";
        }
        SwitchToDefault();
        return "";
    }




    public void verifyIncidentStatus(String status)
    {
        Log("Verifying Incident Status : '"+status+"'");
        SwitchToDefault();
        SwitchToIFrame();

        switch (status) {
            case "Assigned":
                AssertElementValue(incidentState, "2");
                break;
            case "Rejected":
                AssertElementValue(incidentState, "8");
                break;
            case "Awaiting Approval":
                AssertElementValue(incidentState, "10");
                break;
            case "In Progress":
                AssertElementValue(incidentState, "22");
                break;
            case "Awaiting Info":
                AssertElementValue(incidentState, "23");
                break;
            case "Resolved":
                //AssertElementValue(readOnly_incidentState, "6");
                AssertElementValue(incidentState, "6");
                break;
            case "Closed":
                AssertElementValue(readOnly_incidentState, "7");
                break;
        }
        SwitchToDefault();
    }

    public void verifyAssignemntGroupRemoved()
    {
        SwitchToDefault();
        SwitchToIFrame();
        click(mainDetailsTab);
        IsEmpty(assignemntGroup);
        SwitchToDefault();
    }


    public void verifyWorkNotesVisible()
    {
        SwitchToDefault();
        SwitchToIFrame();
        if(!(notesTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(notesTab);
        AssertDisplayed(WorkNotesTextArea);
        SwitchToDefault();
    }


    public void verifyCustomerNotesVisible()
    {
        SwitchToDefault();
        SwitchToIFrame();
        if(!(notesTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(notesTab);
        AssertDisplayed(WorkNotesTextArea);
        SwitchToDefault();
    }



    public void verifyWorkNotesNotVisible()
    {
        SwitchToDefault();
        SwitchToIFrame();
        if(!(notesTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(notesTab);
        WaitForPageRefresh();
        AssertNotDisplayed(WorkNotesTextArea);
        SwitchToDefault();
    }


    public void verifyCustomerNotesNotVisible()
    {
        SwitchToDefault();
        SwitchToIFrame();
        if(!(notesTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(notesTab);
        WaitForPageRefresh();
        AssertNotDisplayed(WorkNotesTextArea);
        SwitchToDefault();
    }



    private String getSecurityContextValue()
    {
        return driver.findElement(By.id("sys_display.incident.u_service.u_security_context")).getAttribute("value");
    }

    public void Select_AssignmentGroup(IncidentData incidentData) {

        SwitchToDefaultIFrame();
        selectMainTab();
        WaitForElementToBeClicable(assignemntGroup);
        sendKeys_Select(assignemntGroup,incidentData.AssignmentGroup);
        AddWorkNotes(incidentData.WorkNotes);
        click(mainDetailsTab);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }

    public void ResolveIncident(IncidentData incidentData) {

        WaitForPageLoad();

        SwitchToDefault();
        SwitchToIFrame();

        WaitForElementToBeClicable(resolutionTab);
        click(resolutionTab);
        WaitForElement(resolutionCode);

        selectValue(incidentState,"Resolved");
        selectValue(resolutionCode, incidentData.ResolutionCode);
        resolutionNotes.sendKeys(incidentData.ResolutionNotes);
        click(Save);

        WaitForPageRefresh();

        WaitForElement(resolvedActive);
        SwitchToDefault();
    }

    public void verifyServiceClassfication(IncidentData incidentData)
    {
        SwitchToDefault();
        SwitchToIFrame();
        AssertElementValue(resolutionITService, incidentData.ITService );
        AssertElementValue(resolutionComponent, incidentData.Component );
        AssertElementValue(resolutionSymptom, incidentData.Symptom );
        SwitchToDefault();
    }

    public void CallCustomer(String WorkNotes) {
        WaitForPageLoad();
        SwitchToDefaultIFrame();
        click(callCustomer);
        AssertDisplayed(workNotesMandatory_CallCustomer);
        AddWorkNotes(WorkNotes);
        click(callCustomer);
        SwitchToDefault();
        new HomePage().WaitForPageLoad();

    }

    public void verifyClosureDetails(IncidentData incidentData)
    {
        SwitchToDefault();
        SwitchToIFrame();

        selectClosureTab();

        AssertElementValue(closureCode_ReadOnly, incidentData.ClosureCode );
        AssertElementValue(closureNotes_ReadOnly, incidentData.ClosureNotes);
        SwitchToDefault();
    }

    public void verifyClosureCode(String ClosureCode)
    {
        SwitchToDefault();
        SwitchToIFrame();

        selectClosureTab();

        AssertElementValue(closureCode, ClosureCode );
        SwitchToDefault();
    }


    private void selectMainTab()
    {
        if(!(mainDetailsTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            mainDetailsTab.click();
    }

    private void selectClosureTab()
    {
        if(!(closureTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            closureTab.click();
    }

    private void selectChildIncidentsTab()
    {
        if(!(childIncidentsTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            childIncidentsTab.click();
    }

    public void EditChildIncident()
    {
        SwitchToDefault();
        SwitchToIFrame();
        ScrollPage(incidentNumber,1);
        WaitForElement(childIncidentsTab);
        selectChildIncidentsTab();
        click(editChildIncidents);
        SwitchToDefault();
    }

    public void verifyChildAdded(String IncidentNumber)
    {
        SwitchToDefault();
        SwitchToIFrame();

        isElementPresent(ElementByXPath(".//a[text()='" + IncidentNumber + "']"));
        SwitchToDefault();
    }


}

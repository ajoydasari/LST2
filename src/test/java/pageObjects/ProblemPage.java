package pageObjects;

import Utilities.Util;
import dataObjects.ProblemData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ProblemPage extends Util {


    @FindBy(how = How.ID, using = "sys_readonly.problem.number")
    private WebElement problemNumber;

    @FindBy(how = How.ID, using = "problem.state")
    private WebElement problemState;
//
//    @FindBy(how = How.ID, using = "sys_readonly.problem.state")
//    private WebElement readOnly_problemState;
//
//    @FindBy(how = How.ID, using = "problem.u_customer_related")
//    private WebElement customerRelated;
//
//    @FindBy(how = How.XPATH, using = ".//div[text()='This user is a Premium Service Centre (PSC) user. Please indicate whether this is a customer related problem.']")
//    private WebElement PSCUserMSG;
//
//    @FindBy(how = How.XPATH, using = ".//div[text()='This is a Premium Service Centre (PSC) user and this is a customer related problem.']")
//    private WebElement PSC_and_customerRelatedMSG;

    @FindBy(how = How.ID, using = "sys_readonly.problem.opened_at")
    private WebElement openedAt;

    @FindBy(how = How.ID, using = "problem.opened_by_label")
    private WebElement openedBy;

    @FindBy(how = How.ID, using = "sys_display.problem.u_requester")
    private WebElement requester;
//
//    @FindBy(how = How.ID, using = "sys_readonly.problem.number")
//    private WebElement requesterReadOnly;
//
//    @FindBy(how = How.ID, using = "sys_display.problem.location")
//    private WebElement location;

//    @FindBy(how = How.ID, using = "problem.caller_id.location_label")
//    private WebElement locationReadOnly;

//    @FindBy(how = How.ID, using = "problem.caller_id.u_reasonable_adjustment_needs")
//    private WebElement assistiveTechnologyUser;

//    @FindBy(how = How.ID, using = "sys_readonly.problem.caller_id.u_reasonable_adjustment_needs")
//    private WebElement assistiveTechnologyUserReadOnly;
//
    @FindBy(how = How.ID, using = "sys_display.problem.u_service")
    private WebElement service;

    @FindBy(how = How.ID, using = "sys_display.problem.u_service.u_security_context")
    private WebElement security_context;

    @FindBy(how = How.ID, using = "sys_display.problem.u_component")
    private WebElement component;

    @FindBy(how = How.ID, using = "lookup.problem.u_component")
    private WebElement componentlookup;

    @FindBy(how = How.ID, using = "sys_display.problem.u_subcat")
    private WebElement symptom;

    @FindBy(how = How.ID, using = "lookup.problem.u_subcat")
    private WebElement symptomlookup;

    @FindBy(how = How.ID, using = "problem.u_problem_type")
    private WebElement problemType;

    @FindBy(how = How.ID, using = "problem.short_description")
    private WebElement problemTitle;

    @FindBy(how = How.ID, using = "problem.description")
    private WebElement problemStatement;

    @FindBy(how = How.ID, using = "problem.u_business_impact")
    private WebElement businessImpact;

    @FindBy(how = How.ID, using = "problem.work_around")
    private WebElement workAround;

    @FindBy(how = How.ID, using = "lookup.problem.u_requester")
    private WebElement requesterLookup;

    @FindBy(how = How.ID, using = "problem.u_tfs_reference")
    private WebElement tfsReference;

    @FindBy(how = How.ID, using = "problem.u_supplier_reference")
    private WebElement supplierReference;

    @FindBy(how = How.ID, using = "sys_display.problem.u_problem_owner")
    private WebElement owningGroup;

    @FindBy(how = How.ID, using = "sys_display.problem.assignment_group")
    private WebElement assignemntGroup;

    @FindBy(how = How.ID, using = "problem.impact")
    private WebElement impact;

    @FindBy(how = How.ID, using = "problem.urgency")
    private WebElement urgency;

    @FindBy(how = How.ID, using = "problem.priority")
    private WebElement priority;

    @FindBy(how = How.ID, using = "sysverb_update_and_stay_save")
    private WebElement Save;

    @FindBy(how = How.XPATH, using = ".//div[text()='New record']")
    private WebElement newRecord;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Main Details']")
    private WebElement mainDetailsTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Notes']")
    private WebElement notesTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Related Records']")
    private WebElement relatedRecordsTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Resolution Information']")
    private WebElement resolutionTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Closure']")
    private WebElement closureTab;

    @FindBy(how = How.ID, using = "problem.work_notes")
    private WebElement WorkNotesTextArea;
//
//    @FindBy(how = How.ID, using = "activity-stream-comments-textarea")
//    private WebElement CustomerNotesTextArea;

    @FindBy(how = How.ID, using = "sys_display.problem.rfc")
    private WebElement relatedChange;

    @FindBy(how = How.XPATH, using = ".//li[@class='active']/a[text()='Assigned']")
    private WebElement assignedActive;
//
//    @FindBy(how = How.XPATH, using = ".//span[text()='The following mandatory fields are not filled in: Work notes']")
//    private WebElement workNotesMandatory;
//
//    @FindBy(how = How.XPATH, using = ".//span[text()='Work notes are required at the end of a customer call']")
//    private WebElement workNotesMandatory_CallCustomer;
//
//    @FindBy(how = How.XPATH, using = ".//span[text()='The following mandatory fields are not filled in: Symptom, Requester, Short description, Description, Component, IT Service, Current location']")
//    private WebElement mandatoryFieldsMSG;

//    @FindBy(how = How.XPATH, using = ".//li[@class='active']/a[text()='Rejected']")
//    private WebElement rejectedActive;

    @FindBy(how = How.XPATH, using = ".//li[@class='active']/a[text()='Resolved']")
    private WebElement resolvedActive;

    @FindBy(how = How.XPATH, using = ".//*[@id='problem.task_sla.task_table']//tr[@record_class='task_sla']")
    private WebElement ProblemSLA;

    @FindBy(how = How.XPATH, using = ".//*[@id='problem.task_sla.task_table']//tr[@record_class='task_sla']/td[4]")
    private WebElement ProblemSLAStatus;

    @FindBy(how = How.XPATH, using = ".//input[@id='ni.problem.known_error']")
    private WebElement knownError;
//
//    @FindBy(how = How.XPATH, using = ".//*[@id='problem.contact_type']")
//    private WebElement source;
//
//    @FindBy(how = How.ID, using = "sys_readonly.problem.contact_type")
//    private WebElement sourceReadOnly;

    @FindBy(how = How.ID, using = "problem.u_resolution_code")
    private WebElement resolutionCode;

    @FindBy(how = How.ID, using = "problem.u_problem_resolution_details")
    private WebElement resolutionDetails;

    @FindBy(how = How.ID, using = "problem.u_root_cause_information")
    private WebElement rootCauseInformation;

    @FindBy(how = How.ID, using = "sys_display.problem.u_resolution_it_service")
    private WebElement resolutionITService;

    @FindBy(how = How.ID, using = "sys_display.problem.u_resolution_component")
    private WebElement resolutionComponent;

    @FindBy(how = How.ID, using = "sys_display.problem.u_resolution_symptom")
    private WebElement resolutionSymptom;

    @FindBy(how = How.ID, using = "sys_display.problem.u_resolution_configuration_item")
    private WebElement resolutionConfigItem;

//    @FindBy(how = How.ID, using = "call_customer")
//    private WebElement callCustomer;
//
    @FindBy(how = How.XPATH, using = ".//select[@id='problem.u_closure_code']/option[@selected]")
    private WebElement closureCode_ReadOnly;

    @FindBy(how = How.XPATH, using = ".//select[@id='problem.u_closure_code']")
    private WebElement closureCode;

    @FindBy(how = How.ID, using = "sys_readonly.problem.u_closure_notes")
    private WebElement closureNotes_ReadOnly;

    @FindBy(how = How.ID, using = "problem.u_closure_notes")
    private WebElement closureNotes;
//
//    @FindBy(how = How.XPATH, using = ".//*[@id='tabs2_list']//span[contains(text(),'Child')]")
//    private WebElement childProblemsTab;
//
//    @FindBy(how = How.ID, using = "sysverb_edit_o2m")
//    private WebElement editChildProblems;


    public ProblemPage() {
        PageFactory.initElements(driver, this);
    }

    protected void WaitForPageLoad() {
        SwitchToIFrame();
        WaitForElement(problemState);
        SwitchToDefault();
    }


    public String CompleteNewProblemDetails(ProblemData problemData) {

        String problemNo;
        SwitchToIFrame();

        UserSearchPage userspage = new UserSearchPage();

        WaitForElement(newRecord);
        AssertElementText(problemState, "New");

        Readonly(problemNumber);
        Readonly(openedAt);
        Readonly(openedBy);

        IsNotEmpty(problemNumber);
        IsNotEmpty(openedAt);
        IsNotEmpty(openedBy);

        click(Save);
//        AssertDisplayed(mandatoryFieldsMSG);

        CaptureWindowHandles();

        requesterLookup.isDisplayed();
        click(requesterLookup);

        SwitchToNewWindow();
        userspage.SearchForUser(problemData.Requester);

        SwitchToOldWindow();
        SwitchToIFrame();

//        if (problemData.PSCUser.contains("yes")) {
//            AssertDisplayed(PSCUserMSG);
//            selectValue(customerRelated, problemData.CustomerRelated);
//            AssertDisplayed(PSC_and_customerRelatedMSG);
//        }
//
//        IsNotEmpty(location);

        CommonPageObjects commonPage = new CommonPageObjects();

        //Capture how many Component options are available before selecting the IT Service
        CaptureWindowHandles();
        click(componentlookup);
        SwitchToNewWindow();

        String componentCount = commonPage.getResultsCount();
        Log("Component Options Count before selecting the IT Service: " + componentCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        //Capture how many Symptom options are available before selecting the IT Service and Component
        CaptureWindowHandles();
        click(symptomlookup);
        SwitchToNewWindow();
        String symptomCount = commonPage.getResultsCount();
        Log("Symptom Options Count before selecting the IT Service and Component: " + symptomCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        sendKeys_Select(service, problemData.ITService);
        //sleep(3);

        //Capture how many Component options are available after selecting the IT Service
        CaptureWindowHandles();
        click(componentlookup);
        //WaitForPageLoad();
        SwitchToNewWindow();
        String newcomponentCount = commonPage.getResultsCount();
        Log("Component Options Count after selecting the IT Service: " + newcomponentCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        System.out.println(componentCount);
        System.out.println(newcomponentCount);
        Assert.assertTrue(Integer.parseInt(newcomponentCount) < Integer.parseInt(componentCount), "Component Options are now reduced after selecting the IT Service");

        sendKeys_Select(component, problemData.Component);

        //Capture how many Symptom options are available before selecting the IT Service and Component
        CaptureWindowHandles();
        click(symptomlookup);
        SwitchToNewWindow();
        String newsymptomCount = commonPage.getResultsCount();
        Log("Symptom Options Count after selecting the IT Service and Component: " + newsymptomCount);
        CloseNewWindow();
        SwitchToOldWindow();
        SwitchToIFrame();

        Assert.assertTrue(Integer.parseInt(newsymptomCount) < Integer.parseInt(symptomCount), "Symptom Options are now reduced after selecting the IT Service and Component");

        sendKeys_Select(symptom, problemData.Symptom);

        AssertElementValue(security_context, "Open");
        Readonly(security_context);

        UnChecked(knownError);
//        selectValue(source, "Phone");

        tfsReference.sendKeys(problemData.TFSReference);
        supplierReference.sendKeys(problemData.SupplierReference);

        sendKeys_Select(owningGroup, problemData.OwningGroup);
        sendKeys_Select(assignemntGroup, problemData.AssignmentGroup);

        selectValue(impact, problemData.Impact);
        selectValue(urgency, problemData.Urgency);
        AssertElementValue(priority, problemData.Priority);

//        short_description.sendKeys(problemData.ShortDescription);
//        description.sendKeys(problemData.Description);

        problemNo = getValue(problemNumber);

        SwitchToDefault();

        return problemNo;
    }


    public String NewProblem(ProblemData problemData) {
        String problemNo = CompleteNewProblemDetails(problemData);

        SwitchToIFrame();

        click(Save);
        WaitForPageRefresh();

        WaitForElement(assignedActive);

        AssertElementText(problemState, "Assigned");

//        AssertDisplayed(requesterReadOnly);
//        Readonly(locationReadOnly);
//        AssertDisplayed(assistiveTechnologyUserReadOnly);
//        Readonly(security_context);
//        AssertDisplayed(sourceReadOnly);
//        Readonly(priority);

        SwitchToDefault();

        return problemNo;
    }

}

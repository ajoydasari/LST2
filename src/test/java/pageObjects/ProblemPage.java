package pageObjects;

import Utilities.Util;
import dataObjects.ProblemData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;


public class ProblemPage extends Util {

    @FindBy(how = How.ID, using = "sys_readonly.problem.number")
    private WebElement problemNumber;

    @FindBy(how = How.ID, using = "problem.state")
    private WebElement problemState;

    @FindBy(how = How.ID, using = "sys_readonly.problem.state")
    private WebElement problemState_Readonly;

    @FindBy(how = How.ID, using = "sys_readonly.problem.opened_at")
    private WebElement openedAt;

    @FindBy(how = How.ID, using = "problem.opened_by_label")
    private WebElement openedBy;

    @FindBy(how = How.ID, using = "sys_display.problem.u_requester")
    private WebElement requester;

    @FindBy(how = How.ID, using = "problem.u_requester_label")
    private WebElement requester_Readonly;

    @FindBy(how = How.ID, using = "sys_display.problem.u_service")
    private WebElement service;

    @FindBy(how = How.ID, using = "problem.u_service_label")
    private WebElement service_Readonly;

    @FindBy(how = How.XPATH, using = ".//*[@id='sys_display.problem.u_service.u_security_context']")
    private WebElement security_context;

    @FindBy(how = How.ID, using = "sys_display.problem.u_component")
    private WebElement component;

    @FindBy(how = How.ID, using = "problem.u_component_label")
    private WebElement component_Readonly;

    @FindBy(how = How.ID, using = "lookup.problem.u_component")
    private WebElement componentlookup;

    @FindBy(how = How.ID, using = "sys_display.problem.u_subcat")
    private WebElement symptom;

    @FindBy(how = How.ID, using = "problem.u_subcat_label")
    private WebElement symptom_Readonly;

    @FindBy(how = How.ID, using = "lookup.problem.u_subcat")
    private WebElement symptomlookup;

    @FindBy(how = How.ID, using = "problem.u_problem_type")
    private WebElement problemType;

    @FindBy(how = How.ID, using = "problem.short_description")
    private WebElement problemTitle;

    @FindBy(how = How.ID, using = "problem.description")
    private WebElement problemStatement;

    @FindBy(how = How.ID, using = "sys_readonly.problem.description")
    private WebElement problemStatement_Readonly;

    @FindBy(how = How.ID, using = "problem.u_business_impact")
    private WebElement businessImpact;

    @FindBy(how = How.ID, using = "sys_readonly.problem.u_business_impact")
    private WebElement businessImpact_Readonly;

    @FindBy(how = How.ID, using = "problem.work_around")
    private WebElement workAround;

    @FindBy(how = How.ID, using = "sys_readonly.problem.work_around")
    private WebElement workAround_Readonly;

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
    private WebElement workNotes;


    @FindBy(how = How.ID, using = "activity-stream-work_notes-textarea")
    private WebElement WorkNotesTextArea;

    @FindBy(how = How.ID, using = "sys_display.problem.rfc")
    private WebElement relatedChange;

    @FindBy(how = How.XPATH, using = ".//li[@class='active']/a[text()='Assigned']")
    private WebElement assignedActive;

    @FindBy(how = How.XPATH, using = ".//span[text()='The following mandatory fields are not filled in: Requestor, Symptom, Business Impact, Problem Type, Owning group, Problem Title, Problem Statement, Component, IT Service']")
    private WebElement mandatoryFieldsMSG;

    @FindBy(how = How.XPATH, using = ".//li[@class='active']/a[text()='Resolved']")
    private WebElement resolvedActive;

    @FindBy(how = How.XPATH, using = ".//*[@id='problem.task_sla.task_table']//tr[@record_class='task_sla']")
    private WebElement ProblemSLA;

    @FindBy(how = How.XPATH, using = ".//*[@id='problem.task_sla.task_table']//tr[@record_class='task_sla']/td[4]")
    private WebElement ProblemSLAStatus;

    @FindBy(how = How.XPATH, using = ".//input[@id='ni.problem.known_error']")
    private WebElement knownError;

    @FindBy(how = How.ID, using = "problem.u_resolution_code")
    private WebElement resolutionCode;

    @FindBy(how = How.ID, using = "sys_readonly.problem.u_resolution_code")
    private WebElement resolutionCode_Readonly;

    @FindBy(how = How.ID, using = "problem.u_problem_resolution_details")
    private WebElement resolutionDetails;

    @FindBy(how = How.ID, using = "sys_readonly.problem.u_problem_resolution_details")
    private WebElement resolutionDetails_Readonly;

    @FindBy(how = How.ID, using = "problem.u_sol_deploy")
    private WebElement solutionDeploymentDetails;

    @FindBy(how = How.ID, using = "problem.u_root_cause_information")
    private WebElement rootCauseInformation;

    @FindBy(how = How.ID, using = "sys_readonly.problem.u_root_cause_information")
    private WebElement rootCauseInformation_Readonly;

    @FindBy(how = How.ID, using = "sys_display.problem.u_resolution_it_service")
    private WebElement resolutionITService;

    @FindBy(how = How.ID, using = "sys_display.problem.u_resolution_component")
    private WebElement resolutionComponent;

    @FindBy(how = How.ID, using = "sys_display.problem.u_resolution_symptom")
    private WebElement resolutionSymptom;

    @FindBy(how = How.ID, using = "sys_display.problem.u_resolution_configuration_item")
    private WebElement resolutionConfigItem;

    @FindBy(how = How.XPATH, using = ".//select[@id='problem.u_closure_code']/option[@selected]")
    private WebElement closureCode_ReadOnly;

    @FindBy(how = How.XPATH, using = ".//select[@id='problem.u_closure_code']")
    private WebElement closureCode;

    @FindBy(how = How.ID, using = "sys_readonly.problem.u_closure_code")
    private WebElement closureCode_Readonly;

    @FindBy(how = How.ID, using = "sys_readonly.problem.u_closure_notes")
    private WebElement closureNotes_ReadOnly;

    @FindBy(how = How.ID, using = "problem.u_closure_notes")
    private WebElement closureNotes;

    @FindBy(how = How.XPATH, using = ".//*[@id='tabs2_list']//span[contains(text(),'Tasks')]")
    private WebElement problemTasksTab;

    @FindBy(how = How.ID, using = "sysverb_new")
    private WebElement newTask;


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

        sleep(2);   // To avoid No Data Found page being displayed as Selenium is too quick

        click(Save);
        AssertDisplayed(mandatoryFieldsMSG);

        CaptureWindowHandles();

        requesterLookup.isDisplayed();
        click(requesterLookup);

        SwitchToNewWindow();
        userspage.SearchForUser(problemData.Requester);

        SwitchToOldWindow();
        SwitchToIFrame();

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
        //Readonly(security_context);

        UnChecked(knownError);

        tfsReference.sendKeys(problemData.TFSReference);
        supplierReference.sendKeys(problemData.SupplierReference);

        sendKeys_Select(owningGroup, problemData.OwningGroup);

        selectValue(impact, problemData.Impact);
        selectValue(urgency, problemData.Urgency);
        AssertElementValue(priority, problemData.Priority);

        selectValue(problemType, problemData.ProblemType);
        sendKeys(problemTitle, problemData.ProblemTitle);
        sendKeys(problemStatement, problemData.ProblemStatement);
        sendKeys(businessImpact, problemData.BusinessImpact);

        click(notesTab);
        sendKeys(workNotes,problemData.WorkNotes);
        click(mainDetailsTab);

        problemNo = getValue(problemNumber);

        SwitchToDefault();

        return problemNo;
    }


    public String NewProblem(ProblemData problemData) {
        String problemNo = CompleteNewProblemDetails(problemData);

        SwitchToDefaultIFrame();
        click(Save);
        WaitForPageRefresh();

        AssertElementText(problemState, "New");
        problemData.Opened = getValue(openedAt);

        SwitchToDefault();

        return problemNo;
    }


    public void VerifyAssignmentReadOnlyFields()
    {
        SwitchToDefaultIFrame();
        Readonly(requester_Readonly);
        IsEditable(service);
        IsEditable(component);
        IsEditable(symptom);
        IsEditable(problemType);
        IsEditable(impact);
        IsEditable(urgency);
        IsEditable(problemTitle);
        IsEditable(problemStatement);
        IsEditable(businessImpact);

        click(notesTab);
        IsEditable(WorkNotesTextArea);
        click(relatedRecordsTab);
        Readonly(relatedChange);
        click(resolutionTab);
        Readonly(resolutionCode_Readonly);
        click(closureTab);
        Readonly(closureNotes_ReadOnly);

        click(mainDetailsTab);
        SwitchToDefault();
    }



    public void VerifyInProgressReadOnlyFields()
    {
        SwitchToDefaultIFrame();
        if(!(mainDetailsTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(mainDetailsTab);
        Readonly(requester_Readonly);
        IsEditable(service);
        IsEditable(component);
        IsEditable(symptom);
        IsEditable(problemType);
        IsEditable(impact);
        IsEditable(urgency);
        IsEditable(problemTitle);
        IsEditable(problemStatement);
        IsEditable(businessImpact);

        click(notesTab);
        IsEditable(WorkNotesTextArea);
        click(relatedRecordsTab);
        Readonly(relatedChange);

        click(resolutionTab);
        IsEditable(resolutionCode);
        IsEditable(rootCauseInformation);
        IsEditable(resolutionDetails);
        IsEditable(resolutionITService);
        IsEditable(resolutionComponent);
        IsEditable(resolutionSymptom);
        IsEditable(resolutionConfigItem);

        click(closureTab);
        IsEditable(closureCode);
        IsEditable(closureNotes);

        click(mainDetailsTab);

        UnChecked(knownError);

        SwitchToDefault();
    }


    public void ValidateKnownErrorField()
    {
        SwitchToDefaultIFrame();
        UnChecked(knownError);
        ChangeProblemStatusWithoutSave("Known Error");
        SwitchToIFrame();
        Checked(knownError);
        ChangeProblemStatusWithoutSave("In Progress");
        SwitchToIFrame();
        UnChecked(knownError);
        SwitchToDefault();
    }

    public void VerifyKnownErrorTicked()
    {
        SwitchToDefaultIFrame();
        Checked(knownError);
        SwitchToDefault();
    }


    public void ChangeProblemStatus(String status) {
        SwitchToDefaultIFrame();
        WaitForElementToBeClicable(problemState);
        selectValue(problemState,status);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void ChangeProblemStatusWithoutSave(String status) {
        SwitchToDefaultIFrame();
        WaitForElementToBeClicable(problemState);
        selectValue(problemState, status);
        SwitchToDefault();
    }

    public void ChangeAssignmentGroup(String group) {
        SwitchToDefaultIFrame();
        WaitForElementToBeClicable(assignemntGroup);
        sendKeys_Select(assignemntGroup,group);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }

    public void CompleteWorkAround(String workaround) {
        SwitchToDefaultIFrame();
        WaitForElement(workAround);
        sendKeys(workAround, workaround);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }

    public void CompleteRootCause(String rootcause) {
        SwitchToDefaultIFrame();
        if(!(resolutionTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(resolutionTab);
        WaitForElement(rootCauseInformation);
        sendKeys(rootCauseInformation, rootcause);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }

    public void CreateNewTask()
    {
        SwitchToDefaultIFrame();
        if(!(problemTasksTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(problemTasksTab);
        click(newTask);
        WaitForPageRefresh();
        SwitchToDefault();
    }

    public void AwaitingImplementation(ProblemData problemData){
        ChangeProblemStatus("Awaiting Implementation");
        SwitchToDefaultIFrame();
        if(!(resolutionTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(resolutionTab);
        selectValue(solutionDeploymentDetails, problemData.SolutionDeploymentDetails);
        sendKeys(rootCauseInformation, problemData.RootcauseInfo);
        sendKeys(resolutionDetails,problemData.ResolutionDetails);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }

    public void ResolveProblem(ProblemData problemData){
        ChangeProblemStatus("Resolved");
        SwitchToDefaultIFrame();
        if(!(resolutionTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(resolutionTab);
        selectValue(resolutionCode, problemData.ResolutionCode);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void CloseProblem(ProblemData problemData){
        ChangeProblemStatus("Closed");
        SwitchToDefaultIFrame();
        if(!(closureTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(closureTab);
        selectValue(closureCode, problemData.ClosureCode);
        sendKeys(closureNotes,problemData.ClosureNotes);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }



    public void VerifyClosedReadonlyFields()
    {
        SwitchToDefaultIFrame();
        click(mainDetailsTab);
        Readonly(requester_Readonly);
        Readonly(service_Readonly);
        Readonly(component_Readonly);
        Readonly(symptom_Readonly);
        Readonly(problemStatement_Readonly);
        Readonly(businessImpact_Readonly);
        Readonly(workAround_Readonly);

        click(notesTab);

        click(resolutionTab);
        Readonly(rootCauseInformation_Readonly);
        Readonly(resolutionDetails_Readonly);

        click(closureTab);
        Readonly(closureCode_Readonly);
        Readonly(closureNotes_ReadOnly);

        SwitchToDefault();
    }

    public void verifyProblemStatus(String status)
    {
        Log("Verifying Problem Status : '"+status+"'");
        SwitchToDefaultIFrame();

        switch (status) {
            case "Closed":
                AssertElementValue(problemState_Readonly, "13");
                break;
        }
        SwitchToDefault();
    }


}

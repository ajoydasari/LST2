package pageObjects;

import Utilities.Util;
import dataObjects.ChangeData;
import dataObjects.IncidentData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ChangePage extends Util {

    @FindBy(how = How.XPATH, using = ".//h2/div[text()='Change Request']")
    private WebElement newRecord;

    @FindBy(how = How.ID, using = "sys_readonly.change_request.number")
    private WebElement changeNumber;

    @FindBy(how = How.ID, using = "sys_display.change_request.requested_by")
    private WebElement requestor;

    @FindBy(how = How.ID, using = "lookup.change_request.requested_by")
    private WebElement requestorLookup;

    @FindBy(how = How.ID, using = "sys_display.change_request.u_service")
    private WebElement service;

    @FindBy(how = How.ID, using = "sys_display.change_request.u_component")
    private WebElement component;

    @FindBy(how = How.ID, using = "sys_display.change_request.cmdb_ci")
    private WebElement configItem;

    @FindBy(how = How.ID, using = "change_request.u_manual_asset")
    private WebElement assetID;

    @FindBy(how = How.ID, using = "change_request.urgency")
    private WebElement urgency;

    @FindBy(how = How.XPATH, using = ".//*[@id='change_request.urgency']/option")
    private WebElement urgencyOption;

    @FindBy(how = How.ID, using = "label.ni.change_request.u_nominate_for_standard_change")
    private WebElement standardChange;

    @FindBy(how = How.ID, using = "lookup.change_request.u_template")
    private WebElement changeModel;

    @FindBy(how = How.ID, using = "change_request.short_description")
    private WebElement changeTitle;

    @FindBy(how = How.ID, using = "change_request.type")
    private WebElement changeType;

    @FindBy(how = How.XPATH, using = ".//select[contains(@id,'change_request.state')]")
    private WebElement changeState;

    @FindBy(how = How.ID, using = "change_request.contact_type")
    private WebElement source;

    @FindBy(how = How.ID, using = "change_request.u_tfs_reference")
    private WebElement tfsReference;

    @FindBy(how = How.ID, using = "change_request.u_supplier_reference")
    private WebElement supplierReference;

    @FindBy(how = How.ID, using = "sys_display.change_request.assignment_group")
    private WebElement assignmentGroup;

    @FindBy(how = How.ID, using = "sys_display.change_request.assigned_to")
    private WebElement assignedTo;

    @FindBy(how = How.ID, using = "change_request.u_date_email_received")
    private WebElement dateEmailReceived;

    @FindBy(how = How.ID, using = "change_request.description")
    private WebElement description;

    @FindBy(how = How.ID, using = "change_request.u_reason_for_change")
    private WebElement reasonForChange;

    @FindBy(how = How.ID, using = "change_request.u_unknown_ci")
    private WebElement offToolCIs;

    @FindBy(how = How.ID, using = "change_request.u_change_benefits")
    private WebElement changeBenefits;

    @FindBy(how = How.ID, using = "change_request.u_revoke_reason")
    private WebElement revokeReason;

    @FindBy(how = How.ID, using = "change_request.u_impact_of_not_undertaking_the_change")
    private WebElement impactOfNoChange;

    @FindBy(how = How.ID, using = "change_request.u_change_classification")
    private WebElement changeClassification;

    @FindBy(how = How.ID, using = "sys_display.change_request.location")
    private WebElement location;

    @FindBy(how = How.ID, using = "change_request.comments")
    private WebElement customerNotes;

    @FindBy(how = How.ID, using = "change_request.work_notes")
    private WebElement workNotes;

    @FindBy(how = How.ID, using = "activity-stream-comments-textarea")
    private WebElement comments;

    @FindBy(how = How.XPATH, using = ".//div[@class='element date-calendar']//a[@id='change_request.start_date.ui_policy_sensitive']")
    private WebElement planStartDateTime;

    @FindBy(how = How.XPATH, using = ".//div[@class='element date-calendar']//a[@id='change_request.end_date.ui_policy_sensitive']")
    private WebElement planEndDateTime;

    @FindBy(how = How.ID, using = "change_request.u_expedite_reason")
    private WebElement justificationForExpedite;

    @FindBy(how = How.ID, using = "change_request.u_verification_steps")
    private WebElement postImplVerificationSteps;

    @FindBy(how = How.ID, using = "change_request.u_implementaion_attached")
    private WebElement implementationPlanAttached;

    @FindBy(how = How.ID, using = "change_request.implementation_plan")
    private WebElement implementationPlan;

    @FindBy(how = How.ID, using = "change_request.u_pre_implementation_attached")
    private WebElement testEvidenceAttached;

    @FindBy(how = How.ID, using = "change_request.u_backout_plan_attached")
    private WebElement backoutPlanAttached;

    @FindBy(how = How.ID, using = "sys_display.change_request.u_lead_implementation_supplier_ref")
    private WebElement implementationSupplier;

    @FindBy(how = How.ID, using = "change_request.u_verification_steps")
    private WebElement verificationSteps;

    @FindBy(how = How.ID, using = "sys_display.change_request.parent")
    private WebElement parent;

    @FindBy(how = How.ID, using = "sys_display.change_request.u_release")
    private WebElement release;

    @FindBy(how = How.ID, using = "ni.change_request.u_pir")
    private WebElement pir;

    @FindBy(how = How.ID, using = "change_request.u_pir_reason")
    private WebElement pirReason;

    @FindBy(how = How.ID, using = "change_request.u_closed_status")
    private WebElement closedStatus;

    @FindBy(how = How.ID, using = "change_request.u_pir_date.ui_policy_sensitive")
    private WebElement pirDate;

    @FindBy(how = How.ID, using = "change_request.close_notes")
    private WebElement closureNotes;

    @FindBy(how = How.ID, using = "ni.change_request.knowledge")
    private WebElement knowledge;

    @FindBy(how = How.ID, using = "sys_readonly.change_request.conflict_status")
    private WebElement conflictStatus_Readonly;

    @FindBy(how = How.ID, using = "label.ni.change_request.u_lead_time_conflict")
    private WebElement leadTimeConflict;

    @FindBy(how = How.ID, using = "ni.change_request.u_lock_assessments")
    private WebElement lockAssessments;

    @FindBy(how = How.ID, using = "sysverb_update_and_stay_save")
    private WebElement save;

    @FindBy(how = How.XPATH, using = ".//button[@id='complete_risk_impact'][contains(@style,'lightgreen')]")
    private WebElement completeRiskImpact;

    @FindBy(how = How.XPATH, using = ".//button[@id='submit_validate'][contains(@style,'lightgreen')]")
    private WebElement submitForValidation;

    @FindBy(how = How.ID, using = "assignToMe_change_request.assigned_to")
    private WebElement assignToMe;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Main Details']")
    private WebElement mainDetailsTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Notes']")
    private WebElement notesTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Planning']")
    private WebElement planningTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Related Records']")
    private WebElement relatedRecordsTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Assessors']")
    private WebElement assessorsTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Closure']")
    private WebElement closureTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Admin']")
    private WebElement adminTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'PIUs')]")
    private WebElement PIUsTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'Tasks')]")
    private WebElement changeTasksTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'Approvals')]")
    private WebElement approvalsTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'Approvals')][contains(text(),'(2)')]")
    private WebElement approvals2Tab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'Approvals')][contains(text(),'(3)')]")
    private WebElement approvals3Tab;

//    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'Approvals')][contains(text(),'(26)')]") - removed as this number changes per environment
    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'Approvals')]")
    private WebElement approvals26Tab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tabs2_tab tabs2_active']/span[contains(text(),'Approvals')]")
    private WebElement approvalsTabSelected;

    @FindBy(how = How.ID, using = "request.assessment")
    private WebElement requestAssessments;

    @FindBy(how = How.ID, using = "skip.assessment")
    private WebElement skipAssessments;

    @FindBy(how = How.XPATH, using = ".//select[@id='change_request.state']/option[@selected][contains(text(),'Awaiting Approval')]")
    private WebElement awaitingValidationState;

    @FindBy(how = How.XPATH, using = ".//table[@id='change_request.u_piu.u_parent_change_table']//td[3]/a[contains(@href,'piu')]")
    private WebElement PIURecord;

    @FindBy(how = How.XPATH, using = ".//table[@id='change_request.u_piu.u_parent_change_table']//tr[1]/td[5]")
    private WebElement firstPIURecStatus;

    @FindBy(how = How.XPATH, using = ".//tr[@record_class='change_task']//a[contains(text(),'CTASK')]")
    private WebElement firstChangeTask;

    @FindBy(how = How.XPATH, using = ".//tr[@record_class='change_task']/td[text()='Mandatory Fields']/..//a[contains(text(),'CTASK')]")
    private WebElement mandatoryFieldsTask;

    @FindBy(how = How.XPATH, using = ".//tr[@record_class='change_task']/td[text()='PIR']/..//a[contains(text(),'CTASK')]")
    private WebElement PIRTask;

    @FindBy(how = How.XPATH, using = ".//tr[@record_class='change_task']/td[text()='PIR']/..//td[text()='PIR Task Change unsuccessful']")
    private WebElement PIRTaskUnsuccessful;

    @FindBy(how = How.XPATH, using = ".//span[@id='change_request.sysapproval_approver.sysapproval_hide_search']//select")
    private WebElement ApprovalFilter;

    @FindBy(how = How.XPATH, using = ".//span[@id='change_request.sysapproval_approver.sysapproval_hide_search']//input")
    private WebElement ApprovalFilterInput;
//
//    @FindBy(how = How.XPATH, using = ".//span[@id='change_request.sysapproval_approver.sysapproval_hide_search']//input")
//    private WebElement RiskImpact;

    @FindBy(how = How.ID, using = "change_request.u_approval_groups_unlock")
    private WebElement internalAssessmentGroupsUnlock;

    @FindBy(how = How.ID, using = "change_request.u_assessment_groups_unlock")
    private WebElement externalAssessmentGroupsUnlock;

    @FindBy(how = How.ID, using = "sys_display.change_request.u_approval_groups")
    private WebElement approvalGroupsEdit;

    @FindBy(how = How.ID, using = "sys_display.change_request.u_assessment_groups")
    private WebElement assessmentGroupsEdit;

    @FindBy(how = How.ID, using = "change_request.u_approval_groups_lock")
    private WebElement approvalGroupsLock;

    @FindBy(how = How.XPATH, using = ".//select[@id='select_0change_request.u_approval_groups']/option[text()='Test AssignmentGroup1']")
    private WebElement assignmentGroup1;

    @FindBy(how = How.XPATH, using = ".//select[@id='select_0change_request.u_assessment_groups']/option[text()='Test AssignmentGroup2']")
    private WebElement assignmentGroup2;

    @FindBy(how = How.XPATH, using = ".//select[@id='select_0change_request.u_approval_groups']/option[text()='HOT Tooling Team']")
    private WebElement hotToolingTeam;

    @FindBy(how = How.ID, using = "remove.change_request.u_approval_groups")
    private WebElement removeApprovalGroup;


    @FindBy(how = How.ID, using = "change_request.u_assessment_groups_lock")
    private WebElement assessmentGroupsLock;


    public ChangePage() {
        PageFactory.initElements(driver, this);
    }

    public void WaitForPageLoad() {
        SwitchToDefaultIFrame();
        WaitForElement(urgencyOption);
        WaitForElementToBeClicable(urgencyOption);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void validateIsAt()
    {
        SwitchToDefaultIFrame();
        WaitForElement(changeTitle);
        ScrollPage(changeTitle,1);
        AssertDisplayed(approvalsTab);
        SwitchToDefault();
    }


    public void validateIsAt3()
    {
        SwitchToDefaultIFrame();
        WaitForElement(changeTitle);
        ScrollPage(changeTitle,1);
        AssertDisplayed(approvals3Tab);
        SwitchToDefault();
    }

    public void validateIsAt26()
    {
        SwitchToDefaultIFrame();
        WaitForElement(changeTitle);
        ScrollPage(changeTitle,1);
        AssertDisplayed(approvals26Tab);
        SwitchToDefault();
    }

    public String CompleteNewChangeDetails(ChangeData changeData) {

        String changeNo;
        SwitchToIFrame();

        changeNo = getValue(changeNumber);
        //sendKeys_Select(requestor, changeData.Requestor);
        sendKeys(requestor, changeData.Requestor);
        SelectFromLookup(requestorLookup, changeData.Requestor);
        sendKeys(changeTitle,changeData.ChangeTitle);
        if(!(changeData.ChangeType == null))
            selectValue(changeType,changeData.ChangeType);
        if(!(changeData.Template == null)) {
            SelectFromLookup(changeModel, changeData.Template);
            sleep(30);
        }
        SwitchToDefault();

        return changeNo;
    }


//    public void selectTemplate(String template)
//    {
//        SwitchToDefaultIFrame();
//        SelectFromLookup(requestorLookup, template);
//        SwitchToDefault();
//    }

    public String NewChange(ChangeData changeData) {
        String changeNo = CompleteNewChangeDetails(changeData);
        SwitchToDefaultIFrame();
        click(save);
        if(changeData.ChangeType.equals("Standard"))
            WaitForElement(submitForValidation);
        else
            WaitForElement(completeRiskImpact);
        SwitchToDefault();
        return changeNo;
    }

    public void NewChangeRecordDisplayed() {
        SwitchToDefaultIFrame();
        AssertDisplayed(newRecord);
        SwitchToDefault();
    }


    public void CompleteRiskImpact() {
        SwitchToDefaultIFrame();
        click(completeRiskImpact);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void SelectChangeModel() {
        SwitchToDefaultIFrame();
        ClickToOpenNewWindow(changeModel);
        WaitForPageRefresh();
//        SwitchToDefault();
    }



    public void VerifyChangeRecordLoaded(String changeNo) {
        SwitchToDefaultIFrame();
        AssertElementValue(changeNumber,changeNo);
        SwitchToDefault();
    }


    public void PopulateChangeDetails(ChangeData changeData) {

        SwitchToDefaultIFrame();

        selectTab(mainDetailsTab);
        sendKeys_Select(configItem, changeData.PrimaryConfigItem);
        sendKeys(description,changeData.Description);
        sendKeys(reasonForChange,changeData.ReasonForChange);

        selectTab(planningTab);
        click(planStartDateTime);
        new CommonPageObjects().selectCalendarDate(changeData.StartDateTime);
        click(planEndDateTime);
        new CommonPageObjects().selectCalendarDate(changeData.EndDateTime);

        ScrollPage(changeTitle,1);
        selectValue(implementationPlanAttached, changeData.ImplementationPlanAttached);
        sendKeys(implementationPlan,changeData.ImplementationPlan);
        selectValue(testEvidenceAttached, changeData.PreImplTestEvidenceAttached);
        selectValue(backoutPlanAttached, changeData.BackoutPlanAttached);
        SwitchToDefault();
    }



    public void PopulateEmergencyChangeDetails(ChangeData changeData) {

        SwitchToDefaultIFrame();
        selectTab(mainDetailsTab);
        sendKeys_Select(configItem, changeData.PrimaryConfigItem);
        selectValue(changeClassification, changeData.ChangeClassification);
        sendKeys(description,changeData.Description);
        sendKeys(reasonForChange,changeData.ReasonForChange);

        selectTab(planningTab);
        click(planStartDateTime);
        new CommonPageObjects().selectCalendarDate(changeData.StartDateTime);
        click(planEndDateTime);
        new CommonPageObjects().selectCalendarDate(changeData.EndDateTime);
        SwitchToDefault();
    }


    public void PopulateTest4ChangeDetails(ChangeData changeData) {

        SwitchToDefaultIFrame();
        selectTab(mainDetailsTab);
        sendKeys_Select(configItem, changeData.PrimaryConfigItem);
        selectValue(changeClassification, changeData.ChangeClassification);
        sendKeys(description,changeData.Description);
        sendKeys(reasonForChange,changeData.ReasonForChange);

        selectTab(planningTab);
        click(planStartDateTime);
        new CommonPageObjects().selectCalendarDate(changeData.StartDateTime);
        click(planEndDateTime);
        new CommonPageObjects().selectCalendarDate(changeData.EndDateTime);

        selectValue(implementationPlanAttached, changeData.ImplementationPlanAttached);
        sendKeys(implementationPlan,changeData.ImplementationPlan);
        selectValue(testEvidenceAttached, changeData.PreImplTestEvidenceAttached);
        selectValue(backoutPlanAttached, changeData.BackoutPlanAttached);
        sendKeys(postImplVerificationSteps, changeData.PostImplVerificationSteps);

        SwitchToDefault();
    }



    public void PopulateChangeInfo(ChangeData changeData) {

        SwitchToDefaultIFrame();
        selectTab(planningTab);
        ScrollPage(changeTitle,1);
        selectValue(implementationPlanAttached, changeData.ImplementationPlanAttached);
        sendKeys(implementationPlan,changeData.ImplementationPlan);
        selectValue(testEvidenceAttached, changeData.PreImplTestEvidenceAttached);
        selectValue(backoutPlanAttached, changeData.BackoutPlanAttached);
        sendKeys(postImplVerificationSteps, changeData.PostImplVerificationSteps);
        SwitchToDefault();
    }




    public void AddInternalAssessmentGroup(String groupName) {

        SwitchToDefaultIFrame();
        click(internalAssessmentGroupsUnlock);
        WaitForElement(approvalGroupsEdit);
        if(isElementPresent(hotToolingTeam))
        {
            click(hotToolingTeam);
            sleep(3);
            click(removeApprovalGroup);
            sleep(3);
        }
        sendKeysEnter(approvalGroupsEdit,groupName);
        WaitForElement(assignmentGroup1);
        click(approvalGroupsLock);
        SwitchToDefault();
    }



    public void AddExternalAssessmentGroup(String groupName) {

        SwitchToDefaultIFrame();
        click(externalAssessmentGroupsUnlock);
        WaitForElement(assessmentGroupsEdit);
        sendKeysEnter(assessmentGroupsEdit,groupName);
        WaitForElement(assignmentGroup2);
        click(assessmentGroupsLock);
        SwitchToDefault();
    }


    public void ClickSubmitForValidation() {
        SwitchToDefaultIFrame();
        click(submitForValidation);
        WaitForPageRefresh();
//        WaitForElement(approvalsTab);
        SwitchToDefault();
    }



    protected void WaitForSubmitForValidation() {
        SwitchToDefaultIFrame();
        WaitForElement(submitForValidation);
        SwitchToDefault();
    }



    public void WaitForRequestAssessments() {
        SwitchToDefaultIFrame();
        WaitForElement(requestAssessments);
        SwitchToDefault();
    }


    public void PopulateExpediteJustification(ChangeData changeData) {
        SwitchToDefaultIFrame();
        WaitForMessage("Complete the highlighted Mandatory Fields from the main form and/or planning tab.");
        selectTab(planningTab);
        ScrollPage(justificationForExpedite,1);
        sendKeys(justificationForExpedite,changeData.JustificationToExpedite);
        if(changeData.PostImplVerificationSteps != null)
            sendKeys(postImplVerificationSteps,changeData.PostImplVerificationSteps);
        SwitchToDefault();
    }


    public void VerifyChangeRecordStatus(String status) {
            Log("Verifying Change Status : '" + status + "'");
            SwitchToDefaultIFrame();

            switch (status) {
                case "Validation":
                    AssertElementValue(changeState, "9");
                    break;
                case "Awaiting Approval":
                    AssertElementValue(changeState, "10");
                    break;
                case "Awaiting Implementation":
                    AssertElementValue(changeState, "11");
                    break;
                case "Awaiting PIR":
                    AssertElementValue(changeState, "14");
                    break;
                case "Awaiting Closure":
                    AssertElementValue(changeState, "15");
                    break;
                case "Closed":
                    AssertElementValue(changeState, "3");
                    break;
                case "Cancelled":
                    AssertElementValue(changeState, "4");
                    break;
            }
            SwitchToDefault();
        }


    public void AssignToMe() {
        SwitchToDefaultIFrame();
        click(assignToMe);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void VerifyAssignedTo(String username) {
        SwitchToDefaultIFrame();
        AssertElementValue(assignedTo,username);
        SwitchToDefault();
    }


    public void VerifyAssignmentGroup(String group) {
        SwitchToDefaultIFrame();
        AssertElementValue(assignmentGroup,group);
        SwitchToDefault();
    }


    public void PopulateChangeClassification(ChangeData changeData) {
        SwitchToDefaultIFrame();
        selectTab(mainDetailsTab);
        selectValue(changeClassification, changeData.ChangeClassification);
        SwitchToDefault();
    }

    public void ClickRequestAssessments() {
        SwitchToDefaultIFrame();
        click(requestAssessments);
        //WaitForPageRefresh();
//        WaitForElement(approvals2Tab);   Removed as the number of approvals differ per environment
        WaitForElement(approvalsTab);
        SwitchToDefault();
    }


    public void ClickSkipAssessments() {
        SwitchToDefaultIFrame();
        click(skipAssessments);
        WaitForElement(awaitingValidationState);
        SwitchToDefault();
    }

    public void ValidatePIURecordCreated() {
        SwitchToDefaultIFrame();
        click(PIUsTab);
        isElementPresent(PIURecord);
        AssertElementText(firstPIURecStatus, "Open");
        SwitchToDefault();
    }


    public void ClickPIURecord() {
        SwitchToDefaultIFrame();
        click(PIURecord);
        SwitchToDefault();
    }

    public void addComments(String commentsText){
        selectTab(notesTab);
        sendKeys(comments,commentsText);
        click(save);
        WaitForPageRefresh();
    }

    public void editStartDate()
    {
        SwitchToDefaultIFrame();
        selectTab(planningTab);
        click(planStartDateTime);
        new CommonPageObjects().selectCalendarDate("NOW");
        SwitchToDefault();
    }


    public void editEndDate()
    {
        SwitchToDefaultIFrame();
        selectTab(planningTab);
        click(planEndDateTime);
        new CommonPageObjects().selectCalendarDate("NOW");
        SwitchToDefault();
    }

//
//    public void saveRecord()
//    {
//        SwitchToDefaultIFrame();
//        click(save);
//        WaitForPageLoad();
//        SwitchToDefault();
//    }


    public void selectChangeTasksTab()
    {
        SwitchToDefaultIFrame();
        WaitForPageRefresh();
        selectTab(changeTasksTab);
        SwitchToDefault();
    }

    public void selectApprovalsTab()
    {
        SwitchToDefaultIFrame();
        selectTab(approvalsTab);
        SwitchToDefault();
    }

    public void selectAssessorsTab()
    {
        SwitchToDefaultIFrame();
        selectTab(assessorsTab);
        SwitchToDefault();
    }


    public void selectFirstChangeTask()
    {
        SwitchToDefaultIFrame();
        WaitForElement(firstChangeTask);
        click(firstChangeTask);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void selectMandatoryFieldsTask()
    {
        SwitchToDefaultIFrame();
        WaitForElement(mandatoryFieldsTask);
        click(mandatoryFieldsTask);
        //WaitForPageRefresh();
        new ChangeTaskPage().WaitForPageLoad();
        SwitchToDefault();
    }


    public void selectPIRTask()
    {
        SwitchToDefaultIFrame();
        WaitForElement(PIRTask);
        click(PIRTask);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void validatePIRTaskUnsuccessful()
    {
        SwitchToDefaultIFrame();
        AssertDisplayed(PIRTaskUnsuccessful);
        SwitchToDefault();
    }


    public void selectApproval(String approver, String changeNo)
    {
        SwitchToDefaultIFrame();
//        WaitForElement(approvalsTabSelected);
        WaitForElement(ApprovalFilter);
        selectValue(ApprovalFilter,"Approver");
        sendKeysEnter(ApprovalFilterInput,approver);
        ClickElementByXPath(".//a[text()='" + approver + "']/../..//a[text()='Requested']");
        SwitchToDefault();
        new ApprovalPage().WaitForPageLoad(changeNo);
    }

}

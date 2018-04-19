package pageObjects;

import Utilities.Util;
import dataObjects.ProblemData;
import dataObjects.ProblemTaskData;
import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProblemTaskPage extends Util {

    @FindBy(how = How.XPATH, using = ".//div[text()='New record']")
    private WebElement newRecord;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class,'chevron-left')]")
    private WebElement backToProblem;

    @FindBy(how = How.ID, using = "sys_readonly.problem_task.number")
    private WebElement taskNumber;

    @FindBy(how = How.XPATH, using = ".//select[contains(@id,'problem_task.state')]")
    private WebElement taskStatus;

    @FindBy(how = How.ID, using = "sys_readonly.problem_task.state")
    private WebElement taskStatus_Readonly;

    @FindBy(how = How.XPATH, using = ".//select[@id='problem_task.u_type']/option[text()='Documentation']")
    private WebElement documentationType;

    @FindBy(how = How.ID, using = "sys_display.problem_task.assignment_group")
    private WebElement assignmentGroup;

    @FindBy(how = How.ID, using = "lookup.problem_task.assignment_group")
    private WebElement assignmentGroupLookup;

    @FindBy(how = How.ID, using = "sys_display.problem_task.u_owning_group")
    private WebElement owningGroup;

    @FindBy(how = How.ID, using = "sys_readonly.problem_task.opened_at")
    private WebElement openedAtDate;

    @FindBy(how = How.ID, using = "sys_readonly.problem_task.u_resolved_on")
    private WebElement resolvedDate;

    @FindBy(how = How.ID, using = "problem_task.u_due_date.ui_policy_sensitive")
    private WebElement dueDateLookup;

    @FindBy(how = How.ID, using = "sys_readonly.problem_task.u_due_date")
    private WebElement dueDate_Readonly;

    @FindBy(how = How.ID, using = "sys_readonly.problem_task.u_extension_count")
    private WebElement extensionCount;

    @FindBy(how = How.ID, using = "problem_task.short_description")
    private WebElement shortDescription;

    @FindBy(how = How.ID, using = "problem_task.u_task_description")
    private WebElement description;

    @FindBy(how = How.ID, using = "problem_task.work_notes")
    private WebElement workNotes;

    @FindBy(how = How.ID, using = "activity-stream-work_notes-textarea")
    private WebElement workNotesActivity;

    @FindBy(how = How.ID, using = "sys_readonly.problem_task.u_task_description")
    private WebElement description_Readonly;

    @FindBy(how = How.ID, using = "problem_task.u_resolution_details")
    private WebElement resolutionDetails;

    @FindBy(how = How.ID, using = "sys_readonly.problem_task.u_resolution_details")
    private WebElement resolutionDetails_Readonly;

    @FindBy(how = How.ID, using = "problem_task.priority")
    private WebElement priority;

    @FindBy(how = How.XPATH, using = ".//select[@id='problem_task.u_type']")
    private WebElement taskType;

    @FindBy(how = How.ID, using = "sysverb_update_and_stay_save")
    private WebElement Save;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Main Details']/..")
    private WebElement mainDetailsTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Notes']")
    private WebElement notesTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][text() = 'Resolution']")
    private WebElement resolutionTab;


    public ProblemTaskPage()
    {
        PageFactory.initElements(driver,this);
    }

    protected void WaitForPageLoad()
    {
//        PageLoadWait();
        SwitchToIFrame();
        WaitForElement(documentationType);
        SwitchToDefault();
    }

    public String CompleteTaskDetails(ProblemTaskData problemTaskData) {
        SelectMainDetailsTab();
        SwitchToIFrame();

        String taskNo = getValue(taskNumber);

        //sendKeys_Select(assignmentGroup, problemTaskData.AssignmentGroup);
        sendKeys(assignmentGroup, problemTaskData.AssignmentGroup);
        CaptureWindowHandles();
        click(assignmentGroupLookup);

        SwitchToNewWindow();
        ClickElementByXPath(".//a[text()='"+problemTaskData.AssignmentGroup+"']");
        SwitchToOldWindow();
        SwitchToIFrame();

        selectValue(taskType, problemTaskData.TaskType);
        sendKeys(description, problemTaskData.TaskDescription);
        selectValue(priority, problemTaskData.Priority);
        SelectResolutionTab();
        SwitchToIFrame();
        click(dueDateLookup);
        new CommonPageObjects().selectCalendarDate(problemTaskData.DueDate);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
        return taskNo;
    }


    public void VerifyShortDescriptionCopiedFromProblem(ProblemData problemData)
    {
        SwitchToDefaultIFrame();
        if(!(mainDetailsTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(mainDetailsTab);
        AssertElementValue(shortDescription, problemData.ProblemTitle);
        SwitchToDefault();
    }


    public void VerifyOwningGroupCopiedFromProblem(ProblemData problemData)
    {
        SwitchToDefaultIFrame();
        AssertElementValue(owningGroup, problemData.AssignmentGroup);
        SwitchToDefault();
    }


    public void VerifyOpenedAtFieldValue(ProblemData problemData) {
        SwitchToDefaultIFrame();

        try {

            String opened = getValue(openedAtDate);
            SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date taskDate = myDateFormat.parse(opened);
            Date problemDate = myDateFormat.parse(problemData.Opened);
            Date currentDateTime = new  Date();

            if(taskDate.after(problemDate) && taskDate.before(currentDateTime))
                Log("Task Date Time generated correctly - after Problem Date time");
            else
                Assert.fail("Task Date Time generated incorrectly");

        } catch (Exception e) {
            System.out.println("Exception occurred in VerifyOpenedAtFieldValue: " + e.getMessage());
        }
        SwitchToDefault();
    }


    public void SelectMainDetailsTab()
    {
        SwitchToDefaultIFrame();
        if(!(mainDetailsTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(mainDetailsTab);
        SwitchToDefault();
    }


    public void SelectResolutionTab()
    {
        SwitchToDefaultIFrame();
        if(!(resolutionTab.findElement(By.xpath("..")).getAttribute("className").contains("tabs2_active")))
            click(resolutionTab);
        SwitchToDefault();
    }


    public void VerifyExtensionCount(String count)
    {
        SwitchToDefaultIFrame();
        AssertElementValue(extensionCount,count);
        SwitchToDefault();
    }


    public void SetDueDateToTomorrow()
    {
        SwitchToDefaultIFrame();
        click(dueDateLookup);
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDateTime = new  Date();
        Date dateTomorrow = DateUtils.addDays(currentDateTime,1);
        new CommonPageObjects().selectCalendarDate(myDateFormat.format(dateTomorrow).toString());
        click(Save);
        SwitchToDefault();
        WaitForPageRefresh();
    }

    public void SetDueDateToMinus3Days()
    {
        SwitchToDefaultIFrame();
        click(dueDateLookup);
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDateTime = new  Date();
        Date dateTomorrow = DateUtils.addDays(currentDateTime,-3);
        new CommonPageObjects().selectCalendarDate(myDateFormat.format(dateTomorrow).toString());
        click(Save);
        SwitchToDefault();
        WaitForPageRefresh();
    }

    public void ChangeTaskStatus(String status) {
        SwitchToDefaultIFrame();
        WaitForElementToBeClickable(taskStatus);
        selectValue(taskStatus,status);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void ResolveTask(ProblemTaskData taskData) {
        SelectMainDetailsTab();
        ChangeTaskStatus("Resolved");
        SwitchToDefaultIFrame();
        sendKeys(resolutionDetails,taskData.ResolutionDetails);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void VerifyResolvedFieldValue(ProblemData problemData) {

        SwitchToDefaultIFrame();

        try {
            SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date openedDate = myDateFormat.parse(getValue(openedAtDate));
            Date reslvdDate = myDateFormat.parse(getValue(resolvedDate));
            Date currentDateTime = new  Date();

            if(reslvdDate.after(openedDate) && reslvdDate.before(currentDateTime))
                Log("Task Resolved Date Time generated correctly - after Task Opened Date time");
            else {
                Assert.fail("Task Resolved Date Time generated incorrectly");
                Log("openedDate="+openedDate);
                Log("reslvdDate="+reslvdDate);
                Log("currentDateTime="+currentDateTime);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred in VerifyResolvedFieldValue: " + e.getMessage());
        }
        SwitchToDefault();
    }

    public void NavigateBackToProblem(){
        SwitchToDefaultIFrame();
        click(backToProblem);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void VerifyClosedReadonlyFields()
    {
        SwitchToDefaultIFrame();

        click(resolutionTab);
        Readonly(dueDate_Readonly);

        click(mainDetailsTab);
        sleep(3);
        Readonly(taskStatus_Readonly);
        Readonly(description_Readonly);
        Readonly(resolutionDetails_Readonly);

        click(notesTab);

        SwitchToDefault();
    }


    public void Find_ProblemTask(String taskNumber)
    {
        String taskNo = RetrieveData(taskNumber);
        new HomePage().GlobalSearch(taskNo);
    }


    public void verifyProblemTaskStatus(String status)
    {
        Log("Verifying Problem Task Status : '"+status+"'");
        SwitchToDefaultIFrame();

        switch (status) {
            case "Rejected":
                AssertElementValue(taskStatus, "10");
                break;
            case "Closed":
                AssertElementValue(taskStatus_Readonly, "3");
                break;
        }
        SwitchToDefault();
    }


    public void CompleteWorkNotes(ProblemTaskData problemTaskData) {

        SwitchToIFrame();
        click(notesTab);
        sendKeys(workNotesActivity, problemTaskData.WorkNotes);
        click(Save);
        WaitForPageRefresh();
        SwitchToDefault();
    }
}

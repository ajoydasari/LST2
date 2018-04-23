package pageObjects;

import Utilities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RequestedItemPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h2//div[text()='Requested Item']")
    private WebElement requestHeader;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'Approvers')]")
    private WebElement approversTab;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'Catalog')]")
    private WebElement tasksTab;

    @FindBy(how = How.ID, using = "sc_req_item.estimated_delivery")
    private WebElement estimatedDelivery;

    @FindBy(how = How.ID, using = "sys_readonly.sc_req_item.estimated_delivery")
    private WebElement estimatedDelivery_Readonly;

    @FindBy(how = How.ID, using = "sys_readonly.sc_req_item.number")
    private WebElement requestItemNumber;

    @FindBy(how = How.XPATH, using = ".//*[text()='Implement']/..//a[contains(text(),'SCTASK')]")
    private WebElement requestTask;

    @FindBy(how = How.XPATH, using = ".//*[text()='ASYS access add - Implement']/..//a[contains(text(),'SCTASK')]")
    private WebElement asysRequestTask;

    @FindBy(how = How.XPATH, using = ".//*[text()='Update License']/..//a[contains(text(),'SCTASK')]")
    private WebElement updateLicenseTask;

    @FindBy(how = How.ID, using = "activity-stream-work_notes-textarea")
    private WebElement workNotes;

    @FindBy(how = How.ID, using = "activity-stream-comments-textarea")
    private WebElement customerNotes;

    @FindBy(how = How.ID, using = "sysverb_update_and_stay_save")
    private WebElement save;

    @FindBy(how = How.XPATH, using = ".//table[@id='sc_req_item.sc_task.request_item_table']/tbody/tr[1]")
    private WebElement taskSLA;

    public void WaitForPageLoad()
    {
        SwitchToDefaultIFrame();
        WaitForElement(requestHeader);
        SwitchToDefault();
    }

    public RequestedItemPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void selectApprovalItem(String approver)
    {
        SwitchToDefaultIFrame();
        ApprovalPage approvalPage = new ApprovalPage();
        ScrollPage(estimatedDelivery,3);
        selectTab(approversTab);
        ClickElementByXPath(".//a[contains(text(),'"+approver+"')]/../..//a[text()='Requested']");
        approvalPage.WaitForPageLoad();
        SwitchToDefault();
    }


    public void selectRequestMoreInfoItem()
    {
        SwitchToDefaultIFrame();
        ApprovalPage approvalPage = new ApprovalPage();
        ScrollPage(requestItemNumber,3);
        selectTab(approversTab);
        ClickElementByXPath(".//a[text()='Request More Info']");
        approvalPage.WaitForPageLoad();
        SwitchToDefault();
    }

    public String getRequestTaskNo()
    {
        String TaskNo="";
        SwitchToDefaultIFrame();
        selectTab(tasksTab);
        TaskNo= getText(requestTask);
        SwitchToDefault();

        return TaskNo;
    }


    public String getAsysRequestTaskNo()
    {
        String TaskNo="";
        SwitchToDefaultIFrame();
        ScrollPage(estimatedDelivery_Readonly,2);
        selectTab(tasksTab);
        TaskNo= getText(asysRequestTask);
        SwitchToDefault();

        return TaskNo;
    }


    public String getUpdateLicenseTaskNo()
    {
        String TaskNo="";
        SwitchToDefaultIFrame();
        selectTab(tasksTab);
        TaskNo= getText(updateLicenseTask);
        SwitchToDefault();

        return TaskNo;
    }


    public String getDeliveryDate()
    {
        String deliveryDate="";
        SwitchToDefaultIFrame();
        deliveryDate= getText(estimatedDelivery_Readonly);
        SwitchToDefault();

        return deliveryDate;
    }


    public void AddWorkNotes(String notes)
    {
        SwitchToDefaultIFrame();
//        ScrollPage(estimatedDelivery,1);
        ScrollPage(requestItemNumber,1);
        sendKeys(workNotes,notes);
        SwitchToDefault();
    }


    public void AddCustomerNotes(String notes)
    {
        SwitchToDefaultIFrame();
        sendKeys(customerNotes,notes);
        click(save);
        WaitForPageRefresh();
        SwitchToDefault();
    }



    public void verifyImplementTaskDisplayed(String taskNo)
    {
        SwitchToDefaultIFrame();
        ScrollPage(requestItemNumber,3);
        selectTab(tasksTab);
        AssertDisplayed(ElementByXPath(".//*[text()='Implement']/..//a[contains(text(),'"+taskNo+"')]"));
        SwitchToDefault();
    }


    public void verifyTaskSLA1Created()
    {
        SwitchToDefaultIFrame();
        ScrollPage(requestItemNumber,2);
        selectTab(tasksTab);
        AssertDisplayed(taskSLA);
        SwitchToDefault();
    }
}


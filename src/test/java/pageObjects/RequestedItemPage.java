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

    @FindBy(how = How.ID, using = "sys_readonly.sc_req_item.number")
    private WebElement requestItemNumber;

    @FindBy(how = How.XPATH, using = ".//*[text()='Implement']/..//a[contains(text(),'SCTASK')]")
    private WebElement requestTask;

    @FindBy(how = How.XPATH, using = ".//*[text()='Implement']/..//a[contains(text(),'SCTASK')]")
    private WebElement updateLicenseTask;

    @FindBy(how = How.ID, using = "activity-stream-work_notes-textarea")
    private WebElement workNotes;

    @FindBy(how = How.ID, using = "activity-stream-comments-textarea")
    private WebElement customerNotes;

    @FindBy(how = How.ID, using = "sysverb_update_and_stay_save")
    private WebElement save;

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

    public String getRequestTaskNo()
    {
        String TaskNo="";
        SwitchToDefaultIFrame();
        selectTab(tasksTab);
        TaskNo= getText(requestTask);
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



    public void AddWorkNotes(String notes)
    {
        SwitchToDefaultIFrame();
        ScrollPage(estimatedDelivery,1);
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
//        ScrollPage(requestItemNumber,3);
        ScrollPage(estimatedDelivery,4);
        selectTab(tasksTab);
        AssertDisplayed(ElementByXPath(".//*[text()='Implement']/..//a[contains(text(),'"+taskNo+"')]"));
        SwitchToDefault();
    }
}


package pageObjects;

import Utilities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApprovalPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h2//*[text()='Approval']")
    public WebElement approvalHeader;

    @FindBy(how = How.ID, using = "view.sysapproval_approver.document_id")
    public WebElement approvingInfo;

    @FindBy(how = How.ID, using = "change_approve")
    public WebElement approve;

    @FindBy(how = How.ID, using = "sys_readonly.change_request.number")
    public WebElement changeNumber_ReadOnly;

    @FindBy(how = How.ID, using = "activity-stream-comments-textarea")
    public WebElement comments;

    @FindBy(how = How.ID, using = "approve_review")
    public WebElement proposedDatesRejected;

    public boolean isAt()
    {
        return isElementPresent(approvalHeader);
    }

    public ApprovalPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void WaitForPageLoad(String changeNo)
    {
        SwitchToDefaultIFrame();
        WaitForElement(approvalHeader);
        WaitForElementValue(changeNumber_ReadOnly,changeNo);
        WaitForPageRefresh();
        SwitchToDefault();
    }

    public void selectApprovingInfo()
    {
        SwitchToDefaultIFrame();
        WaitForElement(approvalHeader);
        click(approvingInfo);
        new ChangePage().WaitForPageLoad();
        SwitchToDefault();
    }


    public void clickApprove()
    {
        SwitchToDefaultIFrame();
        click(approve);
        WaitForPageRefresh();
        SwitchToDefault();
        new ApprovalListPage().WaitForPageLoad();
    }


    public void ProposedDatesRejected(String commentsText)
    {
        SwitchToDefaultIFrame();
        sendKeys(comments, commentsText);
        click(proposedDatesRejected);
        WaitForPageRefresh();
        SwitchToDefault();
        new ApprovalListPage().WaitForPageLoad();
    }
}

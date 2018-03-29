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
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeTaskPage extends Util {

    @FindBy(how = How.XPATH, using = ".//div[text()='Change Task']")
    private WebElement changeTaskHeader;

    @FindBy(how = How.ID, using = "close_task")
    private WebElement closeTask;

    @FindBy(how = How.ID, using = "change_task.u_closed_status")
    private WebElement closedStatus;

    @FindBy(how = How.XPATH, using = ".//select[@id='sys_readonly.change_task.state']/option[@selected][contains(text(),'Closed Complete')]")
    private WebElement closedCompleteState;

    @FindBy(how = How.ID, using = ".//select[@id='change_task.change_request.u_pir_reason']")
    private WebElement PIRReason;

    @FindBy(how = How.XPATH, using = ".//select[@id='change_task.change_request.u_pir_reason']/option[@selected][contains(text(),'Emergency change')]")
    private WebElement emergencyChangePIRReason;

    public ChangeTaskPage()
    {
        PageFactory.initElements(driver,this);
    }

    protected void WaitForPageLoad()
    {
        SwitchToDefaultIFrame();
        WaitForElement(changeTaskHeader);
        SwitchToDefault();
    }

    public void CloseTask() {

        SwitchToIFrame();
        click(closeTask);
        WaitForPageRefresh();
        WaitForElement(closedCompleteState);
        SwitchToDefault();
    }


    public void verifyPIRReason_EmergencyChange() {
        WaitForPageLoad();
        SwitchToDefaultIFrame();
        AssertDisplayed(emergencyChangePIRReason);
        //AssertElementValue(PIRReason,"emeregency_change");
        SwitchToDefault();
    }


    public void ChangeClosedStatus(String status) {

        SwitchToDefaultIFrame();
        WaitForElement(closedStatus);
        selectValue(closedStatus,status);
        SwitchToDefault();
    }

}

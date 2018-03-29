package pageObjects;

import Utilities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CatalogTaskPage extends Util {

    @FindBy(how = How.XPATH, using = ".//h2//div[text()='Catalog Task']")
    private WebElement catalogTaskHeader;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'SLAs')][contains(text(),'(1)')]")
    private WebElement tasksTab;

    @FindBy(how = How.XPATH, using = ".//table[@id='sc_task.task_sla.task_table']/tbody/tr[1]")
    private WebElement taskSLA;

    @FindBy(how = How.XPATH, using = ".//span[@class='tab_caption_text'][contains(text(),'Variables')]")
    private WebElement variablesTab;

    @FindBy(how = How.ID, using = "sys_display.sc_task.assigned_to")
    private WebElement assignedToEdit;

    @FindBy(how = How.ID, using = "sysverb_update_and_stay_save")
    private WebElement save;

    @FindBy(how = How.ID, using = "activity-stream-work_notes-textarea")
    private WebElement workNotes;

    @FindBy(how = How.ID, using = "activity-stream-comments-textarea")
    private WebElement customerNotes;

    @FindBy(how = How.ID, using = "ctask_close_complete")
    private WebElement closeTask;

    @FindBy(how = How.XPATH, using = ".//table[@id='sc_task.u_task_variable.u_catalog_task_table']/tbody/tr[1]/td[2]")
    private WebElement firstAssetNumber;

    @FindBy(how = How.XPATH, using = ".//table[@id='sc_task.u_task_variable.u_catalog_task_table']/tbody/tr[2]/td[2]")
    private WebElement firstModelNumber;

    @FindBy(how = How.XPATH, using = ".//table[@id='sc_task.u_task_variable.u_catalog_task_table']/tbody/tr[3]/td[2]")
    private WebElement firstSerialNumber;

    @FindBy(how = How.ID, using = "u_task_variable.u_value")
    private WebElement variableValue;

    @FindBy(how = How.ID, using = "sysverb_update")
    private WebElement update;
//
//    @FindBy(how = How.XPATH, using = "sysverb_update_and_stay_save")
//    private WebElement save;


    public void WaitForPageLoad()
    {
        SwitchToDefaultIFrame();
        WaitForElement(catalogTaskHeader);
        SwitchToDefault();
    }

    public CatalogTaskPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void verifyTaskSLA1Created()
    {
        SwitchToDefaultIFrame();
        ScrollPage(assignedToEdit,2);
        selectTab(tasksTab);
        AssertDisplayed(taskSLA);
        SwitchToDefault();
    }


    public void AssignToMe(String user)
    {
        SwitchToDefaultIFrame();
        sendKeys_Select(assignedToEdit,user);
        SwitchToDefault();
    }



    public void AddWorkNotes(String notes)
    {
        SwitchToDefaultIFrame();
        ScrollPage(assignedToEdit,1);
        sendKeys(workNotes,notes);
        SwitchToDefault();
    }


    public void AddCustomerNotes(String notes)
    {
        SwitchToDefaultIFrame();
        sendKeys(customerNotes,notes);
        click(save);
        WaitForPageRefresh();
        ScrollPage(assignedToEdit,1);
        SwitchToDefault();
    }


    public void AddVariableData(String assetNumber, String modelNumber, String serialNumber)
    {
        SwitchToDefaultIFrame();
        ScrollPage(customerNotes,1);
        selectTab(variablesTab);
        click(firstAssetNumber);
        SwitchToDefaultIFrame();
        sendKeys(variableValue,assetNumber);
        click(update);
        WaitForPageRefresh();
        WaitForElement(assignedToEdit);

//        SwitchToDefaultIFrame();
        ScrollPage(assignedToEdit,3);
        click(firstModelNumber);
        SwitchToDefaultIFrame();
        sendKeys(variableValue,modelNumber);
        click(update);
        WaitForPageRefresh();

//        SwitchToDefaultIFrame();
        WaitForElement(assignedToEdit);
        ScrollPage(assignedToEdit,3);
        click(firstSerialNumber);
        SwitchToDefaultIFrame();
        sendKeys(variableValue,serialNumber);
        click(update);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    public void CloseTask(String notes)
    {
        AddWorkNotes(notes);
        SwitchToDefaultIFrame();
        click(closeTask);
        WaitForPageRefresh();
        Alert_OK();
        WaitForPageRefresh();
        SwitchToDefault();
    }


}


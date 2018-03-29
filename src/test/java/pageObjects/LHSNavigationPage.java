package pageObjects;

import Utilities.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

public class LHSNavigationPage extends Util {

    @FindBy(how = How.ID, using = "filter")
    private WebElement filter;

    @FindBy(how = How.XPATH, using = ".//*[text()='Create New']")
    private WebElement CreateNew;

    @FindBy(how = How.XPATH, using = ".//a[@title='Create New'][contains(@href,'incident')]")
    private WebElement createNewIncident;

    @FindBy(how = How.XPATH, using = ".//a[@title='Create New.'][contains(@href,'problem')]")
    private WebElement createNewProblem;

    @FindBy(how = How.XPATH, using = ".//a[contains(@title,' Create New')][contains(@href,'change')]")
    private WebElement createNewChange;

    @FindBy(how = How.XPATH, using = ".//div[text()='New record']")
    private WebElement newRecord;

    @FindBy(how = How.XPATH, using = ".//*[text()='My Assignment Groups Open Incidents']")
    private WebElement myAssignmentGroupOpenIncidents;

    @FindBy(how = How.XPATH, using = ".//*[text()='My Owning Groups Open Incidents']")
    private WebElement myOwningGroupOpenIncidents;

    @FindBy(how = How.XPATH, using = ".//*[text()='My Owning Groups Resolved Incidents']")
    private WebElement myOwningGroupResolvedIncidents;

    @FindBy(how = How.XPATH, using = ".//a/span[text()='Change']/../..//a[contains(@title,'My Approvals')]")
    private WebElement change_MyApprovals;

    @FindBy(how = How.XPATH, using = ".//*[text()='Emails']")
    private WebElement emails;

    @FindBy(how = How.XPATH, using = ".//*[text()='Items']")
    private WebElement items;

    @FindBy(how = How.XPATH, using = ".//*[text()='My Groups PIU Tasks']")
    private WebElement myGroupPIUTasks;

    @FindBy(how = How.XPATH, using = ".//*[text()='My Group Work']")
    private WebElement myGroupWork;

    public LHSNavigationPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void CreateNewIncident() {
        setFilter("Create New");
        click(createNewIncident);
//        PageLoadWait();
        SwitchToIFrame();
        WaitForElement(newRecord);
        SwitchToDefault();
    }

    public void CreateNewProblem() {
        setFilter("Problem");
        click(createNewProblem);
        WaitForPageRefresh();
        SwitchToIFrame();
        WaitForElement(newRecord);
        SwitchToDefault();
    }


    public void CreateNewChange() {
        setFilter("Change");
        click(createNewChange);
        SwitchToIFrame();
        WaitForElement(newRecord);
        WaitForPageRefresh();
        SwitchToDefault();
    }

    public void MyAssignmentGroupOpenIncidents()
    {
        click(myAssignmentGroupOpenIncidents);
        WaitForIncidentsListPage();
    }

    public void MyOwningGroupOpenIncidents()
    {
        click(myOwningGroupOpenIncidents);
        WaitForIncidentsListPage();
    }

    public void MyOwningGroupResolvedIncidents()
    {
        click(myOwningGroupResolvedIncidents);
        WaitForIncidentsListPage();
    }

    public void setFilter(String filterText)
    {
        click(filter);
        sendKeysVerify(filter, filterText);
        filter.sendKeys(Keys.ENTER);
    }

    public void openEmails()
    {
        setFilter("Emails");
        click(emails);
        SwitchToIFrame();
        WaitForElementToBeClicable(new EmailsPage().filterColumn);
        SwitchToDefault();
    }

    public void openServiceCatalogItems()
    {
        setFilter("Items");
        click(items);
        SwitchToIFrame();
        new RequestedItemsPage().WaitForPageLoad();
        SwitchToDefault();
    }


    public void openMyGroupWork()
    {
        setFilter("My Group Work");
        click(myGroupWork);
        SwitchToIFrame();
        new CatalogTasksPage().WaitForPageLoad();
        SwitchToDefault();
    }


    public void Change_MyApprovals() {
        setFilter("Change");
        click(change_MyApprovals);
        WaitForPageRefresh();
        SwitchToDefault();
    }


    private void WaitForIncidentsListPage()
    {
        SwitchToIFrame();
        WaitForElement(new IncidentsListPage().incidentsHeader);
        SwitchToDefault();
    }


    public void MyGroupsPIUTasks()
    {
        setFilter("PIU");
        click(myGroupPIUTasks);
        new PIUListPage().WaitForPageLoad();
    }
}

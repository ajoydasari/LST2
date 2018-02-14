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

    @FindBy(how = How.XPATH, using = ".//div[text()='New record']")
    private WebElement newRecord;

    @FindBy(how = How.XPATH, using = ".//*[text()='My Assignment Groups Open Incidents']")
    private WebElement myAssignmentGroupOpenIncidents;

    @FindBy(how = How.XPATH, using = ".//*[text()='My Owning Groups Open Incidents']")
    private WebElement myOwningGroupOpenIncidents;

    @FindBy(how = How.XPATH, using = ".//*[text()='My Owning Groups Resolved Incidents']")
    private WebElement myOwningGroupResolvedIncidents;

    @FindBy(how = How.XPATH, using = ".//*[text()='Emails']")
    private WebElement emails;


    public LHSNavigationPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void CreateNewIncident() {
        //click(CreateNew);
        setFilter("Create New");
        click(createNewIncident);
        SwitchToIFrame();
        WaitForElement(newRecord);
        SwitchToDefault();
    }

    public void CreateNewProblem() {
        //click(CreateNew);
        setFilter("Create New");
        click(createNewIncident);
        SwitchToIFrame();
        WaitForElement(newRecord);
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
        filter.sendKeys(filterText);
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

    private void WaitForIncidentsListPage()
    {
        SwitchToIFrame();
        WaitForElement(new IncidentsListPage().incidentsHeader);
        SwitchToDefault();
    }
}

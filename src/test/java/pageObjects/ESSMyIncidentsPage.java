package pageObjects;

import Utilities.Util;
import dataObjects.OrderSomethingData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ESSMyIncidentsPage extends Util {

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]")
    private WebElement incidentsTable;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]")
    private WebElement firstOpenIncident;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='State']")
    private WebElement firstOpenIncidentState;

    @FindBy(how = How.XPATH, using = ".//table/tbody/tr[1]/td[@data-th='Closure code']")
    private WebElement firstClosedIncidentState;

    @FindBy(how = How.NAME, using = "searchInc")
    private WebElement searchDropdown;

    @FindBy(how = How.XPATH, using = ".//select/following-sibling::input")
    private WebElement searchEdit;

    @FindBy(how = How.XPATH, using = ".//input[@value='Search']")
    private WebElement searchBtn;

    @FindBy(how = How.XPATH, using = ".//input[@value='Clear Search']")
    private WebElement clearSearch;

    public void WaitForPageLoad()
    {
        WaitForElement(incidentsTable);
    }

    public ESSMyIncidentsPage()
    {
        PageFactory.initElements(driver,this);
    }


    public void SearchIncident(String searchText)
    {
        selectValue(searchDropdown,"Number");
        sendKeysVerify(searchEdit, searchText);
        click(searchBtn);
        WaitForPageRefresh();
    }


    public void ClearSearch()
    {
        click(clearSearch);
        WaitForPageRefresh();
    }

    public void SelectFirstIncident()
    {
        click(firstOpenIncident);
        WaitForPageRefresh();
    }


    public void validateState(String state)
    {
        Log("Verifying Incident State : '" + state + "'");
        if(state.contains("Closed"))
            AssertElementText(firstClosedIncidentState, state);
        else
            AssertElementText(firstOpenIncidentState, state);
    }

}

